
public abstract class AbstractTree {

    protected Node root;

    public AbstractTree() {
        root = null;
    }

    abstract void insert(int data);

    abstract void delete(int key);

    abstract boolean findVal(int key);

    abstract void inOrder();

    abstract void preOrder();
}
