package mainApp;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

import constantes.Constantes;

public class MainApp
{

	public static void main(String[] args) throws URISyntaxException
	{
		HttpRequest requetePost = HttpRequest.newBuilder().uri(new URI("https://api.assemblyai.com/v2/transcript"))
				.header("Autorization", Constantes.CLE_API).POST(BodyPublishers.ofString(null)).build();
	}

}
