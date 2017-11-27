public class ProjectTest {
    public static void main(String[] args){
        Project a= new Project();
        a.setName("rabbit");
        a.setDescription("legamorph encyclopedia");
        System.out.println(a.elevatorPitch());

        Project b=new Project("tanks");
        b.getName();
        System.out.println(b.elevatorPitch());


        Project c=new Project("Bananamania", "People obsessed with bananas");
        System.out.println(c.elevatorPitch());


    }
}
