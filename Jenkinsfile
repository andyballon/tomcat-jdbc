node('maven') {
stage 'Checkout'
git branch: 'master', url: 'https://github.com/welshstew/tomcat-jdbc.git'

// ** NOTE: This 'M3' maven tool must be configured in the global configuration.
def mvnHome = tool 'M3'

stage 'Set Version'
sh "${mvnHome}/bin/mvn --settings /etc/m2/settings.xml -f pom.xml versions:set -DnewVersion=1.1.${env.BUILD_NUMBER}"

stage 'Build'
sh "${mvnHome}/bin/mvn --settings /etc/m2/settings.xml -f pom.xml clean install -DskipTests"

stage 'Unit Test'
sh "${mvnHome}/bin/mvn --settings /etc/m2/settings.xml -f pom.xml test"

stage 'Deploy and Tag'
sh "${mvnHome}/bin/mvn --settings /etc/m2/settings.xml -f pom.xml deploy"

withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: '431cbc19-9e57-4011-920d-02304cafc84c', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {
    //println "${env.GIT_USERNAME}:${env.GIT_PASSWORD}@https://github.com/welshstew/tomcat-jdbc.git"
    sh("git config --global user.email \"stuart.winchester@gmail.com\"")
    sh("git config --global user.name \"Stuart Winchester\"")
    sh("git tag -a 1.1.${env.BUILD_NUMBER} -m 'Jenkins CI Tag'")
    sh("git push https://${env.GIT_USERNAME}:${env.GIT_PASSWORD}@github.com/welshstew/tomcat-jdbc.git --tags")
}

}
