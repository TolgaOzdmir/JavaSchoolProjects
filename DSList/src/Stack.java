public class Stack {
    private LinkedList list;

    public Stack(){
        list = new LinkedList();
    }

    public void push(int data){
        list.addHead(data);
    }

    public int pop(){
        return list.removeHead();
    }

    public void display(){
        list.display();
    }
}
