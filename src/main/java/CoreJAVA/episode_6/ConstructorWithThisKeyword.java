package CoreJAVA.episode_6;

public class ConstructorWithThisKeyword {
    int a; //create a class attribute

    //this keywords is used to refer the class attribute when local and class attributes are same
    String Name;
    int Age;
    String Dept;
    int ID;
    String DOB;
    //Create a Class Constructor without arguments
    public ConstructorWithThisKeyword(){
        a =10; //set the initial value for the class attribute x
    }
    //Create a Class Constructor with arguments
    public ConstructorWithThisKeyword(String Name, int Age, String Dept, int ID, String dob){
        this.Name = Name;
        this.Age = Age;
        this.Dept = Dept;
        this.ID = ID;
        DOB = dob;
    }
    public static void main(String[] args) {
        ConstructorWithThisKeyword obj1 = new ConstructorWithThisKeyword("Yokesh",22, "QA",2108,"21-08-1999");
        ConstructorWithThisKeyword obj2 = new ConstructorWithThisKeyword("James Howlett",22,"QA", 2108,"21-08-1999");
        //Print the values
        System.out.println(obj1.Name+ " "+obj1.Age+ " "+obj1.Dept+ " "+obj1.ID);
        System.out.println(obj2.Name+ " "+obj2.Age+" "+obj2.Dept+ " "+obj2.ID);
        ConstructorWithThisKeyword myobj = new ConstructorWithThisKeyword();
        System.out.println(myobj.a);
    }
}