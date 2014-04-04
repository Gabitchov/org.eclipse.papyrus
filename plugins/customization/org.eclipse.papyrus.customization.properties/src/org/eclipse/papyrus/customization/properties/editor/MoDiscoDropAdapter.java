/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.editor;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.customization.properties.util.ActionUtil;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.widgets.Widget;

/**
 * An adapter for Drag & Drop in the Context editor. The default Ecore drag & drop
 * is not compatible with the EMF Facet Tree Elements
 *
 * @author Camille Letavernier
 */
public class MoDiscoDropAdapter extends EditingDomainViewerDropAdapter {

	/**
	 *
	 * Constructor.
	 *
	 * @param domain
	 *        The Editing domain for this Drop Adapter
	 * @param viewer
	 *        The Viewer for this Drop Adapter
	 */
	public MoDiscoDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);
	}

	@Override
	protected Collection<?> extractDragSource(Object object) {
		if(object instanceof ISelection) {
			return super.extractDragSource(ActionUtil.getAdaptedSelection((ISelection)object));
		} else {
			return super.extractDragSource(object);
		}
	}

	@Override
	protected Object extractDropTarget(Widget item) {
		Object dropTarget = super.extractDropTarget(item);
		EObject eObject = EMFHelper.getEObject(dropTarget);
		if(eObject != null) {
			return eObject;
		}

		return dropTarget;
	}

}
