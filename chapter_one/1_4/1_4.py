'''
1.4 Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards or backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be
limited to just dictionary words.
'''

'''
My solution is pretty simple. Given that we are looking for palindromes, we know
that a certain amount of symmetry is required in the words we are looking at.
For even palindromes, each letter must have a buddy that is the same that can go
on the other half of the palindromes. For odd palindromes, all letters must have
a buddy except one letter.

An easy way to check for these pairs of buddies is to use a stack. Each time you
encounter a letter, check if it is in the stack. If it isn't, then add it. If it
is, then remove it because that means it has been encountered. For even numbers
of letters, the word will qualify as a palindrome if at the end of the word the
stack is empty. For odd numbers of letters, there should be exactly one letter in
the stack.
'''

'''
For simplicity, I'm going to make all characters lowercase and skip whitespace
since the example in the book implies whitespace is ignored
'''


def is_palindrome_permutation(word):
    if not word:
        return False

    letter_stack = []
    word = "".join(word.lower().split())

    for i in word:
        if i not in letter_stack:
            letter_stack.append(i)
        elif i in letter_stack:
            letter_stack.remove(i)

    if len(word) % 2 == 0 and len(letter_stack) == 0:  # even length palindrome
        return True
    elif len(word) % 2 == 1 and len(letter_stack) == 1:  # odd length palindrome
        return True
    else:
        return False


print(is_palindrome_permutation("Tact Coa"))  # odd palindrome
print(is_palindrome_permutation("Tact Ca"))  # even palindrome
print(is_palindrome_permutation("Tact ab"))  # even and not a palindrome
print(is_palindrome_permutation("Tabs a"))  # odd and not a palindrome
