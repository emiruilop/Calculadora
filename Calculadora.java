/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

/**
 *
 * @author rdo12
 */
public class Calculadora {
    
    //este método revisa si el carácter es operador o no
    public boolean isOperator(char a){
        boolean resp=true;
        
        switch(a){
            case'+':
            case'-':
            case'/':
            case '*':
            case'(':
            case ')':
                break;
            default:
                resp=false;
                break;
        }
        return resp;
    }
    
    //verifica parentesis
    public boolean verificaParentesis(String algo){
           
        boolean resp=true;
        PilaADT<Character> pila = new Pila();
        
        int i=0;
        
        while (i<algo.length() && resp){
            if (algo.charAt(i)=='('){
                pila.push(algo.charAt(i));
            }
            else{
                if(algo.charAt(i)==')')
                try{
                        pila.pop();
                }catch (Exception e){
                                resp=false;
                        }
                        
            }
            i++;    
        }
        return resp && pila.isEmpty();
    }
    
    public boolean jerarquiaOperandos(char operando, char tope) {
        boolean resp = true;
        switch (operando) {
            case '+':
                if (tope == '+') {
                    resp = false;
                }
                break;
            case '*':
                if (tope != '^') {
                    resp = false;
                }
                break;
            case '/':
                if (tope != '^') {
                    resp = false;
                }
                break;
            case '^':
                resp = false;
                break;
            default:
                resp = false;
                break;
        }
        return resp;
    }
        
    
    
}
