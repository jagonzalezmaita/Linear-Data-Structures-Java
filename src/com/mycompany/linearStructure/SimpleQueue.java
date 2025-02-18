package com.mycompany.linearStructure;

public class SimpleQueue extends AbstractLinearStructure{
    private BaseNode rear;
    
    public SimpleQueue() {
        super();    // Llamada al constructor de AbstractLinearStructure
        this.rear = null;
    }


    public Boolean addValue(int value) {
        BaseNode newNode = new BaseNode(value);
        if (rear == null) {
            setFront(newNode);
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        return true;
    }

    @Override
    public Integer removeValue() {
        if (getFront() == null) {   //La cola está vacía
            return null; 
        }
        int removedValue = getFront().getValue(); //Se obtiene el valor que será eliminado
        setFront(getFront().getNext()); //Se elimina el primer elemento al cambiar las referencias
        if (getFront() == null) {   //en caso de quedar vacia la cola, rear debe serr null tambien
            rear = null;
        }
        return removedValue;
    }
    
    @Override
    protected void displayElements(BaseNode current) {
        System.out.println("Elementos en la cola \nPrimero en Salir");
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
        System.out.println("Último en salir.");
    }


    public BaseNode getRear() {
        return rear;
    }

    public void setRear(BaseNode rear) {
        this.rear = rear;
    }
}
