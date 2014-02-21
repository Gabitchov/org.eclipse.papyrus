/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 342548 - [Java Discovery] Illegal parameter initializer for ELEMENTS_TO_ANALYZE
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.factories;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.CoreIProjectComposite;
import org.eclipse.swt.widgets.Composite;

public class CoreIProjectCompositeFactory implements ICompositeEditorFactory<IProject> {

	public Class<IProject> getHandledType() {
		return IProject.class;
	}

	public AbstractCellEditorComposite<IProject> createCompositeEditor(final Composite parent, final int style) {
		return new CoreIProjectComposite(parent, style);
	}
}