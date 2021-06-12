package ifsp.es4a4.exercicios.bdd;

public class Hello {

    private final String greeting;

    public Hello(String greeting){
        this.greeting = greeting;
    }

    public String sayHi(){
        return greeting + " mundo";
    }
}
