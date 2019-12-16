package ar.com.uade.Bean;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class Informe {
    private Asesor asesor;
    private String especie;
    private Date fecha;
    private String situacionMercado;
    private String relacionExterna;
    private String futuro;
    private String recomendacion;

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSituacionMercado() {
        return situacionMercado;
    }

    public void setSituacionMercado(String situacionMercado) {
        this.situacionMercado = situacionMercado;
    }

    public String getRelacionExterna() {
        return relacionExterna;
    }

    public void setRelacionExterna(String relacionExterna) {
        this.relacionExterna = relacionExterna;
    }

    public String getFuturo() {
        return futuro;
    }

    public void setFuturo(String futuro) {
        this.futuro = futuro;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public Informe(Asesor asesor, String especie, Date fecha, String situacionMercado, String relacionExterna, String futuro, String recomendacion) {
        this.asesor = asesor;
        this.especie = especie;
        this.fecha = fecha;
        this.situacionMercado = situacionMercado;
        this.relacionExterna = relacionExterna;
        this.futuro = futuro;
        this.recomendacion = recomendacion;
    }

    public DBObject toBson() {
        BasicDBObject doc = new BasicDBObject();

        doc.put("_id", ObjectId.get());
        doc.put("asesor", asesor.toBson());
        doc.put("especie", especie);
        doc.put("situacionMercado", situacionMercado);
        doc.put("relacionExterna", relacionExterna);
        doc.put("futuro", futuro);
        doc.put("recomendacion", recomendacion);

        return doc;
    }

    @Override
    public String toString() {
        return
                "Especie: " + especie +
                "\nAsesor: " + asesor +
                "\nSituacion del mercado: " + situacionMercado +
                "\nRelación externa: " + relacionExterna +
                "\nFuturo: " + futuro +
                "\nRecomendación: " + recomendacion;
    }
}
