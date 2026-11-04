package ec.edu.epn.poo.lab4;

import java.util.Locale;

public class OrdenarCatalogo {

    public static void main(String[] args) {

        Producto[] catalogo = {
        		new Producto("Cuaderno", 2.50, 10, "Papelería"),
        	    new Producto("Esfero", 0.75, 50, "Escritura"),
        	    new Producto("Borrador", 0.40, 30, "Papelería"),
        	    new Producto("Regla", 1.20, 0, "Papelería"),
        	    new Producto("Carpeta", 3.10, 8, "Organización")
        };

        int intercambios = 0;

        // Ordenamiento burbuja por precio
        for (int i = 0; i < catalogo.length - 1; i++) {
            for (int j = 0; j < catalogo.length - 1 - i; j++) {

                if (catalogo[j].precio >
                        catalogo[j + 1].precio) {

                    Producto t = catalogo[j];
                    catalogo[j] = catalogo[j + 1];
                    catalogo[j + 1] = t;

                    intercambios++;
                }
            }
        }

        System.out.println(
            "=== CATALOGO ORDENADO POR PRECIO ===");

        System.out.printf(
            "%-10s %8s %6s%n",
            "Producto", "Precio", "Stock");

        // Recorrido con for-each
        for (Producto p : catalogo) {
            System.out.printf(
                Locale.US,
                "%-10s %8.2f %6d%n",
                p.nombre, p.precio, p.stock);
        }

        System.out.println(
            "Total de intercambios: " + intercambios);
    }
}
