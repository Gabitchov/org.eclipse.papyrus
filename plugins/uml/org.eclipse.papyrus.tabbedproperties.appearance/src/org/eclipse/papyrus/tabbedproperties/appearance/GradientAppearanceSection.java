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
import org.eclipse.papyrus.umlutils.ui.command.SetGradienColorCommand;
import org.eclipse.papyrus.umlutils.ui.helper.GradientColorHelper;
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
public class GradientAppearanceSection extends AbstractPropertySection {

	/**
	 * The stereotype appearance.
	 */
	private CLabel gradientLabel;

	/**
	 * The button Gradient appearance.
	 */
	private org.eclipse.swt.widgets.Button checboxGradientAppearence;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener cheboxGradientAppearanceListener;

	private GraphicalEditPart namedElementEditPart;

	private IMultiDiagramEditor editor;

	private BackboneContext backbone;

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

		gradientLabel = getWidgetFactory().createCLabel(composite, "Gradient Color:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		gradientLabel.setLayoutData(data);

		checboxGradientAppearence = getWidgetFactory().createButton(composite, "", SWT.CHECK);

		data = new FormData();
		data.left = new FormAttachment(gradientLabel, 0);
		data.top = new FormAttachment(gradientLabel, 1, SWT.CENTER);
		checboxGradientAppearence.setLayoutData(data);

		cheboxGradientAppearanceListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (namedElementEditPart != null) {
					if (((View) namedElementEditPart.getModel()) != null) {

						Boolean isChecked = checboxGradientAppearence.getSelection();

						// createProperty value
						// updateStereotypeLocationProperty(diagramElement,currentQualifiedNameSpec);
						// command creation
						if (editingDomain != null) {
							editingDomain.getCommandStack().execute(new SetGradienColorCommand(editingDomain, ((EModelElement) namedElementEditPart.getModel()), isChecked));
						}

						refresh();
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		checboxGradientAppearence.addSelectionListener(cheboxGradientAppearanceListener);

	}

	/*
	 * @see org.eclipse.ui.views.properties.tabbed.view.ITabbedPropertySection#refresh()
	 */
	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if ((!checboxGradientAppearence.isDisposed())) {

			checboxGradientAppearence.removeSelectionListener(cheboxGradientAppearanceListener);

			if (namedElementEditPart != null) {

				if ((namedElementEditPart.getModel()) != null) {
					checboxGradientAppearence.setSelection(GradientColorHelper.getGradientColorValue((EModelElement) namedElementEditPart.getModel()));

				} else {
					checboxGradientAppearence.setEnabled(false);
				}
			}
		}
		checboxGradientAppearence.addSelectionListener(cheboxGradientAppearanceListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		super.dispose();
		if (checboxGradientAppearence != null && !checboxGradientAppearence.isDisposed())
			checboxGradientAppearence.removeSelectionListener(cheboxGradientAppearanceListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Object input = ((IStructuredSelection) selection).getFirstElement();
		// look for modelManager
		if (input instanceof GraphicalEditPart) {
			namedElementEditPart = ((GraphicalEditPart) input);
			// selectionChanged(selection);
		}
		// When the selection is computed from the outline, get the associated editor
		if (part instanceof ContentOutline) {
			IContributedContentsView contributedView = ((IContributedContentsView) ((ContentOutline) part).getAdapter(IContributedContentsView.class));
			if (contributedView != null) {
				part = (IWorkbenchPart) contributedView.getContributingPart();
			}
		}
		if (part instanceof IMultiDiagramEditor) {
			editor = (IMultiDiagramEditor) part;
			backbone = editor.getDefaultContext();
			editingDomain = editor.getDefaultContext().getTransactionalEditingDomain();
		} else
			editingDomain = null;
	}

}
