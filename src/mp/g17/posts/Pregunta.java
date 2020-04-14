/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Pregunta {
    private String enunciado;
    private List<String> respuesta;
    
    
    public List<String> createQuestion (){
        String opcion;
        boolean correct = false;
        while(!correct){
            System.out.println("Introduzca el numero de respuestas");
            Scanner entrada = new Scanner(System.in);
            int numero = entrada.nextInt();
            if(numero <= 4)
                correct = true;
        }
        
        respuesta.add(opcion);
    }
    
    
}
