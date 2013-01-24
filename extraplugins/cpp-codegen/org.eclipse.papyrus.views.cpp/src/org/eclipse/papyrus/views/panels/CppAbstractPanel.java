/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.views.panels;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.views.cpp.Activator;
import org.eclipse.papyrus.views.listeners.UMLElementPanelListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Element;


/**
 * 
 */
public abstract class CppAbstractPanel extends Composite {

	static final Font pluginFont = new Font(null, "Bitstream Vera Sans Mono", 10, SWT.NORMAL);

	public static final int H_SPACE = 10;

	// string representing the ID of the language
	// this is the string contained in the language attribute of Activity
	protected static final String CPP_ID = "C/C++";

	// CppInclude text area
	protected Button buttonSave;

	protected Button buttonCancel;

	/** Listener for modifications on the uml element */
	protected UMLElementPanelListener umlListener = null;

	public CppAbstractPanel(Composite parent, int style) {

		super(parent, style);
		this.setLayout(new FormLayout());
		FormData layoutData = new FormData();
		layoutData.top = new FormAttachment(0);
		layoutData.bottom = new FormAttachment(100);
		layoutData.left = new FormAttachment(0);
		layoutData.right = new FormAttachment(100);
		this.setLayoutData(layoutData);
		this.setBackground(parent.getBackground());
		this.setVisible(true);
	}

	public abstract Control createContent();


	/////////////////////////////////////////////////////////////////////// 
	// Following method are used to create text area w/o coloration
	/////////////////////////////////////////////////////////////////////// 
	//	/**
	//	 * 
	//	 */
	//	protected FastPartitioner createPartitioner() {
	//		FastPartitioner pluginPartitioner = new FastPartitioner(
	//				new CPartitionScanner(), new String[] {
	//					CPartitionScanner.C_SINGLE_LINE_COMMENT,
	//					CPartitionScanner.C_MULTILINE_COMMENT,
	//					CPartitionScanner.C_STRING
	//				}
	//		);
	//		
	//		return pluginPartitioner;
	//	}


	/**
	 * Create a group for a text area
	 * 
	 * @param textArea
	 *        parent composite
	 * @param name
	 *        of the group
	 * @param t_previous
	 *        attached to top border
	 * @param l_previous
	 *        attached to left border
	 * @param toRight
	 *        should group reach right border of parent
	 * @param height
	 *        of text in percent of group size
	 * @param width
	 *        of text in percent of group size
	 * @param toBottom
	 *        should group reach bottom of parent
	 * @return new Group
	 */
	protected Group createGroup(
		Composite textArea
		, String name
		, Control t_previous
		, Control l_previous
		, boolean toRight
		, int height
		, int width
		, boolean toBottom) {

		Group groupBody = new Group(textArea, SWT.NONE);

		groupBody.setBackground(textArea.getBackground());
		groupBody.setLayout(new FormLayout());
		groupBody.setText(" " + name + " ");
		groupBody.setFont(Activator.VIEW_FONT);

		FormData data = new FormData();
		if(t_previous != null) {
			data.top = new FormAttachment(t_previous, H_SPACE);
		}

		if(l_previous != null) {
			data.left = new FormAttachment(l_previous, H_SPACE);
		}

		if(data.top == null) {
			data.top = new FormAttachment(0, H_SPACE);
		}

		if(data.left == null) {
			data.left = new FormAttachment(0, H_SPACE);
		}

		if(toBottom) {
			data.bottom = new FormAttachment(100, -H_SPACE);
		} else if(height != 0) {
			data.bottom = new FormAttachment(height);
		}

		if(toRight) {
			data.right = new FormAttachment(100, -H_SPACE);
		} else {
			data.right = new FormAttachment(width, 0);
		}

		groupBody.setLayoutData(data);
		return groupBody;
	}

