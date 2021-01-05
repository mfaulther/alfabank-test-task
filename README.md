# alfabank-test-task
Тестовое задание на позицию Java-стажер

## Перед запуском
Сервис работает с курсами по отношению к доллару (USD)

Для того чтобы сервис работал с курсами по отношению к рублю (RUB), нужно в файле application.properties
поменять свойство base.currency на RUB, 

а так же поменять свойство openexchange.api.key, написать тот апи-ключ, у которого Developer, Enterprise или Unlimited план.
(здесь был использован апи-ключ с бесплатным Free планом, который позволяет получать курсы только по отношению к доллару (USD), для того чтобы можно было выбирать 
валюту по отношению к которой будут возвращены курсы, нужно иметь Developer, Enterprise или Unlimited план)

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
GET /app/RUB
```
