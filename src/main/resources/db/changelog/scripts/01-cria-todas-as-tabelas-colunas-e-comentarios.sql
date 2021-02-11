--- Inicio do script
CREATE TABLE public.conta (
conta_id bigint GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE ),
nome_usuario character varying(50) NOT NULL,
nome character varying(100) NOT NULL,
telefone character varying(15) NOT NULL,
cep character varying(10) NOT NULL,
email character varying(50) NOT NULL,
senha character varying(30) NOT NULL,
criado_em timestamp without time zone DEFAULT NOW(),
editado_em timestamp without time zone DEFAULT NOW(),
empreendedor boolean DEFAULT false,
admin_plataforma boolean DEFAULT false,
ativo boolean DEFAULT true,
CONSTRAINT conta_pk PRIMARY KEY (conta_id)
);
COMMENT ON TABLE conta IS 'Informacoes de todos os usuarios da plataforma';
COMMENT ON COLUMN conta.conta_id IS 'Numero de identificacao unica nesta tabela';
COMMENT ON COLUMN conta.nome_usuario IS 'Nome ou apelido de identificacao do usuario';
COMMENT ON COLUMN conta.nome IS 'Nome completo do usuario';
COMMENT ON COLUMN conta.telefone IS 'Telefone de contato do usuario';
COMMENT ON COLUMN conta.cep IS 'CEP do domicilio do usuario';
COMMENT ON COLUMN conta.email IS 'E-mail eletronico do usuario';
COMMENT ON COLUMN conta.senha IS 'Senha de login do usuario';
COMMENT ON COLUMN conta.criado_em IS 'Data e hora da criacao desse registro';
COMMENT ON COLUMN conta.editado_em IS 'Data e hora da ultima edicao feita nesse registro';
COMMENT ON COLUMN conta.empreendedor IS 'Informa se o usuario habilitou ou nao o perfil de empreendedor. Desligado por padrão';
COMMENT ON COLUMN conta.admin_plataforma IS 'Informa se o usuario e administrador da plataforma como um todo. Desligado por padrao';
COMMENT ON COLUMN conta.ativo IS 'Informa se a conta do usuario esta ativa na plataforma. Ligado por padrao';

CREATE TABLE public.comercio (
comercio_id bigint GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE ),
conta_id bigint NOT NULL,
nome_fantasia character varying(100) NOT NULL,
razao_social character varying(100) NOT NULL,
cnpj character varying(20) NOT NULL,
logradouro character varying(100) NOT NULL,
numero_e_complemento character varying(100) NOT NULL,
telefone character varying(15) NOT NULL,
cep character varying(10) NOT NULL,
bairro character varying(50) NOT NULL,
cidade character varying(50) NOT NULL,
hash_contrato_social character varying(50) NOT NULL,
criado_em timestamp without time zone DEFAULT NOW(),
editado_em timestamp without time zone DEFAULT NOW(),
comercio_vip boolean DEFAULT false,
ativo boolean DEFAULT true,
CONSTRAINT comercio_pk PRIMARY KEY (comercio_id),
CONSTRAINT conta_comercio_fk FOREIGN KEY (conta_id) REFERENCES conta(conta_id)
);
COMMENT ON TABLE comercio IS 'Informacoes dos empreendimentos dos usuarios';
COMMENT ON COLUMN comercio.comercio_id IS 'Numero de identificacao unica nesta tabela';
COMMENT ON COLUMN comercio.nome_fantasia IS 'Nome fantasia (comercial) do empreendimento';
COMMENT ON COLUMN comercio.razao_social IS 'Nome conforme consta no registro oficial do empreendimento';
COMMENT ON COLUMN comercio.cnpj IS 'CNPJ ativo do empreendimento';
COMMENT ON COLUMN comercio.logradouro IS 'Tipo (Rua, Avenida, etc) e nome do endereco do empreendimento';
COMMENT ON COLUMN comercio.numero_e_complemento IS 'Numero e complemento (Loja A, Casa B, etc.) do endereco do empreendimento';
COMMENT ON COLUMN comercio.telefone IS 'Telefone de contato do usuario';
COMMENT ON COLUMN comercio.cep IS 'CEP da regiao do empreendimento';
COMMENT ON COLUMN comercio.bairro IS 'Bairro onde se encontra o empreendimento';
COMMENT ON COLUMN comercio.cidade IS 'Cidade onde se encontra o empreendimento';
COMMENT ON COLUMN comercio.hash_contrato_social IS 'Chave aleatoria e unica do contrato social cadastrado para o empreendimento';
COMMENT ON COLUMN comercio.criado_em IS 'Data e hora da criacao desse registro';
COMMENT ON COLUMN comercio.editado_em IS 'Data e hora da ultima edicao feita nesse registro';
COMMENT ON COLUMN comercio.comercio_vip IS 'Informa se o empreendedor optou pelo plano Comercio VIP. Desligado por padrao';
COMMENT ON COLUMN comercio.ativo IS 'Informa se o registro do empreendimento esta ativo na plataforma. Ligado por padrao';

