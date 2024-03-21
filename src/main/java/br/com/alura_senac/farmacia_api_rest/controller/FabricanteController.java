package br.com.alura_senac.farmacia_api_rest.controller;

import br.com.alura_senac.farmacia_api_rest.DTO.DadosCadastroFabricante;
import br.com.alura_senac.farmacia_api_rest.DTO.DadosCadastroProduto;
import br.com.alura_senac.farmacia_api_rest.repository.FabricanteRepository;
import br.com.alura_senac.farmacia_api_rest.modelo.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController
{
    @Autowired
    private FabricanteRepository fabricanteRepository;

    @PostMapping
    @Transactional
    public void cadastrarFabricante(@RequestBody DadosCadastroFabricante dadosCadastroFabricante)
    {
        fabricanteRepository.save(new Fabricante(dadosCadastroFabricante));
    }
}
