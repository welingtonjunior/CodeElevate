package com.fagundes.catalogodosabio.adapter.in.rest;

import java.time.Instant;

/**
 * Classe que representa um erro gerado pela API, encapsulando informações detalhadas
 * sobre o erro ocorrido em uma requisição.
 * Esta classe pode ser usada para enviar respostas de erro no formato JSON para o cliente.
 */
public class ApiError {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private String traceId;

    /**
     * Construtor da classe ApiError, que inicializa os campos com os valores fornecidos.
     *
     * @param status Código de status HTTP do erro.
     * @param error Descrição do erro (geralmente o nome da exceção).
     * @param path O caminho da requisição que gerou o erro.
     * @param message Mensagem detalhada sobre o erro.
     * @param traceId O ID do rastreamento da requisição, utilizado para monitoramento e depuração.
     */
    public ApiError(int status, String error, String path, String message, String traceId) {
        this.timestamp = Instant.now();  // Marca o momento do erro.
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.traceId = traceId;
    }

    // Getters e Setters

    /**
     * Define o código de status HTTP do erro.
     *
     * @param status O código de status HTTP.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Define o timestamp (data e hora) do erro.
     *
     * @param timestamp O instante do erro.
     */
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Define a descrição do erro (geralmente o nome da exceção).
     *
     * @param error A descrição do erro.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Define uma mensagem detalhada sobre o erro.
     *
     * @param message A mensagem de erro.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Define o caminho da requisição que gerou o erro.
     *
     * @param path O caminho da requisição.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Define o ID do rastreamento da requisição.
     *
     * @param traceId O ID de rastreamento da requisição.
     */
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    // Getters

    /**
     * Retorna o timestamp (data e hora) do erro.
     *
     * @return O instante do erro.
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * Retorna o código de status HTTP do erro.
     *
     * @return O código de status HTTP.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Retorna a descrição do erro.
     *
     * @return A descrição do erro (geralmente o nome da exceção).
     */
    public String getError() {
        return error;
    }

    /**
     * Retorna a mensagem detalhada sobre o erro.
     *
     * @return A mensagem de erro.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retorna o caminho da requisição que gerou o erro.
     *
     * @return O caminho da requisição.
     */
    public String getPath() {
        return path;
    }

    /**
     * Retorna o ID do rastreamento da requisição.
     *
     * @return O ID de rastreamento.
     */
    public String getTraceId() {
        return traceId;
    }
}
