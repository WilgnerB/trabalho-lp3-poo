/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.Bean;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Pessoa {
    private int cdPessoa;
    private String nmPessoa;
    private Date dtNasc;
    private String telefone;
    private String cpf;
    private ArrayList<Endereco> Enderecos;

    public int getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(int CdPessoa) {
        this.cdPessoa = CdPessoa;
    }
   
    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String NmPessoa) {
        this.nmPessoa = NmPessoa;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date DtNasc) {
        this.dtNasc = DtNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String Telefone) {
        this.telefone = Telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Endereco> getEnderecos() {
        return Enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }                
}
