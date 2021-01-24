package com.company.queue;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CustomQueue queue = new CustomQueue(5);
        queue.add("Lord Voldemort");
        queue.add("Albus Dumbledore");
        queue.add("Harry Potter");
        queue.add("Hermione Granger");
        queue.add("Ron Weasley");

        queue.remove();
        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.remove();
        System.out.println("PEEK: " + queue.peek());
        System.out.println("SIZE: " + queue.size());


        queue.printQueue();
    }
}

class CustomQueue {
    public String[] queue;
    public int front;
    public int back;

    CustomQueue(int capacity) {
        queue = new String[capacity];
    }

    public void add(String val) {
        if(back == queue.length) {
            String[] newArray = new String[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back] = val;
        back++;
    }

    public String remove() {
        if(size() == 0) throw new NoSuchElementException();

        String removed = queue[front];
        queue[front] = null;
        front++;

        if(size() == 0) {
            front = 0;
            back = 0;
        }
        return removed;
    }

    public String peek() {
        if(size() == 0) throw new NoSuchElementException();
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for(int i=front; i<back; i++) {
            System.out.println(queue[i]);
        }
    }
}
