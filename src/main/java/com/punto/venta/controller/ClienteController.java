package com.punto.venta.controller;

import com.punto.venta.dto.ClienteDTO;
import com.punto.venta.dto.MessageResponse;
import com.punto.venta.entity.Cliente;
import com.punto.venta.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // GET - TODOS
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    // POST
    @PostMapping
    public ResponseEntity<MessageResponse> createCliente(
            @RequestBody ClienteDTO clienteDTO) {

        try {

            clienteService.save(clienteDTO);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new MessageResponse(
                            "Cliente creado con éxito"
                    ));

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(
                            e.getMessage()
                    ));
        }
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{idCliente}")
    public ResponseEntity<MessageResponse> actualizarCliente(
            @PathVariable Integer idCliente,
            @RequestBody ClienteDTO clienteDTO) {

        try {

            clienteService.actualizar(
                    idCliente,
                    clienteDTO
            );

            return ResponseEntity.ok(
                    new MessageResponse(
                            "Cliente actualizado con éxito"
                    )
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(
                            "Error al actualizar el cliente: "
                                    + e.getMessage()
                    ));
        }
    }

    // DELETE
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<MessageResponse> eliminarCliente(
            @PathVariable Integer idCliente) {

        try {

            clienteService.eliminar(idCliente);

            return ResponseEntity.ok(
                    new MessageResponse(
                            "Cliente eliminado con éxito"
                    )
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(
                            "Error al eliminar el cliente: "
                                    + e.getMessage()
                    ));
        }
    }

    // ANULAR
    @PutMapping("/anular/{idCliente}")
    public ResponseEntity<MessageResponse> anularCliente(
            @PathVariable Integer idCliente) {

        try {

            clienteService.anular(idCliente);

            return ResponseEntity.ok(
                    new MessageResponse(
                            "Cliente anulado con éxito"
                    )
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(
                            "Error al anular el cliente: "
                                    + e.getMessage()
                    ));
        }
    }

    // MOSTRAR ACTIVOS
    @GetMapping("/activos")
    public List<Cliente> mostrarActivos() {
        return clienteService.mostrarActivos();
    }

    // MOSTRAR ACTIVOS CON FILTRO
    @GetMapping("/activos/filtro")
    public List<Cliente> mostrarActivosFiltro(
            @RequestParam String filtro) {

        return clienteService.mostrarActivosFiltro(filtro);
    }

    // MOSTRAR TOP 3 ACTIVOS CON FILTRO
    @GetMapping("/activos/filtro/top")
    public List<Cliente> mostrarActivosFiltroTop(
            @RequestParam String filtro) {

        return clienteService.mostrarActivosFiltroTop(filtro);
    }
}