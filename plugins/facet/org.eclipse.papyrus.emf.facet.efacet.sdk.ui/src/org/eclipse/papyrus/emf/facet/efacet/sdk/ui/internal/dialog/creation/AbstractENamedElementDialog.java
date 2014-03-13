/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.AbstractComandMainDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;

public abstract class AbstractENamedElementDialog<C extends EObject, CW extends Object, W extends IENamedElementWidget<C, CW>>
		extends AbstractComandMainDialog<W> {

	private final PropertyElement2<String> nameProperty;

	protected AbstractENamedElementDialog(final ENamedElement editedElement,
			final EditingDomain editingDomain) {
		super(editedElement, editingDomain);
		this.nameProperty = new PropertyElement2<String>(true);
		if (editedElement != null) {
			this.nameProperty.setValue2(editedElement.getName());
		}
	}

	protected final PropertyElement2<String> getNameProperty() {
		return this.nameProperty;
	}
}
