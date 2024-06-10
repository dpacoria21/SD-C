
package entities;

public class Persona {
    private String nombre;
    private String apellido;
    private int code;
    private double saldo;
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String  apellido){
        this.apellido = apellido;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public int getCode(){
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public Persona(String nombre, String apellido, int code, double saldo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.code = code;
        this.saldo = saldo;     
    }
    
    
    


    
    
    
}
