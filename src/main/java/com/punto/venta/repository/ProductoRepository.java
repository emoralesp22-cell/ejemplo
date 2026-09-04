package com.punto.venta.repository;

import com.punto.venta.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Integer> {

    // MOSTRAR ACTIVOS
    List<Producto> findByEstadoTrueOrderByIdProductoDesc();

    // MOSTRAR ACTIVOS CON FILTRO
    List<Producto> findByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdProductoDesc(
            String filtro
    );

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO
    List<Producto> findTop3ByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdProductoDesc(
            String filtro
    );
}