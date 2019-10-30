#include <iostream>  
void count(int n, int max)
{
std::cout <<n<<" ";
if(n < max) count(n+1, max);
std::cout << n<<" ";
}
int main()
{
int n = 100;
count(0, n);
}
