# 순서를 지키는 list
a_list = ['사과',546,['배','참외'],True]
print(a_list)       # ['사과', 546, '감', True]
print(a_list[0])    # 사과
print(a_list[1])    # 546
print(a_list[2])    # ['배','참외']
print(a_list[2][1]) # 참외
print(a_list[3])    # True

# list에 배열 추가하기
add_list = [ 2, 5, 3, 2, 6 ]
add_list.append(99)
print(add_list)      #[ 2, 5, 3, 2, 6, 99 ]


# list 다루기 : 문자열에서 했던 것들 똑같이 적용 가능
test_list = [ 3, 4, 7, 6, 5 ]
test1 = test_list[-1]
test2 = test_list[:3]
test3 = len(test_list)
print(test1, test2, test3)

# list 정렬하기
add_list.sort()               # 순서대로
print(add_list)               # [2, 2, 3, 5, 6]
test_list.sort(reverse=True)  # 역순으로
print(test_list)              # [7, 6, 5, 4, 3]

# 리스트 안에 있는지 확인하기
a = [2, 1, 4, "2", 6]
print(1 in a)      # True
print("1" in a)    # False
print(0 not in a)  # True


# 순서가 없고 쌍으로 이루어진 딕셔너리
d_dict = { 'name':'baobob', 'age': 34, 'friend' : ['Arien', 'Rydia']}
print(d_dict['name'])
print(d_dict['friend'])
print(d_dict['friend'][0])
print(d_dict['friend'][1])

# 딕셔너리 값 추가하기
d_dict['height'] = 178
print(d_dict)

# 딕셔너리 안에 해당 키가 존재하는지 확인하기
print('height' in d_dict)  # True
print('Sex' in d_dict)     # False


# 리스트와 딕셔너리의 조합
people1 = [
    { 'name':'baobob', 'age': 34 },
    { 'name':'orange', 'age': 27 }
]

print(people1)
print(people1[1])
print(people1[1]['age'])


# Quiz. ‘smith’의 ‘science’점수를 구하시오.
people = [
    {'name': 'bob', 'age': 20, 'score':{'math':90,'science':70}},
    {'name': 'carry', 'age': 38, 'score':{'math':40,'science':72}},
    {'name': 'smith', 'age': 28, 'score':{'math':80,'science':90}},
    {'name': 'john', 'age': 34, 'score':{'math':75,'science':100}}
]
print(people[2]['score']['science'])
