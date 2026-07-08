# Automation Framework — Interview Explanation Guide

---

## 1. Folder Structure

"The project follows a standard Maven/Gradle layout.

- `src/main/java` — all reusable framework code: pages, utilities, helpers, constants, element services
- `src/test/java` — actual test scripts (`FlowTest/`) and listeners
- `src/test/resources` — `testng.xml` and `userdata.json`
- `src/main/resources/assets` — test documents and images used during test execution
- `reports/` — generated HTML, Excel reports and failure screenshots at the root level"

```
Web_LOS_Automation/
├── src/
│   ├── main/java/
│   │   ├── base/              → DriverFactory (WebDriver management)
│   │   ├── constants/         → FrameworkConstants, ErrorMessages
│   │   ├── elementServices/   → SelectService, PicklistService, UploadService
│   │   ├── enums/             → Lead enums, UserGroupId
│   │   ├── exceptions/        → Custom exceptions
│   │   ├── helper/            → LeadDataStore, GenericDbHelper, CaptchaHelper, etc.
│   │   ├── pages/             → Page Object classes (LoginPage, LeadPage, etc.)
│   │   └── utils/             → Waits, ScreenshotUtil, GenerateFakeData, JsonReader, etc.
│   └── test/java/
│       ├── listeners/         → TestListeners, ExcelReportListener, DependencyRemover
│       └── TestScripts/
│           └── FlowTest/      → BaseTest + all test classes (LeadTest, ApplicationTest, etc.)
├── reports/                   → ExtentReport.html, screenshots/, Excel reports
├── build.gradle               → Build config + dynamic XML generation
└── testng.xml                 → Static TestNG suite config
```

---

## 2. Design Patterns

"This framework uses multiple design patterns — not just one. Here's each one with where it's used:"

---

### 2.1 Page Object Model (POM)

"Every screen in the application has its own class under `pages/`. Locators are private, actions are public methods. If a locator changes, you fix it in one place — tests don't break."

```java
public class LoginPage {
    private final By usernameField = By.cssSelector("input#txtUserName");
    private final By loginButton   = By.cssSelector("input#btnSubmit");

    public LoginPage enterUsername(String uname) {
        Waits.waitForVisibility(driver, usernameField).sendKeys(uname);
        return this;
    }
    public DashboardPage clickLogin() {
        Waits.waitForClickability(driver, loginButton).click();
        return new DashboardPage();
    }
}
```

---

### 2.2 Fluent Interface / Method Chaining

"Page methods return either `this` or a new page object, so test code reads like a sentence."

```java
loginPage.enterUsername(FrameworkConstants.salesUser)
         .enterPassword(FrameworkConstants.PASSWORD)
         .clickLogin()
         .pickRegion()
         .createNewLead()
         .completeLeadBasicDetails("HL")
         .completeLeadEntry("INDIVIDUAL", "S", 1)
         .submit();
```

---

### 2.3 Factory Pattern — `DriverFactory`

"`DriverFactory.initDriver(browser, headless)` decides which WebDriver to create based on the browser name. The caller doesn't know how Chrome/Firefox/Edge is constructed — it just asks the factory."

```java
WebDriver webDriver = switch (browser.toLowerCase()) {
    case "chrome"  -> new ChromeDriver(getChromeOptions(headless));
    case "firefox" -> new FirefoxDriver(getFirefoxOptions(headless));
    case "edge"    -> new EdgeDriver();
    default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
};
```

---

### 2.4 Singleton-like Pattern (ThreadLocal) — `DriverFactory`

"Only one driver instance exists per thread. `getDriver()` always returns the same instance for that thread — no new driver is created unless `initDriver()` is called again. This makes it safe for parallel execution."

```java
private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

public static WebDriver getDriver() {
    return Objects.requireNonNull(driver.get(), "Driver not initialized. Call initDriver() first.");
}
```

---

### 2.5 Facade Pattern — `elementServices/` package

"`SelectService`, `PicklistService`, and `UploadService` hide the complexity of Selenium interactions behind simple method calls. Page classes don't deal with `Select`, iframe switching, or JS clicks directly — they just call the service."

```java
// Without Facade — messy in page class
new Select(driver.findElement(locator)).selectByValue(value);

// With Facade — clean in page class
sService.selectByValue(locator, value);
```

---

### 2.6 Data Object Pattern — `LeadDataStore`

"A static class that acts as an in-memory shared data store between test stages. Holds `leadID`, `assignedUser`, `currentScreenName` etc. and passes them across test methods without return values or constructor injection. Also supports flow-specific storage for multi-flow execution."

