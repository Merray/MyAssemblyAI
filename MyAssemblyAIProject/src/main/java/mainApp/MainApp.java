package mainApp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import constantes.Constantes;
import entites.Transcrit;

public class MainApp
{

	public static void main(String[] args) throws Exception
	{

		Transcrit transcrit = new Transcrit();
		transcrit.setAudio_url(Constantes.URL_AUDIO);
		transcrit.setLanguage_code(Constantes.CODE_LANGUE);

		Gson gson = new Gson();
		String leJson = gson.toJson(transcrit);

		System.out.println("Appel POST : " + Constantes.POST_URI);
		System.out.println("Body envoyé dans le post : " + leJson);

		HttpRequest requetePost = HttpRequest.newBuilder().uri(new URI(Constantes.POST_URI))
				.header(Constantes.HEADER_AUTHORIZATION, Constantes.CLE_API).POST(BodyPublishers.ofString(leJson))
				.build();

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> reponsePost = httpClient.send(requetePost, BodyHandlers.ofString());

		System.out.println("POST : Body récupéré : " + reponsePost.body());

		transcrit = gson.fromJson(reponsePost.body(), Transcrit.class);

		System.out.println("Appel GET : " + Constantes.GET_URI + transcrit.getId());

		HttpRequest requeteGet = HttpRequest.newBuilder().uri(new URI(Constantes.GET_URI + transcrit.getId()))
				.header("Authorization", Constantes.CLE_API).build();

		while (true)
		{
			HttpResponse<String> reponseGet = httpClient.send(requeteGet, BodyHandlers.ofString());
			transcrit = gson.fromJson(reponseGet.body(), Transcrit.class);

			System.out.println("GET : Body récupéré : " + reponsePost.body());
			System.out.println("Status : " + transcrit.getStatus());

			if ("completed".equals(transcrit.getStatus()) || "error".equals(transcrit.getStatus()))
			{
				break;
			}

			Thread.sleep(Constantes.TEMPS_AVANT_NOUVELLE_REQUETE);
		}

		System.out.println("Fin de transcription !\n");
		System.out.println("Resultats : " + transcrit.getText());

	}

}
