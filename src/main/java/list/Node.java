package list;

public class Node <T> {
    private Node<T> link;
    private T obj;

    public Node(){
        super();
        this.obj = null;
        this.link = null;
    }
    public Node(T obj){
        super();
        this.obj = obj;
        this.link = null;
    }
    public Node(T obj, Node<T> link){
        super();
        this.obj = obj;
        this.link = link;
    }
    public Node(Node<T> node){
        this.link = node.getLink();
        this.obj = node.getObj();
    }

    public T getObj() { return obj;}                                            
    public void setObj(T obj){ this.obj =obj;} 
                                            
    public Node<T> getLink() { return link; }     
    public void setLink(Node<T> node){ this.link =node;} 

}
