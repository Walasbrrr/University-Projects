public class StackDriver {

    public static void main(String[] args) {
        // Instance of ArrayBoundedStack
        ArrayBoundedStack<String> stack = new ArrayBoundedStack<>(10);
        ArrayBoundedStack<String> temp1 = new ArrayBoundedStack<>(10);
        ArrayBoundedStack<String> temp2 = new ArrayBoundedStack<>(10);

        // Load the stack with the array of colors
        String[] colors = {"Red", "Yellow", "Green", "Purple", "Yellow",
                "Blue", "Orange", "Yellow", "Brown", "Black"};

        for (int i = 0; i < colors.length; i++) {
            stack.push(colors[i]);
        }
        System.out.println("Initial stack: " + stack);

        // Remove all "Yellow" values while preserving the order of the others
        while (!stack.isEmpty()) {
            String color = stack.top();
            stack.pop();
            if (!color.equals("Yellow")) {
                temp1.push(color);
            }
        }

        // Move from temp1 to temp2 to restore order
        while (!temp1.isEmpty()) {
            temp2.push(temp1.top());
            temp1.pop();
        }

        // Move back from temp2 to the original stack
        while (!temp2.isEmpty()) {
            stack.push(temp2.top());
            temp2.pop();
        }

        System.out.println("Final stack (no Yellow): " + stack);
    }
}
