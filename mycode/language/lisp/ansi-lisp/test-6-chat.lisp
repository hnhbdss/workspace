(defun single? (lst)
  (and (consp lst) (null (cdr lst))))

(defun append1 (lst obj)
  (append lst (list obj)))

(defun map-int (func n)
  (let ((acc nil))
    (dotimes (i n)
      (push (funcall func i) acc))
    (reverse acc)))

(defun filter (fn lst)
  (let ((acc nil))
    (dolist (i lst)
      (let ((val (funcall fn i)))
        (if val (push val acc))))
    (nreverse acc)))
        

(defun most (fn lst)
  (if (null lst)
      (values nil nil)
    (let* ((max (car lst))
          (max-value (funcall fn max)))
      (dolist (n (cdr lst))
        (let ((next-value (funcall fn n)))
          (if (< max-value next-value)
              (setf max n max-value next-value))))
      (values max max-value))))
      
(defun compose (fns)
  (destructuring-bind (fn . rest) (reverse fns)
                      #'(lambda (&rest args))))

(defun disjoin (fns))

(defun misjoin (fns))



(defun myadder2 (x) 
  #'(lambda (x) (+ 2 x)))

  
            
