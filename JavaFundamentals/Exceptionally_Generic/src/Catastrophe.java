import java.util.ArrayList;

public class Catastrophe {
    public static void main(String[] args){
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

//        for(Object value : myList) {
//            Integer castedValue = (Integer) value;
//        }

        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch (ClassCastException e) {
                System.out.println(i);
            }

        }


    }
}
