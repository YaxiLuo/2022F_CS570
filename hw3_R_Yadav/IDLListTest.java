public class IDLListTest {

    public static void main(String[] args) {
        IDLList<Integer> dll= new IDLList<Integer>();
        dll.add(500);
        dll.add(400);
        dll.add(300);
        dll.add(200);
        dll.add(100);
        System.out.println(dll.toString());
        System.out.println("Current size of the list: "+ dll.size());
        dll.append(600);
        System.out.println(dll.toString());
        dll.add(4, 700);
        System.out.println(dll.toString());
        System.out.println(dll.get(1));
        System.out.println(dll.getHead());
        System.out.println(dll.getLast());
        System.out.println(dll.removeAt(3));
        System.out.println(dll.toString());
        System.out.println(dll.remove(300));
        System.out.println(dll.toString());
        System.out.println(dll.removeLast());
        System.out.println(dll.toString());
    }
}
