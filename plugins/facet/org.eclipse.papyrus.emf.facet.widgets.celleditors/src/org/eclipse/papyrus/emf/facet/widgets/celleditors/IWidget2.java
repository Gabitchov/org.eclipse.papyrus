/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software)
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors;

import org.eclipse.swt.widgets.Composite;

/** Implemented by {@link Composite}s that are encapsulated in {@link IModelCellEditor cell editors} */
public interface IWidget2<T extends Object> {
	/** @return the validator used to determine whether an entered value is accepted */
	IValidator getValidator();

	/**
	 * Add a listener that is notified when the value in the widget is "committed". That is, when
	 * the user hits Enter or clicks outside the widget.
	 */
	void addCommitListener(IListener listener);

	/** Remove an existing commit listener */
	void removeCommitListener(IListener listener);

	/** Add a listener for changes to the value */
	void addChangeListener(IListener listener);

	/** Remove an existing change listener */
	void removeChangeListener(IListener listener);

	/** Set the given value in the widget */
	void setValue(final T value);

	/** Get the value from the widget */
	T getValue();
}
