
package com.punto.venta.controller;

import com.punto.venta.dto.ReportePedidoClienteDTO;
import com.punto.venta.dto.ReportePedidoClienteDetalleDTO;
import com.punto.venta.repository.PedidoDetalleRepository;
import com.punto.venta.repository.PedidoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "http://localhost:5173")
public class ReporteController {

    private final PedidoRepository pedidoRepository;
    private final PedidoDetalleRepository pedidoDetalleRepository;

    public ReporteController(
            PedidoRepository pedidoRepository,
            PedidoDetalleRepository pedidoDetalleRepository) {

        this.pedidoRepository = pedidoRepository;
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }

    // REPORTE PEDIDO CLIENTE
    @GetMapping("/pedido-cliente")
    public List<ReportePedidoClienteDTO> reportePedidoCliente() {
        return pedidoRepository.obtenerReportePedidoCliente();
    }

    // REPORTE PEDIDO CLIENTE DETALLE
    @GetMapping("/pedido-cliente-detalle")
    public List<ReportePedidoClienteDetalleDTO>
            reportePedidoClienteDetalle() {

        return pedidoDetalleRepository
                .obtenerReportePedidoClienteDetalle();
    }
}

