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