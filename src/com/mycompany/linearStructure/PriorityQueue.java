package com.mycompany.linearStructure;

public class PriorityQueue extends AbstractLinearStructure{

    
    public Boolean addValuePriority(int value, int priority) {
        PriorityNode newNode = new PriorityNode(value, priority);
        if (getFront() == null || ((PriorityNode) getFront()).getPriority() < priority) {
            newNode.setNext(getFront());
            setFront(newNode);
        } else {
            PriorityNode temp = (PriorityNode) getFront();
            while (temp.getNext() != null && ((PriorityNode) temp.getNext()).getPriority() >= priority) {
                temp = (PriorityNode) temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        return true;
    }

    @Override
    public Integer removeValue() {
        if (getFront() == null) {   //La cola con prioridad está vacía
            return null;
        }
        int removedValue = getFront().getValue();   //Se obtiene el valor que será eliminado
        setFront(getFront().getNext()); //Se elimina el primer elemento al cambiar las referencias
        return removedValue;
    }

    @Override
    protected void displayElements(BaseNode current) {
        PriorityNode priorityNode = (PriorityNode) current;
        System.out.println("Elementos en la cola con prioridad \nPrimero en Salir");
        while (priorityNode != null) {
            System.out.println("Valor: " + priorityNode.getValue() + " (Prioridad: " + priorityNode.getPriority() + ")");
            priorityNode = (PriorityNode) priorityNode.getNext();
        }
        System.out.println("Último en Salir");
    }

    @Override
    public void peek() {
        if (getFront() == null) {
            System.out.println("La estructura está vacía.");
        } else {
            PriorityNode current = (PriorityNode) getFront();
            System.out.println("Primer elemento de la estructura: " + current.getValue()+ " (Prioridad: " + current.getPriority() + ") ");
        }
    }    
}
