
package br.com.infox.entidades;

public class OrdemServico {
    
    private String data;
    private String tipo;
    private String situacao;
    private String equipamento;
    private String defeito;
    private String servico;
    private String tecnico;
    private double valor;
    private Cliente cliente;

    public OrdemServico () {
        
    }
    // sobrecarga
    public OrdemServico (String tipo, String situacao, String equipamento, String defeito, String servico, String tecnico, double valor) {
        setTipo(tipo);
        setSituacao(situacao);
        setEquipamento(equipamento);
        setDefeito(defeito);
        setServico(servico);
        setTecnico(tecnico);
        setValor(valor);
    }
    
    public String getData() {
        if (data != null) {
            String partes[] = data.split("-");
            return partes[2]+"/"+partes[1]+"/"+partes[0];
        } else {
            return null;
        }
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "data=" + data + ", tipo=" + tipo + ", situacao=" + situacao + ", equipamento=" + equipamento + ", defeito=" + defeito + ", servico=" + servico + ", tecnico=" + tecnico + ", valor=" + valor + ", cliente=" + cliente + '}';
    }
    
}
