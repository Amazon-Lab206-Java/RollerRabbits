public class Gorilla extends Mammal{

    private String name;
    public Gorilla(String name) {
        this.name = name;
    }
    public void throwSomething(){
        System.out.println(name + " throws a banana!");
        this.energyLevel -= 5;
    }

    public void eatBanana(){
        System.out.println("eating a buanana. Yum Yum Banana!");
        this.energyLevel+=10;
    }

    public void climb(){
        System.out.println("climbing a tree right now!");
        this.energyLevel-=10;
    }
}
