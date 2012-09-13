/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.hyperlink.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkContentProvider;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * dialog to display a list of hyperlinks. the button ok is use to excute the
 * action linked to the hyperlink (open new diagram, open new editor...)
 * 
 */
public class EditorNavigationDialog extends Dialog {

	// prefered dimension
	protected int width = 350;

	protected int height = 150;

	protected List<HyperLinkObject> hyperlinkObjects;

	protected HyperLinkContentProvider contentProvider;

	private TableViewer tableViewer;

	protected Table availableHyperLink;

	protected List<HyperLinkObject> hyperlinkResult = new ArrayList<HyperLinkObject>();

	/**
	 * 
	 * dialog to display a list of hyperlinks. the button ok is use to excute
	 * the action linked to the hyperlink (open new diagram, open new editor...)
	 * 
	 * @param parentShell
	 *        a shell
	 * @param hyperlinkObjects
	 *        the list of hyperlinkObjects
	 */
	public EditorNavigationDialog(Shell parentShell, ArrayList<HyperLinkObject> hyperlinkObjects) {
		super(parentShell);
		this.hyperlinkObjects = hyperlinkObjects;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createContents(Composite parent) {
		super.createContents(parent);
		Composite defaultHyperlinkComposite = (Composite)getDialogArea();

		Label lblHyperlinks = new Label(defaultHyperlinkComposite, SWT.NONE);
		lblHyperlinks.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
		lblHyperlinks.setText(Messages.DiagramNavigationDialog_WhichHyperLinksWouldYouToNavigateTo);

		// creation of the table
		availableHyperLink = new Table(defaultHyperlinkComposite, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);
		availableHyperLink.setLayoutData(new GridData(GridData.FILL_BOTH));

		// set the content provider
		this.contentProvider = new HyperLinkContentProvider();
		tableViewer = new TableViewer(availableHyperLink);
		tableViewer.setContentProvider(contentProvider);

		// set the label provider
		IPageIconsRegistry editorRegistry = null;
		IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry = papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		tableViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		tableViewer.setInput(this.hyperlinkObjects);

		//Check the first element by default
		if(availableHyperLink.getItemCount() > 0) {
			availableHyperLink.getItem(0).setChecked(true);
		}

		getShell().setText(Messages.DiagramNavigationDialog_ChooseHyperLinks);
		getShell().pack();

		return defaultHyperlinkComposite;
	}

	/**
	 * get the list of selected hyperlinks
	 * 
	 * @return the list
	 */
	public List<HyperLinkObject> getSelectedHyperlinks() {
		return hyperlinkResult;
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {

		hyperlinkResult = new ArrayList<HyperLinkObject>();
		TableItem[] tableItems = availableHyperLink.getItems();
		for(int i = 0; i < tableItems.length; i++) {
			if(tableItems[i].getChecked()) {
				hyperlinkResult.add((HyperLinkObject)tableItems[i].getData());
			}
		}

		super.okPressed();
	}
}
