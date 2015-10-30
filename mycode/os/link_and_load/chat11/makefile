all:tls
tls:tls.o
	gcc -o $@ $^	
tls.o:tls.s
	gcc -c -o $@ $^	
tls.s:tls.c
	gcc -S -o $@ $^	
