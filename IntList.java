public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        IntList p = this;
        int toatlSize = 0;
        while (p != null) {
            toatlSize += 1;
            p = p.rest;
        }
        return toatlSize;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(16, L);
        L = new IntList(67, L);
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
    }
}
