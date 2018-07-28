/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author MtsSk
 */
public class Vista extends JFrame implements ActionListener{
    
    public final int alto = 325;
    public final int ancho = 300;
    private JButton [][] botones;
    private JButton [] botonesMenu;
    private Tablero tablero;
    
    public Vista(){
        
        botones = new JButton[3][3];
        botonesMenu = new JButton[3];
        tablero = new Tablero();
        
        setTitle("TicTacToe");
        setSize(ancho,alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        
        getContentPane().setPreferredSize(new Dimension(ancho,alto));
        
        añadirBotones();
        
        pack();        
    }
    
    public void inicializarBotones(int i, int j){
        
        botones[i][j] = new JButton();
        botones[i][j].setName(i+""+j);
        botones[i][j].addActionListener(this);
        add(botones[i][j]); 
        
    }
    
    public void añadirBotones(){
        int x = 0,y = 0+25;
        int altoBoton = (alto-25)/tablero.tablero.length;
        int anchoBoton = ancho/tablero.tablero[0].length;
        
        for (int i = 0; i < tablero.tablero.length; i++){
            for (int j = 0; j < tablero.tablero[0].length; j++){
                
                inicializarBotones(i, j);
                botones[i][j].setBounds(x, y, altoBoton, anchoBoton);
                
                x += anchoBoton;
                if (j == tablero.tablero[0].length-1){
                    y += altoBoton;
                    x = 0;
                }                
            }
        }
        
        inicializarBotonesMenu();
        
    }
    
    public void inicializarBotonesMenu(){
        
        int x = 0;
        int anchoBoton = ancho/tablero.tablero[0].length;
        int altoBoton = 25;
        
        for (int i = 0; i < tablero.tablero[0].length; i++){
            botonesMenu[i] = new JButton();
            botonesMenu[i].setName(""+i);
            botonesMenu[i].addActionListener(this);
            botonesMenu[i].setBounds(x, 0, anchoBoton, altoBoton);
            add(botonesMenu[i]);
            
            x += anchoBoton;
        }
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        //Manejo de botones juego
        if(((JButton)e.getSource()).getName().length() == 2){
            System.out.println("Botón juego: "+((JButton)e.getSource()).getName());
        }        
        //Manejo de botones menu
        else{
            if (((JButton)e.getSource()).getName().length() == 1){
                System.out.println("Boton menu: "+((JButton)e.getSource()).getName());
            }
        }
    }
    
    
    
}
