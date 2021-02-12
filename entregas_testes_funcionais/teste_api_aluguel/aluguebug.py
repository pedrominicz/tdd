#!/usr/bin/env python3

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep

driver = webdriver.Firefox()
driver.get('https://aluguebug.herokuapp.com/form')

dia = driver.find_element_by_id('dia')
nominal = driver.find_element_by_id('valor_nominal')
calculado = driver.find_element_by_id('resposta')
calcular = driver.find_element_by_id('botao')

def send(elem, value):
    elem.clear()
    elem.send_keys(value)

send(nominal, str(100.0))

for i in range(30):
    send(dia, str(i + 1))

    calcular.click()
    sleep(0.5)
    print(i + 1, calculado.get_attribute('value'))

driver.close()
