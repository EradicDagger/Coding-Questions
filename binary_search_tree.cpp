#include<iostream>
#include<stdlib.h>
#include<limits.h>
using namespace std;
struct tree
{
int data;
struct tree* left;
struct tree* right;
};
int arr[10];
struct tree* createBinary(struct tree* root,int d)
{
    if(root==NULL)
    {
        struct tree* nn=(struct tree*)malloc(sizeof(struct tree));
        nn->data=d;
        nn->left=NULL;
        nn->right=NULL;
        return nn;
    }
    else
    {
        if(d<root->data)
        {
            root->left=createBinary(root->left,d);
        }
        else if(d>root->data)
        {
            root->right=createBinary(root->right,d);
        }
        return root;
    }
}
void display(struct tree* r)
{
    if(r==NULL)
    {
        return;
    }
    else
    {
            display(r->left);
            cout<<r->data<<" ";
            display(r->right);
    }

}
int FINDMAX(struct tree* r)
{
    if(r->right==NULL)
    {
        return r->data;
    }
    FINDMAX(r->right);
}
struct tree* Del(struct tree* r,int value)
{
    if(r==NULL)
    {
        return NULL;
    }
    else if(value<r->data)
    {
        r->left=Del(r->left,value);
    }
    else if(value>r->data)
    {
        r->right=Del(r->right,value);
    }
    else
    {
        if(r->left==NULL && r->right==NULL)
        {
            free(r);
            r=NULL;
            return NULL;
        }
       if(r->right==NULL)
        {
            struct tree* temp=r->left;
            free(r);
            r=NULL;
            return temp;
        }
        if(r->left==NULL)
        {
            struct tree* temp=r->right;
            free(r);
            r=NULL;
            return temp;
        }
       else
       {
           int x=FINDMAX(r->left);
           r->data=x;
           r->left=Del(r->left,x);
       }
    }
}
int check_height(struct tree* r)
{
   // int l,ri;
    if(r==NULL)
    {
        return 0;
    }
    else
    {
       int l=check_height(r->left);
       int  ri=check_height(r->right);
       if(l>ri)
        {
           return l+1;
        }
        else
         {
        return ri+1;
        }
    }
}
int least_ances(struct tree* r,int val1,int val2)
{
    if(val1<r->data && val2>r->data)
    {
        return r->data;
    }
    else
    {
        if(val1<r->data && val2<r->data)
        {
            r=r->left;
            least_ances(r,val1,val2);
        }
        if(val1>r->data && val2>r->data)
        {
            r=r->right;
            least_ances(r,val1,val2);
        }
    }
}
int check_bst(struct tree* r, int *p)
{
   if(r==NULL)
   {
       return 1;
   }
   int x=(check_bst(r->left,p));
   if(x==0)
   {
       return 0;
   }
      if(r->data<*p)
     {
       return 0;
   }
   else
   {
       *p=r->data;
   }
   return (check_bst(r->right,p));
}
void inorder(struct tree* r)
{
    int i=0;
    if(r==NULL)
    {
        arr[i]=r->data;
    }
    else
    {
        inorder(r->left);
        //arr[i]=r->data;
        //i++;
        inorder(r->right);
    }
}
void k_small(struct tree* r,int k)
{
    inorder(r);
    for(int i=0;i<8;i++)
    {
        cout<<arr[i];
    }
}
int min_element_tree(struct tree* r)
{
    while(r->left)
    {
        r=r->left;
    }
    return r->data;
}
int complete_tree(struct tree* r)
{
    if(r==NULL)
    {
        return 1;
    }
    else if(!(r->left)&& !(r->right))
    {
        return 1;
    }
    else if(r->left && r->right)
    {
        return (complete_tree(r->left)&& complete_tree(r->right));
    }
    else
    {
        return 0;
    }
}
int main()
{
    int value;
    struct tree* root=NULL;
     root=createBinary(root,10);
      root=createBinary(root,2);
        root=createBinary(root,7);
        root=createBinary(root,5);
        root=createBinary(root,9);
        root=createBinary(root,11);
        root=createBinary(root,3);
        root=createBinary(root,12);
    display(root);
    ///cin>>value;
    ///cout<<endl;
    ///Del(root,value);
   /// display(root);
    int h=check_height(root);
    cout<<"height "<<h<<endl;
    ///int val1,val2;
    ///cin>>val1>>val2;
    ///int result=least_ances(root,val1,val2);
    ///cout<<"Result"<<result;
    int d=INT_MIN;
    int c=check_bst(root,&d);
    cout<<"output"<<c;
    int k;
    //cin>>k;
    //k_small(root,k);
    int m=min_element_tree(root);
    cout<<"min"<<m;
    int y=complete_tree(root);
    cout<<"complete"<<y;
return 0;
}
