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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.EMFCompareUIUtils;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;

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
	public PapyrusCustomizableModelContentMergeViewer(final Composite parent, final CompareConfiguration config) {
		super(parent, config);
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
		final IAction customizationAction = new CustomizationAction(Collections.unmodifiableCollection(metamodels));
		final ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(1, customizationContributionItem);
		super.createToolItems(tbm);
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 * 
	 * @param event
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		metamodels.clear();
		super.handleDispose(event);
	}
}
