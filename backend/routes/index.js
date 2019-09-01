var express = require('express');
var router = express.Router();
const multer = require('multer');


var storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, './uploads')
  },
  filename: function (req, file, cb) {
    console.log('POST : ' + file.originalname)
    cb(null, 'userData')
  }
})

var upload = multer({ dest: 'uploads/', storage: storage })
var result;

router.post('/upload', upload.single('csv'), function (req, res, next) {
  var exec = require('child_process').exec;
  exec('java -jar javaJson.jar', function callback(err, stdout, stderr) {
    if (err) {
      res.send("{'state':'fail'")
    } else {
      result = JSON.parse(stdout);
      var summary = { 'state': 'success', 'nodes': [], 'edges': [] };
      result.data.forEach(function (edge) {
        var start = edge.road_start
        if (!summary.nodes.some(function (node) {
          if (node === start) {
            return true;
          }
        })) {
          summary.nodes.push(start)
        }
        var end = edge.road_end
        if (!summary.nodes.some(function (node) {
          if (node === end) {
            return true;
          }
        })) {
          summary.nodes.push(end)
        }
        var build = []
        edge.opt_table.forEach(function(value){
          if(value!==0){
            build.push(true)
          }else{
            build.push(false)
          }
        })
        var values = [];
        edge.road_flag[0].forEach(function(obj){
          values.push(obj[0].density);
        })
        summary.edges.push({'from':start, 'to':end, 'build':build, 'values':values})
      })
      res.send(summary)
    }
  })
})

router.get('/result', function (req, res, next) {
  var from = req.query.from
  var to = req.query.to
  console.log(from, to)
  res.header("Content-Type", 'application/json');
  res.sendfile("./json/dummy.json")
})

// router.get('/test', function (req, res, next) {
//   var exec = require('child_process').exec;
//   exec('java Test', function callback(err, stdout, stderr) {
//     if (err) {
//       console.error(err);
//     } else {
//       var result = JSON.parse(stdout);
//       res.send(result)
//       // if (result.state === "success") {
//       //   res.send(result.data)
//       // } else {
//       //   res.send(false)
//       // }
//     }
//   })
// })

module.exports = router;
