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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Added a lighter constructor
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.widgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProviderWTooltips;
import org.eclipse.papyrus.modelexplorer.SemanticFromModelExplorer;
import org.eclipse.papyrus.widgets.editors.TreeSelectorDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * create a tree dialog box,with a specific researched meta-class. you can also specify the instance of the top element of your tree
 * 
 */
public class ModelExplorerBasedTreeSelectorDialog extends TreeSelectorDialog {

	protected EclassModelExplorerBasedContentProvider contentProvider;

	protected EObject root = null;

	protected LabelProvider metaclassLabelProvider = new MetaclassLabelProvider();


	/**
	 * get the label provider used to display metaclasses in the combo
	 * 
	 * @return the label provider
	 */
	public LabelProvider getMetaclassLabelProvider() {
		return metaclassLabelProvider;
	}

	/**
	 * set the label provider that will display text in the combo that represent the available list of metaclasses
	 * 
	 * @param metaclassLabelProvider
	 */
	public void setMetaclassLabelProvider(LabelProvider metaclassLabelProvider) {
		this.metaclassLabelProvider = metaclassLabelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	
	protected void setResult(@SuppressWarnings("rawtypes") List newResult) {
		ArrayList<Object> list= new ArrayList<Object>();
		SemanticFromModelExplorer bridge= new SemanticFromModelExplorer();
		Iterator<?> iterator=newResult.iterator();
		while (iterator.hasNext()) {
			Object wrappedObject = (Object) iterator.next();
			Object semantic=bridge.getSemanticElement(wrappedObject);
			if( semantic!=null){
				list.add(semantic);
			}
		}

		super.setResult(list);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        a shell
	 * @param root
	 *        the root of the tree , can be null
	 * @param wantedEClass
	 *        the meta-classes wanted, can be null
	 * @param metaClassNotWanted
	 *        , the list of sub meta-classes not wanted, can not be null
	 */
	public ModelExplorerBasedTreeSelectorDialog(Shell parentShell, EObject root, Object wantedEClass, List<Object> metaClassNotWanted) {
		super(parentShell);
		init(root, wantedEClass, metaClassNotWanted);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        a shell
	 */
	public ModelExplorerBasedTreeSelectorDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Sets the preferences for initializing this Dialog's ContentProvider.
	 * 
	 * @param root
	 *        the root of the tree , can be null
	 * @param wantedEClass
	 *        the meta-classes wanted, can be null
	 * @param metaClassNotWanted
	 *        , the list of sub meta-classes not wanted, can not be null
	 */
	public void init(EObject root, Object wantedEClass, List<Object> metaClassNotWanted) {
		this.root = root;
		contentProvider = new EclassModelExplorerBasedContentProvider(root);
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
		setDescription("Look for " + metaclassLabelProvider.getText(contentProvider.getMetaClassWanted()));
		ViewerFilter[] filters = { new HierarchicViewerFilter(contentProvider) };
		getViewer().setFilters(filters);

		Activator.getDefault().getCustomizationManager().installCustomPainter(getViewer().getTree());
	}
}
