package Steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class JsonPlaceholderSteps {

    private WebDriver driver;
    private Response response;
    private JSONArray photosArray;

    @Given("que eu acesse a pagina inicial do JSONPlaceholder")
    public void que_eu_acesse_a_pagina_inicial_do_jsonplaceholder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jsonplaceholder.typicode.com/");
    }

    @When("eu acessar o menu Guide")
    public void eu_acessar_o_menu_guide() {
        WebElement guideLink = driver.findElement(By.linkText("Guide"));
        guideLink.click();
    }

    @When("eu navegar ate a pagina de albuns")
    public void eu_navegar_ate_a_pagina_de_albuns() {
        driver.get("https://jsonplaceholder.typicode.com/albums/1/photos");
    }

    @Then("eu capturo os dados exibidos e salvo num array JSON")
    public void eu_capturo_os_dados_exibidos_e_salvo_num_array_json() {
        // Fazer a requisição via API para obter os dados
        response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/albums/1/photos");

        photosArray = new JSONArray();

        // Adiciona todos os objetos retornados à lista de JSON
        JSONArray apiResponseArray = response.getBody().as(JSONArray.class);
        for (Object photo : apiResponseArray) {
            photosArray.add(photo);
        }

        // Salvar os dados num arquivo JSON
        try (FileWriter file = new FileWriter("photos.json")) {
            file.write(photosArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("eu valido os dados do objeto com id = {int}")
    public void eu_valido_os_dados_do_objeto_com_id(int id) {
        // Obter os dados do objeto, que são supostamente retornados como um LinkedHashMap
        LinkedHashMap<String, Object> dados = obterDadosDoObjeto(id); // Método que busca os dados

        // Verifique se dados não é nulo e contém a chave esperada
        if (dados == null || !dados.containsKey("id")) {
            throw new IllegalArgumentException("Os dados do objeto não são válidos.");
        }

        // Validar que o id no LinkedHashMap é igual ao id fornecido
        assertEquals("O ID não corresponde ao esperado.", id, dados.get("id"));

        // Percorrer o array para encontrar o objeto com o id especificado
        for (Object obj : photosArray) {
            LinkedHashMap<String, Object> photo = (LinkedHashMap<String, Object>) obj; // Use LinkedHashMap diretamente
            if (photo.get("id").equals(id)) {
                // Validar os dados esperados
                assertEquals(Long.valueOf(6), Long.valueOf((Integer) photo.get("id"))); // Mudar para comparação de Long
                assertEquals("accusamus ea aliquid et amet sequi nemo", photo.get("title"));
                System.out.println("Validação do objeto com id = " + id + " foi bem-sucedida.");
            }
        }
    }

    private LinkedHashMap<String, Object> obterDadosDoObjeto(int id) {
        // Fazer a requisição via API para obter os dados do objeto específico
        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/photos/" + id); // URL para buscar pelo ID correto

        // Verificar se a resposta foi bem-sucedida
        if (response.getStatusCode() == 200) {
            // Converter a resposta em um LinkedHashMap
            return response.getBody().as(LinkedHashMap.class);
        } else {
            // Lidar com a situação em que o objeto não foi encontrado
            System.out.println("Erro ao obter os dados do objeto com ID: " + id);
            return null;
        }
    }
}