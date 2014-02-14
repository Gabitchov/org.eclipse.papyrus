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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.getorcreate.IGetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass.IGetExtendedMetaclassWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;

/**
 * @see CreateFacetInFacetSetWidget
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICreateFacetInFacetSetWidget extends
		IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget> {

	/**
	 * @return the getOrCreateFacetSetWidget
	 */
	IGetOrCreateFacetSetWidget getGetOrCreateFacetSetWidget();

	/**
	 * @return the selectSubTypingTypeWidget
	 */
	IAbstractWidget getSelectSubTypingTypeWidget();

	/**
	 * @return the getFacetNameWidget
	 */
	AbstractGetElementNameWidget getGetFacetNameWidget();

	/**
	 * @return the getExtendedMetaclassWidget
	 */
	IGetExtendedMetaclassWidget getGetExtendedMetaclassWidget();

	/**
	 * @return the name of the sub-typing widget.
	 */
	String getSubTypingFacet();

	IDialog<IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> pressSubTypingButton();

	void setSubTypingFacetSelection(final boolean enable);

}