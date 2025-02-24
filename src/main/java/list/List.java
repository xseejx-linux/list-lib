package list;


public class List {
    private Node head;
    private int length;

    public List(){
        head = null;
        length = 0;
    }

    public List(List l){
        Node support = l.head;
        length = 0;
        head = null;
        while (support!=null) {
            this.add(new Node(support.getObj()));
            support = support.getLink();
        }
    }

    // Add
    public void add(Node n){
        length++;
        if(head == null){
            head = new Node(n.getObj(),null);
            return;
        }
        if(head.getLink() == null){
            head.setLink(new Node(n));
            return;
        }

        Node support = head;
        while (support.getLink()!=null) {
            support = support.getLink();
        }
        support.setLink(new Node(n));
        return;   
    }
    public void add(Node n, int index) throws IndexOutOfBoundsException{
        if(index>length){
            throw new IndexOutOfBoundsException();
        }
        if(index<0){
            index = length+(index+1);
            if(index>length) throw new IndexOutOfBoundsException();            
        }
        if(index == 0){
            head = new Node(n.getObj(), head);
            length++;
            return;
        }
        Node support = head;
        for(int i = 0; i<index-1; i++){
            support = support.getLink();
        }
        support.setLink(new Node(n.getObj(), support.getLink()));
        length++; 
    }
    // Remove
    public void remove(int index) throws IndexOutOfBoundsException, isEmpty{
        if(isEmpty())
            throw new isEmpty();
        if(index>length){
            throw new IndexOutOfBoundsException();
        }
        if(index<0){
            index = length+(index);
            if(index>length) throw new IndexOutOfBoundsException();            
        }
        if(index == 0){
            if(head.getLink()==null){head = null; return;}
                
            head = new Node(head.getLink().getObj(), head.getLink().getLink());
            length--; 
            return;
        }
        Node support = head;
        for(int i = 0; i<index-1; i++){
            support = support.getLink();
        }        
        support.setLink(support.getLink().getLink());
        length--; 
    }
    public void remove(Node n) throws isEmpty{
        if(isEmpty())
            throw new isEmpty();
        Node support = head;
        int i = 0;
        while (support!=null) {
            if(support.getObj().equals(n.getObj())){
                remove(i);
                return;
            }
            i++;
            support = support.getLink();
        }
        
    }
    public void removeAll(Node n) throws isEmpty{
        if(isEmpty())
            throw new isEmpty();
        Node support = head;
        int i = 0;
        while (support!=null) {
            if(support.getObj().equals(n.getObj())){
                remove(i);
                i--;
            }
            i++;
            support = support.getLink();
        }
    }
    public void removeAll(int[] indexes) throws isEmpty{
        if(isEmpty())
            throw new isEmpty();
        for(int i = 0; i<indexes.length; i++){
            try {
                remove(indexes[i]);
                for(int j = i; j<indexes.length; j++){
                    --indexes[j];
                }             
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            } catch (isEmpty e){
                throw new isEmpty();
            }
        }
    }
    public void removeAll() {
        while (!isEmpty()) {
            try {
                remove(0);
            } catch (IndexOutOfBoundsException | list.isEmpty e) {
                ;
            }
        }
        
    }
    //
    public int indexOf(Node n){
        Node support = head;
        int i = 0;
        while (support!=null) {
            if(support.getObj().equals(n.getObj())){
                return i;
            }
            i++;
            support = support.getLink();
        }
        return -1;
    }
    public Node getNode(int index) throws IndexOutOfBoundsException{
        Node support = head;
        int i = 0;
        while (support!=null) {
            if(index == i){
                return support;
            }
            i++;
            support = support.getLink();
        }
        throw new IndexOutOfBoundsException();
    }
    public void swap(Node n, Node n1){
        int index_n = indexOf(n); 
        int index_n1 = indexOf(n1); 
        try {
            remove(index_n);
            remove(index_n1-1);
        } catch (IndexOutOfBoundsException | list.isEmpty e) {
        }
        add(n1, index_n);
        add(n, index_n1);
    }
    public void sort(int mode) throws invalidModeParameter{
        // Bubble-sort
        boolean sorted;
        do{
            sorted = true;
            int i = 0;
            int j = i+1;
            while (j<length) {
                switch (mode) {
                    case 0:{
                        // Ascending
                        if(getNode(i).getObj().compareTo(getNode(j).getObj())>0){
                            sorted = false;
                            swap(getNode(i), getNode(j));
                        }
                        break;
                    }
                    case 1:{
                        // Descending
                        if(getNode(i).getObj().compareTo(getNode(j).getObj())<0){
                            sorted = false;
                            swap(getNode(i), getNode(j));
                        }
                        break;
                    }                
                    default:{
                        throw new invalidModeParameter();
                    }                       
                }                
                i++;
                j++;
            }                
        }while(!sorted);
    }
    // Print
    public String printAllList(){
        Node temp = head;
        String s = "";
        while (temp!=null) {
            s+="["+temp.getObj().toString()+"]" + ((temp.getLink()==null) ? "":", ");
            temp = temp.getLink();
        }
        return s;
    }

    public boolean isEmpty(){
        return head == null;
    }

}
