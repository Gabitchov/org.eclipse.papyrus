/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.messages.Messages;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * 
 * This action allows to collpase TreeViewer
 * 
 */
public class CollapseAllAction extends Action {

	/** icon path for the collapse all action */
	private static final String TOOLTIPTEXT = Messages.CollapseAllAction_CollapseAll;

	/** the list of the TreeViewer expanded by this action */
	final private Collection<TreeViewer> treeList;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tree
	 *        the tree to manage
	 */
	public CollapseAllAction(final TreeViewer tree) {
		super(IAction.TOOL_TIP_TEXT, IAction.AS_PUSH_BUTTON);
		treeList = new ArrayList<TreeViewer>();
		treeList.add(tree);
		init();

	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param trees
	 *        the list of the tree to expand
	 */
	public CollapseAllAction(final Collection<TreeViewer> trees) {
		super(IAction.TOOL_TIP_TEXT, IAction.AS_PUSH_BUTTON);
		treeList = new ArrayList<TreeViewer>(trees);
		init();


	}

	/**
	 * set the image and the tooltip for this action
	 */
	protected void init() {
		setToolTipText(CollapseAllAction.TOOLTIPTEXT);
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ISharedImages.IMG_ELCL_COLLAPSEALL));
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * 
	 */
	@Override
	public void run() {
		for(TreeViewer tree : treeList) {
			tree.collapseAll();
		}
	}
}
