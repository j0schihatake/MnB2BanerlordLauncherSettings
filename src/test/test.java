/*
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>2.5.1</version>
            <configuration>
                <source>1.6</source>
                <target>1.6</target>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>1.7.1</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <shadedArtifactAttached>true</shadedArtifactAttached>
                <shadedClassifierName>shaded</shadedClassifierName>
                <transformers>
                    <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                        <mainClass>com.howtodoinjava.Main</mainClass>
                    </transformer>
                </transformers>
            </configuration>
        </plugin>
        <plugin>
            <groupId>com.akathist.maven.plugins.launch4j</groupId>
            <artifactId>launch4j-maven-plugin</artifactId>
            <version>1.5.1</version>
            <executions>
                <execution>
                    <id>l4j-clui</id>
                    <phase>package</phase>
                    <goals>
                        <goal>launch4j</goal>
                    </goals>
                    <configuration>
                        <headerType>gui</headerType>
                        <jar>${project.build.directory}/${artifactId}-${version}-shaded.jar</jar>
                        <outfile>${project.build.directory}/howtodoinjava.exe</outfile>
                        <downloadUrl>http://java.com/download</downloadUrl>
                        <classPath>
                            <mainClass>com.howtodoinjava.ApplicationMain</mainClass>
                            <preCp>anything</preCp>
                        </classPath>
                        <icon>application.ico</icon>
                        <jre>
                            <minVersion>1.6.0</minVersion>
                            <jdkPreference>preferJre</jdkPreference>
                        </jre>
                        <versionInfo>
                            <fileVersion>1.0.0.0</fileVersion>
                            <txtFileVersion>${project.version}</txtFileVersion>
                            <fileDescription>${project.name}</fileDescription>
                            <copyright>2012 howtodoinjava.com</copyright>
                            <productVersion>1.0.0.0</productVersion>
                            <txtProductVersion>1.0.0.0</txtProductVersion>
                            <productName>${project.name}</productName>
                            <companyName>howtodoinjava.com</companyName>
                            <internalName>howtodoinjava</internalName>
                            <originalFilename>howtodoinjava.exe</originalFilename>
                        </versionInfo>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>


launch4j { headerType="gui" mainClassName = <provide your main class name> outfile = "Burj2.exe" icon = "${projectDir}/src/main/resources/images/icon.ico" jar = '../libs/Master_Mode_System_Config-all-1.0-SNAPSHOT.jar' } тип launch4j { headerType="gui" mainClassName = <provide your main class name> outfile = "Burj2.exe" icon = "${projectDir}/src/main/resources/images/icon.ico" jar = '../libs/Master_Mode_System_Config-all-1.0-SNAPSHOT.jar' }

В IDEA можно сделать .exe для JavaFX приложения, для этого идем File — Project Structure.

В открывшемся окне слева выбираем вкладку Artifacts

Для добавления нового артефакта жмем зеленый плюс +

В выпадающем списке выбираем JavaFX Application

В правой части окна переходим на вкладку JavaFX

Заполняем поля. Можно заполнить только Application Class указав там класс с методом main

И самое главное в Native bundle выбираем all

И в верхней части этого окна ставим галочку Build on make

И еще выше задаем Output directory

Тогда при запуске приложения в папке указанной в Output directory создастся помимо прочего пака bundles, в которой будет лежать nameProjects.exe файл и папка с именем проекта. nameProjects.exe — это файл установщик, но его я не пробовал использовать. Папка с именем проекта — это папка содержащая среду исполнения java и .exe файл с именем проекта. Эту папку можно передавать пользователям. При этом им не нужно иметь установленную java на своих windows.

Все хорошо, но я столкнулся со следующими ограничениями: путь к .exe файлу не должен содержать русских букв. С английскими буквами и пробелами в пути у меня все заработало. Если хотим чтобы наше творение запускалось на всех windows нужно использовать 32 битный jdk, в моем случае это jdk-8u40-windows-i586.exe Полученный exe-шник должен полностью работать на windows начиная с vista, у меня под windows 7 все работает. В windows xp exe-шники из моих проектов тоже запускались, но не во всех проектах все работало.

<icon>D:\Develop\Разработка C#\MountAndBlade\New\NoGUISettings\src\main\resources\logo.ico</icon>




-----------------------------------------------------------------------

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>vexel</groupId>
    <artifactId>vExel</artifactId>
    <version>0.0.1</version>

    <properties>
        <javafx-maven-plugin.version>8.8.3</javafx-maven-plugin.version>
        <maven-compiler-plugin.version>3.7.0</maven-compiler-plugin.version>
        <maven-resources-plugin.version>3.0.2</maven-resources-plugin.version>
        <jdkVersion>1.8</jdkVersion>
        <product.title>vExel_XSL</product.title>
        <product.company>ПАО "Сбербанк"</product.company>
        <exeFileName>vExel</exeFileName>
        <project.java.version>1.8</project.java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <exeFileDescription>Программа для автоматического наполнения XSL фалов значениями</exeFileDescription>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml-schemas</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>com.zenjava</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>8.8.3</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${jdkVersion}</source>
                    <target>${jdkVersion}</target>
                    <encoding>${project.build.sourceEncoding}</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>com.zenjava</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>${javafx-maven-plugin.version}</version>
                <configuration>
                    <mainClass>Main</mainClass>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>Main</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                    <appendAssemblyId>true</appendAssemblyId>
                </configuration>
                <executions>
                <execution>
                    <id>make-assembly</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>com.akathist.maven.plugins.launch4j</groupId>
                <artifactId>launch4j-maven-plugin</artifactId>
                <version>1.7.21</version>
                <executions>
                    <execution>
                        <id>l4j-clui</id>
                        <phase>package</phase>
                        <goals>
                            <goal>launch4j</goal>
                        </goals>
                        <configuration>
                            <headerType>gui</headerType>
                            <outfile>target/${exeFileName}.exe</outfile>
                            <jar>target/${project.artifactId}-${project.version}-jar-with-dependencies.jar</jar>
                            <errTitle>${product.title}</errTitle>
                            <icon>${project.basedir}/src/main/resources/logo.ico</icon>
                            <classPath>
                                <mainClass>Main</mainClass>
                                <addDependencies>true</addDependencies>
                                <preCp>anything</preCp>
                            </classPath>
                            <jre>
                                <path>C:\Users\Donskoy-VO\development\jdk1.8.0_102\jre</path>
                                <minVersion>${jdkVersion}.0</minVersion>
                            </jre>
                            <versionInfo>
                                <fileVersion>${project.version}.0</fileVersion>
                                <txtFileVersion>${project.version}</txtFileVersion>
                                <fileDescription>${exeFileDescription}</fileDescription>
                                <copyright>Copyright © 2018 ${product.company}</copyright>
                                <productVersion>${project.version}.0</productVersion>
                                <txtProductVersion>${project.version}</txtProductVersion>
                                <companyName>${product.company}</companyName>
                                <productName>${product.title}</productName>
                                <internalName>${exeFileName}</internalName>
                                <originalFilename>${exeFileName}.exe</originalFilename>
                            </versionInfo>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>${project.basedir}/src/main/resources</directory>
            </resource>
        </resources>
    </build>
</project>
 */

