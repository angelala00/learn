JAVA_HOME=/opt/soft/jdk/jdk1.7.0_80
export JAVA_HOME
MAVEN_HOME=/opt/oddir/jiangchi/soft/apache-maven-3.5.3
export MAVEN_HOME
PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH
export PATH

if [[ $# -ne 2 ]]; then
     echo "========================================================================="
     echo "please input param like projectName online/offline"
     echo "=========================================================================" && exit 1
fi

JOB_DIR=$1
ONLINE_STATUS=$2

SOURCE_DIR=/opt/oddir/jiangchi/source/$JOB_DIR
cd $SOURCE_DIR/
svn up
mvn clean package -Dmaven.test.skip=true

TASK_DIR=/opt/oddir/jiangchi/task

mkdir -p $TASK_DIR/$JOB_DIR/
rm -rf $TASK_DIR/$JOB_DIR/*
cp -r $SOURCE_DIR/target/classes/config_$ONLINE_STATUS $TASK_DIR/$JOB_DIR/config
cp -r $SOURCE_DIR/target/jar/* $TASK_DIR/$JOB_DIR/
#cp -r $SOURCE_DIR/target/lib $TASK_DIR/$JOB_DIR/

