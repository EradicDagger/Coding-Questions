#include <bits/stdc++.h>
using namespace std;
// #define int long long
#define pi (3.141592653589)
#define mod 1000000007
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

int kadane(int a[], int n)
{
    int current_sum = 0;
    int best_sum = 0;
    for (int i = 0; i < n; i++)
    {
        current_sum += a[i];
        if (best_sum < current_sum)
        {
            best_sum = current_sum;
        }
        if (current_sum < 0)
        {
            current_sum = 0;
        }
    }
    return best_sum;
}

int main()
{
    int a[] = {1, 2, -7, 6, 7, -1};
    int n = sizeof(a) / sizeof(a[0]);
    kadane(a, n);
    return 0;
}
