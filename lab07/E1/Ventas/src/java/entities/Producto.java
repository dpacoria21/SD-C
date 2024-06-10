package entities;

public class Producto {
    private String name;
    private int cantidad;
    private Integer code;
    private double precio;
    
    public Producto(String name, int cantidad, double precio){
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    
    public Integer getCode(){
        return code;
    }
    
    public void setCode(Integer code){
        this.code = code;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }


}
