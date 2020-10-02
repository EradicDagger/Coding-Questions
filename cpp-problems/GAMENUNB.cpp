#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int test;
  cin >> test;
  while (test--) {
    long long int n, k;
    cin >> n >> k;
    long long int card[n], freq[n], turn[k];
    long long int total_cards = 0;
    long long int aux[1000001] = {0};
    long long int total_card = 0;
    for (long long int i = 0; i < n; i++) {
      cin >> card[i];
    }

    for (long long int i = 0; i < n; i++) {
      cin >> freq[i];
    }

    for (long long int i = 0; i < k; i++) {
      cin >> turn[i];
    }

    for (long long int i = 0; i < n; i++) {
      aux[card[i]] += freq[i];
      total_cards += freq[i];
    }

    long long int start = 0, end = 1000000;

    for (long long int i = 0; i < k; i++) {
      long long int left_cards = total_cards - turn[i];
      long long int count = 0;
      if (i % 2 == 0) {
        for (long long int j = start; j <= end; j++) {
          count += aux[j];
          if (count == left_cards) {
            start = j + 1;
            break;
          } else if (count > left_cards) {
            aux[j] = count - left_cards;
            start = j;
            break;
          }
        }
      } else {
        for (long long int j = end; j >= start; j--) {
          count += aux[j];
          if (count == left_cards) {
            end = j - 1;
            break;
          } else if (count > left_cards) {
            aux[j] = count - left_cards;
            end = j;
            break;
          }
        }
      }

      total_cards = turn[i];
    }

    long long int res = 0;

    for (int i = start; i <= end; i++) {
      // cout << i << aux[i] << " ";
      res += i * aux[i];
    }

    // cout << endl;

    cout << res << endl;
  }
  return 0;
}
