# scifioMavenTest

Make a simple project with a pom.xml that extends pom-scijava  
Add a dependency on scijava-common.  
Create a single concrete source class that extends AbstractService  

**Maven questions:**  
**What command lists all the dependencies of the project?**  
mvn dependency:tree will list out a tree version of dependencies  

**What command downloads all the dependencies of the project to the target folder?**  
[maven lifecycle here](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
`mvn package`

**What is the difference between package and install in maven?**  
Directly quoted from [here](https://stackoverflow.com/questions/16602017/how-are-mvn-clean-package-and-mvn-clean-install-different)  
package will compile your code and also package it. 
For example, if your pom says the project is a jar, 
it will create a jar for you when you package it and put it somewhere in the target directory (by default).

install will compile and package, but it will also put the package in your local repository. 
This will make it so other projects can refer to it and grab it from your local repository.


Stretch goals:  
We're going to make a unit test that accesses your test class extending AbstractService  


1. used [this](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) to create mvn project  
2. Removed version dependency from JUnit, scijava provides this  


