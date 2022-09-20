-- Table: public.bill_type

-- DROP TABLE IF EXISTS public.bill_type;

CREATE TABLE IF NOT EXISTS public.bill_type
(
    id integer NOT NULL,
    type text COLLATE pg_catalog."default",
    CONSTRAINT bill_type_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bill_type
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.credit_type
(
    id integer NOT NULL,
    type text COLLATE pg_catalog."default",
    CONSTRAINT credit_type_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.credit_type
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL,
    firstname text COLLATE pg_catalog."default",
    lastname text COLLATE pg_catalog."default",
    username text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default",
    age integer,
    marital_status text COLLATE pg_catalog."default",
    employed boolean,
    monthly_income double precision,
    admin boolean,
    CONSTRAINT "Users_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.bill
(
    id integer NOT NULL,
    payment_purpose text COLLATE pg_catalog."default",
    receiver text COLLATE pg_catalog."default",
    bill_type integer,
    amount double precision,
    sender integer,
    CONSTRAINT bill_pkey PRIMARY KEY (id),
    CONSTRAINT fk_bill_bill_type FOREIGN KEY (bill_type)
        REFERENCES public.bill_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_bill_users FOREIGN KEY (sender)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bill
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.credit
(
    id integer NOT NULL,
    credit_type integer,
    amount double precision,
    sender integer,
    CONSTRAINT credit_pkey PRIMARY KEY (id),
    CONSTRAINT fk_credit_credit_type FOREIGN KEY (credit_type)
        REFERENCES public.credit_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_credit_users FOREIGN KEY (sender)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.credit
    OWNER to postgres;