```java
// Stage 1 stores the LeadID
LeadDataStore.setLeadID(leadID);

// Stage 2 reads it
String leadID = LeadDataStore.getLeadID();

// Flow-specific (multi-flow)
LeadDataStore.setLeadID("HL_Flow", leadID);
String leadID = LeadDataStore.getLeadID("HL_Flow");
```

---

### 2.7 Template Method Pattern — `BaseTest`

"`BaseTest` defines the skeleton of test setup and teardown in `@BeforeMethod` and `@AfterMethod`. Every test class extends `BaseTest` and inherits this behavior. Individual test classes only define the test body — the setup/teardown structure is fixed in the base class."

```java
// BaseTest defines the skeleton — fixed structure
@BeforeMethod public void setUp()          { /* init driver, open URL */ }
@AfterMethod  public void tearDown()       { /* quit driver */ }

// LeadTest just writes the test body
public class LeadTest extends BaseTest {
    @Test public void leadTestForHL() { /* only test logic here */ }
}
```

---

### 2.8 Observer Pattern — Listeners

"`TestListeners`, `ExcelReportListener`, and `DependencyRemover` all implement TestNG listener interfaces. TestNG notifies them on events like `onTestStart`, `onTestFailure`, `onFinish` — they react without the test code knowing about them at all."

```java
// TestNG fires events → listeners react
public class TestListeners implements ITestListener {
    public void onTestFailure(ITestResult result) { /* capture screenshot, log */ }
    public void onFinish(ITestContext context)    { /* flush report */ }
}

public class ExcelReportListener implements ITestListener {
    public void onFinish(ITestContext context)    { /* write .xlsx file */ }
}
```

---

### 2.9 Strategy Pattern — `SelectService` + `PicklistService`

"Different selection strategies are applied based on context — select by value, by text, by index, or randomly. The page class picks the right strategy without changing its own logic."

```java
sService.selectByValue(locator, "MALE");   // specific value
sService.selectByValue(locator);           // random value
sService.selectByText(locator, "Yes");     // by visible text
sService.selectByIndex(locator, 1);        // by index
```

---

### 2.10 Screen Router Pattern — `TechnicalScreen` and `LegalScreen`

"These are not full page objects — they act as entry points that return the correct sub-page based on what the test needs. Instead of directly instantiating `TechnicalTriggerancePage`, the test goes through `TechnicalScreen.asTriggerance()`. This keeps navigation clean and centralised."

```java
// TechnicalScreen acts as a router
public class TechnicalScreen {
    public TechnicalTriggerancePage      asTriggerance()    { return new TechnicalTriggerancePage(); }
    public TechnicalValuationPage        asValuation()      { return new TechnicalValuationPage(); }
    public TechnicalValuationApprovalPage asValuationApprov() { return new TechnicalValuationApprovalPage(); }
}

// Same for LegalScreen
public class LegalScreen {
    public LegalTriggerancePage asTriggerance() { return new LegalTriggerancePage(); }
    public LegalOpinionPage     asOpinion()     { return new LegalOpinionPage(); }
}
```

---

### 2.11 Builder-like Pattern — `LeadPage.completeLeadEntry()`

"`completeLeadEntry()` orchestrates multiple sub-steps in a fixed sequence — filling customer details, loan eligibility, and property details — building up the complete form state step by step before the final `submit()`."

```java
public LeadPage completeLeadEntry(String entityType, String cusType, int n) {
    fillCustomerDetails(entityType, cusType);  // step 1
    fillLoanEligibility();                     // step 2
    addProperty(n);                            // step 3
    return this;                               // ready for submit()
}
```

---

### 2.12 Custom Exception Pattern — `exceptions/` package

"`ElementNotFoundException` and `PageLoadException` extend `RuntimeException` to give meaningful, domain-specific error messages instead of generic Selenium exceptions — makes debugging faster and error messages clearer."

