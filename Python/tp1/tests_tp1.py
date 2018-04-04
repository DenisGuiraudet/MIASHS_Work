from tp1 import *
from nose.tools import eq_

def test_premier():
    assert premier(11)
    assert not premier(12)

def test_parfait():
    assert parfait(28)
    assert not parfait(30)

def test_chanceux():
    assert chanceux(11)
    assert not chanceux(100)

def test_amis():
    eq_(amis(5000), [(220, 284), (1184, 1210), (2620, 2924)])

def test_tous():
    eq_(tous(lambda x: x % 2 == 0, 17), [2, 4, 6, 8, 10, 12, 14, 16])
    eq_(tous(lambda x: x > 30, 17), [])

def test_premiers():
    expected = [2, 3, 5, 7, 11, 13, 17, 19]
    eq_(premiers(20), expected)

def test_parfaits():
    eq_(parfaits(1000), [6, 28, 496])

def test_tous_chanceux():
    eq_(tous_chanceux(100), [2, 3, 5, 11, 17, 41])

def test_erathos():
    expected = [2, 3, 5, 7, 11, 13, 17, 19]
    eq_(erathos(20), expected)

def test_encode():
    eq_(decode(encode("Bonjour à tous", 7), 7), "Bonjour à tous")

def test_rot13():
    eq_(rot13("Bonjour à tous"), 'Obawbhe à gbhf')
    eq_(rot13(rot13("Bonjour à tous")), "Bonjour à tous")
