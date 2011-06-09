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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.alf.validation.typing.TypeExpression;

public abstract class AbstractScopingTool {
	
	public abstract AlfPartialScope getVisibleVariablesOrParametersOrProperties(EObject context) ;

	public abstract AlfPartialScope getVisibleOperationsOrBehaviors(EObject context) ;
	
	public abstract AlfPartialScope getVisibleBehaviors(EObject context) ;
	
	public abstract AlfPartialScope getVisibleClassifiers(EObject context) ;
	
	public abstract AlfPartialScope getVisiblePackages(EObject context) ;

	public abstract boolean isAReturnStatementExpected(EObject context) ;

	public abstract TypeExpression getExpectedReturnType(EObject context) ;
	
	public abstract AlfPartialScope getVisibleSignalReceptions(EObject context) ;
}
