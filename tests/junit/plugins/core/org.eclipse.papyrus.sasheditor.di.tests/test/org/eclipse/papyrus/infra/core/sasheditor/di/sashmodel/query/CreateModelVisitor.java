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

package org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query;

import org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;
import org.eclipse.swt.SWT;

/**
 * This visitor is used with {@link IQueryTerm} to create a {@link SashModel} instancied
 * with the Sash, folders and pages specified in the query.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class CreateModelVisitor implements IQueryVisitor {

	/**
	 * @return the isVisitingParentFirst
	 */
	public boolean isVisitingParentFirst() {
		return true;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.WindowTerm, org.eclipse.papyrus.infra.core.sashwindows.di.Window)
	 *
	 * @param windowTerm
	 * @param windowModel
	 */
	public void visit(WindowTerm windowTerm, Window windowModel) {
		// Create children of the sash
		PanelTerm panel = windowTerm.getPanel();
			if(panel instanceof AbstractSash) {
				windowModel.setPanel(DiFactory.eINSTANCE.createSashPanel());
			}
			else if (panel instanceof Folder) {
				windowModel.setPanel(DiFactory.eINSTANCE.createTabFolder());
			}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Folder, org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder)
	 *
	 * @param folder
	 * @param folderModel
	 */
	public void visit(Folder folder, TabFolder folderModel) {

		// Create children of the folder
		for( Page page : folder.getPages() ) {
			folderModel.getChildren().add(DiFactory.eINSTANCE.createPageRef());
		}
		
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.HSash, org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
	 *
	 * @param sashQuery
	 * @param sashModel
	 */
	public void visit(HSash sashQuery, SashPanel sashModel) {
		
		// sash orientation
		sashModel.setDirection(SWT.HORIZONTAL);
		// Create children of the sash
		
		createPanelOrFolder(sashQuery.leftup, sashModel);
		createPanelOrFolder(sashQuery.rightdown, sashModel);
	}

	/**
	 * @param sashModel
	 * @param panel
	 */
	private void createPanelOrFolder(PanelTerm panel, SashPanel parent ) {
		if(panel instanceof AbstractSash) {
			parent.getChildren().add(DiFactory.eINSTANCE.createSashPanel());
		}
		else if (panel instanceof Folder) {
			parent.getChildren().add(DiFactory.eINSTANCE.createTabFolder());
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.VSash, org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
	 *
	 * @param sash
	 * @param sashModel
	 */
	public void visit(VSash sashQuery, SashPanel sashModel) {
		// sash orientation
		sashModel.setDirection(SWT.VERTICAL);
		// Create children of the sash
		createPanelOrFolder(sashQuery.leftup, sashModel);
		createPanelOrFolder(sashQuery.rightdown, sashModel);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Page, org.eclipse.papyrus.infra.core.sashwindows.di.PageRef)
	 *
	 * @param page
	 * @param pageModel
	 */
	public void visit(Page page, PageRef pageModel) {


		if(page.getIdentifier() != null) {
			pageModel.setPageIdentifier(page.getIdentifier());
		}
		else if(page.getName() != null) {
			pageModel.setPageIdentifier(page.getName());
		}
		else {
			pageModel.setPageIdentifier(new Object());
		}
		
	}

}
