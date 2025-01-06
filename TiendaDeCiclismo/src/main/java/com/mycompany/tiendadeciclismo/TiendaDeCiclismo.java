/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendadeciclismo;

/**
 *Inicia todo el programa
 * @author david
 */
public class TiendaDeCiclismo {
    /**
     * Llama al Login al iniciar el programa. 
     * @param args 
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
