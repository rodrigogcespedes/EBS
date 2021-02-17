package com.microservicioStock.microservicioStock.local_models.stock;

import com.microservicioStock.microservicioStock.local_models.Base;
import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "articulo_existencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Builder
public class Articulos_Existencia extends Base {

    @Column(name="id_existencia")
    private Long id_existencia;
}
