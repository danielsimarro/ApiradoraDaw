/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NitroPc
 */
public class AspiraDaw {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Date date = new Date();

        //Lo primero que debemos hacer para iniciar el programa
        //es que el usuario se autentifique
        /*final String usuario = "User";
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
         */
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
        double bateria = Float.parseFloat(bateriaS);

        while (bateria < 0 || bateria > 100) {
            bateriaS = JOptionPane.showInputDialog("Vuelve a introducir la batería entre (0-100)");
            bateria = Float.parseFloat(bateriaS);
        }

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
                + "5.-Carga\n"
                + "6.-Salir");
        int eleccion = Integer.parseInt(eleccionS);

        //Declararemos todas las variables que se usaran en varios menus
        final double aspiracion = 1.5;
        final double condicion = 3.0;
        boolean repetir = true;//Es el bucle del menu general

        //Variables utilizdas en el case 1 case 1
        boolean repetiras = true;
        double calculadorcocina; // Calculara si la bateria es suficiente para realizar la cocina
        double calculadorbano; // Calculara si la bateria es suficiente para realizar el baño
        double calculadorsalon; // Calculara si la bateria es suficiente para realizar el salon
        double calculadordor1; // Calculara si la bateria es suficiente para realizar el dormitorio 1
        double calculadordor2; // Calculara si la bateria es suficiente para realizar el dormitorio2
        int contadordependencias = 0;//Este contador sirve para contar las dependencias

        //Variables utilizadas en el case 1 case2
        double dcalculadorcocina; // Calculara si la bateria es suficiente para realizar la cocina
        double dcalculadorbano; // Calculara si la bateria es suficiente para realizar el baño
        double dcalculadorsalon; // Calculara si la bateria es suficiente para realizar el salon
        double dcalculadordor1; // Calculara si la bateria es suficiente para realizar el dormitorio 1
        double dcalculadordor2; // Calculara si la bateria es suficiente para realizar el dormitorio2
        String eleccion2S;//Es para elegir la dependencia que quere limpiar
        boolean repetirmododependencia = true;

        String eleccion1S;

        switch (eleccion) {
            case 1:

                eleccion1S = JOptionPane.showInputDialog("En el modo aspiración existe dos modos\n"
                        + "1.-Modo completo\n"
                        + "2.-Modo dependencias\n"
                        + "3.- Salir");
                int eleccion1 = Integer.parseInt(eleccion1S);

                switch (eleccion1) {
                    case 1:
                        calculadorcocina = (bateria) - (aspiracion * cocina); // 100 - 15= 85

                        if (calculadorcocina > condicion) {
                            for (int i = 0; i < cocina; i++) {
                                bateria -= aspiracion;//50

                            }

                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado la cocina, queda " + bateria + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar la cocina, ya que no tiene batería suficiente");
                            break;

                        }

                        calculadorsalon = (bateria) - (aspiracion * salon);

                        if (calculadorsalon > condicion) {
                            for (int i = 0; i < salon; i++) {
                                bateria -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el salon, queda " + bateria + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el salon, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina");
                            break;

                        }

                        calculadorbano = (bateria) - (aspiracion * bano);

                        if (calculadorsalon > condicion) {
                            for (int i = 0; i < bano; i++) {
                                bateria -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el baño, queda " + bateria + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el baño, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina y salon");
                            break;

                        }

                        calculadordor1 = (bateria) - (aspiracion * dormitorio1);

                        if (calculadordor1 > condicion) {
                            for (int i = 0; i < dormitorio1; i++) {
                                bateria -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 1, queda " + bateria + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el dormitorio 1, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina, salon y baño");
                            break;

                        }

                        calculadordor2 = (bateria) - (aspiracion * dormitorio2);

                        if (calculadordor2 > condicion) {
                            for (int i = 0; i < dormitorio2; i++) {
                                bateria -= aspiracion;
                            }
                            contadordependencias++;
                            JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 2, queda " + bateria + "% de batería");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se a podido aspirar el dormitorio 2, ya que no tiene batería suficiente\n"
                                    + "El numero de dependencias aspiradas es " + contadordependencias + " que corresponde a la cocina, salon, baño y dormitorio 1");
                            break;

                        }

                        break;

                    case 2:

                        do {

                            eleccion2S = JOptionPane.showInputDialog("Has seleccionado el modo dependencia, eliga la dependencia a limpiar\n"
                                    + "1.-Cocina\n"
                                    + "2.-Salón\n"
                                    + "3.-Baño\n"
                                    + "4.-Dormitorio 1\n"
                                    + "5.- Dormitorio 2\n"
                                    + "6.- Salir");
                            int eleccion2 = Integer.parseInt(eleccion2S);

                            switch (eleccion2) {
                                case 1:
                                    dcalculadorcocina = (bateria) - (aspiracion * cocina);
                                    if (dcalculadorcocina > condicion) {
                                        for (int i = 0; i < cocina; i++) {
                                            bateria -= aspiracion;
                                        }
                                        JOptionPane.showMessageDialog(null, "Se ha aspirado la cocina, queda " + bateria + "% de batería");
                                    }
                                    break;
                                case 2:
                                    dcalculadorsalon = (bateria) - (aspiracion * salon);
                                    if (dcalculadorsalon > condicion) {
                                        for (int i = 0; i < salon; i++) {
                                            bateria -= aspiracion;
                                        }
                                        JOptionPane.showMessageDialog(null, "Se ha aspirado el salon, queda " + bateria + "% de batería");
                                    }
                                    break;
                                case 3:
                                    dcalculadorbano = (bateria) - (aspiracion * bano);
                                    if (dcalculadorbano > condicion) {
                                        for (int i = 0; i < bano; i++) {
                                            bateria -= aspiracion;
                                        }
                                        JOptionPane.showMessageDialog(null, "Se ha aspirado el baño, queda " + bateria + "% de batería");
                                    }
                                    break;
                                case 4:
                                    dcalculadordor1 = (bateria) - (aspiracion * dormitorio1);
                                    if (dcalculadordor1 > condicion) {
                                        for (int i = 0; i < dormitorio1; i++) {
                                            bateria -= aspiracion;
                                        }
                                        JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 1, queda " + bateria + "% de batería");
                                    }
                                    break;
                                case 5:
                                    dcalculadordor2 = (bateria) - (aspiracion * dormitorio2);
                                    if (dcalculadordor2 > condicion) {
                                        for (int i = 0; i < dormitorio2; i++) {
                                            bateria -= aspiracion;
                                        }
                                        JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 2, queda " + bateria + "% de batería");
                                    }
                                    break;
                                case 6:
                                    repetirmododependencia = false;
                                    break;
                            }

                        } while (repetirmododependencia);
                        break;

                    case 3:
                        repetiras = false;
                        break;
                }

                break;

            case 2:

                break;

            case 3:

                DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                JOptionPane.showMessageDialog(null, "Hora y fecha: " + hourdateFormat.format(date));

                JOptionPane.showMessageDialog(null, "La bateria actual es de " + bateria + " %");

                JOptionPane.showMessageDialog(null, "La cocina tiene " + cocina + " metros cuadrados\n"
                        + "El salón tiene " + salon + " metros cuadrados\n"
                        + "El baño tiene " + bano + " metros cuadrados\n"
                        + "El dormitorio 1 tiene " + dormitorio1 + " metros cuadrados\n"
                        + "El dormitorio 2 tiene " + dormitorio2 + " metros cuadrados\n");

                break;

            case 4:
                bateria = 100.0;
                break;

            case 5:
                bateriaS = JOptionPane.showInputDialog("Introduce el nivel de bateria");
                bateria = Float.parseFloat(bateriaS);

                while (bateria < 0 || bateria > 100) {
                    bateriaS = JOptionPane.showInputDialog("Vuelve a introducir la batería entre (0-100)");
                    bateria = Float.parseFloat(bateriaS);
                }
                
                break;
            case 6:
                //System.out.println("Salir"); // Depuración
                // Preguntar si quiere salir
                // Usamos un JOptionPane.showConfirmDialog
                // Devuelve un entero: 0 o 1 en función de si se pulsa
                // YES o NO.
                int op = JOptionPane.showConfirmDialog(null,
                        "¿Deseas salir?", "Salida del programa", JOptionPane.YES_NO_OPTION);

                // System.out.println("Opcion: " + op); // Depuración
                if (op == JOptionPane.YES_OPTION) {
                    // Quiere salir
                    JOptionPane.showMessageDialog(null, "Saliendo...."); // Depuración
                    repetir = false; // Condición de parada del programa

                }
                break;

        }

    }
}
