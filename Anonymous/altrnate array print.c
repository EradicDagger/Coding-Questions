#include<stdio.h>
void main()
{
    int n,a[10],i;
printf("entr size");
scanf("%d",&n);
printf("entr elemnts");
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
printf("original array\n");
for(i=0;i<n;i++)
{
printf("%d\t",a[i]);
}
printf("\n");
printf("alternate array\n");
for(i=0;i<n;i+=2)
{
    printf("%d\t",a[i]);

}
}
