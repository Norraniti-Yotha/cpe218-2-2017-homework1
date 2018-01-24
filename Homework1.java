package homework1;




import java.util.Stack;
import java.util.Scanner;
 
public class Homework1 {
 
public static Node Tree;
public static Stack<Character> Temp = new Stack<Character>();  
 
public static class Node{
        Node l;
        Node r;
        Character key;
    public Node c;
 
    public Node(char n) {
            key = n;
        }
        public  String toString(){
            return key.toString();
        }
}

public class Tree {
    Node root = null;
}
 
    public static void main(String[] args){
        System.out.print("Input : ");
        Scanner inputs = new Scanner(System.in);
        String input =  inputs.nextLine();
 
        for(int i=0;i<input.length();i++){
            Temp.add(input.charAt(i));
        }
        Tree = new Node(Temp.pop());
        infix(Tree);
        inorder(Tree);
        System.out.print("=" + calculate(Tree));
        TreeDemo.main(args);
    }
    
    public static void inorder(Node n){
        if (n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/'){
                if(n!=Tree){
                        System.out.print("(");
                    }
                    inorder(n.l);
                    System.out.print(n.key);
                    inorder(n.r);
                if(n!=Tree){
                    System.out.print(")");
                    }
                }else {
                            System.out.print(n.key);
                    }
    }
    
        public static void infix(Node n) {
 
                    if (n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/') {
                            n.r = new Node(Temp.pop());
                            infix(n.r);
                            n.l = new Node(Temp.pop());
                            infix(n.l);
                    }
    }
   
    public static int calculate(Node n) {
            if (n.key == '+') {
                
                    return calculate(n.l) + calculate(n.r);
            }else if(n.key == '-'){
                    return calculate(n.l) - calculate(n.r);
            }else if(n.key == '/'){
                    return calculate(n.l) / calculate(n.r);
            }else if(n.key == '*'){
                    return calculate(n.l) * calculate(n.r);
            }else        
            return Integer.parseInt(n.key.toString());
    }
}