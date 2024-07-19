## Описание  

Программа позволяет отображать изображения формата 16x16 в терминале 

## Использование

1. Перейти в папку ImagesToChar(выполнение команд всех пунктов начинается из этой папки)

2. Создать папку target
    <pre>
    mkdir target</pre>

3. Создать папку lib и загрузить нужные библиотеки  
    <pre>
    mkdir lib  
    cd lib  
    wget https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar  
    wget https://repo1.maven.org/maven2/com/diogonunes/JColor/5.0.0/JColor-5.0.0.jar</pre>  

4. Скпомпилироапть файлы при помощи команды:  
    <pre>
    javac -classpath lib/JColor-5.0.0.jar:lib/jcommander-1.82.jar -d target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/ImagesToChar.java</pre>
   
5. Скопировать ресурсные файлы в папку target  
    <pre>
    cp -r src/resources target/.
    cp src/manifest.txt target/.</pre>  

6. Разархивировать библиотеки в папку target  
    <pre>
    cd target  
    jar xf ../lib/jcommander-1.82.jar  
    jar xf ../lib/JColor-5.0.0.jar</pre>  

7. Создать jar-архив  
    <pre>
    jar cmf target/manifest.txt target/images-to-chars-printer.jar -C target .</pre>  
 
8. Запустить jar-архив  
    <pre>
    java -jar target/images-to-chars-printer.jar --black black --white white</pre>  
