Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 *
 * typedef struct ListNode listnode;
 *
 * listnode* listnode_new(int val) {
 *     listnode* node = (listnode *) malloc(sizeof(listnode));
 *     node->val = val;
 *     node->next = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Head pointer of linked list
 *
 * @Output Integer
 */
 listnode* middle(listnode*A)
 {
     listnode*slowptr=A;
     listnode*fastptr=A->next;
     while(fastptr && fastptr->next)
     {
        slowptr=slowptr->next;
        fastptr=fastptr->next->next;
     }
     return slowptr;
 }
 listnode* reverse(listnode*head)
 {
     listnode*curr=head;
     listnode*prev=NULL;
     listnode*nextNode;
     while(curr)
     {
         nextNode=curr->next;
         curr->next=prev;
         prev=curr;
         curr=nextNode;
     }
     return prev;
 }
 int compare(listnode*p1,listnode*p2)
 {
     while(p1&&p2)
     {
         if(p1->val==p2->val)
         {
             p1=p1->next;
             p2=p2->next;
         }
         else
         {
             return 0;
         }
     }
     return 1;
 }
int lPalin(listnode* A) {

    listnode*p2=middle(A);
    listnode*p1=A;
    p2=p2->next;
    listnode*p3=reverse(p2);
   int m=compare(p1,p3);
   if(m==0)
   {
       return 0;
   }
   else
   {
       return 1;
   }

}
