import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Node<Integer> head = ex1(new int[]{1, 2, 3, 4, 5});
	Node<Integer> head2 = ex1(new int[]{1, 2, 3, 4, 5});

        System.out.println("ex2");
        ex2_1(head);
        
        ex2_2(head);

        ex2_3(head);
        
        System.out.println("ex3");
        System.out.println(ex3());
        
        System.out.println("ex4");
        ex4(head);
        
        System.out.println("ex5");
        boolean exists = ex5(head, 3);
        System.out.println("Exists: " + exists);
        
        System.out.println("ex6");
        System.out.println(ex6(head, 2));

	System.out.println("ex8");
        System.out.println(ex8(head, head2));
	
	System.out.println("ex9");
	ex9(head,head2)
	
		

    }

    public static Node<Integer> ex1(int[] a) {
        Node<Integer> h = new Node<>(-1);
        Node<Integer> p = h;
        Node<Integer> x;
        for (int i = 0; i < a.length; i++) {
            x = new Node<>(a[i]);
            p.setNext(x);
            p = p.getNext();
        }
        return h.getNext();
    }
    

    public static void ex2_1(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public static void ex2_2(Node<Integer> current) {
        if (current != null) {
            System.out.println(current.getValue());
            ex2_2(current.getNext());
        }
    }
    
    public static void ex2_3(Node<Integer> current) {
        if (current != null) {
            ex2_2(current.getNext());
            System.out.println(current.getValue());
        }
    }
    
    public static Node<Integer> ex3() {
        Scanner input = new Scanner(System.in);

        Node<Integer> head = null;
        Node<Integer> p = null;
        System.out.println(" | Enter numbers to build a list, end with -1 : | ");
        int msg = input.nextInt();
        while (msg != -1) { 
            Node<Integer> newNode = new Node<>(msg);
            if (head == null) {
                head = newNode;  
            } else {
                p.setNext(newNode);  
            }
            p = newNode;
            msg = input.nextInt();
        }

        return head; 
    }


    public static void ex4(Node<Integer> current) {
        if (current != null) {
            if (current.getValue() % 2 == 0) {
                System.out.println(current.getValue());
            }
            ex4(current.getNext());
        }
    }

    public static boolean ex5(Node<Integer> head, int target) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == target) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    public static Node<Integer> ex6(Node<Integer> head, int target) {
        if (head != null && head.getValue() == target) {
            return head.getNext();  
        }
        Node<Integer> current = head; 
        while (current != null && current.getNext() != null) {// בדיקת גישה נוחה לאיבר הבא
            if (current.getNext().getValue() == target) {
                current.setNext(current.getNext().getNext()); 
                return head; 
            }
            current = current.getNext(); 
        }
		return head;
    }

    public static boolean ex8(Node<Integer> l1, Node<Integer> l2) {
    	if (!l1.hasNext() && !l2.hasNext()) {
    		return true;
    	}
    	
    	if (l1.getValue() != l2.getValue()) {
    		return false;
    	}
		
    	return ex8(l1.getNext(), l2.getNext());
    }

    public static void ex9(Node<Integer> l1, Node<Integer> l2) {
    	if (!l1.hasNext() && !l2.hasNext()) {
    		return;
    	}
    	if (l1.getValue() == l2.getValue()) {
    		System.out.println(l1.getValue());
    	}
    	ex9(l1.getNext(), l2.getNext());
    }
   
}
