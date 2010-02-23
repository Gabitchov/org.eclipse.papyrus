/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;

// TODO: Auto-generated Javadoc
/**
 * The Class EditorHyperlinkDiagramShell.
 */
public class EditorHyperlinkDiagramShell extends AbstractEditHyperlinkDocumentShell {

	/** The usedefault tooltip. */
	protected boolean usedefaultTooltip = true;

	/** The hyper link diagram. */
	protected HyperLinkDiagram hyperLinkDiagram;

	/** The editor registry. */
	private IPageIconsRegistry editorRegistry;

	/** The amodel. */
	protected final Package amodel;

	/**
	 * Open.
	 */
	public void open() {
		Display display = Display.getCurrent();
		// code use to wait for an action from the user
		getEditHyperlinkShell().pack();
		getEditHyperlinkShell().setBounds(500, 500, 600, 120);
		getEditHyperlinkShell().open();
		while(!getEditHyperlinkShell().isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
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
	public EditorHyperlinkDiagramShell(IPageIconsRegistry editorFactoryRegistry, Package model) {
		super();
		this.amodel = model;
		this.editorRegistry = editorFactoryRegistry;
		createEditHyperlinkShell();
		getObjectcLabel().setText("Diagram:");

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
		getChooseDiagramButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				EditorLookForDiagram editorLookForDiagram = new EditorLookForDiagram(editorRegistry, amodel);

				editorLookForDiagram.open();
				if(hyperLinkDiagram == null) {
					hyperLinkDiagram = new HyperLinkDiagram();
				}
				hyperLinkDiagram.setDiagram(editorLookForDiagram.getSelectedDiagram());
				if(hyperLinkDiagram.getDiagram() != null) {
					getObjectLabeltext().setText(hyperLinkDiagram.getDiagram().getName());
				} else {
					getObjectLabeltext().setText("UNDEFINED");
				}
				if(usedefaultTooltip) {
					getTooltipInputText().setText(getObjectLabeltext().getText());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		// listener to cancel
		this.getCancelButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				hyperLinkDiagram = null;
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

				if(hyperLinkDiagram != null) {
					hyperLinkDiagram.setTooltipText(getTooltipInputText().getText().trim());
					// if diagram is null, maybe bad selection or other it return null!
					if(hyperLinkDiagram.getDiagram() == null) {
						hyperLinkDiagram = null;
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
	 * @return the hyperLinkDiagram maybe null, if cancel or bad selection
	 */
	protected HyperLinkDiagram getHyperLinkDiagram() {
		return hyperLinkDiagram;
	}

	/**
	 * Sets the hyper link diagram.
	 * 
	 * @param hyperLinkDiagram
	 *        the hyperLinkDiagram to set
	 */
	protected void setHyperLinkDiagram(HyperLinkDiagram hyperLinkDiagram) {
		getObjectLabeltext().setText(hyperLinkDiagram.getDiagram().getName());
		getTooltipInputText().setText(hyperLinkDiagram.getTooltipText());
		this.hyperLinkDiagram = hyperLinkDiagram;
	}
}
