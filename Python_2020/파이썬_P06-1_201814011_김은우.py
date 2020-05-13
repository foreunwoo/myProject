class Employ:
    def __init__(self, name, year, status):
        self.__name = name
        self.__year = year
        self.__status = status

    def getName(self):
        return self.__name

    def setName(self, name):
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
        if self.__status == '학사':
            return 3000 + self.__year*100
        elif self.__status == '석사':
            return 3500 + self.__year*100

    def show(self):
