package com.punto.venta.repository;

import com.punto.venta.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository
        extends JpaRepository<Cliente, Integer> {

    // VALIDAR CLIENTE DUPLICADO
    boolean existsByNombreIgnoreCaseAndApellidoIgnoreCase(
            String nombre,
            String apellido
    );

    // MOSTRAR ACTIVOS
    List<Cliente> findByEstadoTrueOrderByIdClienteDesc();

    // MOSTRAR ACTIVOS CON FILTRO
    List<Cliente> findByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdClienteDesc(
            String filtro
    );

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO
    List<Cliente> findTop3ByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdClienteDesc(
            String filtro
    );
}