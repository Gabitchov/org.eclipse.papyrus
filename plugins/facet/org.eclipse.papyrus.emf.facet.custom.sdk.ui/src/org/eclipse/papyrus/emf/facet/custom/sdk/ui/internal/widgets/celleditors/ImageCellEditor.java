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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.widgets.celleditors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.widgets.celleditors.composite.ImageComposite;
import org.eclipse.papyrus.emf.facet.custom.ui.ImageUtils;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/** A cell editor for displaying an {@link IImage} (read-only for now) */
public class ImageCellEditor implements IModelCellEditor {

	private IImage iimage;
	private ImageComposite imageComposite;

	protected Image getImage() {
		return ImageUtils.unwrap(this.iimage);
	}

	public Control activateCell(final Composite parent, final Object originalValue,
			final IModelCellEditHandler editHandler, final EStructuralFeature feature,
			final EObject source) {
		
		this.imageComposite = new ImageComposite(parent);

		if (originalValue instanceof IImage) {
			this.imageComposite.setValue((IImage) originalValue);
			this.iimage = (IImage) originalValue;
		}

		return this.imageComposite;
	}

	public Object getValue() {
		return this.iimage;
	}
}
