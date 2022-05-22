import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
public class AgCita extends JFrame implements ActionListener{
    ImageIcon logo = new ImageIcon("mariachi2.png");
    ImageIcon imgExis = new ImageIcon("personas.png");
    ImageIcon imgAnadir = new ImageIcon("anadir.png");
    ImageIcon imgBack = new ImageIcon("flecha.png");
    ImageIcon imgEnca = new ImageIcon("miniencabezado.png");
    JButton btExis = new JButton(imgExis);
    JButton btAnadir = new JButton(imgAnadir);
    JButton btBack = new JButton(imgBack);
    JLabel lbLogo = new JLabel(logo);
    JLabel lbEnca = new JLabel(imgEnca);
    
    public AgCita(){
      super("Agendar Cita");
      this.setSize(500, 450);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setLayout(null);
      this.setLocationRelativeTo(null);
      //this.getContentPane().setBackground(new Color(183,247,238)); //ponemos fondo con el color del fondo de dientes en formato RGB
      this.getContentPane().setBackground(Color.white);
      
      btExis.addActionListener(this);
      btAnadir.addActionListener(this);
      btBack.addActionListener(this);
      
      //Asignar a la opción descripción cuando se pone el cursor del ratón sobre ella
        btExis.setToolTipText("Cliente Existente");
        btAnadir.setToolTipText("Nuevo Cliente");
        btBack.setToolTipText("Volver a la página anterior");
        //Cambiar el cursor cuando se posicione sobre un componente
        btExis.setCursor(new Cursor(HAND_CURSOR));
        btAnadir.setCursor(new Cursor(HAND_CURSOR));
        btBack.setCursor(new Cursor(HAND_CURSOR));
        
        btExis.setBorder(null);
        btExis.setContentAreaFilled(false);
        btAnadir.setBorder(null);
        btAnadir.setContentAreaFilled(false);
        btBack.setBorder(null);
        btBack.setContentAreaFilled(false);
        
        lbLogo.setBounds(320, 265, 160, 160);
        btExis.setBounds(70, 70, 160, 160);
        btAnadir.setBounds(280, 70, 160, 160);
        btBack.setBounds(40, 300, 80, 80);
        lbEnca.setBounds(0, 315, 500, 109);
        
        this.add(lbLogo);
        this.add(lbEnca);
        this.add(btExis);
        this.add(btAnadir);
        this.add(btBack);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object opc = ae.getSource();
        
        if(opc == btExis){
            this.setVisible(false);
            Existente exis = new Existente();
        }
        if(opc == btAnadir){
            Anadir.inst = new Anadir();
            this.setVisible(false);
        }
        if(opc == btBack){
            this.setVisible(false);
            Menu menu = new Menu();
        }
    }
}
