/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

	/**
	 * @generated
	 */
	private final IWorkbenchPart part;

	/**
	 * @generated
	 */
	public DiagramEditorContextMenuProvider(final IWorkbenchPart part, final EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;

	}

	/**
	 * @generated
	 */
	@Override
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel()).runExclusive(new Runnable() {

				public void run() {
					ContributionItemService.getInstance().contributeToPopupMenu(DiagramEditorContextMenuProvider.this,
							DiagramEditorContextMenuProvider.this.part);
					menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);

				}
			});
		} catch (final Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError("Error building context menu", e);
		}
	}
}
