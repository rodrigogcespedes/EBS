package com.example.comanda.local_models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "detalles_comanda")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleComanda extends Base {


    @Column(name = "aclaracion")
    private String aclaracion;
}
