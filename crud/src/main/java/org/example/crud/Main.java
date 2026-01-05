package org.example.crud;

import entidad.Producto;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        // Ejercicio de CRUD
        System.out.println("=====================================");
        System.out.println("BIENVENIDO AL SISTEMA DE SUPERMERCADO");
        System.out.println("=====================================");

        HashMap<Integer, Producto> productos = new HashMap<>();
        HashMap<Integer, Producto> carrito = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean cerrar = false;
        int opcion = 0;
        productos.put(1, new Producto("Manzana",250));

        do {
            System.out.println("\nOpciones:");
            System.out.println("\t1. Ver Productos");
            System.out.println("\t2. Agregar Productos");
            System.out.println("\t3. Eliminar Productos");
            System.out.println("\t4. Agregar Productos al Carrito");
            System.out.println("\t5. Ver Carrito");
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
                    System.out.print("Escribe el Id del producto que deseas agregar: ");
                    int idAgregar = Integer.parseInt(sc.nextLine());

                    if (productos.containsKey(idAgregar)) {
                        System.out.println("ERROR: ID existente!");
                    } else {
                        System.out.print("Escribe el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Escribe el precio del producto: ");
                        double precio = Double.parseDouble(sc.nextLine());
                        productos.put(idAgregar, new Producto(nombre, precio));
                        System.out.println("\nProducto agregado correctamente.");
                    }
                    break;
                case 3:
                    System.out.print("Escribe el Id del producto que deseas eliminar: ");
                    int idEliminar = Integer.parseInt(sc.nextLine());

                    if (!productos.containsKey(idEliminar)) {
                        System.out.println("ERROR: ID NO existente!");
                    } else {
                        productos.remove(idEliminar);
                        System.out.println("Producto eliminado correctamente.");
                    }
                    break;
                case 4:
                        System.out.print("Escribe el Id del producto que deseas agregar al carrito: ");
                        int idComprar = Integer.parseInt(sc.nextLine());
                        if (productos.containsKey(idComprar)) {
                            Producto original = productos.get(idComprar);
                            Producto copia = new Producto(original); // CLON

                            carrito.put(idComprar, copia);

                            System.out.println("El producto fue agregado correctamente al carrito");
                        } else {
                            System.out.println("ERROR: El producto no existe");
                        }
                        break;
                case 5:
                    System.out.println("Productos en el carrito:");
                    carrito.forEach((id, producto) -> {
                        System.out.println("Id -> " + id + ", Producto -> " + producto.toString());
                    });
                    break;
                case 6:
                    AtomicInteger unidadesProductos = new AtomicInteger();
                    AtomicReference<Double> valorTotal = new AtomicReference<>(0.0);
                    carrito.forEach((id, producto) -> {
                        unidadesProductos.getAndIncrement();
                        valorTotal.updateAndGet(v -> new Double((double) (v + producto.getPrecio())));
                    });
                    System.out.println("El valor total por " + unidadesProductos + "productos es de: " + valorTotal);
                    break;
                case 7:
                    cerrar = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (!cerrar);
    }
}