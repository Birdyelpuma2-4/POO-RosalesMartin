package ec.edu.epn.poo.lab4;
 
import java.util.Locale;
import java.util.Scanner;
 
public class CajaRegistradora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        final double IVA = 0.15;
 
        // Catálogo: un arreglo de objetos (cada producto es una sola cosa)
        Producto[] catalogo = {
        		new Producto("Cuaderno", 2.50, 10, "Papelería"),
        	    new Producto("Esfero", 0.75, 50, "Escritura"),
        	    new Producto("Borrador", 0.40, 30, "Papelería"),
        	    new Producto("Regla", 1.20, 0, "Papelería"),
        	    new Producto("Carpeta", 3.10, 8, "Organización")
        };
        int[] carrito = new int[catalogo.length];   // unidades compradas
 
        int opcion;
        do {
            System.out.println();
            System.out.println("=== CAJA REGISTRADORA ===");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver recibo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número de opción: ");
                sc.next();
            }
            opcion = sc.nextInt();
 
            switch (opcion) {
                case 1 -> {
                	 System.out.println(
                		        "\n=== CATALOGO DE PRODUCTOS ===");

                	 System.out.printf(
                		        "%-4s %-10s %8s %6s %-15s%n",
                		        "Cod", "Producto", "Precio", "Stock", "Categoria");

                	 for (int i = 0; i < catalogo.length; i++) {

                		        Producto p = catalogo[i];

                		        System.out.printf(
                		            Locale.US,
                		            "%-4d %-10s %8.2f %6d %-15s%n",
                		            i + 1,
                		            p.nombre,
                		            p.precio,
                		            p.stock,
                		            p.categoria);
                		    } 
                }
                          
                case 2 -> {
                    int codigo;
                    do {
                        System.out.print("Código (1 a " + catalogo.length
                                + "): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. Código: ");
                            sc.next();
                        }
                        codigo = sc.nextInt();
                    } while (codigo < 1 || codigo > catalogo.length);
                    
                    int cantidad;
                    do {
                        System.out.print("Cantidad: ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. Cantidad: ");
                            sc.next();
                        }
                        cantidad = sc.nextInt();
                    } while (cantidad <= 0);
                    
                    int indice = codigo - 1;
                    if (cantidad <= catalogo[indice].stock) {
                        carrito[indice] += cantidad;
                        catalogo[indice].stock -= cantidad;
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("Stock insuficiente (disponible: " + catalogo[indice].stock + ")");
                    }

    
                }
                case 3 -> {
                    double subtotal = 0;
                    System.out.println("------------ RECIBO ------------");
                    System.out.printf("%-10s %6s %8s %8s%n", "Producto", "Cant", "P.Unit", "Total");
                    
                    for (int i = 0; i < carrito.length; i++) {
                        if (carrito[i] > 0) {
                            double totalPorProducto = carrito[i] * catalogo[i].precio;
                            subtotal += totalPorProducto;
                            System.out.printf(Locale.US, "%-10s %3d x %5.2f %8.2f%n", 
                                    catalogo[i].nombre, carrito[i], catalogo[i].precio, totalPorProducto);
                        }
                    }

                    double porcentaje;
                    if (subtotal >= 100) {
                        porcentaje = 0.10;
                    } else if (subtotal >= 50) {
                        porcentaje = 0.05;
                    } else {
                        porcentaje = 0.0;
                    }
                    double descuento = subtotal * porcentaje;
                    double iva = (subtotal - descuento) * IVA;
                    double total = subtotal - descuento + iva;
                    System.out.println("--------------------------------");
                    System.out.printf(Locale.US, "%-23s %8.2f%n",
                            "Subtotal", subtotal);
                    System.out.printf(Locale.US, "%-23s %8.2f%n",
                            "Descuento", descuento);
                    System.out.printf(Locale.US, "%-23s %8.2f%n",
                            "IVA 15 %", iva);
                    System.out.printf(Locale.US, "%-23s %8.2f%n",
                            "TOTAL", total);
                }
                case 0 -> System.out.println("Gracias por su compra.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
