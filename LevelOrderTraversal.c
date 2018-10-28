// Implementing Level Order traversal of a binary tree.

#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node* left;
    struct node* right;
};

typedef struct node node;

/************QUEUE DEFINITION************/
struct queue{
    struct node ar[20];
    int start;
    int end;
}q;


void push(node x){
    q.ar[++q.end] = x; 
}

node pop(){
    return q.ar[++q.start];
}

int isQEmpty(){
    if(q.start == q.end)
        return 1;
    else
        return 0;
}
/***************************************/


node* newEle(int data){                                             //to create a new node
    node* n = (node*) malloc (sizeof(node));
    n -> data = data;
    n -> left = n-> right = NULL;
    return n;
}

node* root = NULL;                                //tree root definition

node* insert(node* root, int data){                                 //to insert a node in a binary search tree
   if(root == NULL){
        node* n = newEle(data);
        root = n;
        return root;
   }
   else{
        
        if(data <= root -> data)
            root -> left = insert (root -> left, data);
        else
            root -> right = insert (root -> right, data);
   }

   return root;
}

void levelOrder(node root){
    push(root);

    while( isQEmpty() == 0){
        node t = pop();
        printf("%d ", t.data);

        if(t.left)
            push(*(t.left));

        if(t.right)
            push(*(t.right));
    }

}

int main(){
    q.start = -1;
    q.end = -1;

    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 5);
    root = insert(root, 21);
    root = insert(root, 4);
   
    levelOrder(*root);

    printf("\n");
    return 0;
}
