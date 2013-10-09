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

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.C_Cpp.Array;
import org.eclipse.papyrus.C_Cpp.Const;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.C_Cpp.Ref;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;


/**
 * Panel displayed when a Property is selected
 */
public class CppPropertyPanel extends CppAbstractPanel {

	private Button isStatic;

	private Button isConst;

	private Property selectedProperty;

	// document used by the viewer
	private IDocument docPtr;

	private IDocument docRef;

	private IDocument docArray;

	private IDocument docDefault;

	@SuppressWarnings("unused")
	private SourceViewer viewerPtr;

	@SuppressWarnings("unused")
	private SourceViewer viewerRef;

	@SuppressWarnings("unused")
	private SourceViewer viewerArray;

	@SuppressWarnings("unused")
	private SourceViewer viewerDefault;

	private Group groupPtr;

	private Group groupRef;

	private Group groupArray;

	private Group groupDefault;

	public CppPropertyPanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
	 */
	@Override
	public Property getSelectedElement() {
		return selectedProperty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(java.lang.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if(newElement instanceof Property) {
			this.selectedProperty = (Property)newElement;
		}
		else {
			throw new RuntimeException("bad selection: " + newElement + " should be an uml2 Property");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContent()
	 */
	@Override
	public Control createContent() {
		///////////////////////////////////////////////////////////////////////
		// Create save reset buttons with superclass method
		///////////////////////////////////////////////////////////////////////    	
		createSaveResetButtons();

		///////////////////////////////////////////////////////////////////////
		// Create checkboxes
		///////////////////////////////////////////////////////////////////////
		isStatic = createButton("isStatic", this, null);
		isConst = createButton("isConst", this, isStatic);

		///////////////////////////////////////////////////////////////////////
		// Add checkboxes listeners
		///////////////////////////////////////////////////////////////////////
		isStatic.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				updateModel();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		addStereotypeSelectionListener(isConst, "Const");

		///////////////////////////////////////////////////////////////////////		
		// Pointer declaration
		///////////////////////////////////////////////////////////////////////		
		docPtr = createDocument();
		groupPtr = createGroup(
			this
			, "Pointer declaration"
			, buttonSave
			, null
			, false
			, 0
			, 25
			, false);

		// Use CDT CEditor coloration
		viewerPtr = createViewer(docPtr, groupPtr);

		///////////////////////////////////////////////////////////////////////		
		// Pointer declaration
		///////////////////////////////////////////////////////////////////////		
		docRef = createDocument();
		groupRef = createGroup(
			this
			, "Reference declaration"
			, buttonSave
			, groupPtr
			, false
			, 0
			, 50
			, false);

		// Use CDT CEditor coloration
		viewerRef = createViewer(docRef, groupRef);

		///////////////////////////////////////////////////////////////////////		
		// Pointer declaration
		///////////////////////////////////////////////////////////////////////		
		docDefault = createDocument();
		groupDefault = createGroup(
			this
			, "Default value"
			, buttonSave
			, groupRef
			, false
			, 0
			, 75
			, false);

		// Use CDT CEditor coloration
		viewerDefault = createViewer(docDefault, groupDefault);

		///////////////////////////////////////////////////////////////////////		
		// Pointer declaration
		///////////////////////////////////////////////////////////////////////		
		docArray = createDocument();
		groupArray = createGroup(
			this
			, "Array value ([...])"
			, buttonSave
			, groupDefault
			, true
			, 0
			, 0
			, false);

		// Use CDT CEditor coloration
		viewerArray = createViewer(docArray, groupArray);

		///////////////////////////////////////////////////////////////////////			
		// Return control
		///////////////////////////////////////////////////////////////////////	

		return this;
	}

	/**
	 * Saves the body for an '<code>Property</code>'
	 */
	public void save()
	{
		if(selectedProperty == null) {
			/* Log.debug("saveBody : selectedProperty is null"); */
		}
		else {
			CommandSupport.exec("C++ package save", new Runnable() {

				public void run()
				{
					// Treat Pointer
					String newPtr = docPtr.get();
					if(newPtr.equals("")) {
						StereotypeUtil.unapply(selectedProperty, Ptr.class);
					}
					else {
						StereotypeUtil.apply(selectedProperty, Ptr.class);
					}

					// Treat Reference
					String newRef = docRef.get();
					if(newRef.equals("")) {
						StereotypeUtil.unapply(selectedProperty, Ref.class);
					}
					else {
						StereotypeUtil.apply(selectedProperty, Ref.class);
					}

					// Treat DefaultValue
					// need common class for facilitating this
					// selectedParameter.setDefaultValue(selectedParameter.createDefaultValue("default", selectedParameter.getType(), null);

					// Treat Array
					String newArray = docArray.get();
					if(newArray.equals("")) {
						StereotypeUtil.unapply(selectedProperty, Array.class);
					}
					else {
						StereotypeUtil.apply(selectedProperty, Array.class);
					}
				}
			});
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#refreshPanel()
	 */
	@Override
	protected void refreshPanel() {
		if(selectedProperty == null) {
			/* Log.debug("resetBody : selectedProperty is null"); */
		}
		else {
			isStatic.setSelection(selectedProperty.isStatic());
			isConst.setSelection(StereotypeUtil.isApplied(selectedProperty, Const.class));
			docPtr.set(StereotypeUtil.isApplied(selectedProperty, Ptr.class) ? "*" : "");
			docRef.set(StereotypeUtil.isApplied(selectedProperty, Ref.class) ? "&" : "");
			docDefault.set(selectedProperty.getDefault());
			docArray.set(StereotypeUtil.isApplied(selectedProperty, Array.class) ? "[]" : "");
		}
	}

	/**
	 * Called when the static checkbox is modified
	 */
	protected void checkStatic() {

		boolean boxState = isStatic.getSelection();

		selectedProperty.setIsStatic(boxState);
	}

	/**
	 * Called when the const checkbox is modified
	 */
	protected void checkConst() {
		boolean boxState = isConst.getSelection();

		if(StereotypeUtil.isApplied(selectedProperty, Const.class) != boxState) {
			if(boxState) {
				StereotypeUtil.apply(selectedProperty, Const.class);
			}
			else {
				StereotypeUtil.unapply(selectedProperty, Const.class);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#entryAction()
	 */
	public void entryAction() {
		super.entryAction();
		reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#exitAction()
	 */
	public void exitAction() {
		super.exitAction();
	}

	/**
	 * Checks if the content of the panel is different to the model
	 * <p>
	 * This is a read only operation
	 * 
	 * @return <code>true</code> if one of the element of the model is not up-to-date
	 *         with the content of the panel
	 */
	public boolean checkModifications() {
		String ptrValue = StereotypeUtil.isApplied(selectedProperty, Ptr.class) ? "*" : "";
		if(!docPtr.get().equals(ptrValue)) {
			return true;
		}

		String refValue = StereotypeUtil.isApplied(selectedProperty, Ref.class) ? "&" : "";
		if(!docRef.get().equals(refValue)) {
			return true;
		}

		String defaultValue = selectedProperty.getDefault();
		if(defaultValue == null) {
			if(!docDefault.get().equals("")) {
				return true;
			}
		}
		else if(!docDefault.get().equals(defaultValue)) {
			return true;
		}

		String arrayValue = StereotypeUtil.isApplied(selectedProperty, Array.class) ? "[]" : "";
		if(!docArray.get().equals(arrayValue)) {
			return true;
		}
		return false;

	}


	@Override
	protected void updateModel()
	{
		CommandSupport.exec("C++ property save", new Runnable() {

			public void run()
			{
				// Check button changes
				checkStatic();
				checkConst();

			}
		});
	}
}
