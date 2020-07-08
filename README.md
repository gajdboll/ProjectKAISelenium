 Version1.7
# ProjectKAISelenium - Sprint One -Version 1.7


##  LOG4J Logging System

Acceptance Criteria

add a dependency to the pom file

<dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-core</artifactId>
     <version>2.10.0</version>
 </dependency>

In the project localisation: scr/main/resources create a file log4j2.xml and paste that content to it

<?xml version="1.0" encoding="UTF-8"?>
 <Configuration status="INFO">
     <Appenders>
         <Console name="console" target="SYSTEM_OUT">
             <PatternLayout
                     pattern="[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %C - %msg%n" />
         </Console>
     </Appenders>
     <Loggers>
         <Root level="debug" additivity="false">
             <AppenderRef ref="console" />
         </Root>
     </Loggers>
 </Configuration>

 src/main/resourcessrc/main/resourc

If we want to use our logger and all the methods we need to start with (that's how we call for logger):private Logger logger = LogManager.getRootLogger();

Logger have 3 methods:

logger.info("Information log");
 logger.warn("warning log");
 logger.error("error log");

!!!Create Logger in each POP class and attach information log inside each method to get more information when a certain method finishes !!!

more information about architecture etc. 

https://logging.apache.org/log4j/2.0/manual/architecture.html

Official Log4j web

https://logging.apache.org/log4j/2.x/

The Test should be stored in master as well as Version1.7 the branch on the global repository (remote)

The master branch should always contain the latest version of the project


### ORIGINAL FRAMEWORK - KAI

