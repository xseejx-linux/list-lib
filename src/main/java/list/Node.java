package list;

public class Node {
    private Node link;
    private String obj;

    public Node(){
        super();
        this.obj = null;
        this.link = null;
    }
    public Node(Object obj){
        super();
        this.obj = (String)obj;
        this.link = null;
    }
    public Node(Object obj, Node link){
        super();
        this.obj = (String)obj;
        this.link = link;
    }
    public Node(Node node){
        this.link = node.getLink();
        this.obj = node.getObj();
    }

    public String getObj() { return obj;}                                            
    public void setObj(String str){ this.obj =str;} 
                                            
    public Node getLink() { return link; }     
    public void setLink(Node node){ this.link =node;}    

}
