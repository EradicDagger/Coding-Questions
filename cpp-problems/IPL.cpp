#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;

  int p[n];
  for (int i = 0; i < n; i++) {
    cin >> p[i];
  }

  int dp[n] = {0};

  dp[0] = p[0];
  dp[1] = p[0] + p[1];
  dp[2] = max(p[0] + p[1], max(p[1] + p[2], p[2] + p[0]));

  for (int i = 3; i < n; i++) {
    dp[i] = max(dp[i - 1], max(p[i] + dp[i - 2], p[i] + p[i - 1] + dp[i - 3]));
  }

  cout << dp[n - 1] << endl;
}
