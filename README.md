# 4_SPRINT

## Техническое задание
Подготовить проект

Собрать в IDE Maven-проект. Нужно использовать Java 11. Подключить JUnit 4. Подключить Selenium. Установить Google Chrome и Mozilla Firefox: они понадобятся, чтобы выполнить задание.

Изучить тестовые сценарии

## Тестовые сценарии:
Выпадающий список в разделе «Вопросы о важном». Нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
Заказ самоката. Весь флоу позитивного сценария. Есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу. Из чего состоит позитивный сценарий:
Нажать кнопку «Заказать». На странице две кнопки заказа, нужно проверить обе.
Заполнить форму заказа.
Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа. Нужно написать тесты с разными данными: минимум два набора.
Нюансы:
В приложении есть баг, который не даёт оформить заказ. Он воспроизводится только в Chrome (не нажимается кнопка "Заказать" при оформлении заказа)

### Написать тесты по дополнительным тестовым сценариям:
- если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
- если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
- ошибки для всех полей формы заказа.
- если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.
 
 
