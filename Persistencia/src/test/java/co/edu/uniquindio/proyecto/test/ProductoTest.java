package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Proveedor;

import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProveedorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private ProveedorRepo proveedorRepo;

    @Test
    @Sql("classpath:Producto.sql")

   // @Sql("classpath:Proveedor.sql")
    public void registrarTest() {

        Proveedor proveedor = proveedorRepo.findByDocumento("1").orElse(null);



        Producto producto = new Producto(6,"caiman",13.000,15.000,Categoria.ACCESORIOS_BELLEZA,proveedor,15);
        Producto   productoGuardado = productoRepo.save(producto);
        System.out.println(productoGuardado.getNombre());
        Assertions.assertNotNull(productoGuardado);
    }
    @Test
    @Sql("classpath:Producto.sql")
    public void eliminarTest() {
        ;
        Producto productos = productoRepo.findById(1).orElse(null);
        productoRepo.delete(productos);
        Producto buscado = productoRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);

    }
    @Test
    @Sql("classpath:Producto.sql")
    public void listarTest() {

        List<Producto> lista = productoRepo.findAll();

        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:Producto.sql")
    public void listarPorCategoriaTest() {

        List<Producto> lista = productoRepo.findAllByCategoria(Categoria.MAQUILLAJE);

        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Producto.sql")
    public void listarPorNombreTest() {

        Optional<Producto> p = productoRepo.findByNombre("Producto 4");
        System.out.println(p);

    }
    @Test
    @Sql("classpath:Producto.sql")
    public void listarPorNombreyCodigoYCategoriaTest() {

        Optional<Producto> p = productoRepo.findByNombreAndAndCodigoAndCategoria("Producto 4",4,Categoria.CUIDADO_PIEL);
        System.out.println(p);

    }
}
