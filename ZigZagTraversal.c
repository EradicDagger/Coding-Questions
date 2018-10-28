// Implementing ZigZag traverssal of a binary tree.

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node{
    int data;
    struct node* left;
    struct node* right;
};

typedef struct node node;

node* newEle(int data){                                             //to create a new node
    node* n = (node*) malloc (sizeof(node));
    n -> data = data;
    n -> left = n-> right = NULL;
    return n;
}

node* root = NULL;                                                  //tree root initialisation

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

/***********STACK DEFINITION*************/

struct stack{
    node ar[20];
    int top;
};

void push(struct stack *z, node x){
    z->ar[++(z->top)] = x; 
}

node pop(struct stack *z){
    return z -> ar[(z -> top)--];
}

int isSEmpty(struct stack *z){
    if(z -> top == -1)
        return 1;
    else
        return 0;
}

/**********ZigZag Traversal************/
void zigZagTraversal(node root){
    
 
    struct stack *s = (struct stack*) malloc(sizeof(struct stack));
    s -> top = -1;
    push(s, root);
    
    bool flag = false;                  //flag- give direction of traversal at each level (when flag=false then right -> left)
                                                                                        //(when  flag=true then left -> right)
    while( isSEmpty(s) == 0){            
        
        struct stack *s2 = (struct stack*) malloc(sizeof(struct stack));
        s2->top = -1;
        while(isSEmpty(s) == 0){
            node t = pop(s);
             
            printf("%d ",t.data);

            if(flag){
                if(t.left)
                    push(s2, *(t.left));
                if(t.right)
                    push(s2, *(t.right));
            }
            else{
                if(t.right)
                    push(s2, *(t.right));

                if(t.left)
                    push(s2, *(t.left));
            }
        }
        *s = *s2;

        flag = !flag;
    }
}

int main(){
    
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 5);
    root = insert(root, 21);
    root = insert(root, 4);
        
    zigZagTraversal(*root);

    printf("\n");
    return 0;
}
