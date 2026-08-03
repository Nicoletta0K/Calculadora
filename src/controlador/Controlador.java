/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import modelo.Calculadora;
import vista.FrmCalculadora;
import javax.swing.JOptionPane;
import excepciones.DivisionPorCeroException;
import excepciones.ValorInvalidoException;
/**
 *
 * @author María J
 */
public class Controlador {
    
    private FrmCalculadora vista;
    private Calculadora modelo;
            
      private String primerNumero = "";
    private String segundoNumero = "";
    private String operacion = "";

    private boolean segundoValor = false;

  public Controlador(FrmCalculadora vista, Calculadora modelo) {
    this.vista = vista;
    this.modelo = modelo;

    eventos();
}
