
package com.punto.venta.repository;

import com.punto.venta.dto.ReportePedidoClienteDTO;
import com.punto.venta.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository
        extends JpaRepository<Pedido, Integer> {

    // MOSTRAR ACTIVOS
    List<Pedido> findByEstadoTrueOrderByIdPedidoDesc();

    // MOSTRAR ACTIVOS CON FILTRO POR NOMBRE DEL CLIENTE
    List<Pedido> findByEstadoTrueAndIdCliente_NombreContainingIgnoreCaseOrderByIdPedidoDesc(
            String filtro
    );

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO POR NOMBRE DEL CLIENTE
    List<Pedido> findTop3ByEstadoTrueAndIdCliente_NombreContainingIgnoreCaseOrderByIdPedidoDesc(
            String filtro
    );

    // REPORTE PEDIDO CLIENTE
    @Query(
        "SELECT new com.punto.venta.dto.ReportePedidoClienteDTO(" +
        "p.fechaPedido, " +
        "CONCAT(c.nombre, CONCAT(' ', COALESCE(c.apellido, '')))) " +
        "FROM Pedido p " +
        "JOIN p.idCliente c " +
        "WHERE p.estado = true " +
        "ORDER BY p.fechaPedido DESC, p.idPedido DESC"
    )
    List<ReportePedidoClienteDTO> obtenerReportePedidoCliente();
}
