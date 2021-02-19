#!/usr/bin/env python3

from aluguel import Aluguel
from unittest import TestCase, main

class TestAluguel(TestCase):
    def setUp(self):
        self.aluguel = Aluguel('webdriver')
        self.nominal = 100000.0

    def test_1_pm(self):
        self.assertEqual(self.aluguel.calcular(1, self.nominal), 90000.0)
        self.assertEqual(self.aluguel.calcular(5, self.nominal), 90000.0)

    def test_2_pm(self):
        self.assertEqual(self.aluguel.calcular(6, self.nominal), 95000.0)
        self.assertEqual(self.aluguel.calcular(10, self.nominal), 95000.0)

    def test_3_pm(self):
        self.assertEqual(self.aluguel.calcular(11, self.nominal), 100000.0)
        self.assertEqual(self.aluguel.calcular(15, self.nominal), 100000.0)

    def test_4_pm(self):
        self.assertEqual(self.aluguel.calcular(16, self.nominal), 102100.0)
        self.assertEqual(self.aluguel.calcular(30, self.nominal), 103500.0)

if __name__ == '__main__':
    main(warnings='ignore')
