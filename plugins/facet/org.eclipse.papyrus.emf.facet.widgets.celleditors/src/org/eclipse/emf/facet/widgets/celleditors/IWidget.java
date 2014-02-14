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
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/** Implemented by {@link Composite}s that are encapsulated in {@link IModelCellEditor cell editors} */
public interface IWidget<T extends Object> {
	/** @return the validator used to determine whether an entered value is accepted */
	IValidator getValidator();

	/** Add a listener for changes to the value */
	void addCommitListener(Listener listener);

	/** Remove an existing listener */
	void removeCommitListener(Listener listener);

	/** Set the given value in the widget */
	void setValue(final T value);

	/** Get the value from the widget */
	T getValue();
}
