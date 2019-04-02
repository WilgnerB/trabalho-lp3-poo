/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Model.DAO.*;

/**
 *
 * @author aluno
 */
public class ControlException extends Exception{

    public ControlException(String message) {
        super(message);
    }

    public ControlException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
