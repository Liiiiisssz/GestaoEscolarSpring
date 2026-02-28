package br.com.centroweg.escola.model;

public class Curso {
    private Integer id;
    private String nome;
    private String codigo;

    public Curso(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Curso(Integer id, String nome, String codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
