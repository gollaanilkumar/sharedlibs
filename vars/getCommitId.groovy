def call(){
  script{
  return sh returnStdout: true, script: 'git rev-parse --short HEAD'
  }
}
