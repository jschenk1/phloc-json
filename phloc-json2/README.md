#phloc-json2

A Java JSON parser and writer. It uses it's own JavaCC grammar to parse JSON. It also provides an object model for creating and extracting JSON Data.

Versions < 1.2.0 still use jackson (com.fasterxml.jackson) as a parser
Versions >= 1.2.0 use its own JavaCC parser  

#Maven usage
Add the following to your pom.xml to use this artifact:
```
<dependency>
  <groupId>com.phloc</groupId>
  <artifactId>phloc-json2</artifactId>
  <version>1.2.0</version>
</dependency>
```