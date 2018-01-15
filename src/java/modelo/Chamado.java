/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jackson
 */
@Entity
@Table(name = "chamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chamado.findAll", query = "SELECT c FROM Chamado c"),
    @NamedQuery(name = "Chamado.findByIdChamado", query = "SELECT c FROM Chamado c WHERE c.idChamado = :idChamado"),
    @NamedQuery(name = "Chamado.findByNomeProblema", query = "SELECT c FROM Chamado c WHERE c.nomeProblema = :nomeProblema"),
    @NamedQuery(name = "Chamado.findByDescricaoProblema", query = "SELECT c FROM Chamado c WHERE c.descricaoProblema = :descricaoProblema"),
    @NamedQuery(name = "Chamado.findByStatus", query = "SELECT c FROM Chamado c WHERE c.status = :status"),
    @NamedQuery(name = "Chamado.findByPosicao", query = "SELECT c FROM Chamado c WHERE c.posicao = :posicao"),
    @NamedQuery(name = "Chamado.findByDataInicio", query = "SELECT c FROM Chamado c WHERE c.dataInicio = :dataInicio"),
    @NamedQuery(name = "Chamado.findByDataFim", query = "SELECT c FROM Chamado c WHERE c.dataFim = :dataFim"),
    @NamedQuery(name = "Chamado.findByAvaliacao", query = "SELECT c FROM Chamado c WHERE c.avaliacao = :avaliacao")})
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChamado")
    private Integer idChamado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomeProblema")
    private String nomeProblema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricaoProblema")
    private String descricaoProblema;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "posicao")
    private Integer posicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Column(name = "dataFim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @Column(name = "avaliacao")
    private Integer avaliacao;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;
    @JoinColumn(name = "tecnico_idTecnico", referencedColumnName = "idTecnico")
    @ManyToOne
    private Tecnico tecnicoidTecnico;

    public Chamado() {
    }

    public Chamado(Integer idChamado) {
        this.idChamado = idChamado;
    }

    public Chamado(Integer idChamado, String nomeProblema, String descricaoProblema, Date dataInicio) {
        this.idChamado = idChamado;
        this.nomeProblema = nomeProblema;
        this.descricaoProblema = descricaoProblema;
        this.dataInicio = dataInicio;
    }

    public Integer getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(Integer idChamado) {
        this.idChamado = idChamado;
    }

    public String getNomeProblema() {
        return nomeProblema;
    }

    public void setNomeProblema(String nomeProblema) {
        this.nomeProblema = nomeProblema;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Tecnico getTecnicoidTecnico() {
        return tecnicoidTecnico;
    }

    public void setTecnicoidTecnico(Tecnico tecnicoidTecnico) {
        this.tecnicoidTecnico = tecnicoidTecnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChamado != null ? idChamado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.idChamado == null && other.idChamado != null) || (this.idChamado != null && !this.idChamado.equals(other.idChamado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Chamado[ idChamado=" + idChamado + " ]";
    }
    
}
