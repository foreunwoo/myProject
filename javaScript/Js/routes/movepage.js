const express = require('express');
const router = express.Router();

router.get('/', (req, res, next)=>{
    res.render('movepage', {a:'movepage'});
}); //요청경로, 응답경로, 다음경로

module.exports = router;