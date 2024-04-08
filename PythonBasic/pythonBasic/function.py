# 반복적으로 사용하는 코드에 이름을 붙인 함수 hello()
def hello():
    print('안녕!')
    print('요새 날씨가 정말 좋아')

hello()
hello()
print('\n')


# 함수의 사용
def sum(a,b):
    print('더하기를 하셨군요!')
    return a+b

result = sum(1,2)
print(result)

print('\n')


# 조건문
def bus_rate(age):
    if age > 65:
        print('사랑합니다')
    elif age > 20:
        print('성인이군요!')
    else:
        print('청소년입니다')

bus_rate(35)
bus_rate(11)

def bus_rate(age):
    if age > 65:
        return 0
    elif age > 20:
        return 1450
    else:
        return 1150

myrate = bus_rate(17)
print(myrate)

print('\n')


# Q. 주민등록번호를 입력받아 성별을 출력하는 함수 만들기
def check_gender(pin):
    num = pin.split('-')[1][0]
    print(num)

    if int(num) % 2 == 0:
        print ('Fmale')
    else:
        print ('male')

check_gender('151001-1012345')
check_gender('151001-2012345')
check_gender('151001-4012345')


