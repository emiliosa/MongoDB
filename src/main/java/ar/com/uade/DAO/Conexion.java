package ar.com.uade.DAO;

import ar.com.uade.Bean.Inversion;

import static com.mongodb.client.model.Updates.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

	public static Document setDocument(Inversion inversion) {
		Document inversionDoc = new Document();
		for (Field field: Inversion.class.getDeclaredFields()) {
			Object value = Conexion.callGetter(inversion, field.getName());
			boolean expression = true;
			try {
				expression = (value != null && Integer.parseInt(value.toString()) != 0 && Double.parseDouble(value.toString()) != 0.00);
			} catch (NumberFormatException e) {
				// nothing here
			} finally {
				if (expression) {
					inversionDoc.put(field.getName(), value);
				}
			}
		}

		return inversionDoc;
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

		Document inversionDoc = new Document();
		inversionDoc
				.append("fecha", inversion.getFecha())
				.append("fechaCotizacionActual", inversion.getFechaCotizacionActual())
				.append("codigo", inversion.getCodigo())
				.append("tipoOperacion", inversion.getTipoOperacion().toString())
				.append("cantidad", inversion.getCantidad())
				.append("cotizacion", inversion.getCotizacion())
				.append("cotizacionActual", inversion.getCotizacionActual())
				.append("monto", inversion.getMonto());

		getInversiones().insertOne(inversionDoc);
	}

	public static void actualizar(Document filtro, Inversion inversion) {
		System.out.println("ACTUALIZAR");
		System.out.println("Filtros: " + filtro.toJson() + "\nInversión: " + inversion);

		for (Document document : getInversiones().find(filtro)) {
			System.out.println(document.toJson());
		}

		getInversiones().updateMany(
				filtro,
				combine(
						set("fecha", inversion.getFecha()),
						currentDate("fechaCotizacionActual"),
						set("codigo", inversion.getCodigo()),
						set("tipoOperacion", inversion.getTipoOperacion()),
						set("cantidad", inversion.getCantidad()),
						set("cotizacion", inversion.getCotizacion()),
						set("cotizacionActual", inversion.getCotizacionActual()),
						set("monto", inversion.getMonto())
				)
		);
	}

	public static void eliminar(Document filtro) {
		System.out.println("ELIMINAR");
		System.out.println(filtro.toJson());

		long result = getInversiones().deleteMany(filtro).getDeletedCount();

		System.out.println(result);
	}

	private static Object callGetter(Object obj, String fieldName){
		PropertyDescriptor pd;
		Object result = null;
		try {
			pd = new PropertyDescriptor(fieldName, obj.getClass());
			result = pd.getReadMethod().invoke(obj);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
			e.printStackTrace();
		}

		return result;
	}
}


