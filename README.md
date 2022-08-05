# Spring + Flyway + Env-specific migrations

Проект представляет собой демо, демонстрирующее
что в зависимости от выбранного стенда в созданную таблицу
настроек сохраняется набор значений, ориентированных именно на этот стенд.

Предполагается что для `dev` стенда нужно использовать такие настройки:
```
sms.gateway.url=https://some-dev-stand
sms.gateway.token=some-dev-token
```

Для `stage` стенда нужно использовать такие настройки:
```
sms.gateway.url=https://some-stage-stand
sms.gateway.token=some-stage-token
```

Для `prod` стенда нужно использовать такие настройки:
```
sms.gateway.url=https://some-prod-stand
sms.gateway.token=some-prod-token
```

## С демо можно ознакомиться двумя способами:
1. запустить тесты
2. использовать Docker и Docker Compose

### Запуск демо с помощью тестов
Откройте проект в IDE и запустите тесты.

Каждый тест демонстрирует выполнение миграций для заданного стенда:
1. MigrationOnDevStandTest - выполнение миграций для `dev` стенда
2. MigrationOnStageStandTest - выполнение миграций для `stage` стенда
3. MigrationOnProdStandTest - выполнение миграций для `prod` стенда

### Запуск демо с помощью Docker и Docker Compose
Соберите Docker образ и запускайте его с разными настройками.

**Сборка Docker образа**
```
docker build -t spring-flyway-demo .
```

**Запуск демо для `dev` стенда**
```
docker-compose up app-dev
```
ожидаемый вывод:
```
app-dev_1    | [Settings] Stand: dev
app-dev_1    | settingValue = some-dev-token
app-dev_1    | settingValue = https://some-dev-stand
```

**Запуск демо для `stage` стенда**
```
docker-compose up app-stage
```
ожидаемый вывод:
```
app-stage_1  | [Settings] Stand: stage
app-stage_1  | settingValue = some-stage-token
app-stage_1  | settingValue = https://some-stage-stand
```

**Запуск демо для `prod` стенда**
```
docker-compose up app-prod
```
ожидаемый вывод:
```
app-prod_1   | [Settings] Stand: prod
app-prod_1   | settingValue = some-prod-token
app-prod_1   | settingValue = https://some-prod-stand
```
