(kill-all-local-variables)
(buffer-local-variables)


(subrb 'message)


(setf f 'list)
(apply f '(x y z))

(apply '+ 1 3 '(3 4))


(defun mapcar* (function &rest args) 
   "Appy function to succesive cars of all Args.
Return the list of results."
     ;; if no list is exhausted,
     (if (not (memq nil args))
     ;;apply function to cars
     (cons (apply function (mapcar 'car args))
           (apply 'mapcar* function (mapcar 'cdr args)))))

(mapcar* 'cons '(a b c) '(1 2 3 4))

(defun bar (n) (+ 2 n))

(symbol-function 'bar)
(fset 'baz 'bar)
(symbol-function 'baz)
(baz 2)

(defun my-closure (x)   
       (lambda () (* 2 x)))

(setq ff (my-closure 3))

(funcall ff)

(function ff)

(fset 'fff (my-closure 3))

(funcall 'fff)

(symbol-function 'fff)

(defun my-func1 (x)
       (declare '(obsolete my-func1 "22.1"))
       (+ 1 x))



        