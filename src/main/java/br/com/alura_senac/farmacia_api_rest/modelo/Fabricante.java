package br.com.alura_senac.farmacia_api_rest.modelo;

import br.com.alura_senac.farmacia_api_rest.DTO.DadosCadastroFabricante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "fabricantes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fabricante
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produto;

    public Fabricante(DadosCadastroFabricante dadosCadastroFabricante)
    {
        this.nome = dadosCadastroFabricante.nome();
    }
}
