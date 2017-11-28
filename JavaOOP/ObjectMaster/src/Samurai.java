public class Samurai extends Human {
    private static int numSamurais=0;
    public Samurai(String name){
        super(name);
        health=200;
        numSamurais+=1;
    }

    public void deathBlow(Human victim){
        victim.health=0;
        this.health/=2;
    }

    public void meditate(){
        this.health*=1.5;
    }
    public int howMany(){
        return numSamurais;
    }
}
