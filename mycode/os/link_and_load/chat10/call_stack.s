	.file	"call_stack.c"
	.text
	.globl	return_test
	.type	return_test, @function
return_test:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movq	%rdi, -136(%rbp)
	movb	$0, -128(%rbp)
	movq	-136(%rbp), %rax
	movq	-128(%rbp), %rdx
	movq	%rdx, (%rax)
	movq	-120(%rbp), %rdx
	movq	%rdx, 8(%rax)
	movq	-112(%rbp), %rdx
	movq	%rdx, 16(%rax)
	movq	-104(%rbp), %rdx
	movq	%rdx, 24(%rax)
	movq	-96(%rbp), %rdx
	movq	%rdx, 32(%rax)
	movq	-88(%rbp), %rdx
	movq	%rdx, 40(%rax)
	movq	-80(%rbp), %rdx
	movq	%rdx, 48(%rax)
	movq	-72(%rbp), %rdx
	movq	%rdx, 56(%rax)
	movq	-64(%rbp), %rdx
	movq	%rdx, 64(%rax)
	movq	-56(%rbp), %rdx
	movq	%rdx, 72(%rax)
	movq	-48(%rbp), %rdx
	movq	%rdx, 80(%rax)
	movq	-40(%rbp), %rdx
	movq	%rdx, 88(%rax)
	movq	-32(%rbp), %rdx
	movq	%rdx, 96(%rax)
	movq	-24(%rbp), %rdx
	movq	%rdx, 104(%rax)
	movq	-16(%rbp), %rdx
	movq	%rdx, 112(%rax)
	movq	-8(%rbp), %rdx
	movq	%rdx, 120(%rax)
	movq	-136(%rbp), %rax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	return_test, .-return_test
	.globl	main
	.type	main, @function
main:
.LFB1:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	addq	$-128, %rsp
	leaq	-128(%rbp), %rax
	movq	%rax, %rdi
	movl	$0, %eax
	call	return_test
	movl	$0, %eax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1:
	.size	main, .-main
	.ident	"GCC: (Debian 4.7.2-5) 4.7.2"
	.section	.note.GNU-stack,"",@progbits
