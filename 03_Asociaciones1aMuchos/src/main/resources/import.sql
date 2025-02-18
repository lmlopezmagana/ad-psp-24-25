insert into categoria (id, nombre)
values (nextval('categoria_seq'), 'Categoria 1');

insert into productos (descripcion,nombre,precio, id, categoria_id)
values ('Lorem ipsum dolor sit amet','Botellín fresquito', 1.0, nextval('productos_seq'), currval('categoria_seq'));

insert into productos (descripcion,nombre,precio, id, categoria_id)
values ('asdfasdafsdfa','Macbook M4 Pro Max', 4999.9, nextval('productos_seq'), currval('categoria_seq'));