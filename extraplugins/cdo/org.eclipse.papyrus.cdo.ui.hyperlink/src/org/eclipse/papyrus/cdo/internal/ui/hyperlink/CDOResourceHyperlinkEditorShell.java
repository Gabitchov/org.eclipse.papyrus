/*****************************************************************************
 * Copyright (c) 2009, 2013 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - adapted for CDO repository resource hyperlinks
 *
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.cdo.internal.ui.dialogs.BrowseRepositoryDialog;
import org.eclipse.papyrus.infra.hyperlink.ui.AbstractEditHyperlinkDocumentShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Objects;

/**
 * The editor shell facade for creation and editing of CDO resource hyperlinks.
 */
public class CDOResourceHyperlinkEditorShell extends AbstractEditHyperlinkDocumentShell {

	private boolean usedefaultTooltip = true;

	private CDOResourceHyperlink hyperlink;

	private boolean okPressed;

	public CDOResourceHyperlink getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(CDOResourceHyperlink hyperlink) {
		this.hyperlink = hyperlink;

		getObjectLabeltext().setText(hyperlink.getHyperlink().toString());
		getTooltipInputText().setText(hyperlink.getTooltipText());

		usedefaultTooltip = Objects.equal(getObjectLabeltext().getText(), getTooltipInputText().getText());
		getUseDefaultCheckBox().setSelection(usedefaultTooltip);
		getTooltipInputText().setEditable(!usedefaultTooltip);
	}

	/**
	 * Open.
	 */
	public boolean open() {
		Display display = Display.getCurrent();

		okPressed = false;

		// code use to wait for an action from the user
		getEditHyperlinkShell().pack();
		getEditHyperlinkShell().open();
		while(!getEditHyperlinkShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}

		return okPressed;
	}

	/**
	 * Instantiates me.
	 */
	public CDOResourceHyperlinkEditorShell() {
		super();

		createEditHyperlinkShell();

		// intialize "use default" check box
		getUseDefaultCheckBox().setSelection(usedefaultTooltip);
		getObjectLabeltext().setEditable(false);
		if(usedefaultTooltip) {
			getTooltipInputText().setEditable(false);
			getTooltipInputText().setText(getObjectLabeltext().getText());
		}
		// add listener "use default button"
		getUseDefaultCheckBox().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				usedefaultTooltip = getUseDefaultCheckBox().getSelection();
				if(usedefaultTooltip) {
					getTooltipInputText().setEditable(false);
					getTooltipInputText().setText(getObjectLabeltext().getText());
				} else {
					getTooltipInputText().setEditable(true);
				}
			}
		});

		getChooseDiagramButton().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				BrowseRepositoryDialog browse = new BrowseRepositoryDialog(getEditHyperlinkShell(), Messages.CDOResourceHyperlinkEditorShell_title, Messages.CDOResourceHyperlinkEditorShell_message, null, SWT.OPEN);
				browse.setBlockOnOpen(true);

				String initialURIString = getObjectLabeltext().getText().trim();
				if(!initialURIString.isEmpty()) {
					browse.setInitialURI(URI.createURI(initialURIString));
				}

				// select resource nodes of file or model kind, not folders
				browse.setNodeTypeFilter(EresourcePackage.Literals.CDO_RESOURCE_LEAF);

				if(browse.open() == Window.OK) {
					URI selected = browse.getSelectedURI();
					if(selected != null) {
						getObjectLabeltext().setText(selected.toString());
					}

					if(usedefaultTooltip) {
						getTooltipInputText().setText(selected.toString());
					}
				}
			}
		});

		// listener to cancel
		this.getCancelButton().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				hyperlink = null;
				getEditHyperlinkShell().close();
			}
		});
		// listener to click on OK
		this.getOkButton().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				if(hyperlink == null) {
					hyperlink = new CDOResourceHyperlink();
				}

				hyperlink.setHyperlink(URI.createURI(getObjectLabeltext().getText().trim()));
				hyperlink.setTooltipText(getTooltipInputText().getText().trim());

				okPressed = true;

				getEditHyperlinkShell().close();
			}
		});
	}
}
