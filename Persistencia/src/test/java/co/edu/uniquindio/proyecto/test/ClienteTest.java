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



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;
    @Test
    @Sql("classpath:Cliente.sql")
    public void registrarTest() {

        Cliente cliente = new Cliente("6","Juan","del","voerpf","sdfsdfs","131232",Tipo_Documento.CEDULA_CIUDADANIA);
        Cliente clienteG = clienteRepo.save(cliente);
        System.out.println(clienteG.getNombre());
        Assertions.assertNotNull(clienteG);
    }
    @Test
    @Sql("classpath:Cliente.sql")
    public void buscarTest() {
        List<Cliente> cliente = clienteRepo.findAll();
        cliente.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Cliente.sql")
    public void buscarNombreTest() {
        List<Cliente> cliente = clienteRepo.findAllByNombre("Cliente 4");
        cliente.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:Cliente.sql")
    public void buscarTipoDocumentoTest() {
        List<Cliente> cliente = clienteRepo.findAllByTipoDocumento(Tipo_Documento.CEDULA_CIUDADANIA);
        cliente.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:Cliente.sql")
    public void actualizarTest() {
        Cliente cliente = clienteRepo.findById("1").orElse(null);
        System.out.println(cliente.getNombre());
        cliente.setNombre("roxana");
        Cliente clienteG = clienteRepo.save(cliente);
        System.out.println(clienteG.getNombre());
    }
}
