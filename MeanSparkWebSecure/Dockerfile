# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8

 

WORKDIR /usrapp/bin

 

ENV PORT 6000

 

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
COPY /keystores /usrapp/bin/keystores

 

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.meansparkwebsecure.MeanSparkService"]
