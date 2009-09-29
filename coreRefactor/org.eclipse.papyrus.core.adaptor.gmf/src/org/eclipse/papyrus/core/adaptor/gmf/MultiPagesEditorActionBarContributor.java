/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.CopyRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightRetargetAction;
import org.eclipse.gef.ui.actions.MatchWidthRetargetAction;
import org.eclipse.gef.ui.actions.PasteRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.sasheditor.extension.EditorFactoryRegistry;
import org.eclipse.papyrus.sasheditor.extension.MultiDiagramActionBarContributor;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;



/**
 * Contributes actions to a toolbar.
 * This class is tied to the editor in the definition of editor-extension (see plugin.xml).
 */
public class MultiPagesEditorActionBarContributor extends MultiDiagramActionBarContributor {

	/**
	 * Return the EditorRegistry loading the extension points accepted by this editor.
	 * Should set the namespace.
	 */
	protected EditorFactoryRegistry getEditorRegistry() {
//	      return new EditorFactoryRegistry(org.eclipse.papyrus.diagram.common.scribe.PapyrusPlugin.PLUGIN_ID);
	      return null;
    }
	

	/**
	 * Create actions managed by this contributor.
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	@Override
	protected void buildActions() {
		super.buildActions();
//		addRetargetAction(new UndoRetargetAction());
//		addRetargetAction(new RedoRetargetAction());
//		addRetargetAction(new DeleteRetargetAction());

		addRetargetAction(new CopyRetargetAction());
		addRetargetAction(new PasteRetargetAction());

		addRetargetAction(new ZoomInRetargetAction());
		addRetargetAction(new ZoomOutRetargetAction());

//		addRetargetAction(new CreateDiagramRetargetAction());
//		addRetargetAction(new DeleteDiagramRetargetAction());
//		addRetargetAction(new CreateDeploymentDiagramRetargetAction());

		addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));

		addRetargetAction(new MatchWidthRetargetAction());
		addRetargetAction(new MatchHeightRetargetAction());

		addRetargetAction(new RetargetAction(
				GEFActionConstants.TOGGLE_RULER_VISIBILITY, 
				GEFMessages.ToggleRulerVisibility_Label, IAction.AS_CHECK_BOX));

		addRetargetAction(new RetargetAction(
				GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, 
				GEFMessages.ToggleSnapToGeometry_Label, IAction.AS_CHECK_BOX));

		addRetargetAction(new RetargetAction(
				GEFActionConstants.TOGGLE_GRID_VISIBILITY, 
				GEFMessages.ToggleGrid_Label, IAction.AS_CHECK_BOX));
	}

	/**
	 * Add actions to the given toolbar.
	 * 
	 * @param toolBarManager 
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
//		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
//		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
//		toolBarManager.add(getAction(ActionFactory.COPY.getId()));
//		toolBarManager.add(getAction(ActionFactory.PASTE.getId()));
//		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
		//toolBarManager.add(getAction(CreateDiagramAction.CREATE_DIAGRAM));
		//toolBarManager.add(getAction(DeleteDiagramAction.DELETE_DIAGRAM));
		//toolBarManager.add(getAction(CreateDeploymentDiagramAction.CREATE_DIAGRAM));
		//toolBarManager.add(getAction(DeleteDiagramAction.DELETE_DIAGRAM));	

		toolBarManager.add(new Separator());
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_LEFT));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_CENTER));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_RIGHT));
		toolBarManager.add(new Separator());
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_TOP));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_BOTTOM));	
		toolBarManager.add(new Separator());	
		toolBarManager.add(getAction(GEFActionConstants.MATCH_WIDTH));
		toolBarManager.add(getAction(GEFActionConstants.MATCH_HEIGHT));

		toolBarManager.add(new Separator());	
		String[] zoomStrings = new String[] {	ZoomManager.FIT_ALL, 
				ZoomManager.FIT_HEIGHT, 
				ZoomManager.FIT_WIDTH	};
		toolBarManager.add(new ZoomComboContributionItem(getPage(), zoomStrings));

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToMenu(org.eclipse.jface.action.IMenuManager)
	 */

	/**
	 * 
	 * 
	 * @param menubar 
	 */
	@Override
	public void contributeToMenu(IMenuManager menubar) {
		super.contributeToMenu(menubar);
		MenuManager viewMenu = new MenuManager(Messages.MultiPagesEditorActionBarContributor_PapyrusMenu);
		viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));
		viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));
		viewMenu.add(new Separator());
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
		viewMenu.add(new Separator());
		viewMenu.add(getAction(GEFActionConstants.MATCH_WIDTH));
		viewMenu.add(getAction(GEFActionConstants.MATCH_HEIGHT));
		menubar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
	 */
	/**
	 * 
	 */
	@Override
	protected void declareGlobalActionKeys() {
		addGlobalActionKey(ActionFactory.PRINT.getId());
		addGlobalActionKey(ActionFactory.SELECT_ALL.getId());
		addGlobalActionKey(ActionFactory.COPY.getId());
		addGlobalActionKey(ActionFactory.PASTE.getId());
		addGlobalActionKey(ActionFactory.DELETE.getId());
	}

}