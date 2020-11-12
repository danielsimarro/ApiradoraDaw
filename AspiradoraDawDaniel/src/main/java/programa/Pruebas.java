/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author NitroPc
 */
public class Pruebas {

    public static void main(String[] args) {

        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);
        
        double aspiracion = 1.5;
        double totalcocina=0;
        int cocina=10;

        //int cocina = aleatorio.nextInt(100) + 1;
        //System.out.println("Los metros de la cocina son " + cocina);

        int salon = aleatorio.nextInt(100) + 1;
        System.out.println("Los metros de la cocina son " + salon);

        int baño = aleatorio.nextInt(100) + 1;
        System.out.println("Los metros de la cocina son " + baño);

        int dormitorio1 = aleatorio.nextInt(100) + 1;
        System.out.println("Los metros de la cocina son " + dormitorio1);

        int dormitorio2 = aleatorio.nextInt(100) + 1;
        System.out.println("Los metros de la cocina son " + dormitorio2);

        int carga;
        do {
            System.out.println("Establecer nivel de carga");

            carga = teclado.nextInt();
        } while (carga <= 0 || carga >= 100);
        
        double carga2 = (int)carga;

        String eleccion1S;

        eleccion1S = JOptionPane.showInputDialog("En el modo aspiración existe dos modos\n"
                + "1.-Modo completo\n"
                + "2.-Modo dependencias\n");
        int eleccion1 = Integer.parseInt(eleccion1S);

        switch (eleccion1) {
            case 1:
                for(int i=0;i<cocina;i++){
                    carga2-=aspiracion;
                    if(carga2<3){
                        i--;
                        System.out.println("La carga es" + carga2 + " y a limpiado" + (i+1));
                    }
                }
                totalcocina=carga2;
                System.out.println("La carga es de un " + totalcocina);
                break;

            case 2:
                break;

        }
    }
}
