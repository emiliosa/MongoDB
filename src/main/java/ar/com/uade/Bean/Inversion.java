package ar.com.uade.Bean;

import java.util.Date;

public class Inversion {

    private Date fecha;
    private Date fechaCotizacionActual;
    private String codigo;
    private TipoOperacion tipoOperacion;
    private int cantidad;
    private double cotizacion;
    private double cotizacionActual;
    private double monto;

    public Inversion() {}

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCotizacionActual() {
        return fechaCotizacionActual;
    }

    public void setFechaCotizacionActual(Date fechaCotizacionActual) {
        this.fechaCotizacionActual = fechaCotizacionActual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public double getCotizacionActual() {
        return cotizacionActual;
    }

    public void setCotizacionActual(double cotizacionActual) {
        this.cotizacionActual = cotizacionActual;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String toString() {
        return "Fecha: " + getFecha() +
                "\nFecha cotizacion actual: " + getFechaCotizacionActual() +
                "\nCódigo: " + getCodigo() +
                "\nTipo de operación: " + getTipoOperacion() +
                "\nCantidad: " + getCantidad() +
                "\nCotización: " + getCotizacion() +
                "\nCotización actual: " + getCotizacionActual();
    }
}
