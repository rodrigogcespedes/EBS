package com.example.comanda.repositories;

import com.example.comanda.local_models.Comanda;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends BaseRepository<Comanda,Long> {
}
