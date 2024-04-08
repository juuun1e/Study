# if-elif-else 조건문
# 들여쓰기의 중요성 : 구문의 구분을 들여쓰기로 해서 잘못되었을 때 출력X
money = 2000
if money > 3800:
    print("택시 플렉스!")
elif money > 1250:
    print("그래, 버스를 타는 거야!")
else:
    print("네 주머니 사정으로는 택시 못 타")
    print("오늘은 뚜벅이...")


# for 반복문 - 리스트 안에 있는 요소들을 하나씩 꺼내서 사용
fruits = ['사과', '배', '감', '딸기', '오렌지']

for fruit in fruits:
    print(fruit)

# Quiz. 이름과 나이 출력하기 -> bob 20
person = [
    {'name': 'bob', 'age': 20},
    {'name': 'carry', 'age': 38},
    {'name': 'john', 'age': 7},
    {'name': 'smith', 'age': 17},
    {'name': 'ben', 'age': 27},
    {'name': 'bobby', 'age': 57},
    {'name': 'red', 'age': 32},
    {'name': 'queen', 'age': 25}
]
#for partyPerson in person:
#    name = partyPerson['name']
#    age = partyPerson['age']
#    if age > 20:
#        print(name, age)


# for문 - enumerate, break
for i, partyPerson in enumerate(person):
    name = partyPerson['name']
    age = partyPerson['age']
    print(i, name, age)
    # 2보다 크면 그만해! -> 테스트 할 때 많이 사용한다.
    if i > 2:
        break