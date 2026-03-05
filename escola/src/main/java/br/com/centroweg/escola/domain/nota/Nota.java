package br.com.centroweg.escola.domain.nota;

public class Nota {
    private Integer id;
    private Integer alunoId;
    private String alunoNome;
    private Integer aulaId;
    private String aulaAssunto;
    private Double valor;

    public Nota(Integer alunoId, Integer aulaId, Double valor) {
        this.alunoId = alunoId;
        this.aulaId = aulaId;
        this.valor = valor;
    }

    public Nota(String alunoNome, String aulaAssunto, Double valor) {
        this.alunoNome = alunoNome;
        this.aulaAssunto = aulaAssunto;
        this.valor = valor;
    }

    public Nota(Integer id, Integer alunoId, String alunoNome, Integer aulaId, String aulaAssunto, Double valor) {
        this.id = id;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.aulaId = aulaId;
        this.aulaAssunto = aulaAssunto;
        this.valor = valor;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAulaAssunto() {
        return aulaAssunto;
    }

    public void setAulaAssunto(String aulaAssunto) {
        this.aulaAssunto = aulaAssunto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
