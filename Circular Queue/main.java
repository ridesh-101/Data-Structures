package com.company.queue;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        CustomCircularQueue queue = new CustomCircularQueue(5);
        queue.add("Harry");
        queue.add("Ron");
        queue.add("Hermione");
        queue.add("Cho");
        queue.add("Cedric");
        queue.add("Snape");
        queue.add("Lily");
        queue.add("James");
        queue.add("Ridesh");

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.printQueue();

    }
}

class CustomCircularQueue {
    public String[] queue;
    public int front;
    public int back;

    CustomCircularQueue(int capacity) {
        queue = new String[capacity];
    }

    public void add(String val) {
        if(size() == queue.length - 1) {
            int numItems = size();
            String[] newArray = new String[2 * queue.length];
            System.arraycopy(queue, front, newArray,0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;
            front = 0;
            back = numItems;
        }
        queue[back] = val;
        if(back < queue.length - 1) back++;
        else back = 0;

    }

    public String remove() {
        if(size() == 0) throw new NoSuchElementException();

        String removed = queue[front];
        queue[front] = null;
        front++;

        if(size() == 0) {
            front = 0;
            back = 0;
        } else if(front == queue.length) front = 0;
        return removed;
    }

    public String peek() {
        if(size() == 0) throw new NoSuchElementException();
        return queue[front];
    }

    public int size() {
        if(front <= back) return back - front;
        return back - front + queue.length;
    }

    public void printQueue() {
        if(front <= back) {
            for(int i=front; i<back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for(int i=front; i<queue.length; i++) System.out.println(queue[i]);
            for(int i=0; i<back; i++) System.out.println(queue[i]);
        }

    }
}

