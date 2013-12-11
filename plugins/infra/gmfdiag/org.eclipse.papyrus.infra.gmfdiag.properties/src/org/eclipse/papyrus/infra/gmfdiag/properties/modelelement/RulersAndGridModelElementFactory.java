/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;

/**
 * 
 * @author vl222926
 *         The factory used to edit Rulers and Grid properties
 */
public class RulersAndGridModelElementFactory implements ModelElementFactory {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory#createFromSource(java.lang.Object,
	 *      org.eclipse.papyrus.views.properties.contexts.DataContextElement)
	 * 
	 * @param sourceElement
	 * @param context
	 * @return
	 */
	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		if(sourceElement instanceof EditPart) {
			final IPreferenceStore preferenceStore = DiagramEditPartsUtil.getDiagramWorkspacePreferenceStore((EditPart)sourceElement);
			View view = NotationHelper.findView(DiagramEditPartsUtil.getDiagramEditPart((EditPart)sourceElement));
			if(preferenceStore != null && view instanceof Diagram) {
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(view);
				return new RulerAndGridModelElement((Diagram)view, domain, context, preferenceStore);
			}
		}

		Activator.log.warn("The selected element cannot be resolved to a Diagram View"); //$NON-NLS-1$
		return null;
	}



}
