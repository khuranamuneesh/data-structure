import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1; // For enqueue operations
    Stack<Integer> stack2; // For dequeue operations

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Always push into stack1
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Dequeue operation: Transfer stack1 to stack2 if needed, then pop
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation: Get the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class ImplementQueueUsingStack {
    public static void main(String[] args) //implementing queues using stack
    {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Front element: " + queue.peek()); // Output: 2

        queue.enqueue(4);
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 2
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 3
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 4
    }
}
