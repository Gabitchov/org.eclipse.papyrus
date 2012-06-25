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
package org.eclipse.papyrus.infra.emf.compare.ui.content.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CollapseAllAction;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.ExpandAllAction;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.CustomizationAndViewerActionDispatcher;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.EMFCompareUIUtils;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This viewer allows to customize the displayed elements using EMF-Facet
 * 
 */
public class PapyrusCustomizableModelContentMergeViewer extends ModelContentMergeViewer {

	/** the list of the metamodels referenced in the compared files. this field is used by the Customization Manager */
	private Collection<EPackage> metamodels;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param config
	 */
	public PapyrusCustomizableModelContentMergeViewer(final Composite parent, final CompareConfiguration config, final IEditorPart editor) {
		super(parent, config);
		final LabelProvider labelProvider = CustomizationAndViewerActionDispatcher.getLabelProvider(editor);
		((PapyrusModelContentMergeTabFolder)leftPart).setLabelProvider(labelProvider);
		((PapyrusModelContentMergeTabFolder)rightPart).setLabelProvider(labelProvider);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @param input
	 *        the input
	 */
	@Override
	public void setInput(final Object input) {
		super.setInput(input);
		metamodels = EMFCompareUIUtils.getMetamodelForCustomization(input, metamodels);
		updateToolItems();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param composite
	 * @param side
	 * @return
	 */
	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(final Composite composite, final int side) {
		return new PapyrusModelContentMergeTabFolder(this, composite, side);
	}



	/**
	 * 
	 * {@inheritDoc} Add a toogle button to the toolbar to do the synchronization with the diagram
	 * 
	 * @param tbm
	 *        the toolbar manager
	 */
	@Override
	protected void createToolItems(final ToolBarManager tbm) {
		//we add an action to change the applied customization
		if(metamodels == null) {
			metamodels = new HashSet<EPackage>();
		}

		Collection<TreeViewer> viewers = new ArrayList<TreeViewer>();
		viewers.add((TreeViewer)this.rightPart.getTreePart());
		viewers.add((TreeViewer)this.leftPart.getTreePart());
		//we add the expand all action
		final IAction expandAllAction = new ExpandAllAction(viewers);
		final ActionContributionItem expandAllContributionItem = new ActionContributionItem(expandAllAction);
		tbm.insert(0, expandAllContributionItem);

		//we add the collapse all action
		final IAction collapseAllAction = new CollapseAllAction(viewers);
		final ActionContributionItem collapseAllActionContributionItem = new ActionContributionItem(collapseAllAction);
		tbm.insert(1, collapseAllActionContributionItem);

		tbm.insert(2, new Separator("treeAction")); //$NON-NLS-1$


		final IAction customizationAction = new CustomizationAction(Collections.unmodifiableCollection(metamodels));
		final ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(3, customizationContributionItem);
		super.createToolItems(tbm);
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 * 
	 * @param event
	 */
	@Override
	protected void handleDispose(final DisposeEvent event) {
		metamodels.clear();
		super.handleDispose(event);
	}
}
