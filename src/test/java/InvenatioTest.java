

import static org.junit.jupiter.api.Assertions.*;

import org.example.Inventario;
import org.example.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

class InventarioTest {
    private Inventario inventario;
    private Producto productoMock;

    @BeforeEach
    void setUp() {
        inventario = new Inventario();
        productoMock = Mockito.mock(Producto.class);
        Mockito.when(productoMock.getId()).thenReturn(1);
        Mockito.when(productoMock.getNombre()).thenReturn("TestProducto");
        Mockito.when(productoMock.getPrecio()).thenReturn(10.0);
    }

    @Test
    void agregarProducto() {
        inventario.agregarProducto(productoMock);
        List<Producto> productos = inventario.getProductos();
        assertFalse(productos.isEmpty());
        assertEquals(1, productos.size());
    }

    @Test
    void eliminarProducto() {
        inventario.agregarProducto(productoMock);
        assertTrue(inventario.eliminarProducto(1));
        assertNull(inventario.buscarProducto(1));
    }

    @Test
    void buscarProducto() {
        inventario.agregarProducto(productoMock);
        assertNotNull(inventario.buscarProducto(1));
    }
}

