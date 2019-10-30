#include<iostream>
using namespace std;
void display(int Size,int a[])
{
    int i;
     for(i=0;i<Size;i++)
    {
    //cout<<a[i]<<" ";
      if(a[i]==0)
      {
          cout<<i+1;
          break;
      }
    }
}
void Missing_Integer(int A[],int Size)
{
    int index;
     for(int i=0;i<Size;i++)
    {
        if(A[i]>Size || A[i]<0)
        {
            A[i]=0;
        }
    }
   int i=0;
    while(i<Size)
        {
    	  if(A[i]>0)
    	  {
    		   index=A[i]-1;
    		   if(A[index]>=0)
				    A[i]=A[index];
			   else A[i]=0;
			   A[index]=-1;
    	  }
         else i++;
       }
}
int main()
{
    int Size,a[100];
    cin>>Size;
    for(int i=0;i<Size;i++)
    {
        cin>>a[i];
    }
    Missing_Integer(a,Size);
    display(Size,a);
return 0;
}
