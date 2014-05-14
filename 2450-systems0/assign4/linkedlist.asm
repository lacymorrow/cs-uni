;
; LinkedList
; By Lacy Morrow: morrowtl
; Reads a linked list of nodes, adds up the sum of their values, then converts to a string and outputs.
;
.orig x3000
MAIN: LEA R0, NODE0	; address of first node
			; call SUMLIST to sum the values of the nodes; result is returned in R0
JSR SUMLIST
			; call NUMTOSTR to convert the number to a string
			; address of string is returned in R0
JSR NUMTOSTR
			; store the address in R1
AND R1, R0, R0
			; print the result
LEA R0, STRNG
PUTS
AND R0, R1, R1
PUTS
LEA R0, NEWLN
PUTS
HALT

			; The output message
STRNG .STRINGZ "The sum of the nodes in the linked list is "
NEWLN .STRINGZ "\n"

SUMLIST: ; R2 is working value, R1 is sum, R0 is addr. Adds the values in a linked list and stores sum to R0
AND R1, R1, #0	; R1 = 0
SLOOP LDR R2, R0, #0	; get value from addr
ADD R1, R1, R2	; add to sum
LDR R0, R0, #1	; obtain addr
BRnp SLOOP	; loop list
ADD R0, R1, #0	; return result in R0
RET

;
; Here is the linked list. Like a linked list in a high level 
; language, the nodes aren't in consecutive locations.
;
NODE8: .FILL 9
.FILL NODE9
.FILL 0
NODE0: .FILL 3
.FILL NODE1
.FILL 0
NODE4: .FILL 1
.FILL NODE5
.FILL 0
NODE2: .FILL 5
.FILL NODE3
.FILL 0
NODE1: .FILL 4
.FILL NODE2
NODE9: .FILL 8
.FILL 0 
NODE3: .FILL 7
.FILL NODE4
.FILL 0
NODE5: .FILL 5
.FILL NODE6
.FILL 0 
NODE6: .FILL 9
.FILL NODE7
.FILL 0
NODE7: .FILL 9
.FILL NODE8
.FILL 0


NUMTOSTR:	; R3 is working divisor, R2 is result add, R1 is divisor addr, R0 is working sum. Creates string from numerical value and stores start addr to R0.
LEA R1, DIVISORS	; loads divisor addr
LEA R2, RESULT		; loads result add
TOP:
LDR R3, R1, #0	; loads current divisor
BRz DONE	; is DIVISOR 0?

NOT R3,R3	; !R3 neg divisor
ADD R3, R3, #1	; R3 + 1
ADD R4, R3, R0	; add to sum
BRzp GOOD	; check ok to subtract

ADD R1, R1, #1	; increment divisor addr
LDR R3, R2, #0	; load value
BRnp NEXT	; no stored num
LDR R3, R2, #-1	; load value
BRz TOP
LDR R3, R2, #0

NEXT LD R4, THIRTY
ADD R3, R3, R4	; add 30 for ASCII
STR R3, R2, #0	; store value
ADD R2, R2, #1	; increment result add

BRnzp TOP	; loop

GOOD  ADD R0, R3, R0	; do subtraction
LDR R3, R2, #0	; load value
ADD R3, R3, #1	; add 1
STR R3, R2, #0	; store value
BRnzp TOP

DONE AND R3, R3, #0	; R3 = 0
LEA R0, RESULT	; loads result str add
RET

.FILL 0
RESULT:
.BLKW 6
; list of denominators
DIVISORS:
.FILL 10000

.FILL 1000

.FILL 100

.FILL 10

.FILL 1

.FILL 0

THIRTY:
.FILL x30
.END