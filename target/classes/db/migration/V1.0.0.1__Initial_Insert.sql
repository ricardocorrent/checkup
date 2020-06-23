------------------------------ INSERT USERS
INSERT INTO "user" (
	id, user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, created_at, updated_at)
VALUES
    ('42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', 'ricardo', 'Ricardo Corrent', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', true, true, true, true, now(), now()),
    ('cbe9b30d-b921-4f4b-b8f2-4b801b8ae417', 'admin', 'Sys admin', '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', true, true, true, true, now(), now());


------------------------------ PERMISSION
INSERT INTO permission (id, description) VALUES
('451f92ea-7d17-4e97-adab-75e7e3ed1429', 'ADMIN');

INSERT INTO permission (id, description) VALUES
('49ae8c60-9769-4e86-981c-18919933c325', 'MANAGER');

INSERT INTO permission (id, description) VALUES
('1066c973-dbcd-483a-8fe7-30231f805a48', 'COMMONS');


------------------------------ INSERT USER PERMISSION
INSERT INTO user_permission (user_id, permission_id) VALUES
	('42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', '451f92ea-7d17-4e97-adab-75e7e3ed1429'),
	('cbe9b30d-b921-4f4b-b8f2-4b801b8ae417', '49ae8c60-9769-4e86-981c-18919933c325'),
	('42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', '1066c973-dbcd-483a-8fe7-30231f805a48');


------------------------------ INSERT USER INFORMATION
-- USER ricardo
INSERT INTO user_information (id, user_id, title, description, position_index, active, created_at, updated_at) VALUES
	('c3cd50c4-7ea3-431e-a545-fbf0398a52e2', '42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', 'CPF', '587.877.789-47', 0, true, now(), now()),
	('43a0bd64-6a01-4a19-897d-29a28bb3c70f', '42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', 'CNH', '27015151713', 1, true, now(), now()),
	('70ce893b-d642-4dc8-bd24-2cf4906082ac', '42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', 'RG', '31.620.969-7', 2, true, now(), now()),
	('9f701fe2-f7aa-48c2-bccc-4c6b7e9d3d98', '42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', 'Data de nascimento', '22/05/1585', 3, true, now(), now()),
	('78008c0b-96f1-4135-8028-b1b30f9b4d29', '42bad0ad-e7f2-4cfb-b9f5-66cfc2b6c5ad', 'PIS', '180.65257.85-8', 4, true, now(), now());

------------------------------ INSERT TARGET
INSERT INTO target (id, "name", active, created_at, updated_at) VALUES
	('0289e7e0-fb15-446f-9e54-a28148e1c943', 'Bárbara e Raimundo Telas Ltda', true, now(), now()),
	('352fd491-7cf4-4cab-852a-7adf28de3804', 'Juan e Maya Esportes Ltda', true, now(), now()),
	('d161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Arthur e Murilo Pães e Doces Ltda', true, now(), now()),
	('ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Martin e Sebastiana Alimentos ME', true, now(), now()),
	('f394ed16-ce91-404b-baac-92c80dd1b3b6', 'Ana e Luciana Doces & Salgados ME', true, now(), now());


------------------------------ INSERT TARGET INFORMATION
-- TARGET BÁRBARA E RAIMUNDO TELAS LTDA
INSERT INTO target_information (id, target_id, title, description, position_index, active, created_at, updated_at) VALUES
	('a24274c4-a4f4-4b07-8ead-87be31a6d971', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'CNPJ', '51.757.992/0001-37', 0, true, now(), now()),
	('b7b7b321-092d-4dd9-b363-675ceead33ef', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Inscrição Estadual', '316.46056-97', 1, true, now(), now()),
	('a1ead20d-e32e-44a2-8bbe-a6c422817319', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Data de abertura', '22/05/2015', 2, true, now(), now()),
	('f3f13b86-9094-4f92-b496-22285830fc47', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Site', 'www.barbaraeraimundotelasltda.com.br', 3, true, now(), now()),
	('621ff388-25d3-484a-8859-daab97df3f3c', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'CEP', '87114-533', 4, true, now(), now()),
	('61794140-d4d3-40e9-afa5-03072adea4f4', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Endereço', 'Rua das Profecias, 251', 5, true, now(), now()),
	('7c14bdac-7b05-4cc0-86f6-a3d0712ec2b1', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Bairro', 'Parque Residencial Bom Pastor', 6, true, now(), now()),
	('c7721ff0-2b5d-4e0b-be66-573aa49d9b24', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Cidade', 'Sarandi', 7, true, now(), now()),
	('e0b5897d-1f62-401d-b16e-5332a14b2186', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Telefone', '(44) 2793-3025', 8, true, now(), now()),
	('1c2dbd37-6da6-47db-918f-2c167bf571a9', '0289e7e0-fb15-446f-9e54-a28148e1c943', 'Responsável', 'Marcos Assunção', 9, true, now(), now());
-- TARGET JUAN E MAYA ESPORTES LTDA
INSERT INTO target_information (id, target_id, title, description, position_index, active, created_at, updated_at) VALUES
	('cda7bbf7-4d2d-4b76-87ff-d8b0f8ded67b', '352fd491-7cf4-4cab-852a-7adf28de3804', 'Endereço', 'Rua Sílvio Romero', 0, true, now(), now()),
	('046ddd3a-5ae4-4748-8afb-ea5a85be8727', '352fd491-7cf4-4cab-852a-7adf28de3804', 'Número', '997', 1, true, now(), now()),
	('5c1d8272-3afd-45ec-b523-597ddb3d3aa5', '352fd491-7cf4-4cab-852a-7adf28de3804', 'CEP', '85865-290', 2, true, now(), now()),
	('530d27b2-36b5-411c-93d8-f80cd2cbaebb', '352fd491-7cf4-4cab-852a-7adf28de3804', 'Cidade', 'Foz do Iguaçu', 3, true, now(), now()),
	('d31b69e1-1924-477c-a548-d9b5baf57d21', '352fd491-7cf4-4cab-852a-7adf28de3804', 'Telefone', '(45) 3992-0268', 4, true, now(), now()),
	('d0cfe576-6c8f-4493-83cb-eee98e6bf4d1', '352fd491-7cf4-4cab-852a-7adf28de3804', 'CNPJ', '57.989.340/0001-04', 5, true, now(), now()),
	('9277ee20-9ec5-4a48-82bc-1f1e2a27e34e', '352fd491-7cf4-4cab-852a-7adf28de3804', 'Responsável', 'Paulo Ricardo de Mattos', 6, true, now(), now()),
	('8cf40bbe-6c1e-4943-910a-2901571746b0', '352fd491-7cf4-4cab-852a-7adf28de3804', 'Celular gerente', '(45) 98253-0564', 7, true, now(), now());
-- TARGET ARTHUR E MURILO PÃES E DOCES LTDA
INSERT INTO target_information (id, target_id, title, description, position_index, active, created_at, updated_at) VALUES
	('d9147fd4-3929-40c5-a3a5-bd5abfcef819', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'CNPJ', '69.775.031/0001-10', 0, true, now(), now()),
	('7ce96b72-857b-4978-9367-021948afb2c0', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Inscrição Estadual', '398.81962-49', 1, true, now(), now()),
	('500394d0-ceb1-4dfc-a6af-2d678c25613f', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Data de Abertura', '24/01/2015', 2, true, now(), now()),
	('02976d3b-ed52-4858-8047-6b6b6c7a9d6a', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Número de funcionários', '8', 3, true, now(), now()),
	('cfc5c9ab-90b8-44d0-81bc-342ed78e0fee', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'CEP', '84043-100', 4, true, now(), now()),
	('44ed3ad1-e652-4599-ab18-680c3add0980', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Endereço', 'Rua Jerônimo Stephano Sikorski', 5, true, now(), now()),
	('6a4ab44b-470c-4d8a-9bc9-3e1f833b382b', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Número', '776', 6, true, now(), now()),
	('93ba9565-25e7-4c05-896b-24bf7a2f28d0', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Bairro', 'Colônia Dona Luíza', 7, true, now(), now()),
	('2339ba27-974e-4840-9556-df66264bd043', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Cidade', 'Ponta Grossa', 8, true, now(), now()),
	('12112742-3e59-44db-9c7f-1301c25882f3', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Telefone', '(42) 2503-7511', 9, true, now(), now()),
	('0af4bc5b-b739-4647-889a-64ae2ad196f2', 'd161c75f-6c7c-407a-b2bd-99dd96162fd6', 'Celular', '(42) 99816-5669', 10, true, now(), now());
-- TARGET MARTIN E SEBASTIANA ALIMENTOS ME
INSERT INTO target_information (id, target_id, title, description, position_index, active, created_at, updated_at) VALUES
	('ec82c1b9-1875-43a4-bb52-b619941edc76', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'CNPJ', '65.988.737/0001-00', 0, true, now(), now()),
	('ee7a8b78-8cfe-4864-a7d1-c972f2bec50e', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Inscrição Estadual', '425.98609-09', 1, true, now(), now()),
	('a9609f35-79f0-4d25-becb-a5cf3f57953e', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Endereço', 'Rua Miguel Losso, 952', 2, true, now(), now()),
	('85fbbc01-5d12-4869-8cf4-913e439c9779', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Bairro', 'Sítio Cercado', 3, true, now(), now()),
	('926d1ef9-b22a-4df9-bb80-3d8b9c807dfc', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Funcionários', '35', 6, true, now(), now()),
	('61a458ef-da74-46e4-a5b2-42c0cac0de09', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Cidade', 'Curitiba', 4, true, now(), now()),
	('0636beda-ecc5-4b1e-b442-3e59776ac902', 'ca278ff3-7533-42d0-8456-56f1fd58acc4', 'Telefone', '(41) 2787-2190', 5, true, now(), now());
-- TARGET ANA E LUCIANA DOCES & SALGADOS ME
INSERT INTO target_information (id, target_id, title, description, position_index, active, created_at, updated_at) VALUES
	('66fcf4b0-3507-4beb-a76e-0f75a0e2efe0', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'CNPJ', '51.581.657/0001-20', 0, true, now(), now()),
	('04270aa0-4ecd-4f99-a57f-c5115773787a', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'Site', 'www.anaelucianadocessalgadosme.com.br', 1, true, now(), now()),
	('00a8a783-07c7-4ef2-acfa-7a69a9aeaa99', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'E-Mail', 'suporte@anaelucianadocessalgadosme.com.br', 2, true, now(), now()),
	('edcc2c7b-9307-4182-9426-f497775913da', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'Endereço', 'Rua Aleixo Thomas, 265', 3, true, now(), now()),
	('2068171b-8ed7-4891-bbdb-4528065c080b', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'Bairro', 'Vila Bela', 4, true, now(), now()),
	('dd855a3d-8b7b-4b90-92d3-f759fb99fedd', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'Telefone', '(42) 98548-3558', 5, true, now(), now()),
	('a794f323-24ce-4630-b76a-0543689ad0ec', 'f394ed16-ce91-404b-baac-92c80dd1b3b6', 'Dona', 'Ana Maria da Silva', 6, true, now(), now());


------------------------------ INSERT RULE
INSERT INTO "rule" (id, title, description, active, created_at, updated_at) VALUES
	('00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', 'NR-12', null, true, now(), now()),
	('7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'CLT', 'Consolidação das Leis do Trabalho', true, now(), now()),
	('dc4ccc56-0532-4393-a34b-399b3a2d01f0', 'NR-05', 'Norma Reguladora que trata de fornos e fogões', true, now(), now());

------------------------------ INSERT RULE INFORMATION
-- RULE NR-12
INSERT INTO rule_information (id, rule_id, title, description, position_index, active, created_at, updated_at) VALUES
	('3e3d5910-cbdb-411d-a4f4-9310949994cf', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', 'NORMA REGULAMENTADORA 12 - NR 12', 'SEGURANÇA NO TRABALHO EM MÁQUINAS E EQUIPAMENTOS', 0, true, now(), now());
-- RULE CLT
INSERT INTO rule_information (id, rule_id, title, description, position_index, active, created_at, updated_at) VALUES
	('c5560394-f58b-4cd3-a588-7859a3063edd', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Origem', 'DECRETO-LEI Nº 5.452, DE 1º DE MAIO DE 1943', 0, true, now(), now());
-- RULE NR-05
INSERT INTO rule_information (id, rule_id, title, description, position_index, active, created_at, updated_at) VALUES
	('aebf15d0-bdc7-424e-94d9-01e692b9b683', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', 'NORMA REGULAMENTADORA 5 - NR 5', 'COMISSÃO INTERNA DE PREVENÇÃO DE ACIDENTES - CIPA', 0, true, now(), now());

------------------------------ INSERT ITEM
-- ITEM FROM NR-12 RULE
INSERT INTO item (id, rule_id, title, description, position_index, active, created_at, updated_at) VALUES
	('a1e05cec-ad23-4e91-83f6-8745d078a2cf', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.3.', 'O empregador deve adotar medidas de proteção para o trabalho em máquinas e equipamentos, capazes de garantir a saúde e a integridade física dos trabalhadores, e medidas apropriadas sempre que houver pessoas com deficiência envolvidas direta ou indiretamente no trabalho.', 0, true, now(), now()),
	('a90f5ca5-8309-49fd-87f6-9360fbbbb8d4', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.6.', 'Nos locais de instalação de máquinas e equipamentos, as áreas de circulação devem ser devidamente demarcadas e em conformidade com as normas técnicas oficiais.', 1, true, now(), now()),
	('f75f90ea-256c-4e0c-ac16-7a81685a362a', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.6.2.', 'As áreas de circulação devem ser mantidas permanentemente desobstruídas.', 2, true, now(), now()),
	('a49a6705-50c4-4672-ab08-1e400a5d93ac', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.8.1.', 'A distância mínima entre máquinas, em conformidade com suas características e aplicações, deve garantir a segurança dos trabalhadores durante sua operação, manutenção, ajuste, limpeza e inspeção, e permitir a movimentação dos segmentos corporais, em face da natureza da tarefa.', 3, true, now(), now()),
	('2058570a-b873-4505-bcca-d4424b271725', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.12.', 'Nas máquinas móveis que possuem rodízios, pelo menos dois deles devem possuir travas.', 4, true, now(), now()),
	('52269a2f-3d07-4922-800e-650fdead8d6d', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.20.1.', 'As máquinas e equipamentos devem possuir dispositivo protetor contra sobretensão quando a elevação da tensão puder ocasionar risco de acidentes.', 5, true, now(), now()),
	('ad6a42e0-869d-4e71-91f4-6afb686f4aad', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.30.', 'Nas máquinas e equipamentos cuja operação requeira a participação de mais de uma pessoa, o número de dispositivos de acionamento bimanual simultâneos deve corresponder ao número de operadores expostos aos perigos decorrentes de seu acionamento, de modo que o nível de proteção seja o mesmo para cada trabalhador.', 6, true, now(), now()),
	('4f7cf5ce-ec3c-4f25-a64d-464519604ca8', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.40.1.', 'Depois que um comando de parada tiver sido iniciado pelo sistema de segurança, a condição de parada deve ser mantida até que existam condições seguras para o rearme. (Inserido pela Portaria MTPS 509/2016)', 7, true, now(), now()),
	('a0a0b9fc-bb72-466e-8dff-609a7aeabb9d', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.41.', 'Para fins de aplicação desta Norma, considera-se proteção o elemento especificamente utilizado para prover segurança por meio de barreira física, podendo ser:', 8, true, now(), now()),
	('3f3af6b2-92d7-4480-9ce6-0f1dd02046e7', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.56.', 'As máquinas devem ser equipadas com um ou mais dispositivos de parada de emergência, por meio dos quais possam ser evitadas situações de perigo latentes e existentes.', 9, true, now(), now()),
	('8d34a7f9-eaeb-4beb-aafd-d8bc87b439be', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.56.1.', 'Os dispositivos de parada de emergência não devem ser utilizados como dispositivos de partida ou de acionamento.', 10, true, now(), now()),
	('3168c6fa-8d02-4fd8-a0dd-de4e7778ee37', '00c278b1-b6bf-4ca6-a275-9f43b60b4ddb', '12.57.', 'Os dispositivos de parada de emergência devem ser posicionados em locais de fácil acesso e visualização pelos operadores em seus postos de trabalho e por outras pessoas, e mantidos permanentemente desobstruídos.', 11, true, now(), now());
-- ITEM FROM CLT RULE
INSERT INTO item (id, rule_id, title, description, position_index, active, created_at, updated_at) VALUES
	('010be314-8dda-4a66-889a-b79221d701d2', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 3º.', 'Considera-se empregado toda pessoa física que prestar serviços de natureza não eventual a empregador, sob a dependência deste e mediante salário.', 0, true, now(), now()),
	('4785e103-5745-4c28-8b6d-f82c12151916', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 4º.', 'Considera-se como de serviço efetivo o período em que o empregado esteja à disposição do empregador, aguardando ou executando ordens, salvo disposição especial expressamente consignada.', 1, true, now(), now()),
	('f2967600-b92b-4cc8-a325-c5784bdd3523', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 13.', 'A Carteira de Trabalho e Previdência Social é obrigatória para o exercício de qualquer emprego, inclusive de natureza rural, ainda que em caráter temporário, e para o exercício por conta própria de atividade profissional remunerada.', 2, true, now(), now()),
	('dab07f34-52e7-4e12-875e-f176ecfb0d1c', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 29.', 'O empregador terá o prazo de 5 (cinco) dias úteis para anotar na CTPS, em relação aos trabalhadores que admitir, a data de admissão, a remuneração e as condições especiais, se houver, facultada a adoção de sistema manual, mecânico ou eletrônico, conforme instruções a serem expedidas pelo Ministério da Economia.', 3, true, now(), now()),
	('34d9a053-fbdb-40b7-8282-4ec62ca1c6e2', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 41.', 'Em todas as atividades será obrigatório para o empregador o registro dos respectivos trabalhadores, podendo ser adotados livros, fichas ou sistema eletrônico, conforme instruções a serem expedidas pelo Ministério do Trabalho.', 4, true, now(), now()),
	('68cc628f-8f9d-4536-ae61-5222a016a479', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 59.', 'A duração diária do trabalho poderá ser acrescida de horas extras, em número não excedente de duas, por acordo individual, convenção coletiva ou acordo coletivo de trabalho. (Redação dada pela Lei nº 13.467, de 2017)', 5, true, now(), now()),
	('90de60fb-76f6-4b8c-a645-2aa243546f59', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 60.', 'Nas atividades insalubres, assim consideradas as constantes dos quadros mencionados no capítulo "Da Segurança e da Medicina do Trabalho", ou que neles venham a ser incluídas por ato do Ministro do Trabalho, Industria e Comercio, quaisquer prorrogações só poderão ser acordadas mediante licença prévia das autoridades competentes em matéria de higiene do trabalho, as quais, para esse efeito, procederão aos necessários exames locais e à verificação dos métodos e processos de trabalho, quer diretamente, quer por intermédio de autoridades sanitárias federais, estaduais e municipais, com quem entrarão em entendimento para tal fim.', 6, true, now(), now()),
	('5d402252-a374-49db-af9c-01ee8e7c1183', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 61.', 'Ocorrendo necessidade imperiosa, poderá a duração do trabalho exceder do limite legal ou convencionado, seja para fazer face a motivo de força maior, seja para atender à realização ou conclusão de serviços inadiáveis ou cuja inexecução possa acarretar prejuízo manifesto.', 7, true, now(), now()),
	('702b0579-d222-459a-8ce6-946c15e041df', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 61. § 2º', 'Nos casos de excesso de horário por motivo de força maior, a remuneração da hora excedente não será inferior à da hora normal. Nos demais casos de excesso previstos neste artigo, a remuneração será, pelo menos, 25% (vinte e cinco por cento) superior à da hora normal, e o trabalho não poderá exceder de 12 (doze) horas, desde que a lei não fixe expressamente outro limite.', 8, true, now(), now()),
	('4189e41b-b11a-4c47-b9b7-f896fa1ef959', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 66.', 'Entre 2 (duas) jornadas de trabalho haverá um período mínimo de 11 (onze) horas consecutivas para descanso.', 9, true, now(), now()),
	('5ba5f62a-7357-462f-a5a7-f8a3e75b5034', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 67.', 'Será assegurado a todo empregado um descanso semanal de 24 (vinte e quatro) horas consecutivas, o qual, salvo motivo de conveniência pública ou necessidade imperiosa do serviço, deverá coincidir com o domingo, no todo ou em parte.', 10, true, now(), now()),
	('76106177-cfa2-418b-9c3a-e8738ce5b926', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 68.', 'O trabalho em domingo, seja total ou parcial, na forma do art. 67, será sempre subordinado à permissão prévia da autoridade competente em matéria de trabalho.', 11, true, now(), now()),
	('b4601c16-26fd-4870-bc1e-134d47b799bf', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 69.', 'Na regulamentação do funcionamento de atividades sujeitas ao regime deste Capítulo, os municípios atenderão aos preceitos nele estabelecidos, e as regras que venham a fixar não poderão contrariar tais preceitos nem as instruções que, para seu cumprimento, forem expedidas pelas autoridades competentes em matéria de trabalho.', 12, true, now(), now()),
	('10df2a25-715f-4574-a791-6981de794eb9', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 70.', 'Salvo o disposto nos artigos 68 e 69, é vedado o trabalho em dias feriados nacionais e feriados religiosos, nos têrmos da legislação própria.', 13, true, now(), now()),
	('615c727a-3724-4f27-957e-43a79879d6d1', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 71.', 'Em qualquer trabalho contínuo, cuja duração exceda de 6 (seis) horas, é obrigatória a concessão de um intervalo para repouso ou alimentação, o qual será, no mínimo, de 1 (uma) hora e, salvo acordo escrito ou contrato coletivo em contrário, não poderá exceder de 2 (duas) horas.', 14, true, now(), now()),
	('0c34af5d-fafc-4a0f-8126-808395b36bda', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 73.', 'Salvo nos casos de revezamento semanal ou quinzenal, o trabalho noturno terá remuneração superior a do diurno e, para esse efeito, sua remuneração terá um acréscimo de 20 % (vinte por cento), pelo menos, sobre a hora diurna.', 15, true, now(), now()),
	('30180d5d-abf8-4e98-bf92-8cd0cc438508', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 74.', 'O horário de trabalho será anotado em registro de empregados.', 16, true, now(), now()),
	('9810486b-f832-4f05-975a-0fd6e4b1aa7e', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 75-C.', 'A prestação de serviços na modalidade de teletrabalho deverá constar expressamente do contrato individual de trabalho, que especificará as atividades que serão realizadas pelo empregado.', 17, true, now(), now()),
	('6ce2eaa7-918f-482b-bd8a-6e1fff8f57b5', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 75-D.', 'As disposições relativas à responsabilidade pela aquisição, manutenção ou fornecimento dos equipamentos tecnológicos e da infraestrutura necessária e adequada à prestação do trabalho remoto, bem como ao reembolso de despesas arcadas pelo empregado, serão previstas em contrato escrito.', 18, true, now(), now()),
	('b3ddea9b-08c5-46c2-82fe-2a7ae7ab75ed', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 75-E.', 'O empregador deverá instruir os empregados, de maneira expressa e ostensiva, quanto às precauções a tomar a fim de evitar doenças e acidentes de trabalho.', 19, true, now(), now()),
	('83e1c3e5-0771-48db-afd0-000f269e58cd', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 130.', 'Após cada período de 12 (doze) meses de vigência do contrato de trabalho, o empregado terá direito a férias.', 20, true, now(), now()),
	('d11d6fef-de06-409a-9a03-328ac7816319', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 137.', 'Sempre que as férias forem concedidas após o prazo de que trata o art. 134, o empregador pagará em dobro a respectiva remuneração.', 21, true, now(), now()),
	('7cd6e1e0-81a7-488f-904c-4b44dcccc2c1', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 142.', 'O empregado perceberá, durante as férias, a remuneração que lhe for devida na data da sua concessão.', 22, true, now(), now()),
	('270726f0-b5e1-4d70-a56c-26c2bbc52551', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 143.', 'É facultado ao empregado converter 1/3 (um terço) do período de férias a que tiver direito em abono pecuniário, no valor da remuneração que lhe seria devida nos dias correspondentes.', 23, true, now(), now()),
	('7850130b-2885-4076-98ba-6415fe9b73fd', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 146.', 'Na cessação do contrato de trabalho, qualquer que seja a sua causa, será devida ao empregado a remuneração simples ou em dobro, conforme o caso, correspondente ao período de férias cujo direito tenha adquirido.', 24, true, now(), now()),
	('868b6b86-e790-4bbf-9b29-358b2d60900f', '7ca6a5a0-589c-4a8b-87a2-246a897e36be', 'Art. 147.', 'O empregado que for despedido sem justa causa, ou cujo contrato de trabalho se extinguir em prazo predeterminado, antes de completar 12 (doze) meses de serviço, terá direito à remuneração relativa ao período incompleto de férias, de conformidade com o disposto no artigo anterior.', 25, true, now(), now());
-- ITEM FROM NR-05 RULE
INSERT INTO item (id, rule_id, title, description, position_index, active, created_at, updated_at) VALUES
	('33596276-35a3-4980-adc2-06febc10a229', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.7', 'O mandato dos membros eleitos da CIPA terá a duração de um ano, permitida uma reeleição.', 0, true, now(), now()),
	('1fd91840-e41b-422e-8fd3-134d63b88b7c', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.8', 'É vedada a dispensa arbitrária ou sem justa causa do empregado eleito para cargo de direção de Comissões Internas de Prevenção de Acidentes desde o registro de sua candidatura até um ano após o final de seu mandato.', 1, true, now(), now()),
	('584f7c24-24c6-4881-95bb-63a722b65718', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.11', 'O empregador designará entre seus representantes o Presidente da CIPA, e os representantes dos empregados escolherão entre os titulares o vice-presidente.', 2, true, now(), now()),
	('838efdb0-26fb-42b8-b55e-107fde7a9bb0', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.24', 'As reuniões ordinárias da CIPA serão realizadas durante o expediente normal da empresa e em local apropriado.', 3, true, now(), now()),
	('52e34386-2a2f-4a76-bf5a-325946d4a2d1', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.25', 'As reuniões da CIPA terão atas assinadas pelos presentes com encaminhamento de cópias para todos os membros.', 4, true, now(), now()),
	('719b4bd3-7b9c-4c6c-80fa-1c157fe396c6', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.26', 'As atas devem ficar no estabelecimento à disposição da fiscalização do Ministério do Trabalho e Emprego.', 5, true, now(), now()),
	('ebca63b8-12e9-4df4-b4e2-c6363df801b1', 'dc4ccc56-0532-4393-a34b-399b3a2d01f0', '5.32', 'A empresa deverá promover treinamento para os membros da CIPA, titulares e suplentes, antes da posse.', 6, true, now(), now());
