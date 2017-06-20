__author__ = "jackie"

# string = "1234567890"
# my_iterator = iter(string)
# print(my_iterator)
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))
# print(next(my_iterator))

# for char in string:
# 	print(char)
#
# for char in iter(string):
# 	print(char)

my_cell_number = "6463096310"
my_cell_iterator = iter(my_cell_number)

for n in range(0, len(my_cell_number)):
	print(next(my_cell_iterator))

