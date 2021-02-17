package com.microservicioProveedores.microservicioProveedores.services;

import com.microservicioProveedores.microservicioProveedores.local_models.proveedores.Unidad;
import com.microservicioProveedores.microservicioProveedores.repositories.BaseRepository;
import com.microservicioProveedores.microservicioProveedores.repositories.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadServiceImpl extends BaseServiceImpl<Unidad,Long> implements UnidadService{

	@Autowired
	private UnidadRepository UnidadRepository;
	
	public UnidadServiceImpl(BaseRepository<Unidad, Long> baseRepository){
        super(baseRepository);
    }
}


