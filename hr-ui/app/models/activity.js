// Example model

var mongoose = require('mongoose'),
  Schema = mongoose.Schema;

var activitySchema = new Schema({
    user_name: String,
    activity_type: String,
    hours: String,
    tweek: Number
  }, {
    collection: 'activities'
  }
);

mongoose.model('Activity', activitySchema);
