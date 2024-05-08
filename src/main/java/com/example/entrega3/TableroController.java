package com.example.entrega3;


import com.example.entrega3.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;


public class TableroController implements Initializable {
    private PrincipalController pC;
    private static ListaSimple<ListaSimple<Celda>> listaCeldas;
    private static int ventanas = 1;
    private static final Logger log = LogManager.getLogger(TableroController.class);
    private static Tablero tablero;
    private static IndividuoTipoBasico individuoTipoBasico;
    private static IndividuoTipoNormal individuoTipoNormal;
    private static IndividuoTipoAvanzado individuoTipoAvanzado;
    private static RecursoAgua recursoAgua;
    private static RecursoBiblioteca recursoBiblioteca;
    private static RecursoComida recursoComida;
    private static RecursoMontaña recursoMontaña;
    private static RecursoPozo recursoPozo;
    private static RecursoTesoro recursoTesoro;

    @FXML
    private GridPane tableroDeJuego;

    public TableroController() {
    }
    @FXML
    public void start(Tablero tablero, IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua,  RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo) {
        log.info("Iniciando controlador de tablero, ventana: "+ventanas++);
        this.tablero = tablero;
        this.individuoTipoBasico = individuoTipoBasico;
        this.individuoTipoNormal = individuoTipoNormal;
        this.individuoTipoAvanzado = individuoTipoAvanzado;
        this.recursoAgua = recursoAgua;
        this.recursoBiblioteca = recursoBiblioteca;
        this.recursoComida = recursoComida;
        this.recursoMontaña = recursoMontaña;
        this.recursoPozo = recursoPozo;
        this.recursoTesoro = recursoTesoro;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("Tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Tablero");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("Tablero.fxml no encontrado");
            e.printStackTrace();
        }
    }
    @FXML
    protected void RectangleOnDragEntered(Rectangle rectange, Celda celda){
        rectange.setFill(Color.DARKGREY);
    }
    @FXML
    protected void RectangleOnDragExited(Rectangle rectange, Celda celda){
        if(celda.getIndividuos().getNumeroElementos()==0){
            rectange.setFill(Color.WHITE);
        }
        else if(celda.getIndividuos().getNumeroElementos()==1){
            rectange.setFill(Color.LIGHTYELLOW);
        }
        else if(celda.getIndividuos().getNumeroElementos()==2){
            rectange.setFill(Color.YELLOW);
        }
        else if(celda.getIndividuos().getNumeroElementos()==3){
            rectange.setFill(Color.YELLOWGREEN);
        }
    }
    @FXML
    protected void ButtonCelda(Celda celda,Rectangle rectangle){
        log.info("Iniciando metodo ButtonCelda");
        CeldaController cD = new CeldaController();
        cD.ButtonCelda(celda,rectangle,pC);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(cD.getClass().getResource("ButtonCelda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Celda" + "(" + (celda.getFilas()+1) + "," + (celda.getColumnas()+1) + ")");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("ButtonCelda.fxml no encontrado");
            e.printStackTrace();
        }
        log.info("Finalizando metodo ButtonCelda");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicializando tablero");
            listaCeldas = new ListaSimple<>(tablero.getColumnas());
            for (int i = 0; i < tablero.getColumnas(); i++) {
                ListaSimple<Celda> listaS = new ListaSimple<>(tablero.getFilas());
                //LDE = new ListaDoblementeEnlazada()...
                for (int j = 0; j < tablero.getFilas(); j++) {
                    // Aquí podrías instanciar tu LetrasColoresGrid
                    // LetrasColoresGrid customComponent = new LetrasColoresGrid();
                    // mainGrid.add(customComponent, i, j);

                    // Ejemplo simplificado con un label
                    Rectangle rectangle = new Rectangle(310 * 3 / tablero.getColumnas(), 450 / tablero.getFilas(),Color.WHITE);
                    final Button placeholder = new Button();
                    Celda celda = new Celda(j,i);
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celda,rectangle);
                        }
                    });
                    placeholder.setOnMouseEntered(mouseEvent -> {
                                RectangleOnDragEntered(rectangle,celda);
                            });
                    placeholder.setOnMouseExited(mouseEvent -> {
                        RectangleOnDragExited(rectangle,celda);
                    });
                    placeholder.setMinSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                    placeholder.setGraphic(rectangle);
                    tableroDeJuego.add(placeholder, i, j);
                    listaS.add(celda);
                    //LDE.add(celda)...
                }
                listaCeldas.add(listaS);
            }
        log.info("Tablero terminado");
        pC = new PrincipalController(individuoTipoBasico,individuoTipoNormal,individuoTipoAvanzado,recursoAgua,recursoComida,recursoMontaña,
                recursoTesoro,recursoBiblioteca,recursoPozo,listaCeldas);
     }
}
