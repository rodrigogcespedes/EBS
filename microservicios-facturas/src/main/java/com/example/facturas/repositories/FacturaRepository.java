package com.example.facturas.repositories;

import com.example.facturas.entities.Factura;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long> {
}
