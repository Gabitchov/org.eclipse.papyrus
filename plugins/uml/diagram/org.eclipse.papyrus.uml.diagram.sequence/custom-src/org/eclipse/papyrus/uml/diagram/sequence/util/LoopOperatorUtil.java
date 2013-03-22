package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.papyrus.uml.service.types.utils.InteractionConstraintUtil;
import org.eclipse.uml2.uml.InteractionConstraint;

/**
 * Loop operand could have iteration bounds which may include a lower and an upper number of iterations of the loop. Textual syntax of the loop is:
 * loop-operand ::= loop [ '(' min-int [ ',' max-int ] ')' ]
 * min-int ::= non-negative-integer
 * max-int ::= positive-integer | '*'
 * 
 * 1. If loop has no bounds specified, it means potentially infinite loop with zero as lower bound and infinite upper bound..
 * 2. If only min-int is specified, it means that upper bound is equal to the lower bound, and loop will be executed exactly the specified
 * number of times.
 * 3. If max-int is specified, it should be greater than or equal to min-int. Loop will iterate minimum the min-int number of times and at
 * most the max-int number of times.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LoopOperatorUtil {

	public static String getLoopCondition(InteractionConstraint guard) {
		if(guard == null) {
			return null;
		}
		Integer minint = InteractionConstraintUtil.getMinintValue(guard);
		Integer maxint = InteractionConstraintUtil.getMaxintValue(guard);

		if(minint == null && maxint == null) {
			return "";
		}
		//by default, minint==0;
		if(maxint == null && minint != null && minint.intValue() == 0) {
			return "";
		}
		//by default, maxint==1
		if(minint == null && maxint != null && maxint.intValue() == 1) {
			return "";
		}
		if(minint == null) {
			minint = Integer.valueOf(0);
		}
		StringBuffer buf = new StringBuffer("(");
		buf.append(minint.intValue());
		if(maxint != null) {
			if(maxint.intValue() != minint.intValue()) {
				buf.append(",");
				if(Integer.MAX_VALUE == maxint) {
					buf.append("*");
				} else {
					buf.append(maxint);
				}
			}
		}
		buf.append(")");
		return new String(buf);
	}
}
