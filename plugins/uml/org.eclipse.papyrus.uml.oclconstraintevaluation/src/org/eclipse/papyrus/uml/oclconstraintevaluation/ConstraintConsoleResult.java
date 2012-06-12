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
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;

/**
 * this is console that display the result of a OCL Constraint. The pattern Singleton has been applied
 *
 */
public class ConstraintConsoleResult extends AbstractConsole {

	protected static ConstraintConsoleResult console;
	protected ConstraintConsolePage page;



	/**
	 * 
	 * Constructor.
	 *
	 */
	private ConstraintConsoleResult(){
		super("ConstraintConsoleResult",null);
	}

	public IPageBookViewPage createPage(IConsoleView view) {
		page = new ConstraintConsolePage();
		return page;
	}
	
	/**
	 * 
	 * @return the instance of the constraintConsoleResult
	 */
	public static ConstraintConsoleResult getInstance(){
		if(console==null){
			console=new ConstraintConsoleResult();
		}
		return console;
	}

	/**
	 * display the value of a OCL constraint written in the expression for a context  
	 * @param contextObject the context to compute the constraint
	 * @param expression the OCL constraint
	 */
	public void  compute(EObject contextObject,String expression){
		if( page!=null){
			page.compute(contextObject, expression);
		}
	}



}
