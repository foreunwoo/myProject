sum=0
answer=input("sum 프로그램을 시작하시겠습니까? ") # y 입력시 프로그램 시작

while answer=='y' or answer=='Y': # 대소문자 둘 다 가능하게
    n=int(input("숫자를 입력하세요: "))
    sum += n
    answer=input("sum 프로그램을 계속하시겠습니까?(Y/N) ")   
    if answer=='n' or answer=='N': # n 입력시 총합 출력 후 반복문을 빠져나옴
        print("합은",sum)
        break
