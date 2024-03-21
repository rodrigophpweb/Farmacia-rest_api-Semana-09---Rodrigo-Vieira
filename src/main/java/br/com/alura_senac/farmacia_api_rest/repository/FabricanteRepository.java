package br.com.alura_senac.farmacia_api_rest.repository;

import br.com.alura_senac.farmacia_api_rest.modelo.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{}
