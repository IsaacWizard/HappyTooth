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
public class Existente extends JFrame implements ActionListener{
    public String nombre, telefono, noCliente, fCita, hora, especialista, fecha, sexo;
    public int deuda;
    public static Existente exis;
    
    ImageIcon imgBuscar = new ImageIcon("buscar.png");
    ImageIcon imgBack = new ImageIcon("flecha.png");
    ImageIcon imgSave = new ImageIcon("salvar.png");
    
    String opc2[] = {"Ortodoncista", "Endodoncista", "Maxilofacial"};
    
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbTelefono = new JLabel("Telefono:");
    JLabel lbNoCliente = new JLabel("Número de cliente:");
    JLabel lbFCita = new JLabel("Fecha de cita:");
    JLabel lbHora = new JLabel("Hora:");
    JLabel lbEspecial = new JLabel("Especialista:");
    
    JLabel lbName = new JLabel();
    JLabel lbPhone = new JLabel();
    JLabel lbClient = new JLabel();
    JTextField txtDate = new JTextField(20);
    JTextField txtHour = new JTextField(20);
    JTextField txtBuscar = new JTextField(20);
    JLabel lbEspecialist = new JLabel();
    
    JComboBox cEspecial = new JComboBox(opc2);
     
    JButton buscar = new JButton(imgBuscar);
     JButton agendar = new JButton(imgSave);
     JButton volver = new JButton(imgBack);
     
     public Existente(){
        super("Cliente Existente");
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(183,247,238));
        
        buscar.addActionListener(this);
        agendar.addActionListener(this);
        volver.addActionListener(this);
        
        buscar.setBorder(null);
        buscar.setContentAreaFilled(false);
        buscar.setToolTipText("Buscar");
        buscar.setCursor(new Cursor(HAND_CURSOR));
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
        TextPrompt placeholderF = new TextPrompt("DD/MM/AAAA", txtDate);
        placeholderF.changeAlpha(0.75f);
        TextPrompt placeholderFC = new TextPrompt("Número de cuenta", txtBuscar);
        placeholderFC.changeAlpha(0.75f);
         TextPrompt placeholderH = new TextPrompt("18:00", txtHour);
        placeholderH.changeAlpha(0.75f);
        
        buscar.setBounds(170, 20, 40, 40);
        txtBuscar.setBounds(220, 25, 110, 25);
        lbNombre.setBounds(30, 80, 100, 25);
        lbName.setBounds(85, 80, 200, 25);
        lbTelefono.setBounds(30, 110, 100, 25);
        lbPhone.setBounds(90, 110, 200, 25);
        lbNoCliente.setBounds(30, 140, 120, 25);
        lbClient.setBounds(140, 140, 200, 25);
        lbFCita.setBounds(30, 170, 200, 25);
        txtDate.setBounds(120, 170, 128, 25);
        lbHora.setBounds(30, 200, 200, 25);
        txtHour.setBounds(65, 200, 170, 25);
        lbEspecial.setBounds(30, 230, 100, 25);
        cEspecial.setBounds(115, 230, 110, 25);
        agendar.setBounds(145, 295, 60, 60);
        volver.setBounds(20, 380, 80, 80);
        
