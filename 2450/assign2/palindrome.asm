;
;  Programmer: Lacy Morrow
;  Userid: tlm
;  Purpose: This program accepts an input string
;  to determine if it is a palindrome.
;
; load
      	.ORIG x3000     ; load program starting in memory location x3000
START	LEA R1, TXT     ; R1 holds first location of string
        AND R2, R2, #0	; set R2 to 0
        LEA R0, PROMPT  ; load prompt address
        PUTS            ; TRAP displays prompt

; get input
ILOOP   GETC            ; get user input
        ADD R4, R0, #-10; check lf
	BRz CONT	; user hit return
        OUT             ; output user input
        STR R0, R1, #0  ; stores chars***
	ADD R1, R1, #1	; increment r1
        ADD R2, R2, #1  ; increment r2
        BRnzp ILOOP	; loop to accept next char
CONT	LD R0, NL	; R0 gets newline
	OUT		; newline
	LD R0, TXT	; R0 gets first char
	BRz START	; check no str
	AND R0, R0, #0	; R0 gets 0
	STR R0, R1, #0	; NULL end of string
;display
	LEA R1, TXT     ; R1 holds first location of string
DISP	LDR R0, R1, #0	; load char into R0
	BRz CHECK	; if NULL
	OUT		; display char
	ADD R1, R1, #1	; increment R1
	BRnzp DISP	; loop
; check
CHECK	LEA R1, TXT	; R1 gets first location
	NOT R4, R2	; R4 gets neg count
	LEA R2, TXT	; R2 gets first location
	ADD R4, R4, #1	; R4 + 1
CLOOP	NOT R3, R4	; R3 gets check length
	ADD R3,	R3, R1	; R3 gets last char check index
	NOT R0, R3	; R0 gets R3 flipped
	ADD R0, R0, R2	; check for loop halt : same location
	BRzp GOOD	; end of string, no fault
	LDR R3, R3, #0	; R3 gets val of last check char
	LDR R0, R2, #0	; R0 gets val of first check char
	NOT R3, R3	; R3 flipped
	ADD R3, R3, #1	; R3 + 1
	ADD R2, R2, #1	; increment R2
	ADD R4, R4, #1	; increment R4
	ADD R3, R3, R0	; check for symmetry
	BRz CLOOP	; match

BAD	LEA R0, BADSTR	; load bad prompt address
        PUTS            ; TRAP displays bad prompt
	BRnzp END	; goto end
GOOD	LEA R0, GOODSTR ; load good prompt address
        PUTS            ; TRAP displays good prompt

; output
END	HALT		; program end
; data
PROMPT  .STRINGZ "Enter a String > "
GOODSTR	.STRINGZ " is a palindrome."
BADSTR	.STRINGZ " is not a palindrome."
NL	.FILL x000A
TXT     .BLKW 50
        .END
