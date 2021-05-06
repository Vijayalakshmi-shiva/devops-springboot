node{
   def mvnHome
   stage('Prepare'){
    git url :'git@github.com:Vijayalakshmi-shiva/devops-springboot.git', branch:'develop'
    mvnHome = tool 'mvn'
    
    
    }
    stage('Build'){
   
    bat "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    
    }
    stage('Unit test'){
    junit '**/target/surefire-reports/TEST-*.xml'
    archive 'target/*.jar'
    
  } 
   stage('Integration test'){
  
   bat "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
   
  
    
  } 
  stage('Sonar'){
   
   bat "'${mvnHome}/bin/mvn' sonar:sonar"
    
     }
     
 stage('Deploy'){
 
 sh 'curl -u admin:admin -T target/**.war "http://localhost:7080/manager/text/deploy?path=/ibmdevops1&update=true"'
 }
 stage('Smoke Test'){
 sh "curl --retry-delay 10 --retry 5 http://localhost:7080/ibmdevops1/api/v1/products"
 }
 
     
     
     
   }