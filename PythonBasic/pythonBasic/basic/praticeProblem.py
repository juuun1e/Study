# Q. 리스트에서 짝수만 출력하는 함수 만들기
num_list = [1, 2, 3, 6, 3, 2, 4, 5, 6, 2, 4]
for num in num_list:
   if num % 2 == 0:
        print(num)

print('\n')

# Q. 리스트에서 짝수의 개수를 출력하기
num_list = [1, 2, 3, 6, 3, 2, 4, 5, 6, 2, 4]
count = 0
for num in num_list:
    if num % 2 == 0:
        count += 1
print(count)

print('\n')


# Q. 리스트 안에 있는 모든 숫자 더하기
num_list = [1, 2, 3, 6, 3, 2, 4, 5, 6, 2, 4]
sum = 0
for num in num_list:
    sum += num
print(sum)

print('\n')


# Q. 리스트 안에 있는 자연수 중 가장 큰 숫자 구하기
num_list = [1, 2, 3, 6, 3, 2, 4, 5, 6, 2, 4]
max = 0
for num in num_list:
    if max < num:
        max = num
print(max)