JAVA_HOME=/opt/soft/jdk/jdk1.7.0_80
export JAVA_HOME
MAVEN_HOME=/opt/oddir/jiangchi/soft/apache-maven-3.5.3
export MAVEN_HOME
PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH
export PATH

if [[ $# -ne 1 ]]; then
     echo "========================================================================="
     echo "please input param like online/offline"
     echo "=========================================================================" && exit 1
fi

SOURCE_DIR=/opt/oddir/jiangchi/source/zcmnoblejob
cd $SOURCE_DIR/
svn up
mvn clean package

TASK_DIR=/opt/oddir/jiangchi/task
JOB_DIR=zcmnoblejob

rm -rf $TASK_DIR/$JOB_DIR/*
cp -r $SOURCE_DIR/target/classes/config_$1 $TASK_DIR/$JOB_DIR/config
cp -r $SOURCE_DIR/target/jar/* $TASK_DIR/$JOB_DIR/
cp -r $SOURCE_DIR/target/lib $TASK_DIR/$JOB_DIR/

 #java -cp ./lib/*:./zcmnoblejob-0.0.1-SNAPSHOT.jar com.bj58.zcm.noble.task.app.HistoryDaysConsumeDataMain -History DaysConsumeData
