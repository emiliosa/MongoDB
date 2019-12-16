package ar.com.uade.TPOMongoDB;

import ar.com.uade.Bean.*;
import ar.com.uade.DAO.Conexion;
import org.bson.Document;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Document filtro = new Document();

        filtro.put("especie", "DICA");

        List<String> resultados = Conexion.recuperar(filtro);

        for (String item : resultados) {
            System.out.println(toPrettyFormat(item));
        }

        Conexion.guardar(prepareForInsert());

        filtro.put("codigo", "DICA");

        Conexion.actualizar(filtro, prepareForUpdate());

        filtro.put("codigo", "DICA");

        Conexion.eliminar(filtro);
    }

    private static Date setDate(String strDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ZZZ").parse(strDate + " 00:00:00.000 UTC");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private static String toPrettyFormat(String jsonString)
    {
        JSONObject json = new JSONObject(jsonString);
        return json.toString(4);
    }

    private static Inversion prepareForInsert() {
        List<Mercado> cotizaciones = new ArrayList<>();

        cotizaciones.add(
                new Mercado(
                        "DICA",
                        Moneda.PESO_ARGENTINO,
                        setDate("2019-12-13"),
                        4.649,
                        4.800,
                        4.607,
                        4.800,
                        517055,
                        315
                )
        );

        cotizaciones.add(
                new Mercado(
                        "DICA",
                        Moneda.PESO_ARGENTINO,
                        setDate("2019-12-12"),
                        4.701,
                        4.649,
                        4.550,
                        4.701,
                        675496,
                        356
                )
        );

        List<Operacion> historialOperaciones = new ArrayList<>();
        Operador operador = new Operador("German", "Marin", 33123456);
        Asesor asesor = new Asesor("German", "Marin", 33123456);

        historialOperaciones.add(
                new Operacion(
                        "DICA",
                        setDate("2019-12-10"),
                        Moneda.PESO_ARGENTINO,
                        4.571,
                        1094,
                        50000.00,
                        TipoOperacion.COMPRA,
                        operador,
                        asesor
                )
        );

        List<Informe> informes = new ArrayList<>();

        informes.add(
                new Informe(
                        asesor,
                        "DICA",
                        setDate("2019-12-10"),
                        "Tendencia alcista corto plazo",
                        "Riesgo país lateralizando",
                        "Alta volatilidad",
                        "Toma de ganancias"
                )
        );

        return new Inversion(
                setDate("2019-11-23"),
                "DICA",
                TipoOperacion.COMPRA,
                1094,
                Moneda.PESO_ARGENTINO,
                4.571 * 10 * 1094,
                cotizaciones,
                historialOperaciones,
                informes
        );
    }

    private static Inversion prepareForUpdate() {
        Inversion inversion = new Inversion();

        List<Informe> informes = new ArrayList<>();

        informes.add(
                new Informe(
                        new Asesor("Carlos", "Viñuales", 34456789),
                        "DICA",
                        setDate("2019-10-02"),
                        "Tendencia bajista corto plazo",
                        "Riesgo país en alza",
                        "Alta volatilidad",
                        "Mirar de arafue"
                )
        );

        inversion.setInformes(informes);

        return inversion;
    }


}
