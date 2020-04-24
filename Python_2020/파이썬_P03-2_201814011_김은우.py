def add(a, b): 
    return a + b

def substract(a, b):
    return a - b

def multiply(a,b):
    return a * b

def divide(a,b):
    return a / b

def calculation(a,b,cal): # 연산 입력 시 실행될 메소드
    intValue = 0

    if cal ==  "1":
        intValue = add(a,b)
    elif cal == "2":
        intValue = substract(a,b)
    elif cal == "3":
        intValue = multiply(a,b)
    elif cal == "4":
        intValue = divide(a,b)
            
    return intValue

def main():
    print('=== 1:덧셈 2:뺄셈 3:곱셈 4:나눗셈 0:종료 ===')
    while True:
        cal = input("연산 입력: ")
        if cal == "0": # 0 입력 시 루프를 빠져나옴
            print('연산 종료')
            break
        a = float(input("정수 입력: "))
        b = float(input())
        
        intValue = calculation(a, b, cal)
        print('연산 결과: ', intValue)

main()





