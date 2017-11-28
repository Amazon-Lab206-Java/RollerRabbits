public class HumanTest {
    public static void main (String[] arg){
        Human victim= new Human("gordon"); // this is the victim
        Human bully = new Human("steve");//this is the attacker/ bully

        bully.displayHealth();
        victim.displayHealth();

        bully.attack(victim);
        victim.displayHealth();
    }
}