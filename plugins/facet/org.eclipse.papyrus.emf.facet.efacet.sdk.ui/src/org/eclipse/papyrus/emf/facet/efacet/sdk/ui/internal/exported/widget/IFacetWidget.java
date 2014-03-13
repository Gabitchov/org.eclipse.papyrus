/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass.IGetExtendedMetaclassWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;

public interface IFacetWidget extends
		IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget> {

	void setSubTypingFacetSelection(final boolean enable);

	IDialog<IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> pressSubTypingButton();

	String getSubTypingFacet();

	IGetExtendedMetaclassWidget getGetExtendedMetaclassWidget();

}