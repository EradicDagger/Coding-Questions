// Implementing Base 64 decoder in C languge.
// knowmore about base 64 encoding : https://en.wikipedia.org/wiki/Base64

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char Base64[]="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

char *decoder(char* encoded){

    int n = strlen(encoded);
    char * result;
    result = (char*) malloc(100 * sizeof(char));

    long int temp = 0;
    int index, i, j, k=0, c;

    for(i = 0; i < n; i+=4){
        temp = 0;
        for(c = i; c <= i+3; c++){
            for(j = 0; j <= 63; j++){
                if(encoded[c] == Base64[j])
                    index = j;
            }
            temp <<=6 ;
            temp = temp | index;
        }
        for(c = 2; c >= 0; c--){
            int x = (temp >> (8 * c)) & 0x3F;
            result[k++] = 64 + x;
        }
    }
    result[k]='\0';

    return result;
}

int main(){
    char* to_decode;
    to_decode = (char *) malloc(100 * sizeof(char));

    gets(to_decode);

    printf("\nTo Decode: %s", to_decode);

    printf("\nDecoded_Result : %s\n", decoder(to_decode));
    return 0;
}

