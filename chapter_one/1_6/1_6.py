"""
 The Question is as follows:
 Implement a method to perform basic string compression using
 the counts of repeated characters. For example, the string
 aabcccccaaa would become a2b1c5a3. If the "compressed" string
 would not become smaller than the original string, your method
 return the original string. You can assume the string has only
 uppercase and lowercase letters
"""

"""
My solution is O(n)
"""


def string_compressor(string):
    if len(string) < 2:
        return string

    res = ""
    char_count = 0
    cur_char = None
    for i in string:
        #print("{}{}".format(cur_char, i))
        if not cur_char:
            cur_char = i
            char_count += 1
        elif i == cur_char:
            char_count += 1
        else:
            res += cur_char
            res += str(char_count)
            char_count = 1
            cur_char = i
    res += cur_char
    res += str(char_count)

    if len(string) < len(res):
        return string
    else:
        return res


print(string_compressor("aabcccccaaa"))
print(string_compressor("hello"))
