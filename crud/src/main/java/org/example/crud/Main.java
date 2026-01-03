package org.example.crud;

import entidad.Producto;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ejercicio de CRUD
        System.out.println("=====================================");
        System.out.println("BIENVENIDO AL SISTEMA DE SUPERMERCADO");
        System.out.println("=====================================");

        HashMap<Integer, Producto> productos = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean cerrar = false;
        int opcion = 0;
        productos.put(1, new Producto("Manzana",250));

        do {
            System.out.println("\nOpciones:");
            System.out.println("\t1. Ver Productos");
            System.out.println("\t2. Agregar Productos");
            System.out.println("\t3. Eliminar Productos");
            System.out.println("\t4. Ver Productos");
            System.out.println("\t5. Agregar Productos al Carrito");
            System.out.println("\t6. Facturar");
            System.out.println("\t7. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1:
                    productos.forEach((id, producto) -> {
                        System.out.println("Id -> " + id + ", Producto -> " + producto.toString());
                    });
                    break;
                case 2:
                    System.out.print("Escribe el Id del producto que deseas agreagar: ");
                    Integer idAgregar = Integer.parseInt(sc.nextLine());
                    productos.forEach((id, producto) -> {
                        if (idAgregar.equals(id)) {
                            System.out.println("ERROR: ID Existente!");
                        }
                    });
                case 7:
                    cerrar = true;
                default:
                    System.out.println("Opción inválida");
            }
        } while (!cerrar);
    }
}