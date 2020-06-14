infile = open("score.txt", "r") #읽기 모드로 파일 객체 생성

outfile = open("avg.txt", "a") #추가 모드로 파일 객체 생성

def average(list): #평균을 구하는 메소드
    sum=0
    for i in range(1,4): 
        sum += int(list[i])
    return sum/(len(list)-1)
    
s = infile.readline() #한 줄씩 읽기
s = s.rstrip() #개행 문자 삭제
list1 = s.split(", ") #split()을 사용하여 list 생성
result1 = list1[0]+"의 평균: "+str(average(list1))+"\n"

outfile.write(result1) #결과값을 outfile에 기록

s = infile.readline()
s = s.rstrip()
list2 = s.split(", ")
result2 = list2[0]+"의 평균: "+str(average(list2))+"\n"

outfile.write(result2)

s = infile.readline()
s = s.rstrip()
list3 = s.split(", ")
result3 = list3[0]+"의 평균: "+str(average(list3))+"\n"

outfile.write(result3)


outfile.close()
infile.close()
