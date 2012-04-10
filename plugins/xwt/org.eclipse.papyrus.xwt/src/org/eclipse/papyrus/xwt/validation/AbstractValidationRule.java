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

import org.eclipse.papyrus.xwt.IValidationRule;

/**
 * Abstract implementation of {@link IValidationRule}
 * 
 * @author hceylan
 */
public abstract class AbstractValidationRule implements IValidationRule {

	/**
	 *
	 */
	public AbstractValidationRule() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IValueValidator#getBindingMode()
	 */
	public Direction getBindingMode() {
		return Direction.Both;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IValueValidator#getPhase()
	 */
	public Phase getPhase() {
		return Phase.AfterGet;
	}

}
