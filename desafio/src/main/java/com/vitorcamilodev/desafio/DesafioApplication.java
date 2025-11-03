package com.vitorcamilodev.desafio;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vitorcamilodev.desafio.entities.Order;
import com.vitorcamilodev.desafio.services.OrderService;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner{

	@Autowired
    OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Order order = new Order();
		
		System.out.println("Codigo: ");
		order.setCode(sc.nextInt());
		System.out.println("Valor: ");
		order.setBasic(sc.nextDouble());
		System.out.println("Desconto: ");
		order.setDiscount(sc.nextDouble());
		
		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order));
	}

}
