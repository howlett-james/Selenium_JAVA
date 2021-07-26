package CoreJAVA.episode_8;

public class BMW extends Car{ //"Has-a relationship"
    //when method is present in parent class as well as in child class with the same name and same number of arguments,
    // is called methods overriding

    public void start() {
        System.out.println("BMW -- Start");
    }
    public void theftsafety(){
        System.out.println("BMW -- Theft Safety");
    }
}
