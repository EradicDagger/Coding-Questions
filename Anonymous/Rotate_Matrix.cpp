#include<iostream>
using namespace std;
  int row,col,a[100][100];
void rotate_matrix(int a[100][100],int row,int col)
{
    int temp;
  for(int i=0;i<row/2;i++)
  {
      for(int j=i;j<col-1-i;j++)
      {
         temp=a[i][j];
         a[i][j]=a[row-1-j][i];
         a[row-1-j][i]=a[row-1-i][col-1-j];
         a[row-1-i][col-1-j]=a[j][col-1-i];
         a[j][col-1-i]=temp;
      }
  }
}
void display()
{
   for(int i=0;i<row;i++)
  {
     for(int j=0;j<col;j++)
     {
        cout<<a[i][j]<<" ";
     }
     cout<<endl;
  }
}
int main()
{
    //int row,col,a[100][100];
  cin>>row>>col;
  for(int i=0;i<row;i++)
  {
     for(int j=0;j<col;j++)
     {
        cin>>a[i][j];
     }
  }
  //cout<<"before rotatn\n";
  display();
  rotate_matrix(a,row,col);
  cout<<"endl"<<"aftr rotan\n";
  display();
  return 0;
}
