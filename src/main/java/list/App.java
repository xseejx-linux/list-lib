package list;


public class App 
{
    public static void main( String[] args ) throws notSorted
    {
        System.out.println( "-------------- ! Running Main App ! --------------\n\n" );

        List<String> list = new List<String>();
        List<String> list1;

        Node<String> node_0 = new Node<String>("Node 0");
        Node<String> node_1 = new Node<String>("Node 1");
        Node<String> node_2 = new Node<String>("Node 2");
        Node<String> node_3 = new Node<String>("Node 3");

        list.add(node_3);
        list.add(node_2);
        list.add(node_1);
        list.add(node_0);
        System.out.println(list.printAllList());
        
        list1 = new List<String>(list);
        
        
        try {
            list.sort(0);
        } catch (invalidModeParameter e) {
            e.printStackTrace();
        } 

        list.isSorted();
        list1.isSorted();

        list.add(new Node<>("Node"), Flag.ENABLE_ADDSORTED);

        
        System.out.println("List 0: "+list.printAllList());
        System.out.println("List 1: "+list1.printAllList());

        System.out.println( "\n\n-------------- ! Stopped Main App ! --------------" );
    }
}
