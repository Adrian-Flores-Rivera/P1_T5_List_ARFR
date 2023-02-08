package uaslp.objetos.list.linkedlist;

public class Main {

    public static void main(String []args) {
        LinkedList linkedList = new LinkedList();

        System.out.println(linkedList.getSize());

        LinkedListIterator iterator = linkedList.getIterator();
        while(iterator.hasNext()){
            String data = iterator.next();
        }
    }
}