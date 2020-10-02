#include<iostream>
#include<limits.h>
using namespace std;
 int max(int a,int b)
 {
     if(a>b)
     {
         return a;
     }
     if(a==b)
     {
         return a;
     }
     else
     {
         return b;
     }
 }
int main()
{
 int arr[100],size;
 cin>>size;
 for(int i=0;i<size;i++)
 {
    cin>>arr[i];
 }
 int Max1=INT_MIN,cursum=0;
 for(int i=0;i<size;i++)
 {
     cursum=max(cursum+arr[i],arr[i]);
     if(cursum>=Max1)
     {
        Max1=cursum;
     }
 }
 cout<<Max1;
return 0;
}
