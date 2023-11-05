package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.entidades.*;


import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProveedorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProveedorTest {
    @Autowired
    private ProveedorRepo proveedorRepo;
    @Autowired
    private ProductoRepo productoRepo;
    @Test
    @Sql("classpath:Proveedor.sql")
    public void registrarTest() {
        List<Producto> productos = new ArrayList<>();
        Proveedor proveedor = new Proveedor("1001017577", "Juan Pablo", "reserva de la pastortia", "yutu6d1@hotmail.com","3219811230",Tipo_Documento.CEDULA_CIUDADANIA, productos);

       Proveedor proveedorGuardado = proveedorRepo.save(proveedor);
        System.out.println(proveedor.getProductos());
        Assertions.assertNotNull(proveedorGuardado);
    }
    @Test
    @Sql("classpath:Proveedor.sql")
    public void ActualizarTest() {
        Proveedor proveedor1 = proveedorRepo.findByDocumento("1").orElse(null);
        System.out.println(proveedor1.getProductos());
        List<Producto> p = new ArrayList<>();
        Producto producto = productoRepo.findById(4).orElse(null);
        producto.setProveedor(proveedor1);
        productoRepo.save(producto);
        Producto producto2 = productoRepo.findById(2).orElse(null);
        producto2.setProveedor(proveedor1);

        productoRepo.save(producto2);

        proveedor1.getProductos().add(producto);
        proveedor1.getProductos().add(producto2);
        System.out.println(proveedor1.getProductos().get(1).getProveedor().getNombre());
        System.out.println(proveedor1.getProductos().get(2).getProveedor().getNombre());
        proveedorRepo.save(proveedor1);
        System.out.println(proveedor1.getProductos());

    }
    @Test
    @Sql("classpath:Proveedor.sql")
    public void eliminarTest() {

        Proveedor proveedor = proveedorRepo.findByDocumento("1").orElse(null);
        proveedorRepo.delete(proveedor);
        Proveedor buscado = proveedorRepo.findByDocumento("1").orElse(null);
        Assertions.assertNull(buscado);

    }
    @Test
    @Sql("classpath:Proveedor.sql")
    public void listarPorCategoriaTest() {

        List<Proveedor> lista = proveedorRepo.findAllByTipoDocumento(Tipo_Documento.CEDULA_CIUDADANIA);

        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Proveedor.sql")
    public void listarPorNombreTest() {

        List<Proveedor> lista = proveedorRepo.findAllByNombre("Proveedor 1");

        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Proveedor.sql")
    public void listarPorCorreoTest() {

        Proveedor lista = proveedorRepo.findByCorreo("proveedor2@correo.com").orElse(null);

        System.out.println(lista);
    }
    @Test
    @Sql("classpath:Proveedor.sql")
    public void listarPorNombreDocumentoCorreoTest() {

        Proveedor lista = proveedorRepo.findByNombreAndDocumentoAndCorreo("Proveedor 1","2","proveedor2@correo.com").orElse(null);

        System.out.println(lista);
    }
}