```java
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class PageLoadException extends RuntimeException {
    public PageLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

---

### Quick Pattern Summary

| Pattern | Where Used |
|---|---|
| Page Object Model | `pages/` package — all page classes |
| Fluent Interface | All page methods — method chaining |
| Factory | `DriverFactory.initDriver()` — browser creation |
| Singleton (ThreadLocal) | `DriverFactory.getDriver()` — one driver per thread |
| Facade | `SelectService`, `PicklistService`, `UploadService` |
| Data Object | `LeadDataStore` — shared state between stages |
| Template Method | `BaseTest` — setup/teardown skeleton |
| Observer | `TestListeners`, `ExcelReportListener`, `DependencyRemover` |
| Strategy | `SelectService` — multiple selection strategies |
| Screen Router | `TechnicalScreen`, `LegalScreen` — sub-page routing |
| Builder-like | `LeadPage.completeLeadEntry()` — step-by-step form filling |
| Custom Exception | `ElementNotFoundException`, `PageLoadException` |

---

## 3. Driver Initialization

"Driver is managed in `DriverFactory` using a `ThreadLocal<WebDriver>`. This means each thread gets its own driver instance — important for parallel execution.

- `initDriver(browser, headless)` uses **WebDriverManager** to auto-download the correct driver binary — no manual chromedriver setup needed
- Supports Chrome, Firefox, and Edge via a switch expression
- `BaseTest.setUp()` (`@BeforeMethod`) calls `initDriver()` before every test
- `BaseTest.tearDown()` (`@AfterMethod`) calls `quitDriver()` after every test"

```java
// ThreadLocal ensures each thread has its own driver
private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

public static WebDriver initDriver(String browser, boolean headless) {
    WebDriver webDriver = switch (browser.toLowerCase().trim()) {
        case "chrome" -> { WebDriverManager.chromedriver().setup(); yield new ChromeDriver(getChromeOptions(headless)); }
        case "firefox" -> { WebDriverManager.firefoxdriver().setup(); yield new FirefoxDriver(getFirefoxOptions(headless)); }
        case "edge" -> { WebDriverManager.edgedriver().setup(); yield new EdgeDriver(); }
        default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
    };
    driver.set(webDriver);
    return webDriver;
}
```

---

## 4. Page Object Model

"Every screen in the application has a dedicated Page class under `pages/`.

- **Locators** are defined as `private final By` fields at the top of each class
- **Actions** are public methods — each method does one thing
- Pages return other page objects to enable method chaining
- The driver is fetched from `DriverFactory.getDriver()` inside the constructor — no driver passing needed

For example, `LoginPage.clickLogin()` returns a `DashboardPage`. If a locator changes, you fix it in one class only — tests don't break."

```java
public class LoginPage {
    private final WebDriver driver;

    // Locators defined once
    private final By usernameField = By.cssSelector("input#txtUserName");
    private final By loginButton   = By.cssSelector("input#btnSubmit");

    public LoginPage() {
        this.driver = DriverFactory.getDriver(); // fetched from ThreadLocal
    }

    public LoginPage enterUsername(String uname) {
        Waits.waitForVisibility(driver, usernameField).sendKeys(uname);
        return this; // enables chaining
    }

    public DashboardPage clickLogin() {
        Waits.waitForClickability(driver, loginButton).click();
        return new DashboardPage(); // returns next page
    }
}
```

---

## 5. Utility Classes

"We have several utility/helper classes that keep the framework clean and reusable:

| Class | Purpose |
|---|---|
| `Waits` | All WebDriverWait logic — visibility, clickability, fluent waits, scroll-into-view, alert handling |
| `GenerateFakeData` | Generates random test data (names, DOB, company names) using JavaFaker |
| `ScreenshotUtil` | Captures screenshots on failure with timestamp, saves to `reports/screenshots/` |
| `JsonReader` | Reads test data from JSON files |
| `GenericDbHelper` | Runs SQL queries against SQL Server — returns single value or list of maps |
| `LeadDataStore` | Static in-memory store that passes data (LeadID, AssignedUser) between test stages |
| `CaptchaHelper` | Fetches CAPTCHA value directly from DB to bypass login CAPTCHA |
| `SelectService` | Wraps Selenium `Select` — supports select by value, text, index, or random |
| `PicklistService` | Handles iframe-based picklist popups — switches to frame, picks random or specific row |
| `UploadService` | Handles file upload via iframe modal |

Example — `GenericDbHelper` returns either a single value or a full table:"

```java
// Returns single value for COUNT(*) queries, or List<Map> for multi-row results
Object result = GenericDbHelper.executeQuery("SELECT TOP 1 Captcha FROM LoginCaptcha ORDER BY pkid DESC");
```

---

## 6. Configuration Management

"`FrameworkConstants` reads the `env` system property at runtime and switches URLs and DB connections accordingly. So the same code runs against different environments just by passing `-Penv=nestavia` or `-Penv=sit` in the Gradle command. No hardcoding — URL, timeout, credentials, DB server are all centralized here."

```java
public class FrameworkConstants {
    private static final String environment = System.getProperty("env", "nestavia");

