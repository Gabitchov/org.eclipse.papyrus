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
import org.eclipse.papyrus.uml.diagram.common.helper.BasicClassifierCompartmentLayoutHelper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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

// TODO: Auto-generated Javadoc
/**
 * This class is used to specify in the property view the kind of layout.
 */
public class LayoutCompartmentAppearanceSection extends AbstractPropertySection {

	/** The stereotype appearance. */
	private CLabel layoutlabelkind;

	/** The button Gradient appearance. */
	private CCombo compartmentAppearence;

	/** The combo stereotype appearance listener. */
	private SelectionListener buttonListener;

	/** The edit part. */
	private GraphicalEditPart editPart;

	/** The editor. */
	private IMultiDiagramEditor editor;

	/** The editing domain. */
	private TransactionalEditingDomain editingDomain;

	/** The MANUAL. */
	private String MANUAL = "manual";

	/** The AUTOMATIC. */
	private String AUTOMATIC = "automatic";

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

		layoutlabelkind = getWidgetFactory().createCLabel(composite, "Compartment Layout :"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		layoutlabelkind.setLayoutData(data);

		compartmentAppearence = getWidgetFactory().createCCombo(composite);
		compartmentAppearence.add(MANUAL);
		compartmentAppearence.add(AUTOMATIC);
		compartmentAppearence.setEditable(false);


		data = new FormData();
		data.left = new FormAttachment(layoutlabelkind, 0);
		data.top = new FormAttachment(layoutlabelkind, 1, SWT.CENTER);
		compartmentAppearence.setLayoutData(data);

		buttonListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if(editPart != null) {
					if(((View)editPart.getModel()) != null) {

						// command creation
						if(editingDomain != null) {
							if(compartmentAppearence.getItem(compartmentAppearence.getSelectionIndex()).equals(AUTOMATIC)) {
								editingDomain.getCommandStack().execute(
										BasicClassifierCompartmentLayoutHelper.getInstances().setAutomaticLayoutKindOnView(editingDomain, ((View)editPart.getModel())));
							}
							else {
								editingDomain.getCommandStack().execute(
										BasicClassifierCompartmentLayoutHelper.getInstances().setManualLayoutKindOnView(editingDomain, ((View)editPart.getModel())));
							}
							refresh();
						}
					}

				}

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
		compartmentAppearence.addSelectionListener(buttonListener);

	}

	/*
	 * @see org.eclipse.ui.views.properties.tabbed.view.ITabbedPropertySection#refresh()
	 */
	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if((!compartmentAppearence.isDisposed())) {

			compartmentAppearence.removeSelectionListener(buttonListener);

			if(editPart != null) {

				if((editPart.getModel()) != null) {
					if(BasicClassifierCompartmentLayoutHelper.getInstances().isManual((EModelElement)editPart.getModel())) {
						compartmentAppearence.select(0);
					} else if(BasicClassifierCompartmentLayoutHelper.getInstances().isManual((EModelElement)editPart.getModel())) {
						compartmentAppearence.select(1);
					} else {
						//default = automatic
						compartmentAppearence.select(1);
					}
				} else {
					compartmentAppearence.setEnabled(false);
				}
			}
		}
		compartmentAppearence.addSelectionListener(buttonListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		super.dispose();
		if(compartmentAppearence != null && !compartmentAppearence.isDisposed())
			compartmentAppearence.removeSelectionListener(buttonListener);
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
