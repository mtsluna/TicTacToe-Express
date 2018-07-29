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
    public int turno;
    
    public Tablero(){
        
        tablero = new char [3][3];
        turno = (int)(Math.random()*2);
        
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
    
    public char verificarVictoria(char turno){
        
        
        if (tablero[0][0] == turno){
            if (tablero[0][1] == turno){
                if (tablero[0][2] == turno){
                    return turno;
                }
            }
            if (tablero[1][1] == turno){
                if (tablero[2][2] == turno){
                    return turno;
                }
            }
            if (tablero[1][0] == turno){
                if (tablero[2][0] == turno){
                    return turno;
                }
            }
        }
        if (tablero[2][2] == turno){
            if (tablero[1][2] == turno){
                if (tablero[0][2] == turno){
                    return turno;
                }
            }
            if (tablero[2][1] == turno){
                if (tablero[2][0] == turno){
                    return turno;
                }
            }
        }
        return 'N';
        
    }
    
}
