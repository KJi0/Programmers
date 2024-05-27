#include <string>
#include <vector>
#define MAX 200000000
using namespace std;

int maxval;

bool check(vector<int> stones, int k, int m) {
    //m-1��°������ �ǳԴٰ� ����
    int size = stones.size();
    int cnt = 0;
    for (int i = 0; i < size; i++) {
        if ((stones[i] - (m - 1)) <= 0) {
            cnt++;
            if (cnt == k) return false; //0���ϰ� �������� k�� �ǳμ� ����.
        }
        else {
            //���ӵ��� �ʴ´ٸ� 0���� �ʱ�ȭ
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
        //mid��° ģ���� �ǳ� �� �ִٸ� �ִ񰪰� ��
        if (maxval < mid) maxval = mid;

        //mid���� �� ū ���� �������� �̺� Ž��
        binarySearch(stones, k, mid + 1, right);
    }
    else {
        //mid��° ģ���� �ǳ� �� ���ٸ� mid���� �� ���� �� ���� Ž��
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