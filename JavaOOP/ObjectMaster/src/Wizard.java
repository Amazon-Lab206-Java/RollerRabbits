public class Wizard extends Human {
    public Wizard(String name) {
        super(name);
        health = 50;
        intelligence = 8;
    }
    public void heal(Human victim) {
        victim.health += intelligence;

    }

    public void fireball(Human victim){
        victim.health-=intelligence*3;
    }
}
