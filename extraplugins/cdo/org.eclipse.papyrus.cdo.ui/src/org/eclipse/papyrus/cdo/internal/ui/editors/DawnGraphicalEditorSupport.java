/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.editors;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.dawn.gmf.editors.impl.DawnGMFEditorSupport;
import org.eclipse.emf.cdo.dawn.gmf.synchronize.DawnConflictHelper;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.decorators.CDOStateAdapter;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.DefaultGraphicalEditorSupport;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IConflictingEditPartFilter;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart;

import com.google.common.collect.Maps;

/**
 * This is the DawnGraphicalEditorSupport type. Enjoy.
 */
public class DawnGraphicalEditorSupport
		extends DefaultGraphicalEditorSupport {

	private final ServicesRegistry registry;

	public DawnGraphicalEditorSupport(ServicesRegistry registry) {
		super();

		this.registry = registry;
	}

	public void initialize(GraphicalEditor editor) {
		if (editor instanceof DiagramDocumentEditor) {
			CDOView view = getCDOView();
			if (view != null) {
				DiagramDocumentEditor diagramEditor = (DiagramDocumentEditor) editor;

				initialize(diagramEditor, view);
			}
		}

		super.initialize(editor);
	}

	protected void initialize(final DiagramDocumentEditor diagramEditor,
			CDOView view) {
		DawnEditorAdapter adapter = new DawnEditorAdapter(diagramEditor);
		final DawnGMFEditorSupport dawnSupport = new PapyrusGMFEditorSupport(
			adapter);

		adapter.setEditorSupport(dawnSupport);
		adapter.setView(getCDOView());
		dawnSupport.setView(adapter.getView());

		// after the root edit part has been created, inject a conflicting edit
		// part filter
		UIUtil.later(new Runnable() {

			public void run() {
				DiagramEditPart diagramEP = diagramEditor.getDiagramEditPart();
				if (diagramEP instanceof PapyrusDiagramEditPart) {
					((PapyrusDiagramEditPart) diagramEP)
						.setConflictingEditPartFilter(createConflictingEditPartFilter());
				}
			}
		});

		dawnSupport.registerListeners();

		// find and process objects locked remotely
		final Map<Object, DawnState> remoteLocks = getRemoteLocks(diagramEditor);
		if (!remoteLocks.isEmpty()) {
			// post for later because the editor isn't yet connected to its
			// editor site in the workbench
			UIUtil.later(new Runnable() {

				public void run() {
					dawnSupport.handleRemoteLockChanges(remoteLocks);

					for (Object next : remoteLocks.keySet()) {
						final EObject element = CDOUtil
							.getEObject((CDOObject) next);
						View view = DawnDiagramUpdater
							.findViewByContainer(element);

						CDOStateAdapter.setState(view, remoteLocks.get(next));
					}
				}
			});
		}
	}

	CDOView getCDOView() {
		CDOView result = null;

		try {
			ModelSet modelSet = registry.getService(ModelSet.class);
			if (modelSet instanceof CDOAwareModelSet) {
				result = ((CDOAwareModelSet) modelSet).getCDOView();
			}
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		return result;
	}

	private Map<Object, DawnState> getRemoteLocks(
			DiagramDocumentEditor diagramEditor) {

		Map<Object, DawnState> result = Maps.newHashMap();

		Diagram diagram = diagramEditor.getDiagram();
		if (diagram != null) {
			Iterator<EObject> iter = EcoreUtil.getAllProperContents(
				Collections.singleton(diagram), false);

			while (iter.hasNext()) {
				CDOObject next = CDOUtils.getCDOObject(iter.next());
				if ((next != null) && CDOUtils.isLocked(next, true)) {
					result.put(next, DawnState.LOCKED_REMOTELY);
				}
			}
		}

		return result;
	}

	private IConflictingEditPartFilter createConflictingEditPartFilter() {
		return new IConflictingEditPartFilter() {

			public boolean isConflicting(EditPart editPart) {
				Object model = editPart.getModel();
				return (model instanceof EObject)
					&& DawnConflictHelper.isConflicted((EObject) model);
			}
		};
	}
}
