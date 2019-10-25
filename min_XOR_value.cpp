void bubble(int arr[], int size)
{
	int i = 0;
	int temp;
	int again = 1;
	int iter = size - 1;
	do {
		again = 0;
		i = 0;
		for(; i < iter; ++i)
			{
				if (arr[i + 1] < arr[i])
					{
						again = 1;
						temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
					}
			}
		--iter;
	} while (again);
}
int min(int a,int b)
{
    return (a<b)?a:b;
}
int findMinXor(int* a, int size) {
   int MIN,c,i=0;
  bubble(a,size);

    int minXor = INT_MAX;
    int val = 0;

        while(i<size-1)
    {
        val = a[i]^a[i+1];
        minXor = min(minXor, val);
        i++;
    }

    return minXor;
}
