all:test_portuguese.pdf
test_portuguese.pdf:test_portuguese.tex
	latex test_portuguese.tex
	dvipdf test_portuguese.dvi

clean:
	rm -rf test_portuguese.dvi
	rm -rf test_portuguese.pdf
	rm -rf test_portuguese.log
	rm -rf test_portuguese.aux
	rm -rf test_portuguese.synctex.gz
	rm -rf test_portuguese.ps
	rm -rf test_portuguese.toc
