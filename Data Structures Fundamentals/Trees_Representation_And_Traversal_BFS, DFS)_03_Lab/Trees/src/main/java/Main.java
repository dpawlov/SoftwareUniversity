import implementations.Tree;

public class Main {
    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>(
                1,
                new Tree<>(2, new Tree<>(4), new Tree<>(5)),
                new Tree<>(3, new Tree<>(6), new Tree<>(7))
        );

        System.out.println(tree.orderBfs());
    }
}