package com.example.facturas.services;

import com.example.facturas.entities.Factura;
import com.example.facturas.repositories.BaseRepository;
import com.example.facturas.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura,Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura,Long> baseRepository){
        super(baseRepository);
    }

}
