import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
public class TablaClientes extends JFrame{
    public String nombre, telefono, noCliente, fecha, sexo;
    public int deuda;
    public static int contad;
    String[] vector = new String[6];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm = new DefaultTableModel();
    
    public TablaClientes(){
        super("Clientes");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pnl = new JPanel();
        //Arreglo de objetos con el contenido de las columnas
        Object[] datos = new Object[6];
        //la tabla con el modelo DefaultTableModel
        final JTable miTabla = new JTable(dtm);
        //Titulo de las columnas
        
            dtm.addColumn("Nombre");
            dtm.addColumn("Telefono");
            dtm.addColumn("No. De cliente");
            dtm.addColumn("Fecha de nacimiento");
            dtm.addColumn("Sexo");
            dtm.addColumn("Deuda");
            
                //Tamaño de la tabla
        miTabla.setPreferredScrollableViewportSize(new Dimension(200,100));
        //Scroll que se agrega a la JTable
        JScrollPane scroll = new JScrollPane(miTabla);
        //Agregamos el scroll al contenedor
        getContentPane().add(scroll, BorderLayout.CENTER);
        contad = Anadir.getContador();
        System.out.println(contad);
        for(int x=contad; x>0; x--){
            String X = Integer.toString(x);
           Anadir c = HappyT.tablaClientes.get(X);
           guardar(c.nombre, c.telefono, c.noCliente, c.fecha, c.sexo, c.deuda);
        }
        
        show();
    }
    public void guardar(String nombre, String telefono, String noCliente, String fecha, String sexo, int deuda){
        String d = Integer.toString(deuda);
        vector[0]=nombre;
        vector[1]=telefono;
        vector[2]=noCliente;
        vector[3]=fecha;
        vector[4]=sexo;
        vector[5]=d;
        dtm.addRow(vector);
    }
}
