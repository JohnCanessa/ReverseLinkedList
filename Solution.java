import java.util.Scanner;
import java.util.Stack;


/**
 * Definition for singly-linked list.
 */
class ListNode {

    // **** members ****
    int         val;
    ListNode    next;

    // **** constructors ****
    ListNode() {
    }

    ListNode(int val) {
        this.val = val; 
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // **** added for testing (not required) ****
    @Override
    public String toString() {
        return "" + this.val;
    }
}


/**
 * Reverse a singly linked list.
 */
public class Solution {


    /**
     * Reverse singly linked list (FIFO).
     * Iterative function.
     * Uses O(n) space and executes in O(n) time.
     */
    static ListNode reverseStack(ListNode head) {

        // **** used to reverse the linked list ****
        Stack<ListNode> stack = new Stack<ListNode>();

        // **** push elements into the stack ****
        for (ListNode p = head; p != null; p = p.next) {
            stack.push(p);
        }

        // ****  ****
        ListNode rll    = null;
        ListNode tail   = null;

        // **** pop elements from the stack and append them at the tail ****
        while (!stack.empty()) {

            // **** ****
            ListNode node = stack.pop();
            node.next = null;

            // **** ****
            if (rll == null)
                rll = node;
            else 
                tail.next = node;

            // **** ****
            tail = node;
        }

        // **** return the reversed linked list ****
        return rll;
    }


    // **** to store the reversed head ****
    static ListNode newHead = null;


    /**
     * Reverse singly linked list.
     * Entry for recursive function.
     */
    static ListNode reverseList(ListNode head) {

        // **** ****
        newHead = null;

        // **** ****
        return reverseRecursive(head, null);
    }


    /**
     * Reverse singly linked list.
     * Recursive function.
     */
    static ListNode reverseRecursive(ListNode head, ListNode prev) {

        // **** base case (end of linked list) ****
        if (head == null)
            return null;

        // **** recursive case ****
        ListNode temp = reverseRecursive(head.next, head);

        // **** save the new head of the list (if needed) ****
        if (temp == null)
            newHead = head;

        // **** update the next element ****
        head.next = prev;

        // **** return new next or the new head ****
        return (prev != null) ? prev : newHead;
    }


    /**
     * Reverse singly linked list.
     * Use pointers.
     */
    static ListNode reversePointers(ListNode head) {

        // **** check for empty linked list ****
        if (head == null)
            return null;

        // **** ****
        ListNode prev = null;
        ListNode nextHead = null;

        // **** loop moving the head of the list to the tail ****
        while (head != null) {

            // **** this will be the next head ****
            nextHead = head.next;

            // **** to point backwards ****
            head.next = prev;

            // **** point backwards ****
            prev = head;

            // **** update the head ****
            head = nextHead;
        }

        // **** return the reversed linked list ****
        return prev;
    }

    
    /**
     * Insert node into linked list.
     * Recursive function.
    */
    static ListNode insert(ListNode head, int val) {

        // **** base case ****
        if (head == null) {
            head = new ListNode(val);
        }

        // **** recursive case ****
        else {
            head.next = insert(head.next, val);
        }

        // **** return linked list ****
        return head;
    } 


    /**
     * Traverse linked list.
     * Recursive function.
     */
    static void traverse(ListNode head) {

        // **** base case ****
        if (head == null) {
            System.out.print("NULL");
            return;
        }
 
        // **** recursive case ****
        else {
            System.out.print(head.val + "->");
            traverse(head.next);
        }
    }


    /**
     * Test scaffolding.
     * This method is not required by the solution.
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read values for the linked list ****
        String[] vals = sc.nextLine().split("->");

        // **** declare the linked list ****
        ListNode head = null;

        // **** populate the linked list ****
        for (int i = 0; i < vals.length - 1; i++) {
            int val = Integer.parseInt(vals[i]);
            head = insert(head, val);
        }

        // ???? ????
        System.out.print("main <<< head: ");
        traverse(head);
        System.out.println();

        // **** close scanner ****
        sc.close();

        // **** reverse linked list (use stack) ****
        head = reverseStack(head);

        // ???? ????
        System.out.print("main <<< head: ");
        traverse(head);
        System.out.println();

        // **** reverse linked list (recursive approach) ****
        head = reverseList(head);

        // ???? ????
        System.out.print("main <<< head: ");
        traverse(head);
        System.out.println();

        // **** reverse linked list (use pointers) ****
        head = reversePointers(head);

        // ???? ????
        System.out.print("main <<< head: ");
        traverse(head);
        System.out.println();
    }
    
}