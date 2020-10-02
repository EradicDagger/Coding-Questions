#include <stdio.h>
#include <limits.h>


void compare (int a) {
	if ((a+1) > a)
		printf("%d > %d\n", (a+1), a);
	else
		printf("%d <= %d\n", (a+1), a);
}

int main () {
	compare(1);
	compare(INT_MAX);
}
