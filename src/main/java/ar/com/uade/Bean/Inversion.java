package ar.com.uade.Bean;

import com.mongodb.DBObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Inversion {
    private Date fecha;
    private String especie;
    private TipoOperacion tipoOperacion;
    private int cantidad;
    private Moneda moneda;
    private double monto;
    private List<Mercado> cotizaciones;
    private List<Operacion> historialOperaciones;
    private List<Informe> informes;

    public Inversion() {
        this.cotizaciones = new ArrayList<>();
        this.historialOperaciones = new ArrayList<>();
        this.informes = new ArrayList<>();
    }

    public Inversion(Date fecha, String especie, TipoOperacion tipoOperacion, int cantidad, Moneda moneda, double monto, List<Mercado> cotizaciones, List<Operacion> historialOperaciones, List<Informe> informes) {
        this.fecha = fecha;
        this.especie = especie;
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
        this.moneda = moneda;
        this.monto = monto;
        this.cotizaciones = cotizaciones;
        this.historialOperaciones = historialOperaciones;
        this.informes = informes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public List<Mercado> getCotizaciones() {
        return cotizaciones;
    }

    public List<DBObject> getCotizacionesBson() {
        List<DBObject> cotizaciones = new ArrayList<>();

        for (Mercado mercado: getCotizaciones()) {
            cotizaciones.add(mercado.toBson());
        }

        return cotizaciones;
    }

    public void setCotizaciones(List<Mercado> cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public List<Operacion> getHistorialOperaciones() {
        return historialOperaciones;
    }

    public List<DBObject> getHistorialOperacionesBson() {
        List<DBObject> historialOperaciones = new ArrayList<>();

        for (Operacion operacion: getHistorialOperaciones()) {
            historialOperaciones.add(operacion.toBson());
        }

        return historialOperaciones;
    }

    public void setHistorialOperaciones(List<Operacion> historialOperaciones) {
        this.historialOperaciones = historialOperaciones;
    }

    public List<Informe> getInformes() {
        return informes;
    }

    public List<DBObject> getInformesBson() {
        List<DBObject> informes = new ArrayList<>();

        for (Informe informe: getInformes()) {
            informes.add(informe.toBson());
        }

        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }

    public Document toDocument() {
        Document doc = new Document();
        doc
            .append("fecha", fecha)
            .append("especie", especie)
            .append("tipoOperacion", tipoOperacion.toString())
            .append("cantidad", cantidad)
            .append("moneda", moneda.toString())
            .append("monto", monto)
            .append("cotizaciones", getCotizacionesBson())
            .append("historialOperaciones", getHistorialOperacionesBson())
            .append("informes", getInformesBson());

        return doc;
    }

    @Override
    public String toString() {
        return
                "Fecha: " + fecha +
                "\nEspecie: " + especie +
                "\nTipo de operación: " + tipoOperacion +
                "\nCantidad: " + cantidad +
                "\nMoneda: " + moneda +
                "\nCotizaciones: " + cotizaciones +
                "\nHistorial de operaciones: " + historialOperaciones +
                "\nInformes: " + informes;
    }
}
