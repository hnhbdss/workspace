(assoc 1 '((1 . 2) (2 . 3) (3 . 4)))
(assoc 'a '((a . 2) (b . 3) (c . 4)))

(defparameter *v* '((1 . 3) (2 . 4)))
(push (cons 3 5) *v*)
(setf *v* (cons (cons 4 6) *v*))

(setf *v2* (copy-alist *v*))

(defparameter *v3* '(((1 . 1) . 3) (2 . 4)))

(defparameter *v4* (copy-alist *v3*))

(setf *v5* (pairlis '(a b c) '(1 2 3)))

(setf *plist1* '(:a 1 :b 2 :c 3))

(defun process-properties (plist keys)
  "process-properties"
  (loop while plist do 
       (multi-value-bind (key value remind) (get-propertis plist keys)


(destructuring-bind (x y z) (list 1 2 3)
  (list :x x :y y :z z))
