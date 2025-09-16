import java.util.Scanner;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.09.2025
 * @author Lars Brennecke
 */

public class SpielDesLebens {
  private String tot = "";
  private String lebend = "";
  private String start = "";
  public static void main(String[] args) {
    SpielDesLebens l = new SpielDesLebens();
    l.sandkiste();
  } // end of main
  public void sandkiste(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the character for a dead cell: ");
    tot = input.next();
    charCheck(tot);
    start = tot ;
    System.out.println("Enter the character for a living cell: ");
    lebend = input.next();
    charCheck(lebend);
    System.out.println("Please give the rule: ");
    int rule = input.nextInt();
    System.out.println("Enter the count of rows from the output: ");
    int steps = input.nextInt();
    System.out.println("Give the start(for example: " +tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+tot+lebend+tot + ":");
    start += input.next() + tot;
    System.out.println(start.substring(1, start.length() - 1));
    boolean check = inputCheck();
    if (rule < 256 && rule > -1 && check) {
      String[][] rules = ruleCreation(rule);
      for (int i = 0; i < steps ;i++ ) {
        execute(rules);
      } // end of for
    } else if(check) {
      System.out.println("The rule's value is above 255 or under 0!");
    } // end of if-else
    input.close();
  }
  public void charCheck(String test){
    if(test.length() != 1 ){
      System.out.println("Only 1 Character is allowed!");
      System.exit(1);
    }
  }
  public boolean inputCheck(){
    for (int i = 0; i < start.length(); i++){
      if (!start.substring(i,i+1).equals(tot) && !start.substring(i,i+1).equals(lebend)){
        System.out.println("Remember: Only use dead and alive!");
        return false;
      }
    }
    return true;
  }

  
  public String[][] ruleCreation(int rule){

    int columns = 8;
    int rows = 2;
    String[][] rules = new String[columns][rows];
    rules[0][0] = lebend + lebend + lebend;
    rules[0][1] = "";
    rules[1][0] = lebend + lebend + tot;
    rules[1][1] = "";
    rules[2][0] = lebend + tot + lebend;
    rules[2][1] = "";
    rules[3][0] = lebend + tot + tot;
    rules[3][1] = "";
    rules[4][0] = tot + lebend + lebend;
    rules[4][1] = "";
    rules[5][0] = tot + lebend + tot;
    rules[5][1] = "";
    rules[6][0] = tot + tot + lebend;
    rules[6][1] = "";
    rules[7][0] = tot + tot + tot;
    rules[7][1] = "";
    
    if (rule >= 128) {
      rule -= 128;
      rules[0][1] = lebend;
    } else {
      rules[0][1] = tot;
    } // end of if-else

    if(rule >= 64){
      rule -= 64;
      rules[1][1] = lebend;
    } else {
      rules[1][1] = tot;
    }
    
    if (rule >= 32) {
      rule -= 32;
      rules[2][1] = lebend;
    } else {
      rules[2][1] = tot;
    } // end of if-else
    
    if (rule >= 16) {
      rule -= 16;
      rules[3][1] = lebend;
    } else {
      rules[3][1] = tot;
    }

    if (rule >= 8) {
      rule -= 8;
      rules[4][1] = lebend;
    } else{
      rules[4][1] = tot;
    } 

    if (rule >= 4) {
      rule -= 4;
      rules[5][1] = lebend;
    } else{
      rules[5][1] = tot;
    } 
    
    if (rule >= 2) {
      rule -= 2;
      rules[6][1] = lebend;
    } else {
      rules[6][1] = tot;
    }

    if (rule >= 1) {
      rules[7][1] = lebend;
    } else {
      rules[7][1] = tot;
    } // end of if-else

    //toString(rules,columns,rows);
    return rules;
  }
  public void execute(String[][] regel){
    String result = tot;
    for (int i = 1; i < start.length()-1 ; i ++ ) {
      result += regelAnwendung(regel, start.substring(i-1,i+2));
    } // end of for
    result += tot;
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
