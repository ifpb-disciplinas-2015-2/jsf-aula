/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pp.aula.jsf;

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;

/**
 *
 * @author Izabel Silva
 */

@Named
@RequestScoped
public class PessoaControlador implements Serializable{
    private Pessoa pessoa;

    public PessoaControlador() {
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public String enviar(){
        return "home.xhtml";
    }
}
