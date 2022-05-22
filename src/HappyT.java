import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
import java.util.Hashtable;
public class HappyT extends JFrame implements ActionListener{

    public static String path="Clientes.obj";
    public static String path2="Ortodoncista.obj";
    public static String path3="Endodoncista.obj";
    public static String path4="Maxilofacial.obj";
    public static String path5="Citas.obj";
    public static String path6="Ort.obj";
    public static String path7="End.obj";
    public static String path8="Max.obj";
    public static String path9="Citas2.obj";
    public static Hashtable <String,Anadir> tablaClientes = new Hashtable <String, Anadir> ();
    public static Hashtable <String,Anadir> tablaOrtodoncista = new Hashtable <String, Anadir> ();
    public static Hashtable <String,Anadir> tablaEndodoncista = new Hashtable <String, Anadir> ();
    public static Hashtable <String,Anadir> tablaMaxilofacial = new Hashtable <String, Anadir> ();
    public static Hashtable <String,Anadir> tablaCitas = new Hashtable <String, Anadir> ();
    public static Hashtable <String,Existente> tablaOrt2 = new Hashtable <String, Existente> ();
    public static Hashtable <String,Existente> tablaEnd2 = new Hashtable <String, Existente> ();
    public static Hashtable <String,Existente> tablaMax2 = new Hashtable <String, Existente> ();
    public static Hashtable <String,Existente> tablaCitas2 = new Hashtable <String, Existente> ();
    
    public static HappyT inst;
    public static int user;
    ImageIcon fondo = new ImageIcon("fondoDientes3.png");
    JTextField txtUsuario = new JTextField(10);
    JPasswordField txtContra = new JPasswordField(10);
    
    JButton ingresar = new JButton("Ingresar");
    JButton olvido = new JButton("Olvidé mi contraseña");
    
    public HappyT(){
        super("Inicio de sesión");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 380);
        this.setLocationRelativeTo(null); //centro
        this.setResizable(false); //no se pueda cambiar la dimensión
        //para que no se utilice ningún layout
        this.setLayout(null);
        Anadir.contador = Anadir.contador+1;
        System.out.println(Anadir.contador);
        ingresar.addActionListener(this);
        olvido.addActionListener(this);
        
