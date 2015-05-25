var path = require('path'),
    rootPath = path.normalize(__dirname + '/..'),
    env = process.env.NODE_ENV || 'development';

var config = {
  development: {
    root: rootPath,
    app: {
      name: 'hr-ui'
    },
    port: 3000,
    db: 'mongodb://mongo/hr'
  },

  test: {
    root: rootPath,
    app: {
      name: 'hr-ui'
    },
    port: 3000,
    db: 'mongodb://localhost/hr-ui-test'
  },

  production: {
    root: rootPath,
    app: {
      name: 'hr-ui'
    },
    port: 3000,
    db: 'mongodb://localhost/hr-ui-production'
  }
};

module.exports = config[env];
