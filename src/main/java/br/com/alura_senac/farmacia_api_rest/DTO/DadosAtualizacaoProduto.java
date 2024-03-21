package br.com.alura_senac.farmacia_api_rest.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(@NotNull Long id, String descricao){}