    public static final String URL = getAppURL();
    public static final long   TIMEOUT = 30;
    public static final String PASSWORD = "Welcome@1";

    private static String getAppURL() {
        return "nestavia".equalsIgnoreCase(environment)
            ? "http://172.23.99.12/NESTAVIAZIVA/"
            : "http://172.23.99.20/NIVARALOS_SIT/";
    }

    private static String getDBServer() {
        return "nestavia".equalsIgnoreCase(environment)
            ? "172.23.99.16\\sql2022"
            : "172.23.100.16\\SQL2022_dev";
    }
}
```

"Switch environment at runtime — no code change needed:"

```cmd
.\gradlew.bat test -Penv=nestavia -Pbrowser=chrome
.\gradlew.bat test -Penv=sit      -Pbrowser=chrome
```

---

## 7. TestNG

"TestNG controls test execution order and lifecycle.

- Each test method has `@Test` with a `priority` and `groups`
  - HL_Flow tests: priorities 1–99
  - LAP_Flow tests: priorities 100–199
- `BaseTest` uses `@BeforeMethod` to initialize the driver and `@AfterMethod` to quit it
- If any test fails, `LeadDataStore.markSuiteFailed()` is called — all subsequent tests throw `SkipException` to prevent running later stages when an earlier stage failed
- `DependencyRemover` is a custom `IMethodInterceptor` that strips hardcoded `dependsOnMethods` and re-sorts tests by priority at runtime
- `preserve-order="true"` in `testng.xml` ensures tests run in the declared order"

```java
@BeforeMethod(alwaysRun = true)
public void setUp() {
    if (LeadDataStore.isSuiteFailed()) {
        throw new SkipException("Skipping — previous stage failed");
    }
    String browser = System.getProperty("browser", "chrome");
    boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
    DriverFactory.initDriver(browser, headless);
    DriverFactory.getDriver().get(FrameworkConstants.URL);
}

@AfterMethod(alwaysRun = true)
public void tearDown(ITestResult result) {
    DriverFactory.quitDriver();
}
```

---

## 8. Reporting

"We have three layers of reporting:

### ExtentReports
- `TestListeners` implements `ITestListener`
- `onStart` → initializes `ExtentSparkReporter` pointing to `reports/ExtentReport.html`
- `onTestStart` → creates a test node
- `onTestSuccess` → logs PASS
- `onTestFailure` → captures screenshot via `ScreenshotUtil`, attaches it to the report, logs the exception
- `onFinish` → flushes everything to the HTML file

### Excel Reports
- `ExcelReportListener` also implements `ITestListener`
- Collects test method name, class, status, start time, end time, duration for every test
- On suite finish, generates a timestamped `.xlsx` file using Apache POI
- Status cells are color-coded: green = PASS, orange = FAIL, yellow = SKIP

### Allure Reports
- Integrated via `allure-testng` dependency
- Run `.\gradlew.bat testWithAllure` then `.\gradlew.bat allureServe` to view in browser"

```java
// TestListeners — failure handling
@Override
public void onTestFailure(ITestResult result) {
    LeadDataStore.markSuiteFailed(); // stops subsequent tests
    WebDriver driver = (WebDriver) result.getInstance().getClass()
                           .getMethod("getDriver").invoke(result.getInstance());
    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
    extentTest.get().fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
}
```

---

## 9. Gradle

"Gradle is the build tool. `build.gradle` defines dependencies, the Java toolchain (JDK 23), and custom tasks.

The key feature is **dynamic TestNG XML generation**:
- When you pass `-Pflow=HL -PstopAt=ApplicationEntry`, Gradle generates `build/generated-testng.xml` on the fly with only the relevant test methods, then runs TestNG against it
- Without those parameters, it uses the static `src/test/resources/testng.xml`
- System properties like `browser`, `headless`, `env` are passed through to tests via `systemProperty`

Custom tasks available:"

| Task | Purpose |
|---|---|
| `.\gradlew.bat test` | Run tests using `testng.xml` |
| `.\gradlew.bat test -Pflow=HL -PstopAt=ApplicationEntry` | Generate XML and run only LeadEntry for HL |
| `.\gradlew.bat listStages` | Print all available stage names |
| `.\gradlew.bat validateStages -PstopAt=PropertyVisit` | Validate a stage name and show what will run |
| `.\gradlew.bat testWithAllure` | Run tests + generate Allure report |
| `.\gradlew.bat allureServe` | Serve Allure report in browser |
| `.\gradlew.bat clean test` | Clean build outputs and re-run |

```groovy
// build.gradle — dynamic XML generation
tasks.register('generateTestNGXml') {
    doLast {
        def flow   = project.findProperty('flow') ?: 'HL'
        def stopAt = project.findProperty('stopAt')
        def idx    = testStages.indexOf(stopAt)
        def activeStages = (idx == -1) ? testStages : testStages[0..<idx]
        // builds XML string with only the relevant <class> entries
        file("build/generated-testng.xml").text = xml
    }
}
```

---

## 10. How a Test Runs — Start to Finish

"Here is the complete flow for: `.\gradlew.bat test -Pflow=HL -PstopAt=ApplicationEntry -Pbrowser=chrome -Pheadless=false`"

```
Step 1 — Gradle
  ├── Sees -PstopAt is set
  ├── Runs generateTestNGXml task
  └── Creates build/generated-testng.xml with only leadTestForHL()

