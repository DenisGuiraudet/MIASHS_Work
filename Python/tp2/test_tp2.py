
from tp2 import *
from nose.tools import eq_

import copy

def test_mega():
    daltons = ListePriorite()
    assert daltons.empty
    eq_(daltons.prio_min, None)
    eq_(daltons.prio_max, None)

    daltons.add(5, "Joe")
    daltons.add(1, "Jack")
    daltons.add(3, "Averell")
    daltons.add(4, "William")
    daltons.add(1, "Ma")
    daltons.add(10, "Jack")

    assert not daltons.contains("Lucky Luke")
    assert daltons.contains("Averell")

    eq_(daltons.priorities_of("Jack"), [1, 10])

    daltons.pop()  # Supprime le dernier élément (10, "Jack")

    # eq_(daltons, "[(1, 'Jack'), (1, 'Ma'), (3, 'Averell'), (4, 'William'), (5, 'Joe')]")

    eq_(daltons.prio_min, 1)
    eq_(daltons.prio_max, 5)

    eq_(daltons.length, 5)

    eq_(daltons.at(0), (1, "Jack"))

    val = daltons.pop()
    # eq_(daltons, "[(1, 'Jack'), (1, 'Ma'), (3, 'Averell'), (4, 'William')]")
    eq_(val, (5, 'Joe'))

    eq_(daltons.prio_min, 1)
    eq_(daltons.prio_max, 4)

    outlaws = copy.deepcopy(daltons)
    daltons.delete(0)
    eq_(daltons, [(1, 'Ma'), (3, 'Averell'), (4, 'William')])
    # eq_(outlaws, "[(1, 'Jack'), (1, 'Ma'), (3, 'Averell'), (4, 'William')]")
