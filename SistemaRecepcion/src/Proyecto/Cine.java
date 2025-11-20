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
    
    public void registrarReserva() {
        nombreCliente = JOptionPane.showInputDialog("Nombre del cliente");
        cantidadEntradas = Integer.parseInt(
                JOptionPane.showInputDialog("Cantidad de entradas"));
    }
    
    public void mostrarResumen() {
        String msg = "Cliente: " + nombreCliente 
                   + "\nEntradas: " + cantidadEntradas;
        JOptionPane.showMessageDialog(null, msg);
    }
}
