BEGIN TRANSACTION;

DROP TABLE IF EXISTS accesos CASCADE;
CREATE TABLE accesos (
    pk bigserial NOT NULL,
    usuario varchar(255) NOT NULL,
    fecha timestamp NOT NULL DEFAULT NOW(),
    tipo varchar(255) NOT NULL,
    ip varchar(255),
    UNIQUE (usuario, fecha, ip),
    PRIMARY KEY (pk)
);


DROP TABLE IF EXISTS tipos_kcc CASCADE;
CREATE TABLE tipos_kcc (
    pk serial NOT NULL,
    tipo varchar(255) NOT NULL,
    codigo_comercio varchar(255),
    tipo_comercio varchar(255),
    UNIQUE (tipo),
    UNIQUE (codigo_comercio, tipo_comercio),
    PRIMARY KEY (pk)
);
INSERT INTO tipos_kcc (tipo, codigo_comercio, tipo_comercio) VALUES ('Normal','597026007976','HTML_TR_NORMAL');
INSERT INTO tipos_kcc (tipo, codigo_comercio, tipo_comercio) VALUES ('Mall','597026008069','HTML_TR_MALL');


DROP TABLE IF EXISTS kcc CASCADE;
CREATE TABLE kcc (
    pk bigserial NOT NULL,
    usuario varchar(255) NOT NULL,
    tipos_kcc_fk int NOT NULL REFERENCES tipos_kcc (pk) ON UPDATE CASCADE ON DELETE CASCADE,
    carpeta varchar(255) NOT NULL,
    medcom int NOT NULL,
    paramverifcom int NOT NULL,
    urlcgicom varchar(255) NOT NULL,
    servercom varchar(255) NOT NULL,
    portcom int NOT NULL,
    whitelistcom varchar(255) NOT NULL,
    host varchar(255) NOT NULL,
    wport int NOT NULL,
    urlcgitra varchar(255) NOT NULL,
    urlcgimedtra varchar(255) NOT NULL,
    servertra varchar(255) NOT NULL,
    porttra int NOT NULL,
    prefijo_conf_tr varchar(255) NOT NULL,
    cierre varchar(255) NOT NULL,
    UNIQUE (carpeta),
    PRIMARY KEY (pk)
);


COMMIT;
