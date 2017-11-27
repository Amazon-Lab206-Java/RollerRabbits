import java.util.Arrays;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList(){
        this.head=null;
    }
    public void add(int value){
        Node newNode= new Node(value);

        if(head==null) {
            head = newNode;
        }else {
            Node runner = head;  //why??!! -- need a starting point for the runner. Runner doesn't know how to move to next point if you don't have a starting point.
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void addMultiple(int... values) {
        for (int v : values) {
            add(v);
        }
    }
    public void remove(){
        Node runner=this.head;

        if(runner==null) {//huh?... there is nothing to remove, nothing in the list.
            System.out.println("there are no nodes in the SLL");
        } else if(head.next==null){
            head=null;// exactly one thing in the list, and we need to remove it.

        }else {
            while(runner.next.next !=null) {
                runner = runner.next;
            }
            runner.next=null;

        }
    }
     public void printValues(){
        Node runner=this.head;
        if(runner==null) {
            System.out.println("There are no nodes in the SLL");
        }else{
            while(runner !=null){
                System.out.println(runner.value);
                runner=runner.next;
            }
        }
     }


}
