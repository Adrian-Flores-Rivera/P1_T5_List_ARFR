package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node head;

    private Node tail;

    private int size;

    //Encapsulación -> la capacidad que tienen las clases para hacer
    //visible u ocultar los atributos y los metodos
    //para dar niveles de visibilidad.

    public void addAtTail(String data){
        Node node = new Node();
        node.data= data;
        node.previous=tail;
        if(head==null){
            head=node;
        }else{
            tail.next = node;
        }
        tail=node;
        size++;
    }

    public void addAtFront(String data){
        Node node = new Node();
        node.data = data;
        node.next=head;
        if(tail==null){
            tail=node;
        }else{
            head.previous=node;
        }
        head=node;
        size++;
    }

    public void remove(int index){
        Node nodeReserv = head;
        Node temp;
        for(int currentIndex=0; currentIndex<index;currentIndex++){
            temp=nodeReserv.previous;
            nodeReserv=nodeReserv.next;
        }
        temp=nodeReserv.previous;
    }

    public void removeAll(){
        Node temp= head;
        for(int i = 0; i<countNumberData(); i++){
            setAt(0, temp.data);
            temp=temp.next;
        }
    }

    public int countNumberData(){
        this.size=0;
        Node nodeAct=this.head;
        while(nodeAct!=null){
            this.size++;
            nodeAct=nodeAct.next;
        }
        return this.size;
    }

    public void setAt(int index,String data){
        Node currentNode = head;
        for(int currentIndex=0; currentIndex < index; currentIndex++) {
            if (currentNode.data == data) {
                this.size= Integer.parseInt(data);
            }else{
                currentNode = currentNode.next;
            }
        }
    }

    public String getAt(int index){
        if(index<0|| index >= size){
            return null;
        }
        Node currentNode = head;
        for(int currentIndex=0; currentIndex < index; currentIndex++)
        {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public void removeAllWithValue(String data){
        Node aux=head;
        int i=0;
        while(aux!=null){
            i++;
            if(aux.data==data){
                if(head==aux){
                    head=aux.next;
                    if(head!=null)
                        aux.next.previous=null;
                }else{
                    aux.previous.next=aux.next;
                    if(aux.next!=null)
                        aux.next.previous=aux.previous;
                    else
                        tail=aux.previous;
                }
                break;
            }
            aux=aux.next;
        }
    }

    public int getSize(){
        return size;
    }

    public LinkedListIterator getIterator(){
        return new LinkedListIterator((head));
    }

}
