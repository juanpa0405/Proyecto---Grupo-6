/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymApp;

/**
 *
 * @author dani1
 */
import javax.swing.JOptionPane;

class Entrenador {
    private final String[][] reservas; 
    
    private final String[] DIAS = {"Lunes", "Martes", "Miércoles"};
    private final String[] HORAS = {"2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM"};
    private final Empleado[] empleados;

    public Entrenador() {
        this.reservas = new String[DIAS.length][HORAS.length];
        
        this.empleados = new Empleado[] {
            new Empleado("E101", "Ana Pérez"),
            new Empleado("E102", "Juan Gómez"),
            new Empleado("E103", "Laura Mora"),
            new Empleado("E104", "Carlos Soto")
        };
        
        reservas[0][2] = "E101"; 
        reservas[1][5] = "E104"; 
    }

   private String buscarNombreEmpleado(String idEmpleado) {
        for (Empleado emp : empleados) {
            if (emp.getId().equals(idEmpleado)) {
                return emp.getNombre();
            }
        }
        return "Empleado Desconocido (ID: " + idEmpleado + ")";
    }
    
    public String[] getDias() {
        return DIAS;
    }
    
    public String[] getHoras() {
        return HORAS;
    }

    public void mostrarReservas() {
        StringBuilder sb = new StringBuilder(" Citas con el Entrenador 🏋️\n\n");
        
        for (int i = 0; i < DIAS.length; i++) {
            sb.append("--- ").append(DIAS[i]).append(" ---\n");
            
            for (int j = 0; j < HORAS.length; j++) {
                String idReservado = reservas[i][j];
                sb.append(HORAS[j]).append(": ");

                if (idReservado == null) {
                    sb.append("Disponible\n");
                } else {
                      String nombre = buscarNombreEmpleado(idReservado);
                    sb.append("Reservado por: ").append(nombre).append("\n");
                }
            }
        }
        
           JOptionPane.showMessageDialog(null, sb.toString(), "Visualización de Citas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void reservarCita(String dia, String hora, String idEmpleado) {
        int diaIndex = java.util.Arrays.asList(DIAS).indexOf(dia);
        int horaIndex = java.util.Arrays.asList(HORAS).indexOf(hora);

         if (diaIndex == -1 || horaIndex == -1) {
            JOptionPane.showMessageDialog(null, "Error: Día u hora no válidos.", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
            if (reservas[diaIndex][horaIndex] != null) {
            String nombreReservado = buscarNombreEmpleado(reservas[diaIndex][horaIndex]);
            JOptionPane.showMessageDialog(null, "La cita del " + dia + " a las " + hora + " ya está reservada por " + nombreReservado + ".", "Reserva Fallida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
     reservas[diaIndex][horaIndex] = idEmpleado.toUpperCase().trim();
        String nombre = buscarNombreEmpleado(idEmpleado);
        
        JOptionPane.showMessageDialog(null, "Cita reservada con éxito.\nDía: " + dia + "\nHora: " + hora + "\nEmpleado: " + nombre, "Reserva Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
      public void liberarCita(String dia, String hora) {
        int diaIndex = java.util.Arrays.asList(DIAS).indexOf(dia);
        int horaIndex = java.util.Arrays.asList(HORAS).indexOf(hora);

        if (diaIndex == -1 || horaIndex == -1) {
            JOptionPane.showMessageDialog(null, "Error: Día u hora no válidos.", "Liberación Fallida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (reservas[diaIndex][horaIndex] == null) {
             JOptionPane.showMessageDialog(null, "La cita del " + dia + " a las " + hora + " ya estaba disponible.", "Liberación Innecesaria", JOptionPane.WARNING_MESSAGE);
             return;
        }
        
        String idLiberado = reservas[diaIndex][horaIndex];
        String nombreLiberado = buscarNombreEmpleado(idLiberado);
        
        reservas[diaIndex][horaIndex] = null; // Libera el espacio
        
        JOptionPane.showMessageDialog(null, "Cita liberada con éxito.\nDía: " + dia + "\nHora: " + hora + "\nReservada previamente por: " + nombreLiberado, "Liberación Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
}

   