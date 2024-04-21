package helpdesk.domain.enums;

public enum Prioridade {

	BAIXA(0, "Prioridade Baixa"), MEDIA(1, "Prioridade Média"), ALTA(2, "Prioridade Alta");

	private Integer codigo;
	private String desccricao;

	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.desccricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDesccricao() {
		return desccricao;
	}

	public void setDesccricao(String desccricao) {
		this.desccricao = desccricao;
	}

	public static Prioridade toEnum(Prioridade cod) {
		if (cod == null)
			return null;

		for (Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}
}
