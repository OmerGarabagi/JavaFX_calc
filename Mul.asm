; 322471145, 50%
; 318678620, 50%
.ORIG X4000
Mul:
	ST R0, R0_SAVE_MUL 			;BACK UP THE REGISTERS
	ST R1, R1_SAVE_MUL
	ST R2, R2_SAVE_MUL
	ST R3, R3_SAVE_MUL
	ST R4, R4_SAVE_MUL
	ST R5, R5_SAVE_MUL
	ST R6, R6_SAVE_MUL
	ST R7, R7_SAVE_MUL
	
	AND R2,R2,#0				;R2=0
	ADD R0,R0,#0
	BRz MULTIPLY_BY_ZERO		; CHECK IF R0=0
	ADD R1,R1,#0
	BRz MULTIPLY_BY_ZERO		; CHECK IF R1=0
	ADD R1,R1,#0
	BRp MULTIPLY_POSITIVE		; CHECK IF THE MULTIPICATION IS WITH A POSITIVE NUMBER 
	ADD R1,R1,#0
	BRn MULTIPLY_NEGATIVE		; CHECK IF THE MULTIPICATION IS WITH A NEGATIVE NUMBER
		
	MULTIPLY_POSITIVE:			; MULTIPICATION WITH A POSITIVE NUMBER (LOOP)
		ADD R2,R2,R0		
		ADD R1,R1,#-1			; LOOP END CONDITION (IF R1=0)
		BRp MULTIPLY_POSITIVE   ; DO LOOP AGAIN
		BR END_MULTIPLY			; END MULTIPICATION

	MULTIPLY_NEGATIVE:			; MULTIPICATION WITH A NEGATIVE NUMBER (LOOP)
		ADD R2,R2,R0
		ADD R1,R1,#1			; LOOP END CONDITION (IF R1=0)
		BRn MULTIPLY_NEGATIVE   ; DO LOOP AGAIN
		NOT R2,R2				; MAKE R2 POSITIVE
		ADD R2,R2,#1
		BR END_MULTIPLY			; END MULTIPICATION

	MULTIPLY_BY_ZERO:			; CASE THE MULTIPICATION IS WITH ZERO
		AND R2,R2,#0			; MAKE RESULT 0
		BR END_MULTIPLY			; END MULTIPICATION

	END_MULTIPLY:
		LD R0, R0_SAVE_MUL		; RESTORE THE REGISTERS BACK UPS
 		LD R1, R1_SAVE_MUL
		LD R3, R3_SAVE_MUL	
		LD R4, R4_SAVE_MUL
		LD R5, R5_SAVE_MUL
		LD R6, R6_SAVE_MUL
		LD R7, R7_SAVE_MUL
RET
HALT

R0_SAVE_MUL .fill #0			; REGISTERS BACK UP LABELS
R1_SAVE_MUL .fill #0
R2_SAVE_MUL .fill #0
R3_SAVE_MUL .fill #0
R4_SAVE_MUL .fill #0
R5_SAVE_MUL .fill #0
R6_SAVE_MUL .fill #0
R7_SAVE_MUL .fill #0
	
.END