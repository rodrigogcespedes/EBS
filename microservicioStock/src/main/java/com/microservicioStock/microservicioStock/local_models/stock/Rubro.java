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
@Table(name = "rubro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class Rubro extends Base {
    @Column(name = "nombre")
    private String nombre;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "RubroP_RubroH",
            joinColumns = @JoinColumn(name = "RubroPadre"),
            inverseJoinColumns = @JoinColumn(name = "RubroHijo"))
    @Default
    private List<Rubro> pertenece = new ArrayList<Rubro>();


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Rubro_Articulo",
            joinColumns = @JoinColumn(name = "Rubro"),
            inverseJoinColumns = @JoinColumn(name = "Articulo"))
    @Default
    private List<Articulo> articulos = new ArrayList<Articulo>();


}
