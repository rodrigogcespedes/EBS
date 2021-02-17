package com.example.comanda.services;

import com.example.comanda.local_models.Comanda;
import com.example.comanda.repositories.BaseRepository;
import com.example.comanda.repositories.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComandaServiceImpl extends BaseServiceImpl<Comanda,Long> implements ComandaService{

    @Autowired
    private ComandaRepository comandaRepository;

    public ComandaServiceImpl(BaseRepository<Comanda,Long> baseRepository){
        super(baseRepository);
    }
}
