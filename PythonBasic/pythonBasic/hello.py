print('hello Python')

# 변수선언과 사칙연산
a = 3       # a박스 안에 3을 넣는다.
b = 2       # b박스 안에 2를 넣는다.
print(a+b)  # a+b = 3+2 = 5
print(a-b)  # a-b = 3-2 = 1
print(a*b)  # a*b = 3*2 = 6
print(a/b)  # a/b = 3/2 = 1.5
print(a%b)  # a%b = 3%2 = 1
print(a**b) # a^b = 3^2 = 3*3 = 9




# 다양한 자료형
c = 11.5
print(c)

d = 'juuun1e'
print(d)

e = False   #True, False 소문자로 쓰면 변수명이라고 인식해서 에러 발생
print(e)

f = ( 3 > 2 )
print(f)




# 문자열 다루기
# 변수와 구분하기 위해 '' 또는 ""로 감싸줘야 한다.
x = 2
y = x
z = 'x'
print(y,z)

j = '2'
k = 'hello'
print(j+k)  # 2hello

l = 2
m = 'hello'
#print(l+m)  # complie error

n = '2'
o = '2'
print(n+o) # 22

p = '2'
q = str(2) #정수를 문자열로 형변환
print(p+q) # 22




# 문자열 길이 구하기
text = 'abcdefg'
length = len(text)
print(length)

# 문자열 자르기
frontPart = text[:3]  # 앞에서 부터 3글자 자르기
backPart = text[3:]   # 3번째 글자 뒤에서 부터 3글자 자르기
print(frontPart, backPart)      # abc, defg

# 문자열 범위 출력
result = text[3:7] # 3번째 다음 글자부터 7번째 글자까지 출력
print(result)      # defg

# 문자열 더하기
first_name = 'jiwoo'
last_name = 'lee'
print(first_name+last_name)

# 기준점 두고 문자열 자르기
myEmail = 'dlwldn0922@gmail.com'
cutting1 = myEmail.split('@')   # '@' 기준으로 문자열이 나뉜다
print(cutting1)                 # ['dlwldn0922', 'gmail.com']

cutting2 = myEmail.split('@')[1].split('.')  # '@' 나뉜 것 중 두번째 값에서 '.' 기준으로 자르기
print(cutting2)                              # ['gmail', 'com']

cutting3 = myEmail.split('@')[1].split('.')[0]  # '.' 기준으로 나뉜 것 중 첫번째 값
print(cutting3)                                 # gmail




# Quiz 01. gmail 에서 'gma' 만 구하기
gmail = cutting3[:3]
print(gmail)

# Quiz 02. 지역번호만 출력하기
phone = '02-123-1234'
seoul1 = phone[:2]
seoul2 = phone.split('-')[0]
print(seoul1, seoul2)