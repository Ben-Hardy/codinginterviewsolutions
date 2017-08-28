C=gcc
CFLAGS=-Wall -pedantic -std=c99

executables=urlify

urlify.o: urlify.c
	$(C) $(CFLAGS) urlify.c -o urlify

clean:
	rm -rf urlify

run:
	./urlify
