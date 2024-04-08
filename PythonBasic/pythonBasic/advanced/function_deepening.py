# 함수 심화
# 직접 쓰는 것보단 알고 있으면 내장함수 등을 사용할 때 도큐먼트를 읽는 데 도움
def cal(a,b):
    return a+2*b

result1 = cal(1, 2)
print(result1)           # (2*2)+1 = 5


# 지정 가능 -> 순서 무관
def cal(c,d):
    return c+2*d

result2 = cal(d=2,c=1)
print(result2)           # (2*2)+1 = 5



# 특정 매개변수에 디폴트 값 지정 가능
# = 언제? 값이 안 들어왔을 때, 넣어주면 넣어준 값 나옴
def cal(e,f=2):
    return e+2*f

result3 = cal(1,3)
print(result3)           # (2*3)+1 = 7



# 입력값의 개수를 무제한으로 리스트로 받아 사용하는 법
def call_names(*args):
    for name in args:
        print(f'{name}야 밥먹어라~')

call_names('철수','영수','희재')



# 키워드 인수를 여러 개 받는 방법
# dictionary로 그대로 사용할 수 있게 반환
def get_kwargs(**kwargs):
    print(kwargs)

get_kwargs(name='bob')
get_kwargs(name='john', age='27')
