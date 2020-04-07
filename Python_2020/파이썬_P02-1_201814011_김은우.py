import turtle
t=turtle.Pen()
n=int(input("몇 각형을 그릴까요? "))
length=int(input("한 변의 길이는 얼마인가요? "))

for i in range(n): // n각형의 n만큼 반복
    t.forward(length) 
    t.right(360/n) // 360을 n으로 나눈 값만큼 회전함
