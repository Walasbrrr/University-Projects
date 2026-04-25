public class LinkedStack<T> implements StackInterface<T> {

    // Reference to the top node in the stack
    protected LLNode<T> top;

    // Constructor
    public LinkedStack() {
        top = null;
    }

    // Push: add new element on top
    @Override
    public void push(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        newNode.setLink(top);
        top = newNode;
    }

    // Pop: remove the top element
    @Override
    public void pop() {
        if (top == null) {
            throw new StackUnderflowException("Pop attempted on empty stack.");
        } else {
            top = top.getLink();
        }
    }

    // Top: return the top element without removing it
    @Override
    public T top() {
        if (top == null) {
            throw new StackUnderflowException("Top attempted on empty stack.");
        } else {
            return top.getInfo();
        }
    }

    // Check if stack is empty
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // For a linked stack, it's never full (unbounded)
    @Override
    public boolean isFull() {
        return false;
    }
}
