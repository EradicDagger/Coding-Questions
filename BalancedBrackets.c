// Given a string containing three types of brackets, determine if it is balanced.
// I have used Stacks to implemnet a perfect efficient solution.

#include <stdlib.h>
#include <math.h>
#include <stdio.h>
#include <string.h>

struct Stack{
    char a[31];
    int top;
}S;

void push(int x){
    S.a[++S.top] = x;
}

char pop(){
    return S.a[S.top--];
}

int balanced(char *ex){
    int i;
    int n = strlen(ex);

    if(n%2 != 0) return 0;

    for(i = 0; i < n; i++){

        if(ex[i] == '{' || ex[i] == '[' || ex[i] ==  '(')
            push(ex[i]);

        else{

            char temp = pop();

            if(ex[i] == '}'){
                if(temp != '{')
                    return 0;
            }

            if(ex[i] == ')'){
                if(temp != '(')
                    return 0;
            }

            if(ex[i] == ']'){
                if(temp != '[')
                    return 0;
            }

        }
    }

    if(S.top == -1)
        return 1;
    else
        return 0;
}

int main(){

    S.top = -1;
    char ex[31];
    scanf("%s",ex);

    int x = 1;
    x = balanced(ex);

    if(x==0)
        printf("false");
    else
        printf("true");

    return 0;
}
