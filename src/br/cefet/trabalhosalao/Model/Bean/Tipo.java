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
public class Tipo {
    private int CdTipo;
    private String NmTipo;
    
    private Tipo(int cdTipo, String nmTipo) {
        this.CdTipo = cdTipo;
        this.NmTipo = nmTipo;
    }

    public Tipo(){
        
    }
    
    public static Tipo newinstance(int cdservico,String nome){
        return new Tipo(cdservico,nome);
    }

    public int getCdTipo() {
        return CdTipo;
    }

    public void setCdTipo(int CdTipo) {
        this.CdTipo = CdTipo;
    }

    public String getNmTipo() {
        return NmTipo;
    }

    public void setNmTipo(String NmTipo) {
        this.NmTipo = NmTipo;
    }
    
}
