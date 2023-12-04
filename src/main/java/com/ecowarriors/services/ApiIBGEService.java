package com.ecowarriors.services;

import com.ecowarriors.modelos.Denuncia;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiIBGEService {

    public List<String> listaDeMunicipios() {
        List<String> listaMunicipios = null;
        try {
            listaMunicipios = new ArrayList<>();

            // URL da API que você deseja acessar
            String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/52/distritos";

            // Cria uma URL a partir da string
            URL obj = new URL(url);

            // Abre uma conexão HTTP
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Configura o método da requisição (GET, POST, etc.)
            con.setRequestMethod("GET");

            // Obtém o código de resposta
            int responseCode = con.getResponseCode();
            System.out.println("Código de Resposta: " + responseCode);

            // Lê a resposta da requisição
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Converte a resposta para um array de objetos JsonNode usando Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(response.toString());

            // Certifique-se de que a resposta é um array JSON
            if (jsonArray.isArray()) {
                // Itera sobre os elementos do array
                for (JsonNode jsonNode : jsonArray) {
                    // Verifica se o objeto tem o campo "municipio"
                    if (jsonNode.has("municipio")) {
                        // Obtém o valor do campo "municipio"
                        JsonNode municipioNode = jsonNode.get("municipio");

                        // Verifica se o objeto "municipio" tem o campo "nome"
                        if (municipioNode.has("nome")) {
                            // Extrai e imprime o nome do município
                            String nomeMunicipio = municipioNode.get("nome").asText();
                            listaMunicipios.add(nomeMunicipio);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaMunicipios;
    }

    public static void main(String[] args) {
    }
}

