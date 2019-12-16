package ar.com.uade.Bean;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class Operacion {
    private String especie;
    private Date fechaOperacion;
    private Moneda moneda;
    private double cotizacion;
    private int cantidadNominal;
    private double importe;
    private TipoOperacion tipoOperacion;
    private Asesor operador;
    private Asesor asesor;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getCantidadNominal() {
        return cantidadNominal;
    }

    public void setCantidadNominal(int cantidadNominal) {
        this.cantidadNominal = cantidadNominal;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Asesor getOperador() {
        return operador;
    }

    public void setOperador(Asesor operador) {
        this.operador = operador;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public Operacion(String especie, Date fechaOperacion, Moneda moneda, double cotizacion, int cantidadNominal, double importe, TipoOperacion tipoOperacion, Asesor operador, Asesor asesor) {
        this.especie = especie;
        this.fechaOperacion = fechaOperacion;
        this.cotizacion = cotizacion;
        this.moneda = moneda;
        this.importe = importe;
        this.cantidadNominal = cantidadNominal;
        this.tipoOperacion = tipoOperacion;
        this.operador = operador;
        this.asesor = asesor;
    }

    public DBObject toBson() {
        BasicDBObject doc = new BasicDBObject();

        doc.put("_id", ObjectId.get());
        doc.put("especie", especie);
        doc.put("moneda", moneda.toString());
        doc.put("cotizacion", cotizacion);
        doc.put("cantidadNominal", cantidadNominal);
        doc.put("importe", importe);
        doc.put("operador", operador.toBson());
        doc.put("asesor", asesor.toBson());

        return doc;
    }

    @Override
    public String toString() {
        return
                "Especie: " + especie +
                "\nMoneda: " + moneda.toString() +
                "\nCotización: " + cotizacion +
                "\nCantidad nominal: " + cantidadNominal +
                "\nImporte: " + importe +
                "\nOperador: " + operador +
                "\nAsesor: " + asesor;
    }
}
