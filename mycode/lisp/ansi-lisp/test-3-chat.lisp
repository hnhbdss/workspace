(defun shortest-path (start end net)
  (bsf-path start (list (list end)) net))

(defun bsf-path (end queue net)
  (if (null queue)
      nil
    (let ((head (car queue)))
      (let ((node (car head)))
        (if (eql node end)
            (reverse head)
          (bsf-path 
           (append (cdr queue)
                   (build-newpaths (node head net)))))))))

(defun build-newpaths (node queue net)
  (mapcar #'(lambda (x) (cons x (assoc node net))) (cdr queue)))

  
                    
           
