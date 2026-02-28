package br.com.centroweg.escola.model;

public class Turma {
    private Integer id;
    private String nome;
    private Integer cursoId;
    private Integer professorId;

    public Turma(String nome, Integer cursoId, Integer professorId) {
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
    }

    public Turma(Integer id, String nome, Integer cursoId, Integer professorId) {
        this.id = id;
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
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
