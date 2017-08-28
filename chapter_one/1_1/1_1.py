'''
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional
data structures?
'''

import unittest

is_unique = lambda string: len(set(string)) == len(string)


class Test(unittest.TestCase):
    def tests(self):
        self.assertEqual(is_unique("Ben"), True)
        self.assertEqual(is_unique("hello"), False)


if __name__ == "__main__":
    unittest.main()