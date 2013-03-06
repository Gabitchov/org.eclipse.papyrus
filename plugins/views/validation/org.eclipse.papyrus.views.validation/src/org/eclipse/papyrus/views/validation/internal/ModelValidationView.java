/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

/**
 * This is the ModelValidationView type. Enjoy.
 */
public class ModelValidationView
		extends PageBookView {

	public static final String VIEW_ID = "org.eclipse.papyrus.views.validation.ModelValidationView";

	private ViewSettings settings;
	
	public ModelValidationView() {
		super();
	}

	@Override
	public void init(IViewSite site, IMemento memento)
			throws PartInitException {
		
		super.init(site, memento);
		
		this.settings = new ViewSettings(memento);
	}
	
	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		
		settings.save(memento);
	}
	
	@Override
	protected IPage createDefaultPage(PageBook book) {
		IPageBookViewPage result = new MessagePage(
			"No model editor is currently active.");

		initPage(result);
		result.createControl(book);

		return result;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		ServicesRegistry services = getServicesRegistry(part);

		IPageBookViewPage result;
		try {
			result = (services == null)
				? new MessagePage("Invalid model editor selected.")
				: new ModelValidationPage(services, settings);
		} catch (ServiceException e) {
			String message = "Failed to obtain services required for Model Validation View.";
			Activator.log.error(message, e);
			result = new MessagePage(message);
		}

		initPage(result);
		result.createControl(getPageBook());

		return new PageRec(part, result);
	}

	private ServicesRegistry getServicesRegistry(IWorkbenchPart part) {
		ServicesRegistry result = null;

		if (part instanceof IMultiDiagramEditor) {
			IMultiDiagramEditor editor = (IMultiDiagramEditor) part;
			result = editor.getServicesRegistry();
		}

		return result;
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		pageRecord.page.dispose();
	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPart result = null;

		IEditorPart editor = getSite().getPage().getActiveEditor();
		if ((editor != null) && isImportant(editor)) {
			result = editor;
		}

		return result;
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part instanceof IMultiDiagramEditor;
	}

	//
	// Nested types
	//

	private static class MessagePage
			extends Page {

		private String message;

		private Label label;

		MessagePage(String message) {
			super();

			this.message = message;
		}

		@Override
		public void createControl(Composite parent) {
			label = new Label(parent, SWT.CENTER);
			label.setText(message);
		}

		@Override
		public Control getControl() {
			return label;
		}

		@Override
		public void setFocus() {
			// pass
		}
	}
}
