/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author juamp
 */
public class ClasesGrupales {

   
    public String nombreCliente;
    public String nombreClase;   
    public String horario;       
    public int cuposDisponibles; 

    
    public void ejecutarModulo() {

        int opcion = 0;

        do {
            String menu = "Clases Grupales\n"
                    + "1. Registrar\n"
                    + "2. Mostrar resumen\n"
                    + "3. Volver al menú principal\n";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    registrarInscripcion();
                    break;

                case 2:
                    mostrarResumen();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

        } while (opcion != 3);
    }

 
    public void registrarInscripcion() {
        nombreCliente = JOptionPane.showInputDialog("Digite el nombre del cliente:");

        String[] clases = {"Yoga", "Spinning", "Funcional"};
        int selClase = JOptionPane.showOptionDialog(
                null,
                "Seleccione la clase grupal:",
                "Clases grupales",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                clases,
                clases[0]
        );

        if (selClase == 0) {
            nombreClase = "Yoga";
        } else if (selClase == 1) {
            nombreClase = "Spinning";
        } else {
            nombreClase = "Funcional";
        }

        horario = JOptionPane.showInputDialog("Digite el horario (ejemplo: 6:00 am):");

        cuposDisponibles = Integer.parseInt(
                JOptionPane.showInputDialog("Digite los cupos disponibles para esa clase:")
        );

        JOptionPane.showMessageDialog(null, "Inscripción registrada correctamente.");
    }

    public void mostrarResumen() {

        if (nombreCliente == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna inscripción registrada.");
            return;
        }

        String msg = "Resumen de la Clase Grupal\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Clase: " + nombreClase + "\n"
                + "Horario: " + horario + "\n"
                + "Cupos disponibles: " + cuposDisponibles + "\n";

        JOptionPane.showMessageDialog(null, msg);
    }
}
