(emacs-version t) 
 GNU Emacs 24.3.1 (x86_64-unknown-linux-gnu, GTK+ Version 3.4.2)
 of 2013-06-19 on lili-debian

(message "%s" emacs-build-time)
(message "%s" emacs-version)

(message "%c" ?\b) 

(message "%c" ?\uddee)

(symbol-name 'foo)

(setq sym (make-symbol "foo"))
(eq sym 'foo)

(setq sym2 (intern "foo"))
(eq sym2 'foo)

(intern-soft "frazzle")
(make-symbol "frazzle")
(intern-soft "frazzle")
(setq sym (intern "frazzle"))
(intern-soft "frazzle")

(eq sym 'frazzle)

(memq 'b '(a b c d e))

(setq x '((1.a) (2.b)))
(setq x '((1 . a) (2 . b)))

(assoc-default '2 x)
(assoc '2 x)

(setq y (copy-alist x))
(eq x y)
(equal x y)
(eql x y)

(sequencep [1 3])
(sequencep "hellowo")

(length [1 3])

(length (make-bool-vector 6 t))



