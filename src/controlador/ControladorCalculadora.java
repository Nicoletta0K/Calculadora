package controlador;

import modelo.Operaciones;
import vista.FrmCalcu;

public class ControladorCalculadora {
    private FrmCalcu vista;
    private Operaciones modelo;
    private double numero1;
    private double numero2;
    private String operacion;
    private String textoActual = "";

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

        vista.getBtnPunto().addActionListener(e -> agregarPunto());
        vista.getBtnNegativo().addActionListener(e -> cambiarSigno());

        vista.getBtnSuma().addActionListener(e -> seleccionarOperacion("+"));

        vista.getBtnResta().addActionListener(e -> seleccionarOperacion("-"));

        vista.getBtnMultiplicar().addActionListener(e -> seleccionarOperacion("*"));

        vista.getBtnDivision().addActionListener(e -> seleccionarOperacion("/"));

        vista.getBtnIgual().addActionListener(e -> {

            double resultado = calcular();

            String texto = (resultado == (long) resultado)
                ? String.valueOf((long) resultado)
                : String.valueOf(resultado);

            vista.setTextoPantalla(texto);
            textoActual = texto;

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

    public void agregarNumero(int numero) {
        textoActual += numero;
        vista.setTextoPantalla(textoActual);
    }

    public void agregarPunto() {
        if (!textoActual.contains(".")) {
            textoActual += ".";
            vista.setTextoPantalla(textoActual);
        }
    }

    public void cambiarSigno() {
        if (textoActual.startsWith("-")) {
            textoActual = textoActual.substring(1);
        } else if (!textoActual.isEmpty()) {
            textoActual = "-" + textoActual;
        }
        vista.setTextoPantalla(textoActual);
    }

    public void seleccionarOperacion(String op) {
        numero1 = Double.parseDouble(textoActual.isEmpty() ? "0" : textoActual);
        operacion = op;
        textoActual = "";
    }

    public double calcular() {
        double resultado = 0;
        numero2 = Double.parseDouble(textoActual.isEmpty() ? "0" : textoActual);
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
                    break;
            }
            resultado = modelo.getResultado();
        } catch(ArithmeticException e) {
        }
        return resultado;
    }
    public void limpiarTodo() {
        textoActual = "";
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