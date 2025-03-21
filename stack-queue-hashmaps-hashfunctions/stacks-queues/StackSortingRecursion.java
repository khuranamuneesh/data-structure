import java.util.Stack;

class SortStack {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove top element
            sortStack(stack); // Recursively sort remaining stack
            insertInSortedOrder(stack, top); // Insert back in sorted order
        }
    }

    // Helper function to insert an element into the sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int temp = stack.pop(); // Remove top element
        insertInSortedOrder(stack, value); // Recursively insert value in correct place
        stack.push(temp); // Push the removed element back
    }

    // Function to print stack
    public static void printStack(Stack<Integer> stack) {
        for (Integer num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class StackSortingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        System.out.println("Original Stack:");
        SortStack.printStack(stack); // Fixed method call

        SortStack.sortStack(stack); // Fixed method call

        System.out.println("\nSorted Stack:");
        SortStack.printStack(stack); // Fixed method call
    }
}
