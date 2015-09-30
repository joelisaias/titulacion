<<<<<<< HEAD:resources/sql/configuracion.sql
--datos de la empresa
INSERT INTO rrhhtpersona(
            id, descripcion, estado, fechacreacion, fechamodificacion, apellidomaterno, 
            apellidopaterno, email, estaDocivil, fax, fechanacimiento, genero, 
            identificacion, naturaleza, nombrecomercial, nombres, razonsocial, 
            telefono, tipoidentificacion, tiposangre)
    VALUES (nextval('rrhhspersona'),'Intertubep S.A.', 'A', now(), null, null, 
            null, 'joyalt77@gmail.com', 'S','0000000', to_date('11 Jan 1990', 'DD Mon YYYY'), 'M', 
            '0981232331001', 'J', 'Intertubep S.A.', 'Intertubep S.A.', 'Intertubep S.A.', 
            '2123456', 'R', NULL);


--empresa
INSERT INTO admitempresa(id, descripcion, estado, fechacreacion, fechamodificacion, codigo, rutalogo, url, persona_id)
 VALUES (NEXTVAL('admisempresa'),'Intertubep S.A.', 'A',now(), null, 'ITSA',null,null, 1);

--MONEDA
INSERT INTO genetmoneda(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            local, simbolo)
    VALUES (NEXTVAL('genesmoneda'), 'DOLAR', 'A', NOW(), NULL,'USD', 
            'S', '$');

--division geografica
INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'ECUADOR', 'A', now(),null, 'ECU', 
            1, 'P', 1, 1);

INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'GUAYAS', 'A', now(),null, 'GUA', 
            2, 'R', 1, 1);

INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'GUAYAQUIL', 'A', now(),null, 'GYE', 
            3, 'C', 1, 2);            

INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'TARQUI', 'A', now(),null, 'TAR', 
            4, 'Q', 1, 3);
            
--region
INSERT INTO genetregion(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo)
    VALUES (nextval('genesregion'), 'COSTA', 'A', NOW(), NULL, 'COS');

--SUCURSAL
INSERT INTO admitsucursal(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            direccion, fax, telefono, ciudad_id, empresa_id, region_id)
    VALUES (nextval('admissucursal'), 'Sucursal Guayaquil' , 'A',NOW(), NULL, '01', 
            'Guayaquil', '2345678', '2345678', 4, 1, 1);




--usuario
INSERT INTO rrhhtpersona(
            id, descripcion, estado, fechacreacion, fechamodificacion, apellidomaterno, 
            apellidopaterno, email, estaDocivil, fax, fechanacimiento, genero, 
            identificacion, naturaleza, nombrecomercial, nombres, razonsocial, 
            telefono, tipoidentificacion, tiposangre)
    VALUES (nextval('rrhhspersona'),'Usuario Administrador', 'A', now(), null, 'Torres', 
            'Alvarado', 'joyalt77@gmail.com', 'S','0000000', to_date('11 Jan 1990', 'DD Mon YYYY'), 'M', 
            '0926983099', 'N', null, 'Joel Isaias', 'Usuario Administrador', 
            '0994450758', 'C', NULL);
            
INSERT INTO rrhhtempresa_persona(
            id, descripcion, estado, fechacreacion, fechamodificacion, escliente, 
            codigo, esempleado, esproveedor, empresa_id, persona_id)
    VALUES (nextval('rrhhsempresa_persona'), null, 'A', now(), null, 'N', 
            'USER01', 'N', 'N', 1, 2);
            

INSERT INTO segutusuario(
            id, descripcion, estado, fechacreacion, fechamodificacion, clave, 
            codigo, empresapersona_id)
    VALUES (nextval('segususuario'), 'Administrador','A', NOW(), NULL, '$2a$05$hBNzSTu04YNiOiYFJk4Z2.VIhVD/0FuKsJyBugdEljZn7PWbjGXzK',
            'ADMIN', 1);
            
            
            
            
INSERT INTO segutusuario_sucursal(
            id, descripcion, estado, fechacreacion, fechamodificacion, predeterminado, 
            sucursal_id, usuario_id)
    VALUES (nextval('segususuario_sucursal'), null, 'A', NOW(),NULL, 'S', 
            1, 1);
            
