__author__ = "jackie"

# ipAddress = input("Please enter an IP address: ")
# print(ipAddress.count("."))

# parrot_list = ["non pinin'", "no more", "a stiff", "bereft of life"]
# parrot_list.append("A Norwegian Blue")
# for state in parrot_list:
# 	print("This parrot is " + state)
#
# even = [2, 4, 6, 8]
# odd = [1, 3, 5, 7, 9]
#
# numbers = even + odd
# numbers_in_order = sorted(numbers)
# print(numbers_in_order)
#
# if numbers == numbers_in_order:
# 	print("The lists are equal")
# else:
# 	print("The lists are not equal")
#
# if sorted(numbers) == numbers_in_order:
# 	print("The lists are equal")
# else:
# 	print("The lists are not equal")

# list_1 = []
# list_2 = list()
#
# print("List 1: {}".format(list_1))
# print("List 2: {}".format(list_2))
#
# if list_1 == list_2:
# 	print("The lists are equal")
#
# print(list("The lists are equal"))

# another_even = sorted(even, reverse=True)
# print(another_even)
# # Java this would be ==
# print(another_even is even)
# # Java this would be equals()
# print(another_even == even)
# another_even.sort(reverse=True)
# print(even)

# even = [2, 4, 6, 8]
# odd = [1, 3, 5, 7, 9]
#
# numbers = [even, odd]
#
# for number_set in numbers:
# 	print(number_set)
#
# 	for value in number_set:
# 		print(value)

menu = []
menu.append(["egg", "spam", "bacon"])
menu.append(["egg", "sausage", "bacon"])
menu.append(["egg", "spam"])
menu.append(["egg", "bacon", "spam"])
menu.append(["egg", "bacon", "sausage", "spam"])
menu.append(["spam", "bacon", "sausage", "spam"])
menu.append(["spam", "egg", "spam", "spam", "bacon", "spam"])
menu.append(["spam", "egg", "sausage", "spam"])

# print(menu)

for meal in menu:
	if "spam" not in meal:
		for ingredient in meal:
			print(ingredient)



