(secure-hash 'sha1 "hello world")
(secure-hash 'sha224 "hello world")
(transpose-regions 1 35 37 69)

(base64-encode-region 1 35)

(base64-encode-string "hello world")
(base64-decode-string "aGVsbG8gd29ybGQ=")


(set-register 'a "hello")
(view-register 'a)
(get-register 'a)

(insert-register 'a)
