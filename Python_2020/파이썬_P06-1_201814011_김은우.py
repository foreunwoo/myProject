class Employ:
    def __init__(self, name, year, status): # 생성자를 정의
        self.__name = name
        self.__year = year
        self.__status = status

    def getName(self): # name에 대한 접근자
        return self.__name 

    def setName(self, name): # name에 대한 설정자
        self.__name = name

    def getYear(self):
        return self.__year

    def setYear(self, year):
        self.__year = year

    def getStatus(self):
        return self.__status

    def setStatus(self, status):
        self.__status = status

    def salary(self): 
        if self.__status == '학사': # 학사일 경우
            return 3000 + self.__year*100
        elif self.__status == '석사': # 석사일 경우
            return 3500 + self.__year*100
        elif self.__status == '박사': # 박사일 경우
            return 4000 + self.__year*100

    def show(self): 
        print('이름:', self.getName()) # getName으로 name 값에 접근
        print('연차:', self.getYear())
        print('학위:', self.getStatus())
        print('연봉:', self.salary(),'만원\n')


e1 = Employ('브라보', 10, '박사')
e1.show()

e1.setName('부싯돌') # setName으로 name 설정
e1.setYear(5) # setYear로 year 설정
e1.setStatus('석사') # setStatus로 status 설정
e1.show()

e2 = Employ('홍길동', 2, '학사')
e2.show()






    
