/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * An implementation of IValue
 *
 */
public class MokaValue extends MokaDebugElement implements IValue {

	public MokaValue(MokaDebugTarget target) {
		super(target);
	}

	///////////////////////////
	// Implementation of IValue
	///////////////////////////
	
	/**
	 * The reference type name of this value
	 */
	protected String referenceTypeName = null ;
	
	/**
	 * The textual representation of this value
	 */
	protected String textualRepresentation = null ;
	
	/**
	 * The variables contained in this value
	 */
	protected MokaVariable[] nestedVariables = null ;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		if (this.referenceTypeName != null)
			return this.referenceTypeName ;
		// Delegates retrieval of the reference type name to the owning debug target
		this.referenceTypeName = this.debugTarget.getReferenceTypeName(this) ;
		return this.referenceTypeName ;
	}

	/**
	 * Convenience method for setting the reference type name of this value
	 * 
	 * @param referenceTypeName The new reference type name for this value
	 */
	public void setReferenceTypeName(String referenceTypeName) {
		this.referenceTypeName = referenceTypeName != null ? referenceTypeName : "" ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	public String getValueString() throws DebugException {
		if (this.textualRepresentation != null)
			return this.textualRepresentation ;
		// Delegates retrieval of the textual representation of this value to the owning debug target
		this.textualRepresentation = this.debugTarget.getValueString(this) ;
		return this.textualRepresentation ;
	}

	/**
	 * Convenience method for setting the textual representation of a MokaValue
	 * 
	 * @param textualRepresentation The new textual representation for this value
	 */
	public void setValueString(String textualRepresentation) {
		this.textualRepresentation = textualRepresentation != null ? textualRepresentation : "" ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	public boolean isAllocated() throws DebugException {
		// This default implementation return true
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
		if (this.nestedVariables != null)
			return this.nestedVariables ;
		// Delegates retrieval of variables to the owning debug target
		this.nestedVariables = this.debugTarget.getVariables(this) ;
		return this.nestedVariables ;
	}

	/**
	 * Convenience method for setting the nested variables of a MokaVariable
	 * 
	 * @param nestedVariables The nested variables for this value
	 */
	public void setVariables(MokaVariable[] nestedVariables) {
		this.nestedVariables = (nestedVariables != null ? nestedVariables : new MokaVariable[]{}) ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return this.getVariables().length > 0 ;
	}

}
