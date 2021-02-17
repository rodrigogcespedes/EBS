package com.microservicioStock.microservicioStock.DTO;

import com.microservicioStock.microservicioStock.local_models.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO<E extends Base> {

    protected Long id;

    public abstract E parseEntity();

}
