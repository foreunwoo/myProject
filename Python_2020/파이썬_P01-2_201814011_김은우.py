score=int(input("점수를 입력하세요. ")) # 점수 입력

if(score>=95): # 조건문에 맞는 학점을 출력
    print("A+")
else:
    if(score>=90):
        print("A0")
    else:
        if(score>=85):
            print("B+")
        else:
            if(score>=80):
                print("B0")
            else:
                if(score>=75):
                    print("C+")
                else:
                    if(score>=70):
                        print("C0")
                    else:
                        if(score>=65):
                            print("D+")
                        else:
                            if(score>=60):
                                print("D0")
                            else:
                                print("F")
            
        
    
    
    
