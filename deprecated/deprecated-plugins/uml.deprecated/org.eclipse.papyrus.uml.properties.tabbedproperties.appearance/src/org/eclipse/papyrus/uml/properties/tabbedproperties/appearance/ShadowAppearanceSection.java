/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.tools.utils.ui.command.SetShadowFigureCommand;
import org.eclipse.papyrus.uml.tools.utils.ui.helper.ShadowFigureHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * The Class QualifiedNameAppearanceSection allow users to customize the display of qualified name.
 */
public class ShadowAppearanceSection extends AbstractPropertySection {

	/**
	 * The stereotype appearance.
	 */
	private CLabel shadowLabel;

	/**
	 * The button Gradient appearance.
	 */
	private org.eclipse.swt.widgets.Button checboxShadowAppearence;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener cheboxShadowAppearanceListener;

	private GraphicalEditPart editPart;

	private IMultiDiagramEditor editor;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Creates the controls.
	 * 
	 * @param tabbedPropertySheetPage
	 *        the tabbed property sheet page
	 * @param parent
	 *        the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		shadowLabel = getWidgetFactory().createCLabel(composite, "Shadow :"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		shadowLabel.setLayoutData(data);

		checboxShadowAppearence = getWidgetFactory().createButton(composite, "", SWT.CHECK);

		data = new FormData();
		data.left = new FormAttachment(shadowLabel, 0);
		data.top = new FormAttachment(shadowLabel, 1, SWT.CENTER);
		checboxShadowAppearence.setLayoutData(data);

		cheboxShadowAppearanceListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if(editPart != null) {
					if(((View)editPart.getModel()) != null) {

						Boolean isChecked = checboxShadowAppearence.getSelection();

						// createProperty value
						// updateStereotypeLocationProperty(diagramElement,currentQualifiedNameSpec);
						// command creation
						if(editingDomain != null) {
							editingDomain.getCommandStack().execute(
									new SetShadowFigureCommand(editingDomain, ((EModelElement)editPart.getModel()),
									isChecked));
						}

						refresh();
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		checboxShadowAppearence.addSelectionListener(cheboxShadowAppearanceListener);

	}

	/*
	 * @see org.eclipse.ui.views.properties.tabbed.view.ITabbedPropertySection#refresh()
	 */
	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if((!checboxShadowAppearence.isDisposed())) {

			checboxShadowAppearence.removeSelectionListener(cheboxShadowAppearanceListener);

			if(editPart != null) {

				if((editPart.getModel()) != null) {
					checboxShadowAppearence.setSelection(ShadowFigureHelper
							.getShadowFigureValue((EModelElement)editPart.getModel()));

				} else {
					checboxShadowAppearence.setEnabled(false);
				}
			}
		}
		checboxShadowAppearence.addSelectionListener(cheboxShadowAppearanceListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		super.dispose();
		if(checboxShadowAppearence != null && !checboxShadowAppearence.isDisposed())
			checboxShadowAppearence.removeSelectionListener(cheboxShadowAppearanceListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Object input = ((IStructuredSelection)selection).getFirstElement();
		// look for modelManager
		if(input instanceof GraphicalEditPart) {
			editPart = ((GraphicalEditPart)input);
			// selectionChanged(selection);
		}
		// When the selection is computed from the outline, get the associated editor
		if(part instanceof ContentOutline) {
			IContributedContentsView contributedView = ((IContributedContentsView)((ContentOutline)part)
					.getAdapter(IContributedContentsView.class));
			if(contributedView != null) {
				part = (IWorkbenchPart)contributedView.getContributingPart();
			}
		}
		if(part instanceof IMultiDiagramEditor) {
			editor = (IMultiDiagramEditor)part;
			editingDomain = getTransactionalEditingDomain(editor);
		} else
			editingDomain = null;
	}

	/**
	 * Get the {@link TransactionalEditingDomain} from the {@link IMultiDiagramEditor}.
	 * @param editor
	 * @return
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain(IMultiDiagramEditor editor) {
		try {
			return editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		} catch (ServiceException e) {
			// TODO Log instead of showing the trace.
			e.printStackTrace();
			return null;
		}
	}

}
