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
 * An implementation of IVariable
 *
 */
public class MokaVariable extends MokaDebugElement implements IVariable {

	public MokaVariable(MokaDebugTarget target) {
		super(target);
	}

	//////////////////////////////
	// Implementation of IVariable
	//////////////////////////////
	
	/**
	 * The value of this variable
	 */
	protected MokaValue value = null ;
	
	/**
	 * The name of this variable
	 */
	protected String name = null ;
	
	/**
	 * The reference type name for this variable
	 */
	protected String referenceTypeName = null ;
	
	/**
	 *  Determines whether this variable's value has changed since the last suspend event
	 */
	protected boolean hasValueChanged = false ;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IVariable#getValue()
	 */
	public IValue getValue() throws DebugException {
		if (this.value != null)
			return this.value ;
		// Delegates retrieval of the value to the owning debug target
		this.value = this.debugTarget.getValue(this) ;
		return this.value ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IVariable#getName()
	 */
	public String getName() throws DebugException {
		if (this.name != null)
			return this.name ;
		return "" ;
	}

	/**
	 * Convenience method for setting the name of variable
	 * 
	 * @param name The new name for this variable
	 */
	public void setName(String name) {
		this.name = name != null ? name : "" ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IVariable#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		if (this.referenceTypeName != null)
			return this.referenceTypeName ;
		// Delegates retrieval of the reference type name to the owning debug target
		this.referenceTypeName = this.debugTarget.getReferenceTypeName(this) ;
		return this.referenceTypeName ;
	}
	
	/**
	 * Convenience method for setting the reference type name of a variable
	 * 
	 * @param referenceTypeName The new reference type name for this variable
	 */
	public void setReferenceTypeName(String referenceTypeName) {
		this.referenceTypeName = referenceTypeName != null ? referenceTypeName : "" ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IVariable#hasValueChanged()
	 */
	public boolean hasValueChanged() throws DebugException {
		return this.hasValueChanged ; // In this implementation, it means that it always returns false
	}

	///////////////////////////////////////
	// Implementation of IValueModification
	///////////////////////////////////////
	
	public void setValue(String expression) throws DebugException {
		// Do nothing
	}

	public void setValue(IValue value) throws DebugException {
		if (value instanceof MokaValue)
			this.value = (MokaValue)value ;
	}

	public boolean supportsValueModification() {
		// By default, does not support value modification
		return false;
	}

	public boolean verifyValue(String expression) throws DebugException {
		// By default, does not support value modification
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		// By default, does not support value modification
		return false;
	}

}
