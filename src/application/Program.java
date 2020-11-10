package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.next());

		/* Instanciando o objeto Cliente */
		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		/* Instanciando pedido */
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order ?: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			name = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();

			/* Instanciando o objeto Produto */
			Product product = new Product(name, price);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			/* Instanciando o objeto Item produto */
			OrderItem orderItem = new OrderItem(quantity, price, product);

			order.addItem(orderItem); // salvando na LIST

		}
		
		System.out.println(order);

		sc.close();

	}

}
