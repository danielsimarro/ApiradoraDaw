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

    public static void main(String[] args) {
        
        //Importamos Date para poder establecer la fecha y hora;
        Date date = new Date();

        //Lo primero que debemos hacer para iniciar el programa
        //es que el usuario se autentifique
        //Para ello debemos introducir como ususuario "User" y como conraseña "Admin"
        //al tener el ignoreCase no diferenciara entre mayusculas y minusculas
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

        //Posteriormente el usuario le asignara los datos de la configuración del sistema 
        JOptionPane.showMessageDialog(null, "Bienvenido a nuestra app, lo siguiente sera configurar el sistema");

        String cocinaS, salonS, banoS, dormitorio1S, dormitorio2S;

        cocinaS = JOptionPane.showInputDialog("Introduce los metros cuadrados de la cocina");
        double cocina = Float.parseFloat(cocinaS);

        while (cocina < 1 || cocina > 100) {
            cocinaS = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            cocina = Float.parseFloat(cocinaS);
        }

        salonS = JOptionPane.showInputDialog("Introduce los metros cuadrados del salón");
        double salon = Float.parseFloat(salonS);

        while (salon < 1 || salon > 100) {
            salonS = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            salon = Float.parseFloat(salonS);
        }

        banoS = JOptionPane.showInputDialog("Introduce los metros cuadrados del baño");
        double bano = Float.parseFloat(banoS);

        while (bano < 1 || bano > 100) {
            banoS = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            bano = Float.parseFloat(banoS);
        }

        dormitorio1S = JOptionPane.showInputDialog("Introduce los metros cuadrados del primer dormitorio");
        double dormitorio1 = Float.parseFloat(dormitorio1S);

        while (dormitorio1 < 1 || dormitorio1 > 100) {
            dormitorio1S = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            dormitorio1 = Float.parseFloat(dormitorio1S);
        }

        dormitorio2S = JOptionPane.showInputDialog("Introduce los metros cuadrados del segundo dormitorio");
        double dormitorio2 = Float.parseFloat(dormitorio2S);

        while (dormitorio2 < 1 || dormitorio2 > 100) {
            dormitorio2S = JOptionPane.showInputDialog("Vueve a introducir un numero entre (1-100)");
            dormitorio2 = Float.parseFloat(dormitorio2S);
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
        //Declararemos todas las variables que se usaran en varios menus
        final double ASPIRAR = 1.5;
        final double FREGAR = 2.25;
        final double CONDICION = 3.0;
        String posicion = "base de carga";//De forma predeterminada la aspiradora se encintrra en base de carga
        boolean repetir = true;//Es el bucle del menu general

        boolean repetirAspiracion = true;//Es el bucle de la aspiración
        double calculadorCocina; // Calculara si la bateria es suficiente para realizar la cocina
        double calculadorBano; // Calculara si la bateria es suficiente para realizar el baño
        double calculadorSalon; // Calculara si la bateria es suficiente para realizar el salon
        double calculadorDor1; // Calculara si la bateria es suficiente para realizar el dormitorio 1
        double calculadorDor2; // Calculara si la bateria es suficiente para realizar el dormitorio2
        int contadorDependencias = 0;//Este contador sirve para contar las dependencias

        String eleccionDependencias1;//Es para elegir la dependencia que quere limpiar
        boolean repetirModoDependencia = true;//Es el bucle del modo dependencia de aspiración

        boolean repetirAspiracionFreagado = true;//Es el bucle de aspiración y fregado

        String eleccionDependenciasFregado;//Es para elegir la dependencia que quere limpiar
        boolean repetirModoDependenciaFregado = true;//Es el bucle de la dependencias de fregado

        do {
            String eleccionS;

            eleccionS = JOptionPane.showInputDialog("Eligue un modo de trabajo\n"
                    + "1.- Aspiración\n"
                    + "2.-Aspiración y fregado\n"
                    + "3.-Estado general\n"
                    + "4.-Carga completa\n"
                    + "5.-Asignar bateria deseada\n"
                    + "6.-Salir");
            int eleccion = Integer.parseInt(eleccionS);

            switch (eleccion) {
                case 1:
                    String eleccionaspiracion;
                    do {
                        eleccionaspiracion = JOptionPane.showInputDialog("En el modo aspiración existe dos modos\n"
                                + "1.-Modo completo\n"
                                + "2.-Modo dependencias\n"
                                + "3.- Salir");
                        int eleccionaspiracion1 = Integer.parseInt(eleccionaspiracion);

                        switch (eleccionaspiracion1) {
                            case 1:
                                contadorDependencias= 0;//Lo igualo a 0 para que el contador se resetee

                                calculadorCocina = (bateria) - (ASPIRAR * cocina);

                                if (calculadorCocina > CONDICION) {
                                    for (int i = 0; i < cocina; i++) {
                                        bateria -= ASPIRAR;

                                    }
                                    posicion = "cocina";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado la cocina, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar la cocina, ya que no tiene batería suficiente");
                                    break;

                                }

                                calculadorSalon= (bateria) - (ASPIRAR * salon);

                                if (calculadorSalon > CONDICION) {
                                    for (int i = 0; i < salon; i++) {
                                        bateria -= ASPIRAR;
                                    }
                                    posicion = "salon";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado el salon, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar el salon, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas es " + contadorDependencias + " que corresponde a la cocina");
                                    break;

                                }

                                calculadorBano = (bateria) - (ASPIRAR * bano);

                                if (calculadorBano > CONDICION) {
                                    for (int i = 0; i < bano; i++) {
                                        bateria -= ASPIRAR;
                                    }
                                    posicion = "baño";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado el baño, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar el baño, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas es " + contadorDependencias + " que corresponde a la cocina y salon");
                                    break;

                                }

                                calculadorDor1 = (bateria) - (ASPIRAR * dormitorio1);

                                if (calculadorDor1> CONDICION) {
                                    for (int i = 0; i < dormitorio1; i++) {
                                        bateria -= ASPIRAR;
                                    }
                                    posicion = "dormitorio 1";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 1, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar el dormitorio 1, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas es " + contadorDependencias + " que corresponde a la cocina, salon y baño");
                                    break;

                                }

                                calculadorDor2 = (bateria) - (ASPIRAR * dormitorio2);

                                if (calculadorDor2 > CONDICION) {
                                    for (int i = 0; i < dormitorio2; i++) {
                                        bateria -= ASPIRAR;
                                    }
                                    posicion = "dormitorio 2";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 2, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar el dormitorio 2, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas es " + contadorDependencias + " que corresponde a la cocina, salon, baño y dormitorio 1");
                                    break;

                                }

                                break;

                            case 2:

                                do {

                                    eleccionDependencias1 = JOptionPane.showInputDialog("Has seleccionado el modo dependencia, eliga la dependencia a limpiar\n"
                                            + "1.-Cocina\n"
                                            + "2.-Salón\n"
                                            + "3.-Baño\n"
                                            + "4.-Dormitorio 1\n"
                                            + "5.- Dormitorio 2\n"
                                            + "6.- Salir");
                                    int elecciondependencia1 = Integer.parseInt(eleccionDependencias1);

                                    switch (elecciondependencia1) {
                                        case 1:
                                            calculadorCocina = (bateria) - (ASPIRAR * cocina);
                                            if (calculadorCocina > CONDICION) {
                                                for (int i = 0; i < cocina; i++) {
                                                    bateria -= ASPIRAR;
                                                }
                                                posicion = "cocina";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado la cocina, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar la cocina ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 2:
                                           calculadorSalon = (bateria) - (ASPIRAR * salon);
                                            if (calculadorSalon > CONDICION) {
                                                for (int i = 0; i < salon; i++) {
                                                    bateria -= ASPIRAR;
                                                }
                                                posicion = "salón";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado el salon, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar el salón ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 3:
                                            calculadorBano = (bateria) - (ASPIRAR * bano);
                                            if (calculadorBano > CONDICION) {
                                                for (int i = 0; i < bano; i++) {
                                                    bateria -= ASPIRAR;
                                                }
                                                posicion = "baño";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado el baño, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar el baño ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 4:
                                            calculadorDor1 = (bateria) - (ASPIRAR * dormitorio1);
                                            if (calculadorDor1 > CONDICION) {
                                                for (int i = 0; i < dormitorio1; i++) {
                                                    bateria -= ASPIRAR;
                                                }
                                                posicion = "dormitorio 1";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 1, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar el dormitorio 1 ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 5:
                                            calculadorDor2 = (bateria) - (ASPIRAR * dormitorio2);
                                            if (calculadorDor2 > CONDICION) {
                                                for (int i = 0; i < dormitorio2; i++) {
                                                    bateria -= ASPIRAR;
                                                }
                                                posicion = "dormitorio 2";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado el dormitorio 2, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar el dormitorio 2 ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 6:
                                            repetirModoDependencia= false;
                                            break;
                                    }

                                } while (repetirModoDependencia);
                                break;

                            case 3:
                                repetirAspiracion = false;
                                break;
                        }
                    } while (repetirAspiracion);

                    break;

                case 2:
                    String eleccionfregado;
                    do {
                        eleccionfregado = JOptionPane.showInputDialog("En el modo aspiración y fregado existe dos modos\n"
                                + "1.-Modo completo\n"
                                + "2.-Modo dependencias\n"
                                + "3.- Salir");
                        int eleccionfregado1 = Integer.parseInt(eleccionfregado);

                        switch (eleccionfregado1) {
                            case 1:
                                contadorDependencias = 0;

                                calculadorCocina = (bateria) - (FREGAR * cocina);

                                if (calculadorCocina > CONDICION) {
                                    for (int i = 0; i < cocina; i++) {
                                        bateria -= FREGAR;//50

                                    }
                                    posicion = "cocina";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado la cocina, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar y fregar la cocina, ya que no tiene batería suficiente");
                                    break;

                                }

                                calculadorSalon = (bateria) - (FREGAR * salon);

                                if (calculadorSalon > CONDICION) {
                                    for (int i = 0; i < salon; i++) {
                                        bateria -= FREGAR;
                                    }
                                    posicion = "salon";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el salon, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar y fregar el salon, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas y fregadas es " + contadorDependencias + " que corresponde a la cocina");
                                    break;

                                }

                                calculadorBano = (bateria) - (FREGAR * bano);

                                if (calculadorBano > CONDICION) {
                                    for (int i = 0; i < bano; i++) {
                                        bateria -= FREGAR;
                                    }
                                    posicion = "baño";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el baño, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar y freagar el baño, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas y fregadas es " + contadorDependencias + " que corresponde a la cocina y salon");
                                    break;

                                }

                                calculadorDor1 = (bateria) - (FREGAR * dormitorio1);

                                if (calculadorDor1 > CONDICION) {
                                    for (int i = 0; i < dormitorio1; i++) {
                                        bateria -= FREGAR;
                                    }
                                    posicion = "dormitorio 1";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado y freagado el dormitorio 1, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar y freagar el dormitorio 1, ya que no tiene batería suficiente\n"
                                            + "El numero de dependencias aspiradas y freagadas es " + contadorDependencias + " que corresponde a la cocina, salon y baño");
                                    break;

                                }

                                calculadorDor2 = (bateria) - (FREGAR * dormitorio2);

                                if (calculadorDor2 > CONDICION) {
                                    for (int i = 0; i < dormitorio2; i++) {
                                        bateria -= FREGAR;
                                    }
                                    posicion = "dormitorio 2";
                                    contadorDependencias++;
                                    JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el dormitorio 2, queda " + bateria + "% de batería");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se a podido aspirar y fregar el dormitorio 2, ya que no tiene batería suficiente\n"
                                            + "El número de dependencias aspiradas y freagadas es " + contadorDependencias + " que corresponde a la cocina, salon, baño y dormitorio 1");
                                    break;

                                }

                                break;

                            case 2:
                                do {

                                    eleccionDependenciasFregado = JOptionPane.showInputDialog("Has seleccionado el modo dependencia, eliga la dependencia a limpiar\n"
                                            + "1.-Cocina\n"
                                            + "2.-Salón\n"
                                            + "3.-Baño\n"
                                            + "4.-Dormitorio 1\n"
                                            + "5.- Dormitorio 2\n"
                                            + "6.- Salir");
                                    int elecciondependenciaf = Integer.parseInt(eleccionDependenciasFregado);

                                    switch (elecciondependenciaf) {
                                        case 1:
                                            calculadorCocina = (bateria) - (FREGAR * cocina);
                                            if (calculadorCocina > CONDICION) {
                                                for (int i = 0; i < cocina; i++) {
                                                    bateria -= FREGAR;
                                                }
                                                posicion = "cocina";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado la cocina, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar y fregar la cocina ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 2:
                                            calculadorSalon = (bateria) - (FREGAR * salon);
                                            if (calculadorSalon > CONDICION) {
                                                for (int i = 0; i < salon; i++) {
                                                    bateria -= FREGAR;
                                                }
                                                posicion = "salon";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el salon, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar y fregar el salón ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 3:
                                            calculadorBano = (bateria) - (FREGAR * bano);
                                            if (calculadorBano > CONDICION) {
                                                for (int i = 0; i < bano; i++) {
                                                    bateria -= FREGAR;
                                                }
                                                posicion = "baño";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el baño, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar y fregar el baño ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 4:
                                            calculadorDor1 = (bateria) - (FREGAR * dormitorio1);
                                            if (calculadorDor1 > CONDICION) {
                                                for (int i = 0; i < dormitorio1; i++) {
                                                    bateria -= FREGAR;
                                                }
                                                posicion = "dormitorio 1";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el dormitorio 1, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar y fregar el dormitorio 1 ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 5:
                                            calculadorDor2 = (bateria) - (FREGAR * dormitorio2);
                                            if (calculadorDor2 > CONDICION) {
                                                for (int i = 0; i < dormitorio2; i++) {
                                                    bateria -= FREGAR;
                                                }
                                                posicion = "dormitorio 2";
                                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado el dormitorio 2, queda " + bateria + "% de batería");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se ha podido aspirar y fregar el dormitorio 2 ya que no tiene suficiente batería");
                                            }
                                            break;
                                        case 6:
                                            repetirModoDependenciaFregado = false;
                                            break;
                                    }

                                } while (repetirModoDependenciaFregado);
                                break;

                            case 3:
                                repetirAspiracionFreagado = false;
                                break;

                        }
                    } while (repetirAspiracionFreagado);
                    break;

                case 3:

                    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

                    JOptionPane.showMessageDialog(null, "Hora y fecha: " + hourdateFormat.format(date) + "\n\n"
                            + "La bateria actual es de " + bateria + " %\n\n"
                            + "La aspiradora se encuantra en " + posicion + "\n\n"
                            + "La cocina tiene " + cocina + " metros cuadrados\n"
                            + "El salón tiene " + salon + " metros cuadrados\n"
                            + "El baño tiene " + bano + " metros cuadrados\n"
                            + "El dormitorio 1 tiene " + dormitorio1 + " metros cuadrados\n"
                            + "El dormitorio 2 tiene " + dormitorio2 + " metros cuadrados\n");

                    break;

                case 4:
                    bateria = 100.0;

                    JOptionPane.showMessageDialog(null, "Se ha cargado por completo, el nivel de bateria es del " + bateria + " %");
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

        } while (repetir);

    }
}
