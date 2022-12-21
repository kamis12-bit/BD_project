DROP TABLE event;
DROP TABLE promo_message;
DROP TABLE message_type;
DROP TABLE person;
DROP TABLE graphics;
DROP TABLE description;
DROP TABLE event_person;
DROP TABLE message_person;

CREATE TABLE event (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    description VARCHAR2(1000),
    begin_date DATE NOT NULL,
    end_date DATE NOT NULL,
    archived NUMBER(1) NOT NULL
);

CREATE TABLE message_type (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    colour VARCHAR2(20) NOT NULL
);

CREATE TABLE person (
    id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR2(40) NOT NULL,
    last_name VARCHAR2(40) NOT NULL,
    avatar VARCHAR2(100)
);

CREATE TABLE graphics (
    id NUMBER(10) PRIMARY KEY,
    state NUMBER(1) NOT NULL,
    reason VARCHAR2(1000),
    graphics_content VARCHAR2(100) NOT NULL,
    supervisor NUMBER(10) REFERENCES person(id) NOT NULL
);

CREATE TABLE description (
    id NUMBER(10) PRIMARY KEY,
    state NUMBER(1) NOT NULL,
    reason VARCHAR2(1000),
    description_content VARCHAR2(100) NOT NULL,
    supervisor NUMBER(10) REFERENCES person(id) NOT NULL
);

CREATE TABLE promo_message (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    publication_date DATE NOT NULL,
    published NUMBER(1) NOT NULL,
    event NUMBER(10) REFERENCES event(id) NOT NULL,
    graphics NUMBER(10) REFERENCES graphics(id),
    description NUMBER(10) REFERENCES description(id),
    has_type NUMBER(10) REFERENCES message_type(id) NOT NULL
);

CREATE TABLE event_person (
    event NUMBER(10) REFERENCES event(id) NOT NULL,
    person NUMBER(10) REFERENCES person(id) NOT NULL,
    CONSTRAINT id_event_person PRIMARY KEY (event, person)
);

CREATE TABLE message_person (
    promo_message NUMBER(10) REFERENCES promo_message(id) NOT NULL,
    person NUMBER(10) REFERENCES person(id) NOT NULL,
    CONSTRAINT id_message_person PRIMARY KEY (promo_message, person)
);

CREATE OR REPLACE TRIGGER checkDates 
BEFORE INSERT OR UPDATE ON event
FOR EACH ROW
BEGIN
    IF :NEW.begin_date IS NULL OR :NEW.begin_date IS NULL 
        OR :NEW.begin_date > :NEW.end_date THEN
        raise_application_error(-20000,'Incorrect begin and end dates');
    END IF;
END;
/
