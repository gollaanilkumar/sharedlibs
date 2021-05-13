def call(cred_id,user,ip)
{
  sshagent([cred_id]) {
    // some block
    sh "mv target/feature*.war target/deployshare.war"
    sh "scp -o StrictHostChecking=no  target/deploysahre.war ${user}@${ip}:/opt/tomcat8/webapps"
    sh "ssh ${user}@${ip} /opt/tomcat8/bin/shutdown.sh"
    sh "ssh ${user}@${ip} /opt/tomcat8/bin/startup.sh"
    echo "deployed to tomcat"
}
}
