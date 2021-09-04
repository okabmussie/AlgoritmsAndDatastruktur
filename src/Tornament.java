public class Tornament {

    public static class Node{
        char value;
        Node left_child;
        Node right_child;

        public Node(char verdi){
            this.value = verdi;
            this.left_child = null;
           this.right_child = null;
        }
        void skrivUt(){
            System.out.println(value);
        }
    }
     static  Node playMatch(Node team_1, Node team_2){
        char vinner;
        if (team_1.value>team_2.value){
            vinner = team_1.value;
        }
       else {
            vinner = team_2.value;
        }
        Node parent = new Node(vinner);
        parent.left_child = team_1;
        parent.right_child= team_2;

        return parent;

    }



    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node f = new Node('F');
        Node e = new Node('E');

        Node semi_1 = playMatch(a,b);
        Node semi_2 = playMatch(c,d);
        Node semi_3 = playMatch(f,e);

        System.out.println("semifinalen er :");
        semi_1.skrivUt();
        semi_2.skrivUt();
        semi_3.skrivUt();

        Node Vinnere = playMatch(semi_1,semi_2);
        Node finalWinner = playMatch(Vinnere,semi_3);
        System.out.println("final vineren av hele matchen er da : ");
        finalWinner.skrivUt();

    }
}
