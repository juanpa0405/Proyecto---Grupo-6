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
public class Cine {

    public String nombreCliente;
    public int cantidadEntradas;
    public double precioEntrada = 2500; 

    public void ejecutarModulo() {

        int opcion = 0;

        do {
            String menu = "MÓDULO CINE\n"
                        + "1. Registrar reserva\n"
                        + "2. Mostrar resumen\n"
                        + "3. Volver al menú principal\n";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    registrarReserva();
                    break;

                case 2:
                    mostrarResumen();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

        } while (opcion != 3);

    }


    public void registrarReserva() {
        nombreCliente = JOptionPane.showInputDialog("Digite el nombre del cliente:");
        cantidadEntradas = Integer.parseInt(
                JOptionPane.showInputDialog("Digite la cantidad de entradas:"));

        JOptionPane.showMessageDialog(null, "Reserva registrada correctamente.");
    }

    public void mostrarResumen() {

        if (nombreCliente == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna reserva registrada.");
            return;
        }

        double total = cantidadEntradas * precioEntrada;

        String msg = "Resumen reserva\n"
                   + "Cliente: " + nombreCliente + "\n"
                   + "Entradas: " + cantidadEntradas + "\n"
                   + "Precio unitario: " + precioEntrada + "\n"
                   + "Total a pagar: " + total;

        JOptionPane.showMessageDialog(null, msg);
    }
}