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
    private String title;
    private List<String> question;
    
    
    public List<String> createOptions ( int numRespuestas){
        String answer;
        for(int i = 0; i <= numRespuestas;i++){
            System.out.println("introduzca la opción");
            Scanner enter = new Scanner(System.in);
            answer = enter.nextLine();
            question.add(answer);
        }
        return question;
    }

    public String getEnunciado() {
        return title;
    }

    public void setEnunciado(String enunciado) {
        this.title = enunciado;
    }

    public List<String> getRespuestas() {
        return question;
    }
    
    
}
