from tkinter import *

def login(): # 로그인
    if inputId.get() == dic['id'] and inputPw.get() == dic['pw']: # id, password 체크
        label["text"] = "로그인 성공"
        
    elif inputId.get() != dic['id']: # id가 맞지 않을 경우
        label["text"] = "로그인 실패 (ID 오류)"
        
    elif inputPw.get() != dic['pw']: # password가 맞지 않을 경우
        label["text"] = "로그인 실패 (PW 오류)"

def reset(): # 초기화
    label["text"] = "로그인 하세요"
    inputId.delete(0,"end")
    inputPw.delete(0,"end")

dic = {'id':'김은우', 'pw':'1234'} # id와 password가 들어있는 딕셔너리

window = Tk()

label = Label(window,
            text="로그인 하세요",
            fg="black",
            bg="pink"
            )
label.pack(ipadx=100, padx=0)

Label(window, text="ID를 입력하세요").pack()		
inputId = Entry(window)
inputId.pack(ipadx=70, padx=0)

Label(window, text="PW를 입력하세요:").pack()
inputPw = Entry(window, show="*")
inputPw.pack(ipadx=70, padx=0)

loginBtn = Button(window, text="로그인", command=login) # login 콜백 함수 등록
resetBtn = Button(window, text="초기화", command=reset) # reset 콜백 함수 등록

loginBtn.pack(side=LEFT, ipadx=50)
resetBtn.pack(side=LEFT, ipadx=50)

window.mainloop()
