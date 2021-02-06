-- Importa o banco de dados para o servidor Postgres da sua maquina com o usuario "postgres"
>> psql -U postgres tcc_do_entra21_2020_equipe_abcd < banco_de_dados.pgsql

-- Conecta ao banco de dados com o usuario "postgres" na linha de comando (nao rode como script)
>> psql -U postgres -d tcc_do_entra21_2020_equipe_abcd


-- Caso desejar criar um usuario "tcc" com acesso de leitura e escrita ao banco de dados, pode-se usar os procedimentos abaixo
-- Início
-- Cria o usuario "tcc" no PostgreSQL na linha de comando (nao rode como script)
>> createuser -U postegres tcc

-- Conecta ao banco de dados com o usuario "tcc" na linha de comando (nao rode como script)
>> psql -U postgres -d tcc_do_entra21_2020_equipe_abcd

-- Configura a senha do usuario "tcc"
ALTER USER tcc with ENCRYPTED PASSWORD 'e2120abcd';

-- Reseta as permissoes de acesso ao banco de dados
REVOKE ALL ON DATABASE tcc_do_entra21_2020_equipe_abcd FROM PUBLIC;
REVOKE CREATE ON SCHEMA public FROM PUBLIC;

-- Cria e configura role de acesso ao banco de dados com permissoes para leitura e escrita
CREATE ROLE readwrite;
GRANT CONNECT ON DATABASE tcc_do_entra21_2020_equipe_abcd TO readwrite;
GRANT USAGE,CREATE ON SCHEMA public TO readwrite;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO readwrite;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO readwrite;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public TO readwrite;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE ON SEQUENCES TO readwrite;

-- Configura usuario "tcc" com role com permissoes de leituta e escrita
GRANT readwrite TO tcc;

-- Havendo necessidade, pode-se criar um role com acesso somente-leitura
-- CREATE ROLE readonly;
-- GRANT CONNECT ON DATABASE tcc_do_entra21_2020_equipe_abcd TO readonly;
-- GRANT USAGE ON SCHEMA public TO readonly;
-- GRANT SELECT ON ALL TABLES IN SCHEMA public TO readonly;
-- ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO readonly;

-- Havendo necessidade, pode-se revogar as permissoes do usuario
-- REVOKE readwrite FROM tcc;

-- Ou simplesmente alterar o nivel de permissao dele
-- GRANT readonly TO tcc;

-- Para trocar o nome
-- ALTER USER tcc TO <novo_nome>;

-- Para trocar a senha
-- ALTER USER tcc WITH ENCRYPTED PASSWORD '<nova_senha>';
-- Fim