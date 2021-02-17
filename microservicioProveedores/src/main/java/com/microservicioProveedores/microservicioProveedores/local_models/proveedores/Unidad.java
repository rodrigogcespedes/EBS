

package com.microservicioProveedores.microservicioProveedores.local_models.proveedores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservicioProveedores.microservicioProveedores.local_models.Base;


@Entity
@Table(name = "unidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class Unidad extends Base {
    @Column(name = "nombre")
    private String nombre;


}
