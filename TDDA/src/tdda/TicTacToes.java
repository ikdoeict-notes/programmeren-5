/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;

/**
 *
 * @author seppesnoeck
 */
public class TicTacToes {
    Function<Integer, Object> contains1, contains2, contains3, divide1, divide2, divide3;
    String type1,type2, type3;
    int bottomValue, topValue;
        
    public TicTacToes(String type1, String type2, String type3, int value1, int value2, int value3, int bottomValue, int topValue){
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        
        if (bottomValue <= 0){
            throw new IllegalArgumentException();
        }else {
            this.bottomValue = bottomValue;    
        } 
        
        if (topValue > 100){
            throw new IllegalArgumentException();
        }else {
            this.topValue = topValue;
        }  
        
        contains1 = containsValue(type1, value1);
        contains2 = containsValue(type2, value2);
        contains3 = containsValue(type3, value3);
        divide1 = dividable(type1, value1);
        divide2 = dividable(type2, value2);
        divide3 = dividable(type3, value3);
    }
    
    static Function<Integer, Object> dividable(String type, int value) {
        return (number) -> number % value == 0 ? type : number;
    }
    
    static Function<Integer, Object> containsValue(String type, int value){
        return (number) -> {
            StringBuilder result = new StringBuilder();
            Integer.toString(number).chars().map(c -> c-='0').filter(num -> num == value).forEach(i -> result.append(type).append(" "));
            return result.length() > 0 ? result.toString().trim() : number;
        };
    } 
    
    public Object TicTacToe(int number){
        StringBuilder result = new StringBuilder();
        //TicTacToes ttt = new TicTacToes("Tic", "Tac", "Toe", 3,5,7);
        if (this.divide1.apply(number).toString().contains(this.type1)){
            result.append(this.divide1.apply(number)).append(" ");
        }
        if (this.contains1.apply(number).toString().contains(this.type1)){
            result.append(this.contains1.apply(number)).append(" ");
        }
        if (this.divide2.apply(number).toString().contains(this.type2)){
            result.append(this.divide2.apply(number)).append(" ");
        }
        if (this.contains2.apply(number).toString().contains(this.type2)){
            result.append(this.contains2.apply(number)).append(" ");
        }
        if (this.divide3.apply(number).toString().contains(this.type3)){
            result.append(this.divide3.apply(number)).append(" ");
        }
        if (this.contains3.apply(number).toString().contains(this.type3)){
            result.append(this.contains3.apply(number)).append(" ");
        }
        if (result.length() != 0){
            System.out.print(result.toString().trim() + ", ");
            return result.toString().trim();
        }
        System.out.print(number + ", ");
        return number;
    }
    
    public void Iterator(){
        IntStream.range(bottomValue, topValue).forEach(i -> this.TicTacToe(i));
    }
}
