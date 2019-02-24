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
        
        //heuristica de accesibilidad entre menos valor mas accesible.
        int [][] tablaAccesibilidad = new int[8][8];
        tablaAccesibilidad[0][0] = 2;
        tablaAccesibilidad[0][1] = 3;
        tablaAccesibilidad[0][2] = 4;
        tablaAccesibilidad[0][3] = 4;
        tablaAccesibilidad[0][4] = 4;
        tablaAccesibilidad[0][5] = 4;
        tablaAccesibilidad[0][6] = 3;
        tablaAccesibilidad[0][7] = 2;
        
        tablaAccesibilidad[1][0] = 3;
        tablaAccesibilidad[1][1] = 4;
        tablaAccesibilidad[1][2] = 6;
        tablaAccesibilidad[1][3] = 6;
        tablaAccesibilidad[1][4] = 6;
        tablaAccesibilidad[1][5] = 6;
        tablaAccesibilidad[1][6] = 4;
        tablaAccesibilidad[1][7] = 3;
        
        tablaAccesibilidad[2][0] = 4;
        tablaAccesibilidad[2][1] = 6;
        tablaAccesibilidad[2][2] = 8;
        tablaAccesibilidad[2][3] = 8;
        tablaAccesibilidad[2][4] = 8;
        tablaAccesibilidad[2][5] = 8;
        tablaAccesibilidad[2][6] = 6;
        tablaAccesibilidad[2][7] = 4;
        
        tablaAccesibilidad[3][0] = 4;
        tablaAccesibilidad[3][1] = 6;
        tablaAccesibilidad[3][2] = 8;
        tablaAccesibilidad[3][3] = 8;
        tablaAccesibilidad[3][4] = 8;
        tablaAccesibilidad[3][5] = 8;
        tablaAccesibilidad[3][6] = 6;
        tablaAccesibilidad[3][7] = 4;
        
        tablaAccesibilidad[4][0] = 4;
        tablaAccesibilidad[4][1] = 6;
        tablaAccesibilidad[4][2] = 8;
        tablaAccesibilidad[4][3] = 8;
        tablaAccesibilidad[4][4] = 8;
        tablaAccesibilidad[4][5] = 8;
        tablaAccesibilidad[4][6] = 6;
        tablaAccesibilidad[4][7] = 4;
        
        tablaAccesibilidad[5][0] = 4;
        tablaAccesibilidad[5][1] = 6;
        tablaAccesibilidad[5][2] = 8;
        tablaAccesibilidad[5][3] = 8;
        tablaAccesibilidad[5][4] = 8;
        tablaAccesibilidad[5][5] = 8;
        tablaAccesibilidad[5][6] = 6;
        tablaAccesibilidad[5][7] = 4;
        
        tablaAccesibilidad[6][0] = 3;
        tablaAccesibilidad[6][1] = 4;
        tablaAccesibilidad[6][2] = 6;
        tablaAccesibilidad[6][3] = 6;
        tablaAccesibilidad[6][4] = 6;
        tablaAccesibilidad[6][5] = 6;
        tablaAccesibilidad[6][6] = 4;
        tablaAccesibilidad[6][7] = 3;
        
        tablaAccesibilidad[7][0] = 2;
        tablaAccesibilidad[7][1] = 3;
        tablaAccesibilidad[7][2] = 4;
        tablaAccesibilidad[7][3] = 4;
        tablaAccesibilidad[7][4] = 4;
        tablaAccesibilidad[7][5] = 4;
        tablaAccesibilidad[7][6] = 3;
        tablaAccesibilidad[7][7] = 2;
        
        
      
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
        
        //posicion inicial aleatoria caballo
        String stringfilaActual = JOptionPane.showInputDialog("ingrese la fila inicial 0-7");
        String stringcolumnaActual = JOptionPane.showInputDialog("ingrese la columna inicial 0-7");

        int filaActual      = Integer.parseInt(stringfilaActual);
        int columnaActual   = Integer.parseInt(stringcolumnaActual);
        
        
        tableroAjedrez[filaActual][columnaActual] = 1;
        int contMovExitosos = 0;
        
        for(int movimientos =1; movimientos<=64; movimientos++)
        {
            
            int mov_escogido=-1;//movimiendo escodigo en cada iteraccion
            int puntajeFinal = 9;//puntaje maximo 
            for(int mov= 0;mov < 8; mov++)
            {
                if ((filaActual+verticalMov[mov] < 0 || filaActual+verticalMov[mov] > 7) || (columnaActual+horizontalMov[mov] < 0 || columnaActual+horizontalMov[mov] > 7))
                {
                    //el posible movimiento se sale del tablero.;
                    
                }
                else
                {
                    //tambien preguntar si la casilla no ha sido visitada.
                    if(tableroAjedrez[filaActual+verticalMov[mov]][columnaActual+horizontalMov[mov]] != 0)
                    {
                        //tampoco sirve un movimiento a una casilla ya visitada.
                        
                    }
                    else
                    {
                        //aqui si se toma como un movimiento valido y compite con otros para escoger el mejor movimiento.
                        int puntajeActual = tablaAccesibilidad[filaActual+verticalMov[mov]][columnaActual+horizontalMov[mov]];
                        if(puntajeActual < puntajeFinal)
                        {
                            puntajeFinal = puntajeActual;
                            mov_escogido = mov;
                        }
                        
                    }
                    //
                    
                    
                }
            }
            //el movimiento ya esta escogido.
            
            
                
                
                
                
                
            
            if(mov_escogido == -1)
            {
                //ya el movimiento del caballo no tiene salida.
                
                
            }
            else
            {
                //mover caballado a nueva casilla
                filaActual    += verticalMov[mov_escogido];
                columnaActual += horizontalMov[mov_escogido];
                tableroAjedrez[filaActual][columnaActual] = 1; //visitado.
                
                for(int i=0; i< tableroAjedrez.length; i++)
                    {
                        for(int j=0; j<tableroAjedrez[i].length; j++)
                            {
                                System.out.printf("%d ",tableroAjedrez[i][j]);
                            }
                        System.out.println();
                    }
                System.out.printf("Caballo se movio a [%d][%d]\n",filaActual,columnaActual);
                contMovExitosos++;
            }
        }
        System.out.printf("el numero de mov fueron %d ", contMovExitosos);
    }
}
