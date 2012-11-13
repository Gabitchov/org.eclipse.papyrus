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
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

/**
 * this is console that display the result of a OCL Constraint. The pattern Singleton has been applied
 * 
 */
public class OCLEvaluationView extends ViewPart {

	private Text textViewer;

	/**
	 * ID
	 */
	public static String ID = "org.eclipse.papyrus.uml.oclconstraintevaluation.OCLEvaluationView";

	protected MetaModelManager metaModelManager = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public OCLEvaluationView() {
		super();
	}

	@Override
	public void setFocus() {
		textViewer.setFocus();
	}

	@Override
	public void createPartControl(Composite parent) {
		textViewer = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		textViewer.setEditable(false);
		textViewer.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	}

	/**
	 * this method comes from the org.eclipse.ocl.examples.xtext.console.OCLConsolePage written by
	 * 
	 * @param contextObject
	 * @return the metamodelManager
	 */
	protected MetaModelManager getMetaModelManager(EObject contextObject) {
		MetaModelManager metaModelManager = ElementUtil.findMetaModelManager(contextObject);
		if(metaModelManager != null) {
			return metaModelManager;
		}
		if(metaModelManager == null) {
			metaModelManager = new MetaModelManager();
		}
		return metaModelManager;
	}



	/**
	 * allow to compute the constraint written in the string in the context of the EObject
	 * 
	 * @param contextObject
	 *        the context of the constraint
	 * @param expression
	 *        the constraint
	 */
	public void compute(EObject contextObject, String expression) {
		//initialize the context of an evaluation of the OCL expression
		MetaModelManager metaModelManager = getMetaModelManager(contextObject);
		PivotEnvironmentFactory envFactory = new PivotEnvironmentFactory(null, metaModelManager);
		PivotEnvironment environment = envFactory.createEnvironment();
		OCL ocl = OCL.newInstance(environment);
		OCLHelper oclHelper = ocl.createOCLHelper(contextObject);
		oclHelper.setContext(contextObject.eClass());
		try {
			ExpressionInOCL createQuery = oclHelper.createQuery(expression);
			Object evaluate = ocl.evaluate(contextObject, createQuery);
			String print = evaluate.toString();

			//display the value
			textViewer.setText("value = " + print);
		} catch (Exception ex) {
			textViewer.setText("\nERROR " + ex);
		}

	}
}
