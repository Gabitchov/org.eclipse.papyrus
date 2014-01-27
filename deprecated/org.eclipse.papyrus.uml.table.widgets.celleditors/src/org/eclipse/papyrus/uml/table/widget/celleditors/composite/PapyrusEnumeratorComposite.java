/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.widget.celleditors.composite;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.swt.widgets.Composite;



public class PapyrusEnumeratorComposite<T extends Enumerator> extends org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.EnumeratorComposite {

	/**
	 * the enumeration
	 */
	private EEnum myEEnum;

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	public PapyrusEnumeratorComposite(Composite parent) {
		super(parent);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void setEEnum(EEnum eenum2) {
		super.setEEnum(eenum2);
		this.myEEnum = eenum2;
	}


	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected Enumerator getEnumValue(String text) {
		if(this.myEEnum.getEEnumLiteralByLiteral(text) == null) {
			return super.getEnumValue(text);
		}
		EEnumLiteral enumLiteral = myEEnum.getEEnumLiteral(text);
		return enumLiteral.getInstance();

	}
}
