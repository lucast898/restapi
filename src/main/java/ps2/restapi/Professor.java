package ps2.restapi;

public class Disciplina {
	private long id;
	private String nome;
	private String sigla;
	private String curso;
 private int semestre;
		
	public Disciplina() {}
	public Disciplina(long id, String n, String si, String c, int s) {
		this.id = id;
		this.nome = n;
		this.sigla = si;
  this.curso = c;
  this.semestre = s;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

 public String getSigla() {
  return sigla;
 }

 public void setSigla(String sigla) {
  this.sigla = sigla;
}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
