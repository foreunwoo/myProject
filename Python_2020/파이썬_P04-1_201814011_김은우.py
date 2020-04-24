print('### 회원 등록 프로그램 ###')
print('### 0 입력시 입력 종료 ###')

name=[]
while True:
    name.append(input("회원 이름 입력: "))
    if('0' in name): # 리스트에 0이 입력될 경우
        last=len(name)-1 
        name.pop(last) # 리스트의 마지막 인덱스인 0을 제거
        break # 루프를 빠져나옴

print('회원 등록 완료!')
print('회원 명부 출력 (등록순서): ', name)
print('회원 명부 출력 (오름차순): ', sorted(name))
print('회원 명부 출력 (내림차순): ', sorted(name, reverse=True))
