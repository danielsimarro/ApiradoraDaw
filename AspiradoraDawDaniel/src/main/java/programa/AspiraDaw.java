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

    @SuppressWarnings("empty-statement")
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

        while (dormitorio2 < 1 || dormitorio2 > 100) {
            dormitorio2S = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            dormitorio2 = Integer.parseInt(dormitorio2S);
        }

        

        String bateriaS;

        bateriaS = JOptionPane.showInputDialog("Introduce el nivel de bateria");
        int bateria = Integer.parseInt(bateriaS);

        while (bateria < 0 || bateria > 100){
            bateriaS = JOptionPane.showInputDialog("Vuelve a introducir la batería entre (0-100)");
            bateria = Integer.parseInt(bateriaS);
        }

        double bateria1 = (int) bateria;
        //------------------------------------------------------------------------------------------
        //Aqui realizaremos la configuración principal de la aplicación
        //
        //
        String eleccionS;

        eleccionS = JOptionPane.showInputDialog("Eligue un modo de trabajo\n"
                + "1.- Aspiración\n"
                + "2.-Aspiración y fregado\n"
                + "3.-Estado general\n"
                + "4.-Base de carga\n"
                + "5.-Salir");
        int eleccion = Integer.parseInt(eleccionS);

        //Declararemos todas las variables que se usaran en el menu
        final double aspiracion = 1.5;
        
        //Variables utilizdas en el case 1 case 1
        double calculadorcocina; // Calculara si la bateria es suficiente para realizar la cocina
        double calculadorbano; // Calculara si la bateria es suficiente para realizar el baño
        double calculadorsalon; // Calculara si la bateria es suficiente para realizar el salon
        double calculadordor1; // Calculara si la bateria es suficiente para realizar el dormitorio 1
        double calculadordor2; // Calculara si la bateria es suficiente para realizar el dormitorio2
        
        int contadordependencias = 0;//Este contador sirve para contar las dependencias

        String eleccion1S;

        switch (eleccion) {
            case 1:

                eleccion1S = JOptionPane.showInputDialog("En el modo aspiración existe dos modos\n"
                        + "1.-Modo completo\n"
                        + "2.-Modo dependencias\n");
                int eleccion1 = Integer.parseInt(eleccion1S);

                switch (eleccion1) {
                    case 1:
                        calculadorcocina = (bateria1) - (aspiracion * cocina);

                        if (calculadorcocina > 3) {
                            for (int i = 0; i <= cocina; i++) {
                                bateria1 -= aspiracion;
                                if(bateria1<3){
                                    
                                }
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado la cocina, queda " + bateria1 + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar la cocina, ya que no tiene batería suficiente");
                            break;

                        }

                        calculadorsalon = (bateria1) - (aspiracion * salon);
                        
                        if (calculadorsalon > 3) {
                            for (int i = 0; i <= salon; i++) {
                                bateria1 -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el salon, queda " + bateria1 + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el salon, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina");
                            break;

                        }
                        
                        calculadorbano = (bateria1) - (aspiracion * bano);
                        
                        if (calculadorsalon > 3) {
                            for (int i = 0; i <= bano; i++) {
                                bateria1 -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el baño, queda " + bateria1 + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el baño, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina y salon");
                            break;

                        }
                        
                        calculadordor1 = (bateria1) - (aspiracion * dormitorio1);
                        
                        if (calculadordor1 > 3) {
                            for (int i = 0; i <= dormitorio1; i++) {
                                bateria1 -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 1, queda " + bateria1 + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el dormitorio 1, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina, salon y baño");
                            break;

                        }
                        
                        calculadordor2 = (bateria1) - (aspiracion * dormitorio2);
                        
                        if (calculadordor2 > 3) {
                            for (int i = 0; i <= dormitorio2; i++) {
                                bateria1 -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 2, queda " + bateria1 + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el dormitorio 2, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina, salon, baño y dormitorio 1");
                            break;

                        }
                        
                        
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
