package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.entidades.*;

import co.edu.uniquindio.proyecto.repositorios.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaTest {

    @Autowired
    private FacturaRepo facturaRepo;
    @Autowired
    private EmpleadoRepo  empleadoRepo;
    @Autowired
    private ClienteRepo  clienteRepo;


    @Test
    @Sql("classpath:Factura.sql")
    public void registrarTest() {
        Date fechaActual = new Date();
        Cliente cliente = clienteRepo.findById("1").orElse(null);
        Empleado empleado = empleadoRepo.findByCorreoAndContrasenia("empleado3@correo.com","confidential789").orElse(null);
        ArrayList<Detalle_Factura> productos = new ArrayList<>();

        Factura factura = new Factura(fechaActual, 150000, cliente,empleado,Tipo_Factura.ELECTRONICA, productos);
        Factura factura2 = facturaRepo.save(factura);
        System.out.println(factura2.getFecha());
        Assertions.assertNotNull(factura2);
    }

    @Test
    @Sql("classpath:Factura.sql")
    public void buscarTest() {
    List<Factura> facturas = facturaRepo.findAll();
    facturas.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Factura.sql")
    public void buscarPorClienteyFechaTest() {
        Date fechaActual = new Date();
        List<Factura> facturas = facturaRepo.findAllByCliente_NombreAndFecha("Cliente 1", fechaActual);
        facturas.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Factura.sql")
    public void buscarPorClientet() {
        Date fechaActual = new Date();
        List<Factura> facturas = facturaRepo.findAllByCliente_Nombre("Cliente 1");
        facturas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:Factura.sql")
    public void buscarPorFechaTest() {
        Date fechaActual = new Date();
        List<Factura> facturas = facturaRepo.findAllByFecha( fechaActual);
        facturas.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Factura.sql")
    public void actualizarTest() {
        Factura factura = facturaRepo.findByCodigo(1).orElse(null);
        System.out.println("la fecha antigua era: "+ factura.getFecha());
        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();

        // Establecer año, mes y día
        calendar.set( Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.JUNE); // Ten en cuenta que los meses comienzan desde 0 (enero) en Calendar
        calendar.set(Calendar.DAY_OF_MONTH, 14);

        factura.setFecha(calendar.getTime());

        Factura factura1 = facturaRepo.save(factura);
        System.out.println("la fecha nueva es: "+factura1.getFecha());
    }
    @Test
    @Sql("classpath:Factura.sql")
    public void eliminarTest() {
        Factura factura = facturaRepo.findByCodigo(1).orElse(null);
        facturaRepo.delete(factura);
        Factura buscado = facturaRepo.findByCodigo(1).orElse(null);
        Assertions.assertNull(buscado);
    }

}
