package jump.to.java.interfacestudy;

public class Lion extends Animal implements Predator, Barkable {
    @Override
    public String getFood() {
        return "banana";
    }

    @Override
    public void bark() {
        System.out.println(":::Lion 으르렁");
    }
}
