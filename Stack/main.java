package com.company.stack;

import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(44);
        System.out.println("SIZE: " + stack.size());
//        stack.push(3000);
//        stack.push(616);
        stack.push(101);
        stack.push(19990909);
        stack.pop();
        stack.pop();
        System.out.println(stack.pop());
        System.out.println("SIZE: " + stack.size());
        System.out.println(stack.peek());
        stack.printStack();
    }
}

class ArrayStack {

    public int[] stack;
    public int top;

    ArrayStack(int capacity) {
        stack = new int[capacity];
    }

    public void push(int val) {
        if(top == stack.length) {
            int[] newArray = new int[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top] = val;
        top++;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        int removedVal = stack[--top];
        stack[top] = 0;
        return removedVal;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top-1];
     }


     public void printStack() {
        for(int i=top-1; i>=0; i--) {
            System.out.println(stack[i]);
        }
     }

     public int size() {
        return top;
     }

    public boolean isEmpty() {
        return top == 0;
    }
}
