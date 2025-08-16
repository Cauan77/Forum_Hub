create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(100) not null unique,
    data_de_criacao datetime not null,
    status tinyint,
    autor_id bigint not null,
    curso_id bigint not null,

    primary key(id),

    constraint fk_topicos_autor_id foreign key(autor_id) references autores(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)
);