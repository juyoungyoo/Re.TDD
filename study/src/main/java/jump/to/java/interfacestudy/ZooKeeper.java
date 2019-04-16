package jump.to.java.interfacestudy;

public class ZooKeeper {

//    public void feed(Tiger tiger){
//        System.out.println("feed apple");
//    }
//
//    public void feed(Lion lion){
//        System.out.println("feed banana");
//    }

    public void feed(Predator predator){
        System.out.println("feed " + predator.getFood());
    }

    public static void main(String[] args){

        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);

    }

}
