
package com.punto.venta.repository;

import com.punto.venta.dto.ReportePedidoClienteDetalleDTO;
import com.punto.venta.entity.PedidoDetalle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoDetalleRepository
        extends JpaRepository<PedidoDetalle, Integer> {

    // MOSTRAR ACTIVOS
    List<PedidoDetalle> findByEstadoTrueOrderByIdPedidoDetalleDesc();

    // MOSTRAR ACTIVOS CON FILTRO POR NOMBRE DEL PRODUCTO
    List<PedidoDetalle> findByEstadoTrueAndIdProducto_NombreContainingIgnoreCaseOrderByIdPedidoDetalleDesc(
            String filtro
    );

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO POR NOMBRE DEL PRODUCTO
    List<PedidoDetalle> findTop3ByEstadoTrueAndIdProducto_NombreContainingIgnoreCaseOrderByIdPedidoDetalleDesc(
            String filtro
    );

    // REPORTE PEDIDO CLIENTE DETALLE
    @Query(
        "SELECT new com.punto.venta.dto.ReportePedidoClienteDetalleDTO(" +
        "p.fechaPedido, " +
        "CONCAT(c.nombre, CONCAT(' ', COALESCE(c.apellido, ''))), " +
        "pr.nombre, " +
        "d.cantidad, " +
        "pr.precio, " +
        "d.precioUnitario, " +
        "d.subtotal) " +
        "FROM PedidoDetalle d " +
        "JOIN d.idPedido p " +
        "JOIN p.idCliente c " +
        "JOIN d.idProducto pr " +
        "WHERE p.estado = true " +
        "ORDER BY p.fechaPedido DESC, " +
        "p.idPedido DESC, d.idPedidoDetalle DESC"
    )
    List<ReportePedidoClienteDetalleDTO>
            obtenerReportePedidoClienteDetalle();
}
