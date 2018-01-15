package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Chamado;
import modelo.Setor;
import modelo.Tecnico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-14T21:08:56")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Setor> setoridSetor;
    public static volatile SingularAttribute<Cliente, String> senha;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Tecnico> tecnicoidTecnico;
    public static volatile CollectionAttribute<Cliente, Chamado> chamadoCollection;
    public static volatile SingularAttribute<Cliente, String> nome;

}