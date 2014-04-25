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
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextEditor;
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
 * A StringEditor with support for inserting references to EObjects (Via a TextReferenceHelper)
 * 
 * @author Camille Letavernier
 * 
 */
public class RichTextEditorWithReferences extends RichTextEditor implements SelectionListener {

	protected Composite buttonsBar;

	protected Button insertReferenceButton;

	protected IStaticContentProvider referenceContentProvider = EmptyContentProvider.instance;

	protected ILabelProvider labelProvider = new LabelProvider();

	protected TextReferencesHelper referenceHelper;

	public RichTextEditorWithReferences(Composite parent, int style) {
		super(parent, style | SWT.MULTI);
		setLayout(new GridLayout(2, false));
		createButtonsBar(this);
	}

	@Override
	protected GridData getDefaultLayoutData() {
		GridData defaultData = super.getDefaultLayoutData();
		defaultData.horizontalSpan = 2;
		return defaultData;
	}

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

	protected void createButtons(Composite buttonsBar) {
		createInsertReferenceButton(buttonsBar);
	}

	protected void createInsertReferenceButton(Composite buttonsBar) {
		insertReferenceButton = new Button(buttonsBar, SWT.PUSH);
		insertReferenceButton.setToolTipText("Insert a dynamic reference to an Element");
		insertReferenceButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/hyperlink_16x16.gif")); //$NON-NLS-1$
		insertReferenceButton.addSelectionListener(this);
		insertReferenceButton.setLayoutData(new GridData(SWT.END, SWT.BEGINNING, true, false));
	}

	public void setReferenceBrowserContentProvider(IStaticContentProvider provider) {
		this.referenceContentProvider = provider;
	}

	public void setTextReferencesHelper(TextReferencesHelper helper) {
		this.referenceHelper = helper;
	}

	public void widgetSelected(SelectionEvent e) {
		if(e.widget == insertReferenceButton) {
			insertReferenceAction();
		}
	}

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

			String currentText = value;
			//			int caretPosition = text.getCaretPosition();

			//			String newText = referenceHelper.insertReference(objectToReference, currentText, caretPosition);
			//			if(newText.length() == currentText.length()) {
			//				return;
			//			}
			//
			//			int caretShift = newText.length() - currentText.length();
			//			int newCaretPosition = caretPosition + caretShift;

			//This should not happen with the standard ReferenceHelper as it is supposed to insert additional text into the current text
			//However, some ReferenceHelper implementations might replace the current text 
			//			if(newCaretPosition < 0) {
			//				newCaretPosition = 0;
			//			}
			//
			//			if(newCaretPosition > newText.length()) {
			//				newCaretPosition = newText.length();
			//			}
			//
			//			text.setText(newText);
			//			text.setFocus();
			//			text.setSelection(newCaretPosition);
			commit();
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}


}
