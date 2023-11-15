package co.edu.uniquindio.proyecto.Controllers;



import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
@Component
public class InventarioController implements Initializable {

    @Autowired
    private SceneController sceneController;
    @Autowired
    ProductoRepo productoRepo;
    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    FacturaRepo facturaRepo;
    @Autowired
    EmpleadoRepo empleadoRepo;

    private Empleado empleadoLogin;

    @Autowired
    Detalle_FacturaRepo detalleFacturaRepo;
    Cliente cliente = new Cliente();
    //Empleado empleado = new Empleado();

    @FXML
    private ImageView fondoImageView;

    @FXML
    private Label inventarioLabel;

    @FXML
    private Label actualizarLabel;

    @FXML
    private Label historialLabel;

    @FXML
    private Label facturasLabel;

    @FXML
    private Label proveedoresLabel;

    @FXML
    private Label cantidadLabel;

    @FXML
    private Label empleadosLabel;

    @FXML
    private Label clientesLabel;

    @FXML
    private Label fechaLabel;

    @FXML
    private Label nombreUsuarioLabel;

    @FXML
    private Label eliminarLabel;

    @FXML
    private Label buscarLabel;

    @FXML
    private TextField correoField;

    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TableView<Carrito> tablaProductos;

    @FXML
    private TableColumn<Carrito, Integer> cantidadColumn;

    @FXML
    private TableColumn<Carrito, String> productoColumn;

    @FXML
    private TableColumn<Carrito, Double> valorUnidadColumn;

    @FXML
    private TableColumn<Carrito, Double> valorTotalColumn;



    @FXML
    private TextField nombreProductoField;

    @FXML
    private TextField totalField;

    @FXML
    private TextField subtotalField;



    @FXML
    private Label agregarLabel;

    @FXML
    private TextField idProductoField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField nombreClienteField;

    @FXML
    private TextField idClienteField;

    @FXML
    private Label descuentoLabel;

    @FXML
    private Label productoLabel;

    @FXML
    private Button FacturaFisicaButton;

    @FXML
    private Button FacturaVirtualButton;

    @FXML
    private TextField CantidadField1;
    ObservableList<Carrito> listaCarrito = FXCollections.observableArrayList();
    List<Carrito> carrito = new ArrayList<>();
    List<Integer> ids = new ArrayList<>();
    List<Detalle_Factura> detalleFacturas = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializetable();

        // Load products
        listaCarrito.addAll(carrito);

