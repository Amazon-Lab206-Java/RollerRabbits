public class Human {
    protected int health=100;
    protected int strength=3;
    protected int stealth=3;
    protected int intelligent=3;
    private final String name;

    public Human(String name) {
        this.name = name;
    }

    public void attack(Human victim){
        victim.health -= this.strength; // this is the human attacking a victim.
        System.out.println("The health of the person that got beaten up is:" + victim.health);
    }

    public int displayHealth(){
        System.out.println("name: "+name+"health: " + health);
        return health;
    }
}
