package com.mycompany.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mycompany.linearStructure.AbstractLinearStructure;
import com.mycompany.linearStructure.PriorityQueue;
import com.mycompany.linearStructure.SimpleQueue;
import com.mycompany.linearStructure.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Instanciación de las tres estructuras
        AbstractLinearStructure simpleQueue = new SimpleQueue();
        AbstractLinearStructure priorityQueue = new PriorityQueue();
        AbstractLinearStructure stack = new Stack();
        AbstractLinearStructure currentQueue = null; // Estructura lineal actual (cola o pila)
        String typeStructure[]={"","Cola Simple", "Cola con Prioridad", "Pila (Stack)"};

        do {

            // Menú principal para seleccionar la estructura
            System.out.println("\nSeleccione la estructura de datos:");
            System.out.println("1. "+typeStructure[1]);
            System.out.println("2. "+typeStructure[2]);
            System.out.println("3. "+typeStructure[3]);
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int mainChoice;
            try {
                mainChoice = scanner.nextInt(); // Intentamos leer un valor entero
                // mainChoice = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario no ingresa un número entero
                System.out.println("¡Error! Debes ingresar un número entero.");
                scanner.nextLine(); // Limpiamos el buffer del scanner
                continue; // Volvemos a pedir la opción sin continuar con el resto del código
            }

            if (mainChoice == 4) { // Elección de terminar ejecución app
                System.out.println("Saliendo...");
                break;
            }

            // Establecer la estructura actual
            if (mainChoice == 1) {
                currentQueue = simpleQueue;
            } else if (mainChoice == 2) {
                currentQueue = priorityQueue;
            } else if (mainChoice == 3) {
                currentQueue = stack;
            } else {
                System.out.println("Opción inválida, intente nuevamente.");
                continue;
            }

            int operation=0;
            // Menú de operaciones
            do {

                System.out.println("\nOperaciones en " + typeStructure[mainChoice]);
                System.out.println("1. Agregar elemento");
                System.out.println("2. Eliminar elemento");
                System.out.println("3. Mostrar primer elemento");
                System.out.println("4. Verificar si la estructura está vacía");
                System.out.println("5. Obtener tamaño");
                System.out.println("6. Mostrar todos los elementos");
                System.out.println("7. Regresar al menú principal");
                System.out.print("Opción: ");
                //operation = Integer.parseInt(scanner.nextLine());
                try {
                    operation = scanner.nextInt(); // Intentamos leer un valor entero
                    // mainChoice = Integer.parseInt(scanner.nextLine());
                } catch (InputMismatchException e) {
                    // Captura la excepción si el usuario no ingresa un número entero
                    System.out.println("¡Error! Debes ingresar un número entero.");
                    scanner.nextLine(); // Limpiamos el buffer del scanner
                    continue; // Volvemos a pedir la opción sin continuar con el resto del código
                }


                switch (operation) {
                    case 1:
                        int value;
                        System.out.print("Ingrese un valor para agregar: ");                        
                        try {
                            value = scanner.nextInt(); // Intentamos leer un valor entero
                            // mainChoice = Integer.parseInt(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            // Captura la excepción si el usuario no ingresa un número entero
                            System.out.println("¡Error! Debes ingresar un número entero.");
                            scanner.nextLine(); // Limpiamos el buffer del scanner
                            break; // Volvemos a pedir la opción sin continuar con el resto del código
                        }
                        
                        if (currentQueue instanceof SimpleQueue){
                            ((SimpleQueue) currentQueue).addValue(value);
                        }else if (currentQueue instanceof Stack){
                            ((Stack) currentQueue).addValue(value);
                        }else if (currentQueue instanceof PriorityQueue){
                            int priority;
                            try {
                                System.out.print("Ingrese un valor de prioridad: ");
                                priority = scanner.nextInt(); // Intentamos leer un valor entero
                                // mainChoice = Integer.parseInt(scanner.nextLine());
                            } catch (InputMismatchException e) {
                                // Captura la excepción si el usuario no ingresa un número entero
                                System.out.println("¡Error! Debes ingresar un número entero.");
                                scanner.nextLine(); // Limpiamos el buffer del scanner
                                break; // Volvemos a pedir la opción sin continuar con el resto del código
                            }
                            ((PriorityQueue) currentQueue).addValuePriority(value, priority);
                        }
                        break;
                    case 2:
                        Integer removedValue = currentQueue.removeValue();
                        if( removedValue instanceof Integer){
                            System.out.println("Se a eliminado el primer elemento con valor: "+ removedValue);
                        }else if (removedValue==null){
                            System.out.println("No se ha eliminado el primer elemento debido a que la estructura está vacía");
                        }                        
                        break;
                    case 3:
                        currentQueue.peek();
                        break;
                    case 4:
                        System.out.println("¿Está vacía la estructura? " + (currentQueue.isEmpty() ? "Sí" : "No"));
                        break;
                    case 5:
                        System.out.println("Tamaño de la estructura: " + currentQueue.size());
                        break;
                    case 6:
                        currentQueue.display();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } while (operation!=7);

        } while (true);

        scanner.close();

    }
}
