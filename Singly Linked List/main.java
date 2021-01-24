package com.company.linkedlist;

public class Main {

    public static void main(String[] args) {
        CustomSinglyLinkedList ll = new CustomSinglyLinkedList();
//        ll.addToFront(1999909);
//        ll.addToFront(616);
//        ll.addToFront(204);
//        ll.addToFront(101);
//        System.out.println(ll.getSize());
//        System.out.println(ll.removeFromFront().getData());
//        System.out.println(ll.getSize());
//        ll.printList();
//        ll.addToFront(1999909);
//        ll.addToFront(101);
//
//        ll.printList();
        ll.insertSorted(101);
        ll.printList();
        System.out.println(ll.getSize());
        ll.insertSorted(3000);
        ll.printList();
        System.out.println(ll.getSize());
        ll.insertSorted(96);
        ll.printList();
        System.out.println(ll.getSize());
        ll.insertSorted(199898989);
        ll.printList();
        System.out.println(ll.getSize());
        ll.insertSorted(7337);
        ll.printList();
        System.out.println(ll.getSize());
        ll.insertSorted(4568);
        ll.printList();
        System.out.println(ll.getSize());

    }
}

class Node {
    public Node next;
    public int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class CustomSinglyLinkedList {

    private Node head;
    private int size = 0;
    void addToFront(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    Node removeFromFront() {
        if(isEmpty()) {
            return null;
        }
        Node removedNode = head;
        head = head.next;
        size--;
        return removedNode;
    }

    public void insertSorted(int value) {
        if(isEmpty() || head.data >= value) {
            addToFront(value);
            return;
        }
        Node node  = new Node(value);
        Node previous = head;
        Node current = head.next;
        while(current != null && !(current.data > value)) {
            previous = current;
            current = current.next;
        }
        node.next = current;
        previous.next = node;
        size++;
    }

    public void printList() {
        Node temp = head;
        System.out.print("head --> ");
        while(temp != null) {
            System.out.print(temp.getData());
            System.out.print(" --> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
