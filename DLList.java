public class DLList {

    public static class DoubleIntNode {
        public int item;
        public DoubleIntNode prev;
        public DoubleIntNode next;

        public DoubleIntNode(int x, DoubleIntNode p, DoubleIntNode n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    private DoubleIntNode sentinel;
    private int size;

    public DLList() {
        sentinel = new DoubleIntNode(63, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public DLList(int x) {
        sentinel = new DoubleIntNode(63, null, null);
        DoubleIntNode p = new DoubleIntNode(x, sentinel, sentinel);
        sentinel.next = p;
        sentinel.prev = p;
        size = 1;
    }

    public void addFirst(int x) {
        DoubleIntNode p = new DoubleIntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;

    }

    public void addLast(int x) {
        DoubleIntNode p = new DoubleIntNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public void removeFirst() {
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
    }

    public void removeLast() {
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
    }

    public int size() {
        return size;
    }

    public void printNode() {
        DoubleIntNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + "->");
            p = p.next;
        }
        System.out.println(p + " " + sentinel);
    }

    public void printNodeBack() {
        DoubleIntNode p = sentinel.prev;
        while (p != sentinel) {
            System.out.print(p.item + "->");
            p = p.prev;
        }
        System.out.println(p + " " + sentinel);
    }

    public static void main(String[] args) {
        DLList L = new DLList(12);
        L.addFirst(21);
        L.addLast(34);
        L.addLast(24);
        L.removeFirst();
        L.addLast(4);
        L.addLast(3);
        L.removeLast();
        L.printNode();
        L.printNodeBack();
        DLList R = new DLList();
        R.addLast(1);
        R.addFirst(2);
        R.addFirst(7);
        R.addFirst(5);
        R.addFirst(4);
        R.addFirst(3);
        R.printNodeBack();

        System.out.println(L.size() + " " + R.size());
    }
}
