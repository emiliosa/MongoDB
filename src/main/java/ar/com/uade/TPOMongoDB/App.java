package ar.com.uade.TPOMongoDB;

import ar.com.uade.Bean.Inversion;
import ar.com.uade.Bean.TipoOperacion;
import ar.com.uade.DAO.Conexion;
import org.bson.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Document filtro = new Document();
        Inversion inversion = new Inversion();

        filtro.put("codigo", "DICA");
        inversion.setCodigo("DICA");

        List<String> resultados = Conexion.recuperar(filtro);

        for (String item: resultados){
            System.out.println(item);
        }

        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ZZZ").parse("2019-11-23 00:00:00.000 UTC");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        inversion.setFecha(fecha);
        inversion.setTipoOperacion(TipoOperacion.COMPRA);
        inversion.setCantidad(1000);
        inversion.setCotizacion(98.55);
        inversion.setCotizacionActual(98.55);
        inversion.setMonto(98.55 * 1000);

        Conexion.guardar(inversion);

        filtro.put("codigo", "DICA");
        filtro.put("cantidad", 1000);

        inversion = new Inversion();
        inversion.setCodigo("DICA");
        inversion.setCantidad(1500);

        Conexion.actualizar(filtro, inversion);

        filtro.put("codigo", "DICA");
        filtro.put("cantidad", 1500);

        Conexion.eliminar(filtro);
    }
}
