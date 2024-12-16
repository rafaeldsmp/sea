-- Tabela Cliente
CREATE TABLE Cliente (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         cpf CHAR(11) NOT NULL UNIQUE,
                         CONSTRAINT chk_nome CHECK (LENGTH(nome) >= 3 AND LENGTH(nome) <= 100 AND nome REGEXP '^[a-zA-Z0-9 ]+$')
    );

-- Tabela Endereco
CREATE TABLE Endereco (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          cliente_id INT NOT NULL,
                          cep CHAR(8) NOT NULL,
                          logradouro VARCHAR(255) NOT NULL,
                          bairro VARCHAR(100) NOT NULL,
                          cidade VARCHAR(100) NOT NULL,
                          uf CHAR(2) NOT NULL,
                          complemento VARCHAR(255),
                          FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE,
                          CONSTRAINT chk_cep CHECK (cep REGEXP '^[0-9]{8}$')
    );

-- Tabela Telefone
CREATE TABLE Telefone (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          cliente_id INT NOT NULL,
                          tipo ENUM('RESIDENCIAL', 'COMERCIAL', 'CELULAR') NOT NULL,
                          numero CHAR(11) NOT NULL,
                          FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE,
                          CONSTRAINT chk_numero CHECK (numero REGEXP '^[0-9]{10,11}$')
    );

-- Tabela Email
CREATE TABLE Email (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       cliente_id INT NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE,
                       CONSTRAINT chk_email CHECK (email LIKE '%@%.%')
);
