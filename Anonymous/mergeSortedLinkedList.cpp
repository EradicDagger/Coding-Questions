// Linked list are alternatives to arrays over some advantages and disadvantages based on conditions given.
// Read more about linked list : https://en.wikipedia.org/wiki/Linked_list

//  This is a cpp program to merge two sorted lists A and B as one linked list.

Node* MergeLists(Node *headA, Node* headB)
{
    struct Node *result = new struct Node;
    struct Node *resultHead = new struct Node;      //to store resultant list's head pointer, which we will return at end;

    if(headA == NULL)                      //if listA is NULL, listB is our solution
        return headB;

    if(headB == NULL)                      //if listB is NULL, listA is our solution
        return headA;

    if(headA -> data < headB -> data){
        result = headA;
        headA = headA -> next;
    }
    else{
        result = headB;
        headB = headB -> next;
    }

    resultHead = result;                    //storing address of head node of resultant list in 'r'

    while(headA && headB){                  //checking elements one by one and adding to resultant list
        if(headA -> data < headB -> data){
            result -> next = headA;
            headA = headA -> next;
         }
        else{
            result -> next = headB;
            headB = headB -> next;
        }
        result = result -> next;
    }

    while(headA != NULL){                   //Adding all elements from listA when listB is fully exhaust
        result -> next = headA;
        headA = headA -> next;
        result = result -> next;
    }

    while(headB != NULL){                   //Adding all elements from listB when listA is fully exhaust
        result -> next = headB;
        headB = headB -> next;
        result = result -> next;
    }
    result -> next = NULL;                  //assigning NULL to last pointer of the resultant list

    return resultHead;                      //returning head pointer of the resultant list which we stored above

}
