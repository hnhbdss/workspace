(defun read-integer (str) 
  (if (every #'digit-char-p str)
      (let ((accum 0))
	(dotimes (pos (length str) accum)
	  (setf accum (+ (* accum 10) 
			 (digit-char-p (char str pos)))))
	accum)
      nil))

(defstruct point 
  x
  y)

(defstruct (node (:print-function (lambda (p s d) 
				      (format s "#node<~A>" (node-elt p)))))
  elt 
  (l nil)
  (r nil))

(defun bst-insert (obj bst less)
  (if (null bst)
      (make-node :elt obj)
      (let ((value (node-elt bst)))
	(if (equal value obj)
	    bst
	    (if (funcall less obj value)
		(make-node :elt value
			   :l (bst-insert obj (node-l bst) less)
			   :r (node-r bst))
		(make-node :elt value
			   :r (bst-insert obj (node-r bst) less)
			   :l (node-l bst)))))))

(defparameter nums nil)

(dolist (x '(5 8 4 2 1 9 6 7 3))
  (setf nums (bst-insert x nums #'<)))

(defun bst-find (obj bst less) 
  (if (null bst)
      nil
      (let ((value (node-elt bst)))
	(if (equal value obj)
	    bst
	    (if (funcall less obj value)
		(bst-find obj (node-l bst) less)
		(bst-find obj (node-r bst) less))))))


(bst-find 9 nums #'<)

(defun bst-min (bst)
  (and bst 
       (or (bst-min (node-l bst)) bst)))
(bst-min nums)

(defun bst-max (bst)
  (and bst 
       (or (bst-max (node-r bst)) bst)))

(bst-max nums)