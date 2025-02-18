package com.mycompany.linearStructure;

public abstract class AbstractLinearStructure {

    private BaseNode front; // Nodo base común

    public AbstractLinearStructure() {
        this.front = null;
    }


    public abstract Integer removeValue();  // Para eliminar un elemento

    // Este método se deja abstracto para que las subclases lo implementen
    protected abstract void displayElements(BaseNode current);

    // Método para ver el primer elemento (común para cola simple y pila) Cola con prioridad sobreescribe el metodo
    public void peek() {
        if (front == null) {
            System.out.println("La estructura está vacía.");
        } else {
            System.out.println("Primer elemento de la estructura: " + front.getValue());
        }
    }

    // Método para verificar si la estructura está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Método para contar el tamaño de la estructura    
    public int size() {
        int size = 0;
        BaseNode current = front;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

     // Método común para mostrar todos los elementos
    public void display() {
        if (front == null) {
            System.out.println("La estructura está vacía.");
            return;
        }
        BaseNode current = front;
        displayElements(current); // Llamamos al método que las subclases deben implementar
    }


    public BaseNode getFront() {
        return front;
    }

    public void setFront(BaseNode front) {
        this.front = front;
    }
}
