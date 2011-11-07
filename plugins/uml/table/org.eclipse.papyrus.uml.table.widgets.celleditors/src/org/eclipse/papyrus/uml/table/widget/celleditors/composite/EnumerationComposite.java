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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.widget.celleditors.composite;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * 
 * This Composite allows to edit the Enumeration in Papyrus table.
 * Useful to edit the property of the stereotyped element when the property is typed with an Enumeration.
 * 
 */
public class EnumerationComposite extends EnumComposite<EnumerationLiteral> {

	/**
	 * the enumeration
	 */
	private Enumeration enumeration;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 */
	public EnumerationComposite(final Composite parent) {
		super(parent);
	}

	/**
	 * 
	 * @param enumeration
	 */
	public void setEnumeration(final Enumeration enumeration) {
		this.enumeration = enumeration;
		getCombo().setItems(getEnumStrings());
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.EnumComposite#getEnumValue(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	protected EnumerationLiteral getEnumValue(final String text) {
		return this.enumeration.getOwnedLiteral(text);
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.EnumComposite#getEnumString(java.lang.Object)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	protected String getEnumString(final EnumerationLiteral value) {
		return value.getName();
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.EnumComposite#getEnumStrings()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	protected String[] getEnumStrings() {
		int size = this.enumeration.getOwnedLiterals().size();
		String[] strs = new String[size];
		for(int i = 0; i < size; i++) {
			strs[i] = this.enumeration.getOwnedLiterals().get(i).getName();
		}
		return strs;
	}

}
