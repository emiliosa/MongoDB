package ar.com.uade.Bean;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class Mercado {
    private String especie;
    private Moneda moneda;
    private Date fecha;
    private double cotizacionApertura;
    private double cotizacionCierre;
    private double cotizacionMin;
    private double cotizacionMax;
    private int volumenNominal;
    private int cantidadOperaciones;

    public Mercado(String especie, Moneda moneda, Date fecha, double cotizacionApertura, double cotizacionCierre, double cotizacionMin, double cotizacionMax, int volumenNominal, int cantidadOperaciones) {
        this.especie = especie;
        this.moneda = moneda;
        this.fecha = fecha;
        this.cotizacionApertura = cotizacionApertura;
        this.cotizacionCierre = cotizacionCierre;
        this.cotizacionMin = cotizacionMin;
        this.cotizacionMax = cotizacionMax;
        this.volumenNominal = volumenNominal;
        this.cantidadOperaciones = cantidadOperaciones;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCotizacionApertura() {
        return cotizacionApertura;
    }

    public void setCotizacionApertura(double cotizacionApertura) {
        this.cotizacionApertura = cotizacionApertura;
    }

    public double getCotizacionCierre() {
        return cotizacionCierre;
    }

    public void setCotizacionCierre(double cotizacionCierre) {
        this.cotizacionCierre = cotizacionCierre;
    }

    public double getCotizacionMin() {
        return cotizacionMin;
    }

    public void setCotizacionMin(double cotizacionMin) {
        this.cotizacionMin = cotizacionMin;
    }

    public double getCotizacionMax() {
        return cotizacionMax;
    }

    public void setCotizacionMax(double cotizacionMax) {
        this.cotizacionMax = cotizacionMax;
    }

    public int getVolumenNominal() {
        return volumenNominal;
    }

    public void setVolumenNominal(int volumenNominal) {
        this.volumenNominal = volumenNominal;
    }

    public int getCantidadOperaciones() {
        return cantidadOperaciones;
    }

    public void setCantidadOperaciones(int cantidadOperaciones) {
        this.cantidadOperaciones = cantidadOperaciones;
    }

    public DBObject toBson() {
        BasicDBObject doc = new BasicDBObject();

        doc.put("_id", ObjectId.get());
        doc.put("especie", especie);
        doc.put("moneda", moneda.toString());
        doc.put("fecha", fecha);
        doc.put("cotizacionApertura", cotizacionApertura);
        doc.put("cotizacionCierre", cotizacionCierre);
        doc.put("cotizacionMax", cotizacionMax);
        doc.put("cotizacionMin", cotizacionMin);
        doc.put("volumenNominal", volumenNominal);
        doc.put("cantidadOperaciones", cantidadOperaciones);

        return doc;
    }

    @Override
    public String toString() {
        return
                "Especie: " + especie +
                "\nMoneda: " + moneda.toString() +
                "\nFecha: " + fecha +
                "\nCotización apertura: " + cotizacionApertura +
                "\nCotización cierre: " + cotizacionCierre +
                "\nCotización mínima: " + cotizacionMin +
                "\nVolumen nominal: " + volumenNominal +
                "\nCantidad de operaciones: " + cantidadOperaciones;
    }
}
