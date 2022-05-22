import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
public class Menu extends JFrame implements ActionListener{
    
    ImageIcon imgEnca = new ImageIcon("encabezado.png");
    ImageIcon logo = new ImageIcon("mariachi.png");
    ImageIcon titulo = new ImageIcon("titulo.png");
    JLabel lbEnca = new JLabel(imgEnca);
    JLabel lbLogo = new JLabel(logo);
    JLabel lbTitulo = new JLabel(titulo);
    ImageIcon imgClientes = new ImageIcon("hombres.png");
    JButton btClientes = new JButton(imgClientes);
    ImageIcon imgCitas = new ImageIcon("citas.png");
    JButton btCitas = new JButton(imgCitas);
    ImageIcon imgAgCitas = new ImageIcon("lista.png");
    JButton btAgCitas = new JButton(imgAgCitas);
    ImageIcon imgPagar = new ImageIcon("dinero.png");
    JButton btPagar = new JButton(imgPagar);
    ImageIcon imgGanancias = new ImageIcon("crecimiento.png");
    JButton btGanancias = new JButton(imgGanancias);
    
    public Menu(){
        super("Menú Principal");
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        //this.getContentPane().setBackground(new Color(183,247,238)); //ponemos fondo con el color del fondo de dientes en formato RGB
        this.getContentPane().setBackground(Color.white);
        
        btClientes.addActionListener(this);
        btCitas.addActionListener(this);
        btAgCitas.addActionListener(this);
        btPagar.addActionListener(this);
        btGanancias.addActionListener(this);
        
        //Asignar a la opción descripción cuando se pone el cursor del ratón sobre ella
        btClientes.setToolTipText("Ver clientes");
        btCitas.setToolTipText("Ver citas");
        btAgCitas.setToolTipText("Agendar cita");
        btPagar.setToolTipText("Hacer un pago");
        btGanancias.setToolTipText("Ver ganancias");
        //Cambiar el cursor cuando se posicione sobre un componente
        btClientes.setCursor(new Cursor(HAND_CURSOR));
        btCitas.setCursor(new Cursor(HAND_CURSOR));
        btAgCitas.setCursor(new Cursor(HAND_CURSOR));
        btPagar.setCursor(new Cursor(HAND_CURSOR));
        btGanancias.setCursor(new Cursor(HAND_CURSOR));
        
        btClientes.setBorder(null);
        btClientes.setContentAreaFilled(false);
        btCitas.setBorder(null);
        btCitas.setContentAreaFilled(false);
        btAgCitas.setBorder(null);
        btAgCitas.setContentAreaFilled(false);
        btPagar.setBorder(null);
        btPagar.setContentAreaFilled(false);
        btGanancias.setBorder(null);
        btGanancias.setContentAreaFilled(false);
        
        lbEnca.setBounds(0, 20, 1200, 120);
        lbLogo.setBounds(20, 20, 160, 160);
        lbTitulo.setBounds(500, 0, 476, 476);
        btClientes.setBounds(90, 200, 160, 160);
        btCitas.setBounds(300, 200, 160, 160);
        btAgCitas.setBounds(510, 200, 160, 160);
        btPagar.setBounds(720, 200, 160, 160);
        btGanancias.setBounds(930, 200, 160, 160);
        
        this.add(lbLogo);
        this.add(lbEnca);
        this.add(lbTitulo);
        this.add(btClientes);
        this.add(btCitas);
        this.add(btAgCitas);
        this.add(btPagar);
        this.add(btGanancias);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object opcion = ae.getSource();
        
        if(opcion == btClientes){
            this.setVisible(false);
            VerClientes ver = new VerClientes();
        }
        if(opcion == btCitas){
            TablaCi citas = new TablaCi();
        }
        if(opcion == btAgCitas){
            this.setVisible(false);
            AgCita cita = new AgCita();
        }
        if(opcion == btPagar){
            this.setVisible(false);
            Pagar pay = new Pagar();
            
        }
        if(opcion == btGanancias){
            if(HappyT.user==1){
            this.setVisible(false);
            Ganancias gan = new Ganancias();
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo el jefe puede ver las ganancias de la clínica");
            }
        }
    }
}