Step 2 — TestNG picks up generated XML
  └── TestListeners.onStart() → initializes ExtentReports

Step 3 — BaseTest.setUp() [@BeforeMethod]
  ├── Checks LeadDataStore.isSuiteFailed() → if true, throws SkipException
  ├── Reads browser="chrome", headless="false" from system properties
  ├── Calls DriverFactory.initDriver("chrome", false)
  │     └── WebDriverManager downloads chromedriver automatically
  │     └── ChromeDriver launched with incognito + no-password-save options
  └── driver.get(FrameworkConstants.URL) → opens the LOS application

Step 4 — TestListeners.onTestStart()
  └── Creates an ExtentTest node for this test method

Step 5 — LeadTest.leadTestForHL() runs
  ├── LoginPage.enterUsername().enterPassword().clickLogin() → lands on Dashboard
  ├── DashboardPage.pickRegion().createNewLead() → opens Lead Entry form
  ├── LeadPage.completeLeadBasicDetails("HL") → fills loan type
  ├── LeadPage.completeLeadEntry("INDIVIDUAL","S",1) → fills customer, income, property
  └── LeadPage.submit()
        ├── Clicks Submit button
        ├── Waits for success modal
        ├── Extracts LeadID from modal message
        └── LeadDataStore.setLeadID(leadID) → stores for next stage

Step 6 — Assertions
  ├── Assert leadMessage contains expected text
  ├── Assert leadID is not null
  └── Assert leadID is not empty

Step 7 — On Success: TestListeners.onTestSuccess()
  └── Logs PASS to ExtentReport

       On Failure: TestListeners.onTestFailure()
  ├── LeadDataStore.markSuiteFailed() → all future tests will be skipped
  ├── ScreenshotUtil.captureScreenshot() → saves PNG to reports/screenshots/
  └── Attaches screenshot + exception to ExtentReport

Step 8 — BaseTest.tearDown() [@AfterMethod]
  └── DriverFactory.quitDriver() → closes browser, removes from ThreadLocal

Step 9 — TestListeners.onFinish()
  ├── extent.flush() → writes ExtentReport.html
  └── ExcelReportListener.onFinish() → writes TestExecutionReport_<timestamp>.xlsx
```

---

## Quick Summary Table

| Topic | Key Class / File |
|---|---|
| Folder Structure | Standard Gradle layout — `main/` for framework, `test/` for scripts |
| Design Pattern | Page Object Model + Flow-based execution + Fluent interface |
| Driver Init | `DriverFactory` — ThreadLocal + WebDriverManager |
| Page Object Model | `pages/` package — locators as `By`, actions as methods, returns page objects |
| Utility Classes | `Waits`, `GenerateFakeData`, `ScreenshotUtil`, `GenericDbHelper`, `LeadDataStore` |
| Configuration | `FrameworkConstants` — env-based switching via system property |
| TestNG | Priority-based ordering, `@BeforeMethod`/`@AfterMethod`, SkipException on failure |
| Reporting | ExtentReports (HTML) + Apache POI (Excel) + Allure |
| Gradle | Dynamic TestNG XML generation, custom tasks, system property passing |
| Test Flow | Gradle → TestNG XML → BaseTest setup → Test runs → Listener captures result → Teardown |

---

*Last Updated: 2026 | Framework: Selenium 4.38 + TestNG 7.11 + Gradle 8.x + Java 23*
