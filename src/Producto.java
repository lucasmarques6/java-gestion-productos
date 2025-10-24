public class Producto {

  private static int nextId = 1;

  private int id;
  private String nombre;
  private double precio;
  private String descripcion;
  private String categoria;

  public Producto(String nombre, double precio, String descripcion, String categoria) {
    this.id = Producto.nextId;
    Producto.nextId++;
    this.nombre = nombre;
    this.precio = precio;
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

  public int getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    if (precio <= 0) {
      System.out.println("El precio debe ser mayor a cero, no se modifico nada");
      return;
    }
    this.precio = precio;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    if (descripcion.length() > 500) {
      System.out.println("El limite de caracteres es 500, no se modifico la descripcion");
      return;
    }
    this.descripcion = descripcion;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public boolean coincideId(int id) {
    return this.id == id;
  }
  
  @Override
  public String toString() {
    return String.format("Producto{id=%d, nombre='%s', precio=%.2f, categoria='%s'}", 
                        id, nombre, precio, categoria);
  }
  
  // === METODOS ESTATICOS PARA GESTION DE PRODUCTOS ===
  
  public static void crearProducto(java.util.ArrayList<Producto> productos, java.util.Scanner entrada) {
    System.out.println("Creando Nuevo Producto");
    entrada.nextLine(); // Limpiar el buffer
    
    System.out.print("Ingrese el nombre del nuevo producto: ");
    String nombre = entrada.nextLine();
    
    System.out.print("Ingrese el precio del producto: $");
    double precio = entrada.nextDouble();
    entrada.nextLine(); // Limpiar el buffer después del nextDouble()
    
    System.out.print("Ingrese la descripción del producto: ");
    String descripcion = entrada.nextLine();
    
    System.out.print("Ingrese la categoría del producto: ");
    String categoria = entrada.nextLine();
    
    productos.add(new Producto(nombre, precio, descripcion, categoria));

    System.out.println("Producto creado con éxito!");
  }
  
  public static void listarProductos(java.util.ArrayList<Producto> productos) {
    System.out.println("==============================================================================================");
    System.out.println("                                  LISTA DE PRODUCTOS TECNOLÓGICOS                             ");
    System.out.println("==============================================================================================");

    if (productos == null || productos.isEmpty()) {
      System.out.println("No hay productos para mostrar.");
    } else {
      System.out.printf("| %-3s | %-35s | %-10s | %-20s | %-15s |%n",
              "ID", "Nombre", "Precio", "Categoría", "Descripción");
      System.out.println("----------------------------------------------------------------------------------------------");

      for (Producto producto : productos) {
        System.out.printf("| %3d | %-35s | $%9.2f | %-20s | %-15s |%n",
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCategoria(),
                acortarDescripcion(producto.getDescripcion(), 15));
      }
    }

    System.out.println("==============================================================================================");
  }
  
  public static void buscarProductoPorNombre(java.util.ArrayList<Producto> productos, java.util.Scanner entrada) {
    entrada.nextLine(); // Limpiar el buffer
    System.out.print("Ingrese el nombre del producto a buscar: ");
    String busqueda = entrada.nextLine();
    java.util.ArrayList<Producto> productosEncontrados = new java.util.ArrayList<>();

    for (Producto producto : productos) {
      if (estaIncluido(producto.getNombre(), busqueda)) {
        productosEncontrados.add(producto);
      }
    }

    if (productosEncontrados.isEmpty()) {
      System.out.println("No se encontraron productos con el nombre: " + busqueda);
    } else {
      System.out.println("Productos encontrados:");
    }
    listarProductos(productosEncontrados);
  }
  
  public static void filtroPorPrecio(java.util.List<Producto> productos, java.util.Scanner entrada) {
    System.out.print("Ingrese el precio máximo para filtrar: $");
    double precioFiltro = entrada.nextDouble();

    java.util.ArrayList<Producto> productosFiltrados = new java.util.ArrayList<>();

    for (Producto producto : productos) {
      if (producto.getPrecio() <= precioFiltro) {
        productosFiltrados.add(producto);
      }
    }

    System.out.println("Productos con precio menor o igual a $" + precioFiltro + ":");
    listarProductos(productosFiltrados);
  }
  
  public static Producto obtenerProductoPorId(java.util.List<Producto> productos, java.util.Scanner entrada) {
    System.out.print("Ingrese el ID del producto: ");
    int idBusqueda = entrada.nextInt();

    for (Producto producto : productos) {
      if (producto.coincideId(idBusqueda)) {
        return producto;
      }
    }

    System.out.println("No pudimos encontrar el producto con el ID: " + idBusqueda);
    return null;
  }
  
  public static void editarProducto(java.util.List<Producto> productos, java.util.Scanner entrada) {
    Producto producto = obtenerProductoPorId(productos, entrada);
    
    if (producto == null) {
      System.out.println("No se puede editar el producto.");
      return;
    }

    String nombreOriginal = producto.getNombre();
    System.out.println("Producto a editar:");
    System.out.println(nombreOriginal);
    
    entrada.nextLine(); // Limpiar el buffer
    System.out.print("Ingrese el nuevo nombre: ");
    String nuevoNombre = entrada.nextLine();

    producto.setNombre(nuevoNombre);

    System.out.printf("El nombre del producto cambió de '%s' a '%s'%n", nombreOriginal, nuevoNombre);
  }
  
  public static void borrarProducto(java.util.List<Producto> productos, java.util.Scanner entrada) {
    Producto producto = obtenerProductoPorId(productos, entrada);
    
    if (producto == null) {
      System.out.println("No pudimos borrar el producto");
      return;
    }
    
    String nombreOriginal = producto.getNombre();
    System.out.println("Producto a borrar:");
    System.out.println(nombreOriginal);

    productos.remove(producto);
    System.out.println("Producto borrado exitosamente!");
  }
  
  // =============== METODOS AUXILIARES ===============
  
  private static String acortarDescripcion(String descripcion, int maxLength) {
    if (descripcion.length() <= maxLength) {
      return descripcion;
    } else {
      return descripcion.substring(0, maxLength - 3) + "...";
    }
  }
  
  private static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);
    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }

  private static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }
  
}