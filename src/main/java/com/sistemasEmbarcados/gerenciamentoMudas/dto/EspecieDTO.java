package com.sistemasEmbarcados.gerenciamentoMudas.dto;

import lombok.Data;

@Data
public class EspecieDTO {
    private String nomeComum;
    private String nomeCientifico;
    private String descricao;
    private String imagem;
}
