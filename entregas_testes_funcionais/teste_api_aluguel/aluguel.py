#!/usr/bin/env python3

from selenium import webdriver
from time import sleep

class Aluguel():
    def __init__(self, method='api'):
        method = method.lower()
        if method not in ['api', 'webdriver']:
            raise ValueError("method must be 'api' or 'webdriver'")
        self.method = method

    def calcular(self, dia, nominal):
        if self.method == 'api':
            raise NotImplementedError()
        elif self.method == 'webdriver':
            driver = webdriver.Firefox()
            driver.get('https://aluguebug.herokuapp.com/form')

            dia_input = driver.find_element_by_id('dia')
            dia_input.clear()
            dia_input.send_keys(str(dia))

            nominal_input = driver.find_element_by_id('valor_nominal')
            nominal_input.clear()
            nominal_input.send_keys(str(nominal))

            calcular_button = driver.find_element_by_id('botao')
            calcular_button.click()

            sleep(1)

            calculado_input = driver.find_element_by_id('resposta')
            result = float(calculado_input.get_attribute('value'))

            driver.close()

            return result

if __name__ == '__main__':
    print('Pedro Minicz')
    dia = int(input('Dia: '))
    nominal = float(input('Valor nominal: '))

    aluguel = Aluguel('api')
    print(aluguel.calcular(dia, nominal))
