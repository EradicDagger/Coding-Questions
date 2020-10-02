#include<iostream>
using namespace std;
int sqrt(int A) {
       int low = 1;
    int high = A/2 + 1;

    if (A <= 1)
    {
        return A;
    }

    while (low < high-1)
    {
        long long mid = (low + high) / 2;
        long long mid2 = mid * mid;
        if (mid2 == A)
        {
            return mid;  //perfect square root
        }
        if (mid2 < A)
        {
            low = mid;
        }
        if (mid2 > A)
        {
            high = mid;
        }
    }
    return low;
}
int main()
{
    int A;
cin>>A;
int val=sqrt(A);
cout<<val;
return 0;
}
