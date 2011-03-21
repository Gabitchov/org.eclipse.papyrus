/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorerbasedwidgets;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProviderWTooltips;
import org.eclipse.papyrus.widgets.editors.TreeSelectorDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * create a tree dialog box,with a specific researched meta-class. you can also specify the instance of the top element of your tree  
 *
 */
public class ModelExplorerBasedTreeSelectorDialog extends TreeSelectorDialog {

	protected ModelExplorerBasedContentProvider contentProvider;
	protected EObject eObject=null;
	
	/**
	 * constructor
	 * @param parentShell
	 * @param root the root of the tree , can be null
	 * @param wantedEClass the meta-classes wanted, can be null
	 * @param metaClassNotWanted, the list of sub meta-classes not wanted, can not be null
	 */
	public ModelExplorerBasedTreeSelectorDialog(Shell parentShell, EObject root, EClass wantedEClass, List<EClass> metaClassNotWanted) {
		super(parentShell);
		eObject= root;
		contentProvider = new ModelExplorerBasedContentProvider(root);
		contentProvider.setMetaClassWanted(wantedEClass);
		contentProvider.setMetaClassNotWanted(metaClassNotWanted);
		this.setContentProvider(contentProvider);
		this.setLabelProvider(new MoDiscoLabelProviderWTooltips());
		this.setInput(EditorUtils.getMultiDiagramEditor().getServicesRegistry());
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		setDescription("Look for "+contentProvider.getMetaClassWanted().getName());
		ViewerFilter[] filters= { new HierarchicViewerFilter(contentProvider)};
		getViewer().setFilters(filters);
		
		Activator.getDefault().getCustomizationManager().installCustomPainter(getViewer().getTree());
	}
}
