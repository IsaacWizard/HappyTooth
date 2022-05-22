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
public class Pagar extends JFrame implements ActionListener{
    public String nombre, telefono, noCliente, fCita, hora, especialista, fecha, sexo;
    public int deuda;
    
    ImageIcon imgBuscar = new ImageIcon("buscar.png");
    ImageIcon imgBack = new ImageIcon("flecha.png");
    ImageIcon imgAbonar = new ImageIcon("calendario.png");
    ImageIcon imgLiquidar = new ImageIcon("pago-por-clic.png");
    
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbTelefono = new JLabel("Telefono:");
    JLabel lbNoCliente = new JLabel("Número de cliente:");
    JLabel lbDeuda = new JLabel("Deuda Total:");
    JTextField txtBuscar = new JTextField(20);
    
    JLabel lbName = new JLabel();
    JLabel lbPhone = new JLabel();
    JLabel lbClient = new JLabel();
    JLabel lbDeud = new JLabel();
    
     
    JButton buscar = new JButton(imgBuscar);
     JButton abonar = new JButton(imgAbonar);
     JButton volver = new JButton(imgBack);
     JButton liquidar = new JButton(imgLiquidar);
     
     public Pagar(){
        super("Pagar");
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(183,247,238));
        
        buscar.addActionListener(this);
        abonar.addActionListener(this);
        volver.addActionListener(this);
        liquidar.addActionListener(this);
        
        buscar.setBorder(null);
        buscar.setContentAreaFilled(false);
        buscar.setToolTipText("Buscar");
        buscar.setCursor(new Cursor(HAND_CURSOR));
        abonar.setBorder(null);
        abonar.setContentAreaFilled(false);
        abonar.setToolTipText("Abonar a deuda");
        abonar.setCursor(new Cursor(HAND_CURSOR));
        liquidar.setBorder(null);
        liquidar.setContentAreaFilled(false);
        liquidar.setToolTipText("Liquidar deuda");
        liquidar.setCursor(new Cursor(HAND_CURSOR));
        volver.setBorder(null);
        volver.setContentAreaFilled(false);
        volver.setToolTipText("Volver a la página anterior");
        volver.setCursor(new Cursor(HAND_CURSOR));
        //una libreria que coloqué en el paquete para no tener que importarla
        //Le agrega un texto sugerente al textfield
        TextPrompt placeholderFC = new TextPrompt("Número de cuenta", txtBuscar);
        placeholderFC.changeAlpha(0.75f);
        
        buscar.setBounds(170, 20, 40, 40);
        txtBuscar.setBounds(220, 25, 110, 25);
        lbNombre.setBounds(30, 80, 100, 25);
        lbName.setBounds(85, 80, 200, 25);
        lbTelefono.setBounds(30, 110, 100, 25);
        lbPhone.setBounds(90, 110, 200, 25);
        lbNoCliente.setBounds(30, 140, 120, 25);
        lbClient.setBounds(140, 140, 200, 25);
        lbDeuda.setBounds(30, 200, 200, 25);
        lbDeud.setBounds(120, 200, 128, 25);
        abonar.setBounds(70, 275, 60, 60);
        liquidar.setBounds(210, 275, 60, 60);
        volver.setBounds(20, 380, 80, 80);
        
        this.add(buscar);
        this.add(txtBuscar);
        this.add(lbNombre);
        this.add(lbName);
        this.add(lbTelefono);
        this.add(lbPhone);
        this.add(lbNoCliente);
        this.add(lbClient);
        this.add(lbDeuda);
        this.add(lbDeud);
        this.add(liquidar);
        this.add(abonar);
        this.add(volver);
        this.setVisible(true);
     }
     public boolean Vacio(){ //comprober que estén vacios los textfield
        boolean r = false;
        r |= lbName.getText().isEmpty();
        r |=lbTelefono.getText().isEmpty();
        r |=lbClient.getText().isEmpty();
        return r;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object accion = ae.getSource();
        if(accion == volver){
            this.setVisible(false);
            Menu menu = new Menu();
        }
        if(accion == buscar){
            if(!txtBuscar.getText().isEmpty()){
                String busqueda = txtBuscar.getText();
                if(HappyT.tablaClientes.containsKey(busqueda)){
                    Anadir c = HappyT.tablaClientes.get(busqueda);
                    lbName.setText(c.nombre);
                    lbPhone.setText(c.telefono);
                    lbClient.setText(c.noCliente);
                    lbDeud.setText(Integer.toString(c.deuda));
                }
                else{
                    JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese número de cliente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese un número de cliente");
            }
        }
        if(accion==abonar){
            boolean r = Vacio();
            if(r == false){
                if(!txtBuscar.getText().isEmpty()){
                String busqueda = txtBuscar.getText();
                if(HappyT.tablaClientes.containsKey(busqueda)){
                    Anadir c = HappyT.tablaClientes.get(busqueda);
                    try{
                    String d = JOptionPane.showInputDialog("Ingrese la cantidad que desea abonar(en valor entero):");
                    int de = Integer.parseInt(d);
                    if(de<=c.deuda){
                       c.deuda = c.deuda-de;
                       deuda = c.deuda;
                       JOptionPane.showMessageDialog(null, "Se abonó correctamente, su deuda ahora es de : $"+c.deuda);
                       try {
                guardar();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No puede abonar una mayor cantidad que su deuda");
                    }
                    }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese una opción valída");
        }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese número de cliente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese un número de cliente");
            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
            
            this.setVisible(false);
            Menu menu = new Menu();
        }
        if(accion==liquidar){
            boolean r = Vacio();
            if(r == false){
                if(!txtBuscar.getText().isEmpty()){
                String busqueda = txtBuscar.getText();
                if(HappyT.tablaClientes.containsKey(busqueda)){
                    Anadir c = HappyT.tablaClientes.get(busqueda);
                    deuda = 0;
                    JOptionPane.showMessageDialog(null, "Liquidación de deuda efectuada con éxito");
                    try {
                guardar();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese número de cliente");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese un número de cliente");
            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
            this.setVisible(false);
            Menu menu = new Menu();
        }
    }
    public void guardar() throws IOException, ClassNotFoundException, FileNotFoundException{
        FileInputStream fi = new FileInputStream(HappyT.path);
        ObjectInputStream oi = new ObjectInputStream(fi);
        HappyT.tablaClientes=(Hashtable)oi.readObject();
        fi.close();
        oi.close();
                String busqueda = txtBuscar.getText();
                    Anadir c = HappyT.tablaClientes.get(busqueda);
                    c.deuda = deuda;
                HappyT.tablaClientes.put(c.noCliente, c); //guarda en el hash
                
                System.out.println("Guardado");
        
        FileOutputStream fo = new FileOutputStream(HappyT.path);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(HappyT.tablaClientes);
        oo.close();
        fo.close();
    }
}
