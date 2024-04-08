# 기존의 방법
a_list = [1, 3, 2, 5, 1, 2]

b_list = []

for a in a_list:
    b_list.append(a*2)

print(b_list)


# for문을 한 줄로 표현
# aa_list 안에 있는 aa를 돌리는데 그 때마다 aa*2를 해서 리스트로 묶어라
aa_list = [1, 3, 2, 5, 1, 2]

bb_list = [aa*2 for aa in aa_list]

print(bb_list)