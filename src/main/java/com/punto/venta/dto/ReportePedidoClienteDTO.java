
package com.punto.venta.dto;

import java.util.Date;

public class ReportePedidoClienteDTO {

    private final Date fechaPedido;
    private final String nombreCliente;

    public ReportePedidoClienteDTO(
            Date fechaPedido,
            String nombreCliente) {
        this.fechaPedido = fechaPedido;
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
}
