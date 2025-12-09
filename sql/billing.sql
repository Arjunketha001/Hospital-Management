CREATE SCHEMA IF NOT EXISTS billing_service;

CREATE TABLE IF NOT EXISTS billing_service.billing_account
(
    id UUID PRIMARY KEY,
    patient_id UUID UNIQUE NOT NULL,
    patient_name VARCHAR(255) NOT NULL,
    balance DOUBLE PRECISION DEFAULT 0.0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Dummy billing accounts (can match auth_service patients)
INSERT INTO billing_service.billing_account (id, patient_id, patient_name, balance)
SELECT 'b2111111-1111-1111-1111-111111111111','123e4567-e89b-12d3-a456-426614174000','John Doe', 0.0
WHERE NOT EXISTS (SELECT 1 FROM billing_service.billing_account WHERE patient_id='123e4567-e89b-12d3-a456-426614174000');

INSERT INTO billing_service.billing_account (id, patient_id, patient_name, balance)
SELECT 'b2111111-1111-1111-1111-111111111112','123e4567-e89b-12d3-a456-426614174001','Jane Smith', 0.0
WHERE NOT EXISTS (SELECT 1 FROM billing_service.billing_account WHERE patient_id='123e4567-e89b-12d3-a456-426614174001');
