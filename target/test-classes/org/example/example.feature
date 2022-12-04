#Gherkin
Feature: adding book to wishlist
  #Позитивный сценарий: ищем книгу Дружеское знакомство с тестированием программ, помещаем в Отложенные
  Scenario: choose real book
    Given url of website 'https://www.labirint.ru/'
    When website is open accept all cookie
    Then search book 'Дружеское знакомство с тестированием программ'
    Then click wishlist button
    Then go to wishlist
    And assert that book added to wishlist is 'Дружеское знакомство с тестированием программ'
    #Негативный сценарий: вводим в поисковую строку несуществующее название книги, получаем соответствуещее уведомление
  Scenario: chose absent book
    Given url of website 'https://www.labirint.ru/'
    When website is open search book 'Кищворитсет'
    Then assert that user got message 'Мы ничего не нашли по вашему запросу! Что делать?'