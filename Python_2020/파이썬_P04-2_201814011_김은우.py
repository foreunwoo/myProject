birth=input('생년월일을 "2001-03-01" 형식으로 입력하세요: ')
result=birth.split('-') # split 함수를 써서 '-' 단위로 잘라 리스트를 만듦 
age=2020-int(result[0])+1 # 나이 계산

print('생년월일: ',result[0],'년', result[1],'월', result[2],'일')
print('나이: ',age,'세')
