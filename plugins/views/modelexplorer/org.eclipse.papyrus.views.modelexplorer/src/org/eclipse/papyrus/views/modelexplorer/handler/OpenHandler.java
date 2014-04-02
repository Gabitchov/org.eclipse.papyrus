/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * This handler allows to Open Diagrams and Tables
 *
 *
 *
 */
public class OpenHandler extends AbstractModelExplorerHandler implements IExecutableExtension {


	/**
	 * Close only the selected elements
	 */
	public static final String IS_DUPLICATE_EDITOR_ALLOWED_PARAMETER = "isDuplicateEditorAllowed"; //$NON-NLS-1$


	/**
	 * Return true if the open command allow to duplicate editor that are already
	 * opened.
	 * Return false if open command should not duplicate already opened editor.
	 * This property can be set from the plugin.xml.
	 */
	protected boolean isDuplicateDiagramAllowed = false;


	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IPageManager pageManager = getPageManager();
		if(pageManager == null) {
			return null;
		}

		// Try to close each selected editor.
		// There is no common type for object representing an editor. So,
		// We try to get the EObject, and try to close it as an Editor.
		List<EObject> selectedProperties = getCurrentSelectionAdaptedToType(event, EObject.class);
		if(selectedProperties == null) {
			// nothing to do
			return null;
		}

		// Check each selected object
		final List<EObject> pagesToOpen = new LinkedList<EObject>();
		List<EObject> pagesToSelect = new LinkedList<EObject>();
		for(EObject selected : selectedProperties) {
			if (!canOpenByPolicy(selected))
				continue;
			if (!pageManager.isOpen(selected) || isDuplicateDiagramAllowed) {
				pagesToOpen.add(selected);
			} else {
				pagesToSelect.add(selected);
			}
		}

		if(!pagesToOpen.isEmpty()) {
			for(EObject page : pagesToOpen) {
				pageManager.openPage(page);
			}
		}

		for(EObject page : pagesToSelect) {
			pageManager.selectPage(page);
		}

		return null;
	}

	/**
	 * Determines whether the current policy allows this object to be opened
	 * @param selection The object to open
	 * @return <code>true</code> if the object can be opened
	 */
	private boolean canOpenByPolicy(EObject selection) {
		if (selection instanceof Diagram) {
			Diagram diagram = (Diagram)selection;
			ViewPrototype proto = DiagramUtils.getPrototype(diagram);
			return (proto != ViewPrototype.UNAVAILABLE_VIEW && proto != ViewPrototype.UNAVAILABLE_DIAGRAM);
		}
		return true;
	}
	
	/**
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 *      java.lang.Object)
	 *
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if(!(data instanceof Hashtable)) {
			return;
		}

		@SuppressWarnings("rawtypes")
		Hashtable map = (Hashtable)data;

		try {
			isDuplicateDiagramAllowed = Boolean.parseBoolean((String)map.get(IS_DUPLICATE_EDITOR_ALLOWED_PARAMETER));
		} catch (Exception e) {
			// silently fail;
		}
	}


}
