package com.example.facturas.services;

import com.example.facturas.entities.EstadoFactura;
import com.example.facturas.repositories.BaseRepository;
import com.example.facturas.repositories.EstadoFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoFacturaServiceImpl extends BaseServiceImpl<EstadoFactura,Long> implements EstadoFacturaService {

    @Autowired
    private EstadoFacturaRepository estadoFacturaRepository;

    public EstadoFacturaServiceImpl(BaseRepository<EstadoFactura,Long> baseRepository){
        super(baseRepository);
    }
}
