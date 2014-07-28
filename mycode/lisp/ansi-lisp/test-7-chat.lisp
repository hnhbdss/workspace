(defparameter path (make-pathname :name "mybook" :directory "/home/lili/"))
(defparameter myoutput (open path :direction :output :if-exists :supersede))

(format myoutput "hello world~%")
(force-output myoutput)
(close myoutput)

(with-open-file (f "~/mybook2" :direction :output :if-exists :supersede)
  (format f "lili~%"))

(defun persedu-cat (file-name) 
	     (with-open-file (f file-name  :direction :input)
	       (do ((line (read-line f nil 'eof)
			  (read-line f nil 'eof)))
		   ((equal line 'eof))
		 (format t "~A~%" line))))