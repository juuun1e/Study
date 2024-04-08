# 기존의 방법
num1 = 3

if num1 % 2 ==0:
    result1 = '짝수'
else:
    result1 = '홀수'

print(f'{num1}은 {result1}입니다.')


# if문을 한 줄로 표현
# 짝수라고 해라, 만약 2로 나눈 나머지가 0이면. 그게 아니면 홀수
num2 = 4

result2 = ('짝수' if num2 % 2 == 0 else '홀수')

print(f'{num2}은 {result2}입니다.')