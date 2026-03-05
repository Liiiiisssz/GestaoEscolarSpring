package br.com.centroweg.escola.domain.aula;

import java.time.LocalDateTime;

public class Aula {
    private Integer id;
    private Integer turmaId;
    private String turmaNome;
    private LocalDateTime dataHora;
    private String assunto;

    public Aula(Integer turmaId, LocalDateTime dataHora, String assunto) {
        this.turmaId = turmaId;
        this.dataHora = dataHora;
        this.assunto = assunto;
    }

    public Aula(Integer id, Integer turmaId, String turmaNome, LocalDateTime dataHora, String assunto) {
        this.id = id;
        this.turmaId = turmaId;
        this.turmaNome = turmaNome;
        this.dataHora = dataHora;
        this.assunto = assunto;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
