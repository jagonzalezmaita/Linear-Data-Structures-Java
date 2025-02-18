package com.mycompany.linearStructure;


public class Stack extends AbstractLinearStructure {


    public Boolean addValue(int value) {
        BaseNode newNode = new BaseNode(value);
        newNode.setNext(getFront());
        setFront(newNode);
        return true;
    }

    @Override
    public Integer removeValue() {
        if (getFront() == null) { //Stack está vacío
            return null;
        }
        //Si no esta vacio el Stack
        int removedValue = getFront().getValue(); //Se obtiene el valor que será eliminado
        setFront(getFront().getNext()); //Se elimina el primer elemento al cambiar las referencias
        return removedValue;
    }

    @Override
    protected void displayElements(BaseNode current) {
        System.out.println("Elementos en la pila \nTop:");
        // En un stack, se debe mostrar desde el primero (top) hasta el último
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
        System.out.println("Bottom");
    }
}
