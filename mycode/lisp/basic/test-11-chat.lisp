(defparameter *v* (make-hash-table))

(setf (gethash 'foo *v*) 'quux)

(gethash 'foo *v*)

(defun show-value (key hash-table)
  (multiple-value-bind (value present) (gethash key hash-table)
    (if present
	(format t "value is present ~a~%" value)
	(format t "value is not present ~a~%" present))))

(show-value 'fooo *v*)

(setf (gethash "foo" *v*) 'quux)

(defparameter *v2* (make-hash-table :test 'equal))
(setf (gethash "foo" *v2*) 'quux)


  (multiple-value-bind (value present) (gethash "foo" *v2*)
    (if present
	(format t "value is present ~a~%" value)
	(format t "value is not present ~a~%" present))))

(maphash #'(lambda (key value) (format t "key:~a,value:~a~%" key value)) *v*)

(loop for k being the hash-keys in *v* using (hash-value v)
     do (format t "~a => ~a~%" k v))

(clrhash *v*)

(defun dump-hash (table)
  (loop for k being the hash-keys in table using (hash-value v)
     do (format t "~a => ~a~%" k v)))

(reduce #'+ '(1 3 5 7 9))

(reduce #'+ '(1 3 5 7 9) :initial-value 100)

(map 'vector #'+ '(1 3 5 7) '(2 4 6 8))

