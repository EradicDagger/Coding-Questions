#include<stdio.h>
 
int main()
{
    char text[100];
    int i;
     
    printf("Enter any string: ");
    gets(text);
     
    printf("Entered string is: %s\n",text);
     
    //convert into upper case
    for(i=0;text[i]!='\0';i++)
    {
        //check character is alphabet or not
        if((text[i]>='A' && text[i]<='Z')||(text[i]>='a' && text[i]<='z'))
        {
            //check for upper case character
            if(text[i]>='A' && text[i]<='Z')
                text[i]=text[i]+0x20;
            else
                text[i]=text[i]-0x20;
        }
    }
     
    printf("String after toggle case: %s\n",text);
 
    return 0;
}
