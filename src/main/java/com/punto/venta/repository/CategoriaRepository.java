package com.punto.venta.repository;

import com.punto.venta.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository
        extends JpaRepository<Categoria, Integer> {

    // MOSTRAR ACTIVOS
    List<Categoria> findByEstadoTrueOrderByIdCategoriaDesc();

    // MOSTRAR ACTIVOS CON FILTRO
    List<Categoria> findByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdCategoriaDesc(
            String filtro
    );

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO
    List<Categoria> findTop3ByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdCategoriaDesc(
            String filtro
    );
}