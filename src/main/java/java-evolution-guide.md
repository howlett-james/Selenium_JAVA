# Java Evolution: Old vs New, With Code

Each section shows: the concept, the version it arrived in, how you used to write it, and how you write it now.

---

## 1. Lambdas (Java 8)

**Before — anonymous inner class:**
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running!");
    }
};

Comparator<String> byLength = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return Integer.compare(a.length(), b.length());
    }
};
```

**After — lambda:**
```java
Runnable r = () -> System.out.println("Running!");

Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());
// or even shorter, using a method reference:
Comparator<String> byLength2 = Comparator.comparingInt(String::length);
```

---

## 2. Streams API (Java 8)

**Before — manual loops:**
```java
List<String> names = Arrays.asList("Anu", "Bala", "Chitra", "Dev");
List<String> longNames = new ArrayList<>();
for (String name : names) {
    if (name.length() > 3) {
        longNames.add(name.toUpperCase());
    }
}
```

**After — streams:**
```java
List<String> names = List.of("Anu", "Bala", "Chitra", "Dev");
List<String> longNames = names.stream()
        .filter(name -> name.length() > 3)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
```

---

## 3. Optional (Java 8)

**Before — null checks everywhere:**
```java
String city = getCity();
if (city != null) {
    System.out.println(city.toUpperCase());
} else {
    System.out.println("UNKNOWN");
}
```

**After — Optional:**
```java
Optional<String> city = getCityOptional();
System.out.println(city.map(String::toUpperCase).orElse("UNKNOWN"));
```

---

## 4. Date/Time API (Java 8)

**Before — java.util.Date / Calendar (mutable, confusing, not thread-safe):**
```java
Date now = new Date();
Calendar cal = Calendar.getInstance();
cal.set(2025, Calendar.JANUARY, 15);
Date someDate = cal.getTime();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String formatted = sdf.format(now); // SimpleDateFormat is not thread-safe!
```

**After — java.time (immutable, clear):**
```java
LocalDate now = LocalDate.now();
LocalDate someDate = LocalDate.of(2025, Month.JANUARY, 15);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String formatted = now.format(formatter); // thread-safe
```

---

## 5. Default Methods in Interfaces (Java 8)

**Before — every implementer had to write the method, or you needed an abstract class:**
```java
interface Vehicle {
    void start();
    // No way to add a new method without breaking every existing implementation
}
```

**After — interface can supply a default body:**
```java
interface Vehicle {
    void start();

    default void honk() {
        System.out.println("Beep beep!");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting...");
    }
    // honk() is inherited for free, no need to implement it
}
```

---

## 6. Module System / JPMS (Java 9)

**Before — everything on one flat classpath, no real encapsulation between JARs:**
```java
// No module-info.java existed. Any public class in any JAR
// was accessible from anywhere on the classpath.
```

**After — explicit modules:**
```java
// module-info.java
module com.example.myapp {
    requires java.sql;
    exports com.example.myapp.api;   // only this package is visible outside
    // everything else stays internal/private to the module
}
```

---

## 7. `var` — Local Type Inference (Java 10)

**Before — explicit type required:**
```java
Map<String, List<Integer>> scoresByPlayer = new HashMap<String, List<Integer>>();
ArrayList<String> names = new ArrayList<String>();
```

**After — compiler infers the type:**
```java
var scoresByPlayer = new HashMap<String, List<Integer>>();
var names = new ArrayList<String>();
// var is still strongly typed — it's inferred at compile time, not "dynamic"
```

---

## 8. New HTTP Client (Java 11)

**Before — clunky HttpURLConnection:**
```java
URL url = new URL("https://api.example.com/data");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
StringBuilder response = new StringBuilder();
String line;
while ((line = reader.readLine()) != null) {
    response.append(line);
}
reader.close();
```

**After — java.net.http.HttpClient:**
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.example.com/data"))
        .GET()
        .build();

HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());

// or fully async:
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
```

---

## 9. Switch Expressions (Java 12-14)

**Before — classic switch statement (fall-through risk, no return value):**
```java
int day = 3;
String dayType;
switch (day) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        dayType = "Weekday";
        break;
    case 6:
    case 7:
        dayType = "Weekend";
        break;
    default:
        dayType = "Invalid";
        break;
}
```

**After — switch expression with arrow syntax:**
```java
int day = 3;
String dayType = switch (day) {
    case 1, 2, 3, 4, 5 -> "Weekday";
    case 6, 7 -> "Weekend";
    default -> "Invalid";
};
```

---

## 10. Text Blocks (Java 15)

**Before — manual string concatenation for multi-line text:**
```java
String json = "{\n" +
              "  \"name\": \"Anu\",\n" +
              "  \"city\": \"Chennai\"\n" +
              "}\n";
```

**After — text blocks:**
```java
String json = """
        {
          "name": "Anu",
          "city": "Chennai"
        }
        """;
```

---

## 11. Records (Java 14 preview -> 16 final)

**Before — a "data class" required tons of boilerplate:**
```java
public final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point[x=" + x + ", y=" + y + "]";
    }
}
```

**After — one line:**
```java
public record Point(int x, int y) { }
// equals(), hashCode(), toString(), and accessor methods x() / y() are generated automatically
```

---

## 12. Pattern Matching for `instanceof` (Java 16)

