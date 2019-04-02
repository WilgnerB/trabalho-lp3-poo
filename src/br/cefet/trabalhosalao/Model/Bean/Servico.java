/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.Bean;

/**
 *
 * @author aluno
 */
public class Servico {
    
    private int CdServico;
    private String NmServico;
    private double ValorAt;
    private Tipo tipo;
    
        private Servico(int cdservico, String nome, double vlatual,Tipo tipo) {
        this.CdServico = cdservico;
        this.NmServico = nome;
        this.ValorAt = vlatual;
        this.tipo=tipo;
    }

    
    public static Servico newinstance(int cdservico,String nome,double valorat,Tipo tipo){
        return new Servico(cdservico,nome,valorat,tipo);
    }

    public Servico() {
    }

    public int getCdServico() {
        return CdServico;
    }

    public void setCdServico(int CdServico) {
        this.CdServico = CdServico;
    }

    public String getNmServico() {
        return NmServico;
    }

    public void setNmServico(String NmServico) {
        this.NmServico = NmServico;
    }

    public double getValorAt() {
        return ValorAt;
    }

    public void setValorAt(double ValorAt) {
        this.ValorAt = ValorAt;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
