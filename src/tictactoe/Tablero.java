/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author MtsSk
 */
public class Tablero {    
    
    public char [][] tablero;
    
    public Tablero(){
        
        tablero = new char [3][3];
        
    }
    
    public void deshacerTablero(){
        
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){
                tablero[i][j] = 'V';
            }
        }
        
    }
    
    public void mostrarConsolaTablero(){
        
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){
                System.out.print(tablero[i][j]+" ");
                if (j == tablero[0].length-1){
                    System.out.println("");
                }
            }
        }
        
    }
    
}
