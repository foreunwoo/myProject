def main():
    password=input('비밀번호 입력: ')
    print('비밀번호 안전도: ', set_password(password))

def set_password(password):
    if(len(password) >= 10): // password의 길이를 받아옴
        return '좋음'
    elif(len(password) >= 5 and len(password) < 10):
        return '보통'
    else:
        return '나쁨'

main()

