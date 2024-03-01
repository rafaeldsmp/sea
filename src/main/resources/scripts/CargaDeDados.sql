USE xpto;

INSERT INTO tb_customer_success (nome, email, experiencia, ausencia) 
VALUES 
('inicianteComFalta', 'inicianteComFalta@example.com', 0, true),
('proficiente', 'proficiente@example.com', 1, false),
('inicianteNormal', 'inicianteComFalta@example.com', 0, false)