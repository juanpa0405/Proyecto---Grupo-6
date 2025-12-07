/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

import javax.swing.JOptionPane;

/**
 *
 * @author dani1
 */
public class Barista {

    private final String[] MENU_BEBIDAS = {
        "Café normal", "Capuchino", "Capuchino con vainilla",
        "Chocolate", "Moka", "Te chai", "Café frio"
    };

    private Pedido[] pedidos;
    private int contadorPedidos;
    private final Empleado[] empleados;

    public Barista(Empleado[] empleados) {
        this.pedidos = new Pedido[100];
        this.contadorPedidos = 0;
        this.empleados = empleados;
    }

    private String buscarNombreEmpleado(String idEmpleado) {
        for (Empleado emp : empleados) {
            if (emp != null && emp.getId().equalsIgnoreCase(idEmpleado.trim())) {
                return emp.getNombre();
            }
        }
        return "ID Desconocido";
    }

    private int buscarPedidoPorId(String idEmpleado) {
        for (int i = 0; i < contadorPedidos; i++) {
            if (pedidos[i] != null && pedidos[i].getIdEmpleado().equalsIgnoreCase(idEmpleado)) {
                return i;
            }
        }
        return -1;
    }

    public void realizarReserva(String idEmpleado, String nombreBebida, String horaEntrega) {
        idEmpleado = idEmpleado.trim().toUpperCase();

        if (buscarPedidoPorId(idEmpleado) != -1) {
            JOptionPane.showMessageDialog(null, " Ya tienes una reserva asignada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (contadorPedidos < pedidos.length) {
            String nombre = buscarNombreEmpleado(idEmpleado);

            pedidos[contadorPedidos] = new Pedido(idEmpleado, nombreBebida.trim(), horaEntrega.trim());
            contadorPedidos++;

            JOptionPane.showMessageDialog(null, " Pedido de " + nombre + " asignado.", "Reserva Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, " No hay espacio para más pedidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarReserva() {
        String idEmpleado = JOptionPane.showInputDialog(null, "Ingrese ID de Empleado para modificar:");
        if (idEmpleado == null) {
            return;
        }

        int indice = buscarPedidoPorId(idEmpleado.trim().toUpperCase());

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, " No se encontró una reserva para ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pedido p = pedidos[indice];
        String nuevaBebida = JOptionPane.showInputDialog(null,
                "Reserva actual: " + p.getNombreBebida() + " a las " + p.getHoraEntrega()
                + "\nIngrese la NUEVA Bebida:", "Modificar Pedido", JOptionPane.QUESTION_MESSAGE);
        if (nuevaBebida == null) {
            return;
        }

        String nuevaHora = JOptionPane.showInputDialog(null, "Ingrese la NUEVA Hora de Entrega:");
        if (nuevaHora == null) {
            return;
        }

        p.setNombreBebida(nuevaBebida.trim());
        p.setHoraEntrega(nuevaHora.trim());
        JOptionPane.showMessageDialog(null, " Reserva de " + buscarNombreEmpleado(idEmpleado) + " modificada con éxito.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    public void listarPedidos() {
        if (contadorPedidos == 0) {
            JOptionPane.showMessageDialog(null, "No hay pedidos de Barista registrados hoy.", "Pedidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder(" Lista de Pedidos:\n\n");
        for (int i = 0; i < contadorPedidos; i++) {
            Pedido p = pedidos[i];
            String nombre = buscarNombreEmpleado(p.getIdEmpleado());

            sb.append("ID: ").append(p.getIdEmpleado())
                    .append(" | Empleado: ").append(nombre)
                    .append(" | Bebida: ").append(p.getNombreBebida())
                    .append(" | Entrega: ").append(p.getHoraEntrega()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Visualización de Pedidos", JOptionPane.INFORMATION_MESSAGE);
    }
}
