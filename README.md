# UI и API автотесты для сайта [GIPHY](https://giphy.com/)
<img alt="GIPHY" src="readme/screenshots/GIPHY.PNG">


## :bookmark_tabs: <a id="list"></a> Содержание 

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>:   
  - <a href="#cases-ui"> UI
  - <a href="#cases-api"> API

* <a href="#integrations">Подключенные интеграции</a>

* <a href="#console">Запуск из терминала</a>
  - <a href="#console-ui"> UI
  - <a href="#console-api"> API

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчеты</a>

* <a href="#telegram">Отчёт в Telegram</a>

* <a href="#testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#video">Пример прогона теста в Selenoid</a>


## :hammer_and_wrench: <a id="tools"></a> Технологии и инструменты
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="75" alt="IDEA" src="readme/icons/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="75" alt="JAVA" src="readme/icons/Java.svg"></a>
<a href="https://github.com/"><img width="75" alt="Github" src="readme/icons/GitHub.svg"></a>
<a href="https://junit.org/junit5/"><img width="75" alt="JUnit5" src="readme/icons/JUnit5.svg"></a>
<a href="https://gradle.org/"><img width="75" alt="Gradle" src="readme/icons/Gradle.svg"></a>
<a href="https://selenide.org/"><img width="75" alt="Selenide" src="readme/icons/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="75" alt="Selenoid" src="readme/icons/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="75" alt="Allure" src="readme/icons/Allure.svg"></a>
<a href="https://qameta.io"><img width="55" alt="TestOps" src="readme/icons/TestOpspng.png"></a>
<a href="https://www.jenkins.io/"><img width="75" alt="Jenkins" src="readme/icons/Jenkins.svg"></a>
<a href="https://telegram.org/"><img width="75" alt="Telegram" src="readme/icons/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="75" alt="Jira" src="readme/icons/Jira.svg"></a>
</p>


## :white_check_mark: <a id="cases"></a> Реализованные проверки
<a id="cases-ui"></a>UI-кейсы:
  
:heavy_check_mark: Проверка создания стикера без авторизации на сайте   
:heavy_check_mark: Проверка кнопки Share на странице гифки   
:heavy_check_mark: Проверка кнопок с тэгами под гифкой   
:heavy_check_mark: Проверка логина с рандомными значениями   
:heavy_check_mark: Проверка элементов верхнего меню   
:heavy_check_mark: Проверка основных блоков на главной странице   
:heavy_check_mark: Проверка поиска по @user + tag   
:heavy_check_mark: Проверка открытия Privacy Policy по клику на баннере   
:heavy_check_mark: Проверка открытия FAQ   
:heavy_check_mark: Проверка страницы пользователя   
  
<a id="cases-api"></a>API-кейсы:
  
:heavy_check_mark: Поиск гифки по корректному ID   
:heavy_check_mark: Поиск гифки по НЕкорректному ID   
:heavy_check_mark: Поиск по слову "sticker"   
:heavy_check_mark: Ошибка 414 при количестве символов более 50 в поисковом запросе   
:heavy_check_mark: БАГ в API - Поиск без обязательного параметра "q"   
:heavy_check_mark: Поиск без обязательного параметра "api_key"   
:heavy_check_mark: Загрузка гифки   

<a href="#list">К Содержанию</a>

## :on:	<a id="integrations"></a> Подключенные интеграции
:heavy_check_mark: Запуск автотестов в Jenkins   
:heavy_check_mark: Allure Report + SelenideLogger.addListener + step()   
:heavy_check_mark: Уведомление от бота в Telegram с отчетом о прохождении тестов   
:heavy_check_mark: Allure TestOps   
:heavy_check_mark: Jira   
:heavy_check_mark: Selenoid   
:heavy_check_mark: Библиотека Owner   
:heavy_check_mark: Java Faker  
:heavy_check_mark: Assertj 

<a href="#list">К Содержанию</a>

## :desktop_computer: <a id="console"></a> Запуск из терминала
  
### <a id="console-ui"></a>Локальный запуск UI-тестов

```
gradle clean giphy_ui -Denv="{ENV}"
```
  В проекте созданы 3 файла properties для локального запуска с предустановленными настройками:
  * chrome    
  * edge    
  * opera    
  
  В параметр {ENV} необходимо вписать один из трёх файлов.

### <a id="console-api"></a>Локальный запуск API-тестов

```
gradle clean giphy_api
```
  
### Удаленный запуск тестов

```
clean
${test_run}
-Denv=${env}
```
  В проекте созданы 2 файла properties для удаленного запуска с предустановленными настройками:
  * remoteChrome     
  * remoteOpera  
  
> `${env}` - конфиг для быстрого выбора конфигурации запуска тестов.
> 
> `${test_run}` - название 

<a href="#list">К Содержанию</a>

## <a id="jenkins"></a> <img width="30" alt="Jenkins" src="readme/icons/Jenkins_ico.svg"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C17-linakramer-Diplom/)

:information_source: При сборке в Jenkins можно выбрать параметры из выпадающих списков   

<img alt="Jenkins_screenshot" src="readme/screenshots/Jenkins.PNG">

<a href="#list">К Содержанию</a>

## <a id="allure"></a> <img width="30" alt="Allure" src="readme/icons/Allure_ico.svg"> [Allure](https://jenkins.autotests.cloud/job/C17-linakramer-Diplom/10/allure/) отчеты

:information_source: По итогам сборки в Jenkins собирается отчет в Allure Report   
* Автотесты написаны как "шаги" через SelenideLogger.addListener + step() = описание пройденных тестов понятно любому сотруднику
* Подключено добавление в отчет:   
  - последнего скриншота
  - ресурсов страницы
  - логов браузера
  - видео прохождения тестов

<img alt="AllureReport_screenshot" src="readme/screenshots/AllureReport.PNG">
<img alt="AllureReportTest_screenshot" src="readme/screenshots/AllureReportTest.PNG">

<a href="#list">К Содержанию</a>

## <a id="telegram"></a> <img width="30" alt="Telegram" src="readme/icons/Telegram_ico.svg"> Отчёт в Telegram
:information_source: Также отчет по сборке можно отправить в телеграм через бота

<img alt="Telegram_screenshot" src="readme/screenshots/Telegram.PNG">

<a href="#list">К Содержанию</a>

## <a id="testops"> <img width="25" alt="TestOps" src="readme/icons/TestOpspng.png"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/21158)
:information_source: Настроена интеграция с Allure TestOps, в котором также можно увидеть отчет о прохождении автотестов
  
<img alt="AllureTestOpsLaunches_screenshot" src="readme/screenshots/AllureTestOpsLaunches.PNG">
<img alt="AllureTestOpsLaunchesTreeTests_screenshot" src="readme/screenshots/AllureTestOpsLaunchesTreeTests.PNG">

<a href="#list">К Содержанию</a>

## <a id="jira"></a> <img width="30" alt="Jira" src="readme/icons/Jira.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-620)
:information_source: Настроена интеграция Allure TestOps с Jira.
Тест-кейсы и результаты прогонов можно прикреплять к необходимым задачам.
  
<img alt="Jira_screenshot" src="readme/screenshots/Jira.PNG">

<a href="#list">К Содержанию</a>

## <a id="video"></a> <img width="30" alt="Selenoid" src="readme/icons/Selenoid_ico.svg"> Пример прогона теста в Selenoid
:information_source: Видео прогона одного из кейсов. Записано автоматически.
  
<img alt="SelenoidVideo_video" src="readme/video.gif">

<a href="#list">К Содержанию</a>
