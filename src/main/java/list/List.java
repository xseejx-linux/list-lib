package list;


public class List <T extends Comparable<T>> {
    private Node <T> head;
    private int length;

    public List(){
        head = null;
        length = 0;
    }

    public List(List <T> l){
        Node<T> support = l.head;
        length = 0;
        head = null;
        while (support!=null) {
            this.add(new Node<T>(support.getObj()));
            support = support.getLink();
        }
    }

    // Add
    public void add(Node<T> n){
        length++;
        if(head == null){
            head = new Node<T>(n.getObj(),null);
            return;
        }
        if(head.getLink() == null){
            head.setLink(new Node<T>(n));
            return;
        }

        Node<T> support = head;
        while (support.getLink()!=null) {
            support = support.getLink();
        }
        support.setLink(new Node<T>(n));
        return;   
    }
    public void add(Node<T> n, int index) throws IndexOutOfBoundsException{
        if(index>length){
            throw new IndexOutOfBoundsException();
        }
        if(index<0){
            index = length+(index+1);
            if(index>length) throw new IndexOutOfBoundsException();            
        }
        if(index == 0){
            head = new Node<T>(n.getObj(), head);
            length++;
            return;
        }
        Node<T> support = head;
        for(int i = 0; i<index-1; i++){
            support = support.getLink();
        }
        support.setLink(new Node<T>(n.getObj(), support.getLink()));
        length++; 
    }
    public void add(Node<T> n, Flag... flags) throws notSorted{
        for (Flag flag : flags) {
            switch (flag) {
                case ENABLE_ADDSORTED:{
                    if(!isSorted()[0])
                        throw new notSorted();
            
                    int modeSort = isSorted()[1] ? 0:1;
                    add(n);
                    try {
                        sort(modeSort);// if true ascending 0 1 3   - 0 for ascending
                    } catch (invalidModeParameter e) {}
                    break; 
                }           
                default:
                System.out.println("WARNING: Flag '" + flag + "' is not recognized or not applicable in this context.");
                    break;
            }
        }
        
        return;
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
                
            head = new Node<T>(head.getLink().getObj(), head.getLink().getLink());
            length--; 
            return;
        }
        Node<T> support = head;
        for(int i = 0; i<index-1; i++){
            support = support.getLink();
        }        
        support.setLink(support.getLink().getLink());
        length--; 
    }
    public void remove(Node<T> n) throws isEmpty{
        if(isEmpty())
            throw new isEmpty();
        Node<T> support = head;
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
    public void removeAll(Node<T> n) throws isEmpty{
        if(isEmpty())
            throw new isEmpty();
        Node<T> support = head;
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
    public int indexOf(Node<T> n){
        Node<T> support = head;
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
    public Node<T> getNode(int index) throws IndexOutOfBoundsException{
        Node<T> support = head;
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
    public void swap(Node<T> n, Node<T> n1){
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
    public boolean[] isSorted(){
        int counter = 1;
        for(int i = 0; i<length-1; i++){
            try {                
                if(getNode(i).getObj().compareTo(getNode(i+1).getObj())>0){
                    counter++;
                }
            } catch (IndexOutOfBoundsException e) {
                
            }
        }
        // if counter == 1 --> sorted ascending
        return new boolean[] {(counter==length || counter == 1), (counter == 1)};
        
    }
    // Print
    public String printAllList(){
        Node<T> temp = head;
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
