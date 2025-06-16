
CREATE TABLE IF NOT EXISTS empresas (
    cd_Cnpj VARCHAR(14) PRIMARY KEY,
    nm_Empresa VARCHAR(100) NOT NULL,
    ds_Email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS planos (
    cd_Plano INTEGER PRIMARY KEY,
    nm_Plano VARCHAR(100) NOT NULL,
    ds_Plano VARCHAR(255),
    vl_Plano NUMERIC(10,2)  NOT NULL
);

CREATE TABLE IF NOT EXISTS contratos (
    cd_Cnpj VARCHAR(18) NOT NULL REFERENCES empresas(cd_Cnpj) ON DELETE CASCADE,
    cd_Plano INTEGER NOT NULL REFERENCES planos(cd_Plano) ON DELETE CASCADE,
    dt_Inicio DATE NOT NULL,
    dt_Vencimento DATE NOT NULL
);



-- Inserir empresas
-- INSERT INTO empresas (cd_Cnpj, nm_Empresa, ds_Email) VALUES
-- ('12345678000199', 'TechBridge Ltda.', 'contato@techbridge.com'),
-- ('98765432000188', 'NovaEra Solutions', 'suporte@novaera.com');

-- -- Inserir planos
-- INSERT INTO planos (cd_Plano, nm_Plano, ds_Plano, vl_Plano) VALUES
-- (1, 'Plano Básico', 'Ideal para pequenas empresas.', 99.90),
-- (2, 'Plano Profissional', 'Para empresas em crescimento.', 199.90),
-- (3, 'Plano Corporativo', 'Recursos avançados e suporte dedicado.', 499.90);

-- -- Inserir contratos
-- INSERT INTO contratos (cd_Cnpj, cd_Plano, dt_Inicio, dt_Vencimento) VALUES
-- ('12345678000199', 1, '2024-01-01', '2024-12-31'),
-- ('98765432000188', 2, '2024-03-01', '2025-02-28'),
-- ('12345678000199', 3, '2025-01-01', '2025-12-31');