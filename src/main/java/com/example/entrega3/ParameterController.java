package com.example.entrega3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ParameterController implements Initializable {
    /**
     * Hooks de conexión entre los controles visuales y el código, llevan @FXML para identificarlos
     **/

    private static int ventanas = 1;
    private static final Logger log = LogManager.getLogger(ParameterController.class);
    //SLIDEERS VALORES Y MEDIDAS DE INDIVIDUO
    @FXML
    private Slider sliderVidas;
    @FXML
    private Label ValorSliderVidas;
    @FXML
    private Slider sliderPorcentajeReproduccion;
    @FXML
    private Label ValorSliderPReproduccion;
    @FXML
    private Slider sliderPorcentajeClonacion;
    @FXML
    private Label ValorSliderPClonacion;
    @FXML
    private Slider sliderPorcentajeTipoAlReproducirse;
    @FXML
    private Label ValorSliderPTipo;
    protected IntegerProperty medidaVidas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaClonacion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTipoAlReproducirse = new SimpleIntegerProperty(0);


//SLIDERS;VALORES Y MEDIDAS DE RECURSO:::::

    @FXML
    private Slider sliderTiempoAparicion;
    @FXML
    private Label ValorTiempoAparicion;
    @FXML
    private Slider sliderPorcentajeAparicion;
    @FXML
    private Label ValorSliderPorcentajeAparicion;
    @FXML
    private Slider sliderPorcentajeAparicionAgua;
    @FXML
    private Label ValorSliderPorcentajeAparicionAgua;
    @FXML
    private Slider sliderPorcentajeAparicionComida;
    @FXML
    private Label ValorSliderPorcentajeAparicionComida;
    @FXML
    private Slider sliderPorcentajeAparicionMontaña;
    @FXML
    private Label ValorSliderPorcentajeAparicionMontaña;
    @FXML
    private Slider sliderPorcentajeAparicionTesoro;
    @FXML
    private Label ValorSliderPorcentajeAparicionTesoro;
    @FXML
    private Slider sliderPorcentajeAparicionBiblioteca;
    @FXML
    private Label ValorSliderPorcentajeAparicionBiblioteca;
    @FXML
    private Slider sliderPorcentajeAparicionPozo;
    @FXML
    private Label ValorSliderPorcentajeAparicionPozo;
    protected IntegerProperty medidaTiempoAparicion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionComida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionPozo = new SimpleIntegerProperty(0);


    //TABLERO:::
    @FXML
    private Slider sliderColumnas;
    @FXML
    private Label ValorColumnas;
    @FXML
    private Slider sliderFilas;
    @FXML
    private Label ValorFilas;
    protected IntegerProperty medidaFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaColumnas = new SimpleIntegerProperty(0);


    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    //MODELS DE CADA PARAMETRO
    private IndividuoParametros model;

    private RecursoParametros model2;

    private RecursoParametros.RecursoParametrosAgua modelAgua;
    private RecursoParametros.RecursoParametrosComida modelComida;
    private RecursoParametros.RecursoParametrosMontaña modelMontaña;
    private RecursoParametros.RecursoParametrosTesoro modelTesoro;
    private RecursoParametros.RecursoParametrosBiblioteca modelBiblioteca;
    private RecursoParametros.RecursoParametrosPozo modelPozo;

    private TableroParametros modelTablero;
    private Stage scene;


    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */


    @FXML
    protected void onBotonGuardarClick() {
        log.info("Guardando datos del individuo");
        model.commit();
        log.info("Datos del individuo guardados");
    }

    @FXML
    protected void onBotonGuardarClick2() {
        log.info("Guardando datos de Recurso");
        model2.commit();
        modelAgua.commit();
        modelComida.commit();
        modelMontaña.commit();
        modelBiblioteca.commit();
        modelPozo.commit();
        modelTesoro.commit();
        log.info("Datos del Recurso guardados");
    }

    @FXML
    protected void onBotonGuardarClick3() {
        log.info("Guardando datos de Tablero");
        modelTablero.commit();
        log.info("Datos del Tablero guardados");
    }

    @FXML
    protected void onBotonReiniciarClick() {
        log.info("Reiniciando datos de Individuo");
        model.rollback();
        log.info("Datos del Individuo reiniciados");
    }

    @FXML
    protected void onBotonReiniciarClick2() {
        log.info("Reiniciando datos de Recurso");
        model2.rollback();
        modelAgua.rollback();
        modelComida.rollback();
        modelMontaña.rollback();
        modelBiblioteca.rollback();
        modelPozo.rollback();
        modelTesoro.rollback();
        log.info("Datos del Recurso reiniciados");
    }

    @FXML
    protected void onBotonReiniciarClick3() {
        log.info("Reiniciando datos de Tablero");
        modelTablero.rollback();
        log.info("Datos del Tablero reiniciados");
    }


    /**
     * Este método se encarga de conectar los datos del modelo con el GUI
     **/
    protected void updateGUIwithModel() {
        log.warn("Generando sliders varios");
        sliderVidas.valueProperty().bindBidirectional(model.VidasProperty());
        sliderPorcentajeReproduccion.valueProperty().bindBidirectional(model.PorcentajeReproduccionProperty());
        sliderPorcentajeClonacion.valueProperty().bindBidirectional(model.PorcentajeClonacionProperty());
        sliderPorcentajeTipoAlReproducirse.valueProperty().bindBidirectional(model.PorcentajeTipoAlReproducirse());

        sliderTiempoAparicion.valueProperty().bindBidirectional(model2.TiempoAparicionProperty());
        sliderPorcentajeAparicion.valueProperty().bindBidirectional(model2.PorcentajeAparicionProperty());

        sliderPorcentajeAparicionAgua.valueProperty().bindBidirectional(modelAgua.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionComida.valueProperty().bindBidirectional(modelComida.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionMontaña.valueProperty().bindBidirectional(modelMontaña.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionTesoro.valueProperty().bindBidirectional(modelTesoro.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionBiblioteca.valueProperty().bindBidirectional(modelBiblioteca.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionPozo.valueProperty().bindBidirectional(modelPozo.PorcentajeAparicion2Property());

        sliderFilas.valueProperty().bindBidirectional(modelTablero.FilasProperty());
        sliderColumnas.valueProperty().bindBidirectional(modelTablero.ColumnasProperty());
        log.info("sliders generados");
    }
    // Listener para actualizar la suma total

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(IndividuoParametros parametrosData, RecursoParametros parametrosData2, RecursoParametros.RecursoParametrosAgua parametrosAgua, RecursoParametros.RecursoParametrosComida parametrosComida,
                             RecursoParametros.RecursoParametrosMontaña parametrosMontaña, RecursoParametros.RecursoParametrosTesoro parametrosTesoro,
                             RecursoParametros.RecursoParametrosBiblioteca parametrosBiblioteca, RecursoParametros.RecursoParametrosPozo parametrosPozo,
                             TableroParametros tableroParametros) {
        log.info("Cargando datos genéricos");
        this.model = parametrosData;
        this.model2 = parametrosData2;
        this.modelAgua = parametrosAgua;
        this.modelComida = parametrosComida;
        this.modelMontaña = parametrosMontaña;
        this.modelTesoro = parametrosTesoro;
        this.modelBiblioteca = parametrosBiblioteca;
        this.modelPozo = parametrosPozo;
        this.modelTablero = tableroParametros;
        this.updateGUIwithModel();
    }

    public void setStage(Stage s) {
        this.scene = s;
    }

    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Iniciando controlador de parametros, ventana: "+ventanas++);
        if((model!=null)&&(model2!=null)&&(modelAgua!=null)&&(modelComida!=null)&&(modelMontaña!=null)&&(modelTesoro !=null)
                &&(modelBiblioteca!=null)&&(modelPozo!=null)&&(modelTablero!=null)){
            this.updateGUIwithModel();
        }
        sliderVidas.valueProperty().bindBidirectional(medidaVidas);
        ValorSliderVidas.textProperty().bind(medidaVidas.asString());

        sliderPorcentajeReproduccion.valueProperty().bindBidirectional(medidaReproduccion);
        ValorSliderPReproduccion.textProperty().bind(medidaReproduccion.asString());

        sliderPorcentajeClonacion.valueProperty().bindBidirectional(medidaClonacion);
        ValorSliderPClonacion.textProperty().bind(medidaClonacion.asString());

        sliderPorcentajeTipoAlReproducirse.valueProperty().bindBidirectional(medidaTipoAlReproducirse);
        ValorSliderPTipo.textProperty().bind(medidaTipoAlReproducirse.asString());

        sliderTiempoAparicion.valueProperty().bindBidirectional(medidaTiempoAparicion);
        ValorTiempoAparicion.textProperty().bind(medidaTiempoAparicion.asString());

        sliderPorcentajeAparicion.valueProperty().bindBidirectional(medidaPorcentajeAparicion);
        ValorSliderPorcentajeAparicion.textProperty().bind(medidaPorcentajeAparicion.asString());

        sliderPorcentajeAparicionAgua.valueProperty().bindBidirectional(medidaPorcentajeAparicionAgua);
        ValorSliderPorcentajeAparicionAgua.textProperty().bind(medidaPorcentajeAparicionAgua.asString());

        sliderPorcentajeAparicionComida.valueProperty().bindBidirectional(medidaPorcentajeAparicionComida);
        ValorSliderPorcentajeAparicionComida.textProperty().bind(medidaPorcentajeAparicionComida.asString());

        sliderPorcentajeAparicionMontaña.valueProperty().bindBidirectional(medidaPorcentajeAparicionMontaña);
        ValorSliderPorcentajeAparicionMontaña.textProperty().bind(medidaPorcentajeAparicionMontaña.asString());

        sliderPorcentajeAparicionTesoro.valueProperty().bindBidirectional(medidaPorcentajeAparicionTesoro);
        ValorSliderPorcentajeAparicionTesoro.textProperty().bind(medidaPorcentajeAparicionTesoro.asString());

        sliderPorcentajeAparicionBiblioteca.valueProperty().bindBidirectional(medidaPorcentajeAparicionBiblioteca);
        ValorSliderPorcentajeAparicionBiblioteca.textProperty().bind(medidaPorcentajeAparicionBiblioteca.asString());

        sliderPorcentajeAparicionPozo.valueProperty().bindBidirectional(medidaPorcentajeAparicionPozo);
        ValorSliderPorcentajeAparicionPozo.textProperty().bind(medidaPorcentajeAparicionPozo.asString());

        sliderFilas.valueProperty().bindBidirectional(medidaFilas);
        ValorFilas.textProperty().bind(medidaFilas.asString());

        sliderColumnas.valueProperty().bindBidirectional(medidaColumnas);
        ValorColumnas.textProperty().bind(medidaColumnas.asString());

    }

    @FXML
    protected void ButtonGuiaVidas() {
        log.info("Inciando zVentanaVidas");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaVidas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Vidas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaVidas.fxml no encontrada");
            e.printStackTrace();
        }
    }

    @FXML
    protected void ButtonGuiaReproduccion() {
        log.info("Inciando zVentanaReproduccion");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaReproduccion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Reproducción");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaReproduccion.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaClonacion() {
        log.info("Inciando zVentanaClonacion");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaClonacion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Clonación");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaClonacion.fxml no encontrada");
            e.printStackTrace();
        }
    }

    @FXML
    protected void ButtonGuiaTipo() {
        log.info("Inciando zVentanaTipo");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaTipo.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Tipo al reproducirse");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaTipo.fxml no encontrada");
            e.printStackTrace();
        }


    }

    @FXML
    protected void ButtonGuiaTiempoAparicion() {
        log.info("Inciando zVentanaTiempoAparicion");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaTiempoAparicion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Tiempo de aparición");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaTiempoAparicion.fxml no encontrada");
            e.printStackTrace();
        }

    }


    @FXML
    protected void ButtonGuiaPropabilidadAparicion() {
        log.info("Inciando zVentanaProbabilidadAparicion");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaProbabilidadAparicion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Probabilidad de aparición");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaProbabilidadAparicion.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaAgua() {
        log.info("Inciando zVentanaAgua");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaAgua.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Agua");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaAgua.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaComida() {
        log.info("Inciando zVentanaComida");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaComida.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Comida");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaComida.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaMontaña() {
        log.info("Inciando zVentanaMontaña");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaMontaña.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Montaña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaMontaña.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaTesoro() {
        log.info("Inciando zVentanaTesoro");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaTesoro.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Tesoro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaTesoro.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaBiblioteca() {
        log.info("Inciando zVentanaBiblioteca");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaBiblioteca.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Biblioteca");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaBiblioteca.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaPozo() {
        log.info("Inciando zVentanaPozo");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaPozo.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Pozo");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaPozo.fxml no encontrada");
            e.printStackTrace();
        }

    }


    @FXML
    protected void ButtonGuiaFilas() {
        log.info("Inciando zVentanaFilas");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaFilas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Filas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaFilas.fxml no encontrada");
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaColumnas() {
        log.info("Inciando zVentanaColumnas");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaColumnas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Columnas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaColumnas.fxml no encontrada");
            e.printStackTrace();
        }
    }

    @FXML
    protected void ButtonOnClickTablero() throws Exception {
        log.info("Creando nuevo controlador de tablero (TableroController)");
        TableroController tab = new TableroController();
        log.info("Creando clases con los datos de los sliders");
        tab.start(modelTablero.getOriginal(),(new IndividuoTipoBasico(model.getOriginal().getVidas(),model.getOriginal().getPorcentajeReproduccion(),model.getOriginal().getPorcentajeClonacion(),model.getOriginal().getPorcentajeTipoAlReproducirse())),
                (new IndividuoTipoNormal(model.getOriginal().getVidas(),model.getOriginal().getPorcentajeReproduccion(),model.getOriginal().getPorcentajeClonacion(),model.getOriginal().getPorcentajeTipoAlReproducirse())),
                (new IndividuoTipoAvanzado(model.getOriginal().getVidas(),model.getOriginal().getPorcentajeReproduccion(),model.getOriginal().getPorcentajeClonacion(),model.getOriginal().getPorcentajeTipoAlReproducirse())),
                (new RecursoAgua(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),getPorcentajesRecurso(modelAgua.getOriginal().getPorcentajeAparicion2()))),
                (new RecursoComida(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),getPorcentajesRecurso(modelComida.getOriginal().getPorcentajeAparicion2()))),
                (new RecursoMontaña(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),getPorcentajesRecurso(modelMontaña.getOriginal().getPorcentajeAparicion2()))),
                (new RecursoTesoro(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),getPorcentajesRecurso(modelTesoro.getOriginal().getPorcentajeAparicion2()))),
                (new RecursoBiblioteca(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),getPorcentajesRecurso(modelBiblioteca.getOriginal().getPorcentajeAparicion2()))),
                (new RecursoPozo(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),getPorcentajesRecurso(modelPozo.getOriginal().getPorcentajeAparicion2()))));
        log.debug(model.getOriginal().toString());
        log.debug("Porcentaje Aparicion recurso"+model2.getOriginal().getPorcentajeAparicion());
        log.debug("Tiempo Aparicion recurso"+model2.getOriginal().getTiempoAparicion());
        log.debug("aparicionAgua="+getPorcentajesRecurso(modelAgua.getOriginal().getPorcentajeAparicion2()));
        log.debug("aparicionComida="+getPorcentajesRecurso(modelComida.getOriginal().getPorcentajeAparicion2()));
        log.debug("aparicionMontaña="+getPorcentajesRecurso(modelMontaña.getOriginal().getPorcentajeAparicion2()));
        log.debug("aparicionTesoro="+getPorcentajesRecurso(modelTesoro.getOriginal().getPorcentajeAparicion2()));
        log.debug("aparicionBiblioteca="+getPorcentajesRecurso(modelBiblioteca.getOriginal().getPorcentajeAparicion2()));
        log.debug("aparicionPozo="+getPorcentajesRecurso(modelPozo.getOriginal().getPorcentajeAparicion2()));
        log.debug("Tablero="+modelTablero.getOriginal());
        log.debug("Individuo="+model.getOriginal());
        log.debug(modelTablero.getOriginal().toString());
        log.info("Finalizando metodo ButtonClcikTablero");
    }
    protected int getPorcentajesRecurso(int dato) {
        int total = modelAgua.getOriginal().getPorcentajeAparicion2() + modelComida.getOriginal().getPorcentajeAparicion2() + modelMontaña.getOriginal().getPorcentajeAparicion2() +
                modelTesoro.getOriginal().getPorcentajeAparicion2() + modelBiblioteca.getOriginal().getPorcentajeAparicion2() + modelPozo.getOriginal().getPorcentajeAparicion2();

        return dato* 100 / total ;
    }
    }

