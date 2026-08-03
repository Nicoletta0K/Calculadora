/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import modelo.Calculadora;
import vista.FrmCalculadora;
import javax.swing.JOptionPane;
/**
 *
 * @author María J
 */
public class ControladorCalculadora {

    private FrmCalculadora vista;
    private Calculadora modelo;

     private String numero1 = "";
    private String numero2 = "";
    private String operacion = "";

    public ControladorCalculadora(FrmCalculadora vista, Calculadora modelo) {

        this.vista = vista;
        this.modelo = modelo;

        numero1 = "";
        numero2 = "";
        operacion = "";

        agregarEventos();
    }

    private void agregarEventos() {
       
    }
    public void escribirNumero(String numero) {

        if (operacion.equals("")) {
            numero1 = numero1 + numero;
        } else {
            numero2 = numero2 + numero;
        }
    }
    public void SeleccionarOperacion(String op){
        
    }
}
    
    
