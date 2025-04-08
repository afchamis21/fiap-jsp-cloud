package com.fiap.on.esoa.env;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Classe singleton responsável por carregar variáveis de ambiente
 * de um arquivo .env localizado em ./src/main/resources/.env.
 *
 * <p>Exemplo de uso:
 * <pre>{@code
 * EnvLoader env = EnvLoader.getInstance();
 * String azureKey = env.getValue("AZURE_KEY")
 *     .orElseThrow(() -> new RuntimeException("Azure Key is required to run this application!"));
 * System.out.println(azureKey);
 * }</pre>
 */
public class EnvLoader {

    public static void main(String[] args) {
        EnvLoader env = EnvLoader.getInstance();
        String azureKey = env.getValue("AZURE_KEY").orElseThrow(() -> new RuntimeException("Azure Key is required run this application!"));
        System.out.println(azureKey);
    }
    /**
     * Instância singleton do EnvLoader.
     */
    public static EnvLoader instance = null;

    /**
     * Mapa contendo as variáveis de ambiente carregadas do arquivo .env.
     */
    public Map<String, String> env = new HashMap<>();

    /**
     * Retorna a instância singleton do EnvLoader.
     *
     * @return a instância única
     */
    public static EnvLoader getInstance() {
        if (instance == null) {
            instance = new EnvLoader();
        }
        return instance;
    }

    /**
     * Construtor privado que inicializa e carrega as variáveis de ambiente.
     */
    private EnvLoader() {
        loadEnv();
    }

    /**
     * Carrega os pares chave=valor do arquivo .env para o mapa 'env'.
     * Linhas que começam com "#" ou que não possuem "=" são ignoradas.
     */
    private void loadEnv() {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/.env"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().startsWith("#") && line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    env.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("> Erro ao carregar variáveis de ambiente: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna o valor de uma variável de ambiente, se existir.
     *
     * @param key o nome da variável de ambiente
     * @return um Optional com o valor, ou vazio se não encontrada
     */
    public Optional<String> getValue(String key) {
        return Optional.ofNullable(env.get(key));
    }
}
