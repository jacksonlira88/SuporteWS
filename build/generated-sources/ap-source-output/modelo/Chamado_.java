package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.Tecnico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-14T21:08:56")
@StaticMetamodel(Chamado.class)
public class Chamado_ { 

    public static volatile SingularAttribute<Chamado, String> nomeProblema;
    public static volatile SingularAttribute<Chamado, String> descricaoProblema;
    public static volatile SingularAttribute<Chamado, Integer> posicao;
    public static volatile SingularAttribute<Chamado, Date> dataFim;
    public static volatile SingularAttribute<Chamado, Tecnico> tecnicoidTecnico;
    public static volatile SingularAttribute<Chamado, Cliente> clienteidCliente;
    public static volatile SingularAttribute<Chamado, Integer> idChamado;
    public static volatile SingularAttribute<Chamado, Date> dataInicio;
    public static volatile SingularAttribute<Chamado, Integer> avaliacao;
    public static volatile SingularAttribute<Chamado, String> status;

}