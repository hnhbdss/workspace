(let (arg result)
  (setq arg "#include <sys/linux/sys.h>")
  
(defun ff-string (arg)
  "Prompt user to enter a string with input history support."
  (interactive (list (read-string "Please input your name:")))
  (message "Your name is :%s" arg))

(require 'find-lisp)
(mapc 'my-process-file (find-lisp-find-files))

(setq v (vector 1 3 4))
(setq v [1 3 4])
(length v)
(elt v 1)

(mapcar '1+ v)

(vconcat [1 3 4] [4 6 7])
(append [1 34 8] nil)

(setq li '(1 34 8))
(car li)
(cdr li)
(nthcdr 2 li)
(last li)
(cons "a" (list "b" "c" "d"))


(let (myhash)
  (setq myhash (make-hash-table :test 'equal))
  (puthash "dss" "1" myhash)
  (puthash "lili" "2" myhash)
  (puthash "lili" "3" myhash)
  (puthash "lucy" "4" myhash)
  (remhash "lucy" myhash)
  (message "%s" (gethash "lili" myhash))
  (message ",%d" (hash-table-count myhash)))
(let ((mystr "hello world 444 lucy 888 lili"))
  (string-match "\([0-9]+\)" mystr)
  (message "%d , %d" (match-beginning 0) (match-end 0)))

(setq x1 123)
(symbolp x1)
(setq x3 'xx)
(symbolp x3)

(subrp (symbol-function 'goto-char))
(subrp (symbol-function 'lambda))

(subrp (symbol-function 'ff-string))

(require 'clisp)
(featurep 'clisp)


(message "%S" list-colors-sort-key)

(print (list "34" "44"))

(format-time-string "%z")
(format-time-string "%Y-%m-%dT%T")

(format-time-string "%s")

(print (elt argv 0))

(length argv)

(setq mykeywords 
      '(("Sin\\|Cos\\|Sum" . font-lock-function-name-face)
        ("Pi\\|Infinity" . font-lock-constant-face)))
(define-derived-mode math-lang-mode fundamental-mode
  (setq font-lock-defaults '(mykeywords))
  (setq mode-name "math lang"))

(print (regexp-opt (list "hwlo" "wodl" "nihao1" "asdkf" "ad234")))

(setq a '((1 . 1) (2 . 2)))
(setq b `((1 . 1) (2 . 2)))


(try-completion "hello" '("helloworld", "hello2"))
(setq meat "hello")

(with-output-to-temp-buffer "*Completions*"
                         (display-completion-list
                          (all-completions meat '("hellowold", "hello3"))
                          meat))
(let* (
       (suffixmap
        '(("pl" . "perl")
          ("rb" . "ruby"))))
  (cdr (assoc "rb" suffixmap)))

(string-match-p "https?://" "wwhttp://")

(with-temp-buffer
  (insert-file-contents "~/workspace/mycode/elisp/test/test.el"))
(require 'json)
(require 'url)
(require 'w3m)

(require 'find-lisp)

(find-lisp-find-files "./../../" "\\.cpp$")

(let (mylist)
  (setq mylist '(("a1" . "b1") ("a2" . "b2")))
  (rassoc "b2" mylist)
  (assoc "a2" mylist))

(require 'sgml-mode)
(sgml-delete-tag 1)
<html> <body> </body> </html>

(funcall 'html-mode)

(html-mode)

(funcall 'lisp-mode)

(funcall 'emacs-lisp-mode)

(browse-url "www.ustc.edu.cn")

(getenv "PATH")

(message "%s" load-file-name)
(message "%s" buffer-file-name)

(expt 16 4)
(expt 4 16)

(user-uid)
(emacs-pid)
(system-name)
(user-full-name)
(current-time)
(emacs-uptime)
(garbage-collect)
(recent-keys)


