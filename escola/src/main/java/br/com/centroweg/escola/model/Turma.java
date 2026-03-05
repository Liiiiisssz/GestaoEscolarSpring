package br.com.centroweg.escola.model;

import java.util.List;

public class Turma {
    private Integer id;
    private String nome;
    private Integer cursoId;
    private String nomeCurso;
    private Integer professorId;
    private String nomeProfessor;
    private List<String> nomeAlunos;

    public Turma(String nome, Integer cursoId, Integer professorId) {
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
    }

    public Turma(Integer id, String nome, Integer cursoId, String nomeCurso, Integer professorId, String nomeProfessor, List<String> nomeAlunos) {
        this.id = id;
        this.nome = nome;
        this.cursoId = cursoId;
        this.nomeCurso = nomeCurso;
        this.professorId = professorId;
        this.nomeProfessor = nomeProfessor;
        this.nomeAlunos = nomeAlunos;
    }

    public Turma(Integer id, String nome, Integer cursoId, Integer professorId) {
        this.id = id;
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public List<String> getNomeAlunos() {
        return nomeAlunos;
    }

    public void setNomeAlunos(List<String> nomeAlunos) {
        this.nomeAlunos = nomeAlunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }
}
