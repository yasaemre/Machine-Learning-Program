
package Lab5bBTreeMachineLearning;
import java.io.*;
import java.util.*;



//********************************************************************
//Lab 5b -     Binary tree using a basic form of machine learning
//@authors     Emre Yasa
//@IDE     	   Eclipse
//@since       2019-5-10
//@OS          IOS
//**
public class BTNode {

    String text;

    BTNode yes;

    BTNode no;
    
    public BTNode (String item) {
    	text=item;
    	yes = null;
    	no = null;
    }
 
 // A Java program to introduce Binary Tree
  public static class BinaryTree{
    	
    	//Root of Binary Tree
    	BTNode root;
    	
    	BinaryTree(String key){
    		root = new BTNode(key);
    	}
    	BinaryTree(){
    		root = null;
    	}
    	
}//BinaryTree Class
    


  public static void main(String[] args)
  {
      BinaryTree tree = new BinaryTree();

      //elephant is value at the root
      tree.root = new BTNode("elephant");
      int cycleCount = 0;

      boolean answerFound = false;//checks whether answer found and assigned to false
      String A = "guess"; //initialized a animal guess
      char YesNo = ' ';// YesNo char

      Scanner scan = new Scanner(System.in);  // Create a Scanner object
      
      //the loop goes through at least 5 times and answer is correct
      while(!answerFound && cycleCount < 5) {
          System.out.println("Think of an animal. Type something to continue");

          String userAnswer = scan.nextLine();  // Read user input
          if(userAnswer.equalsIgnoreCase("")) {
              System.out.println("You did not type anything, The program finished");
              break;
          }

          //p is root node now
          BTNode p = tree.root;
          
          //while p node not null
          while(p != null) {
              //if p.yes is null, it wants to take a confirmation of the animal
              if(p.yes == null) {
                  System.out.println("Are you thinking of the animal: " + p.text + " Please type Y/N");
                  String userAnimalAnswer = scan.nextLine();
                  if (userAnimalAnswer.equalsIgnoreCase("Y")) {
                      answerFound = true;
                      System.out.println("We win!");
                      break;
                  }
                  // It is not that animal, so we get the animal

                  System.out.println("What animal were you thinking of?");
                  A = scan.nextLine();

                  System.out.println("What Yes/No question differentiates this animal from yours? ");
                  String Q = scan.nextLine();

                  //ask which response is correct for A -- yes or no...
                  System.out.println("Which response is correct for that question? (Y/N)");

                  YesNo=scan.nextLine().charAt(0);//gets the char y or no

                  //it initialize the node with null value
                  BTNode Y = new BTNode(null);
                  BTNode N = new BTNode(null);
                  
                  //According to which one is correct, Y node gets A animal,
                  //and p.text is assgined to N node as a value
                  //if not, opposite happens
                  if ((YesNo == 'Y') || (YesNo == 'y') ) {
                      Y.text = A;
                      N.text = p.text;
                  } else if((YesNo == 'N') || (YesNo == 'n')) {
                      N.text = A;
                      Y.text = p.text;
                  }

                  //Question is assigned as a value to P
                  p.text = Q;

                  //And then every node is assigned to null
                  Y.yes= null;
                  N.yes= null;
                  Y.no = null;
                  N.no = null;

                  //p.yes becomes Y, p.no is no either
                  p.yes = Y;
                  p.no = N;
                  break;//it 
              } else if (p.yes != null) {
                  System.out.println(p.text);
                  YesNo = scan.nextLine().charAt(0);
                  if((YesNo =='Y') || (YesNo =='y')) {
                      p = p.yes;
                  }else if((YesNo =='N') || (YesNo =='n')){
                      p = p.no;
                  }
              }// end p.yes != null
          }//while loop traversing tree
          cycleCount++; 
      } //while loop  at least 5 times ask the user
  }//Main Class
}
