/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.dialogs;

import org.eclipse.gmf.runtime.common.ui.util.PropertySheetUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This dialog provide a message and a link to navigate to a model element.
 */
public class WarningAndLinkDialog extends MessageDialog {

	/** The element to link */
	private NamedElement element;

	/** The label of the link */
	private String label;

	/**
	 * Construct a new dialog to open a warning message and a link to an element.
	 * 
	 * @param parentShell
	 * @param dialogTitle
	 * @param dialogMessage
	 * @param linkElement
	 */
	public WarningAndLinkDialog(Shell parentShell, String dialogTitle, String dialogMessage, NamedElement linkElement, String linkLabel) {
		super(parentShell, dialogTitle, null, dialogMessage, WARNING, new String[]{ IDialogConstants.OK_LABEL }, 0);
		element = linkElement;
		label = linkLabel;
	}

	/**
	 * Create the link to the element
	 * 
	 * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 *        the parent composite
	 * @return the hyperlink control
	 */
	@Override
	protected Control createCustomArea(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Hyperlink hyperLink = toolkit.createHyperlink(parent, label, SWT.UNDERLINE_LINK);
		hyperLink.setBackground(parent.getBackground());
		hyperLink.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
		hyperLink.addHyperlinkListener(new HyperlinkAdapter() {

			@Override
			public void linkActivated(HyperlinkEvent e) {
				navigateToElement();
				okPressed();
			}


		});
		return hyperLink;
	}

	/**
	 * Navigate to the linked element. Open it in model editor and print its properties.
	 */
	protected void navigateToElement() {
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		IViewReference[] views = editor.getSite().getPage().getViewReferences();
		for(IViewReference view : views) {
			IWorkbenchPart part = view.getPart(false);
			if(part instanceof CommonNavigator) {
				CommonNavigator navigator = (CommonNavigator)part;
				navigator.selectReveal(new StructuredSelection(element));
			}
		}
		PropertySheetUtil.setCurrentPageSelection(editor, new StructuredSelection(element));
	}
}
