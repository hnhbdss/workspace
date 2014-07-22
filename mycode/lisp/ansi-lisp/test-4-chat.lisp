(defun read-integer (str) 
  (if (every #'digit-char-p str)
      (let ((accum 0))
	(dotimes (pos (length str) accum)
	  (setf accum (+ (* accum 10) 
			 (digit-char-p (char str pos)))))
	accum)
      nil))
		    