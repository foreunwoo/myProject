const express = require('express'); //express 모듈을 import 하는 거라고 보면 됨
const path = require('path');
const logger = require('morgan');

const indexRouter = require('./routes/index');
const moveRouter = require('./routes/movepage');


const app = express(); //여기에 express가 쓰는 기능이 들어간다고 생각하면 됨

app.set('views', path.join(__dirname, 'views')); //html 같은 파일들의 기본 경로를 'views'라는 폴더로 설정하는 것
app.set('view engine', 'ejs'); //템플릿 엔진을 ejs로 설정

app.use(logger('dev'));
app.use(express.static(path.join(__dirname, 'public'))); //정적 파일은 기본적으로 'public'에서 찾기 시작
app.use(express.json()); //json 파일 읽을 때 쓰겠다
app.use(express.urlencoded({extended:false})); //url이 들어오면 기본적으로 utf인코딩을 하겠다

app.use('/',indexRouter);
app.use('/movepage', moveRouter);

app.use((req, res, next) =>{ //에러 처리 미들웨어라고 함
    const err = new Error('Not found'); 
    err.status = 404; //내보내고자 한 응답이 (서버에 파일 존재x, 경로 설정 오류)
    next(err);
});

app.use((req, res, next) =>{
    res.locals.message = err.message;
    res.status(err.status||500); //서버 에러 컴파일 오류
});

app.listen(8001,()=> {
console.log('8001번 포트에서 서버 대기 중입니다.');
});

