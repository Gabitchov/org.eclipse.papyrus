/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.validation.typing;

public class MultiplicityFacade {
	private int lowerBound = 0;
	private int upperBound = 0;
	private boolean nonUnique = false ;
	private boolean ordered = false ;
	
	public String getLabel() {
		if (lowerBound == upperBound) {
			if (lowerBound == 1)
				return "" ;
			if (lowerBound == -1)
				return "[*]" ;
			return "[" + lowerBound + "]" ;
		}
		else {
			if (upperBound == -1) {
				if (lowerBound == 0) {
					return "[*]" ;
				}
				else {
					return "[" + lowerBound + "..*]" ;
				}
			}
			else {
				return "[" + lowerBound + ".." + upperBound + "]";
			}
		}
	}

	public boolean isCompatibleWithMe(MultiplicityFacade multiplicity) {
		//boolean lowerBoundCompatible = multiplicity.lowerBound >= this.lowerBound ;
		boolean upperBoundCompatible = true ; 
		
		switch (this.upperBound) {
		case -1:
			break;

		default:
			if (multiplicity.upperBound == -1)
				upperBoundCompatible = false ;
//			else 
//				upperBoundCompatible = multiplicity.upperBound <= this.upperBound ;
			break;
		}
		
		//return lowerBoundCompatible && upperBoundCompatible;
		return upperBoundCompatible ;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound ;
	}
	
	public void setUpperBound(int lowerBound) {
		this.upperBound = lowerBound ;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}
	
	public boolean isUnique() {
		return !nonUnique ;
	}
	
	public boolean isOrdered() {
		return ordered ;
	}
	
	public boolean isSequence() {
		return ordered && nonUnique ;
	}
	
	public void setIsUnique(boolean isUnique) {
		nonUnique = !isUnique ;
	}
	
	public void setIsOrdered(boolean isOrdered) {
		ordered = isOrdered ;
	}
	
	public void setIsSequence(boolean isSequence) {
		ordered = true ;
		nonUnique = true ;
	}
}
