#include<stdio.h>
 
int main()
{
    char text[100];
    int i;
    int countL,countU,countS;
     
    printf("Enter any string: ");
    gets(text);
 
    //here, we are printing string using printf
    //without using loop
    printf("Entered string is: %s\n",text);
     
    //count lower case, upper case and special characters
    //assign 0 to counter variables
    countL=countU=countS=0; 
     
    for(i=0;text[i]!='\0';i++)
    {
        //check for alphabet
        if((text[i]>='A' && text[i]<='Z') || (text[i]>='a' && text[i]<='z'))
        {
            if((text[i]>='A' && text[i]<='Z'))
            {
                //it is upper case alphabet
                countU++;
            }
            else
            {
                //it is lower case character
                countL++;
            }
        }
        else
        {
            //character is not an alphabet
            countS++; //it is special character
        }
    }
     
    //print values
    printf("Upper case characters: %d\n",countU);
    printf("Lower case characters: %d\n",countL);
    printf("Special characters: %d\n",countS);
     
    return 0;
}
