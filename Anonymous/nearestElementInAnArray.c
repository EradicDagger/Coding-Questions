// A classic logical array problem - Find the nearest smallest element for every element in given array.
// I have implimented solution using in classic C language for this classic problem.

#include <stdlib.h>
#include <stdio.h>

struct Stack{
    int a[100];
    int top;
};

void push(struct Stack *S, int x){
    S -> a[S -> top + 1] = x;
    S -> top = S -> top  + 1;
}

int pop(struct Stack *S){
    int x = S -> a[S -> top];
    (S -> top) = S -> top - 1;
    return x;
}

int isEmpty(struct Stack *S){
    if(S -> top == -1)
        return 1;
    else
        return 0;
}

int top(struct Stack *S){
    return S -> a[S -> top];
}


void fun(int A[], int n){
  struct Stack *s1, *s2;

  s1 = (struct Stack*) malloc(sizeof(struct Stack));
  s1 -> top = -1;
  s2 = (struct Stack*) malloc(sizeof(struct Stack));
  s2 -> top = -1;

  int i, flag = 0, flagAnother = 0;

  for(i = 0; i < n ;i++){
    while(isEmpty(s1) == 0){
        int x = top(s1);

        if(x < A[i]){
            printf("%d ",x);
            flagAnother = 1;
            break;
        }
        else{
             x = pop(s1);
             push(s2, x);
        }
    }

    if(isEmpty(s1)){
        printf("-1 ");
        flag = 1;
    }

    while(isEmpty(s2) == 0){
       int x = pop(s2);
        push(s1, x);
    }

    if(flag){
        push(s1, A[i]);
        flag = 0;
    }
    if(flagAnother){
        push(s1, A[i]);
        flagAnother = 0;
    }
  }
}

int main(){
    int ar[9] = {1, 35, 28, 20, 6, 16, 26, 48, 34};
    
    fun(ar, 9);

    return 0;
}
