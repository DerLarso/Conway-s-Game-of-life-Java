import java.util.Scanner;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.09.2025
 * @author Lars Brennecke
 */

public class SpielDesLebens {
  private int columns = 8;
  private int rows = 2;
  private String start = ".";
  public static void main(String[] args) {
    SpielDesLebens l = new SpielDesLebens();
    l.sandkiste();
  } // end of main
  public void sandkiste(){
    Scanner input = new Scanner(System.in);
    System.out.println("Gib die Regel ein: ");
    int rule = input.nextInt();
    System.out.println("Gib an wie viele Durchläufe es geben soll: ");
    int steps = input.nextInt();
    System.out.println("Gib den Start(z.B. ....................x. ).");
    start += input.next() + ".";
    System.out.println(start.substring(1, start.length() - 1));
    if (rule < 256) {
      String[][] rules = ruleCreation(rule);
      for (int i = 0; i < steps ;i++ ) {
        execute(rules);
      } // end of for
    } else {
      System.out.println("Die Regel hat einen zu hohen Wert!");  
    } // end of if-else
    input.close();
  }
  
  public String[][] ruleCreation(int rule){
    
    
    String[][] rules = new String[columns][rows];
    rules[0][0] = "xxx";
    rules[0][1] = "";
    rules[1][0] = "xx.";
    rules[1][1] = "";
    rules[2][0] = "x.x";
    rules[2][1] = "";
    rules[3][0] = "x..";
    rules[3][1] = "";
    rules[4][0] = ".xx";
    rules[4][1] = "";
    rules[5][0] = ".x.";
    rules[5][1] = "";
    rules[6][0] = "..x";
    rules[6][1] = "";
    rules[7][0] = "...";
    rules[7][1] = "";
    
    if (rule >= 128) {
      rule -= 128;
      rules[0][1] = "x";
    } else {
      rules[0][1] = ".";  
    } // end of if-else

    if(rule >= 64){
      rule -= 64;
      rules[1][1] = "x";
    } else {
      rules[1][1] = ".";
    }
    
    if (rule >= 32) {
      rule -= 32;
      rules[2][1] = "x";
    } else {
      rules[2][1] = ".";  
    } // end of if-else
    
    
    if (rule >= 16) {
      rule -= 16;
      rules[3][1] = "x";
    } else {
      rules[3][1] = ".";
    }
    
    
    if (rule >= 8) {
      rule -= 8;
      rules[4][1] = "x";
    } else{
      rules[4][1] = ".";
    } 
    
    
    if (rule >= 4) {
      rule -= 4;
      rules[5][1] = "x";
    } else{
      rules[5][1] = ".";
    } 
    
    if (rule >= 2) {
      rule -= 2;
      rules[6][1] = "x";
    } else {
      rules[6][1] = ".";
    }

    if (rule >= 1) {
      rule -= 1;
      rules[7][1] = "x";
    } else {
      rules[7][1] = "."; 
    } // end of if-else

    //toString(rules,columns,rows);
    return rules;
  }
  public void execute(String[][] regel){
    String result = ".";
    for (int i = 1; i < start.length()-1 ; i ++ ) {
      result += regelAnwendung(regel, start.substring(i-1,i+2));
    } // end of for
    
    result += ".";
    start = result;
    System.out.println(start.substring(1,start.length()-1));
  }
  
  public String regelAnwendung(String[][] regel, String a){
    String c = "";
    for (int i = 0; i< regel.length ; i++) {
      if (a.equals(regel[i][0])) {
        c = regel[i][1];
        break;
      } // end of if
    } // end of for
    
    return c;
    
    
  }
  public void toString(String[][] input, int columns, int rows){
    for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows; j++ ) {
        System.out.println(input[i][j]);
      } // end of for
    } // end of for
  }
} // end of class SpielDesLebens
