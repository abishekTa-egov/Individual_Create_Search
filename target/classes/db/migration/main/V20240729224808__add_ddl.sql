CREATE TABLE eg_address(
  id VARCHAR(64),
  individualId VARCHAR(64),
  tenantId VARCHAR(64) ,
  doorNo VARCHAR(64),
  latitude FLOAT,
  longitude FLOAT,
  locationAccuracy FLOAT,
  type VARCHAR(64),
  addressLine1 VARCHAR(256),
  addressLine2 VARCHAR(256),
  landmark VARCHAR(256),
  city VARCHAR(64),
  pincode VARCHAR(16),
  buildingName VARCHAR(256),
  street VARCHAR(256),
  locality_code VARCHAR(64),
  locality_name VARCHAR(256),
  locality_label VARCHAR(256),
  locality_latitude VARCHAR(64),
  locality_longitude VARCHAR(64),
  CONSTRAINT fk_eg_ind_address FOREIGN KEY (individualId) REFERENCES eg_ind_registration (individualId)
);
