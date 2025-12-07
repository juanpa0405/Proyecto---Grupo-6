/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

/**
 *
 * @author dani1
 */
public class Pedido {
       private String idEmpleado;
    private String nombreBebida;
    private String horaEntrega;

    public Pedido(String idEmpleado, String nombreBebida, String horaEntrega) {
        this.idEmpleado = idEmpleado;
        this.nombreBebida = nombreBebida;
        this.horaEntrega = horaEntrega;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }
}

