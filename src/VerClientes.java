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
public class VerClientes extends JFrame implements ActionListener{
    ImageIcon logo = new ImageIcon("mariachi2.png");
    ImageIcon imgOrt = new ImageIcon("doctor.png");
    ImageIcon imgEnd = new ImageIcon("enfermero.png");
    ImageIcon imgMax = new ImageIcon("empleado.png");
    ImageIcon imgClientes = new ImageIcon("obrero.png");
    ImageIcon imgEnca = new ImageIcon("miniencabezado2.png");
    ImageIcon imgBack = new ImageIcon("flecha.png");
    JButton btOrt = new JButton(imgOrt);
    JButton btEnd = new JButton(imgEnd);
    JButton btMax = new JButton(imgMax);
    JButton btClientes = new JButton(imgClientes);
    JButton btBack = new JButton(imgBack);
    JLabel lbLogo = new JLabel(logo);
    JLabel lbEnca = new JLabel(imgEnca);

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object event = ae.getSource();
        if(event == btClientes){
            TablaClientes clientes = new TablaClientes();
        }
        if(event == btOrt){
            TablaOrt ortodoncista = new TablaOrt();
        }
        if(event == btEnd){
            TablaEnd endodoncista = new TablaEnd();
        }
        if(event == btMax){
            TablaMax maxilofacial = new TablaMax();
        }
        if(event == btBack){
            this.setVisible(false);
            Menu menu = new Menu();
        }
    }
    
    public VerClientes(){
        super("Ver Clientes");
        this.setSize(900, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
      this.setLayout(null);
      this.setLocationRelativeTo(null);
      this.getContentPane().setBackground(Color.white);
      
      btOrt.addActionListener(this);
      btEnd.addActionListener(this);
      btMax.addActionListener(this);
      btClientes.addActionListener(this);
      btBack.addActionListener(this);
      
      //Asignar a la opción descripción cuando se pone el cursor del ratón sobre ella
        btOrt.setToolTipText("Ver clientes del ortodoncista");
        btEnd.setToolTipText("Ver clientes del endodoncista");
        btMax.setToolTipText("Ver clientes del maxilofacial");
        btClientes.setToolTipText("Ver todos los clientes y su deuda");
        btBack.setToolTipText("Volver a la página anterior");
        //Cambiar el cursor cuando se posicione sobre un componente
        btOrt.setCursor(new Cursor(HAND_CURSOR));
        btEnd.setCursor(new Cursor(HAND_CURSOR));
        btMax.setCursor(new Cursor(HAND_CURSOR));
        btClientes.setCursor(new Cursor(HAND_CURSOR));
        btBack.setCursor(new Cursor(HAND_CURSOR));
        
        btOrt.setBorder(null);
        btOrt.setContentAreaFilled(false);
        btEnd.setBorder(null);
        btEnd.setContentAreaFilled(false);
        btMax.setBorder(null);
        btMax.setContentAreaFilled(false);
        btClientes.setBorder(null);
        btClientes.setContentAreaFilled(false);
        btBack.setBorder(null);
        btBack.setContentAreaFilled(false);
        
        lbLogo.setBounds(680, 320, 160, 160);
        btClientes.setBounds(70, 70, 160, 160);
        btOrt.setBounds(280, 70, 160, 160);
        btEnd.setBounds(490, 70, 160, 160);
        btMax.setBounds(700, 70, 160, 160);
        btBack.setBounds(40, 330, 80, 80);
        lbEnca.setBounds(0, 365, 900, 109);
        
        this.add(lbLogo);
        this.add(lbEnca);
        this.add(btClientes);
        this.add(btOrt);
        this.add(btEnd);
        this.add(btMax);
        this.add(btBack);
        this.setVisible(true);
    }
    
    
    
}
