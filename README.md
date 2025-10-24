# 🛒 Sistema de Gestión de Productos en Java

Una aplicación de consola desarrollada en Java para gestionar un inventario de productos tecnológicos con funcionalidades CRUD completas.

## 📋 Características

- ✅ **Crear productos** - Agregar nuevos productos al inventario
- ✅ **Listar productos** - Visualizar todos los productos en formato tabla
- ✅ **Buscar productos** - Búsqueda por nombre (parcial o completo)
- ✅ **Editar productos** - Modificar el nombre de productos existentes
- ✅ **Eliminar productos** - Remover productos del inventario
- ✅ **Filtrar por precio** - Mostrar productos dentro de un rango de precio

## 🏗️ Estructura del Proyecto

```
src/
├── Main.java          # Clase principal con la interfaz de usuario
└── Producto.java      # Clase modelo con gestión de productos
```

## 🚀 Cómo ejecutar

### Prerequisitos
- Java JDK 8 o superior
- Terminal/Consola

### Compilación y ejecución

```bash
# Clonar el repositorio
git clone https://github.com/lucasmarques6/java-gestion-productos.git
cd java-gestion-productos

# Compilar
javac src/*.java

# Ejecutar
java -cp src Main
```

## 🎮 Uso

Al ejecutar la aplicación, verás un menú interactivo:

```
Bienvenido a la app de compras
Ingrese el número equivalente a la opción:
0 - Finaliza el programa
1 - Crea un Producto
2 - Listar Productos
3 - Búsqueda por nombre
4 - Editar nombre producto
5 - Borrar producto
6 - Filtro por precio
```

## 🏛️ Arquitectura

### Clase `Producto`
- **Atributos**: ID, nombre, precio, descripción, categoría
- **Encapsulación**: Getters y setters con validaciones
- **ID autoincrementable**: Sistema de identificación único
- **Métodos estáticos**: Gestión completa del CRUD

### Clase `Main`
- **Interfaz de usuario**: Menú interactivo por consola
- **Coordinación**: Llama a los métodos de la clase Producto
- **Datos iniciales**: Carga productos de ejemplo

## 💡 Conceptos de POO Implementados

- **Encapsulación**: Atributos privados con métodos de acceso
- **Cohesión**: Métodos relacionados agrupados en la clase correspondiente
- **Separación de responsabilidades**: UI en Main, lógica en Producto
- **Validaciones**: Control de datos en setters
- **Métodos estáticos**: Operaciones a nivel de clase

## 🛠️ Tecnologías Utilizadas

- Java 8+
- Scanner para entrada de usuario
- ArrayList para manejo de colecciones
- String manipulation y formatting

## 📊 Datos de Ejemplo

La aplicación incluye 10 productos tecnológicos predefinidos:
- Laptops, smartphones, tablets
- Accesorios y periféricos
- Componentes de hardware
- Dispositivos de audio

## 🔄 Futuras Mejoras

- [ ] Persistencia en archivos
- [ ] Interfaz gráfica (JavaFX/Swing)
- [ ] Base de datos
- [ ] API REST
- [ ] Tests unitarios
- [ ] Validaciones más robustas
- [ ] Categorías dinámicas

## 👤 Autor

**Lucas Marques**
- GitHub: [@lucasmarques6](https://github.com/lucasmarques6)

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

⭐ Si te gusta este proyecto, ¡dale una estrella en GitHub!