public class Dragon extends Mammal{
    public Dragon(){
        this.energyLevel=300;
    }
    public void fly(){
        System.out.println( "flying like defying gravity");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("Humans are delicious nom nom!");
        this.energyLevel+=25;
    }

    public void attackTown() {
        System.out.println("BURN EVERYTHING TO THE GROUND!");
        this.energyLevel -= 100;
    }
}
