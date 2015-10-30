(message "%s" (read t))

(get-buffer-create "*foo*"

(read (get-buffer "*foo*"))

(eval-expression (read "(print \"heloo\")"))

(print "hello world dushishuang " (get-buffer "*foo*"))

(terpri (get-buffer "*foo*"))

(write-char ?\77)

(eval-minibuffer "hello")
(princ "ls -tlr\n\n" (get-buffer "dss.shell"))

(with-current-buffer "dss.shell"
  (shell))

(read-directory-name "hello:")
insert-default-directory

(active-minibuffer-window)

(minibuffer-window)

(execute-extended-command 3)

     (defun display-prefix (arg)
       "Display the value of the raw prefix arg."
       (interactive "P")
       (message "%s" arg))


          (defun simple-rec ()
            (forward-word 1)
            (message "Recursive edit in progress")
            (recursive-edit)
            (forward-word 1))

(simple-rec)



"Hello World"

