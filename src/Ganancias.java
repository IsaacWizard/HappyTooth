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
public class Ganancias extends JFrame implements ActionListener{
    public int gt, ge, nc;
    ImageIcon imgGananciasT = new ImageIcon("valor.png");
    ImageIcon imgBack = new ImageIcon("flecha.png");
    ImageIcon imgGananciasE = new ImageIcon("objetivo.png");
    ImageIcon imgClientes = new ImageIcon("usuario.png");
    
    JLabel lbImgT = new JLabel(imgGananciasT);
    JLabel lbImgE = new JLabel(imgGananciasE);
    JLabel lbImgC = new JLabel(imgClientes);
    
    JLabel lbGT = new JLabel();
    JLabel lbGE = new JLabel();
    JLabel lbClientes = new JLabel();
    
     
     JButton volver = new JButton(imgBack);
     
     public Ganancias(){
        super("Ganancias");
        this.setSize(370, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(183,247,238));
        
        volver.addActionListener(this);
        
        volver.setBorder(null);
        volver.setContentAreaFilled(false);
        volver.setToolTipText("Volver a la página anterior");
        volver.setCursor(new Cursor(HAND_CURSOR));
        
        Datos();
        
        lbGT.setText("Ganancias Totales: $"+gt);
        lbGE.setText("Ganancias Estimadas: $"+ge);
        lbClientes.setText("Número de clientes: "+nc);
        
        lbImgT.setBounds(160, 40, 60, 60);
        lbGT.setBounds(100, 120, 200, 25);
        lbImgE.setBounds(160, 160, 60, 60);
        lbGE.setBounds(100, 230, 200, 25);
        lbImgC.setBounds(160, 290, 60, 60);
        lbClientes.setBounds(100, 370, 200, 25);
        volver.setBounds(20, 480, 80, 80);
        
        this.add(lbImgT);
        this.add(lbGT);
        this.add(lbImgE);
        this.add(lbGE);
        this.add(lbImgC);
        this.add(lbClientes);
        this.add(volver);
        this.setVisible(true);
     }
     public void Datos(){
         gt=0;
         ge=0;
         nc=0;
         int rest=0;
         nc = HappyT.tablaClientes.size();
         int contad = HappyT.tablaClientes.size();
        System.out.println(contad);
        for(int x=contad; x>0; x--){
            String X = Integer.toString(x);
           Anadir c = HappyT.tablaClientes.get(X);
           if(c.especialista.equals("Ortodoncista")){
           ge=ge+600;
           }
           if(c.especialista.equals("Endodoncista")){
           ge=ge+800;
           }
           if(c.especialista.equals("Maxilofacial")){
           ge=ge+1000;
           }
           rest= rest+c.deuda;
        }
        gt = ge-rest;
        
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object accion = ae.getSource();
        if(accion == volver){
            this.setVisible(false);
            Menu menu = new Menu();
        }
    }
}