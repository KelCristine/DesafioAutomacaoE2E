# DesafioAutomacaoE2E
Projeto desafio de automação - VAGA QA Lead.


Olá, Avaliador, 
  Segue abaixo instruções de sugestão para o melhor uso do arquivo anexo, caso seja do seu interesse efetuar download e importá-lo na IDE utilizada para este projeto:



  📋 Pré-requisitos
  
  #IDE: Intellij IDEA Community
  #Tool Kit Java: Java JDK - ultima versão
  #Bibliotecas: JUnit, WebDriver e WebDriverManager, RestAssured (para validar dados de API)
  #Gerenciador de pacotes: Maven
  #Automação: Selenium / Cucumber (para BDD)
  #Relatórios: Cucumber e Allure (relatórios API)
  #Dependências: https://mvnrepository.com/artifact/org...
  

  
  
  🔧 Instalação
  
  JDK:
  Baixar versão mais recente do JDK: https://www.oracle.com/br/java/technologies/downloads/
  Executar na máquina;
  
  ![image](https://github.com/user-attachments/assets/0297a8d2-90b7-4340-a695-3cf4816b7c98)
  
  Allure-Results:

  Baixar o pacote da allure nas dependências, bem como arquivo .zip no fim da página: https://github.com/allure-framework/allure2/releases;
  Descompactar a pasta;
  Acessar via pesquisa do menu "windows" - "variáveis de ambiente";
  Configurando da seguinte forma:

  ![image](https://github.com/user-attachments/assets/4b060ffe-eb09-4ed5-99b3-e75da07f0f71)
  ![image](https://github.com/user-attachments/assets/f5b57c9e-7999-4703-b30a-af0f25645f12)

  Incluindo o caminho do diretório onde o arquivo bin do allure foi baixado:
  ![image](https://github.com/user-attachments/assets/ed5fa38f-3d2c-462b-b7d7-7a1313f22ea8)

  
  IDE: 
  Instalar a IDE Intellij IDEA - v. Community (gratuita): https://www.jetbrains.com/idea/download/?section=windows 
  
  Selecione seu sistema operacional
  Buscar na pasta selecionada para download, o arquivo executável.
  Iniciar o executável do Intellij;
  Selecionar a pasta destino onde ficarão seus futuros projetos;
  Na tela de seleção de opções de instalação, selecionar todas as opções disponíveis;
  Clique em "install"
  
  
  ![image](https://github.com/user-attachments/assets/9b66647c-ce4f-46fc-99cd-4c8c02b363f7)
  ![image](https://github.com/user-attachments/assets/c2a09ad4-8491-450c-8a2c-49b1eb4c35aa)
  ![image](https://github.com/user-attachments/assets/ec80482a-98b8-4e60-a2f3-8ff2f7ef0266)
  ![image](https://github.com/user-attachments/assets/305ff930-49d0-4fb2-96c6-c5454d8a27d6)
  ![image](https://github.com/user-attachments/assets/98b55a95-b494-4d36-a006-fa45fadb4da0)
  
  Ao finalizar, abrir a IDE e selecionar a opção "Open"
  Selecione a pasta do projeto baixado;
  
  ![image](https://github.com/user-attachments/assets/829e266d-7d4a-4a30-a750-5d2266e9d729)
  ![image](https://github.com/user-attachments/assets/4025cd28-bda2-4847-ba40-55d12cdbc8e0)
  ![image](https://github.com/user-attachments/assets/26e211d3-ccff-4ac7-a68b-442838a2a214)
  
  
  🚀 Navegando pelo projeto 
   - Ao abrir a tela principal do projeto há a seguinte estrutura:
  	
  ![print](https://github.com/user-attachments/assets/ab565b77-3122-478a-a530-aa8781e1c635)

  
   O que é importante avaliar na estrutura do projeto "DesafioAutomacaoKellyCristineE2E": 
	
"/src/test/java/runners/" - Encontra-se a classe CucumberTestRunner, nela consta o código utilizado para a execução da automação, devidamente comentado por etapas;
	
"/src/test/java/Steps/" - Encontra-se a classe JsonPlaceholderSteps, nela consta o código que será chamado pela clase de execução CucumberTestRunner, que particiona cada atividade que será executada conforme o cenário descrito em BDD, também devidamente comentado por etapas;
	
"/src/test/resouces/features/" - Encontra-se o arquivo "jsonplaceholder.feature", nele constam os cenários descritos em BDD, que será chamado dentro da Classe JsonPlaceholderSteps, etapa por etapa e será executado pela clase de execução CucumberTestRunner
	
"/src/test/resouces/" - Há o arquivo cucumber.properties que é responsável por iniciar e gravar o registro da execução, gerando um arquivo Report para consulta;
	
"/Taget/" - Encontra-se o arquivo "cucumber.json" que armazenou as informações do conteúdo do body, preservando os dados do "id = 6" conforme solicitado em avaliação, bem como descrito no código de automação; Contém também o arquivo "cucumber.reports.html" que pode ser aberto no navegador para validação de que o cenário fora executado com sucesso.

"photos.json" - Encontra-se os dados do album armazenados, conforme solicitado em avaliação, bem como descrito no código de automação.
	
"pom.xml" - Na estrutura POM.XML encontram-se as dependências usadas no projeto, com as bibliotecas e pluggins que auxiliaram no desenvolvimento do código;
	
"External Libraries" - Encontram-se todas as bibliotecas que foram adicionadas para uso no pom.xml.
  	
	
  ⚙️ Executando os testes
  
  Para executar sem falhas o projeto, é necessário configurar algumas dependências, instalando bibliotecas que auxilam o código, para isso:
  Acessar arquivo "pom.xml" e incluir a seguinte estrutura de instalação de dependencias dentro da tag <project> </project>
  
          <dependencies>
            <!-- Dependência para RestAssured -->
            <dependency>
                <groupId>io.rest-assured</groupId>
                <artifactId>rest-assured</artifactId>
                <version>5.4.0</version>
                <scope>test</scope>
            </dependency>

            <!-- Dependência para JUnit -->
            <dependency>
                <groupId>org.junit.jupiter</groupId>
                <artifactId>junit-jupiter</artifactId>
                <version>5.9.3</version>
                <scope>test</scope>
            </dependency>

            <!-- Dependência para Allure (para relatórios) -->
            <dependency>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-junit5</artifactId>
                <version>2.20.1</version>
                <scope>test</scope>
            </dependency>
        </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-maven</artifactId>
                <version>2.20.1</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
   
  
  Após esta etapa, basta clicar com o lado direito do mouse sobre a classe "CucumberTestRunner" e selecionar a opção "Run 'CucumberTestRunner'"
  ![image](https://github.com/user-attachments/assets/234e6626-7812-4be1-bbd7-4bc4aa9b17b9)
  
  A execução da automação será iniciada, será aberta uma tela do navegador chrome em que a aplicação será executada e, quando finalizada com sucesso conforme evidência abaixo:
  ![image](https://github.com/user-attachments/assets/619fd392-e73f-465e-907d-16db64442da4)

  Um informativo de que o teste passou, será apresentado na tela;
  Bem como, também será disponibilizado link de report para acesso:
  ![image](https://github.com/user-attachments/assets/e5e88a0b-6c2a-46dd-a0da-c503da9882cd)

  E novos reports/evidências serão armazenados em cucumber.reports.html para consulta.
  ![image](https://github.com/user-attachments/assets/9a553937-1ef8-4126-a611-8b89d6695990)

  
  

✒️ Autoria:
Kelly Cristine Danderfer Pina - Avaliada 
