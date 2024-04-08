# map으로 list의 모든 원소 조작하기
people = [
    {'name': 'bob', 'age': 20},
    {'name': 'carry', 'age': 38},
    {'name': 'john', 'age': 7},
    {'name': 'smith', 'age': 17},
    {'name': 'ben', 'age': 27},
    {'name': 'bobby', 'age': 57},
    {'name': 'red', 'age': 32},
    {'name': 'queen', 'age': 25}
]

# 1차 조작
def check_adult(person):
    if person['age'] > 20:
        return '성인'
    else:
        return '청소년'

# people을 하나하나 돌면서, check_adult에 넣어라!
result = map(check_adult, people)
# return 값을 모아서 리스트로 만들어 출력해라 !
print(list(result))



# 2차 조작
def check_adult(person):
    return '성인' if person['age'] > 20 else '청소년'

result2 = map(check_adult, people)
print(list(result2))



# 3차 조작 - lamda : 훨씬 깔끔하게 정리
# lamda식에서 관용적으로 person이 아닌 x를 많이 사용한다
# people 하나씩 돌면서 person 에다가 넣을 건데, 그 person으로 (’성인’~) 처럼 리턴해라.
result3 = map(lambda person:('성인' if person['age'] > 20 else '청소년'), people)
print(list(result3))



# Filter - map과 아주 유사한데, True인 것만 뽑기!
# x(person)에 age가 20보다 큰 애들만 담겨라~! : 조금 더 직관적
result4 = filter(lambda x: x['age'] > 20, people)
print(list(result4))