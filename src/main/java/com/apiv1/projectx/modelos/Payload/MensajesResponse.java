package com.apiv1.projectx.modelos.Payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
public class MensajesResponse  {

    private String mensaje;
    private Object objeto;
}
