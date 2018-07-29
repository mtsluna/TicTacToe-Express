/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
    private boolean turno;
    
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
        
        botones[i][j] = new JButton(new ImageIcon("src/resources/botonVacio.png"));
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
        
        añadirBotonesMenu();
        
    }
    
    public void inicializarBotonesMenu(int i){
                
        botonesMenu[i] = new JButton();
        botonesMenu[i].setName(""+i);
        botonesMenu[i].addActionListener(this);
        
        if (i == 0){
            botonesMenu[i].setIcon(new ImageIcon("src/resources/botonReinicio.png"));
        }
        
        add(botonesMenu[i]);
        
    }
    
    public void añadirBotonesMenu(){        
        int x = 0;
        int anchoBoton = ancho/tablero.tablero[0].length;
        int altoBoton = 25;
        
        for (int i = 0; i < tablero.tablero[0].length; i++){
            inicializarBotonesMenu(i);
            botonesMenu[i].setBounds(x, 0, anchoBoton, altoBoton);
            
            x += anchoBoton;
        }
        
    }
    
    public void turno(){
        if (tablero.turno == 0){
            turno = false;
        }
        else{
            if (tablero.turno == 1){
                turno = true;
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        
        //Manejo de botones juego
        if(((JButton)e.getSource()).getName().length() == 2){
            String posicion = ((JButton)e.getSource()).getName();
            int x = Integer.parseInt(""+posicion.charAt(0)), y = Integer.parseInt(""+posicion.charAt(1));
            if (turno){
                tablero.tablero[x][y] = 'X';
                botones[x][y].setIcon(new ImageIcon("src/resources/botonX.png"));
                turno = false;
                if (tablero.verificarVictoria('X') == 'X'){
                    System.out.println("X WIN");
                    usoTablero(false);
                }
                else{
                    System.out.println("Todavia no hay ganadores");
                }
                
            }
            else{
                tablero.tablero[x][y] = 'O'; 
                botones[x][y].setIcon(new ImageIcon("src/resources/botonO.png"));
                turno = true;
                if (tablero.verificarVictoria('O') == 'O'){
                    System.out.println("O WIN");
                    usoTablero(false);
                }
                else{
                    System.out.println("Todavia no hay ganadores");
                }
            }
            tablero.mostrarConsolaTablero();
        }        
        //Manejo de botones menu
        else{
            if (((JButton)e.getSource()).getName().length() == 1){
                System.out.println("Boton menu: "+((JButton)e.getSource()).getName());
                int [] posicionBotonesMenu;
            }
        }
    }
    
    public void usoTablero(boolean uso){
        
        for (int i = 0; i < tablero.tablero.length; i++){
            for (int j = 0; j < tablero.tablero[0].length; j++){
                botones[i][j].setEnabled(uso);
            }
        }
            
    }
    

    
}