        JLabel etiqueta = new JLabel();
        etiqueta.setSize(350, 350);
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT)); //Esableciendo el fondo del tamaño de la ventana
        this.repaint();
        etiqueta.setIcon(icono);
        
        txtUsuario.setBounds(125, 65, 103, 25);
        txtContra.setBounds(160, 145, 90, 25);
        ingresar.setBounds(35, 257, 100, 25);
        olvido.setBounds(175, 267, 170, 25);
         //Cambiar el cursor cuando se posicione sobre un componente
        ingresar.setCursor(new Cursor(HAND_CURSOR));
        olvido.setCursor(new Cursor(HAND_CURSOR));
        
        
        txtUsuario.setFont(new Font("Berlin Sans FB Bold",Font.BOLD,16));
        txtUsuario.setBorder(null);
        txtUsuario.setOpaque(false);
        txtContra.setEchoChar('\u2022');
        txtContra.setBorder(null);
        txtContra.setOpaque(false);
        ingresar.setBorder(null);
        ingresar.setContentAreaFilled(false);
        ingresar.setFont(new Font("Berlin Sans FB Bold",Font.BOLD,20));
        ingresar.setForeground(Color.white);
        olvido.setBorder(null);
        olvido.setContentAreaFilled(false);
        olvido.setFont(new Font("Berlin Sans FB Bold",Font.BOLD,13));
        olvido.setForeground(Color.white);
        
        this.add(txtUsuario);
        this.add(txtContra);
        this.add(ingresar);
        this.add(olvido);
        this.add(etiqueta);
        this.setVisible(true);
        
    }
    public boolean Vacio(){ //comprober que estén vacios los textfield
        boolean r = false;
        r |= txtUsuario.getText().isEmpty();
        r |=txtContra.getText().isEmpty();      
        return r;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException, NumberFormatException{
        //SI SE EJECUTA POR PRIMERA VEZ QUITE LAS DIAGONALES DE ABAJO, INICIE EL PROGRAMA, HAGA CLICK EN TERMINAR Y VUELVA A PONER LAS DIAGONALES DE COMENTARIO A LAS LINEAS DE ABAJO ANTES DE VOLVERLO A USAR, TAMBIÉN CHEQUE LA LINEA 536
//        FileOutputStream fo = new FileOutputStream(path);
//        ObjectOutputStream oo = new ObjectOutputStream(fo);
//        FileOutputStream fo2 = new FileOutputStream(path2);
//        ObjectOutputStream oo2 = new ObjectOutputStream(fo2);
//        FileOutputStream fo3 = new FileOutputStream(path3);
//        ObjectOutputStream oo3 = new ObjectOutputStream(fo3);
//        FileOutputStream fo4 = new FileOutputStream(path4);
//        ObjectOutputStream oo4 = new ObjectOutputStream(fo4);
//        FileOutputStream fo5 = new FileOutputStream(path5);
//        ObjectOutputStream oo5 = new ObjectOutputStream(fo5);
//        FileOutputStream fo6 = new FileOutputStream(path6);
//        ObjectOutputStream oo6 = new ObjectOutputStream(fo6);
//        FileOutputStream fo7 = new FileOutputStream(path7);
//        ObjectOutputStream oo7 = new ObjectOutputStream(fo7);
//        FileOutputStream fo8 = new FileOutputStream(path8);
//        ObjectOutputStream oo8 = new ObjectOutputStream(fo8);
//        FileOutputStream fo9 = new FileOutputStream(path9);
//        ObjectOutputStream oo9 = new ObjectOutputStream(fo9);
//        HappyT a = new HappyT ();
//        oo.writeObject(tablaClientes);
//        oo2.writeObject(tablaOrtodoncista);
//        oo3.writeObject(tablaEndodoncista);
//        oo4.writeObject(tablaMaxilofacial);
//        oo5.writeObject(tablaCitas);
//        oo6.writeObject(tablaOrt2);
//        oo7.writeObject(tablaEnd2);
//        oo8.writeObject(tablaMax2);
//        oo9.writeObject(tablaCitas2);
//        oo.close();
//        fo.close();
//        oo2.close();
//        fo2.close();
//        oo3.close();
//        fo3.close();
//        oo4.close();
//        fo4.close();
//        oo5.close();
//        fo5.close();
//        oo6.close();
//        fo6.close();
//        oo7.close();
//        fo7.close();
//        oo8.close();
//        fo8.close();
//        oo9.close();
//        fo9.close();

        FileInputStream fi = new FileInputStream(path);
        ObjectInputStream oi = new ObjectInputStream(fi);
        tablaClientes=(Hashtable)oi.readObject();
        Anadir.contador = tablaClientes.size()-1;
        fi.close();
        oi.close();
        FileInputStream fi2 = new FileInputStream(path2);
        ObjectInputStream oi2 = new ObjectInputStream(fi2);
        tablaOrtodoncista=(Hashtable)oi2.readObject();
        fi2.close();
        oi2.close();
        FileInputStream fi3 = new FileInputStream(path3);
        ObjectInputStream oi3 = new ObjectInputStream(fi3);
        tablaEndodoncista=(Hashtable)oi3.readObject();
        fi3.close();
        oi3.close();
        FileInputStream fi4 = new FileInputStream(path4);
        ObjectInputStream oi4 = new ObjectInputStream(fi4);
        tablaMaxilofacial=(Hashtable)oi4.readObject();
        fi4.close();
        oi4.close();
        FileInputStream fi5 = new FileInputStream(path5);
        ObjectInputStream oi5 = new ObjectInputStream(fi5);
        tablaCitas=(Hashtable)oi5.readObject();
        fi5.close();
        oi5.close();
        FileInputStream fi6 = new FileInputStream(path6);
        ObjectInputStream oi6 = new ObjectInputStream(fi6);
        tablaOrt2=(Hashtable)oi6.readObject();
        fi6.close();
        oi6.close();
        FileInputStream fi7 = new FileInputStream(path7);
        ObjectInputStream oi7 = new ObjectInputStream(fi7);
        tablaEnd2=(Hashtable)oi7.readObject();
        fi7.close();
        oi7.close();
        FileInputStream fi8 = new FileInputStream(path8);
        ObjectInputStream oi8 = new ObjectInputStream(fi8);
        tablaMax2=(Hashtable)oi8.readObject();
        fi8.close();
        oi8.close();
        FileInputStream fi9 = new FileInputStream(path9);
        ObjectInputStream oi9 = new ObjectInputStream(fi9);
        tablaMax2=(Hashtable)oi9.readObject();
        fi9.close();
        oi9.close();
        
        
        inst = new HappyT();
        
        //SI SE EJECUTA POR PRIMERA VEZ HAGA COMENTARIO TODO DESDE LA LINEA 537 HASTA LA 542, INICIE EL PROGRAMA, HAGA CLICK EN TERMINAR Y QUITE LAS DIAGONALES QUE PUSO EN LAS LINEAS DE ABAJO
             FileOutputStream fo = new FileOutputStream(path);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo.writeObject(tablaClientes);
        oo.close();
        fo.close();
        FileOutputStream fo2 = new FileOutputStream(path2);
        ObjectOutputStream oo2 = new ObjectOutputStream(fo2);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo2.writeObject(tablaOrtodoncista);
        oo2.close();
        fo2.close();
        FileOutputStream fo3 = new FileOutputStream(path3);
        ObjectOutputStream oo3 = new ObjectOutputStream(fo3);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo3.writeObject(tablaEndodoncista);
        oo3.close();
        fo3.close();
        FileOutputStream fo4 = new FileOutputStream(path4);
        ObjectOutputStream oo4 = new ObjectOutputStream(fo4);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo4.writeObject(tablaMaxilofacial);
        oo4.close();
        fo4.close();
        FileOutputStream fo5 = new FileOutputStream(path5);
        ObjectOutputStream oo5 = new ObjectOutputStream(fo5);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo5.writeObject(tablaCitas);
        oo5.close();
        fo5.close();
        FileOutputStream fo6 = new FileOutputStream(path6);
        ObjectOutputStream oo6 = new ObjectOutputStream(fo6);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo6.writeObject(tablaOrt2);
        oo6.close();
        fo6.close();
        FileOutputStream fo7 = new FileOutputStream(path7);
        ObjectOutputStream oo7 = new ObjectOutputStream(fo7);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo7.writeObject(tablaEnd2);
        oo7.close();
        fo7.close();
        FileOutputStream fo8 = new FileOutputStream(path8);
        ObjectOutputStream oo8 = new ObjectOutputStream(fo8);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo8.writeObject(tablaMax2);
        oo8.close();
        fo8.close();
        FileOutputStream fo9 = new FileOutputStream(path9);
        ObjectOutputStream oo9 = new ObjectOutputStream(fo9);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        oo9.writeObject(tablaCitas2);
        oo9.close();
        fo9.close();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object pulsar = ae.getSource();
        
        if(pulsar == ingresar){
            boolean r = Vacio();
            if(r==false){
                String usuario = txtUsuario.getText();
                String password = txtContra.getText();
                if(usuario.equals("secre777") && password.equals("topicos1")){
                    user = 0;
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    Menu menu = new Menu();
                }
                else if(usuario.equals("theboss20") && password.equals("itd2020")){
                    user = 1;
                    JOptionPane.showMessageDialog(null, "Bienvenido jefe");
                    Menu menu = new Menu();
                }
                else{
                    JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña no son correctas");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No deje espacios en blanco");
            }
            
        }
        if(pulsar == olvido){
                JOptionPane.showMessageDialog(null, "Usuario secretaria: secre777"+"\n"+"Contraseña: topicos1"+"\n"
                +"Usuario dueño: theboss20"+"\n"+"Contraseña: itd2020");
        }
    }
    
}
