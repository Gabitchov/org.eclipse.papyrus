/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375388 - Cell editor for IImage
 *******************************************************************************/
package org.eclipse.emf.facet.custom.sdk.ui.internal.widgets.celleditors.composite;

import org.eclipse.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.swt.widgets.Composite;

/** Factory for {@link ImageComposite} */
public class ImageCompositeFactory implements ICompositeEditorFactory<IImage> {

	public AbstractCellEditorComposite<IImage> createCompositeEditor(final Composite parent, final int style) {
		return new ImageComposite(parent);
	}

	public Class<IImage> getHandledType() {
		return IImage.class;
	}
}
