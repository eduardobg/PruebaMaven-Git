package hello;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.joda.time.LocalTime;

public class HelloWorld {

    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
        System.out.println("----------------------");
        
        //InputStream arch = HelloWorld.class.getClassLoader().getResourceAsStream("informes/Recibo.jrxml");
        InputStream arch = HelloWorld.class.getClassLoader().getResourceAsStream("informes/Factura.jrxml");
        System.out.println( "Ubicacion de reporte " + arch.toString() );
        /*
        List<RecibosDatos> lr= new ArrayList();
        lr.add(new RecibosDatos("empresaName", "direccionNombre", "codigoName", 1, "producto1", 1, 15, 15));
        lr.add(new RecibosDatos("empresaName", "direccionNombre", "codigoName", 22, "producto2", 1, 40, 40));
        lr.add(new RecibosDatos("empresaName", "direccionNombre", "codigoName", 333, "producto3", 1, 10, 20));
        */
        List<DtoBoleta> lr= new ArrayList();
        //lr.add(new DtoBoleta("Clínica Veterianria San Pedro", "10246856422", "Juan Carlos Tito Carrizales", "AURELIO GARCÍA Y GARCÍA 1403, CERCADO DE LIMA 15081","(01) 164-0682", "960337121", "example@example.com"));
        lr.add(new DtoBoleta("Clínica Veterianria San Pedro", "10246856422", "Juan Carlos Tito Carrizales", "AURELIO GARCÍA Y GARCÍA 1403, CERCADO DE LIMA 15081", "(01) 164-0682","960337121","example@example.com", 1, "Alonso Geronimo Pérez", "Av.Sol 122 San Carlos, SJL", "74880271", "14/10/99", 1, "Hueso de Goma", 10, 10, 100, 80, 20));
        lr.add(new DtoBoleta("Clínica Veterianria San Pedro", "10246856422", "Juan Carlos Tito Carrizales", "AURELIO GARCÍA Y GARCÍA 1403, CERCADO DE LIMA 15081", "(01) 164-0682","960337121","example@example.com", 1, "Alonso Geronimo Pérez", "Av.Sol 122 San Carlos, SJL", "74880271", "14/10/99", 2, "Pastilla Amarilla", 20, 40, 100, 80, 20));
        lr.add(new DtoBoleta("Clínica Veterianria San Pedro", "10246856422", "Juan Carlos Tito Carrizales", "AURELIO GARCÍA Y GARCÍA 1403, CERCADO DE LIMA 15081", "(01) 164-0682","960337121","example@example.com", 1, "Alonso Geronimo Pérez", "Av.Sol 122 San Carlos, SJL", "74880271", "14/10/99", 2, "Examen Médico", 15, 30, 100, 80, 20));
        try{
            JasperReport jr = JasperCompileManager.compileReport(arch);
            Map<String, Object> pr = new HashMap<>();
            JRBeanCollectionDataSource jbcd = new JRBeanCollectionDataSource(lr);
            //JREmptyDataSource jre = new JREmptyDataSource();
            JasperPrint jp = JasperFillManager.fillReport(jr, pr, jbcd);
            JasperViewer.viewReport(jp);
        }catch (JRException e){
            e.printStackTrace();
        }

    }
}
