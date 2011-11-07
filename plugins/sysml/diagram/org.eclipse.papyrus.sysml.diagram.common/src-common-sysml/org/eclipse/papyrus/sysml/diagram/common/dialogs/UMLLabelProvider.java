/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.uml.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.views.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.widgets.providers.IDetailLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Copied from org.eclipse.papyrus.properties.uml.providers.UMLLabelProvider.
 * 
 * The Modisco customizable label provider doesn't handle standard EObjects,
 * while standard EMF label providers don't handle MoDisco elements.
 * 
 * This label provider aggregates both a MoDisco label provider and an
 * EMF Label Provider.
 * 
 * @author Camille Letavernier
 */
public class UMLLabelProvider extends LabelProvider implements IDetailLabelProvider {

	private ILabelProvider modiscoLabelProvider;

	private ILabelProvider eObjectLabelProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public UMLLabelProvider() {
		modiscoLabelProvider = new MoDiscoLabelProvider();
		eObjectLabelProvider = new EditorLabelProvider();
	}

	@Override
	public String getText(Object inputObject) {
		return getProviderFor(inputObject).getText(inputObject);
	}

	@Override
	public Image getImage(Object inputObject) {
		return getProviderFor(inputObject).getImage(inputObject);
	}

	/**
	 * @param inputObject
	 * @return the ILabelProvider for input object
	 */
	protected ILabelProvider getProviderFor(Object inputObject) {
		if(inputObject == null || inputObject instanceof EObject) {
			return eObjectLabelProvider;
		}

		return modiscoLabelProvider;
	}

	public String getDetail(Object object) {
		return getText(object);
	}

}
