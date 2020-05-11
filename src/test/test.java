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


 */