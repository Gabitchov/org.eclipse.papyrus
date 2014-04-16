/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.RichTextValueEditor;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A RichText editor with support for inserting references to EObjects (Via a TextReferenceHelper).
 *
 * @author Mickaël ADAM
 */
public class RichTextEditorWithReferences extends RichTextValueEditor implements SelectionListener {

	/** The buttons bar. */
	protected Composite buttonsBar;

	/** The insert reference button. */
	protected Button insertReferenceButton;

	/** The reference content provider. */
	protected IStaticContentProvider referenceContentProvider = EmptyContentProvider.instance;

	/** The label provider. */
	protected ILabelProvider labelProvider = new LabelProvider();

	/** The reference helper. */
	protected TextReferencesHelper referenceHelper;

	/**
	 * Instantiates a new rich text editor with references.
	 *
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 */
	public RichTextEditorWithReferences(Composite parent, int style) {
		super(parent, style | SWT.MULTI);
		setLayout(new GridLayout(1, false));
		createButtonsBar(this);
	}

	/**
	 * Gets the default layout data.
	 *
	 * @return the default layout data
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#getDefaultLayoutData()
	 */
	@Override
	protected GridData getDefaultLayoutData() {
		GridData defaultData = super.getDefaultLayoutData();
		defaultData.horizontalSpan = 2;
		return defaultData;
	}

	/**
	 * Creates the buttons bar.
	 *
	 * @param wrapper
	 *        the wrapper
	 */
	protected void createButtonsBar(Composite wrapper) {
		buttonsBar = new Composite(wrapper, SWT.NONE);
		GridLayout buttonsBarLayout = new GridLayout(1, true);

		buttonsBarLayout.marginWidth = 0;
		buttonsBarLayout.marginHeight = 0;

		buttonsBar.setLayout(buttonsBarLayout);
		buttonsBar.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		buttonsBar.moveAbove(label);
		createButtons(buttonsBar);
	}

	/**
	 * Creates the buttons.
	 *
	 * @param buttonsBar
	 *        the buttons bar
	 */
	protected void createButtons(Composite buttonsBar) {
		createInsertReferenceButton(buttonsBar);
	}

	/**
	 * Creates the insert reference button.
	 *
	 * @param buttonsBar
	 *        the buttons bar
	 */
	protected void createInsertReferenceButton(Composite buttonsBar) {
		insertReferenceButton = new Button(buttonsBar, SWT.PUSH);
		insertReferenceButton.setToolTipText("Insert a dynamic reference to an Element");
		insertReferenceButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/hyperlink_16x16.gif")); //$NON-NLS-1$
		insertReferenceButton.addSelectionListener(this);
		insertReferenceButton.setLayoutData(new GridData(SWT.END, SWT.BEGINNING, true, false));
	}

	/**
	 * Sets the reference browser content provider.
	 *
	 * @param provider
	 *        the new reference browser content provider
	 * @see org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextEditor#setReferenceBrowserContentProvider(org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider)
	 */
	public void setReferenceBrowserContentProvider(IStaticContentProvider provider) {
		this.referenceContentProvider = provider;
	}

	/**
	 * Sets the text references helper.
	 *
	 * @param helper
	 *        the new text references helper
	 */
	public void setTextReferencesHelper(TextReferencesHelper helper) {
		this.referenceHelper = helper;
	}

	/**
	 * Widget selected.
	 *
	 * @param event
	 *        the event
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent event) {
		if(event.widget == insertReferenceButton) {
			insertReferenceAction();
		}
	}

	/**
	 * Insert reference action.
	 */
	protected void insertReferenceAction() {
		if(referenceHelper == null) {
			//The widget is not properly set. We cannot handle references
			Activator.log.warn("This widget is not properly configured. It cannot handle reference insertion");
			return;
		}

		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());

		dialog.setContentProvider(new EncapsulatedContentProvider(referenceContentProvider));
		dialog.setLabelProvider(labelProvider);

		if(dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if(result.length == 0) {
				return;
			}

			Object resultElement = result[0];
			if(!(resultElement instanceof EObject)) {
				return;
			}

			EObject objectToReference = (EObject)resultElement;
			String newText = referenceHelper.insertReference(objectToReference, "", 0);

			getRichTextEditor().addHTML(newText);

			commit();
		}
	}

	/**
	 * Widget default selected.
	 *
	 * @param event
	 *        the event
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent event) {
		//Nothing
	}

	/**
	 * Sets the label provider.
	 *
	 * @param labelProvider
	 *        the new label provider
	 * @see org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextEditor#setLabelProvider(org.eclipse.jface.viewers.ILabelProvider)
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	@Override
	public void addCommitListener(ICommitListener listener) {
		// TODO Auto-generated method stub
		super.addCommitListener(listener);
	}

}
