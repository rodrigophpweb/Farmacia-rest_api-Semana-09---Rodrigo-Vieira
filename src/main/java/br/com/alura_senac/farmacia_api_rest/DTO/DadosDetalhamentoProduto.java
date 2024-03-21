package br.com.alura_senac.farmacia_api_rest.DTO;

import br.com.alura_senac.farmacia_api_rest.modelo.Fabricante;
import br.com.alura_senac.farmacia_api_rest.modelo.Produto;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoProduto
        (
                @NotNull Long id,
                String nome,
                String descricao,
                double preco,
                Fabricante fabricante)
{
    public DadosDetalhamentoProduto(Produto produto)
    {
        this(produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),produto.getFabricante());
    }

}