**Before — explicit cast after the check:**
```java
Object obj = "Hello";
if (obj instanceof String) {
    String s = (String) obj;   // separate cast needed
    System.out.println(s.length());
}
```

**After — the cast happens inline:**
```java
Object obj = "Hello";
if (obj instanceof String s) {   // 's' is auto-cast and in scope below
    System.out.println(s.length());
}
```

---

## 13. Sealed Classes (Java 17)

**Before — any class could extend any non-final class, no way to restrict the hierarchy:**
```java
public abstract class Shape { }
// Anyone, anywhere, could write "class Hexagon extends Shape {}"
// the compiler has no idea about the full set of subtypes
```

**After — sealed restricts who can extend it:**
```java
public sealed abstract class Shape permits Circle, Square, Triangle { }

public final class Circle extends Shape { public double radius; }
public final class Square extends Shape { public double side; }
public final class Triangle extends Shape { public double base, height; }
// Compiler now knows this is the COMPLETE list of subtypes
// (this enables exhaustive switch checks below)
```

---

## 14. Pattern Matching for `switch` + Record Patterns (Java 21)

**Before — long if/else chains with manual casting:**
```java
double area;
if (shape instanceof Circle) {
    Circle c = (Circle) shape;
    area = Math.PI * c.radius * c.radius;
} else if (shape instanceof Square) {
    Square s = (Square) shape;
    area = s.side * s.side;
} else if (shape instanceof Triangle) {
    Triangle t = (Triangle) shape;
    area = 0.5 * t.base * t.height;
} else {
    throw new IllegalStateException("Unknown shape");
}
```

**After — pattern matching switch, exhaustive (works great with sealed + records):**
```java
double area = switch (shape) {
    case Circle c -> Math.PI * c.radius() * c.radius();
    case Square s -> s.side() * s.side();
    case Triangle t -> 0.5 * t.base() * t.height();
    // no "default" needed: compiler knows Shape is sealed with exactly these 3 subtypes
};

// Record patterns can even destructure inline:
record Point(int x, int y) {}
record Line(Point start, Point end) {}

Object obj = new Line(new Point(0, 0), new Point(3, 4));
if (obj instanceof Line(Point(var x1, var y1), Point(var x2, var y2))) {
    System.out.println("From (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
}
```

---

## 15. Virtual Threads (Java 19 preview -> 21 final)

**Before — platform threads are heavy; thread pools used to manage concurrency carefully:**
```java
ExecutorService executor = Executors.newFixedThreadPool(200); // limited, OS threads are expensive
for (int i = 0; i < 10_000; i++) {
    int taskId = i;
    executor.submit(() -> {
        // each platform thread uses ~1MB of stack; 10,000 threads would crash most systems
        System.out.println("Task " + taskId + " running on " + Thread.currentThread());
    });
}
executor.shutdown();
```

**After — virtual threads are cheap, you can spawn thousands/millions:**
```java
try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 10_000; i++) {
        int taskId = i;
        executor.submit(() -> {
            System.out.println("Task " + taskId + " running on " + Thread.currentThread());
        });
    }
} // executor auto-closes and waits for tasks (try-with-resources)
```

---

## 16. Sequenced Collections (Java 21)

**Before — getting first/last element was clunky and inconsistent across collection types:**
```java
List<String> list = new ArrayList<>(List.of("a", "b", "c"));
String first = list.get(0);
String last = list.get(list.size() - 1);

LinkedHashSet<String> set = new LinkedHashSet<>(List.of("a", "b", "c"));
String firstOfSet = set.iterator().next(); // awkward, no direct "first" method
```

**After — unified methods via the SequencedCollection interface:**
```java
List<String> list = new ArrayList<>(List.of("a", "b", "c"));
String first = list.getFirst();
String last = list.getLast();
List<String> reversed = list.reversed();

LinkedHashSet<String> set = new LinkedHashSet<>(List.of("a", "b", "c"));
String firstOfSet = set.getFirst(); // same consistent API now
```

---

## 17. Structured Concurrency (Java 21+ preview)

**Before — manually tracking and joining multiple async tasks, manual error handling:**
```java
ExecutorService executor = Executors.newFixedThreadPool(2);
Future<String> userFuture = executor.submit(() -> fetchUser());
Future<String> orderFuture = executor.submit(() -> fetchOrder());
try {
    String user = userFuture.get();
    String order = orderFuture.get();
    System.out.println(user + " " + order);
} catch (Exception e) {
    userFuture.cancel(true);
    orderFuture.cancel(true);
    throw e;
}
```

**After — structured concurrency treats related tasks as one unit (preview feature, needs --enable-preview):**
```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Subtask<String> user = scope.fork(() -> fetchUser());
    Subtask<String> order = scope.fork(() -> fetchOrder());

    scope.join();           // waits for both
    scope.throwIfFailed();  // propagates first failure, auto-cancels the other task

    System.out.println(user.get() + " " + order.get());
}
```

---

## Quick takeaway as a learner

You don't need to write code the "old" way — it's shown only so you recognize it when you see it in older codebases or tutorials. For new code, default to: lambdas + streams, `var` where it's clear, records for data carriers, pattern-matching switch, and `java.time`. Pick Java 17 or 21 to practice with, since both give you nearly all of the modern syntax above.
