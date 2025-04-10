## 문제 설명
**문제 번호:** p138476

**문제 내용:**
- 주어진 정수 배열 `tangerine`에서 종류별로 최소한 `k`개 이상의 귤을 고를 수 있는 최소한의 종류 수를 구하는 문제입니다.

## 풀이 과정
1. 배열 `tangerine`에 있는 귤의 종류별 개수를 세기 위해 `HashMap`을 사용합니다.
2. 귤의 종류별 개수를 내림차순으로 정렬합니다.
3. 가장 많은 귤부터 하나씩 선택해가며, `k`개 이상을 고를 때까지 종류 수를 셉니다.

## 코드 설명
- `HashMap`을 사용해 귤의 종류별 개수를 세고, 이를 `List`로 변환하여 내림차순으로 정렬합니다.
- `k`개 이상의 귤을 고르기 위해 가장 많이 나오는 귤부터 차례대로 선택합니다.
- 선택된 귤의 종류 수가 최종 답이 됩니다.

## 예시
- 입력: [1, 3, 2, 5, 4, 5, 2, 3], k = 6
- 출력: 3