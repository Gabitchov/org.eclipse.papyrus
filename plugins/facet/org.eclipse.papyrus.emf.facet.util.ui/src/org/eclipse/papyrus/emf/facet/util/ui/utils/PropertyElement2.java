/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved.
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Integration into ITM-Factory
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.utils;


/**
 * @since 0.3
 */
public class PropertyElement2<T extends Object> extends PropertyElement {

	private final boolean canBeNull;

	public PropertyElement2(final boolean changeable) {
		super("", Object.class, changeable); //$NON-NLS-1$
		this.canBeNull = false;
	}

	public PropertyElement2(final boolean changeable, final T value) {
		super("", Object.class, changeable, value); //$NON-NLS-1$
		this.canBeNull = false;
	}

	public PropertyElement2(final boolean changeable, final boolean canBeNull) {
		super("", Object.class, changeable); //$NON-NLS-1$
		this.canBeNull = canBeNull;
	}

	public T getValue2() {
		@SuppressWarnings("unchecked")
		// @SuppressWarnings("unchecked") This cast is safe because the value
		// has to be a instance of T.
		// PropertyElement a refactoring of PropertyElement is expected.
		final T result = (T) this.getValue();
		return result; // NOPMD by gdupe on 19/10/12 16:59
		// NOPMD to isolate @SuppressWarnings("unchecked")
	}

	public void setValue2(final T value) {
		this.setValue(value);
	}

	public boolean isCanBeNull() {
		return this.canBeNull;
	}

}
