package fr.jeremy.leetcode;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in each linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     It is guaranteed that the list represents a number that does not have leading zeros.
 */

class ListNode {

     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
     }
  }

public class AddTwoNumbers {

    public ListNode solution(ListNode l1, ListNode l2) {
        //Initialise the dummy node and the pointer
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        //We keep going while there are numbers to count or be carried
        while (l1 != null || l2 != null || carry != 0) {
            //Extracting values (0 reached)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            //Sum
            int sum = carry + x + y;
            carry = sum / 10; // Nouvelle retenue

            //Create a new node modulo 10
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            //Iterating in the list
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        //Return the node after the dummyHead
        return dummyHead.next;
    }

}
