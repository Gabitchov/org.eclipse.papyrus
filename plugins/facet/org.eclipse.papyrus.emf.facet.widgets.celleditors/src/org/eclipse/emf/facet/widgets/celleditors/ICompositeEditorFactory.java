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
package org.eclipse.emf.facet.widgets.celleditors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * The factory interface for creating some control
 * {@link AbstractCellEditorComposite} dedicated to the edition of one java
 * type. The developer should register some factories using the dedicated
 * extension point "compositeEditors"
 * 
 * @param <T>
 *            the java type managed by this composite editor factory.
 */
public interface ICompositeEditorFactory<T> {

	/**
	 * @return the type handled by the composite editors created by this factory. This method is
	 *         required because of type erasure with Java generics.
	 */
	Class<T> getHandledType();

	/**
	 * Create a cell editor composite for a value of type &lt;T&gt;, as a subclass of
	 * {@link AbstractCellEditorComposite}, which is a SWT {@link Composite} suited for use as an
	 * in-place editor for values of type &lt;T&gt;.
	 * 
	 * @param parent
	 *            the SWT parent of the new composite
	 * @param style
	 *            SWT style bits ({@link SWT#BORDER}, etc.)
	 * @return the new cell editor composite
	 */
	AbstractCellEditorComposite<T> createCompositeEditor(Composite parent, int style);

}
