package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Screenmatch2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Screenmatch2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new service.ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=56dac46c");
		System.out.println(json);
		service.ConverteDados converteDados = new service.ConverteDados();
		model.DadosSerie dadosSerie = converteDados.obterDados(json, model.DadosSerie.class);
		System.out.println(dadosSerie);
		System.out.println("para git");
	}
}
