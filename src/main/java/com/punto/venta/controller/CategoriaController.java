
package com.punto.venta.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.punto.venta.dto.CategoriaDTO;
import com.punto.venta.service.CategoriaService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // 🔍 LISTAR
    @GetMapping
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.findAll();
    }

    // 💾 CREAR
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(categoriaDTO);
    }

    // ✏️ MODIFICAR
    @PutMapping("/{id}")
    public CategoriaDTO modificar(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
        return categoriaService.modificarCategoria(id, dto);
    }

    // 🚫 ANULAR (soft delete)
    @PutMapping("/anular/{id}")
    public CategoriaDTO anular(@PathVariable Integer id) {
        return categoriaService.anularCategoria(id);
    }

    // ❌ ELIMINAR (delete real)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
    }
}