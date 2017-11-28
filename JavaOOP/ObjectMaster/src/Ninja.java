public class Ninja extends Human{
    public Ninja(String name){
        super(name);
        stealth=10;
    }
    public void steal(Human victim){ // you steal victim's health as a ninja
        this.health+=stealth; // this is the ninja's health stolen and improved.
        victim.health-=stealth;
    }
    public void runAway(){
        this.health-=10;
    }
}

