package dei.uc.pt.ar.paj;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Scanner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import dei.uc.pt.ar.paj.pojo.MusicCollection;
import dei.uc.pt.ar.paj.pojo.MusicRest;
import dei.uc.pt.ar.paj.pojo.PlaylistCollection;
import dei.uc.pt.ar.paj.pojo.UserCollection;
import dei.uc.pt.ar.paj.pojo.UserRest;
import dei.uc.pt.ar.paj.pojo.CountRest;

public class WebServicesClient {
	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
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
				changepassword();
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
			System.out.println("-----------------------------------\n");
			System.out.println("           Menu playlist\n");
			System.out.println("-----------------------------------\n");
			System.out.println("1 - Listar todas as playlists");
			System.out.println("2 - Número de playlists existentes");
			System.out.println("3 - Músicas de uma playlist");
			System.out.println("4 - Playlists de um user");
			System.out.println("\n");
			System.out.println("0 - Regressar ao menu inicial");
			System.out.println("-----------------------------------\n");
			System.out.println("Insira uma opção!");
			
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

		int c = sc.nextInt();
		switch (c) {
		case 0:
			sc.close();
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
				.target("http://localhost:8080/thews-ws2/rest/users/number");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de utilizadores registados: "
				+ response.readEntity(CountRest.class).getContador() );
	}

	public static void userdata() {
		listusers();
		System.out.println("Qual o utilizador que deseja consultar? (Insira o ID)");
		int d = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/users/list/" + d);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(UserRest.class).toString());
	}

	public static void playlistsfromuser() {
		listusers();
		System.out.println("Qual o utilizador que deseja consultar? (Insira o ID)");
		int e = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/playlists/fromuser/" + e);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(PlaylistCollection.class)
				.toString());
	}

	public static void adduser() {
		UserRest novo = new UserRest();
		//limpar enter
		sc.nextLine();
		System.out.println("Insira nome do utilizador.");
		String name = sc.nextLine();
		novo.setName(name);
		System.out.println("Insira email do utilizador.");
		String email = sc.nextLine();
		novo.setEmail(email);
		System.out.println("Insira pass do utilizador.");
		String pass = sc.nextLine();
		novo.setPassword(pass);
		System.out.println("Data de nascimento no formato: ano-mes-dia. (ex: 1983-04-03)");
		String birth = sc.nextLine();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			novo.setBirthdate(ft.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/users/add");
		target.request(MediaType.APPLICATION_XML).post(Entity.entity(novo, "application/xml"));
		listusers();
	}

	public static void removeuser() {
		listusers();
		System.out.println("Qual o utilizador que deseja remover? (Insira o ID)");
		int f = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/users/delete/" + f);
		target.request().get();
		listusers();
	}

	public static void changepassword() {
		listusers();
		System.out.println("Qual utilizador quer mudar a pass? (Insira o ID)");
		int g = sc.nextInt();
		//limpa enter
		sc.nextLine();
		UserRest another = new UserRest();
		another.setIdUtilizador(g);
		
		System.out.println("Insira a nova pass do utilizador.");
		String pass = sc.nextLine();
		try {
			another.setPassword(encriptaPass(pass));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao codificar password:\n"+e);
			//e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Erro ao codificar password:\n"+e);
		}
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/users/changepassword");
		target.request(MediaType.APPLICATION_XML).post(Entity.entity(another, "application/xml"));
		listusers();
	}

	public static void listmusics() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/musics/list");
		Response response = target.request().get();
		System.out.println(response.readEntity(MusicCollection.class));
	}

	public static void countmusics() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/musics/number");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Numero de Musicas existentes: " + response.readEntity(CountRest.class).getContador() );
	}
	
	public static void musicfromplaylist() {
		listplaylists();
		System.out.println("Qual a playlist que deseja consultar? (Insira o ID)");
		int h = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/musics/fromplaylist/"
						+ h);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicCollection.class)
				.toString());
	}
	
	public static void musicfromplaylist(int playlistID) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/musics/fromplaylist/"
						+ playlistID);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicCollection.class)
				.toString());
	}

	public static void listplaylists() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/playlists/list");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(PlaylistCollection.class)
				.toString());
	}

	public static void musicdata() {
		listmusics();
		System.out.println("Qual a música que deseja consultar? (Insira o ID)");
		int i = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/musics/list/" + i);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicRest.class).toString());
	}

	public static void musicfromuser() {
		listusers();
		System.out.println("Qual o utilizador que deseja consultar? (Insira o ID)");
		int j = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/musics/fromuser/" + j);
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println(response.readEntity(MusicCollection.class).toString());
	}

	public static void addmusictoplaylist() {
		listplaylists();
		System.out.println("Qual a playlist a que deseja adicionar a música? (Insira o ID)");
		int k = sc.nextInt();
		listmusics();
		System.out.println("Qual a música deseja adicionar? (Insira o ID)");
		int l = sc.nextInt();

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/musics/add/"
						+ l + "/toplaylist/" + k);
		target.request(MediaType.APPLICATION_XML).get();
		musicfromplaylist();
	}

	public static void removemusicfromplaylist() {
		listplaylists();
		System.out
				.println("Qual a playlist a que deseja remover a música? (Insira o ID)");
		int m = sc.nextInt();
		musicfromplaylist(m);
		System.out.println("Qual a música que deseja remover? (Insira o ID)");
		int n = sc.nextInt();

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/musics/remove/"
						+ n + "/fromplaylist/" + m);
		target.request(MediaType.APPLICATION_XML).get();
		musicfromplaylist();
	}
	
	public static void removemusic() {
		listmusics();
		System.out.println("Qual a música que deseja remover? (Insira o ID)");
		int n = sc.nextInt();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/musics/delete/" + n);
		target.request(MediaType.APPLICATION_XML).get();
		musicfromuser();
	}
	
	public static void countplaylists() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/thews-ws2/rest/playlists/number");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de playlists registadas: "
				+ response.readEntity(CountRest.class).getContador() );
	}
	
	public static void logeduserlist() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/users/listlogedusers");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out
				.println(response.readEntity(UserCollection.class).toString());
	}
	
	public static void logedusercounter() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target("http://localhost:8080/thews-ws2/rest/users/numberlogedusers");
		Response response = target.request(MediaType.APPLICATION_XML).get();
		System.out.println("Número de utilizadores logados: "
				+ response.readEntity(CountRest.class).getContador() );
	}
	
	public static String encriptaPass(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (null == password) {
			return null;
		}
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			String stringToStore = new String(Base64.getEncoder().encode(hash));
			return stringToStore;
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}
