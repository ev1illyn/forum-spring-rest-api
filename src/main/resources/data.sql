INSERT INTO USUARIO(nome, email, senha) VALUES('Evillyn', 'evillyndsoliveiras@email.com',
'$2a$10$OoFFi58VS6E2El2lUcUOzua4jN38M0xFFJaIM412VgZgnI/06eYtO');
INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com',
'$2a$10$ydr/Lwoy8m84Izr5y7H9VeKh.dBPTa6pvkYGpKWh7PnmkVrRgr9GW');

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('NodeJS', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');
INSERT INTO CURSO(nome, categoria) VALUES('Introdução ao Docker', 'DevOps');
INSERT INTO CURSO(nome, categoria) VALUES('Angular', 'Front-end');
INSERT INTO CURSO(nome, categoria) VALUES('React', 'Front-end');
INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ADMIN');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_ALUNO');
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2,2);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(
'Problemas de dependências', 'Erro ao criar projeto', '2020-03-01 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(
'Problemas de teste ao criar package', 'Projeto não compila', '2020-03-01 19:00:00', 'NAO_SOLUCIONADO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(
'Tag HTML não funciona', 'Tag HTML', '2020-03-01 20:00:00', 'NAO_SOLUCIONADO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(
'Projeto não roda', 'Conexão Recusada', '2020-03-01 21:00:00', 'NAO_SOLUCIONADO', 1, 1);