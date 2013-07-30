/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util.functions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import com.google.common.base.Function;
/**
 * Transform an EObject to a View
 * If the EObject passed into apply is not a view then return null
 * @author adaussy
 *
 */
public class EObjectToViewFunction implements Function<EObject, View> {

	private static class SingletonHolder {
		private static EObjectToViewFunction INSTANCE = new EObjectToViewFunction();
	}
	
	public static EObjectToViewFunction getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	public View apply(EObject from) {
		if ( from instanceof View){
			return (View)from;			
		}
		return null;
	}

}