        this.add(buscar);
        this.add(txtBuscar);
        this.add(lbNombre);
        this.add(lbName);
        this.add(lbTelefono);
        this.add(lbPhone);
        this.add(lbNoCliente);
        this.add(lbClient);
        this.add(lbFCita);
        this.add(txtDate);
        this.add(lbHora);
        this.add(txtHour);
        this.add(lbEspecial);
        this.add(cEspecial);
        this.add(agendar);
        this.add(volver);
        this.setVisible(true);
     }
     public void guardarOrtodo() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path6);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaOrt2=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
         String conta = Integer.toString(1+HappyT.tablaOrt2.size());
        HappyT.tablaOrt2.put(conta, exis); //guarda en el hash
                
                System.out.println("Guardado");

            FileOutputStream fo = new FileOutputStream(HappyT.path6);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaOrt2);
        oo.close();
        fo.close();
        
    }
    public void guardarEndodo() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path7);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaEnd2=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
         String conta = Integer.toString(1+HappyT.tablaEnd2.size());
        HappyT.tablaEnd2.put(conta, exis); //guarda en el hash
                
                System.out.println("Guardado");

            FileOutputStream fo = new FileOutputStream(HappyT.path7);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaEnd2);
        oo.close();
        fo.close();
    }
    public void guardarMaxi() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path8);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaMax2=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
         String conta = Integer.toString(1+HappyT.tablaMax2.size());
        HappyT.tablaMax2.put(conta, exis); //guarda en el hash
                
                System.out.println("Guardado");

            FileOutputStream fo = new FileOutputStream(HappyT.path8);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaMax2);
        oo.close();
        fo.close();
    }
    public void guardarCita() throws IOException, ClassNotFoundException, FileNotFoundException{
         FileInputStream fi = new FileInputStream(HappyT.path9);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaCitas2=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
        String conta = Integer.toString(1+HappyT.tablaCitas2.size());
        HappyT.tablaCitas2.put(conta, exis); //guarda en el hash
                
                System.out.println("Guardado");

            FileOutputStream fo = new FileOutputStream(HappyT.path9);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaCitas2);
        oo.close();
        fo.close();
    }
     public boolean Vacio(){ //comprober que estén vacios los textfield
        boolean r = false;
        r |= lbName.getText().isEmpty();
        r |=lbTelefono.getText().isEmpty();
        r |=lbClient.getText().isEmpty();
        r |=txtDate.getText().isEmpty();  
        r |=txtHour.getText().isEmpty();  
        return r;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object accion = ae.getSource();
        if(accion == volver){
            this.setVisible(false);
            AgCita ag = new AgCita();
        }
        if(accion == buscar){
            if(!txtBuscar.getText().isEmpty()){
                String busqueda = txtBuscar.getText();
                if(HappyT.tablaClientes.containsKey(busqueda)){
                    Anadir c = HappyT.tablaClientes.get(busqueda);
                    lbName.setText(c.nombre);
                    lbPhone.setText(c.telefono);
                    lbClient.setText(c.noCliente);
                    fecha = c.fecha;
                    sexo = c.sexo;
                    deuda = c.deuda;
                }
                else{
                    JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese número de cliente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese un número de cliente");
            }
        }
        if(accion == agendar){
            boolean r = Vacio();
            if(r == false){
                nombre = lbName.getText();
                telefono = lbTelefono.getText();
                noCliente = lbClient.getText();
                fCita = txtDate.getText();
                hora = txtHour.getText();
                especialista = (String)cEspecial.getSelectedItem();
                if(especialista.equals("Ortodoncista")){
                    deuda = deuda+600;
                }
                if(especialista.equals("Endodoncista")){
                    deuda = 800;;
                }
                if(especialista.equals("Maxilofacial")){
                    deuda = 1000;
                }
                boolean o=false, e=false, m=false;
                int contad = HappyT.tablaOrtodoncista.size();
        System.out.println(contad);
        for(int x=contad; x>0; x--){
            String X = Integer.toString(x);
           Anadir c = HappyT.tablaOrtodoncista.get(X);
           if(c.noCliente.equals(this.noCliente)){
               if(c.especialista.equals(this.especialista)){
                    o = true;
                }
           }
        }
        contad = HappyT.tablaEndodoncista.size();
        System.out.println(contad);
        for(int x=contad; x>0; x--){
            String X = Integer.toString(x);
           Anadir c = HappyT.tablaEndodoncista.get(X);
           if(c.noCliente.equals(this.noCliente)){
               if(c.especialista.equals(this.especialista)){
                    e = true;
                }
           }
        }
        contad = HappyT.tablaMaxilofacial.size();
        System.out.println(contad);
        for(int x=contad; x>0; x--){
            String X = Integer.toString(x);
           Anadir c = HappyT.tablaMaxilofacial.get(X);
           if(c.noCliente.equals(this.noCliente)){
               if(c.especialista.equals(this.especialista)){
                    m = true;
                }
           }
        }
        if(this.especialista.equals("Ortodoncista")){
            if(o==false){
                try { 
                guardarOrtodo();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        if(this.especialista.equals("Endodoncista")){
            if(e==false){
                try { 
                guardarEndodo();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        if(this.especialista.equals("Maxilofacial")){
            if(m==false){
                try { 
                guardarMaxi();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        try { 
                guardarCita();
            } catch (IOException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            }
        JOptionPane.showMessageDialog(null, "Cita registrada con éxito, Se agregaron $"+deuda+" a su deuda");
              this.setVisible(false);
              AgCita ag = new AgCita();
            }
            else{
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
        }
    }
}
