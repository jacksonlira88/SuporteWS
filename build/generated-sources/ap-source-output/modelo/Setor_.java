package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-14T21:08:56")
@StaticMetamodel(Setor.class)
public class Setor_ { 

    public static volatile SingularAttribute<Setor, Integer> prioridade;
    public static volatile SingularAttribute<Setor, String> nome;
    public static volatile SingularAttribute<Setor, Integer> idSetor;
    public static volatile CollectionAttribute<Setor, Cliente> clienteCollection;

}