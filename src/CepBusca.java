import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CepBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner busca = new Scanner(System.in);
        System.out.println("Digite seu Cep: ");
        var buscarCep  = busca.nextLine();

        String buscaCepCompleta = ("http:// viacep.com.br/ws/"+ buscarCep +"/json/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buscaCepCompleta))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
