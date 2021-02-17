package com.microservicioStock.microservicioStock.local_models.stock;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "manufacturado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class Manufacturado extends Articulo {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receta> recetas = new ArrayList<Receta>();


}
