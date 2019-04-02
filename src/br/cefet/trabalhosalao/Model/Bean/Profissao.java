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
public class Profissao {
    private int CdProfissao;
    private String NmProfissao;
    
    private Profissao(int cdprofissao, String nmprofissao) {
        this.CdProfissao = cdprofissao;
        this.NmProfissao = nmprofissao;
    }

    
    public static Profissao newinstance(int cdservico,String nome){
        return new Profissao(cdservico,nome);
    }

    public Profissao() {
    }

    public int getCdProfissao() {
        return CdProfissao;
    }

    public void setCdProfissao(int CdProfissao) {
        this.CdProfissao = CdProfissao;
    }

    public String getNmProfissao() {
        return NmProfissao;
    }

    public void setNmProfissao(String NmProfissao) {
        this.NmProfissao = NmProfissao;
    }
}
