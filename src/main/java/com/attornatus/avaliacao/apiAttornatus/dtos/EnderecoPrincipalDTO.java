package com.attornatus.avaliacao.apiAttornatus.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoPrincipalDTO {
    @NotNull
    @Min(1)
    private long id_endereco;

    public long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
