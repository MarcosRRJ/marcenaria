CREATE TABLE pessoa(
id NUMBER(10),
nome VARCHAR(100) NOT NULL,
dataNasc DATE,
CONSTRAINT pk_id_pesso PRIMARY KEY (id)
);

CREATE SEQUENCE pessoa_seq;

CREATE TABLE email(
id_email NUMBER(10),
email VARCHAR(100),
id_pessoa NUMBER(10),
CONSTRAINT uk_email UNIQUE(email),
CONSTRAINT pk_id_email PRIMARY KEY (id_email),
CONSTRAINT fk_email_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);

CREATE SEQUENCE email_seq;


CREATE TABLE documento(
id_documento NUMBER(10),
numero VARCHAR(50) NOT NULL,
descricao VARCHAR(50) NOT NULL,
id_pessoa NUMBER(10),
CONSTRAINT uk_documento_numero UNIQUE(numero),
CONSTRAINT pk_id_documento PRIMARY KEY (id_documento),
CONSTRAINT fk_doc_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);
CREATE SEQUENCE documento_seq;


CREATE TABLE endereco(
id_endereco NUMBER(10),
pais VARCHAR(150) NOT NULL,
estado VARCHAR(150) NOT NULL,
cidade VARCHAR(150) NOT NULL,
bairro VARCHAR(150) NOT NULL,
logradouro VARCHAR(550) NOT NULL,
cep VARCHAR(50) NOT NULL,
complemento VARCHAR(50) NOT NULL,
id_pessoa NUMBER(10),
CONSTRAINT pk_id_endereco PRIMARY KEY (id_endereco),
CONSTRAINT fk_end_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);
CREATE SEQUENCE endereco_seq;


CREATE TABLE telefone(
id_telefone NUMBER(10),
numero VARCHAR(50) NOT NULL,
descricao VARCHAR(50) NOT NULL,
id_pessoa NUMBER(10),
CONSTRAINT uk_telefone_numero UNIQUE(numero),
CONSTRAINT pk_id_telefone PRIMARY KEY (id_telefone),
CONSTRAINT fk_tel_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);
CREATE SEQUENCE telefone_seq;


CREATE TABLE perfil(
id_perfil NUMBER(10),
descricao VARCHAR(100),
CONSTRAINT pk_id_perfil PRIMARY KEY (id_perfil)
);
CREATE SEQUENCE perfil_seq;


CREATE TABLE cliente(
id_cliente NUMBER(10),
login VARCHAR(500) NOT NULL,
senha VARCHAR(100) NOT NULL,
data_cadastro DATE,
status VARCHAR(50) CHECK (status IN ('Ativo','Inativo')),
id_pessoa NUMBER(10),
id_perfil NUMBER(10),
CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente),
CONSTRAINT fk_cli_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
CONSTRAINT fk_cli_id_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil)
);
CREATE SEQUENCE cliente_seq;


CREATE TABLE funcionario(
id_funcionario NUMBER(10),
login VARCHAR(500) NOT NULL,
senha VARCHAR(100) NOT NULL,
data_admissao DATE,
data_demissao DATE,
status VARCHAR(50) CHECK (status IN ('Ativo','Inativo')),
id_pessoa NUMBER(10),
id_perfil NUMBER(10),
id_departamento NUMBER(10),
CONSTRAINT pk_id_funcionario PRIMARY KEY (id_funcionario),
CONSTRAINT fk_fun_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
CONSTRAINT fk_fun_id_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil),
CONSTRAINT fk_fun_id_depart FOREIGN KEY (id_departamento) REFERENCES departamento (id_departamento)
);

CREATE SEQUENCE Funcionario_seq;


CREATE TABLE departamento(
id_departamento NUMBER(10),
numero_de_serie NUMBER(10),
descricao VARCHAR(50) NOT NULL,
CONSTRAINT uk_departamento_numero UNIQUE(numero_de_serie),
CONSTRAINT pk_id_departamento PRIMARY KEY (id_departamento)
);
CREATE SEQUENCE departamento_seq;
CREATE SEQUENCE depart_num_serie_seq
START WITH 50
INCREMENT BY 50
;


INSERT INTO perfil VALUES(1, 'Cliente');
INSERT INTO perfil VALUES(2, 'Funcionario');



