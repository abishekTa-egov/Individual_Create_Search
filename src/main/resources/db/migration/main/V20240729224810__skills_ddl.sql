CREATE TABLE eg_skills (
    individualId VARCHAR(255) PRIMARY KEY,
    skilltype VARCHAR(255),
    skillLevel VARCHAR(255),
    experience VARCHAR(255),
    FOREIGN KEY (individualId) REFERENCES eg_ind_registration (individualId)
);