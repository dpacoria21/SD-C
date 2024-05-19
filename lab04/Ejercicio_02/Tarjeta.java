package lab04.Ejercicio_02;

import java.math.BigDecimal;

public class Tarjeta {

    private String numero;
    private TipoTarjeta tipo;
    private String fechaVencimiento;
    private String cvv;
    private String nombreTitular;
    private String dniTitular;
    private BigDecimal saldo;

    public Tarjeta(String numero, TipoTarjeta tipo, String fechaVencimiento, String cvv, String nombreTitular,
            String dniTitular, BigDecimal saldo) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.nombreTitular = nombreTitular;
        this.dniTitular = dniTitular;
        this.saldo = saldo;
    }

    public Tarjeta(String numero, TipoTarjeta tipo, String fechaVencimiento, String cvv, String nombreTitular,
            String dniTitular) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.nombreTitular = nombreTitular;
        this.dniTitular = dniTitular;
        this.saldo = new BigDecimal(0);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTarjeta getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarjeta tipo) {
        this.tipo = tipo;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(String dniTitular) {
        this.dniTitular = dniTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}
