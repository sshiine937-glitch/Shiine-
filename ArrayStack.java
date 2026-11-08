class ArrayStack {

    private int[] stack;
    private int top;
    private int capacity;


    public ArrayStack(int initialCapacity) {
        capacity = initialCapacity;
        stack = new int[capacity];
        top = -1;
    }


    public void push(int value) {

        if (size() == capacity) {
            expandCapacity();
        }
        top++;
        stack[top] = value;
    }


    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public int size() {
        return top + 1;
    }


    private void expandCapacity() {
        int[] larger = new int[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            larger[i] = stack[i];
        }
        stack = larger;
        capacity = capacity * 2;
    }
}

public class Solution {
    public static int[] reverseArray(int[] numbers) {


        ArrayStack stack = new ArrayStack(2);

        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }


        int[] reversed = new int[numbers.length];
        int index = 0;
        while (!stack.isEmpty()) {
            reversed[index] = stack.pop();
            index++;
        }

        return reversed;
    }

    public static int[] reverseFirstK(int[] numbers, int k) {

        ArrayStack stack = new ArrayStack(2);

        for (int i = 0; i < k; i++) {
            stack.push(numbers[i]);
        }

        int[] result = new int[numbers.length];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index++;
        }
        for (int i = k; i < numbers.length; i++) {
            result[i] = numbers[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int[] result = reverseArray(numbers);

        System.out.print("Reversed: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] bonus = reverseFirstK(new int[]{10, 20, 30, 40, 50}, 3);

        System.out.print("First K reversed: ");
        for (int num : bonus) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
