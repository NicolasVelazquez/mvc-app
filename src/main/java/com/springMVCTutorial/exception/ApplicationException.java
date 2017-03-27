/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springMVCTutorial.exception;

public class ApplicationException extends Exception{

    public ApplicationException() {
    }
    
    public ApplicationException(Exception ex){
        super(ex.fillInStackTrace());
    }

    public ApplicationException(String mensaje, Exception ex) {
        super(mensaje, ex.fillInStackTrace());
    }
    
}
