package com.example.comanda.local_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comandas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comanda extends Base{

    @Temporal(TemporalType.TIME)
    @Column(name = "hora_salida_estimada")
    private Date horaSalidaEstimada;

    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name="fk_estado_comanda")
    private EstadoComanda estadoComanda;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Comanda_DetallesComanda",
    joinColumns = @JoinColumn(name = "Comanda"),
    inverseJoinColumns = @JoinColumn(name = "DetalleComanda"))
    @Builder.Default
    private List<DetalleComanda> detallesComanda = new ArrayList<DetalleComanda>();


}
