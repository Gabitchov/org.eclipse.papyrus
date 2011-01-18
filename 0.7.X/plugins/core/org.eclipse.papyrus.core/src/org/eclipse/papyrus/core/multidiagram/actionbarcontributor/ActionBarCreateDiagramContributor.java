/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.multidiagram.actionbarcontributor;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * This contributor adds a toolbar item for each possible diagram creation
 * 
 * @author mvelten
 * 
 */
public class ActionBarCreateDiagramContributor extends EditorActionBarContributor {

	private IEditorPart currentEditor = null;

	private ArrayList<ActionBarCreateDiagramAction> createDiagramActions = new ArrayList<ActionBarCreateDiagramAction>();

	public ActionBarCreateDiagramContributor() {
	}

	public void contributeToToolBar(IToolBarManager toolBarManager) {
		ArrayList<CreationCommandDescriptor> sortedDescs = new ArrayList<CreationCommandDescriptor>(getCreationCommandRegistry().getCommandDescriptors());
		Collections.sort(sortedDescs);
		for(CreationCommandDescriptor desc : sortedDescs) {
			ActionBarCreateDiagramAction createDiagramAction = new ActionBarCreateDiagramAction(desc);
			createDiagramActions.add(createDiagramAction);
			toolBarManager.add(createDiagramAction);
		}
	}

	private static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}

	public void setActiveEditor(IEditorPart targetEditor) {
		for(ActionBarCreateDiagramAction createDiagramAction : createDiagramActions) {
			if(currentEditor != null) {
				currentEditor.getEditorSite().getSelectionProvider().removeSelectionChangedListener(createDiagramAction);
			}

			if(targetEditor != null) {
				targetEditor.getEditorSite().getSelectionProvider().addSelectionChangedListener(createDiagramAction);
			}
		}
		currentEditor = targetEditor;
	}
}
