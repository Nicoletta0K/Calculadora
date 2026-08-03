package modelo;
public class Operaciones {
  public double valor;
    public double resultado;
    private String operador;
    public Operaciones(){
    this.resultado = 0;
    this.valor = 0;
    }
    public double getResultado(){
    return resultado;  
}
    public double getValor(){
    return valor;  
}
    public void setValor(double valor){
    this.valor = valor;
}
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    public String getOperador() {
        return operador;
    }

    public void setOperacion(String operacion) {
        this.operador  = operacion;
    }

    public void sumar(){
        resultado+= valor; 
    }
    
    public void restar(){
        resultado-= valor; 
    }
    
    public void multiplicar(){
        resultado*= valor; 
    }
        public void dividir(){
        if (valor == 0){
                    throw new ArithmeticException("No se puede dividir entre cero.");
                } else {
                    resultado /= valor;
        }
        }
      public void reiniciar(){
                this.valor = 0;
        this.resultado = 0;
        this.operador= "+";
    }
    }

