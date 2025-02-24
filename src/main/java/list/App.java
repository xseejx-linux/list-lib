package list;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "-------------- ! Running App ! --------------\n\n" );

        List list = new List();
        List list1;

        Node node_0 = new Node("Node 0");
        Node node_1 = new Node("Node 1");
        Node node_2 = new Node("Node 2");
        Node node_3 = new Node("Node 3");

        list.add(node_3);
        list.add(node_2);
        list.add(node_1);
        list.add(node_0);
        System.out.println(list.printAllList());
        
        list1 = new List(list);
        
        //list.swap(list.getNode(0), list.getNode(3));
        
        //System.out.println(list.getNode(1).getObj().toString());
        // Sort with comparator - To be done
        try {
            list.sort(0);
        } catch (invalidModeParameter e) {
            e.printStackTrace();
        } 
// Comparator
/*
Functional Interface Implementation:
The Comparator<T> interface has a single method:
`int compare(T o1, T o2);`
The lambda '(a, b) -> a - b' is shorthand for an implementation of this method.
It tells Java: "When you need to compare *two elements*, subtract the second from the first."
*/
        //list1.swap(list1.getNode(0), list1.getNode(list1.length-1));
        System.out.println("List 0: "+list.printAllList());
        System.out.println("List 1: "+list1.printAllList());

        System.out.println( "\n\n-------------- ! Stopped App ! --------------" );
    }
}
