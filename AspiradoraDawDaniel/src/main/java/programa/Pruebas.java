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
        double totalcocina = 0;
        double cocina = 10;

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

        double carga2 = (int) carga;

        String eleccion1S;
        String eleccion2S;

        eleccion1S = JOptionPane.showInputDialog("En el modo aspiración existe dos modos\n"
                + "1.-Modo completo\n"
                + "2.-Modo dependencias\n");
        int eleccion1 = Integer.parseInt(eleccion1S);
        
        double calculadorcocina;
        double condicion = 3.0;

        double to;

        switch (eleccion1) {
            case 1:
                calculadorcocina = (carga2) - (aspiracion * cocina); // 100 - 15= 85

                if (calculadorcocina > condicion) {
                    for (int i = 0; i < cocina; i++) {
                        carga2 -= aspiracion;//50

                    }

                    
                    JOptionPane.showMessageDialog(null, "Se ha aspirado la cocina, queda " + carga2 + "% de batería");

                } else {
                    JOptionPane.showMessageDialog(null, "No se a podido aspirar la cocina, ya que no tiene batería suficiente");
                    break;

                }
                break;

            case 2:

                eleccion2S = JOptionPane.showInputDialog("Has seleccionado el modo dependencia, eliga la dependencia a limpiar"
                        + "1.-Cocina\n"
                        + "2.-Salón\n"
                        + "3.-Baño\n"
                        + "4.-Dormitorio 1\n"
                        + "5.- Dormitorio 2\n"
                        + "5.- Salir");
                int eleccion2 = Integer.parseInt(eleccion2S);

                switch (eleccion2) {

                    case 1:

                        break;
                }

                break;

        }
    }
}
