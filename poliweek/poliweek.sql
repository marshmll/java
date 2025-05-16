DROP DATABASE IF EXISTS poliweek_db;
CREATE DATABASE IF NOT EXISTS poliweek_db;
USE poliweek_db;

CREATE TABLE `usuario` (
`id_usuario` int NOT NULL AUTO_INCREMENT,
`nome` varchar(100) NOT NULL,
`email` varchar(100) NOT NULL,
`curso` varchar(100) NOT NULL,
`senha` varchar(100) NOT NULL,
`nivel_acesso` int NOT NULL,
`confirmacao` tinyint(1) NOT NULL,
`token_confirmacao` int NOT NULL,
`token_recuperacao` int DEFAULT NULL,
`data_hora` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `evento` (
`id_evento` int NOT NULL AUTO_INCREMENT,
`tipo` int NOT NULL,
`curso` varchar(150) NOT NULL,
`titulo` varchar(1000) NOT NULL,
`descricao` varchar(2000) NOT NULL,
`dia_semana` varchar(10) NOT NULL,
`inicio` varchar(10) NOT NULL,
`termino` varchar(10) NOT NULL,
`turno` varchar(10) NOT NULL,
`palestrante` varchar(300) NOT NULL,
`publico` int NOT NULL,
`localizacao` varchar(1000) NOT NULL,
`vagas` int NOT NULL,
`software_equipamento` varchar(1000) NOT NULL,
`data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id_evento`)
);

CREATE TABLE `usuario_evento` (
`id_usuario_evento` int NOT NULL AUTO_INCREMENT,
`id_usuario` int NOT NULL,
`id_evento` int NOT NULL,
`checkin` int NOT NULL,
`data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id_usuario_evento`)
);

INSERT INTO `usuario` (`nome`, `email`, `curso`, `senha`, `nivel_acesso`, `confirmacao`, `token_confirmacao`, `token_recuperacao`) VALUES
('João Silva', 'joao.silva@email.com', 'Engenharia Civil', 'senha123', 1, 1, 123456, NULL),
('Maria Oliveira', 'maria.oliveira@email.com', 'Ciência da Computação', 'abc123', 1, 1, 234567, NULL),
('Carlos Pereira', 'carlos.pereira@email.com', 'Administração', 'admin123', 2, 1, 345678, NULL),
('Ana Santos', 'ana.santos@email.com', 'Engenharia Elétrica', 'eletrica123', 1, 1, 456789, NULL),
('Pedro Costa', 'pedro.costa@email.com', 'Medicina', 'med123', 1, 0, 567890, 987654),
('Juliana Almeida', 'juliana.almeida@email.com', 'Direito', 'direito123', 1, 1, 678901, NULL),
('Marcos Souza', 'marcos.souza@email.com', 'Arquitetura', 'arquiteto123', 2, 1, 789012, NULL),
('Fernanda Lima', 'fernanda.lima@email.com', 'Psicologia', 'psi123', 1, 0, 890123, 876543),
('Ricardo Martins', 'ricardo.martins@email.com', 'Engenharia Mecânica', 'mecanica123', 1, 1, 901234, NULL),
('Patrícia Rocha', 'patricia.rocha@email.com', 'Enfermagem', 'enfermagem123', 1, 1, 012345, NULL);

INSERT INTO `evento` (`tipo`, `curso`, `titulo`, `descricao`, `dia_semana`, `inicio`, `termino`, `turno`, `palestrante`, `publico`, `localizacao`, `vagas`, `software_equipamento`, `data_hora`) VALUES
(1, 'Ciência da Computação', 'Introdução à Inteligência Artificial', 'Workshop sobre conceitos básicos de IA e machine learning', 'Segunda', '09:00', '12:00', 'Manhã', 'Dr. Roberto Almeida', 100, 'Auditório Central', 50, 'Python, Jupyter Notebook', '2025-03-10 09:00:00'),
(2, 'Engenharia Civil', 'Técnicas de Construção Sustentável', 'Palestra sobre métodos eco-friendly na construção civil', 'Terça', '14:00', '16:00', 'Tarde', 'Eng. Carla Mendes', 200, 'Bloco B - Sala 205', 80, 'Projetor, Microfone', '2024-11-19 14:00:00'),
(3, 'Administração', 'Gestão de Startups', 'Workshop interativo sobre empreendedorismo', 'Quarta', '19:00', '22:00', 'Noite', 'Prof. Marcelo Costa', 50, 'Sala de Eventos - Bloco A', 30, 'Quadro branco, Marcadores', '2026-02-04 19:00:00'),
(1, 'Engenharia Elétrica', 'Energias Renováveis', 'Discussão sobre o futuro da geração de energia', 'Quinta', '10:00', '12:00', 'Manhã', 'Dra. Silvia Ramos', 150, 'Auditório de Engenharia', 60, 'Projetor, Slides', '2024-09-12 10:00:00'),
(2, 'Medicina', 'Avancos em Neurociência', 'Palestra sobre as últimas descobertas no cérebro humano', 'Sexta', '16:00', '18:00', 'Tarde', 'Dr. Felipe Oliveira', 120, 'Anfiteatro de Medicina', 40, 'Microscópios, Slides', '2025-07-25 16:00:00'),
(3, 'Direito', 'Direito Digital', 'Workshop sobre legislação aplicada à internet', 'Segunda', '13:00', '15:00', 'Tarde', 'Dra. Vanessa Torres', 80, 'Sala 301 - Bloco Jurídico', 25, 'Computadores', '2026-01-06 13:00:00'),
(1, 'Arquitetura', 'Design Urbano Sustentável', 'Apresentação de cases internacionais', 'Terça', '08:00', '10:00', 'Manhã', 'Arq. Tiago Nunes', 90, 'Sala de Projeção - FAU', 35, 'Maquetes, Projetor 3D', '2024-08-13 08:00:00'),
(2, 'Psicologia', 'Saúde Mental no Ambiente Acadêmico', 'Discussão aberta sobre desafios psicológicos', 'Quarta', '17:00', '19:00', 'Noite', 'Dra. Luciana Freitas', 60, 'Sala de Grupos - Psicologia', 20, 'Nenhum', '2025-05-21 17:00:00'),
(3, 'Engenharia Mecânica', 'Fabricação Aditiva', 'Workshop prático de impressão 3D industrial', 'Quinta', '14:00', '17:00', 'Tarde', 'Eng. Rafael Soares', 40, 'Laboratório de Prototipagem', 15, 'Impressoras 3D, Software CAD', '2026-03-13 14:00:00'),
(1, 'Enfermagem', 'Primeiros Socorros Avançados', 'Treinamento prático para situações de emergência', 'Sexta', '09:00', '13:00', 'Manhã', 'Enf. Roberta Campos', 30, 'Laboratório de Simulação', 10, 'Bonecos de treinamento, Equipamentos médicos', '2024-12-06 09:00:00');
INSERT INTO `usuario_evento` (`id_usuario`, `id_evento`, `checkin`) VALUES
(1, 2, 1),
(2, 1, 1),
(3, 3, 0),
(4, 4, 1),
(5, 5, 0),
(6, 6, 1),
(7, 7, 1),
(8, 8, 0),
(9, 9, 1),
(10, 10, 1);

SELECT * FROM evento WHERE data_hora BETWEEN '2024-12-31' AND '2026-01-01';