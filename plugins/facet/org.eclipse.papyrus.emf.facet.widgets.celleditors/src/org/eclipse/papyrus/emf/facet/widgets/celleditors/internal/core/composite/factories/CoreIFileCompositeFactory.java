/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *    Nicolas Bros (Mia-Software) - Bug 338437 - compositeEditors extension point cannot be used to register user types
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.factories;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.CoreIFileComposite;
import org.eclipse.swt.widgets.Composite;

public class CoreIFileCompositeFactory implements ICompositeEditorFactory<IFile> {

	public Class<IFile> getHandledType() {
		return IFile.class;
	}

	public AbstractCellEditorComposite<IFile> createCompositeEditor(final Composite parent, final int style) {
		return new CoreIFileComposite(parent, style);
	}
}