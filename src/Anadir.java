import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Anadir extends JFrame implements ActionListener{
//    public static String path="Clientes.obj";
//    public static String path2="Ortodoncista.obj";
//    public static String path3="Endodoncista.obj";
//    public static String path4="Maxilofacial.obj";
//    public static String path5="Citas.obj";
//    public static Hashtable <String,Anadir> tablaClientes = new Hashtable <String, Anadir> ();
//    public static Hashtable <String,Anadir> tablaOrtodoncista = new Hashtable <String, Anadir> ();
//    public static Hashtable <String,Anadir> tablaEndodoncista = new Hashtable <String, Anadir> ();
//    public static Hashtable <String,Anadir> tablaMaxilofacial = new Hashtable <String, Anadir> ();
//    public static Hashtable <String,Anadir> tablaCitas = new Hashtable <String, Anadir> ();
//director1000, gerente800, supervisor500 y operador300, nombre puesto, horas, horas extras80
    public String nombre, telefono, fecha, sexo, fechaC, hora, especialista, noCliente;
    public int deuda =0;
    public static int contador=0;
    public static Anadir inst;
    String opc1[] = {"Masculino", "Femenino"};
    String opc2[] = {"Ortodoncista", "Endodoncista", "Maxilofacial"};
    
    ImageIcon imgBack = new ImageIcon("flecha.png");
    ImageIcon imgSave = new ImageIcon("salvar.png");
    
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbTelefono = new JLabel("Telefono:");
    JLabel lbFecha = new JLabel("Fecha de nacimiento:");
    JLabel lbSexo = new JLabel("Sexo:");
    JLabel lbFCita = new JLabel("Fecha de cita:");
    JLabel lbHora = new JLabel("Hora:");
    JLabel lbEspecial = new JLabel("Especialista:");
    
    JTextField txtNombre = new JTextField(20);
    JTextField txtTelefono = new JTextField(20);
    JTextField txtFecha = new JTextField(20);
    JTextField txtFCita = new JTextField(20);
    JTextField txtHora = new JTextField(20);
    JTextField txtEspecial = new JTextField(20);
    
    JComboBox cSexo = new JComboBox(opc1);
     JComboBox cEspecial = new JComboBox(opc2);
     
     JButton agendar = new JButton(imgSave);
     JButton volver = new JButton(imgBack);
    
    public Anadir(){
        super("Cliente nuevo");
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(183,247,238));
        
        agendar.addActionListener(this);
        volver.addActionListener(this);
        
        agendar.setBorder(null);
        agendar.setContentAreaFilled(false);
        agendar.setToolTipText("Registrar Cita");
        agendar.setCursor(new Cursor(HAND_CURSOR));
        volver.setBorder(null);
        volver.setContentAreaFilled(false);
        volver.setToolTipText("Volver a la página anterior");
        volver.setCursor(new Cursor(HAND_CURSOR));
        //una libreria que coloqué en el paquete para no tener que importarla
        //Le agrega un texto sugerente al textfield
        TextPrompt placeholderF = new TextPrompt("DD/MM/AAAA", txtFecha);
        placeholderF.changeAlpha(0.75f);
        TextPrompt placeholderFC = new TextPrompt("DD/MM/AAAA", txtFCita);
        placeholderFC.changeAlpha(0.75f);
         TextPrompt placeholderH = new TextPrompt("18:00", txtHora);
        placeholderH.changeAlpha(0.75f);
        
        lbNombre.setBounds(30, 20, 100, 25);
        txtNombre.setBounds(85, 20, 200, 25);
        lbTelefono.setBounds(30, 50, 100, 25);
        txtTelefono.setBounds(85, 50, 200, 25);
        lbFecha.setBounds(30, 80, 200, 25);
        txtFecha.setBounds(160, 80, 128, 25);
        lbSexo.setBounds(30, 110, 100, 25);
        cSexo.setBounds(70, 110, 110, 25);
        lbFCita.setBounds(30, 140, 200, 25);
        txtFCita.setBounds(120, 140, 170, 25);
        lbHora.setBounds(30, 170, 100, 25);
        txtHora.setBounds(73, 170, 200, 25);
        lbEspecial.setBounds(30, 200, 100, 25);
        cEspecial.setBounds(115, 200, 110, 25);
        agendar.setBounds(145, 265, 60, 60);
        volver.setBounds(20, 380, 80, 80);
        
        this.add(lbNombre);
        this.add(txtNombre);
        this.add(lbTelefono);
        this.add(txtTelefono);
        this.add(lbFecha);
        this.add(txtFecha);
        this.add(lbSexo);
        this.add(cSexo);
        this.add(lbFCita);
        this.add(txtFCita);
        this.add(lbHora);
        this.add(txtHora);
        this.add(lbEspecial);
        this.add(cEspecial);
        this.add(agendar);
        this.add(volver);
        this.setVisible(true);
    }
    public boolean Vacio(){ //comprober que estén vacios los textfield
        boolean r = false;
        r |= txtNombre.getText().isEmpty();
        r |=txtTelefono.getText().isEmpty();
        r |=txtFecha.getText().isEmpty();  
        r |=txtFCita.getText().isEmpty();  
        r |=txtHora.getText().isEmpty();  
        return r;
    }
    public void guardarCliente() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaClientes=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
        
        contador = HappyT.tablaClientes.size();
        if(contador==0){ //no hay nada en la tabla
            contador = contador+1;
            System.out.println(contador);
                this.noCliente = Integer.toString(contador);
                String conta = this.noCliente;
                
                HappyT.tablaClientes.put(conta, inst); //guarda en el hash
                
                System.out.println("Guardado");
                System.out.println(contador);
            }
            else{
//                for(int x=0; x<100; x++){
//                    String X = Integer.toString(x);
//                    if(tabla.containsKey(X)){
//                        
//                    }
//                }
contador = contador+1;
                  this.noCliente = Integer.toString(contador);
                String conta = this.noCliente;
                
                HappyT.tablaClientes.put(conta, inst); //guarda en el hash

                System.out.println("Guardado");  
                System.out.println(contador);
            }
            FileOutputStream fo = new FileOutputStream(HappyT.path);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaClientes);
        oo.close();
        fo.close();
    }
    public void guardarOrtodo() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path2);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaOrtodoncista=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
         String conta = Integer.toString(1+HappyT.tablaOrtodoncista.size());
        HappyT.tablaOrtodoncista.put(conta, inst); //guarda en el hash
                
                System.out.println("Guardado");
                System.out.println(contador);

            FileOutputStream fo = new FileOutputStream(HappyT.path2);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaOrtodoncista);
        oo.close();
        fo.close();
        
    }
    public void guardarEndodo() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path3);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaEndodoncista=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
         String conta = Integer.toString(1+HappyT.tablaEndodoncista.size());
        HappyT.tablaEndodoncista.put(conta, inst); //guarda en el hash
                
                System.out.println("Guardado");
                System.out.println(contador);

            FileOutputStream fo = new FileOutputStream(HappyT.path3);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaEndodoncista);
        oo.close();
        fo.close();
    }
    public void guardarMaxi() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path4);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaMaxilofacial=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
         String conta = Integer.toString(1+HappyT.tablaMaxilofacial.size());
        HappyT.tablaMaxilofacial.put(conta, inst); //guarda en el hash
                
                System.out.println("Guardado");
                System.out.println(contador);

            FileOutputStream fo = new FileOutputStream(HappyT.path4);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaMaxilofacial);
        oo.close();
        fo.close();
    }
    public void guardarCita() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path5);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaCitas=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
        String conta = Integer.toString(1+HappyT.tablaCitas.size());
        HappyT.tablaCitas.put(conta, inst); //guarda en el hash
                
                System.out.println("Guardado");
                System.out.println(contador);

            FileOutputStream fo = new FileOutputStream(HappyT.path5);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaCitas);
        oo.close();
        fo.close();
    }
    public static int getContador(){
        contador = HappyT.tablaClientes.size();
        return contador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj == agendar){
            boolean r;
            r = Vacio();
            if(r == false){
                nombre = txtNombre.getText();
                telefono = txtTelefono.getText();
                fecha = txtFecha.getText();
                sexo = (String)cSexo.getSelectedItem();
                fechaC = txtFCita.getText();
                hora = txtHora.getText();
                especialista = (String)cEspecial.getSelectedItem();
                if(especialista.equals("Ortodoncista")){
                    deuda = 600;
                }
                if(especialista.equals("Endodoncista")){
                    deuda = 800;;
                }
                if(especialista.equals("Maxilofacial")){
                    deuda = 1000;
                }
                try {
                guardarCliente();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
              if(especialista.equals("Ortodoncista")){
                  try { 
                guardarOrtodo();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
              }
              if(especialista.equals("Endodoncista")){
                  try {
                guardarEndodo();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
              }
              if(especialista.equals("Maxilofacial")){
                  try {      
                guardarMaxi();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
              }
              try {
                guardarCita();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
              JOptionPane.showMessageDialog(null, "Cita registrada con éxito, su número de cliente es "+noCliente+"\n"+"Se agregaron $"+deuda+" a su deuda");
              this.setVisible(false);
              AgCita ag = new AgCita();
            }
            else{
            JOptionPane.showMessageDialog(null, "No deje espacios en blanco");
            }
        }
        else if(obj == volver){
            this.setVisible(false);
            AgCita bt = new AgCita();
        }
        
    }
}
