package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.entidades.*;

import co.edu.uniquindio.proyecto.repositorios.*;

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
public class EmpleadoTest {
    @Autowired
    private EmpleadoRepo empleadoRepo;


    @Test
    @Sql("classpath:Empleado.sql")
    public void registrarTest() {

        Empleado empleado = new Empleado("6","Juan Pablo","Delgado","reserva de la pastorita", "yutu6d1@hotmail.com","3218711239","JuanPablo1",Tipo_Documento.CEDULA_CIUDADANIA);
    Empleado empleadoGuardado = empleadoRepo.save(empleado);
        System.out.println(empleadoGuardado.getNombre());
        Assertions.assertNotNull(empleadoGuardado);
    }
    @Test
    @Sql("classpath:Empleado.sql")
    public void BuscarTest() {

        List<Empleado> empleados = empleadoRepo.findAll();
        empleados.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:Empleado.sql")
    public void Login() {

        Empleado empleados = empleadoRepo.findByCorreoAndAndContrasenia("empleado3@correo.com","confidential789").orElse(null);
      System.out.println(empleados);
    }

    @Test
    @Sql("classpath:Empleado.sql")
    public void BuscarNombreTest() {

        List<Empleado> empleados = empleadoRepo.findAllByNombre("Juan");
        empleados.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Empleado.sql")
    public void BuscarNombreIdCorreo () {

        Empleado empleados = empleadoRepo.findByNombreAndIdAndCorreo("Juan","1", "empleado1@correo.com").orElse(null);
        System.out.println(empleados);
    }
    @Test
    @Sql("classpath:Empleado.sql")
    public void BuscarCorreo () {

        Empleado empleados = empleadoRepo.findByCorreo( "empleado1@correo.com").orElse(null);
        System.out.println(empleados);
    }
    @Test
    @Sql("classpath:Empleado.sql")
    public void Actualizar () {

        Empleado empleados = empleadoRepo.findById( "1").orElse(null);

        System.out.println(empleados.getTelefono());

        empleados.setCorreo("yutu6d1@hotmail.com");

        Empleado empleadoActua = empleadoRepo.save(empleados);
        System.out.println(empleadoActua.getCorreo());

    }
    @Test
    @Sql("classpath:Empleado.sql")
    public void eliminarTest() {

        Empleado empleados = empleadoRepo.findById( "1").orElse(null);
        empleadoRepo.delete( empleados);
        Empleado buscado= empleadoRepo.findById( "1").orElse(null);
        Assertions.assertNull(buscado);

    }
}
