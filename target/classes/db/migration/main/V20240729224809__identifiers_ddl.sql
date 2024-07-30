CREATE TABLE eg_identifier (
    individualId VARCHAR(255) PRIMARY KEY,
    identifierType VARCHAR(255),
    identifierId VARCHAR(255),
    FOREIGN KEY (individualId) REFERENCES eg_ind_registration (individualId)
);
