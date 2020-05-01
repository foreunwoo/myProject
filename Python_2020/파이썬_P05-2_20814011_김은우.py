dict={} # 사전

while True:
    e_word=input('영어 단어: ')
    
    if e_word.isspace(): # 공백을 입력할 경우 사전 리턴 후 빠져나옴
        print(dict)
        break
    
    if dict=={}: # 사전이 비어 있을 경우 추가
        print('사전이 비어 있습니다.')
        print('단어를 추가합니다.')
        k_word=input('한글 단어: ')
        dict[e_word] = k_word
        continue

    if e_word not in dict: # 단어가 등록되어 있지 않을 경우 추가
        print(e_word, '단어가 등록되어 있지 않습니다.')
        print('단어를 추가합니다.')
        k_word=input('한글 단어: ')
        dict[e_word] = k_word
        continue
    
    
