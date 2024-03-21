package br.com.alura_senac.farmacia_api_rest.DTO;

import br.com.alura_senac.farmacia_api_rest.modelo.Fabricante;

public record DadosCadastroProduto
        (
                String nome,
                String descricao,
                double preco,
                DadosCadastroFabricante dadosCadastroFabricante
        ){}
