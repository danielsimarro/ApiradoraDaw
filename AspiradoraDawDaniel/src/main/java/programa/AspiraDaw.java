/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author NitroPc
 */
public class AspiraDaw {

    public static void main(String[] args) {

        //Lo primero que debemos hacer para iniciar el programa
        //es que el usuario se autentifique
        final String usuario = "User";
        String usuariointroducido = "";

        while (usuario.equalsIgnoreCase(usuariointroducido) == false) {
            usuariointroducido = JOptionPane.showInputDialog("Usuario");

            if (usuario.equalsIgnoreCase(usuariointroducido) == false) {
                JOptionPane.showMessageDialog(null, "El usuario es incorrecto, vuelva a introducirlo");
            }

        }

        final String password = "Admin";
        String passwordintroducido = "";

        while (password.equalsIgnoreCase(passwordintroducido) == false) {
            passwordintroducido = JOptionPane.showInputDialog("Contraseña");

            if (password.equalsIgnoreCase(passwordintroducido) == false) {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecto, vuelva a introducirlo");
            }

        }

        JOptionPane.showMessageDialog(null, "Bienvenido a nuestra app, lo siguiente sera configurar el sistema");

        String cocinaS, salonS, banoS, dormitorio1S, dormitorio2S;

        cocinaS = JOptionPane.showInputDialog("Introduce los metros cuadrados de la cocina");
        int cocina = Integer.parseInt(cocinaS);

        while (cocina < 1 || cocina > 100) {
            cocinaS = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            cocina = Integer.parseInt(cocinaS);
        }

        salonS = JOptionPane.showInputDialog("Introduce los metros cuadrados del salón");
        int salon = Integer.parseInt(salonS);

        while (salon < 1 || salon > 100) {
            salonS = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            salon = Integer.parseInt(salonS);
        }

        banoS = JOptionPane.showInputDialog("Introduce los metros cuadrados del baño");
        int bano = Integer.parseInt(banoS);

        while (bano < 1 || bano > 100) {
            banoS = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            bano = Integer.parseInt(banoS);
        }

        dormitorio1S = JOptionPane.showInputDialog("Introduce los metros cuadrados del primer dormitorio");
        int dormitorio1 = Integer.parseInt(dormitorio1S);

        while (dormitorio1 < 1 || dormitorio1 > 100) {
            dormitorio1S = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            dormitorio1 = Integer.parseInt(dormitorio1S);
        }

        dormitorio2S = JOptionPane.showInputDialog("Introduce los metros cuadrados del segundo dormitorio");
        int dormitorio2 = Integer.parseInt(dormitorio2S);

        while (dormitorio2 < 1 || dormitorio2 > 100);
        {
            dormitorio2S = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            dormitorio2 = Integer.parseInt(dormitorio2S);
        }

        JOptionPane.showMessageDialog(null, "Establece el nivel de bateria");

        String bateriaS;

        bateriaS = JOptionPane.showInputDialog("Introduce el nivel de bateria");
        int bateria = Integer.parseInt(bateriaS);

        while (bateria < 0 || bateria > 100);
        {
            bateriaS = JOptionPane.showInputDialog("Vuelve a introducir la batería entre (0-100)");
            bateria = Integer.parseInt(bateriaS);
        }

        //Aqui realizaremos la configuración principal de la aplicación
        //
        //
        String eleccionS;

        eleccionS = JOptionPane.showInputDialog("Eligue un modo de trebajo\n"
                + "1.- Aspiración\n"
                + "2.-Aspiración y fregado\n"
                + "3.-Estado general\n"
                + "4.-Base de carga\n"
                + "5.-Salir");
        int eleccion = Integer.parseInt(eleccionS);
        
        String eleccion1S;

        switch (eleccion) {
            case 1:
                
                eleccion1S= JOptionPane.showInputDialog("En el modo aspiración existe dos modos\n"
                        + "1.-Modo completo\n"
                        + "2.-Modo dependencias\n");
                int eleccion1 = Integer.parseInt(eleccion1S);
                
                switch(eleccion1){
                    case 1:
                        
                        break;
                    
                    case 2:
                        break;
                        
                }

                break;

            case 2:

                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

        }

    }
}
