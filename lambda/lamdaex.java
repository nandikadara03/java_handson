package lambda;


public class lamdaex {
    public static void main(String[] args) {
        Sayableimp sayable = new Sayableimp();
        sayable.say();
// using lamda
        Sayinterface s1 = () -> {System.out.println("you're saying something");};
        s1.say();
    }
}
