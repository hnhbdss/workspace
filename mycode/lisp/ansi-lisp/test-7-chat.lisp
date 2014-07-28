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
(defstruct buf
  vec (start -1) (end -1) (used -1) (new -1))

(defun bref (buf n)
  (svref (buf-vec buf)
	 (mod n (length (buf-vec buf)))))

(defun (setf bref) (val buf n)
  (setf (svref (buf-vec buf)
	       (mod n (length (buf-vec buf)))) val))


(defun new-buf (len)
  (make-buf :vec (make-array len)))

(defun buf-insert (x b)
  (setf (bref b (incf (buf-end b))) x))

(defun buf-reset (b)
  (setf (buf-used b) (buf-start b)
	(buf-new b) (buf-end b)))

(defun buf-pop (b)
  (prog1 
      (bref b (incf (buf-start b)))
    (buf-reset b)))

(defun buf-next (b)
  (if (< (buf-used b) (buf-new b))
      (bref b (incf (buf-used b)))))

(defun buf-clear (b)
  (setf (buf-used b) -1
	(buf-start b) -1
	(buf-new b) -1
	(buf-end b) -1))

(defun buf-flush (b str)
  (do ((i (1+ (buf-used b)) (1+ i)))
      ((> i (buf-new b)))
    (princ (bref b i) str)))

(defun file-subst (new old file1 file2)
  (with-open-file (in file1 :direction :input)
    (with-open-file (out file2 :direction :output :if-exists :supersede)
      (stream-subst new old in out))))

(defun stream-subst (new old in out)
  (let* ((pos 0)
	 (len (length old))
	 (buf (new-buf len))
	 (from-buf nil))
    (do ((c (read-char in nil :eof)
	    (or (setf from-buf (buf-next buf))
		(read-char in nil :eof))))
	((eql c :eof))
      (cond ((char= c (char old pos)) ;char equal
	     (incf pos)
	     (cond ((= pos len)   ;all char equal 
		    (princ new out)
		    (setf pos 0)
		    (buf-clear buf))
		   ((not from-buf)  ; some chars equal
		    (buf-insert c buf))))
	    ((zerop pos) ; first char not equal 
	     (princ c out)
	     (when from-buf
	       (buf-pop buf)
	       (buf-reset buf)))
	    (t ; some chars equal, then now not equal
	     (unless from-buf
	       (buf-insert c buf))
	     (princ (buf-pop buf) out)
	     (buf-reset buf)
	     (setf pos 0))))
    (buf-flush buf out)))

(file-subst "baro" "baric" "c:/cygwin/home/oam/work/workspace/mycode/lisp/ansi-lisp/test1" "c:/cygwin/home/oam/work/workspace/mycode/lisp/ansi-lisp/test2")	

