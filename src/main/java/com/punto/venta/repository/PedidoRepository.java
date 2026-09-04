package com.punto.venta.repository;

import com.punto.venta.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

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
}