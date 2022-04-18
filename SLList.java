/**
 * an SLList is a list of integers which hides the terrible truth
 * of the nakedness within.
 */
public class SLList {
    /* This is static nested class */
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    /**
     * Create empty list.  Using overload.
     */

    public SLList() {
        sentinel = new IntNode(63, null);
        last = sentinel;
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        last = sentinel.next;
        size = 1;
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /**
     * Returns the first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds the item to the end of the list.
     */
    public void addLast(int x) {
        last.next = new IntNode(x, null);
        last = last.next;
        size += 1;
    }

    /**
     * Print all item in the list.
     */
    public void printNode() {
        IntNode p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size(sentinel.next);
    }

    public int sizeCaching() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(12);
        L.addFirst(34);
        System.out.println(L.getFirst());
        L.addLast(94);
        L.addLast(43);
        L.addLast(32);
        L.printNode();
        System.out.println(L.size());
        System.out.println(L.sizeCaching());
        SLList R = new SLList();
        R.addLast(34);
        R.addLast(3);
        R.addLast(6);
        R.printNode();

    }
}
