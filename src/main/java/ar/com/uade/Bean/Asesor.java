package ar.com.uade.Bean;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

public class Asesor {
    private String nombre;
    private String apellido;
    private int documento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Asesor(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    public DBObject toBson() {
        BasicDBObject doc = new BasicDBObject();

        doc.put("_id", ObjectId.get());
        doc.put("nombre", nombre);
        doc.put("apellido", apellido);
        doc.put("documento", documento);

        return doc;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDocumento: " + documento;
    }
}
