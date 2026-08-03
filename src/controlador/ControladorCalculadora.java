/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Operaciones;
import vista.FrmCalculadora;
import javax.swing.JOptionPane;
/**
 *
 * @author María J
 */
public class ControladorCalculadora {
    private FrmCalculadora vista;
    private Operaciones modelo;
    private double numero1;
    private double numero2;
    private String operacion;

    public ControladorCalculadora(FrmCalculadora vista, Operaciones modelo) {
        this.vista = vista;
        this.modelo = modelo;
        numero1 = 0;
        numero2 = 0;
        operacion = "";

        agregarEventos();
    }


    private void agregarEventos() {
    }


    public void seleccionarOperacion(String op) {
        if(numero1 == 0){
            JOptionPane.showMessageDialog(null,"Debe ingresar el primer número.");
            return;
        }
        operacion = op;
    }
    public double calcular() {
        double resultado = 0;
        try {
            modelo.setResultado(numero1);
            modelo.setValor(numero2);
            
            switch(operacion){
                case "+":
                    modelo.sumar();
                    break;

                case "-":
                    modelo.restar();
                    break;

                case "*":
                    modelo.multiplicar();
                    break;

                case "/":
                    modelo.dividir();
                    break;

                default:

                    JOptionPane.showMessageDialog(null,
                    "Seleccione una operación.");

                    break;
            }


            resultado = modelo.getResultado();
        } catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null,e.getMessage());

        }
        return resultado;
    }


    public void limpiarTodo(){
        numero1 = 0;
        numero2 = 0;
        operacion = "";
        modelo.reiniciar();

    }

    public void setNumero1(double numero1){
        this.numero1 = numero1;
    }
    public void setNumero2(double numero2){
        this.numero2 = numero2;
    }
}