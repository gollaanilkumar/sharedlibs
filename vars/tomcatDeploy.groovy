def call(cred_id,user,ip)
{
  sshagent([cred_id]) {
    // some block
    sh "mv target/myweb*.war target/deployshare.war"
    scp " -o StrictHostChecking=no  target/deploysahre.war ${user}@${ip}:/opt/tomcat8/webapps"
    ssh "${user}@${ip} /opt/tomcat8/bin/shutdown.sh"
    ssh "${user}@${ip} /opt/tomcat8/bin/startup.sh"
    echo "deployed to tomcat"
}
