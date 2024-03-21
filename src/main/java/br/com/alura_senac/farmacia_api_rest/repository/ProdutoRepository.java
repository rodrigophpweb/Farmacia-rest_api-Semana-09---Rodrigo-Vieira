package br.com.alura_senac.farmacia_api_rest.repository;

import br.com.alura_senac.farmacia_api_rest.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
//    List<Produto> findByNome();
}
