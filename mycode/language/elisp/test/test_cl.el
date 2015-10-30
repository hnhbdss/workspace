(require 'cl-lib)

(cl-oddp 6)

(cl-defun myadder (x)
  (+ x 2))

(myadder 3)
(format "hello world %S" "hello world")
(standard-case-table)

(make-list 3 'pigs)
(car (make-list 3 'pigs))
(setq trees '(pine oak))
(append trees nil)

(setq x '(1 2 3))
(nconc x '(4 5))

(defun add-foo (x)
  (nconc '(foo) x))

(symbol-function 'add-foo)

(setq z (add-foo '(1 3)))

(setq nums '(1 3 2 6 5 4 0))

(sort nums '<)
(sort nums '>)

(equal '(2) '(2))
(eq '(2) '(2))
