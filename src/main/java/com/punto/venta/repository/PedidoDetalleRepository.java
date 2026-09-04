package com.punto.venta.repository;

import com.punto.venta.entity.PedidoDetalle;

import org.springframework.data.jpa.repository.JpaRepository;

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
}

