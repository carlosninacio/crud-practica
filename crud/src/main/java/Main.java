import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        // Ejercicio de CRUD
        System.out.println("=====================================");
        System.out.println("BIENVENIDO AL SISTEMA DE SUPERMERCADO");
        System.out.println("=====================================");

        HashMap<String, Integer> productos = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("\nOpciones:");
        System.out.println("\t1. Ver Productos");
        System.out.println("\t2. Agregar Productos");
        System.out.println("\t3. Eliminar Productos");
        System.out.println("\t4. Ver Productos");
    }
}