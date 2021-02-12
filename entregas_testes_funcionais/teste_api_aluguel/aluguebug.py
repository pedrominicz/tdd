#!/usr/bin/env python3

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep

driver = webdriver.Firefox()
driver.get('https://aluguebug.herokuapp.com/form')

dia = driver.find_element_by_id('dia')
nominal = driver.find_element_by_id('valor_nominal')
calculado = driver.find_element_by_id('resposta')

def send_hello(elem):
    elem.clear()
    elem.send_keys('Hello, world!')

send_hello(dia)
send_hello(nominal)
send_hello(calculado)

sleep(10)
driver.close()
