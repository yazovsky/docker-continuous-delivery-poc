var express = require('express'),
  router = express.Router(),
  mongoose = require('mongoose'),
  Activity = mongoose.model('Activity');

module.exports = function (app) {
  app.use('/', router);
};

router.get('/', function (req, res, next) {
  Activity.aggregate([
    { $match: { user_name: 'Anton Yazovskiy'} },
    { $group: { _id: '$tweek', user_name: { '$first': '$user_name' }, hours: { $sum: '$hours' } } },
    { $sort: { _id: 1 } }
  ],

    function (err, result) {
      if (err) return next(err);

      var labels = []
      var data = []
      result.forEach(function(val) {
        labels.push(val._id);
        data.push(val.hours)
      })

      res.render('index', {
        'activities': {
          'labels': labels,
          'datasets': [{ 'data': data }]
        }
      });
    }
  );

});
