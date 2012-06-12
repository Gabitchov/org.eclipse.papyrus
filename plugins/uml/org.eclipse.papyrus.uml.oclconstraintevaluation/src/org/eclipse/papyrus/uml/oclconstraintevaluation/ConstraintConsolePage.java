/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.oclconstraintevaluation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.Page;

/**
 *this class is a text area that display the result of a constraint 
 *
 */
public class ConstraintConsolePage extends Page {
	protected Text textViewer;
	protected Composite page;

	protected  MetaModelManager nullMetaModelManager = null;

	@Override
	public void createControl(Composite parent) {
		page = new SashForm(parent, SWT.VERTICAL | SWT.LEFT_TO_RIGHT);

		textViewer = new Text(page, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		textViewer.setEditable(false);

	}

	@Override
	public Control getControl() {
		return page;
	}

	@Override
	public void setFocus() {}
	/**
	 * this method comes from the org.eclipse.ocl.examples.xtext.console.OCLConsolePage written by 
	 * @param contextObject
	 * @return the metamodelManager
	 */
	protected  MetaModelManager getMetaModelManager(EObject contextObject) {
		MetaModelManager metaModelManager = ElementUtil.findMetaModelManager(contextObject);
		if (metaModelManager != null) {
			return metaModelManager;
		}
		if (nullMetaModelManager == null) {
			nullMetaModelManager = new MetaModelManager();
		}
		return nullMetaModelManager;
	}
	
	

	/**
	 * allow to compute the constraint written in the string in the context of the EObject
	 * @param contextObject the context of the constraint
	 * @param expression the constraint
	 */
	public void  compute(EObject contextObject,String expression){
		//initialize the context of an evaluation of the OCL expression
		MetaModelManager metaModelManager = getMetaModelManager(contextObject);
		PivotEnvironmentFactory envFactory = new PivotEnvironmentFactory(null, metaModelManager);
		PivotEnvironment environment = envFactory.createEnvironment();
		OCL ocl= OCL.newInstance(environment); 
		OCLHelper oclHelper=ocl.createOCLHelper(contextObject);
		oclHelper.setContext(contextObject.eClass());
		try {
			ExpressionInOCL createQuery = oclHelper.createQuery(expression);
			Value evaluate = ocl.evaluate(contextObject, createQuery);
			String print = evaluate.asObject().toString();
			
			//clear the value of the text area
			textViewer.selectAll();
			textViewer.clearSelection();
			//display the value
			textViewer.setText("value = " + print);
		} catch (Exception ex) {
			textViewer.setText("\nERROR " + ex);
		} 

	}
}
