public class main {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.addTail(4);
        llist.addTail(5);
        llist.addTail(6);
        llist.addTail(7);

//        llist.addHead(4);
//        llist.addHead(5);
//        llist.addHead(6);
//        llist.addHead(7);

        llist.display();

        llist.removeTail();

        llist.display();

        llist.remove(3);

        llist.display();

//        Stack stack = new Stack();
//
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//
//        stack.display();
//
//        System.out.println("Pop: "+stack.pop());
//        stack.display();
    }
}
