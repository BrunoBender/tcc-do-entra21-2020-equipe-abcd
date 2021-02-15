package tcc.common;

public class Constante {
	public static final String DIRETORIO_BASE = "/api";
	public static final String ACAO_HTTP_GET = "/busca";
	public static final String ACAO_HTTP_POST = "/cria";
	public static final String ACAO_HTTP_PUT = "/atualiza-todos-campos";
	public static final String ACAO_HTTP_PATCH = "/atualiza";
	public static final String ACAO_HTTP_DELETE = "/remove";

	public static final String DIRETORIO_DA_CONTA = Constante.DIRETORIO_BASE + "/contas";
	public static final String DIRETORIO_DO_COMERCIO = Constante.DIRETORIO_BASE + "/comercios";
	public static final String DIRETORIO_DO_ITEM_DO_CATALOGO = Constante.DIRETORIO_BASE + "/itens";
	public static final String DIRETORIO_DA_AVALIACAO = Constante.DIRETORIO_BASE + "/avaliacoes";
	public static final String DIRETORIO_DA_PROMOCAO = Constante.DIRETORIO_BASE + "/promocoes";
	public static final String DIRETORIO_DO_REPORTE = Constante.DIRETORIO_BASE + "/reportes";

	public static final String DIRETORIO_DA_VARIAVEL_ID = "/{id}";
}
