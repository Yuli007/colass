package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;

import javax.swing.JOptionPane;

import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Nodo frente;//el inicio de la cola


        @FXML ComboBox listaMenu;

        @FXML ListView <Integer> list;

        @FXML Label lblDatos;


        public Controller() {

            this.frente = null;
        }


        ObservableList<Integer> items1 = FXCollections.observableArrayList();


        @Override
        public void initialize(URL location, ResourceBundle resources) {


            this.listaMenu.getItems().addAll("Insertar elemento","Mostrar ", "Buscar ", "Extraer"," tamano ", "Vaciar la cola");

            listaMenu.getSelectionModel().select(0);
            listaMenu.setOnAction(event -> {
                String value = (String) listaMenu.getValue();
                switch (value) {
                    case "Insertar Elemento":

                        int rango = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta el tamano de elementos de la cola"));
                        for (int i = 0; i < rango; i++){
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta un valor"));
                            insertar(valor);
                        }

                        break;
                    case "Mostrar elemento":

                        mostrar();
                        break;
                    case "Buscar elemento":

                        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el valor a buscar"));
                        buscar(buscar);
                        break;
                    case "Extraer elemento":
                        int extraerNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el valor a extraer de la cola"));
                        extraer(extraerNumero);
                        mostrar();
                        break;
                    case "Obtener tamano de la cola":
                        JOptionPane.showMessageDialog(null,"El tamano de la cola es: " + tamano());

                        break;
                    case "Vaciar la cola":
                        borrarElementos();
                        break;
                    default: break;
                }
            });
        }

        //Método para insertar siguiente elemento (nodo), el elemento debe colocarse detrás del último nodo
        public void insertar(int valor){
            Nodo nuevo = new Nodo(valor);

            if(frente == null){
                frente = nuevo;
            }else{
                Nodo temp = frente;
                while(temp.getProximo() != null){
                    temp = temp.getProximo();
                }
                temp.getProximo();
            }
        }

    //Método para buscar siguiente elemento
        public void buscar(int busqueda) {

            try {
                Nodo temp = frente;
                int posicion = 1;

                if (temp.getValor() == busqueda) {
                    System.out.println("El valor esta en la posición 0");
                } else {
                    while (temp != null) {
                        if (temp.getProximo().getValor() == busqueda) {

                            JOptionPane.showMessageDialog(null,"valor en la posicion:" + posicion);

                            break;
                        }
                        posicion++;
                        temp = temp.getProximo();
                    }}
            }
            catch (Exception ex)
            {
                System.out.println("El elemento no se encuentra");
            }
        }

    //Método para mostrar siguiente elemento
        public void mostrar(){

            if( frente != null){
                Nodo temp = frente;
                System.out.println("Los valores de la cola son: ");

                while(temp != null){
                    System.out.println(temp.getValor());
                    items1.addAll(temp.getValor());
                    temp = temp.getProximo();
                }

                list.setItems(items1);

            }else{
                System.out.println("La cola está vacía.");
            }
        }

        public int extraer(int valorExtraer){
            if(frente == null){
                return 0;
            }else{
                valorExtraer = frente.getValor(); //variable temporal
                System.out.println("Valor extraído: "+ frente.getValor());
                frente = frente.getProximo(); //cambiar el frente por el siguiente
                return valorExtraer ; //devolver el valor extraído de la cola

            }
        }

    //Método para borrar siguiente elemento

        public void borrarElementos(){
            if(frente == null){
                System.out.println("La cola ya esta vacia");
            }else{
                while(frente != null){
                    frente.getValor();
                    frente = frente.getProximo();
                }
                items1.clear();
                list.setItems(items1);
                mostrar();

            }
        }

        public int tamano (){
            Nodo aux = null;
            int i=0;
            aux = frente;
            while(aux != null){
                aux = aux.getProximo();
                i++;
            }
            return i;
        }
    }




