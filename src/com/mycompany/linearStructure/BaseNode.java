package com.mycompany.linearStructure;

// Nodo para la cola simple, stack
class BaseNode {
    private int value;
    private BaseNode next;

    public BaseNode(int value) {
        this.value = value;
        this.next = null;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BaseNode getNext() {
        return next;
    }

    public void setNext(BaseNode next) {
        this.next = next;
    }
}