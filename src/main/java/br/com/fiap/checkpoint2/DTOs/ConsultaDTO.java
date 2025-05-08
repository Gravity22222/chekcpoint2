package br.com.fiap.checkpoint2.DTOs;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long id;
    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime dataConsulta;
    private String statusConsulta;
    private Integer quantidadeHoras;
    private Double valorConsulta;

   

    public ConsultaDTO(Long id, Long profissionalId, Long pacienteId, LocalDateTime dataConsulta, String statusConsulta,
            Integer quantidadeHoras, Double valorConsulta) {
        this.id = id;
        this.profissionalId = profissionalId;
        this.pacienteId = pacienteId;
        this.dataConsulta = dataConsulta;
        this.statusConsulta = statusConsulta;
        this.quantidadeHoras = quantidadeHoras;
        this.valorConsulta = valorConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

}
