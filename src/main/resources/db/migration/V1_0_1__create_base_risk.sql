create TABLE SPECIFIC_RISK (
    ID VARCHAR2(100 CHAR),
    OE_ID VARCHAR2(100 CHAR),
    SPECIFIC_THING VARCHAR2(100 CHAR),
    PRIMARY KEY(ID)
);

create TABLE GENERIC_RISK (
    ID VARCHAR2(100 CHAR),
    PRIMARY KEY(ID)
);


create table GENERIC_RISK_LABEL (
    LABEL_VALUE VARCHAR2(100 CHAR),
    RISK_ID VARCHAR2(100 CHAR),
    FOREIGN KEY(RISK_ID) REFERENCES GENERIC_RISK (ID)
);


create table LABEL (
    LABEL_VALUE VARCHAR2(100 CHAR),
    RISK_ID VARCHAR2(100 CHAR),
    FOREIGN KEY(RISK_ID) REFERENCES SPECIFIC_RISK (ID)
);

create table IMPORTED_RISK (
    ID VARCHAR2(100 CHAR),
    PARENT_RISK VARCHAR2(100 CHAR),
    OE_ID VARCHAR2(100 CHAR),
    PRIMARY KEY(ID),
);

create or replace view local_risks_view as

    select s.id as risk_id, s.oe_id as oe_id from SPECIFIC_RISK s
    union
    select distinct g.id as risk_id, i.oe_id as oe_id
    from GENERIC_RISK g, IMPORTED_RISK i
    where i.PARENT_RISK = g.id

    ;

create or replace view local_risk_label as
    select s.id as risk_id, sl.label_value as risk_label
     from SPECIFIC_RISK s, LABEL sl
        where s.id = sl.risk_id
        union
        select g.id as risk_id, gl.label_value as risk_label
        from GENERIC_RISK g, GENERIC_RISK_LABEL gl
        where gl.risk_id = g.id

        ;
