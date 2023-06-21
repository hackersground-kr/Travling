const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '12345678',
  database: 'food' // 스키마 이름 변경
});

connection.connect((err) => {
  if (err) {
    throw err;
  }
  console.log('MySQL 데이터베이스에 연결되었습니다.');
});

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/food/:disease/:danger', (req, res) => {
  const disease = req.params.disease;
  const danger = req.params.danger;

  let resDict = {
    "items": {
      
    }
  }

  let tableName;

  if (disease === 'dm') {
    tableName = 'dm';
  } else if (disease === 'hbp') {
    tableName = 'hbp';
  } else if (disease === 'mi') {
    tableName = 'mi';
  } else {
    res.send('유효하지 않은 질병입니다.');
    return;
  }

  const query = `SELECT foodname, foodcontent, foodetc FROM ${tableName} WHERE danger = ${danger}`;
  connection.query(query, (err, result) => {
    if (err) {
      throw err;
    }

    if (result.length === 0) {
      res.send('해당 위험도에 대한 음식을 찾을 수 없습니다.');
    } else {
      res.send({ "items": result }); // 모든 결과를 JSON 형식으로 응답
    }
  });
});

app.listen(port, () => {
  console.log(`서버가 http://localhost:${port} 에서 실행 중입니다.`);
});
