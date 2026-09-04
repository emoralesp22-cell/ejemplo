package com.punto.venta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.punto.venta.dto.CategoriaDTO;
import com.punto.venta.entity.Categoria;
import com.punto.venta.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // GET - LISTAR TODOS
    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // POST - CREAR
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {

        Categoria categoria = convertToEntity(categoriaDTO);

        Categoria savedCategoria =
                categoriaRepository.save(categoria);

        return convertirDTO(savedCategoria);
    }

    // PUT - ACTUALIZAR
    public CategoriaDTO modificarCategoria(
            Integer idCategoria,
            CategoriaDTO dto) {

        Categoria categoriaExistente =
                categoriaRepository.findById(idCategoria)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Categoria no encontrada"
                        ));

        if (dto.getNombre() != null) {
            categoriaExistente.setNombre(dto.getNombre());
        }

        if (dto.getDescripcion() != null) {
            categoriaExistente.setDescripcion(dto.getDescripcion());
        }

        if (dto.getEstado() != null) {
            categoriaExistente.setEstado(dto.getEstado());
        }

        return convertirDTO(
                categoriaRepository.save(categoriaExistente)
        );
    }

    // DELETE
    public void eliminarCategoria(Integer idCategoria) {

        if (!categoriaRepository.existsById(idCategoria)) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Categoria no encontrada"
            );
        }

        categoriaRepository.deleteById(idCategoria);
    }

    // ANULAR
    public CategoriaDTO anularCategoria(Integer idCategoria) {

        Categoria categoriaExistente =
                categoriaRepository.findById(idCategoria)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Categoria no encontrada"
                        ));

        categoriaExistente.setEstado(false);

        return convertirDTO(
                categoriaRepository.save(categoriaExistente)
        );
    }

    // MOSTRAR SOLO ACTIVOS
    public List<CategoriaDTO> mostrarActivos() {

        return categoriaRepository
                .findByEstadoTrueOrderByIdCategoriaDesc()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // MOSTRAR ACTIVOS CON FILTRO
    public List<CategoriaDTO> mostrarActivosFiltro(String filtro) {

        return categoriaRepository
                .findByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdCategoriaDesc(
                        filtro
                )
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO
    public List<CategoriaDTO> mostrarActivosFiltroTop(String filtro) {

        return categoriaRepository
                .findTop3ByEstadoTrueAndNombreContainingIgnoreCaseOrderByIdCategoriaDesc(
                        filtro
                )
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // ENTITY -> DTO
    private CategoriaDTO convertirDTO(Categoria categoria) {

        CategoriaDTO dto = new CategoriaDTO();

        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        dto.setEstado(categoria.getEstado());

        return dto;
    }

    // DTO -> ENTITY
    private Categoria convertToEntity(CategoriaDTO dto) {

        Categoria categoria = new Categoria();

        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        categoria.setEstado(true);

        return categoria;
    }
}