INSERT INTO segutrol(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo)
    VALUES (NEXTVAL('segusrol'),'ADMINISTRACION', 'A', now(), null, 'RADM');
    
INSERT INTO seguttarea(
            id, descripcion, estado, fechacreacion, fechamodificacion, acciongenerica, 
            anular, autorizar, codigo, crear, duplicar, editar, eliminar, 
            enviar, generar, imprimir, listar, procesar, rechazar, recuperar, 
            reportar, reversar, tipo, ver, modulo_id)
SELECT NEXTVAL('segustarea') AS ID, 'TAREA ADMIN '||codigo AS descripcion, 'A' ESTADO, now() AS fechacreacion , null AS fechamodificacion, null AS acciongenerica, 
            'S' AS anular, 'S' AS autorizar, 'T'||codigo AS codigo, 'S' AS crear, 'S' AS duplicar, 'S' AS editar, 'S' AS eliminar, 
            'S' AS enviar, 'S' AS generar, 'S' AS imprimir, 'S' AS listar, 'S' AS procesar,'S' AS rechazar,'S' AS recuperar, 
            'S' reportar, 'S' reversar, 'S' tipo,'T' ver, ID AS modulo_id
  FROM segutmodulo;
  
  
  
  
INSERT INTO seguttarea_rol(
            id, descripcion, estado, fechacreacion, fechamodificacion, rol_id, 
            tarea_id)
select nextval('segustarea_rol') as id,null as descripcion, 'A', now(), null, 1,id as tarea_id
from seguttarea       ;

INSERT INTO segutusuario_rol(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            rol_id, sucursal_id, usuario_id)
    VALUES (NEXTVAL('segususuario_rol'), null, 'A',NOW(),NULL, NULL, 
            1, NULL, 1);

  
    
            
            
            
            










=======
--datos de la empresa
INSERT INTO rrhhtpersona(
            id, descripcion, estado, fechacreacion, fechamodificacion, apellidomaterno, 
            apellidopaterno, email, estaDocivil, fax, fechanacimiento, genero, 
            identificacion, naturaleza, nombrecomercial, nombres, razonsocial, 
            telefono, tipoidentificacion, tiposangre)
    VALUES (nextval('rrhhspersona'),'Intertubep S.A.', 'A', now(), null, null, 
            null, 'joyalt77@gmail.com', 'S','0000000', to_date('11 Jan 1990', 'DD Mon YYYY'), 'M', 
            '0981232331001', 'J', 'Intertubep S.A.', 'Intertubep S.A.', 'Intertubep S.A.', 
            '2123456', 'R', NULL);


--empresa
INSERT INTO admitempresa(id, descripcion, estado, fechacreacion, fechamodificacion, codigo, rutalogo, url, persona_id)
 VALUES (NEXTVAL('admisempresa'),'Intertubep S.A.', 'A',now(), null, 'ITSA',null,null, 1);

--MONEDA
INSERT INTO genetmoneda(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            local, simbolo)
    VALUES (NEXTVAL('genesmoneda'), 'DOLAR', 'A', NOW(), NULL,'USD', 
            'S', '$');

--division geografica
INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'ECUADOR', 'A', now(),null, 'ECU', 
            1, 'P', 1, 1);

INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'GUAYAS', 'A', now(),null, 'GUA', 
            2, 'R', 1, 1);

INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'GUAYAQUIL', 'A', now(),null, 'GYE', 
            3, 'C', 1, 2);            

INSERT INTO genetdivision_geografica(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            nivel, tipo, moneda_id, padre_id)
    VALUES (nextval('genesdivision_geografica'), 'TARQUI', 'A', now(),null, 'TAR', 
            4, 'Q', 1, 3);
            
--region
INSERT INTO genetregion(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo)
    VALUES (nextval('genesregion'), 'COSTA', 'A', NOW(), NULL, 'COS');

