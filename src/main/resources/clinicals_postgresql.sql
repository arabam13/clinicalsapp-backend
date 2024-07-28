use clinicals;

CREATE TABLE patient (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    age INT
);

CREATE TABLE clinicaldata (
    id SERIAL PRIMARY KEY,
    patient_id INT,
    component_name VARCHAR(255) NOT NULL,
    component_value VARCHAR(255) NOT NULL,
    measured_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_patient FOREIGN KEY (patient_id)
      REFERENCES patient(id)
);


insert into patient values(1,'toto','toto',32);
insert into patient values(2,'tata','tata',52);


insert into clinical_data  values('1', 'bp', '12/7', '2023-07-09 19:34:24', '1');
insert into clinical_data  values('2', 'bp', '13/6', '2023-08-02 19:34:24', '2');