# Delegated-federation

Use Delegated mode of common security behind service provider reverse proxy.

# Requirement 
* Maven 3.1 ou supérieur.    
* JDK 1. ou supérieur. 

# Build
 
            mvn clean install
            
# run 

            cd target 
            java -jar -DITESOFT_SECURITY_MODE=delegated springboot-fatjar-1.0.0-SNAPSHOT.jar
           
# other files

Apache + saml and openidc modules 
https://github.com/alizarion/delegated-federation/releases/download/1.0.0/files.zip