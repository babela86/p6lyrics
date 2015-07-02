package pt.uc.dei.ar.paj.wsclient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class WebServicesClient {
	public static void main(String[] args) {
		menuInicial();
		System.out.println("Fim da Aplicação.");
	}

	public static void menuUtilizadores() {
		boolean sair = false;
		while (!sair) {
			System.out.println("\n");
			System.out.println("-----------------------------------\n");
			System.out.println("         Menu Utilizadores\n");
			System.out.println("-----------------------------------\n");
			System.out.println("1 - Número de utilizadores existentes");
			System.out.println("2 - Lista de utilizadores existentes");
			System.out.println("3 - Dados de um utilizador");
			System.out.println("4 - Número de users logados");
			System.out.println("5 - Lista de users logados");
			System.out.println("6 - Playlists de um user");
			System.out.println("7 - Adicionar user");
			System.out.println("8 - Remover user");
			System.out.println("9 - Alterar password");
			System.out.println("0 - Voltar ao menu inicial");
			System.out.println("---------------------");
			System.out.println("Insira uma opção!");
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			switch (i) {
			case 1:
				countusers();
				break;
			case 2:
				listusers();
				break;
			case 3:
				userdata();
				break;
			case 4:
				logedusercounter();
				break;
			case 5:
				logeduserlist();
				break;
			case 6:
				playlistsfromuser();
				break;
			case 7:
				adduser();
				break;
			case 8:
				removeuser();
				break;
			case 9:
				changepass();
				break;
			case 0:
				sair = true;
				menuInicial();
				break;
			default:
				System.out.println("Insira novamente.");
				break;
			}
		}

	}

	public static void menuMusica() {
		boolean out = false;
		while (!out) {
			System.out.println("\n");
			System.out.println("-----------------------------------\n");
			System.out.println("            Menu Musica\n");
			System.out.println("-----------------------------------\n");
			System.out.println("1 - Listar todas as músicas");
			System.out.println("2 - Número de músicas existentes");
			System.out.println("3 - Músicas de uma playlist");
			System.out.println("4 - Dados de uma música concreta");
			System.out.println("5 - Músicas de um user");
			System.out.println("6 - Adicionar músicas a uma playlist");
			System.out.println("7 - Remover músicas de uma playlist");
			System.out.println("8 - Eliminar uma música da DB (passa para o gestor)");
			System.out.println("\n");
			System.out.println("0 - Regressar ao menu inicial");
			System.out.println("-----------------------------------\n");
			System.out.println("Insira uma opção!");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			switch (a) {
			case 1:
				listmusics();
				break;
			case 2:
				countmusics();
				break;
			case 3:
				musicfromplaylist();
				break;
			case 4:
				musicdata();
				break;
			case 5:
				musicfromuser();
				break;
			case 6:
				addmusictoplaylist();
				break;
			case 7:
				removemusicfromplaylist();
				break;
			case 8:
				removemusic();
				break;
			case 0:
				menuInicial();
				out = true;
				break;
			default:
				System.out.println("Opção inválida.\nInsira novamente.");
				break;
			}
		}
	}

	public static void menuPlaylist() {
		boolean sairdomenu = false;
		while (!sairdomenu) {
			System.out.println("\n");
			System.out.println("1 - Listar todas as playlists");
			System.out.println("2 - Número de playlists existentes");
			System.out.println("3 - Músicas de uma playlist");
			System.out.println("4 - Playlists de um user");
			System.out.println("0 - Regressar ao menu inicial");
			System.out.println("---------------------");
			System.out.println("Insira uma opção!");
			Scanner sc = new Scanner(System.in);
			int b = sc.nextInt();
			switch (b) {
			case 1:
				listplaylists();
				break;
			case 2:
				countplaylists();
				break;
			case 3:
				musicfromplaylist();
				break;
			case 4:
				playlistsfromuser();
				break;
			case 0:
				menuInicial();
				sairdomenu = true;
				break;
			default:
				System.out.println("Opção inválida.\nInsira novamente.");
				break;
			}
		}
	}

	public static void menuInicial() {
		System.out.println("\n");
		System.out.println("-----------------------------------\n");
		System.out.println(" APLICACAO CLIENTE DE WEB SERVICES\n");
		System.out.println("-----------------------------------\n");
		System.out.println("1 - Utilizadores");
		System.out.println("2 - Musicas");
		System.out.println("3 - Playlists");
		System.out.println("\n");
		System.out.println("0 - Sair da aplicação");
		System.out.println("-----------------------------------\n");
		System.out.println("Insira uma opção: ");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		switch (c) {
		case 0:
			return;
		case 1:
			menuUtilizadores();
			break;
		case 2:
			menuMusica();
			break;
		case 3:
			menuPlaylist();
			break;
		default:
			System.out.println("Opção inválida.\nInsira novamente.");
			break;
		}
	}

	public static void listusers() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/users/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(UserCollection.class).toString());
	}

	public static void countusers() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de utilizadores registados: "
				+ response.readEntity(UserCollection.class).getUserList()
						.size());
	}

	public static void userdata() {
		listusers();
		System.out
				.println("Qual o utilizador que deseja consultar? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/list/" + d);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out
				.println(response.readEntity(UserRest.class).toString());
	}

	public static void playlistsfromuser() {
		listusers();
		System.out
				.println("Qual o utilizador que deseja consultar? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws/rest/playlists/fromuser/" + e);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(PlaylistCollection.class)
				.toString());
	}

	public static void adduser() {
		UserRest novo = new UserRest();
		System.out.println("Insira nome do utilizador.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		novo.setName(name);
		System.out.println("Insira email do utilizador.");
		Scanner sc1 = new Scanner(System.in);
		String email = sc.nextLine();
		novo.setEmail(email);
		System.out.println("Insira pass do utilizador.");
		Scanner sc2 = new Scanner(System.in);
		String pass = sc.nextLine();
		novo.setPassword(pass);
		System.out
				.println("Data de nascimento no formato: ano-mes-dia. (ex: 1983-04-03)");
		Scanner sc3 = new Scanner(System.in);
		String birth = sc.nextLine();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			novo.setBirthdate(ft.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/add");
		Response response = target.request(MediaType.APPLICATION_XML).post(
				Entity.entity(novo, "application/xml"));
		listusers();
	}

	public static void removeuser() {
		listusers();
		System.out
				.println("Qual o utilizador que deseja remover? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/delete/" + f);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		listusers();
	}

	public static void changepass() {
		listusers();
		System.out.println("Qual utilizador quer mudar a pass? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		UserRest another = new UserRest();
		System.out.println("Insira a nova pass do utilizador.");
		Scanner sc2 = new Scanner(System.in);
		String pass = sc2.nextLine();
		another.setPassword(pass);
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/changepass/"
						+ g);
		Response response = target.request(MediaType.APPLICATION_XML).post(
				Entity.entity(another, "application/xml"));
		listusers();
	}

	public static void listmusics() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicCollection.class)
				.toString());
	}

	public static void countmusics() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de músicas na BD: "
				+ response.readEntity(MusicCollection.class).getMusicList()
						.size());
	}

	public static void musicfromplaylist() {
		listplaylists();
		System.out
				.println("Qual a playlist que deseja consultar? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/fromplaylist/"
						+ h);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicCollection.class)
				.toString());
	}

	public static void listplaylists() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/playlists/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(PlaylistCollection.class)
				.toString());
	}

	public static void musicdata() {
		listmusics();
		System.out.println("Qual a música que deseja consultar? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/list/" + i);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicRest.class).toString());
	}

	public static void musicfromuser() {
		listusers();
		System.out
				.println("Qual o utilizador que deseja consultar? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/fromuser/"
						+ j);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicCollection.class)
				.toString());
	}

	public static void addmusictoplaylist() {
		listplaylists();
		System.out
				.println("Qual a playlist a que deseja adicionar a música? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		listmusics();
		System.out.println("Qual a música deseja adicionar? (Insira o ID)");
		Scanner sc1 = new Scanner(System.in);
		int l = sc.nextInt();

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/add/" + l
						+ "/toplaylist/" + k);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		musicfromplaylist();
	}

	public static void removemusicfromplaylist() {
		listplaylists();
		System.out
				.println("Qual a playlist a que deseja remover a música? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		musicfromplaylist();
		System.out.println("Qual a música que deseja remover? (Insira o ID)");
		Scanner sc1 = new Scanner(System.in);
		int n = sc.nextInt();

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/remove/"
						+ n + "/fromplaylist/" + m);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		musicfromplaylist();
	}
	
	public static void removemusic() {
		listmusics();
		System.out
				.println("Qual a música que deseja remover? (Insira o ID)");
		Scanner sc = new Scanner(System.in);
		int o = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/musics/delete/" + o);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		musicfromuser();
	}
	
	public static void countplaylists() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/playlists/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de playlists registadas: "
				+ response.readEntity(PlaylistCollection.class).getListaPlaylist()
						.size());
	}
	
	public static void logeduserlist() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/listlogedusers");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out
				.println(response.readEntity(UserCollection.class).toString());
	}
	
	public static void logedusercounter() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws/rest/users/listlogedusers");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de utilizadores logados: "
				+ response.readEntity(UserCollection.class).getUserList()
						.size());
	}

}
