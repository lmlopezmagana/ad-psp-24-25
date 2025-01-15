insert into categoria (id, nombre)
values (nextval('categoria_seq'), 'Categoria 1');

insert into tag (id, nombre)
values (nextval('tag_seq'), 'Ibérico');

insert into tag (id, nombre)
values (nextval('tag_seq'), 'Tapeo');

insert into tag (id, nombre)
values (nextval('tag_seq'), 'Refrigerio');


insert into producto (descripcion,nombre,precio, id, categoria_id)
values ('Lorem ipsum dolor sit amet','Botellín fresquito', 1.0, nextval('producto_seq'), currval('categoria_seq'));

insert into producto (descripcion,nombre,precio, id, categoria_id)
values ('Lorem ipsum dolor sit amet','Tapita de jamón de bellota', 4.20, nextval('producto_seq'), currval('categoria_seq'));

insert into producto_tag (producto_id, tag_id) values (1, 51);
insert into producto_tag (producto_id, tag_id) values (51, 51);
insert into producto_tag (producto_id, tag_id) values (51, 1);
insert into producto_tag (producto_id, tag_id) values (1, 101);