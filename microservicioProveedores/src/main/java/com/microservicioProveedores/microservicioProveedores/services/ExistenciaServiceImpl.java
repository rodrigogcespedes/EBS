package com.microservicioProveedores.microservicioProveedores.services;

import com.microservicioProveedores.microservicioProveedores.local_models.proveedores.Existencia;
import com.microservicioProveedores.microservicioProveedores.repositories.BaseRepository;
import com.microservicioProveedores.microservicioProveedores.repositories.ExistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExistenciaServiceImpl extends BaseServiceImpl<Existencia,Long> implements ExistenciaService{

	@Autowired
	private ExistenciaRepository ExistenciaRepository;
	
	public ExistenciaServiceImpl(BaseRepository<Existencia, Long> baseRepository){
        super(baseRepository);
    }
}


