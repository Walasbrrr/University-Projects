import support.DLLNode;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyDeque<T> implements DequeInterface<T> {
    private DLLNode<T> front;
    private DLLNode<T> rear;
    private int size;

    @Override
    public void enqueueFront(T element) throws QueueOverflowException {
        DLLNode<T> n = new DLLNode<>(element);
        if (isEmpty()) {
            front = rear = n;
        } else {
            n.setForward(front);
            front.setBack(n);
            front = n;
        }
        size++;
    }

    @Override
    public void enqueueRear(T element) throws QueueOverflowException {
        DLLNode<T> n = new DLLNode<>(element);
        if (isEmpty()) {
            front = rear = n;
        } else {
            rear.setForward(n);
            n.setBack(rear);
            rear = n;
        }
        size++;
    }

    @Override
    public T dequeueFront() throws QueueUnderflowException {
        if (isEmpty()) throw new QueueUnderflowException("Deque is empty");
        T e = front.getInfo();
        front = front.getForward();
        if (front == null) rear = null; else front.setBack(null);
        size--;
        return e;
    }

    @Override
    public T dequeueRear() throws QueueUnderflowException {
        if (isEmpty()) throw new QueueUnderflowException("Deque is empty");
        T e = rear.getInfo();
        rear = rear.getBack();
        if (rear == null) front = null; else rear.setForward(null);
        size--;
        return e;
    }

    @Override public boolean isFull() { return false; }
    @Override public boolean isEmpty() { return size == 0; }
    @Override public int size() { return size; }
}
