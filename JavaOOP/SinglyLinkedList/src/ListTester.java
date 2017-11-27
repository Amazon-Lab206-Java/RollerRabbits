public class ListTester {
    public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addMultiple(15, 12, 10, 25);
        sll.printValues();

        System.out.println("remove last one");
        sll.remove();
        sll.printValues();
    }
}
