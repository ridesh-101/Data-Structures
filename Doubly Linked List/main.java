package com.company.linkedlist;

public class Main {

    public static void main(String[] args) {
	CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        list.addToFront("Ridesh Raj");
        list.addToFront("Tony Stark");
        list.addToFront("Clark Kent");
        list.addToFront("Bruce Wayne");
        list.addToFront("Steve Rogers");
        list.printList();
        System.out.println("Size: " + list.getSize());
        list.addToEnd("Natasha Romanoff");
        list.addToEnd("Diana Prince");
        list.addToEnd("Gwen Stacy");
        list.addToEnd("Mary Jane");
        list.printList();
        System.out.println("Size: " + list.getSize());
        list.removeFromFront();
        list.removeFromFront();
//        list.removeFromFront();
//        list.removeFromFront();
        list.removeFromEnd();
        list.removeFromEnd();
        System.out.println(list.removeFromEnd().data);
        list.printList();
        System.out.println("Size: " + list.getSize());
        System.out.println(list.addBefore("Felicia Hardy", "Thomas"));
        System.out.println(list.addBefore("Miles Morales", "Ridesh Raj"));
        list.printList();
        System.out.println("Size: " + list.getSize());
        System.out.println(list.addBefore("Bruce Wayne", "Clark Kent"));
        list.printList();
        System.out.println("Size: " + list.getSize());
        System.out.println(list.addBefore("Mary Jane", "Natasha Romanoff"));
        list.printList();
        System.out.println("Size: " + list.getSize());
    }
}
 class Node {
    public Node previous;
    public String data;
    public Node next;

    Node(String data) {
        this.data = data;
    }
 }

 class CustomDoublyLinkedList {

    public Node head;
    public Node tail;
    private int size = 0;

    public void addToFront(String data) {
        Node node = new Node(data);

        if(head == null) {
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
        }
        head = node;
        size++;
    }

    public void addToEnd(String data) {
        Node node = new Node(data);
        if(tail == null) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    public Node removeFromFront() {
        if(isEmpty()) {
            return  null;
        }
        Node removedNode = head;
        if(head.next == null) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        removedNode.next = null;
        size--;
        return removedNode;
    }

    public Node removeFromEnd() {
        if(isEmpty()) return null;
        Node removedNode = tail;
        if(tail.previous != null) {
            tail.previous.next = null;
        } else {
            head = null;
        }
        tail = tail.previous;
        removedNode.previous = null;
        size--;
        return removedNode;
    }

    public boolean addBefore(String value, String valBefore) {
        if(isEmpty()) {
            return false;
        }
        Node node = new Node(value);
        Node temp = head;
        while(temp != null && !(temp.data.equals(valBefore))) {
            temp = temp.next;
        }
        if(temp == null) {
            return false;
        } else if(temp.previous == null) {
            addToFront(value);
            return true;
        } else {
            node.next = temp;
            node.previous = temp.previous;
            temp.previous.next = node;
            temp.previous = node;
            size++;
            return true;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node temp = head;
        System.out.print("head --> ");
        while(temp != null) {
            System.out.print(temp.data);
            System.out.print(" <==> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
 }

