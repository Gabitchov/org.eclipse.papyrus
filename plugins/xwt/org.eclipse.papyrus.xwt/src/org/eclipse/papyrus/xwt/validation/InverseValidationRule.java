/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.xwt.IValidationRule;

public class InverseValidationRule implements IValidationRule {

	private final IValidationRule delegate;

	public InverseValidationRule(IValidationRule delegate) {
		super();

		this.delegate = delegate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IValueValidator#getBindingMode()
	 */
	public Direction getBindingMode() {
		switch(delegate.getBindingMode()) {
		case SourceToTarget:
			return Direction.TargetToSource;
		case TargetToSource:
			return Direction.SourceToTarget;
		case Both:
		default:
			return Direction.Both;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IValueValidator#getPhase()
	 */
	public Phase getPhase() {
		return delegate.getPhase();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IValueValidator#validateBack(java.lang.Object)
	 */
	public IStatus validateBack(Object value) {
		return delegate.validate(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.validation.IValidator#validate(java.lang.Object)
	 */
	public IStatus validate(Object value) {
		return delegate.validateBack(value);
	}

}
