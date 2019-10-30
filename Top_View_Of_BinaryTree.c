#include<malloc.h>
#include<stdio.h>
struct node
{
	int val;
	int data;
	struct node *left;
	struct node *right;
};
struct node* createBST(struct node *root,int d,int v)
{
	struct node *n=(struct node*)malloc(sizeof(struct node));
	if(root==NULL)
	{
		n->val=v;
		n->data=d;
		n->left=NULL;
		n->right=NULL;
		return n;
	}
	else if(d<root->data)
		root->left=createBST(root->left,d,v-1);
	else if(d>root->data)
		root->right=createBST(root->right,d,v+1);
	return root;
}
int height(struct node *root)
{
	if(root==NULL)
		return 0;
	else
	{
		int l=height(root->left);
		int r=height(root->right);
		if(l>r)
			return l+1;
		else
			return r+1;
	}
}
//take an array of let's say size 10 to store the nodes according to their values(0,1,-1,-2 etc)
int a[10]={0};
void printGivenLevel(struct node* root, int level)
{
    if (root == NULL)
        return;
    if (level == 1)
      {
	    if(a[root->val+5]==0)
	       {
		      a[root->val+5]=root->data;
           }
      }
    else if (level > 1)
    {
        printGivenLevel(root->left, level-1);
        printGivenLevel(root->right, level-1);
    }
}
void printLevelOrder(struct node* root)
{
    int h = height(root);
    int i;
    for (i=1; i<=h; i++)
        printGivenLevel(root, i);
}
void top_view()
{
	int i=0;
	for(i=0;i<10;i++)
	{
		if(a[i]!=0)
			printf("%d ",a[i]);
	}
}
main()
{
	int n,i,a,m;
	struct node *root=NULL;

	scanf("%d",&n);

	scanf("%d",&a);
	root=createBST(root,a,0);
	for(i=1;i<n;i++)
	{
		scanf("%d",&a);
		root=createBST(root,a,root->val);
	}
	printLevelOrder(root);
	top_view();
}
