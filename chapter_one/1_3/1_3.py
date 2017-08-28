'''
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
space at the end to hold the additional characters, and that you are given the length of the string (Note: if
implementing in Java, please use a character array so that you can  perform this operation in place)
'''

# see urlify.c for in-place version. This is the Pythony way of doing this. Super easy
urlify = lambda string: "%20".join(string.split())

print(urlify("hello there  "))
print(urlify("Mr John Smith    "))
