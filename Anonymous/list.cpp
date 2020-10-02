#include<iostream>
#include<stdlib.h>
using namespace std;
typedef struct node
{
int data;
struct node*next;
}nn;
struct node* add(nn**h,int val)
{
    nn*loc=*h;
    if(*h==NULL)
    {
        nn *n=(nn*)malloc(100*sizeof(nn));
        n->data=val;
        n->next=*h;
       *h=n;
    }
    else
    {
        while(loc->next!=NULL)
        {
            loc=loc->next;
        }
        nn *n=(nn*)malloc(sizeof(nn));
        n->data=val;
        n->next=NULL;
        loc->next=n;
    }
    return *h;
}
void print(nn*h)
{
    while(h!=NULL)
    {
        cout<<h->data;
        h=h->next;
    }
}
int main()
{
struct node* head=NULL;
struct node* result=NULL;
result=add(&head,10);
result=add(&head,20);
result=add(&head,30);
print(result);
}
