package com.microservicioStock.microservicioStock.repositories;

import com.microservicioStock.microservicioStock.local_models.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E,ID>{
}


