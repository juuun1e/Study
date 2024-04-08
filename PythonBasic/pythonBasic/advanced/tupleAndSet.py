# 리스트와 튜플의 차이
a_list = ['apple','banana','melon']
a_list[2] = 'watermelon'
print(a_list)

a_tuple = ('apple','banana','melon')
#a_tuple[2] = 'watermelon' -> 불변형이라 변경 불가, TypeError 발생
print(a_tuple[0])
print(a_tuple[1])
print(a_tuple[2])




# 집합 set
a = [1, 2, 3, 4,  3, 2, 3, 2, 1, 4, 7, 8, 1]

a_set = set(a)
print(a_set)


# 교집합과 합집합
x = ['사과','감','수박','참외','딸기']
y = ['사과','멜론','청포도','토마토','참외']

x_set = set(x)
y_set = set(y)

print(x_set & y_set)  # 교집합
print(x_set | y_set)  # 합집합


# 차집합
student_a = ['물리2','국어','수학1','음악','화학1','화학2','체육']
student_b = ['물리1','수학1','미술','화학2','체육']

aa_set = set(student_a)
bb_set = set(student_b)

print(aa_set - bb_set)  # 차집합