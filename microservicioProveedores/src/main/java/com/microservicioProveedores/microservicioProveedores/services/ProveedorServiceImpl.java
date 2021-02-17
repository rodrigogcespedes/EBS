package com.microservicioProveedores.microservicioProveedores.services;

import com.microservicioProveedores.microservicioProveedores.local_models.proveedores.Proveedor;
import com.microservicioProveedores.microservicioProveedores.repositories.BaseRepository;
import com.microservicioProveedores.microservicioProveedores.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends BaseServiceImpl<Proveedor,Long> implements ProveedorService{

	@Autowired
	private ProveedorRepository ProveedorRepository;
	
	public ProveedorServiceImpl(BaseRepository<Proveedor, Long> baseRepository){
        super(baseRepository);
    }
}


