#!/usr/bin/sh

echo "start deployment"

export JAVA_HOME=/usr/local/java
ulimit -n 200000

ROOT_PATH="/root"
GIT_URL="http://git.adpdigital.com/pishkhan3"

SOURCE_PATH="$ROOT_PATH/source"
JARS_PATH="$ROOT_PATH/jars"
JAR_BACKUP_PATH="$ROOT_PATH/jars_backup"
TAR_PATH="$ROOT_PATH/tars"

declare -a SRC_PATH=(
  ouc
  oms/DAO
  oms/Message
  obs
  oms
  aaa
  admin_aaa
)
declare -a JAR_PATH=(
  ouc
  obs
  oms
  aaa
  admin_aaa
)

create_folder_structure() {
  echo "kdir $SOURCE_PATH"
  echo "kdir $JAR_BACKUP_PATH"
  echo "kdir $TAR_PATH"
  for i in "${JAR_PATH[@]}"; do
    echo "mkdir $JARS_PATH/$i"
    echo "mkdir $JARS_PATH/$i/dependency-jars"
  done

}

git_clone() {
  cd $SOURCE_PATH
  for i in "${JAR_PATH[@]}"; do
    echo "git clone $GIT_URL/$i.git"
  done
}

git_pull() {
  echo "Start pulling all projects ..."
  for i in "${SRC_PATH[@]}"; do
    echo "cd $SOURCE_PATH/$i"
    echo "git config --global credential.helper store"
    echo "git pull"
  done

}
maven_package() {
  echo "Start packaging all projects ..."
  for i in "${SRC_PATH[@]}"; do
    echo "cd $SOURCE_PATH/$i"
    echo "mvn clean package install -DskipTests"
  done
}
backup_jars() {
  echo "echo "Start backup jars ...""
  echo "cd $JARS_PATH"
  echo "tar -czvf $JAR_BACKUP_PATH/jars_$(date '+%Y_%m_%d__%H_%M_%S').tar.gz *"
}
clear_jar_tar() {
  echo "find $JARS_PATH/ -name *.jar | xargs rm -f"
  echo "rm -f $TAR_PATH/*"
}

copy_jars() {
  echo "Start copy jars ..."
  for i in "${JAR_PATH[@]}"; do
    if [ $i != "obs" ]; then
      echo "find $SOURCE_PATH/$i -name *.jar -type f -not -path '*/dependency-jars/*' | xargs cp -t $JARS_PATH/$i/"
      echo "find $SOURCE_PATH/$i -name *.jar -type f -path '*/dependency-jars/*' | xargs cp -nt $JARS_PATH/$i/dependency-jars/"
    else
      echo "find $SOURCE_PATH/$i -name *.jar -type f -not -path '*/dependency-jars/*' -not -name '*DTO*' | xargs cp -t $JARS_PATH/$i"
      echo "find $SOURCE_PATH/$i -name *.jar -type f -path '*/dependency-jars/*' -not -path '*/Core/*' | xargs cp -nt $JARS_PATH/$i/dependency-jars/"
    fi
  done

}

create_tars() {
  echo "Start creating tars ..."
  for i in "${JAR_PATH[@]}"; do
    echo "cd $JARS_PATH/$i"
    echo "tar -czvf $TAR_PATH/$i.tar.gz *"
  done
}

if [[ $1 == "create" ]]; then
  create_folder_structure
elif [[ $1 == "clone" ]]; then
  git_clone
else
  git_pull
  maven_package
  clear_jar_tar
  copy_jars
  create_tars
  backup_jars
fi
