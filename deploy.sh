#!/usr/bin/sh


echo "start deployment"


export JAVA_HOME=/usr/local/java
ulimit -n 200000

#mkdir source
#cd source


#git clone http://git.adpdigital.com/pishkhan3/ouc.git
#git clone http://git.adpdigital.com/pishkhan3/oms.git
#git clone http://git.adpdigital.com/pishkhan3/obs.git
#git clone http://git.adpdigital.com/pishkhan3/aaa.git
#git clone http://git.adpdigital.com/pishkhan3/admin_aaa.git


cd /root/source/ouc
git config --global credential.helper store
git pull
mvn clean install -DskipTests

cd /root/source/oms/DAO
git config --global credential.helper store
git pull
mvn clean install -DskipTests

cd /root/source/oms/Message
git config --global credential.helper store
git pull
mvn clean install -DskipTests

cd /root/source/obs
git config --global credential.helper store
git pull
mvn clean install -DskipTests

cd /root/source/oms
git config --global credential.helper store
git pull
mvn clean install -DskipTests

cd /root/source/aaa
git config --global credential.helper store
git pull
mvn clean install -DskipTests

cd /root/source/admin_aaa
git config --global credential.helper store
git pull
mvn clean install -DskipTests

#mkdir /root/jars_backup
cd /root/jars
tar -czvf /root/jars_backup/jars_`date '+%Y_%m_%d__%H_%M_%S'`.tar.gz *
find /root/jars/ -name *.jar | xargs rm -f
rm -f /root/tars/*

#mkdir /root/jars
#mkdir /root/jars/ouc
#mkdir /root/jars/oms
#mkdir /root/jars/oms/dependency-jars
#mkdir /root/jars/obs
#mkdir /root/jars/obs/dependency-jars
#mkdir /root/jars/aaa
#mkdir /root/jars/aaa/dependency-jars
#mkdir /root/jars/admin_aaa
#mkdir /root/jars/admin_aaa/dependency-jars


find /root/source/ouc -name *.jar -type f -not -path '*/dependency-jars/*' | xargs cp -t /root/jars/ouc/
find /root/source/oms -name *.jar -type f -not -path '*/dependency-jars/*' | xargs cp -t /root/jars/oms/
find /root/source/aaa -name *.jar -type f -not -path '*/dependency-jars/*' | xargs cp -t /root/jars/aaa/
find /root/source/admin_aaa -name *.jar -type f -not -path '*/dependency-jars/*' | xargs cp -t /root/jars/admin_aaa/
find /root/source/obs -name *.jar -type f -not -path '*/dependency-jars/*' -not -name '*DTO*' | xargs cp -t /root/jars/obs/

find /root/source/obs -name *.jar -type f -path '*/dependency-jars/*' -not -path '*/Core/*' | xargs cp -nt  /root/jars/obs/dependency-jars/
find /root/source/oms -name *.jar -type f -path '*/dependency-jars/*' | xargs cp -nt  /root/jars/oms/dependency-jars/
find /root/source/aaa -name *.jar -type f -path '*/dependency-jars/*' | xargs cp -nt  /root/jars/aaa/dependency-jars/
find /root/source/admin_aaa -name *.jar -type f -path '*/dependency-jars/*' | xargs cp -nt  /root/jars/admin_aaa/dependency-jars/

#mkdir /root/tars
cd /root/jars/obs/
tar -czvf /root/tars/obs.tar.gz *

cd /root/jars/oms/
tar -czvf /root/tars/oms.tar.gz *

cd /root/jars/aaa
tar -czvf /root/tars/aaa.tar.gz *

cd /root/jars/admin_aaa/
tar -czvf /root/tars/admin_aaa.tar.gz *





