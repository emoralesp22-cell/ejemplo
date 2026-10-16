
package com.punto.venta.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReportePedidoClienteDetalleDTO {

    private final Date fechaPedido;
    private final String nombreCliente;
    private final String nombreProducto;
    private final Integer cantidadPedido;
    private final BigDecimal precio;
    private final BigDecimal precioUnitario;
    private final BigDecimal subtotal;

    public ReportePedidoClienteDetalleDTO(
            Date fechaPedido,
            String nombreCliente,
            String nombreProducto,
            Integer cantidadPedido,
            BigDecimal precio,
            BigDecimal precioUnitario,
            BigDecimal subtotal) {

        this.fechaPedido = fechaPedido;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.cantidadPedido = cantidadPedido;
        this.precio = precio;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Integer getCantidadPedido() {
        return cantidadPedido;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
}
