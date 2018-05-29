/etc/profile 会从目录 /etc/profile.d 中加载所有的配置，所以个人配置都放在 /etc/profile.d 的 app.sh 中：

    export APP_HOME=/app
    export JAVA_HOME=$APP_HOME/java
    export JRE_HOME=$JAVA_HOME/jre  
    export NODE_HOME=$APP_HOME/node
    export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH  
    export PATH=$JAVA_HOME/bin:$NODE_HOME/bin:$PATH