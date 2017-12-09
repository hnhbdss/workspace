(fresh-line)
(do ((x))
    ((equal x ""))
  (setf x (read-line))
  (write-line x))

(format t "~d" 111111)
(format t "~:d" 111111)
(format t "~@d" 111111)

(format t "~4$" 11.1111)
(format t "~s" 11.1111)

(saveinitmem "/home/lili/workspace/mycode/lisp/myinit.mem")
