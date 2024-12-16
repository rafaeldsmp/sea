USE sea;

-- Inserir Cliente
INSERT INTO Cliente (nome, cpf)
VALUES
    ('João Silva', '12345678901'),
    ('Maria Souza', '23456789012');

-- Inserir Endereços
INSERT INTO Endereco (cliente_id, cep, logradouro, bairro, cidade, uf, complemento)
VALUES
    (1, '01001000', 'Praça da Sé', 'Sé', 'São Paulo', 'SP', NULL),
    (2, '20040002', 'Rua da Carioca', 'Centro', 'Rio de Janeiro', 'RJ', 'Apt 202');

-- Inserir Telefones
INSERT INTO Telefone (cliente_id, tipo, numero)
VALUES
    (1, 'CELULAR', '11987654321'),
    (1, 'RESIDENCIAL', '1133445566'),
    (2, 'CELULAR', '21998765432');

-- Inserir Emails
INSERT INTO Email (cliente_id, email)
VALUES
    (1, 'joao.silva@example.com'),
    (1, 'contato.joao@example.com'),
    (2, 'maria.souza@example.com');