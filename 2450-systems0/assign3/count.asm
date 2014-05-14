;
;  Programmer: Lacy Morrow
;  Userid: tlm
;  Purpose: This program accepts an input string
;  and counts the occurrences in a list
;
; load
		.ORIG x3000	; load program in memory location x3000
START		LEA R1, INPUT	; R1 holds first location of string
		AND R2, R2, #0	; set R2 to 0
		LEA R0, PROMPT	; load prompt address
		PUTS		; TRAP displays prompt

; get input
ILOOP		GETC		; get user input
		ADD R4, R0, #-10; check lf
		BRz CONT	; user hit return
		OUT		; output user input
		STR R0, R1, #0	; stores chars***
		ADD R1, R1, #1	; increment r1
		ADD R2, R2, #1	; increment r2
		BRnzp ILOOP	; loop to accept next char
CONT		LD R0, NL	; R0 gets newline
		OUT		; newline
		LD R0, INPUT	; R0 gets first char
		BRz START	; check no str
		AND R0, R0, #0	; R0 gets 0
		STR R0, R1, #0	; NULL end of string
;display
		LEA R0, TXT	; load prompt address
		PUTS		; TRAP displays prompt
		LEA R1, INPUT	; R1 holds first location of string
DISP		LDR R0, R1, #0	; load char into R0
; R0 should be first input
		BRz CHECK	; if NULL
		OUT		; display char
		ADD R1, R1, #1	; increment R1
		BRnzp DISP	; loop
CHECK		LEA R0, TXT2	; load prompt address
		PUTS		; TRAP displays prompt
; count
		AND R5, R5, #0	; R5 gets 0- match count
		LEA R0, POINTER	; R0 gets first string address
		LEA R1, INPUT	; R1 gets first input address
NEXT		LDR R4, R0, #0	; R4 gets string char address
NEXTCHR		LDR R2, R1, #0	; R2 gets input char
		LDR R3, R4, #0	; R3 gets string char
		NOT R2, R2	; R2 gets neg
		ADD R2, R2, #1	; R2 + 1
		ADD R3, R3, R2	; check match
		BRnp NXTWORD	; no match
MATCH		ADD R5, R5, #1	; R5 increment-  match
		ADD R1, R1, #1	; R1 increment- char count
		LDR R2, R1, #0	; R2 gets input char
		BRnp NXTWORD	; not null
		ADD R4, R4, #1	; R4 increment
		BRnzp NEXTCHR
NXTWORD		ADD R0, R0, #1	; R0 increment
		LDR R3, R0, #0	; R2 gets R0 val
		BRnp NEXT	; check end of list
;results		
DONE		LD R0, ASCII	; R0 gets 48
		ADD R0, R5, R0	;load ASCII number
		OUT
END		HALT	

ASCII		.FILL x0030
NL		.FILL x000A
POINTER  	.FILL STRING1
		.FILL STRING2
		.FILL STRING3
		.FILL STRING4
		.FILL STRING5
		.FILL STRING6
		.FILL STRING7
		.FILL STRING8
		.FILL STRING9
		.FILL STRING10
		.FILL STRING11
		.FILL STRING12
		.FILL STRING13
		.FILL STRING14
		.FILL STRING15
		.FILL STRING16
		.FILL STRING17
		.FILL STRING18
		.FILL STRING19
		.FILL STRING20
		.FIll 0
PROMPT		.STRINGZ "Enter a String > "
TXT		.STRINGZ "The number of times "
TXT2		.STRINGZ " appears in the list is "
STRING1		.STRINGZ "apple"
STRING2		.STRINGZ "kiwi"
STRING3		.STRINGZ "orange"
STRING4		.STRINGZ "pear"
STRING5		.STRINGZ "apple"
STRING6		.STRINGZ "pear"
STRING7		.STRINGZ "banana"
STRING8		.STRINGZ "apple"
STRING9		.STRINGZ "fig"
STRING10 	.STRINGZ "pig"
STRING11 	.STRINGZ "bacon"
STRING12 	.STRINGZ "pig"
STRING13  	.STRINGZ "gnat"
STRING14  	.STRINGZ "pig"
STRING15  	.STRINGZ "banana"
STRING16 	.STRINGZ "fig"
STRING17 	.STRINGZ "kiwi"
STRING18 	.STRINGZ "papaya"
STRING19 	.STRINGZ "pineapple"
STRING20 	.STRINGZ "bacon"
INPUT		.BLKW 50
		.END
