money=int(input('금액 : '))
cash={} # 화폐단위를 저장할 dictionary
types=0 # 종류
count=0 # 화폐 갯수

a=int(money/50000) # 금액에서 나눈 몫을 대입, 사실상 화폐 갯수
money-=50000*a 
cash[50000]=a
if a>0: # 화폐 갯수가 0보다 클 경우
    types+=1 
    count+=a
    
a=int(money/10000)
money-=10000*a
cash[10000]=a
if a>0:
    types+=1
    count+=a

a=int(money/5000)
money-=5000*a
cash[5000]=a
if a>0:
    types+=1
    count+=a

a=int(money/1000)
money-=1000*a
cash[1000]=a
if a>0:
    types+=1
    count+=a

a=int(money/500)
money-=500*a
cash[500]=a
if a>0:
    types+=1
    count+=a

a=int(money/100)
money-=100*a
cash[100]=a
if a>0:
    types+=1
    count+=a

a=int(money/50)
money-=50*a
cash[50]=a
if a>0:
    types+=1
    count+=a

a=int(money/10)
money-=10*a
cash[10]=a
if a>0:
    types+=1
    count+=a

a=int(money/5)
money-=5*a
cash[5]=a
if a>0:
    types+=1
    count+=a

a=int(money/1)
money-=1*a
cash[1]=a
if a>0:
    types+=1
    count+=a
    

print(cash)
print('총 ',types,'종류 ',count,'개 필요')

    
