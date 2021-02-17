package com.example.comanda.services;

import com.example.comanda.local_models.EstadoComanda;
import com.example.comanda.repositories.BaseRepository;
import com.example.comanda.repositories.EstadoComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoComandaServiceImpl extends BaseServiceImpl<EstadoComanda,Long> implements EstadoComandaService{

    @Autowired
    private EstadoComandaRepository estadoComandaRepository;

    public EstadoComandaServiceImpl(BaseRepository<EstadoComanda,Long> baseRepository){
        super(baseRepository);
    }
}
