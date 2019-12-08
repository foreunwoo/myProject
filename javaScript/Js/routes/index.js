const express = require('express'); //익스프레스를 가져온다
const router = express.Router();// 라우터라는 변수에 express안에 라우터()를 가져와 넣어줌

router.get('/',(req, res, next)=>{ //'/'경로로 get 요청이 보내졌ㅇ르 경우에 이 미들웨어가 실행된다
res.render('index', {a:'안녕'}); //파일 렌더링(app.js에 view 기본 확장자가 ejs이므로 .ejs는 생략 가능.)
});

module.exports = router; //이 라우터를 module.exports로 내보내준다.