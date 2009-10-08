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
package org.eclipse.papyrus.tabbedproperties.appearance;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.umlutils.ui.command.SetNameLabelIconCommand;
import org.eclipse.papyrus.umlutils.ui.helper.NameLabelIconHelper;
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
public class LabelNameIconAppearanceSection extends AbstractPropertySection {

	/**
	 * The stereotype appearance.
	 */
	private CLabel ElementIconLabel;

	/**
	 * The button Gradient appearance.
	 */
	private org.eclipse.swt.widgets.Button checboxElementIconAppearence;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener cheboxElementIconAppearanceListener;

	private GraphicalEditPart editPart;

	private IMultiDiagramEditor editor;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Creates the controls.
	 * 
	 * @param tabbedPropertySheetPage
	 *            the tabbed property sheet page
	 * @param parent
	 *            the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		ElementIconLabel = getWidgetFactory().createCLabel(composite, "Element icon :"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		ElementIconLabel.setLayoutData(data);

		checboxElementIconAppearence = getWidgetFactory().createButton(composite, "", SWT.CHECK);

		data = new FormData();
		data.left = new FormAttachment(ElementIconLabel, 0);
		data.top = new FormAttachment(ElementIconLabel, 1, SWT.CENTER);
		checboxElementIconAppearence.setLayoutData(data);

		cheboxElementIconAppearanceListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (editPart != null) {
					if (((View) editPart.getModel()) != null) {

						Boolean isChecked = checboxElementIconAppearence.getSelection();

						// createProperty value
						// updateStereotypeLocationProperty(diagramElement,currentQualifiedNameSpec);
						// command creation
						if (editingDomain != null) {
							editingDomain.getCommandStack().execute(
									new SetNameLabelIconCommand(editingDomain, ((EModelElement) editPart.getModel()),
											isChecked));
						}

						refresh();
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		checboxElementIconAppearence.addSelectionListener(cheboxElementIconAppearanceListener);

	}

	/*
	 * @see org.eclipse.ui.views.properties.tabbed.view.ITabbedPropertySection#refresh()
	 */
	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if ((!checboxElementIconAppearence.isDisposed())) {

			checboxElementIconAppearence.removeSelectionListener(cheboxElementIconAppearanceListener);

			if (editPart != null) {

				if ((editPart.getModel()) != null) {
					checboxElementIconAppearence.setSelection(NameLabelIconHelper
							.getNameLabelIconValue((EModelElement) editPart.getModel()));

				} else {
					checboxElementIconAppearence.setEnabled(false);
				}
			}
		}
		checboxElementIconAppearence.addSelectionListener(cheboxElementIconAppearanceListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		super.dispose();
		if (checboxElementIconAppearence != null && !checboxElementIconAppearence.isDisposed())
			checboxElementIconAppearence.removeSelectionListener(cheboxElementIconAppearanceListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Object input = ((IStructuredSelection) selection).getFirstElement();
		// look for modelManager
		if (input instanceof GraphicalEditPart) {
			editPart = ((GraphicalEditPart) input);
			// selectionChanged(selection);
		}
		// When the selection is computed from the outline, get the associated editor
		if (part instanceof ContentOutline) {
			IContributedContentsView contributedView = ((IContributedContentsView) ((ContentOutline) part)
					.getAdapter(IContributedContentsView.class));
			if (contributedView != null) {
				part = (IWorkbenchPart) contributedView.getContributingPart();
			}
		}
		if (part instanceof IMultiDiagramEditor) {
			editor = (IMultiDiagramEditor) part;
			editingDomain = editor.getDefaultContext().getTransactionalEditingDomain();
		} else
			editingDomain = null;
	}

}
