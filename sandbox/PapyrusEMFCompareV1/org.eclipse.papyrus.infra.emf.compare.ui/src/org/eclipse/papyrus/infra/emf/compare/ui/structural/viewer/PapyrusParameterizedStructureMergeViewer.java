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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.structural.viewer;

import java.util.Collections;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.emf.compare.ui.viewer.structure.ParameterizedStructureMergeViewer;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.PapyrusLabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class PapyrusParameterizedStructureMergeViewer extends ParameterizedStructureMergeViewer {

	public PapyrusParameterizedStructureMergeViewer(final Composite parent, final CompareConfiguration compareConfiguration) {
		super(parent, compareConfiguration);
		setLabelProvider(createMyLabelProvider(compareConfiguration));
	}

	@Override
	protected void createToolItems() {
		final ToolBarManager tbm = CompareViewerPane.getToolBarManager(getControl().getParent());
		tbm.removeAll();
		super.createToolItems();

		//we add an action to change the applied cuztomization
		final IAction customizationAction = new CustomizationAction(Collections.EMPTY_SET);
		final ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(1, customizationContributionItem);
		tbm.update(true);
	}

	//	/**
	//	 * Creates this viewer's label provider.
	//	 * 
	//	 * @param compareConfiguration
	//	 *        Compare configuration that's been fed this viewer.
	//	 * @return This viewer's label provider.
	//	 * @since 1.1
	//	 */
	//	@Override
	protected LabelProvider createMyLabelProvider(@SuppressWarnings("unused") final CompareConfiguration compareConfiguration) {
		final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		Activator.getDefault().getCustomizationManager(activeEditor);
		final CustomizationManager manager = Activator.getDefault().getCustomizationManager(activeEditor);
		//TODO : I think that we need to provide the metamodel to the customization manager in order to display correctly the element in the viewer
		//Warning : there are 2 viewers (merge and structure), we need to provide the metamodels in 2 times!
		return new PapyrusLabelProvider(manager);
	}
	


}
