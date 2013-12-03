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
import org.eclipse.jface.text.IDocument;
import org.eclipse.papyrus.C_Cpp.Virtual;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.AcceleoException;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;


/**
 * Panel displayed when an Operation is selected
 * 
 * TODO: instead of keeping isAbstract and pureVirtual Stereotype synchronized, pure virtual
 * could be removed from the panel
 */
public class CppBehaviorPanel extends CppAbstractPanel {

	private Group groupBody;

	// document used by the viewer
	private IDocument docBody;

	private Behavior selectedBehavior;

	private Button verifyAcceleo;
	
	Element selectedEOwner;

	public CppBehaviorPanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
	 */
	@Override
	public Behavior getSelectedElement() {
		return selectedBehavior;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(java.lang.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if(newElement instanceof Behavior) {
			this.selectedBehavior = (Behavior)newElement;
			// Retrieve the owner
			this.selectedEOwner = selectedBehavior.getOwner();
		}
		else {
			throw new RuntimeException("bad selection: " + newElement + " should be an uml2 Behavior");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContent()
	 */
	@Override
	public Control createContent()
	{
		///////////////////////////////////////////////////////////////////////
		// Create checkboxes
		///////////////////////////////////////////////////////////////////////
		verifyAcceleo = new Button(this, SWT.PUSH);
		verifyAcceleo.setText("verify embedded Acceleo");
		FormData dataVA = new FormData();
		dataVA.left = new FormAttachment(this, H_SPACE);
		dataVA.top = new FormAttachment(0, H_SPACE);
		verifyAcceleo.setLayoutData(dataVA);
		
		///////////////////////////////////////////////////////////////////////
		// Add checkboxes listeners
		///////////////////////////////////////////////////////////////////////

		verifyAcceleo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				try {
					AcceleoDriver.evaluate(docBody.get(), selectedBehavior, null);
					MessageDialog.openInformation(new Shell(), "Validation information", "no errors");
				}
				catch (AcceleoException err) {
					MessageDialog.openInformation(new Shell(), "Validation information", err.getMessage());
				}
			}
		});

		///////////////////////////////////////////////////////////////////////
		// Create save reset buttons with superclass method
		///////////////////////////////////////////////////////////////////////    	
		createSaveResetButtons();

		///////////////////////////////////////////////////////////////////////		
		// Constructor init list
		///////////////////////////////////////////////////////////////////////		

		///////////////////////////////////////////////////////////////////////
		// Body
		///////////////////////////////////////////////////////////////////////		

		docBody = createDocumentC();
		groupBody = createGroup(
			this
			, "Method body"
			, verifyAcceleo
			, null
			, true
			, 0
			, 0
			, true);
		// Use CDT CEditor coloration
		createViewerC(docBody, groupBody);

		///////////////////////////////////////////////////////////////////////	

		return this;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#save()
	 */
	@Override
	public void save()
	{
		if(selectedBehavior == null) {
			/* Log.debug("saveBody : selectedOperation is null"); */
		} else {
			CommandSupport.exec("C++ behavior save", new Runnable() {

				public void run() {
					// Body
					setCppBody(selectedBehavior, docBody.get());
				}
			});
		}

	}

	public static String getCppBody(Behavior behavior)
	{
		if(behavior instanceof OpaqueBehavior) {
			OpaqueBehavior ob = (OpaqueBehavior)behavior;
			int i = 0;
			for(String language : ob.getLanguages()) {
				if(language.equals(C_CPP_ID)) {
					return ob.getBodies().get(i);
				}
				else if(language.equals(CPP_ID)) {
					return ob.getBodies().get(i);
				}
				else if(language.equals(C_ID)) {
					return ob.getBodies().get(i);
				}
				i++;
			}
		}
		return "";
	}

	public static void setCppBody(Behavior behavior, String body)
	{
		boolean done = false;
		if(behavior instanceof OpaqueBehavior) {
			OpaqueBehavior ob = (OpaqueBehavior)behavior;
			int i = 0;
			for(String language : ob.getLanguages()) {
				if(language.equals(C_CPP_ID) || language.equals(CPP_ID) || language.equals(C_ID)) {
					done = true;
					ob.getBodies().set(i, body);
					break;
				}
				i++;
			}
			if(!done) {
				ob.getLanguages().add(C_CPP_ID);
				ob.getBodies().add(body);
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
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#exitAction()
	 */
	public void exitAction() {
		// do exit action, only if the owner is a class
		if(selectedEOwner instanceof Class) {
			super.exitAction();
		}
	}

	@Override
	public boolean checkModifications() {
		// check if ConstInit has changed
	
		String methodBody = getCppBody(selectedBehavior);

		if(!(docBody.get().equals(methodBody))) {
			return true;
		}

		return false;
	}

	@Override
	protected void refreshPanel() {
		if(selectedBehavior == null) {
			/* Log.debug("resetBody : selectedOperation is null"); */
		} else {

			String body = getCppBody(selectedBehavior);
			docBody.set(body);
		}
	}

	@Override
	protected boolean isModelValid() {
		if(selectedBehavior == null) {
			return true;
		}
		if(selectedEOwner instanceof Class) {

			if(selectedBehavior.isAbstract()) {
				if(!StereotypeUtil.isApplied(selectedBehavior, Virtual.class)) {
					return false;
				}
			}
		} else {
			// owner is interface
			if(!selectedBehavior.isAbstract()) {
				return false;
			}
			if(StereotypeUtil.isApplied(selectedBehavior, Virtual.class)) {
				return false;
			}
		}
		return true;

	}

	@Override
	protected void updateModel()
	{
		CommandSupport.exec("C++ operation save", new Runnable() {

			public void run()
			{
				if(selectedBehavior == null) {
					return;
				}
				if(selectedEOwner instanceof Class) {
					// toggle Stereotypes pure virtual if element is abstract
					if(selectedBehavior.isAbstract()) {
						if(!StereotypeUtil.isApplied(selectedBehavior, Virtual.class)) {
							// selectedOperation.toggleStereotype("VirtualPure", true);
							// selectedOperation.toggleStereotype("Virtual", false);
						} else {
							// selectedOperation.toggleStereotype("Virtual", false);
						}
					}

					// if element is abstract and has VirtualPure, set to Virtual only
					if(!selectedBehavior.isAbstract()) {
						if(StereotypeUtil.isApplied(selectedBehavior, Virtual.class)) {
							// selectedOperation.toggleStereotype("VirtualPure", false);
							// selectedOperation.toggleStereotype("Virtual", true);
						} else {
							// selectedOperation.toggleStereotype("VirtualPure", false);
							// selectedOperation.toggleStereotype("Virtual", false);
						}
					}
				}
				else {
					selectedBehavior.setIsAbstract(true);
					// selectedOperation.toggleStereotype("Virtual", false);
					// selectedOperation.toggleStereotype("VirtualPure", true);
				}
			}
		});
	}
}
