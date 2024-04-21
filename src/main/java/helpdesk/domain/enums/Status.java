package helpdesk.domain.enums;

public enum Status {
	ABERTO(0, "Chamado Aberto"), ANDAMENTO(1, "Chamado em andamento"), CANCELADO(2, "Chamado Cancelado"),
	ENCERRADO(3, "Chamado Encerrado");

	private Integer codigo;
	private String descricao;

	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Status toEnum(Status cod) {
		if (cod == null)
			return null;
		for (Status x : Status.values()) {
			if (cod.equals(x.getClass())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Status inválido");
	}
}
