package com.microservicioStock.microservicioStock.local_models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.microservicioStock.microservicioStock.remote_models.DTOProveedor;
import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "insumo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Audited
public class Insumo extends Articulo {

    @Column(name = "id_prov")
    private Long idDistribProv;

}
