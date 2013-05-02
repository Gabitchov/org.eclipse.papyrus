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
import org.eclipse.papyrus.cpp.profile.StUtils;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Parameter;


/**
 * Panel displayed when a Parameter is selected
 */
public class CppParameterPanel extends CppAbstractPanel {

	private Button isConst;

	private Parameter selectedParameter;

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

	public CppParameterPanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordAbstractPanel#getSelectedElement()
	 */
	@Override
	public org.eclipse.uml2.uml.Parameter getSelectedElement() {
		return selectedParameter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordAbstractPanel#setSelectedElement(java.lang.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if(newElement instanceof Parameter) {
			this.selectedParameter = (Parameter)newElement;
		}
		else {
			throw new RuntimeException("bad selection: " + newElement + " should be an uml2 Parameter");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContent()
	 */
	public Control createContent() {
		///////////////////////////////////////////////////////////////////////
		// Create save reset buttons with superclass method
		///////////////////////////////////////////////////////////////////////    	
		createSaveResetButtons();

		///////////////////////////////////////////////////////////////////////
		// Create checkboxes
		///////////////////////////////////////////////////////////////////////
		isConst = createButton("isConst", this, null);

		///////////////////////////////////////////////////////////////////////
		// Add checkboxes listeners
		///////////////////////////////////////////////////////////////////////
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
	 * Saves the body for an '<code>Parameter</code>'
	 */
	public void save()
	{
		if(selectedParameter == null) {
			/* Log.debug("saveBody : selectedParameter is null"); */
		}
		else {
			CommandSupport.exec("C++ parameter save", new Runnable() {

				public void run()
				{
					// Treat Pointer
					String newPtr = docPtr.get();
					if(newPtr.equals("")) {
						StUtils.unapply(selectedParameter, Ptr.class);
					}
					else {
						StUtils.apply(selectedParameter, Ptr.class);
					}

					// Treat Reference
					String newRef = docRef.get();
					if(newRef.equals("")) {
						StUtils.unapply(selectedParameter, Ref.class);
					}
					else {
						StUtils.apply(selectedParameter, Ref.class);
					}

					// Treat DefaultValue
					// need common class for facilitating this
					// selectedParameter.setDefaultValue(selectedParameter.createDefaultValue("default", selectedParameter.getType(), null);

					// Treat Array
					String newArray = docArray.get();
					if(newArray.equals("")) {
						StUtils.unapply(selectedParameter, Array.class);
					}
					else {
						StUtils.apply(selectedParameter, Array.class);
						// StUtils.setTaggedValue(selectedParameter, Array.class, "definition", newArray);
					}
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordAbstractPanel#refreshPanel()
	 */
	@Override
	protected void refreshPanel() {
		if(selectedParameter != null) {
			// Const

			isConst.setSelection(StUtils.isApplied(selectedParameter, Const.class));
			// TODO: examine effect;
			// isConst.setSelection(selectedParameter.getEffect?);

			docPtr.set(StUtils.isApplied(selectedParameter, Ptr.class) ? "*" : "");
			docRef.set(StUtils.isApplied(selectedParameter, Ref.class) ? "&" : "");
			docDefault.set(selectedParameter.getDefault());
			docArray.set(StUtils.isApplied(selectedParameter, Array.class) ? "[]" : "");
			// need definition?
		}
	}

	/**
	 * Called when the static checkbox is modified
	 */
	protected void checkConst() {

		boolean boxState = isConst.getSelection();

		if(boxState) {
			if(!StUtils.isApplied(selectedParameter, Const.class)) {
				StUtils.apply(selectedParameter, Const.class);
			}
		} else {
			if(StUtils.isApplied(selectedParameter, Const.class)) {
				StUtils.unapply(selectedParameter, Const.class);
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
	 * @see com.cea.accordcpp.core.ui.panels.AccordAbstractPanel#checkModifications()
	 */
	@Override
	public boolean checkModifications() {
		String ptrValue = StUtils.isApplied(selectedParameter, Ptr.class) ? "*" : "";
		if(!docPtr.get().equals(ptrValue)) {
			return true;
		}

		String refValue = StUtils.isApplied(selectedParameter, Ref.class) ? "&" : "";
		if(!docRef.get().equals(refValue)) {
			return true;
		}

		String defaultValue = selectedParameter.getDefault();
		if(defaultValue == null) {
			if(!docDefault.get().equals("")) {
				return true;
			}
		}
		else if(!docDefault.get().equals(defaultValue)) {
			return true;
		}

		String arrayValue = StUtils.isApplied(selectedParameter, Array.class) ? "[]" : "";
		if(!docArray.get().equals(arrayValue)) {
			return true;
		}
		return false;
	}

	@Override
	protected void updateModel() {

		// Check button changes
		CommandSupport.exec("C++ parameter update", new Runnable() {

			public void run()
			{
				checkConst();
			}
		});
	}
}
