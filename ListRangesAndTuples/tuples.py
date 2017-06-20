__author__ = "Jackie"

#
# t = ("a", "b", "c")
# print(t)
#
# print("a", "b", "c")
# print(("a", "b", "c"))

welcome = "Welcome to my Nightmare", "Alice Cooper", 1975
bad = "Bad Company", "Bad Company", 1974
budgie = "Nightflight", "Budgie", 1981

# unpacking the tuple
# title, artist, year, tracks = imelda
# print(title)
# print(artist)
# print(year)
# print(tracks)

# title, artist, year, track1, track2, track3, track4 = imelda
# print(title)
# print(artist)
# print(year)
# print(track1)
# print(track2)
# print(track3)
# print(track4)
#
# imelda = "More Mayhem", "Imilda May", 2011, ((1, "Pulling the Rug"), (2, "Psycho"), (3, "Mayhem"), \
# 		 (4, "Kentish Town Waltz"))
#
# title, artist, year, tracks = imelda
# print("Album Title: " + title)
# print("Artist: " + artist)
# print("Year Released: " + str(year))
# print("Tracks: ")
#
# for song in tracks:
# 	print("\t" + str(song[0]) + " " + song[1])

imelda = "More Mayhem", "Imilda May", 2011, [(1, "Pulling the Rug"), (2, "Psycho"), (3, "Mayhem"),
	(4, "Kentish Town Waltz")]

print(imelda)

imelda[3].append((5, "All For You"))

title, artist, year, tracks = imelda
tracks.append((6, "Eternity"))
print(title)
print(artist)
print(year)
for song in tracks:
	track, title = song
	print("\tTrack number {}, Title: {}". format(track, title))








