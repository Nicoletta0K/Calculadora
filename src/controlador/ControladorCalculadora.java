/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Operaciones;
import vista.FrmCalcu;
import javax.swing.JOptionPane;
/**
 *
 * @author María J
 */
public class ControladorCalculadora {
    private FrmCalcu vista;
    private Operaciones modelo;
    private double numero1;
    private double numero2;
    private String operacion;

    public ControladorCalculadora(FrmCalcu vista, Operaciones modelo) {
        this.vista = vista;
        this.modelo = modelo;
        numero1 = 0;
        numero2 = 0;
        operacion = "";
        agregarEventos();
    }
    private void agregarEventos() {
        vista.getBtnCero().addActionListener(e -> agregarNumero(0));
        vista.getBtnUno().addActionListener(e -> agregarNumero(1));
        vista.getBtnDos().addActionListener(e -> agregarNumero(2));
        vista.getBtnTres().addActionListener(e -> agregarNumero(3));
        vista.getBtnCuatro().addActionListener(e -> agregarNumero(4));
        vista.getBtnCinco().addActionListener(e -> agregarNumero(5));
        vista.getBtnSeis().addActionListener(e -> agregarNumero(6));
        vista.getBtnSiete().addActionListener(e -> agregarNumero(7));
        vista.getBtnOcho().addActionListener(e -> agregarNumero(8));
        vista.getBtnNueve().addActionListener(e -> agregarNumero(9));
        vista.getBtnSuma().addActionListener(e -> seleccionarOperacion("+"));

        vista.getBtnResta().addActionListener(e -> seleccionarOperacion("-"));

        vista.getBtnMultiplicar().addActionListener(e -> seleccionarOperacion("*"));

        vista.getBtnDivision().addActionListener(e -> seleccionarOperacion("/"));

        vista.getBtnIgual().addActionListener(e -> {

            double resultado = calcular();

            vista.setTextoPantalla(String.valueOf(resultado));

        });
        vista.getBtnAC().addActionListener(e -> {

            limpiarTodo();

            vista.setTextoPantalla("");
        });

        vista.getBtnC().addActionListener(e -> {

            limpiarTodo();

            vista.setTextoPantalla("");

        });

    }

    public void agregarNumero(double numero) {
        if(operacion.equals("")) {
            numero1 = numero1 * 10 + numero;

            vista.setTextoPantalla(String.valueOf(numero1));
        } else {
            numero2 = numero2 * 10 + numero;
            vista.setTextoPantalla(String.valueOf(numero2));
        }
    }

    public void seleccionarOperacion(String op) {
        if(numero1 == 0) {

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
            switch(operacion) {
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
        } catch(ArithmeticException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
        return resultado;
    }
    public void limpiarTodo() {
        numero1 = 0;
        numero2 = 0;
        operacion = "";
        modelo.reiniciar();
    }
    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }
    public void setNumero2(double numero2) {

        this.numero2 = numero2;
    }

}