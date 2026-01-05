package entidad;

public class Producto {
    String nombre;
    double precio;

    public Producto (String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Constructor copia
    public Producto(Producto p) {
        this.nombre = p.nombre;
        this.precio = p.precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Precio: " + precio;
    }
}