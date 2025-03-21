import java.util.Stack;

class StockSpan {

    // Function to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Array to store span results
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price at top is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, span = i + 1 (all previous prices were smaller)
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index to stack
            stack.push(i);
        }

        return span;
    }

    // Function to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
} // Missing closing brace added for StockSpan class

// Main class
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock Prices:");
        StockSpan.printArray(prices); // Fixed method call

        int[] spans = StockSpan.calculateSpan(prices); // Fixed method call
        System.out.println("\nStock Span:");
        StockSpan.printArray(spans); // Fixed method call
    }
}
