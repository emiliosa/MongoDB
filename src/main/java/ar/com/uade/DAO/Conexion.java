package ar.com.uade.DAO;

import ar.com.uade.Bean.Inversion;

import static com.mongodb.client.model.Updates.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Conexion {
    private static MongoCollection<Document> inversiones;

    private static MongoCollection<Document> getInversiones() {
        if (inversiones == null) {
            MongoClient mongoClient = MongoClients.create("mongodb://root:example@localhost:27018/?authSource=admin");
            MongoDatabase database = mongoClient.getDatabase("test");
            inversiones = database.getCollection("inversiones");
        }

        return inversiones;
    }

    public static List<String> recuperar(Document filtro) {
        System.out.println("RECUPERAR");
        System.out.println(filtro.toJson());

        List<String> resultados = new ArrayList<>();

        for (Document document : getInversiones().find(filtro)) {
            resultados.add(document.toJson());
        }

        return resultados;
    }

    public static void guardar(Inversion inversion) {
        System.out.println("GUARDAR");
        System.out.println(inversion);

        getInversiones().insertOne(inversion.toDocument());
    }

    /**
     * Se actualizan las colecciones incrustadas")
     */
    public static void actualizar(Document filtro, Inversion inversion) {
        System.out.println("ACTUALIZAR");
        System.out.println("Filtros: " + filtro.toJson() + "\nInversión: " + inversion);

        for (Document document : getInversiones().find(filtro)) {
            System.out.println(document.toJson());
        }

        getInversiones().updateMany(
                filtro,
                combine(
                        addEachToSet("cotizaciones", inversion.getCotizacionesBson()),
                        addEachToSet("historialOperaciones", inversion.getHistorialOperacionesBson()),
                        addEachToSet("informes", inversion.getInformesBson())
                )
        );
    }

    public static void eliminar(Document filtro) {
        System.out.println("ELIMINAR");
        System.out.println(filtro.toJson());

        long result = getInversiones().deleteMany(filtro).getDeletedCount();

        System.out.println(result);
    }
}


