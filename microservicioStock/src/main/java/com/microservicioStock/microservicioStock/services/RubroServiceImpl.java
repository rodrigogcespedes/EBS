package com.microservicioStock.microservicioStock.services;

import com.microservicioStock.microservicioStock.local_models.stock.Rubro;
import com.microservicioStock.microservicioStock.repositories.BaseRepository;
import com.microservicioStock.microservicioStock.repositories.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro,Long>{

	@Autowired
	private RubroRepository RubroRepository;
	
	public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository){
        super(baseRepository);
    }
}


