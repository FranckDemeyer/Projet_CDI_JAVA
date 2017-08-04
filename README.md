# Projet_CDI_JAVA
Projet en Java de la Formation CDI JAVA 02/17 => application similaire Ã Â  Massy En Poche

## setup for photos upload
We're using TomCat.
edit tomcat file /conf/server.xml
add following line in the ```<Host>``` section:
```
<Context docBase="/uploads" path="/uploads" />
```
when running from Eclipse or STS : 
create directory ``` <codeRoot>\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\uploads```
