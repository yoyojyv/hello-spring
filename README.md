# Hello Spring

## Spring Framework 시작을 위한 Gradle 맛보기

=====================================

> 본 내용 중 Gradle 관련 내용은 rocking-the-gradle[https://github.com/ihoneymon/rocking-the-gradle] 을 참조하였습니다.

### Step00. Gradle 설치
먼저 gradle 1.10 버전을 설치해 주세요.

* http://www.gradle.org/downloads 에서 예전버전 선택 다운로드
* 압축 해제, 설치


* *nix 설정


* gradle home 설정

```
export GRADLE_HOME=/Users/yoyojyv/Development/gradle/gradle-1.10
```

* path 추가

```
export PATH=$PATH:$GRAILS_HOME/bin
```

* windows 설정

```
시스템 속성에서 환경변수에 GRADLE_HOME 에 경로를 등록
PATH 에 %GRAILS_HOME%\bin 추가
```

* 확인

```
gradle -v
```


### Step01. Gradle 프로젝트 생성

* 기본 gradle 프로젝트 생성
```
mkdir hello-spring
cd hello-spring
gradle init --type java-library
```

<pre><code>.
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   └── java
    │       └── Library.java
    └── test
        └── java
            └── LibraryTest.java	
</code></pre>	



* build.gradle 파일 수정 

```
/*
 * This build file was auto generated by running the Gradle 'init' task
 * by 'yoyojyv' at '14. 2. 17 오후 10:23' with Gradle 1.10
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * user guide available at http://gradle.org/docs/1.10/userguide/tutorial_java_projects.html
 */

// Apply the java plugin to add support for Java
apply plugin: 'java'

ext {
  javaVersion='1.7'
}

buildDir = 'build' // 기본값

sourceCompatibility = javaVersion
targetCompatibility = javaVersion
[compileJava, compileTestJava]*.options*.encoding = 'UTF-8'

// In this section you declare where to find the dependencies of your project
repositories {
    // Use 'maven central' for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

// In this section you declare the dependencies for your production and test code
dependencies {
    // The production code uses the SLF4J logging API at compile time
    compile 'org.slf4j:slf4j-api:1.7.5'

    // Declare the dependency for your favourite test framework you want to use in your tests.
    // TestNG is also supported by the Gradle Test task. Just change the
    // testCompile dependency to testCompile 'org.testng:testng:6.8.1' and add
    // 'test.useTestNG()' to your build script.
    testCompile 'junit:junit:4.11'
}


// JavaExec라는 Task 클래스를 상속하여 태스크 생성
// http://www.gradle.org/docs/current/dsl/org.gradle.api.tasks.JavaExec.html
task runLibrary(type: JavaExec) {
  main = "Library"
  classpath += sourceSets.main.runtimeClasspath
  args "Gradle"
}

```


* Library.java 수정

```    public static void main(String[] args) {
    	System.out.println("Hello world!");
    }
```


* 작성된 태스크 확인
```
./gradlew tasks
```

* 태스크 실행
```
./gradlew build
./gradlew runLibrary
```



