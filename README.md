# alfabank-test-task
Тестовое задание на позицию Java-стажер

## Инструкция по запуску 

* С помощью Gradle
```
./gradlew build
java -jar build/libs/*.jar
```

Или
```
./gradlew bootRun
```

* С помощью Docker
```
docker build -t alfabanktest .
docker run -p 8080:8080 -t alfabanktest
```

## После запуска

Запросы приходят на HTTP endpoint, туда передается код валюты

```
GET /app/{code}
```


Например 

```
GET /app/USD
```

В качестве ответа сервис делает редирект (HTTP 302) на ссылку с гифкой 