CREATE TABLE public.catalogo (
catalogo_id bigint GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE ),
comercio_id bigint NOT NULL,
produto boolean DEFAULT false,
categoria character varying(50) NOT NULL,
nome_descritivo character varying(100) NOT NULL,
marca character varying(50) DEFAULT 'Nao informado/Nao se aplica',
medida_usada character varying(20) DEFAULT 'Nao informado/Nao se aplica',
quantidade_medida numeric(7,3) DEFAULT 1,
preco numeric(7,2) NOT NULL,
criado_em timestamp without time zone DEFAULT NOW(),
editado_em timestamp without time zone DEFAULT NOW(),
item_vip boolean DEFAULT false,
ativo boolean DEFAULT true,
CONSTRAINT catalogo_pk PRIMARY KEY (catalogo_id),
CONSTRAINT comercio_catalogo_fk FOREIGN KEY (comercio_id) REFERENCES comercio(comercio_id)
);
COMMENT ON TABLE catalogo IS 'Itens/servicos cadastrados pelos empreendedores';
COMMENT ON COLUMN catalogo.catalogo_id IS 'Numero de identificacao unica nesta tabela';
COMMENT ON COLUMN catalogo.produto IS 'Informa se esse registro se refere a um produto. Se desligado, se refere apenas um servico. Desligado por padrao';
COMMENT ON COLUMN catalogo.categoria IS 'Categoria geral ao qual pertence o item/servico';
COMMENT ON COLUMN catalogo.nome_descritivo IS 'Descricao concisa e informativa sobre o item/servico';
COMMENT ON COLUMN catalogo.marca IS 'Marca comercial do item/servico';
COMMENT ON COLUMN catalogo.medida_usada IS 'Grandeza de medida (quilo, litro, unidade, hora, empreitada, etc.) utilizada nesse registro';
COMMENT ON COLUMN catalogo.quantidade_medida IS 'Quantia minima comercializada por cada grandeza de medida usada em medida_usada';
COMMENT ON COLUMN catalogo.preco IS 'Preco referente a quantidade_medida minima informada do item/servico';
COMMENT ON COLUMN catalogo.criado_em IS 'Data e hora da criacao desse registro';
COMMENT ON COLUMN catalogo.editado_em IS 'Data e hora da ultima edicao feita nesse registro';
COMMENT ON COLUMN catalogo.item_vip IS 'Informa se o empreendedor optou pelo plano Item/Servico VIP. Desligado por padrao';
COMMENT ON COLUMN catalogo.ativo IS 'Informa se o registro do item esta ativo na plataforma. Ligado por padrao';

CREATE TABLE public.avaliacao_comercio (
avaliacao_comercio_id bigint GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE ),
conta_id bigint NOT NULL,
comercio_id bigint NOT NULL,
nota numeric(4,2) NOT NULL,
CONSTRAINT avaliacao_comercio_pk PRIMARY KEY (avaliacao_comercio_id),
CONSTRAINT conta_avaliacao_comercio_fk FOREIGN KEY (conta_id) REFERENCES conta(conta_id),
CONSTRAINT comercio_avaliacao_comercio_fk FOREIGN KEY (comercio_id) REFERENCES comercio(comercio_id)
);
COMMENT ON TABLE avaliacao_comercio IS 'Avaliacao dos empreendimentos pelos usuarios';
COMMENT ON COLUMN avaliacao_comercio.avaliacao_comercio_id IS 'Numero de identificacao unica nesta tabela';
COMMENT ON COLUMN avaliacao_comercio.nota IS 'Qualifica dada ao empreendimento pelo usuario';