	/**
	 * Create a simple viewer without coloration
	 * 
	 * @param doc
	 * @param group
	 * @return
	 */
	protected SourceViewer createViewer(IDocument doc, Group group) {

		SourceViewer viewer =
			new SourceViewer(group, null, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

		viewer.setDocument(doc);

		viewer.getTextWidget().setLayout(new FormLayout());
		FormData viewerData = new FormData();
		viewerData.height = 20;
		viewerData.top = new FormAttachment(0);
		viewerData.bottom = new FormAttachment(100);
		viewerData.left = new FormAttachment(0);
		viewerData.right = new FormAttachment(100);
		viewer.getTextWidget().setLayoutData(viewerData);

		return viewer;
	}

	/**
	 * 
	 * @param doc
	 * @param group
	 * @return
	 */
	protected SourceViewer createViewerC(IDocument doc, Group group) {
		return createViewer(doc, group);
	}

	/**
	 * Create a simple document
	 * 
	 * @return
	 */
	protected IDocument createDocument() {
		IDocument doc = new Document();

		return doc;
	}

	/**
	 * Create a C/C++ (see cdt) document
	 * 
	 * @return
	 */
	protected IDocument createDocumentC() {
		return createDocument();
	}

	/////////////////////////////////////////////////////////////////////// 

	/**
	 * Create save and reset button in the top - right of the structure
	 * 
	 */
	protected void createSaveResetButtons() {

		/////////////////////////////////////////////////////////////////////////
		// Create a composite that contain the "Save/Cancel" buttons
		/////////////////////////////////////////////////////////////////////////

		buttonSave = new Button(this, SWT.PUSH);
		buttonSave.setImage(Activator.getImage(Activator.SAVE_IMAGE));
		buttonSave.setToolTipText(Activator.getResourceString("panel.class.button.save.tooltip"));
		buttonSave.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				save();
			}
		});

		buttonCancel = new Button(this, SWT.PUSH);
		buttonCancel.setImage(Activator.getImage(Activator.UNDO_IMAGE));
		buttonCancel.setToolTipText(Activator.getResourceString("panel.class.button.cancel.tooltip"));
		buttonCancel.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				reset();
			}
		});

		FormData dataC = new FormData();
		dataC.right = new FormAttachment(100, -H_SPACE);
		dataC.top = new FormAttachment(0, H_SPACE);
		buttonCancel.setLayoutData(dataC);

		FormData dataS = new FormData();
		dataS.right = new FormAttachment(buttonCancel, -H_SPACE);
		dataS.top = new FormAttachment(0, H_SPACE);
		buttonSave.setLayoutData(dataS);
	}

	/**
	 * Create new button
	 * 
	 * @param name
	 *        of the button
	 * @param parent
	 *        composite that owns the button
	 * @param previous
	 *        structure on which button is left attached
	 * @return the newly created button
	 */
	protected Button createButton(String name, Composite parent, Button previous) {
		Button newButton = new Button(parent, SWT.CHECK);

		newButton.setBackground(parent.getBackground());
		newButton.setText(name);
		FormData data = new FormData();

		if(previous == null) {
			data.left = new FormAttachment(0, H_SPACE);
		} else {
			data.left = new FormAttachment(previous, H_SPACE);
		}

		data.top = new FormAttachment(0, H_SPACE);
		newButton.setLayoutData(data);

		return newButton;
	}

	/**
	 * Selection listener that match button status and a particular stereotype
	 * 
	 * @param button
	 * @param stereotypeName
	 */
	protected void addStereotypeSelectionListener(final Button button, final String stereotypeName) {

		button.addSelectionListener(
			new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {

					updateModel();
					refreshPanel();
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			}
			);
	}

	/**
	 * Action executed just after the panel is created for the specific element.
	 */
	public void entryAction() {
		reset();
	}

	/**
	 * Action executed just before moving to the new element.
	 */
	public void exitAction() {
		boolean modelChanged = false;

		// check if model was modified (read only action)
		modelChanged = checkModifications();

		// model has change, must go in a write transaction => save
		if(modelChanged) {
			MessageDialog dialog = new MessageDialog(
				Display.getCurrent().getActiveShell(),
				Activator.getResourceString("panel.property.dialog.saveorignore.title"),
				Activator.getImage(Activator.WARNING_IMAGE),
				Activator.getResourceString("panel.property.dialog.saveorignore"),
				0,
				new String[]{
					Activator.getResourceString("panel.property.dialog.saveorignore.button.save"),
					Activator.getResourceString("panel.property.dialog.saveorignore.button.ignore") },
				0);
			dialog.open();
			if(dialog.getReturnCode() == 0) { //saveButton pressed
				save();
			}
		}
	}

	/**
	 * Check if the content of the panel has modification against the corresponding UML element.
	 * 
	 * @return <code>true</code> if the panel has modification against the model
	 */
	public abstract boolean checkModifications();

	/**
	 * Action executed when save button is pressed
	 */
	public abstract void save();

	/**
	 * Action executed when reset button is pressed
	 */
	public void reset() {
		boolean modelValid = true;
		modelValid = isModelValid();
		if(!modelValid) {
			updateModel();
		}
		refreshPanel();
	}

	/**
	 * Refresh panel
	 */
	protected abstract void refreshPanel();

	/**
	 * Makes the model coherent with the AccordCpp Methodology
	 */
	protected void updateModel() {
	}

	/**
	 * Check if model is coherent with the AccordCpp Methodology
	 * 
	 * @return <code>true</code> if the model is coherent with the AccordCpp Methodology
	 */
	protected boolean isModelValid() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		if(getSelectedElement() != null && umlListener != null) {
			getSelectedElement().eAdapters().remove(umlListener);
		}
		super.dispose();
	}

	/**
	 * Returns the selected element
	 * <p>
	 * Warning: it can be <code>null</code>
	 * 
	 * @return the selected element
	 */
	public abstract Element getSelectedElement();

	/**
	 * Sets the new selected element
	 * 
	 * @param newElement
	 *        the new selected element
	 */
	public void setSelectedElement(Element newElement) {
		if(newElement != null && umlListener != null) {
			newElement.eAdapters().add(umlListener);
		}
	}
}
