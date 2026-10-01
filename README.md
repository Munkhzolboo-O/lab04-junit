\# Лаборатори №4 — JUnit 5



\*\*Оюутны нэр:\*\* Оюунсүрэн Мөнхзолбоо  

\*\*Оюутны код:\*\* B210910878



\## Орчны мэдээлэл



\### java -version



```text

openjdk version "17.0.20.1" 2026-08-18 LTS

OpenJDK Runtime Environment Microsoft-14940689 (build 17.0.20.1+1-LTS)

OpenJDK 64-Bit Server VM Microsoft-14940689 (build 17.0.20.1+1-LTS, mixed mode, sharing)

```



\### mvn -version



```text

Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)

Maven home: C:\\maven\\apache-maven-3.9.16

Java version: 17.0.20.1, vendor: Microsoft, runtime: C:\\Program Files\\Microsoft\\jdk-17.0.20.101-hotspot

Default locale: en\_US, platform encoding: Cp1252

OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"

```



\## Тестийн үр дүн



\- Тестийн методын тоо: 9

\- Parameterized тестийн тоо: 2

\- Maven-аар ажилласан нийт тест: 20

\- Failures: 0

\- Errors: 0

\- Skipped: 0

\- Build: SUCCESS



Бүрэн гаралт: `results/mvn-test.txt`



\## Mutation test



`GradeCalculator` классын:



```java

score >= 90

```



нөхцөлийг зориуд:



```java

score > 90

```



болгож өөрчилж тест ажиллуулсан.



Mutation тестийн үр дүн:



\- Tests run: 20

\- Failures: 2

\- Build: FAILURE



Бүрэн гаралт: `results/mvn-test-mutant.txt`



90 оноог A гэж шалгасан энгийн тест болон parameterized boundary тест мутацийн алдааг илрүүлсэн. Туршилтын дараа `score >= 90` нөхцөлийг буцааж зөв болгосон.



\## Дүгнэлт



Энэ лабораторийн ажлаар JUnit 5 ашиглан Java кодод нэгжийн тест бичиж сурлаа. GradeCalculator классын letterGrade болон totalScore хоёр методыг ердийн, хязгаарын болон буруу оролтоор шалгасан. 90, 89.99, 60, 59.99 зэрэг хязгаарын утгуудыг шалгах нь жижиг нөхцөлийн алдааг илрүүлэхэд чухал гэдгийг ойлгосон. Мөн assertThrows ашиглан буруу оролтод exception зөв үүсэж байгаа эсэхийг шалгасан. ParameterizedTest ашигласнаар ижил төрлийн олон утгыг нэг тестийн методоор шалгах боломжтой байсан. `score >= 90` нөхцөлийг `score > 90` болгож зориуд өөрчлөхөд 90 оноог шалгасан тестүүд алдааг шууд илрүүлж 2 тест унасан. Миний хувьд 90 онооны boundary тест хамгийн сонирхолтой байсан, учир нь энгийн утгууд зөв ажиллаж байсан ч яг хязгаар дээрх жижиг өөрчлөлтийг илрүүлж чадсан.

