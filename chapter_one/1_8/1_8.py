'''
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, it's entire row and column are set to
0.
'''


def zero_matrix(mat):
    xs = []
    ys = []

    for i in range(len(mat)):
        for j in range(len(mat[i])):
            if mat[i][j] == 0:
                xs.append(i)
                ys.append(j)


    for i in range(len(mat)):
        for j in range(len(mat[i])):
            if i in xs or j in ys:
                mat[i][j] = 0

    return mat


a = [[1, 2, 3], [4, 0, 6], [7, 8, 9]]
print(zero_matrix(a))

b = [[1, 2, 3, 4], [5, 0, 7, 8], [9, 10, 0, 12],[13, 14, 15, 16]]
print(zero_matrix(b))


