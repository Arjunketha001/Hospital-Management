CREATE SCHEMA IF NOT EXISTS auth_service;

-- Users
CREATE TABLE IF NOT EXISTS auth_service.app_user
(
    id UUID PRIMARY KEY,
    patient_id UUID UNIQUE NOT NULL,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(255) DEFAULT 'PATIENT'
);

-- Billing accounts
CREATE TABLE IF NOT EXISTS auth_service.billing_account
(
    id UUID PRIMARY KEY,
    patient_id UUID UNIQUE NOT NULL,
    patient_name VARCHAR(255) NOT NULL,
    balance DOUBLE PRECISION DEFAULT 0.0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Dummy users
INSERT INTO auth_service.app_user (id, patient_id, username, password_hash)
SELECT '11111111-1111-1111-1111-111111111111','123e4567-e89b-12d3-a456-426614174000','john','hash1'
WHERE NOT EXISTS (SELECT 1 FROM auth_service.app_user WHERE patient_id='123e4567-e89b-12d3-a456-426614174000');

INSERT INTO auth_service.app_user (id, patient_id, username, password_hash)
SELECT '11111111-1111-1111-1111-111111111112','123e4567-e89b-12d3-a456-426614174001','jane','hash2'
WHERE NOT EXISTS (SELECT 1 FROM auth_service.app_user WHERE patient_id='123e4567-e89b-12d3-a456-426614174001');

-- Dummy billing accounts
INSERT INTO auth_service.billing_account (id, patient_id, patient_name, balance)
SELECT 'b1111111-1111-1111-1111-111111111111','123e4567-e89b-12d3-a456-426614174000','John Doe', 0.0
WHERE NOT EXISTS (SELECT 1 FROM auth_service.billing_account WHERE patient_id='123e4567-e89b-12d3-a456-426614174000');

INSERT INTO auth_service.billing_account (id, patient_id, patient_name, balance)
SELECT 'b1111111-1111-1111-1111-111111111112','123e4567-e89b-12d3-a456-426614174001','Jane Smith', 0.0
WHERE NOT EXISTS (SELECT 1 FROM auth_service.billing_account WHERE patient_id='123e4567-e89b-12d3-a456-426614174001');
