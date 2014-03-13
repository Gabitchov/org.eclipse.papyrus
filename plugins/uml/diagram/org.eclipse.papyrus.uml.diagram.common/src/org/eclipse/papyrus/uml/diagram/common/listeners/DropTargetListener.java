/*******************************************************************************
 * Copyright (c) 2008, 2013 Obeo, CEA LIST, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     modified by CEA-LIST
 *     Christian W. Damus (CEA LIST) - delegate object localization to a new service
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.listeners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.localizer.IObjectLocalizer;
import org.eclipse.papyrus.infra.services.localizer.util.LocalizerUtil;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

/**
 * This class is used to handle drop event on diagram
 * 
 */
public abstract class DropTargetListener extends DiagramDropTargetListener {

	public static final String EVENT_DETAIL = "EVENT_DETAIL";

	public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
		super(viewer, xfer);
	}


	@SuppressWarnings("unchecked")
	@Override
	protected Request createTargetRequest() {
		Request r = super.createTargetRequest();
		if(r != null && r.getExtendedData() != null) {
			r.getExtendedData().put(EVENT_DETAIL, getCurrentEvent().detail);
			//430099: [Diagram] Snap to Grid for elements dropped from the ModelExplorer is ignored
			//https://bugs.eclipse.org/bugs/show_bug.cgi?id=430099
			boolean isSnapping = ((DiagramGraphicalViewer)getViewer()).getWorkspaceViewerPreferenceStore().getBoolean(PreferencesConstantsHelper.SNAP_TO_GRID_CONSTANT);
			r.getExtendedData().put(PreferencesConstantsHelper.SNAP_TO_GRID_CONSTANT, isSnapping);
		}
		return r;
	}

	protected abstract Object getJavaObject(TransferData data);

	@Override
	protected List<EObject> getObjectsBeingDropped() {
		// get objects from transfer
		TransferData data = getCurrentEvent().currentDataType;
		ArrayList<URI> uris = new ArrayList<URI>(); // Array list to keep the
		// order of the selection

		Object transferedObject = getJavaObject(data);
		ArrayList<EObject> result = new ArrayList<EObject>();

		if(transferedObject instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)transferedObject;
			ResourceSet localSet = getTransactionalEditingDomain().getResourceSet();
			IObjectLocalizer localizer = LocalizerUtil.getInstance(localSet);

			for(Iterator<?> it = selection.iterator(); it.hasNext();) {
				Object nextSelectedObject = it.next();
				// if (nextSelectedObject instanceof UMLNavigatorItem) {
				// View view = ((UMLNavigatorItem)
				// nextSelectedObject).getView();
				// nextSelectedObject = view.getElement();
				// } else
				nextSelectedObject = EMFHelper.getEObject(nextSelectedObject);
				if(nextSelectedObject instanceof EObject) {
					EObject local = localizer.getLocalEObject(localSet, (EObject)nextSelectedObject);
					if(local != null) {
						result.add(local);
					}
				}
			}
		}

		for(URI uri : uris) {
			EObject modelObject = getTransactionalEditingDomain().getResourceSet().getEObject(uri, true);
			result.add(modelObject);
		}
		return result;
	}

	protected abstract TransactionalEditingDomain getTransactionalEditingDomain();

}
