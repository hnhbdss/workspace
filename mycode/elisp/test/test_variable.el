(setq x 1)
x
(let ((x 2))
  (makunbound 'x))

(defun getx ()
  x)

(let ((x 1))
  (getx))

(defvar my-ticker nil)

(let ((x 0))
  (setq my-ticker (lambda () (setq x (1+ x)))))

(funcall my-ticker)

x

(setq foo 5)
(make-local-variable 'foo)
(setq foo 6)

(with-current-buffer "*Help*"
                      foo)

(local-variable-p 'foo)