--SUCURSAL
INSERT INTO admitsucursal(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            direccion, fax, telefono, ciudad_id, empresa_id, region_id)
    VALUES (nextval('admissucursal'), 'Sucursal Guayaquil' , 'A',NOW(), NULL, '01', 
            'Guayaquil', '2345678', '2345678', 4, 1, 1);




--usuario
INSERT INTO rrhhtpersona(
            id, descripcion, estado, fechacreacion, fechamodificacion, apellidomaterno, 
            apellidopaterno, email, estaDocivil, fax, fechanacimiento, genero, 
            identificacion, naturaleza, nombrecomercial, nombres, razonsocial, 
            telefono, tipoidentificacion, tiposangre)
    VALUES (nextval('rrhhspersona'),'Usuario Administrador', 'A', now(), null, 'Torres', 
            'Alvarado', 'joyalt77@gmail.com', 'S','0000000', to_date('11 Jan 1990', 'DD Mon YYYY'), 'M', 
            '0926983099', 'N', null, 'Joel Isaias', 'Usuario Administrador', 
            '0994450758', 'C', NULL);
            
INSERT INTO rrhhtempresa_persona(
            id, descripcion, estado, fechacreacion, fechamodificacion, escliente, 
            codigo, esempleado, esproveedor, empresa_id, persona_id)
    VALUES (nextval('rrhhsempresa_persona'), null, 'A', now(), null, 'N', 
            'USER01', 'N', 'N', 1, 2);
            

INSERT INTO segutusuario(
            id, descripcion, estado, fechacreacion, fechamodificacion, clave, 
            codigo, empresapersona_id)
    VALUES (nextval('segususuario'), 'Administrador','A', NOW(), NULL, '$2a$05$hBNzSTu04YNiOiYFJk4Z2.VIhVD/0FuKsJyBugdEljZn7PWbjGXzK',
            'ADMIN', 1);
            
            
            
            
INSERT INTO segutusuario_sucursal(
            id, descripcion, estado, fechacreacion, fechamodificacion, predeterminado, 
            sucursal_id, usuario_id)
    VALUES (nextval('segususuario_sucursal'), null, 'A', NOW(),NULL, 'S', 
            1, 1);
            
INSERT INTO segutrol(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo)
    VALUES (NEXTVAL('segusrol'),'ADMINISTRACION', 'A', now(), null, 'RADM');
    
INSERT INTO seguttarea(
            id, descripcion, estado, fechacreacion, fechamodificacion, acciongenerica, 
            anular, autorizar, codigo, crear, duplicar, editar, eliminar, 
            enviar, generar, imprimir, listar, procesar, rechazar, recuperar, 
            reportar, reversar, tipo, ver, modulo_id)
SELECT NEXTVAL('segustarea') AS ID, 'TAREA ADMIN '||codigo AS descripcion, 'A' ESTADO, now() AS fechacreacion , null AS fechamodificacion, null AS acciongenerica, 
            'S' AS anular, 'S' AS autorizar, 'T'||codigo AS codigo, 'S' AS crear, 'S' AS duplicar, 'S' AS editar, 'S' AS eliminar, 
            'S' AS enviar, 'S' AS generar, 'S' AS imprimir, 'S' AS listar, 'S' AS procesar,'S' AS rechazar,'S' AS recuperar, 
            'S' reportar, 'S' reversar, 'T' tipo,'S' ver, ID AS modulo_id
  FROM segutmodulo;
  
  
  
  
INSERT INTO seguttarea_rol(
            id, descripcion, estado, fechacreacion, fechamodificacion, rol_id, 
            tarea_id)
select nextval('segustarea_rol') as id,null as descripcion, 'A', now(), null, 1,id as tarea_id
from seguttarea       ;

INSERT INTO segutusuario_rol(
            id, descripcion, estado, fechacreacion, fechamodificacion, codigo, 
            rol_id, sucursal_id, usuario_id)
    VALUES (NEXTVAL('segususuario_rol'), null, 'A',NOW(),NULL, NULL, 
            1, NULL, 1);

  
    
            
            
            
            










>>>>>>> 1128786084dcde9c9bdf10a1f0cdc08dcb7d099f:sql/configuracion.sql
