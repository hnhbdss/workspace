(defmacro quick-sort (&rest params) 
  `(quick-sort-1 ',params))

(defun quick-sort-1 (params) 
  (if (null params)
      nil
      (let* ((len (length params))
	     (mid (floor (/ len 2)))
	     (left nil)
	     (right nil)
	     (mid-value (elt params mid)))
	(if (= len 1) 
	    params
	    (progn 
	      (loop for e in 
		   (append (subseq params 0 mid)
			   (subseq params (+ mid 1) len)) do 
		   (if (< e mid-value) 
		       (push e left)
		       (push e right)))
	      (append 
	       (quick-sort-1 (reverse left))
	       (list mid-value)
	       (quick-sort-1 (reverse right))))))))

