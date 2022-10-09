
package metododegaussjordan;

import java.util.Arrays;
import java.util.Scanner;


public class MetodoDeGaussJordan {
private static float[][] mat = new float[2][3];//guarda la matriz
    
    /*es un auxiliar que guatrda una de las filas para evitar modificar
    la matriz original*/
    private static float[] auxMat = new float[3];
    
    /*usado para copiar los valores de la posición de la matriz */
    private static float aux;
    
    /*imprime con salto de linea lo que se le mande*/
    private static void e(String tx){
        System.out.println(""+tx);
    }
    
    /*imprime lo que se le mande pero sin salto de linea*/
    private static void en(String tx){
        System.out.print(""+tx);
    }
    
    /*llamala sin parametros para que imprima la matriz*/
    private static void imp(){
            for(int f=0;f<2;f++){
                for(int c=0;c<3;c++){
                    en("\t"+mat[f][c]);
                }
                e("");
            }
    }
    
    /*para recoger datos de teclado*/
    private static Scanner sc = new Scanner(System.in);
    
    /*metodo proncipal del programa*/
    public static void main(String[] args) {
        /*
        Pedimos datos al usuario
        */
        e("El formato de las ecuaciones es el suiguiente:");
        e(" Ax +/- By = C");
        e("Dx +/- Ey = F");
        e("ingresa el valor de A ==>");
        mat[0][0]=sc.nextInt();
        e("ingresa el valor de B ==>");
        mat[0][1]=sc.nextInt();
        e("ingresa el valor de C ==>");
        mat[0][2]=sc.nextInt();
        e("ingresa el valor de D ==>");
        mat[1][0]=sc.nextInt();
        e("ingresa el valor de E ==>");
        mat[1][1]=sc.nextInt();
        e("ingresa el valor de F ==>");
        mat[1][2]=sc.nextInt();
        
        /*
        2.- dividiomos la primer ecuacion entre el valor de x1 
        */
        
        aux=mat[0][0];
        /*
        Toda la Fila [0][X] se divide entre la posición [0][0]
        */
        
        for(int c=0;c<3;c++){
            mat[0][c]/=aux;
        }
        /*fin 2.*/
        /*tomamos valor 1 0 y le restamos 1*/
        aux=((mat[1][0])*(-1));
        /*
        En el primer For copia toda la fila 0
        */
        for(int c=0;c<3;c++){
            auxMat[c]=mat[0][c];
        }
        /*
        En el segundo for los valores de cada posición copiados se multiplican por el auxiliar  
        para asignar nuevos valores.
        */
        for(int c=0;c<3;c++){
            auxMat[c]*=aux;
        }
        /*
        En el tercer for se suma cada una de la posición de la matriz auxiliar en cada 
        posición de la matriz original correspondiente y lo reemplaza de la fila 1.
        */
        for(int c=0;c<3;c++){
            mat[1][c]+=auxMat[c];
        }
        /*fin de paso 3**/
        
        /*paso 4*/
        /*
        A la variable aux se le asigna la posición de la fila [1] en la columna [1].
        */
        aux=mat[1][1];
        /*
        En este for se divide cada posición de la fila [1] de la matriz entre el auxiliar
        */
        for(int c=0;c<3;c++){
            mat[1][c]/=aux;
        }
        /*fin de paso 4*/
        
        /*paso 5*/
        /*
        Tomamos el valor de la matriz de la posición [0][1] en negativo y se guarda.
        */
        aux=(mat[0][1]*-1);
        /*
        En este for se toman los valores de las posiciones en la fila uno 
        y se guardan en el auxiliar de la matriz.
        */
        for(int c=0;c<3;c++){
            auxMat[c]=mat[1][c];
        }
        /*
        En este for el auxiliar se multiplica por cada uno de los valores del auxiliar de la matriz 
        y los reemplaza.
        */
        for(int c=0;c<3;c++){
            auxMat[c]*=aux;
        }
        /*
        En este for se le suma cada posición de la fila auxiliar de la matriz 
        mas cada posición de la matriz y lo reemplaza.
        */
        for(int c=0;c<3;c++){
            mat[0][c]+=auxMat[c];
        }
        /*fin de paso 5*/
        
        /*imprime el resultado*/
        e("El resultado de X es :"+mat[0][2]);
        e("El resultado de Y es :"+mat[1][2]);
    }
    
}
