/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.state.editor.xtext.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.state.editor.xtext.umlState.StateRule;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class UmlStateScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * The EObject context represents the context UML model element for the active xtext editor.
	 * This variable is public static, and updated when a given xtext editor gets the focus.
	 * @see IEObjectContextUpdater from org.eclipse.xtext.gmf.glue.edit.part
	 * @see IXTextEditorContextUpdater from org.eclipse.xtext.gmf.glue.edit.part
	 */
	public static EObject context = null ;
	
}
