/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.AbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SashPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.TabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.editor.MessagePartModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Folder;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.HSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IPagesModelVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PanelTerm;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.VSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.WindowTerm;
import org.eclipse.swt.SWT;

/**
 * This visitor is used with {@link IModelExp} to create a pages model in a {@link SimpleContentProvider} instancied
 * with the Sash, folders and pages specified in the expr.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class CreateModelInSimpleContentProviderVisitor extends SimpleContentProviderBaseVisitor implements IPagesModelVisitor<Object> {

	/**
	 * {@link SimpleSashWindowsContentProvider} into which model is created.
	 */
	private SimpleSashWindowsContentProvider contentProvider;
	
	/**
	 * Constructor.
	 *
	 * @param contentProvider
	 */
	public CreateModelInSimpleContentProviderVisitor(SimpleSashWindowsContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * @return the isVisitingParentFirst
	 */
	public boolean isVisitingParentFirst() {
		return true;
	}

	/**
	 * There is no windowTerm counterpart in {@link SimpleSashWindowsContentProvider}.
	 * @param windowTerm
	 * @param windowModel
	 */
	@Override
	public void visit(WindowTerm windowTerm, RootModel windowModel) {
		// Create children of the window
		PanelTerm panel = windowTerm.getPanel();
		
		AbstractPanelModel childPanel = createPanelOrFolder(panel, windowModel);
		windowModel.replaceChild(windowModel.getChild(), childPanel);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Folder, org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder)
	 *
	 * @param folder
	 * @param folderModel
	 */
	@Override
	public void visit(Folder folder, TabFolderModel folderModel) {

		// Create children of the folder
		for( Page page : folder.getPages() ) {
			// Create a page of type "MessagePartModel".
			folderModel.getChildren().add( new MessagePartModel( page.getName(), page.getName() ));
		}
		
	}

	/**
	 *
	 * @param sashQuery
	 * @param sashModel
	 */
	public void visit(HSash sashQuery, SashPanelModel sashModel) {
		
		// Create children of the sash
		AbstractPanelModel leftChild = createPanelOrFolder(sashQuery.getLeftup(), sashModel);
		sashModel.setLeftChild( leftChild ) ;
		AbstractPanelModel rightChild = createPanelOrFolder(sashQuery.getRightdown(), sashModel);
        sashModel.setRightChild(rightChild);
	}

	/**
	 * @param sashModel
	 * @param panel
	 */
	private AbstractPanelModel createPanelOrFolder(PanelTerm panel, AbstractModel parent ) {
		if(panel instanceof HSash) {
			// Create a sash with null children.
			// This is not a good example of how to proceed. Avoid to use it like this.
			// Here we can do this because we know that we create the children soon.
			return new SashPanelModel(parent, null, null, SWT.HORIZONTAL);
		}
		else if(panel instanceof VSash) {
			return new SashPanelModel(parent, null, null, SWT.VERTICAL);
		}
		else /*if (panel instanceof Folder)*/ {
			TabFolderModel folder = new TabFolderModel(contentProvider);
			folder.setParent(parent);
			return folder;
		}
		
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.VSash, org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
	 *
	 * @param sash
	 * @param sashModel
	 */
	public void visit(VSash sashQuery, SashPanelModel sashModel) {
		// Create children of the sash
		AbstractPanelModel leftChild = createPanelOrFolder(sashQuery.getLeftup(), sashModel);
		sashModel.setLeftChild( leftChild ) ;
		AbstractPanelModel rightChild = createPanelOrFolder(sashQuery.getRightdown(), sashModel);
        sashModel.setRightChild(rightChild);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Page, org.eclipse.papyrus.infra.core.sashwindows.di.PageRef)
	 *
	 * @param page
	 * @param pageModel
	 */
	public void visit(Page page, IPageModel pageModel) {
		// Page is created and identifier already set.
		// Nothing to do
	}

}
