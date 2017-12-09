(defun month-length (mon)
  (case mon
    ((jan mar may jul aug oct dec) 31)
    ((apr jun sept nov) 30)
    (feb 29)
    ;(feb (if (leap-year) 29 28))
    (otherwise "unknown month")))

(defun compute-execusive (x)
  (when (< x 5)
    (return-from compute-execusive x))
  (* x x))

(defun precedes (x vec)
  (let ((nvec (reverse vec)))
    (maplist #'(lambda (e) 
		 (when (and (consp (cdr e))
			    (char= (cadr e) x))
		   (cadr e))) nvec)))

		   
    

  