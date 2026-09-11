import java.util.Scanner;

public class MiProyecto {
	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
			
			String[] usuario = null;
			int[] edad = null;
			double[] deuda = null;
			
			String[] producto = null;
			int[] stock = null;
			double[] precio = null;
			
			int opcion;
			do {
				System.out.println("Tiedan de mercancia");
				System.out.println("1. Menu de usuarios");
				System.out.println("2. Menu de productos");
				System.out.println("3. Salir de sistema");
				System.out.println("Seleccione una opcion");
				opcion = datos.nextInt();
				
					switch(opcion) {
						case 1:
						int opcion2;
						do {
							System.out.println("Menu de usuarios");
							System.out.println("1. Colocar usuarios");
							System.out.println("2. Lista de usuarios");
							System.out.println("3. Todas las deudas");
							System.out.println("4. Mayor deuda");
							System.out.println("5. Gestion de deudas");
							System.out.println("6. volver al menu");
							System.out.println("Seleccione una opcion");
							opcion2 = datos.nextInt();
							datos.nextLine();
						
						
								switch(opcion2) {
									case 1:
										System.out.println("¿Cuantos usuarios ahi?");
										int nuevos = datos.nextInt();
										datos.nextLine();
										
										if(usuario == null) {
											usuario = new String[nuevos];
											edad = new int[nuevos];
											deuda = new double[nuevos];
										
											for(int j = 0; j < nuevos; j++) {
												System.out.println("\n--- Usuario #" + (j + 1) + " ---");
												System.out.println("Nombre del usuario");
												usuario[j] = datos.nextLine();
											
												System.out.println("Edad del usuario");
												edad[j] = datos.nextInt();
											
												System.out.println("deuda a pagar");
												deuda[j] = datos.nextDouble(); 
												datos.nextLine();
											}
										} else {
											String[] usuariosViejos = usuario;
											int[] edadesViejas = edad;
											double[] deudasViejas = deuda;
											
											int tamañoAnterior = usuariosViejos.length;
											int nuevoTamaño = tamañoAnterior + nuevos;
											
											usuario = new String[nuevoTamaño];
											edad = new int[nuevoTamaño];
											deuda = new double[nuevoTamaño];
											
											for(int j = 0; j < tamañoAnterior; j++) {
												usuario[j] = usuariosViejos[j];
												edad[j] = edadesViejas[j];
												deuda[j] = deudasViejas[j];
											}
											
											for (int j = tamañoAnterior; j < nuevoTamaño; j++) {
												System.out.println("\n--- Usuario #" + (j + 1) + " ---");
												System.out.println("Nombre del usuario");
												usuario[j] = datos.nextLine();
												
												System.out.println("Edad del usuario");
												edad[j] = datos.nextInt();
												
												System.out.println("Deuda a pagar");
												deuda[j] = datos.nextDouble();
												datos.nextLine();
											}
										}
										
										System.out.println("Usuario registrado correctamente");
										break;
									case 2:
									if(usuario == null) {
										System.out.println("No se registro ningun usuario todavia");
									} else {
										System.out.println("--- Lista de Usuarios ---");
										for(int j = 0; j < usuario.length; j++) {
											System.out.println("Usuario: " + usuario[j] + " | Edad: " + edad[j] + " | Deuda: $" + deuda[j]);
										}
									}
										break;
									case 3:
										System.out.println("Lista de deudas");
										
										for(int j = 0; j < usuario.length; j++) {
											System.out.println(usuario[j] + " debe: " + deuda[j]);
										}
										break;
									case 4:
										double deudaMayor = 0;
										
										for(int j = 0; j < usuario.length; j++) {
											if(deuda[j] > deudaMayor) {
												deudaMayor = deuda[j];
											}
										}
										System.out.println("la deuda mas grande es: " + deudaMayor);
										break;
									case 5:
										if(usuario == null) {
											System.out.println("No se registro ningun usuario todavia");
										} else {
											System.out.println("Ingrese el nombre del usuario");
											String nombreBuscar = datos.nextLine();
											boolean encontrado = false;
											
											for(int i = 0; i < usuario.length; i++) {
												if(usuario[i].equalsIgnoreCase(nombreBuscar)) {
												encontrado = true;
												
												System.out.println("\nUsuario encontrado: " + usuario[i]);
												System.out.println("Deuda actual: $" + deuda[i]);
                
												System.out.println("\n¿Qué desea hacer?");
												System.out.println("1. Pagar deuda (reducir)");
												System.out.println("2. Aumentar deuda");
												System.out.println("3. Cancelar");
												System.out.print("Seleccione una opción: ");
												int subOpcion = datos.nextInt();
												datos.nextLine();
												
												if(subOpcion == 1) {
													System.out.println("¿Cuanto va a pagar el usuario?");
													double pago = datos.nextDouble();
													datos.nextLine();
													
													if(pago > deuda[i]) {
														System.out.println("El pago del usuario supera la deuda ($" + deuda[i] + "). Intentelo de nuevo");
													} else {
														deuda[i] -= pago;
														System.out.println("¡Pago ralizado! la nueva deuda del usuario " + usuario[i] + "es: $" + deuda[i]); 
													}
												} else if(subOpcion == 2) {
													System.out.println("¡Deuda aumentada! cuanto desea aumentar a la deuda");
													double aumento = datos.nextDouble();
													datos.nextLine();
													
													deuda[i] += aumento;
													System.out.println("¡Deuda aumentada! la nueva deuda del usuario: " + usuario[i] + "es: $" + deuda[i]);
												} else {
													System.out.println("Operacion cancelada");
												}
												break;
												}
											}
											if(!encontrado) {
											System.out.println("no se encontro ningun usuario con el nombre: " + nombreBuscar);
											}
										}
										break;
									case 6:
										System.out.println("Volviendo al menu principal");
										break;
									default:
										System.out.println("opcion no valida");
								}
							}while(opcion2 != 6);
						break;
					case 2:
						int opcion3;
						
						do {
							System.out.println("Menu de productos");
							System.out.println("1. Poner productos");
							System.out.println("2. Lista de productos");
							System.out.println("3. Productos con poquito stock");
							System.out.println("4. Restaurar producto");
							System.out.println("5. Volver al menu principal");
							System.out.println("Seleccione una opcion");
							opcion3 = datos.nextInt();
							datos.nextLine();
							
							switch(opcion3) {
								case 1:
									System.out.println("¿Cuántos productos desea agregar?");
									int nuevosProd = datos.nextInt();
									datos.nextLine();

									if (producto == null) {
									producto = new String[nuevosProd];
									stock = new int[nuevosProd];
									precio = new double[nuevosProd];

										for (int j = 0; j < nuevosProd; j++) {
											System.out.println("\n--- Producto #" + (j + 1) + " ---");
											System.out.print("Nombre del producto: ");
											producto[j] = datos.nextLine();

											System.out.print("Stock: ");
											stock[j] = datos.nextInt();

											System.out.print("Precio: ");
											precio[j] = datos.nextDouble();
											datos.nextLine();
										}
									} else {
										String[] productosViejos = producto;
										int[] stockViejo = stock;
										double[] preciosViejos = precio;

										int tamañoAnterior = productosViejos.length;
										int nuevoTamaño = tamañoAnterior + nuevosProd;

										producto = new String[nuevoTamaño];
										stock = new int[nuevoTamaño];
										precio = new double[nuevoTamaño];

										for (int j = 0; j < tamañoAnterior; j++) {
											producto[j] = productosViejos[j];
											stock[j] = stockViejo[j];
											precio[j] = preciosViejos[j];
										}

										for (int j = tamañoAnterior; j < nuevoTamaño; j++) {
											System.out.println("\n--- Nuevo Producto #" + (j + 1) + " ---");
											System.out.print("Nombre del producto: ");
											producto[j] = datos.nextLine();

											System.out.print("Stock: ");
											stock[j] = datos.nextInt();

											System.out.print("Precio: ");
											precio[j] = datos.nextDouble();
											datos.nextLine();
										}
									}
									System.out.println("¡Productos registrados con éxito!");
									break;
								case 2:
									if(stock == null) {
										System.out.println("primero debe registrar en la (opcion 1)");
									} else {
										for(int j = 0; j < stock.length; j++) {	
												if(stock[j] < 5) {
													System.out.println("Producto: " + producto[j] + " [POCO STOCK] " + stock[j] + " | precio: " + precio[j]);
												} else {
													System.out.println("Producto: " + producto[j] + " | Stock: " + stock[j] + " | precio: " + precio[j]);
												}
											}
										}
									break;
								case 3:
									if(stock == null) {
										System.out.println("No hay productos registrados todavia");
									} else {
										System.out.println("--- Productos con poco stock (< 5) ---");
										boolean algunoPoco = false;
										for(int i = 0; i < stock.length; i++) {
											if(stock[i] < 5) {
												System.out.println("Producto: " + producto[i] + " | Stock: " + stock[i]);
												algunoPoco = true;
											}
										}
									if(!algunoPoco) {
										System.out.println("Todos los productos tienen suficiente stock");
									}
								}
									break;
								case 4:
									if(producto == null) {
										System.out.println("No se registro ningun producto todavia");
									} else {
										System.out.println("Nombre del producto");
										String nombreBuscar2 = datos.nextLine();
										boolean encontrado2 = false;
										
										for(int i = 0; i < producto.length; i++) {
											if(producto[i].equalsIgnoreCase(nombreBuscar2)) {
											encontrado2 = true;
											
											System.out.println("Producto encontrado: " + producto[i]);
											System.out.println("stock total: " + stock[i]);
											
											System.out.println("¿Que desea hacer?");
											System.out.println("1. Restaurar producto");
											System.out.println("2. Cancelar");
											int subOpcion2 = datos.nextInt();
											
											if(subOpcion2 == 1) {
												System.out.println("Cuanto desea reabastecer");
												int aumento2 = datos.nextInt();
												datos.nextLine();
												
												stock[i] += aumento2;
												System.out.println("¡Aumento con exito! el total de stock atual es: " + stock[i]);
											} else {
												System.out.println("Cancelando opcion");
											}
											break;
											}
										}
										if(!encontrado2) {
											System.out.println("no se encontro ningun producto con el nombre: " + nombreBuscar2);
										}
									}
									break;
								case 5:
									System.out.println("volviendo al menu principal");
									break;
								default:
									System.out.println("opcion no valida");
							}
						}while(opcion3 != 5);
						break;
					case 3:
						System.out.println("Saliendo del sistema");
						break;
					default:
						System.out.println("opcion no valida");
				}
		}while(opcion != 3);
	}
}

