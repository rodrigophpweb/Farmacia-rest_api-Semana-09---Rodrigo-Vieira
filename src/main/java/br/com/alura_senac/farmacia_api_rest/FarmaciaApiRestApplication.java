package br.com.alura_senac.farmacia_api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
public class FarmaciaApiRestApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(FarmaciaApiRestApplication.class, args);
	}
}

