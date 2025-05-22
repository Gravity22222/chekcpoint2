package br.com.fiap.checkpoint2.DTOs;

import java.time.LocalDateTime;

public class ProfissionalDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private double valorHora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    

    public ProfissionalDTO(Long id, String nome, String especialidade, double valorHora, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.valorHora = valorHora;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

}
