#include <string>
#include <vector>
#define MAX 200000000
using namespace std;

int maxval;

bool check(vector<int> stones, int k, int m) {
    //m-1번째까지는 건넜다고 가정
    int size = stones.size();
    int cnt = 0;
    for (int i = 0; i < size; i++) {
        if ((stones[i] - (m - 1)) <= 0) {
            cnt++;
            if (cnt == k) return false; //0이하가 연속으로 k면 건널수 없다.
        }
        else {
            //연속되지 않는다면 0으로 초기화
            cnt = 0;
        }
    }
    return true;
}


void binarySearch(vector<int> stones, int k, int left, int right) {
    if (left > right) return;

    int mid = (left + right) / 2;
    bool res = check(stones, k, mid);

    if (res) {
        //mid번째 친구가 건널 수 있다면 최댓값과 비교
        if (maxval < mid) maxval = mid;

        //mid보다 더 큰 값이 가능한지 이분 탐색
        binarySearch(stones, k, mid + 1, right);
    }
    else {
        //mid번째 친구가 건널 수 없다면 mid보다 더 작은 값 범위 탐색
        binarySearch(stones, k, left, mid - 1);
    }
}


int solution(vector<int> stones, int k) {
    int answer = 0;

    maxval = 0;
    binarySearch(stones, k, 1, MAX);
    answer = maxval;

    return answer;
}