/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Fabien Giquel (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *    Nicolas Bros (Mia-Software) - Bug 338437 - compositeEditors extension point cannot be used to register user types
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.ecore.composite;

import java.math.BigInteger;

import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.swt.widgets.Composite;

public class BigIntegerCompositeFactory implements ICompositeEditorFactory<BigInteger> {

	public AbstractCellEditorComposite<BigInteger> createCompositeEditor(final Composite parent, final int style) {
		return new BigIntegerComposite(parent, style);
	}

	public Class<BigInteger> getHandledType() {
		return BigInteger.class;
	}

}
