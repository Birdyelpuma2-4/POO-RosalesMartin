package ec.edu.epn.poo.lab3;

import java.util.Locale;
import java.util.Scanner;

public class CajaRegistradora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        final double IVA = 0.15;

        // Catálogo en arreglos paralelos (solución provisional: ver Semana 4)
        String[] nombres = {"Cuaderno", "Esfero", "Borrador", "Regla", "Carpeta"};
        double[] precios = {2.50, 0.75, 0.40, 1.20, 3.10};
        int[] stock = {10, 50, 30, 0, 8};
        int[] carrito = new int[nombres.length];   // unidades compradas

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
                System.out.print("No es un entero. Cantidad (1 a 20): ");
                sc.next();                          // descarta el token inválido
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.printf("%-4s %-10s %7s %6s%n",
                            "Cód", "Producto", "Precio", "Stock");
                    for (int i = 0; i < nombres.length; i++) {
                        System.out.printf(Locale.US, "%-4d %-10s %7.2f %6d%n",
                                i + 1, nombres[i], precios[i], stock[i]);
                    }
                }
                case 2 -> {
                    int codigo;
                    do {
                        System.out.print("codigo del producto (1 a 5): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. codigo del producto (1 a 5): ");
                            sc.next();                          // descarta el token inválido
                        }
                        codigo = sc.nextInt();
                        if (codigo < 1 || codigo > 5) {
                            System.out.println("Fuera de rango.");
                        }
                    } while (codigo < 1 || codigo > 5);
                    System.out.println("Producto: " + nombres[codigo - 1]);
                    
                    // TODO 4: pedir la cantidad (> 0). Si hay stock suficiente,
                    //         sumarla a carrito[] y restarla de stock[]
                    int cantidad;
                    do {
                        System.out.print("Cantidad a comprar (> 0): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. Cantidad a comprar (> 0): ");
                            sc.next(); 
                        }
                        cantidad = sc.nextInt();
                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor a 0.");
                        }
                    } while (cantidad <= 0);

                    int indice = codigo - 1;
                    if (cantidad <= stock[indice]) {
                        carrito[indice] += cantidad;
                        stock[indice] -= cantidad;
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("Stock insuficiente (disponible: " + stock[indice] + ")");
                    }
                }
                case 3 -> {
                    // TODO 5 y 6: recorrer el carrito, subtotal, descuento e IVA
                    System.out.println("\n--- RECIBO DE COMPRA ---");
                    System.out.printf("%-10s %6s %8s %8s%n", "Producto", "Cant", "P.Unit", "Total");
                    
                    double subtotal = 0.0;
                    for (int i = 0; i < carrito.length; i++) {
                        if (carrito[i] > 0) {
                            double totalPorProducto = carrito[i] * precios[i];
                            subtotal += totalPorProducto;
                            System.out.printf(Locale.US, "%-10s %6d %8.2f %8.2f%n", 
                                    nombres[i], carrito[i], precios[i], totalPorProducto);
                        }
                    }

                    if (subtotal == 0) {
                        System.out.println("El carrito está vacío.");
                    } else {
                        double porcentajeDescuento = 0.0;
                        if (subtotal >= 100) {
                            porcentajeDescuento = 0.10;
                        } else if (subtotal >= 50) {
                            porcentajeDescuento = 0.05;
                        }

                        double descuento = subtotal * porcentajeDescuento;
                        double subtotalConDescuento = subtotal - descuento;
                        double valorIva = subtotalConDescuento * IVA;
                        double totalPagar = subtotalConDescuento + valorIva;

                        System.out.println("-----------------------------------");
                        System.out.printf(Locale.US, "Subtotal:            $%8.2f%n", subtotal);
                        System.out.printf(Locale.US, "Descuento (%.0f%%):     $%8.2f%n", (porcentajeDescuento * 100), descuento);
                        System.out.printf(Locale.US, "Subtotal con Desc:   $%8.2f%n", subtotalConDescuento);
                        System.out.printf(Locale.US, "IVA (15%%):           $%8.2f%n", valorIva);
                        System.out.printf(Locale.US, "TOTAL A PAGAR:       $%8.2f%n", totalPagar);
                    }
                }
                case 0 -> System.out.println("Gracias por su compra.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}