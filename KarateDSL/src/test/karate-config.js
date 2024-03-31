function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    baseURl = 'https://gorest.co.in',
    authPassword: '20298c6944fb2b8a2a7db37ca7a59ac27b5c50018c0d411c1ef7420ee90a1940'
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env == 'e2e') {
    // customize
  }
  return config;
}