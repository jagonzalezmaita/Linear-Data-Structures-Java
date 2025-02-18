package com.mycompany.linearStructure;

// Nodo para la cola con prioridad, que hereda de BaseNode
public class PriorityNode extends BaseNode {
    private int priority;

    public PriorityNode(int value, int priority) {
        super(value);   // Llamada al constructor de BaseNode
        this.priority=priority;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }    
}
