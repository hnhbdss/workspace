(when t
  (princ "hello world")
  (princ "dss")
  2)

(eq 'success 'success)

(defun get-return-code2 (x) 
  "do get return code2"
  (if (eq x 1) 
      'success 
    (if (eq x 2)
        'world-block
      (if (eq x 3)
          'read-only
        (if (eq x 4)
            'access-denied
          100)))))

     (pcase (get-return-code2 5)
       (`success       (message "Done!"))
       (`would-block   (message "Sorry, can't do it now"))
       (`read-only     (message "The shmliblick is read-only"))
       (`access-denied (message "You do not have the needed rights"))
       (code           (message "Unknown return code %S" code)))


(setq tt '(1 3 4))
(dolist (elt tt)
  (princ elt))

(defun foo-outer ()
  (catch 'foo
    (foo-inner)))

(defun foo-inner ()
  (let ((x 0))
    (if x
        (throw 'foo 100))))

(foo-outer)
(error "You have committed %d errors" 10)

(put 'new-error 
     'error-conditions
     '(error my-own-errors new-error))

(put 'new-error 'error-message "A new error")

(signal 'new-error '(x y))

(condition-case foo
    (bar nil t)
  (my-own-errors nil))
(setq a :aa)

(keywordp a)
(keywordp :aa)
