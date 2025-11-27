/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author dani1
 */
public class proyecto {
    
    public static void main(String[] args) {
        Entrenador gym = new Entrenador();
        int opcion = -1;

        while (opcion != 0) {
            String menu = "Gestión del Gimnasio 🏋️\n\n"
                        + "1. Ver Horarios y Reservas (Matriz)\n"
                        + "2. Reservar Cita (Gym)\n"
                        + "3. Liberar Cita (Gym)\n"
                        + "0. Salir";
            
            String input = JOptionPane.showInputDialog(null, menu, "Menú Principal Gym", JOptionPane.QUESTION_MESSAGE);
            
            if (input == null) {
                opcion = 0;
                continue;
            }
            
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una opción numérica válida.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1:
                    gym.mostrarReservas();
                    break;
                case 2:
                    ejecutarReserva(gym);
                    break;
                case 3:
                    ejecutarLiberacion(gym);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema de Gym.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no reconocida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void ejecutarReserva(Entrenador gym) {
        String diaSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione el día para la reserva:",
            "Reservar Cita",
            JOptionPane.QUESTION_MESSAGE,
            null, 
            gym.getDias(), 
            gym.getDias()[0]
        );
        if (diaSeleccionado == null) return;
        
        String horaSeleccionada = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione la hora para la reserva (2 PM a 7 PM):",
            "Reservar Cita",
            JOptionPane.QUESTION_MESSAGE,
            null, 
            gym.getHoras(), 
            gym.getHoras()[0]
        );
        if (horaSeleccionada == null) return;
        
        String idEmpleado = JOptionPane.showInputDialog(null, "Ingrese el ID del empleado (ej: E101):", "ID Empleado", JOptionPane.QUESTION_MESSAGE);
        
        if (idEmpleado != null && !idEmpleado.trim().isEmpty()) {
            gym.reservarCita(diaSeleccionado, horaSeleccionada, idEmpleado);
        } else {
            JOptionPane.showMessageDialog(null, "ID de empleado no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static void ejecutarLiberacion(Entrenador gym) {
        String diaSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione el día para liberar:",
            "Liberar Cita",
            JOptionPane.QUESTION_MESSAGE,
            null, 
            gym.getDias(), 
            gym.getDias()[0]
        );
        if (diaSeleccionado == null) return;

        String horaSeleccionada = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione la hora para liberar:",
            "Liberar Cita",
            JOptionPane.QUESTION_MESSAGE,
            null,
            gym.getHoras(),
            gym.getHoras()[0]
        );

        if (horaSeleccionada != null) {
            gym.liberarCita(diaSeleccionado, horaSeleccionada);
        }
    }
}