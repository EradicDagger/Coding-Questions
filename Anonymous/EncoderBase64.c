// Implpementing Base 64 encoder in C language.

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char Base64[]="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

char *encoder(char* to_encode){
    char* result;
    int n=strlen(to_encode);
    int encode_length = 4 * ( (n+2) / 3);
    result = (char*) malloc(encode_length);
    int i, c = 0, j = 0, k = 0;

    for(i = 0; i < n; i += 3){
        long int temp2=0;
        for(j = i; j <= i+2 ; j++){
                temp2 = temp2<<8;
                if(j<n){
                temp2 |= to_encode[j];
                }
        }
        for(c = 3; c >= 0; c--){
            result[k++] = Base64 [ temp2 >> (c * 6) & 0x3F ];
        }
    }

    if((n%3) != 0){
        for(i = 0; i < (3 - (n%3)); i++){
            result[encode_length -i -1] = '=';
        }
    }
    result[k]='\0';

    return result ;
}

int main(void){

    char* to_encode;
    to_encode = (char *) malloc(100 * sizeof(char));

    gets(to_encode);

    printf("\nTo Encode: %s", to_encode);

    printf("\nEncoded_Result : %s\n",encoder(to_encode));

   return 0;
}
