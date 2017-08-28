'''
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

We will assume not counting whitespace since it doesn't specify
'''

import unittest

check_permutation = lambda str1, str2: sorted("".join(str1.split())) == sorted("".join(str2.split()))


class Test(unittest.TestCase):
    def tests(self):
        self.assertEqual(check_permutation("Ben", "ben"), False)
        self.assertEqual(check_permutation("hello", "ohell"), True)
        self.assertEqual(check_permutation("hello", "o h e l l  "), True)


if __name__ == "__main__":
    unittest.main()