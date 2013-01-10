/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.hyperlink.helper.EditorHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * This shell is used to find the editors
 * 
 */
public class EditorHyperLinkEditorShell extends AbstractEditHyperlinkDocumentShell {

	/** The usedefault tooltip. */
	protected boolean usedefaultTooltip = true;

	/** The hyper link diagram. */
	protected HyperLinkEditor hyperLinkEditor;

	/** The editor registry. */
	private IPageIconsRegistry editorRegistry;

	/** The amodel. */
	protected final EObject amodel;

	/**
	 * Open.
	 */
	public void open() {
		Display display = Display.getCurrent();
		// code use to wait for an action from the user

		//		getEditHyperlinkShell().setBounds(500, 500, 600, 120);
		getEditHyperlinkShell().pack();
		getEditHyperlinkShell().open();
		while(!getEditHyperlinkShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Instantiates a new editor hyperlink diagram shell.
	 * 
	 * @param editorFactoryRegistry
	 *        the editor factory registry
	 * @param model
	 *        the model
	 */
	public EditorHyperLinkEditorShell(IPageIconsRegistry editorFactoryRegistry, EObject model) {
		super();
		this.amodel = model;
		this.editorRegistry = editorFactoryRegistry;
		createEditHyperlinkShell();
		getObjectcLabel().setText(Messages.EditorHyperLinkEditorShell_View); //TODO : where is it used?

		// intialize "use default" check box
		getUseDefaultCheckBox().setSelection(usedefaultTooltip);
		getObjectLabeltext().setEditable(false);
		if(usedefaultTooltip) {
			getTooltipInputText().setEditable(false);
			getTooltipInputText().setText(getObjectLabeltext().getText());
		}
		// add listener "use default button"
		getUseDefaultCheckBox().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				usedefaultTooltip = getUseDefaultCheckBox().getSelection();
				if(usedefaultTooltip) {
					getTooltipInputText().setEditable(false);
					getTooltipInputText().setText(getObjectLabeltext().getText());
				} else {
					getTooltipInputText().setEditable(true);
				}
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		// launch a new editor to choose or create diagrams
		getChooseDiagramButton().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				EditorLookForEditorShell editorLookForDiagram = new EditorLookForEditorShell(editorRegistry, amodel);
				editorLookForDiagram.open();
				Object selection = editorLookForDiagram.getSelectedEditor();
				if(selection == null) {//cancelled or no selection
					//nothing to do
				} else {

					EditorHyperLinkHelper helper = new EditorHyperLinkHelper();
					hyperLinkEditor = helper.getHyperLinkObjectFor(selection);
					Assert.isNotNull(hyperLinkEditor, NLS.bind(Messages.EditorHyperLinkEditorShell_ICanFindTheHyperLinkEditorObject, selection));
					hyperLinkEditor.setObject(selection);

					//TODO : remove this dependency
					//					DecoratingLabelProviderWTooltips labelProvider = new DecoratingLabelProviderWTooltips(new MoDiscoLabelProvider());
					getObjectLabeltext().setText(hyperLinkEditor.getText(selection));
					if(usedefaultTooltip) {
						getTooltipInputText().setText(getObjectLabeltext().getText());
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}
		});

		// listener to cancel
		this.getCancelButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				hyperLinkEditor = null;
				getEditHyperlinkShell().close();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		// listener to click on OK
		this.getOkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {

				if(hyperLinkEditor != null) {
					hyperLinkEditor.setTooltipText(getTooltipInputText().getText().trim());
					// if diagram is null, maybe bad selection or other it
					// return null!
					if(hyperLinkEditor.getObject() == null) {
						hyperLinkEditor = null;
					}
				}
				getEditHyperlinkShell().close();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}

	/**
	 * Gets the hyper link diagram.
	 * 
	 * @return the hyperLinkEditor maybe null, if cancel or bad selection
	 */
	public HyperLinkEditor getHyperLinkEditor() {
		return hyperLinkEditor;
	}

	/**
	 * Sets the hyper link diagram.
	 * 
	 * @param hyperLinkEditor
	 *        the hyperLinkEditor to set
	 */
	public void setHyperLinkEditor(HyperLinkEditor hyperLinkEditor) {
		//TODO
		getTooltipInputText().setText(hyperLinkEditor.getTooltipText());
		this.hyperLinkEditor = hyperLinkEditor;
	}
}
