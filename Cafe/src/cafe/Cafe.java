/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafe;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author dani1
 */
public class Cafe {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {

            Empleado[] empleados = {
                new Empleado("E101", "Daniela Vega"),
                new Empleado("E102", "Carlos Soto"),
                new Empleado("E103", "Maria López"),};

            Barista baristaManager = new Barista(empleados);

            SwingUtilities.invokeLater(() -> mostrarMenuBarista(baristaManager));
        }

        private static void mostrarMenuBarista(Barista baristaManager) {
            int opcion = -1;
            while (opcion != 0) {
                String menu = "1. Listar Pedidos de Barista\n"
                        + "2. Realizar Pedido (Reserva)\n"
                        + "3. Modificar Pedido Existente\n"
                        + "0. Salir del Módulo";

                String input = JOptionPane.showInputDialog(null, menu, "Gestión del Barista ", JOptionPane.PLAIN_MESSAGE);

                if (input == null || input.trim().equals("0")) {
                    opcion = 0;
                    continue;
                }

                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese una opción numérica válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                switch (opcion) {
                    case 1:
                        baristaManager.listarPedidos();
                        break;
                    case 2:
                        ejecutarReservaBarista(baristaManager);
                        break;
                    case 3:
                        baristaManager.modificarReserva();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no reconocida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        private static void ejecutarReservaBarista(Barista baristaManager) {
            String id = JOptionPane.showInputDialog(null, "Ingrese ID de Empleado (Ej: E101):", "Pedido", JOptionPane.QUESTION_MESSAGE);
            if (id == null) {
                return;
            }

            String bebida = JOptionPane.showInputDialog(null, "Ingrese Bebida (Ej: Café normal, Moka):", "Pedido", JOptionPane.QUESTION_MESSAGE);
            if (bebida == null) {
                return;
            }

            String hora = JOptionPane.showInputDialog(null, "Ingrese Hora de Entrega (Ej: 10 AM):", "Pedido", JOptionPane.QUESTION_MESSAGE);
            if (hora == null) {
                return;
            }

            baristaManager.realizarReserva(id, bebida, hora);
        }
    }

