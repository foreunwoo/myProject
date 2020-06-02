import math

class Polygon:
    __length = 0 # private로 length 변수 선언 후 초기화

    def __init__(self, length):
        self.__length = length

    def setLen(self, length): # 설정자
        self.__length = length

    def getLen(self): # 접근자
        return self.__length

    def area(self):
        return

    def peri(self):
        return

    def __str__(self): 
        return '종류: '+ type(self).__name__+'\n' +'길이: '+str(self.__length)+'\n'+ '넓이: '+str(self.area())+'\n'+ '둘레: '+str(self.peri())+'\n'

class Triangle(Polygon):
    def __init__(self, length): 
        super().__init__(length) # 부모 클래스 생성자 호출

    def area(self): # area 메소드 오버라이드
        return (math.sqrt(float(3))/4)*self.getLen()*self.getLen()

    def peri(self): # peri 메소드 오버라이드
        return self.getLen()*3

class Square(Polygon):
    def __init__(self, length):
        super().__init__(length)

    def area(self):
        return self.getLen()*self.getLen()

    def peri(self):
        return self.getLen()*4


t1 = Triangle(10) # Triangle 객체 생성
s1 = Square(20) # Square 객체 생성
    
print(t1)
print(s1)

