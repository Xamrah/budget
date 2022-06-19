# Budget

[![Build Status](http://85.193.84.55:8080/buildStatus/icon?job=Budget+build)](http://85.193.84.55:8080/job/Budget%20build/)

Веб-приложение для ведения и планирования бюджета посредством импорта выписок из онлайн-банкинга.
Приложение ориентировано на российский сегмент пользователей и является прямой альтернативой для FIREFLY III.

Доступны следующие банки:
 - [x] Альфа-банк
 - [x] Тинькофф
 - [ ] Сбербанк
 - [ ] ВТБ
 

## Проблема

Ведение домашней бухгалтерии в таблицах достаточно трудоемкое, т.к. нужно следить за несколькими счетами, поддерживать разномастные типы документов и выписок.
В добавок ко всему некоторые банки поставляют не нормализованные выгрузки. 

Например, рри выгрузке CSV файла из альфабанка
- можно получить список транзакций только по одному счету. Не понятно как учитывать трансфер между счетами
- список не очень хороший - нет уникального атрибута у тразакции
- есть "мусорные" внутренние транзакции


## Notes

Как и зачем?

По сути мы превращяем список тразакции в транзакции с инкам/ауткам счетом, где в случае трансфера оба поля заполнены

! Альфабанк позволяет себе дублировать рефы для определенных внутренних типов транзакций, что рождает "КОСТЫЛИ И ВЕЛОСИПЕДЫ" при попытке нормализовать транзакцию

- Предоставление транша
- Погащение ОД
- Некоторые CASHIN на разных счетах
- Отмены транзакций в один день
- Начисления процентов
- Старое снятие задолжностей с других счетов


## Dev Plan

- [x] импорт транзакций в локальную БД
- [x] импорт транзакций из CSV выгрузок
- [ ] импорт транзакций из выписок PDF-формата
- [ ] пропуск транзакций по фильтру
- [ ] пропуск транзакций по REF\SHA
- [ ] линкование транферов между счетами
- [x] отображение и поиск тразакций
- [x] отображение и поиск истории
- [ ] Конфигурация

---
## Installation
### Pre-requirements

- Installed JRE 11+

## Setup

Download the latest version from [release page](#).

Simple running with:
```bash
java -jar budget.jar
```

Enable auto-start by systemd script
```bash
[Unit]
Description=Budget application
After=syslog.target
After=network.target

[Service]
User=butget
Group=butget
WorkingDirectory=/opt/butget/
ExecStart=/usr/bin/java -jar /opt/butget/butget.jar
ExecStop=/bin/kill -s TERM $MAINPID
RestartSec=60
TimeoutSec=300
SuccessExitStatus=143 SIGTERM
Restart=on-failure

[Install]
WantedBy=multi-user.target
```

----

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/xamrah/budget. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [code of conduct](https://github.com/xamrah/budget/blob/master/CODE_OF_CONDUCT.md).

## Copyright

Copyright (c) 2020 Evgeniy Khamrachev. See [MIT License](LICENSE.txt) for further details.
