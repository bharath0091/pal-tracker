 cf login : asks for login email and psw, it selects the org, space and target(the api endpoint spcicific to your foundation)
 cf push pal-tracker -p build/libs/pal-tracker.jar --random-route
 
 http://pal-tracker-boring-dingo.cfapps.io/