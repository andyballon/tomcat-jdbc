# tomcat-jdbc s2i

Taken from the [tomcat-jdbc quickstarts]([https://github.com/jboss-openshift/openshift-quickstarts])

Added some extra stuff to allow the binary created to be pulled in from a nexus


# Building in Jenkins...


Possible cause: Old version of Maven...!  Apache Maven 3.0.5 (Red Hat 3.0.5-16)

```
➜  cdk-v2 git:(master) ✗ docker run -it --rm registry.access.redhat.com/openshift3/jenkins-slave-maven-rhel7 bash
bash-4.2$ mvn --version
Apache Maven 3.0.5 (Red Hat 3.0.5-16)
Maven home: /usr/share/maven
Java version: 1.8.0_111, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.111-1.b15.el7_2.x86_64/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "3.10.0-327.36.2.el7.x86_64", arch: "amd64", family: "unix"
```