        productoLabel.setOnMouseClicked(event -> handleProductoClick(event));
        eliminarLabel.setOnMouseClicked(event -> handleEliminarLabelClick());
        buscarLabel.setOnMouseClicked(event -> handleBuscarLabelClick());
        inventarioLabel.setOnMouseClicked(event -> handleInventarioLabelClick());
        actualizarLabel.setOnMouseClicked(event -> handleActualizarLabelClick());
        historialLabel.setOnMouseClicked(event -> handleHistorialLabelClick(event));
        facturasLabel.setOnMouseClicked(event -> handleFacturasLabelClick(event));
        proveedoresLabel.setOnMouseClicked(event -> handleProveedoresLabelClick(event));
        cantidadLabel.setOnMouseClicked(event -> handleCantidadLabelClick());
        empleadosLabel.setOnMouseClicked(event -> handleEmpleadosLabelClick(event));
        clientesLabel.setOnMouseClicked(event -> handleClientesLabelClick(event));
        agregarLabel.setOnMouseClicked(event -> handleAgregarLabelClick());
        descuentoLabel.setOnMouseClicked(event -> handleDescuentoLabelClick());
        FacturaFisicaButton.setOnAction(event -> handleFacturaFisicaButtonClick());
        FacturaVirtualButton.setOnAction(event -> handleFacturaVirtualButtonClick());

    }
    public int obtenerSiguienteIdFactura() {
        // Obtener todas las facturas ordenadas por el código de manera descendente
        List<Factura> facturasOrdenadas = facturaRepo.findAllByOrderByCodigoDesc();

        // Verificar si hay facturas en la lista
        if (!facturasOrdenadas.isEmpty()) {
            // Obtener el código de la última factura y sumar 1 para obtener el siguiente ID
            int ultimoId = facturasOrdenadas.get(0).getCodigo();
            return ultimoId + 1;
        } else {
            // Si no hay facturas en la base de datos, puedes comenzar desde 1 o manejarlo como desees
            return 1;
        }
    }
   private int obtenerSiguienteIdDetalleFactura() {
        // Obtener todas las facturas ordenadas por el código de manera descendente
        List<Detalle_Factura> facturasOrdenadas = detalleFacturaRepo.findAllByOrderByCodigoDesc();

        // Verificar si hay facturas en la lista
        if (!facturasOrdenadas.isEmpty()) {
            // Obtener el código de la última factura y sumar 1 para obtener el siguiente ID
            int ultimoId = facturasOrdenadas.get(0).getCodigo();
            return ultimoId + 1;
        } else {
            // Si no hay facturas en la base de datos, puedes comenzar desde 1 o manejarlo como desees
            return 1;
        }
    }
    private void handleFacturaFisicaButtonClick() {
        buscarCliente ();
        Tipo_Factura tipoFactura = Tipo_Factura.FISICA;
       Factura factura = GenerarFactura( tipoFactura);
        GenerarDetalles(factura);
        String facturita = "Codigo de la factura:" + factura.getCodigo() + "\n"
                + factura.getFecha() +  "\n" + "Valor Total: " + factura.getValor_total() +"\n" +
               "Cliente: " + factura.getCliente().getNombre() + "Responsable de la venta: " + factura.getEmpleado().getNombre()
                + "\n" + "Tipo de factura: " + factura.getTipoFactura() + concatenarDetalles();
        GuardarFacturfISICA (facturita);
        carrito.clear();
        ids.clear();
        listaCarrito.clear();
        listaCarrito.addAll(carrito);

        mostrarAlerta("La factura ha sido generado con exito" , "Error de entrada", Alert.AlertType.CONFIRMATION);
    }

    private void GuardarFacturfISICA (String contenidoFactura){

        String rutaArchivo = "C:\\Users\\USUARIO\\OneDrive\\Desktop\\Software-3\\Persistencia\\src\\main\\java\\co\\edu\\uniquindio\\proyecto\\Facturas\\factura.txt";

        // Intentar escribir el contenido en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(rutaArchivo)))) {
            writer.write(contenidoFactura);
            System.out.println("Se ha creado el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al escribir en el archivo.");
        }
    }
    private  String concatenarDetalles() {
        StringBuilder resultado = new StringBuilder();

        for (Detalle_Factura detalle : detalleFacturas) {
            resultado.append(detalle.toString()).append("\n");
        }

        return resultado.toString();
    }
    private void GenerarDetalles(Factura factura){
        for (Carrito item : carrito) {
            Producto producto = productoRepo.findByNombre(item.getProducto()).orElse(null);
             Detalle_Factura detalleFactura = new Detalle_Factura(item.getCantindad(), item.getValorUnidad(), factura, producto);
       detalleFacturaRepo.save(detalleFactura);
       detalleFacturas.add(detalleFactura);
        }
    }
    private Factura GenerarFactura(Tipo_Factura tipoFactura){
        Date fechaActual = new Date();
        Double total = Double.parseDouble(totalField.getText());
        Factura factura = new Factura(obtenerSiguienteIdFactura(),fechaActual,total,cliente,empleadoLogin,tipoFactura, detalleFacturas  );
        facturaRepo.save(factura);
        return  factura;

    }

    private void buscarCliente (){
       String cedula = idClienteField.getText();

       if(idClienteField.getText().isEmpty()){
           mostrarAlerta("Escriba el id del cliente porfavor", "Error de entrada", Alert.AlertType.ERROR);
        } else if(!clienteRepo.findById(cedula).isPresent()){
               mostrarAlerta("El cliente con el id "+ cedula + "no se encuentra registrado, porfavor registrelo" , "Error de entrada", Alert.AlertType.ERROR);
           } else{
               cliente = clienteRepo.findById(cedula).orElse(null);
           }
       }


    private void handleFacturaVirtualButtonClick() {
        // Acciones a realizar cuando se hace clic en el botón de factura virtual
        System.out.println("Clic en Factura Virtual");
        // Puedes agregar más acciones según tus necesidades
    }
    public void actualizarValoresUnitarios( ) {
        for (Integer id : ids) {
            // Consulta el producto por ID
            Producto producto = productoRepo.findById(id).orElse(null);

            if (producto != null) {
                // Encuentra el carrito correspondiente al producto
                Carrito carritoItem = encontrarCarritoPorProducto(carrito, producto.getNombre());

                if (carritoItem != null) {
                    // Actualiza el valor unitario en el carrito
                    carritoItem.setValorUnidad(producto.getPrecio_minimo());
                    carritoItem.setValorTotal(producto.getPrecio_minimo() * carritoItem.getCantindad());
                }
            }
        }
    }

    // Método auxiliar para encontrar un elemento de carrito por nombre de producto
    private Carrito encontrarCarritoPorProducto(List<Carrito> carrito, String nombreProducto) {
        for (Carrito item : carrito) {
            if (item.getProducto().equals(nombreProducto)) {
                return item;
            }
        }
        return null;
    }

    private void handleDescuentoLabelClick(){
      if(carrito.isEmpty()){
          mostrarAlerta("Primero agregue productos", "Error de entrada", Alert.AlertType.INFORMATION);
      }else {
          actualizarValoresUnitarios();
          listaCarrito.clear();
          listaCarrito.addAll(carrito);

          totalField.setText("" + calcularSumaTotales(carrito));
      }
    }
    private Double calcularSumaTotales(List<Carrito> carritoLista) {
        double sumaTotales = 0.0;

        for (Carrito item : carritoLista) {
            sumaTotales += item.getValorTotal();
        }

        return sumaTotales;
    }
    private int calcularCantidad(List<Carrito> carritoLista) {
        int sumaTotales = 0;

        for (Carrito item : carritoLista) {
            sumaTotales += item.getCantindad();
        }

        return sumaTotales;
    }
    private void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Puedes establecer un encabezado si lo deseas
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    void initializetable() {
        // Initialize the product table
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantindad"));
        productoColumn.setCellValueFactory(new PropertyValueFactory<>("producto"));
        valorUnidadColumn.setCellValueFactory(new PropertyValueFactory<>("valorUnidad"));
        valorTotalColumn.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));


        tablaProductos.setItems(listaCarrito);
    }


    private  void handleAgregarLabelClick(){
        try {
            if (idProductoField.getText().isEmpty() && nombreProductoField.getText().isEmpty()) {
                mostrarAlerta("ha porfavor no deje campos del producto vacios", "Error de entrada", Alert.AlertType.ERROR);
            } else if (idProductoField.getText().isEmpty() && !nombreProductoField.getText().isEmpty()) {
                generarAccioNombreProductos();
                listaCarrito.clear();
                listaCarrito.addAll(carrito);
                subtotalField.setText("" + calcularSumaTotales(carrito));
                totalField.setText("" + calcularSumaTotales(carrito));
                cantidadLabel.setText(""+calcularCantidad( carrito));
            } else if (!idProductoField.getText().isEmpty() && nombreProductoField.getText().isEmpty()) {
                generarAccioIdProducto();
                listaCarrito.clear();
                listaCarrito.addAll(carrito);
                subtotalField.setText("" + calcularSumaTotales(carrito));
                totalField.setText("" + calcularSumaTotales(carrito));
                cantidadLabel.setText(""+calcularCantidad( carrito));
            } else if (!idProductoField.getText().isEmpty() && !nombreProductoField.getText().isEmpty()) {
                generarAccioIdYNombreProducto();
                listaCarrito.clear();
                listaCarrito.addAll(carrito);
                subtotalField.setText("" + calcularSumaTotales(carrito));
                totalField.setText("" + calcularSumaTotales(carrito));
                cantidadLabel.setText(""+calcularCantidad( carrito));
            } else {
                mostrarAlerta("ha ocurrido un error", "Error de entrada", Alert.AlertType.ERROR);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private  void  generarAccioIdProducto (){
        Integer codigo;
        int cant;
        if(!CantidadField1.getText().isEmpty()) {
            try {
                if (!idProductoField.getText().isEmpty()) {

                    codigo = Integer.parseInt(idProductoField.getText());
                    cant = Integer.parseInt(CantidadField1.getText());
                    Producto producto = productoRepo.findById(codigo).orElse(null);
                    if(producto == null){
                        mostrarAlerta("El producto no fue encontrado, digite un nombre  correcto", "Error de entrada", Alert.AlertType.ERROR);
                    }else{
                        if(producto.getStock() < cant){
                            mostrarAlerta("NO hay suficiente stock para la cantidad solicitada", "Error de entrada", Alert.AlertType.ERROR);
                        }else{
                            producto.setStock(producto.getStock()-cant);
                            productoRepo.save( producto);
                            Carrito carrito1 = new Carrito(cant, producto.getNombre(),producto.getPrecio_maximo(),producto.getPrecio_maximo()*cant);
                            carrito.add(carrito1);
                            ids.add(producto.getCodigo());
                        }
                    }

                }
            } catch (NumberFormatException e) {
                // Maneja la excepción si el código no es un número válido
                mostrarAlerta("El código y/o cantidad deben de  ser un número válido.", "Error de entrada", Alert.AlertType.ERROR);

            }
        }else{
            mostrarAlerta(" Por favor llene el campo de cantidad de producto :(", "Error de entrada", Alert.AlertType.ERROR);
        }

    }
    private  void  generarAccioNombreProductos (){

        int cant;
        if(!CantidadField1.getText().isEmpty()) {
            try {
                if (!idProductoField.getText().isEmpty()) {


                    cant = Integer.parseInt(CantidadField1.getText());
                    Producto producto = productoRepo.findByNombre(nombreProductoField.getText()).orElse(null);
                    if(producto == null){
                        mostrarAlerta("El producto no fue encontrado, digite un  id correcto", "Error de entrada", Alert.AlertType.ERROR);
                    }else{
                        if(producto.getStock() < cant){
                            mostrarAlerta("NO hay suficiente stock para la cantidad solicitada", "Error de entrada", Alert.AlertType.ERROR);
                        }else{
                            producto.setStock(producto.getStock()-cant);
                            productoRepo.save( producto);
                            Carrito carrito1 = new Carrito(cant, producto.getNombre(),producto.getPrecio_maximo(),producto.getPrecio_maximo()*cant);
                            carrito.add(carrito1);
                            ids.add(producto.getCodigo());
                            mostrarAlerta("Agregado con exito", "Error de entrada", Alert.AlertType.CONFIRMATION);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                // Maneja la excepción si el código no es un número válido
                mostrarAlerta("la cantidad debe ser un número válido.", "Error de entrada", Alert.AlertType.ERROR);

            }
        }else{
            mostrarAlerta(" Por favor llene el campo de cantidad de producto :(", "Error de entrada", Alert.AlertType.ERROR);
        }

    }

    private  void  generarAccioIdYNombreProducto (){
        Integer codigo;
        int cant;
        if(!CantidadField1.getText().isEmpty()) {
            try {
                if (!idProductoField.getText().isEmpty()) {

                    codigo = Integer.parseInt(idProductoField.getText());
                    cant = Integer.parseInt(CantidadField1.getText());
                    Producto producto = productoRepo.findByNombreAndCodigo(nombreProductoField.getText(),codigo).orElse(null);
                    if(producto == null){
                        mostrarAlerta("El producto no fue encontrado, digite un nombre y id corretos", "Error de entrada", Alert.AlertType.ERROR);
                    }else{
                        if(producto.getStock() < cant){
                            mostrarAlerta("NO hay suficiente stock para la cantidad solicitada", "Error de entrada", Alert.AlertType.ERROR);
                        }else{
                            producto.setStock(producto.getStock()-cant);
                            productoRepo.save( producto);
                            Carrito carrito1 = new Carrito(cant, producto.getNombre(),producto.getPrecio_maximo(),producto.getPrecio_maximo()*cant);
                            carrito.add(carrito1);
                            ids.add(producto.getCodigo());
                        }

                    }
                }
            } catch (NumberFormatException e) {
                // Maneja la excepción si el código no es un número válido
                mostrarAlerta("El código y/o cantidad deben de ser un número válido.", "Error de entrada", Alert.AlertType.ERROR);

            }
        }else{
            mostrarAlerta(" Por favor llene el campo de cantidad de producto :(", "Error de entrada", Alert.AlertType.ERROR);
        }

    }

    private void handleEliminarLabelClick() {


    }

    private void handleBuscarLabelClick() {
        System.out.println("Clic en Buscar");
    }

    private void handleInventarioLabelClick() {
        System.out.println("Clic en Inventario");
    }

    private void handleActualizarLabelClick() {
        System.out.println("Clic en Actualizar");
    }

    private void handleHistorialLabelClick(MouseEvent event) {
        System.out.println("Clic en Historial");
        abrirVentanaHistorial(event, empleadoLogin);

    }
    private void handleProductoClick(MouseEvent event) {
        abrirVentanaProducto(event, empleadoLogin);
        System.out.println("Clic en Producto");
    }

    private void handleFacturasLabelClick(MouseEvent event) {
        System.out.println("Clic en Facturas");
        abrirVentanaFacturas(event, empleadoLogin);
    }
    private void abrirVentanaFactura(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaFactura(event, empleado);
    }

    private void handleProveedoresLabelClick(MouseEvent event) {
        System.out.println("Clic en Proveedores");
        abrirVentanaProveedores(event, empleadoLogin);
    }
    private void handleClientesLabelClick(MouseEvent event) {
        System.out.println("Clic en Clientes");
        if(!empleadoLogin.getNombre().equalsIgnoreCase("ADMIN")){
            mostrarAlerta("No tiene permisos para acceder a esta ventana", "Error de entrada", Alert.AlertType.ERROR);
        }else{
            abrirVentanaClientes(event, empleadoLogin);
        }
    }

    private void abrirVentanaClientes(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaCliente(event, empleado);
    }

    private void abrirVentanaHistorial(MouseEvent event, Empleado empleado) {
       sceneController.cambiarAVentanaFactura(event, empleado);
    }
    private void abrirVentanaProducto(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaProducto(event, empleado);
    }

    private void abrirVentanaFacturas(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaInventario(event, empleado);
    }


    private void abrirVentanaProveedores(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaProveedor(event, empleado);
    }

    private void handleCantidadLabelClick() {
        System.out.println("Clic en Cantidad");
    }

    private void handleEmpleadosLabelClick(MouseEvent event) {
        System.out.println("Clic en Empleados");
        if(!empleadoLogin.getNombre().equalsIgnoreCase("ADMIN")){
            mostrarAlerta("No tiene permisos para acceder a esta ventana", "Error de entrada", Alert.AlertType.ERROR);
        }else{
            abrirVentanaEmpleados(event, empleadoLogin);
        }
    }

    private void abrirVentanaEmpleados(MouseEvent event, Empleado empleado) {
        sceneController.cambiarAVentanaEmpleado(event, empleado);
    }

    public Tipo_Factura traducirOpciones(String opcion) {
        switch (opcion) {
            case "FISICA":
                return Tipo_Factura.FISICA;
            case "ELECTRONICA":
                return Tipo_Factura.ELECTRONICA;
            // Agrega más casos según sea necesario
            default:
                // Manejar el caso por defecto si la opción no coincide con ningún tipo de producto
                return null;
        }
    }





    public void displayEmployeeIDUsername(Empleado empleado){
        empleadoLogin = empleado;
        nombreUsuarioLabel.setText(empleado.getNombre());
        fechaLabel.setText("Fecha: " + java.time.LocalDate.now());
    }
}

