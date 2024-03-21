package br.com.alura_senac.farmacia_api_rest.modelo;

import br.com.alura_senac.farmacia_api_rest.DTO.DadosAtualizacaoProduto;
import br.com.alura_senac.farmacia_api_rest.DTO.DadosCadastroFabricante;
import br.com.alura_senac.farmacia_api_rest.DTO.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String descricao;
    double preco;
    @ManyToOne
    Fabricante fabricante;

    public Produto(DadosCadastroProduto dadosCadastroProduto)
    {
        this.nome = dadosCadastroProduto.nome();
        this.descricao = dadosCadastroProduto.descricao();
        this.preco = dadosCadastroProduto.preco();
        this.fabricante = new Fabricante(dadosCadastroProduto.dadosCadastroFabricante());
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dadosAtualizacaoProduto)
    {
        if (dadosAtualizacaoProduto.descricao() != null)
        {
            this.descricao = dadosAtualizacaoProduto.descricao();
        }
    }
}
