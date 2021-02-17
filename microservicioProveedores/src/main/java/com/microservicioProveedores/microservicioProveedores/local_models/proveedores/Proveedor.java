package com.microservicioProveedores.microservicioProveedores.local_models.proveedores;

import javax.persistence.*;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservicioProveedores.microservicioProveedores.local_models.Base;


@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class Proveedor extends Base {
    @Column(name = "razonSocial")
    private String razonSocial;
    @Column(name = "contacto")
    private String contacto;
}
