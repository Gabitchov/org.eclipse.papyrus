/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.outline.actions.CreateDiagramAction;
import org.eclipse.papyrus.outline.actions.DefaultCreateChildMenu;
import org.eclipse.papyrus.outline.actions.DefaultCreateSiblingMenu;
import org.eclipse.papyrus.outline.actions.DeleteAction;
import org.eclipse.papyrus.outline.actions.DeleteDiagramAction;
import org.eclipse.papyrus.outline.actions.DuplicateDiagramAction;
import org.eclipse.papyrus.outline.actions.RenameDiagramAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.uml2.uml.Model;

/**
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class DefaultOutlineActionProvider extends CommonActionProvider {

	/**
	 * Pop-up menu: name of group for the top of the menu (value <code>"group.diagram"</code>).
	 */
	public static final String GROUP_DIAGRAM = "group.diagram"; //$NON-NLS-1$ 

	/**
	 * The Constructor
	 */
	public DefaultOutlineActionProvider() {
	}

	public void fillContextMenu(IMenuManager menu) {
		EObject selection = getSelection();
		menu.insertAfter(ICommonMenuConstants.GROUP_EDIT, new GroupMarker(GROUP_DIAGRAM));
		menu.add(new Separator(GROUP_DIAGRAM));
		EList<Resource> resource = null;

		if (selection != null) {
			AdapterFactoryEditingDomain domain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(selection);
			if (!(selection instanceof Diagram)) {
				DefaultCreateChildMenu createChildMenu = new DefaultCreateChildMenu(selection);
				DefaultCreateSiblingMenu createSiblingMenu = new DefaultCreateSiblingMenu(selection);

				menu.appendToGroup(ICommonMenuConstants.GROUP_NEW, createChildMenu);
				menu.appendToGroup(ICommonMenuConstants.GROUP_NEW, createSiblingMenu);
				menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, new DeleteAction(domain, selection));
			}

			if (selection instanceof Model) {
				EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selection);
				resource = editingDomain.getResourceSet().getResources();
				Resource res = resource.get(0);
				menu.appendToGroup(GROUP_DIAGRAM, new CreateDiagramAction(selection, res, "PapyrusUMLClassDiagram", null));
				// selection, res, ModelEditPart.MODEL_ID,
				// UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));

			} else if (selection instanceof Diagram) {
				menu.appendToGroup(GROUP_DIAGRAM, new DuplicateDiagramAction((Diagram) selection));
				menu.appendToGroup(GROUP_DIAGRAM, new DeleteDiagramAction((Diagram) selection));
				menu.appendToGroup(GROUP_DIAGRAM, new RenameDiagramAction((Diagram) selection));
			}
			menu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS, new LoadResourceAction(domain));
		}
	}

	/**
	 * Returns the selected domain object. Adapt it if necessary
	 */
	protected EObject getSelection() {
		EObject eobject = null;
		IStructuredSelection selection = (IStructuredSelection) getActionSite().getStructuredViewer().getSelection();
		Object object = selection.getFirstElement();

		if (object instanceof EObject) {
			eobject = (EObject) object;
		} else if (object instanceof IAdaptable) {
			EObject adaptedObject = (EObject) ((IAdaptable) object).getAdapter(EObject.class);
			if (adaptedObject != null) {
				eobject = adaptedObject;
			}
		} else {
			EObject adaptedObject = (EObject) Platform.getAdapterManager().loadAdapter(object, EObject.class.getName());
			if (adaptedObject != null) {
				eobject = adaptedObject;
			}
		}

		return eobject;
	}

	/**
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
	}
}
