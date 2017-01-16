
package tictactoe;

/**
 *
 * @author hanne.goossens
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public String inputNumber(int cijfer){
        String returnWaarde = "";
        boolean veranderd = false;
        
/*        //region TicTacToe
        if(cijfer >= 101 || cijfer <= 0) {
            throw new IllegalArgumentException();
        }
        if(String.valueOf(cijfer).contains("3")){
            veranderd = true;
            returnWaarde += "Tic";
        }
        if(cijfer%3==0){
            veranderd = true;
            returnWaarde += "Tic";
        }
        if(String.valueOf(cijfer).contains("5")){
            veranderd = true;
            returnWaarde += "Tac";
        }
        if(cijfer%5==0){
            veranderd = true;
            returnWaarde += "Tac";
        }
        if(String.valueOf(cijfer).contains("7")){
            veranderd = true;
            returnWaarde += "Toe";
        }
        if(cijfer%7==0){
            veranderd = true;
            returnWaarde += "Toe";
        }        
        //endregion*/
        
        if(String.valueOf(cijfer).contains("4")) {
            veranderd = true;
            returnWaarde += "Frits";
        }
        
        if (cijfer%4==0) {
            veranderd = true;
            returnWaarde += "Frits";
        }
        
        if(String.valueOf(cijfer).contains("6")) {
            veranderd = true;
            returnWaarde += "Freddy";
        }
        
        if (cijfer%6==0) {
            veranderd = true;
            returnWaarde += "Freddy";
        }
        
        if(!veranderd) { 
            return Integer.toString(cijfer); 
        }
        
        return returnWaarde;
    }
}
