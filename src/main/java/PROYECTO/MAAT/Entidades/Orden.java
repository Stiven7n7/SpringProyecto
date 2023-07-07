package PROYECTO.MAAT.Entidades;

import java.util.Date;

public class Orden {
    private Integer id;
    private String numero;
    private Date fecha_creacion;
    private Date fecha_entrega;
    private double total;

    public Orden() {
    }

    public Orden(Integer id, String numero, Date fecha_creacion, Date fecha_entrega, double total) {
        this.id = id;
        this.numero = numero;
        this.fecha_creacion = fecha_creacion;
        this.fecha_entrega = fecha_entrega;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_entrega=" + fecha_entrega +
                ", total=" + total +
                '}';
    }
}