CREATE TABLE public.promocao (
promocao_id bigint GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE ),
catalogo_id bigint NOT NULL,
preco_promocional numeric(7,2) NOT NULL,
data_inicio character varying(15) NOT NULL,
data_fim character varying(15) NOT NULL,
criado_em timestamp without time zone DEFAULT NOW(),
editado_em timestamp without time zone DEFAULT NOW(),
ativo boolean NOT NULL true,
CONSTRAINT promocao_pk PRIMARY KEY (promocao_id),
CONSTRAINT catalogo_promocao_fk FOREIGN KEY (catalogo_id) REFERENCES catalogo(catalogo_id)
);
COMMENT ON TABLE promocao IS 'Precos temporarios de itens do catalogo';
COMMENT ON COLUMN promocao.promocao_id IS 'Numero de identificacao unica nesta tabela';
COMMENT ON COLUMN promocao.preco_promocional IS 'Preco promocional referente a quantidade_medida minima informada do item/servico';
COMMENT ON COLUMN promocao.data_inicio IS 'Data e horario em que se inicia a promocao';
COMMENT ON COLUMN promocao.data_fim IS 'Data e horario em que termina a promocao se ainda houver estoque';
COMMENT ON COLUMN promocao.criado_em IS 'Data e hora da criacao desse registro';
COMMENT ON COLUMN promocao.editado_em IS 'Data e hora da ultima edicao feita nesse registro';
COMMENT ON COLUMN promocao.ativo IS 'Informa se o registro desta promocao esta ativo na plataforma. Ligado por padrao';

CREATE TABLE public.reporte (
reporte_id bigint GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE ),
conta_id bigint NOT NULL,
comercio_id bigint NOT NULL,
data_abertura character varying(15) NOT NULL,
catalogo boolean DEFAULT false,
promocao boolean DEFAULT false,
detalhes character varying(4000) NOT NULL,
criado_em timestamp without time zone DEFAULT NOW(),
editado_em timestamp without time zone DEFAULT NOW(),
data_conclusao character varying(15) DEFAULT 'Reporte em analise',
resolucao character varying(4000) DEFAULT 'Reporte em analise',
ativo boolean DEFAULT true,
CONSTRAINT reporte_pk PRIMARY KEY (reporte_id),
CONSTRAINT conta_reporte_fk FOREIGN KEY (conta_id) REFERENCES conta(conta_id),
CONSTRAINT comercio_reporte_fk FOREIGN KEY (comercio_id) REFERENCES comercio(comercio_id)
);
COMMENT ON TABLE reporte IS 'Denuncias ou elogios feitos pelos usuarios da plataforma';
COMMENT ON COLUMN reporte.reporte_id IS 'Numero de identificacao unica nesta tabela';
COMMENT ON COLUMN reporte.data_abertura IS 'Data e hora da abertura do reporte na plataforma';
COMMENT ON COLUMN reporte.catalogo IS 'Informa se o reporte sera sobre um item do catalogo';
COMMENT ON COLUMN reporte.promocao IS 'Informa se o reporte sera sobre uma promocao anunciada';
COMMENT ON COLUMN reporte.detalhes IS 'Detalhes sobre o que levou o usuario a abrir esse reporte';
COMMENT ON COLUMN reporte.criado_em IS 'Data e hora da criacao desse registro';
COMMENT ON COLUMN reporte.editado_em IS 'Data e hora da ultima edicao feita nesse registro';
COMMENT ON COLUMN reporte.data_conclusao IS 'Data e hora da conclusao do reporte, informada pelos administradores da plataforma';
COMMENT ON COLUMN reporte.resolucao IS 'Detalhes informados pelos administradores da plataforma sobre a resolucao do reporte';
COMMENT ON COLUMN reporte.ativo IS 'Informa se o registro desse reporte ainda esta em tratativa. Ligado por padrao';
-- Fim do script
