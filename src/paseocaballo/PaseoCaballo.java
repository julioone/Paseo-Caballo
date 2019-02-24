/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paseocaballo;

import javax.swing.JOptionPane; //libreria para formularios.
import java.lang.Integer;
/**
 *
 * @author julio.ospina
 */
public class PaseoCaballo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int[][] tableroAjedrez = new int[8][8]; // boleano para saber si fue visitado o no 
        
        //movimientos posible caballo del 0 al 7
        //filaActual +- verticalMov[ numeroMovimiento ];
        //columnaActual +- horizontalMov[ numeroMovimiento];
        int [] horizontalMov = new int[8];    
        int [] verticalMov   = new int[8];
        horizontalMov[0] = 2;
        horizontalMov[1] = 1;
        horizontalMov[2] = -1;
        horizontalMov[3] = -2;
        horizontalMov[4] = -2;
        horizontalMov[5] = -1;
        horizontalMov[6] = 1;
        horizontalMov[7] = 2;
                
        verticalMov[0] = -1;
        verticalMov[1] = -2;
        verticalMov[2] = -2;
        verticalMov[3] = -1;
        verticalMov[4] = 1;
        verticalMov[5] = 2;
        verticalMov[6] = 2;
        verticalMov[7] = 1;
        
        
        //inicializar tablero
        for(int i=0; i< 8; i++)
        {
            for(int j=0; j< 8; j++)
            {
                tableroAjedrez[i][j] = 0;
            }
        }
        //pintar tablero
        /*
        for(int i=0; i< tableroAjedrez.length; i++)
        {
            for(int j=0; j<tableroAjedrez[i].length; j++)
            {
                System.out.printf("%b ",tableroAjedrez[i][j]);
            }
            System.out.println();
        }
        */
        //posicion inicial aleatoria caballo
        String stringfilaActual = JOptionPane.showInputDialog("ingrese la fila inicial 0-7");
        String stringcolumnaActual = JOptionPane.showInputDialog("ingrese la columna inicial 0-7");
       
        int auxfilaActual    = 0;
        int auxcolumnaActual = 0;
        int filaActual      = Integer.parseInt(stringfilaActual);
        int columnaActual   = Integer.parseInt(stringcolumnaActual);
        
        
        tableroAjedrez[filaActual][columnaActual] = 1;
        int contMovExitosos = 0;
        
        for(int movimientos =1; movimientos<=64; movimientos++)
        {
            for(int tipoMov=0; tipoMov < 8; tipoMov++)
            {
                
                auxfilaActual = filaActual;
                auxcolumnaActual = columnaActual;
                filaActual += verticalMov[tipoMov];
                columnaActual += horizontalMov[tipoMov];
                //System.out.printf("%d,%d;", tempfilaActual,tempcolumnaActual);
                if ((filaActual < 0 || filaActual > 7) || (columnaActual < 0 || columnaActual > 7))
                {
                    filaActual = auxfilaActual;
                    columnaActual = auxcolumnaActual;

                }
                else 
                {
                    
                    if (tableroAjedrez[filaActual][columnaActual] != 0)
                    {
                        //ya esta visitado
                        //no muevo el caballo y sigo con el posible proximo movimiento.
                        filaActual = auxfilaActual;
                        columnaActual = auxcolumnaActual;

                    }
                    else
                    {
                        //desplazo el caballo.


                        tableroAjedrez[filaActual][columnaActual] = 1; //visitado.
                        System.out.printf("Caballo se movio a [%d][%d]\n",filaActual,columnaActual);
                        for(int i=0; i< tableroAjedrez.length; i++)
                        {
                            for(int j=0; j<tableroAjedrez[i].length; j++)
                                {
                                    System.out.printf("%d ",tableroAjedrez[i][j]);
                            }
                            System.out.println();
                        }
                        contMovExitosos++;
                        //System.out.printf(":%d:",contMovExitosos);
                        break;

                    }

                }//visitada = tableroAjedrez[tempfilaActual][tempcolumnaActual];
                
                
                
            }
            
            
        }
        System.out.printf("el numero de movimientos exitosos fueron %d\n",contMovExitosos);
        
        
    }
    
}
