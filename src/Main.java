import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Producto> productosDB = obtenerProductosTecnologicos();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido a la app de compras");
        label:
        while (true) {
            System.out.println("Ingrese el número equivalente a la opción:");
            System.out.println("0 - Finaliza el programa");
            System.out.println("1 - Crea un Producto");
            System.out.println("2 - Listar Productos");
            System.out.println("3 - Búsqueda por nombre");
            System.out.println("4 - Editar nombre producto");
            System.out.println("5 - Borrar producto");
            System.out.println("6 - Filtro por precio");
            
            int opcionUsuario = entrada.nextInt();

            switch (opcionUsuario) {
                case 1:
                    Producto.crearProducto(productosDB, entrada);
                    pausa();
                    break;
                case 2:
                    Producto.listarProductos(productosDB);
                    pausa();
                    break;
                case 3:
                    Producto.buscarProductoPorNombre(productosDB, entrada);
                    pausa();
                    break;
                case 4:
                    Producto.editarProducto(productosDB, entrada);
                    pausa();
                    break;
                case 5:
                    Producto.borrarProducto(productosDB, entrada);
                    pausa();
                    break;
                case 6:
                    Producto.filtroPorPrecio(productosDB, entrada);
                    pausa();
                    break;
                case 0:
                    System.out.println("Gracias por usar la app!");
                    break label;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo");
                    break;
            }
        }
    }

    // =============== MÉTODOS AUXILIARES ===============
    
    public static void pausa() {
        System.out.println("Pulse ENTER para continuar...");
        entrada = new Scanner(System.in);
        entrada.nextLine();
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }
    }

    public static ArrayList<Producto> obtenerProductosTecnologicos() {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(
                "Remera",
                1899.99,
                "Comoda remera de algodón para uso diario.",
                "Ropa"));

        productos.add(new Producto(
                "Pantalón",
                99.99,
                "Pantalón de mezclilla cómodo y duradero.",
                "Ropa"));

        productos.add(new Producto(
                "Buzo con capucha",
                179.99,
                "Buzo con capucha de felpa suave y cálido.",
                "Ropa"));

        productos.add(new Producto(
                "Zapatillas deportivas Nike Air Max",
                499.99,
                "Zapatillas deportivas de alto rendimiento con tecnología de amortiguación.",
                "Calzado"));

        productos.add(new Producto(
                "Cinturón de cuero Fossil",
                1199.99,
                "Cinturón de cuero genuino con hebilla de metal.",
                "Accesorios"));

        productos.add(new Producto(
                "Remera deportiva Adidas",
                1399.99,
                "Remera deportiva de alto rendimiento con tecnología de absorción de humedad.",
                "Ropa"));

        productos.add(new Producto(
                "Bermuda cargo Columbia",
                79.99,
                "Bermuda cargo de secado rápido con múltiples bolsillos.",
                "Ropa"));

        productos.add(new Producto(
                "Cartera Michael Kors",
                69.99,
                "Cartera de cuero sintético con diseño elegante y moderno.",
                "Accesorios"));

        productos.add(new Producto(
                "Campera de lluvia The North Face",
                39.99,
                "Campera de lluvia ligera y resistente al agua.",
                "Ropa"));

        productos.add(new Producto(
                "Saco de lana",
                349.99,
                "Saco de lana de alta calidad, ideal para climas fríos.",
                "Ropa"));

        return productos;
    }

}