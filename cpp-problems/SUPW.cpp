#include <algorithm>
#include <cmath>
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

  int min_val;
  min_val = min(p[1], p[2]);

  dp[2] = min(p[0], min_val);

  for (int i = 3; i < n; i++) {
    min_val = min(dp[i - 3] + p[i - 2], dp[i - 2] + p[i - 1]);
    dp[i] = min(dp[i - 1] + p[i], min_val);
  }

  cout << dp[n - 1] << endl;
}
