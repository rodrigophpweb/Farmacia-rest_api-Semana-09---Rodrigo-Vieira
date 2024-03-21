package br.com.alura_senac.farmacia_api_rest.controller;

import br.com.alura_senac.farmacia_api_rest.DTO.DadosAtualizacaoProduto;
import br.com.alura_senac.farmacia_api_rest.DTO.DadosCadastroProduto;
import br.com.alura_senac.farmacia_api_rest.DTO.DadosDetalhamentoProduto;
import br.com.alura_senac.farmacia_api_rest.DTO.DadosListagemProduto;
import br.com.alura_senac.farmacia_api_rest.repository.ProdutoRepository;
import br.com.alura_senac.farmacia_api_rest.modelo.Produto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("produtos")
public class ProdutoController
{
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriComponentsBuilder)
    {
        var produto = new Produto(dadosCadastroProduto);
        produtoRepository.save(new Produto(dadosCadastroProduto));

        var uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProduto>> listar(@PageableDefault(size = 1, sort = {"nome"}) Pageable paginacao)
    {
        var page = produtoRepository.findAll(paginacao).map(DadosListagemProduto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProduto dadosAtualizacaoProduto)
    {
        var produto = produtoRepository.getReferenceById(dadosAtualizacaoProduto.id());
        produto.atualizarInformacoes(dadosAtualizacaoProduto);
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id)
    {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
