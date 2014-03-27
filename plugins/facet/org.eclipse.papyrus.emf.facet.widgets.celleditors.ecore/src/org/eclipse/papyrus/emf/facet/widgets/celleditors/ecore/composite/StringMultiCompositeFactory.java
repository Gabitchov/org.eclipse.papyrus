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
package org.eclipse.papyrus.emf.facet.widgets.celleditors.ecore.composite;

import org.eclipse.papyrus.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.swt.widgets.Composite;

public class StringMultiCompositeFactory implements ICompositeEditorFactory<String> {

	public AbstractCellEditorComposite<String> createCompositeEditor(final Composite parent, final int style) {
		return new StringMultiComposite<String>(parent, style);
	}

	public Class<String> getHandledType() {
		return String.class;
	}

}
