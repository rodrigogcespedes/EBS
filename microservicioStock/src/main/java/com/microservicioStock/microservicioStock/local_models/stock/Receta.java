package com.microservicioStock.microservicioStock.local_models.stock;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder.Default;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservicioStock.microservicioStock.local_models.Base;


@Entity
@Table(name = "receta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class Receta extends Base {
    @Column(name = "costoElaboracion")
    private float costoElaboracion;
    @Column(name = "instrucciones")
    private String instrucciones;
    @Column(name = "tiempoElaboracion")
    private int tiempoElaboracion;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Receta_Articulo",
            joinColumns = @JoinColumn(name = "Receta"),
            inverseJoinColumns = @JoinColumn(name = "Articulo"))
    @Default
    private List<Articulo> ingredientes = new ArrayList<Articulo>();


}
