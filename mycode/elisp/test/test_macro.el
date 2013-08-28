(defmacro inc (var)
  (list 'setq var (list '1+ var)))

(defvar p 1)
(++ p)
(macroexpand '(++ p))


(defmacro for (var from init to final do &rest body)
  "Execute a simple for loop : (for i from 1 to 10 do (print i))."
  (let ((tempvar (make-symbol "max")))
    `(let ((,var ,init)
           (,tempvar ,final))
       (while (<= ,var ,tempvar)
         ,@body
         (inc ,var)))))
(for i from 0 to 3 do (print (format "hello %d" i)))

(macroexpand '(for i from 0 to 3 do (print (format "hello %d" i))))

(let ((i 0) (max 3)) (while (<= i max) (inc i)))

(setq a 'c)

(defmacro foo (a)
  (list 'setq (eval a) t))

(foo a)

(symbol-function 'run-prolog)

(autoload-do-load autoload &optional name macro-only)
