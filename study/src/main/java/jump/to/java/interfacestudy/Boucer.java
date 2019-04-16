package jump.to.java.interfacestudy;

public class Boucer {

    private void barkAnimal(Barkable animal){
        animal.bark();
    }

    public static void main(String[] args){
        Boucer boucer = new Boucer();
        boucer.barkAnimal(new Tiger());
        boucer.barkAnimal(new Lion());

        // 하나의 객체에 여러개의 자료형을 갖는다.
        Tiger tiger = new Tiger();
        Animal tiger2 = new Tiger();
        Predator tiger3 = new Tiger();
        Barkable tiger4 = new Tiger();
    }
}
