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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.scoping;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.PopupXtextEditorHelper;
import org.eclipse.papyrus.uml.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 * 
 */
public class AppliedStereotypePropertyScopeProvider extends AlfScopeProvider {

	public IScope scope_AppliedStereotypePropertyRule_property(AppliedStereotypePropertyRule ctx, EReference ref) {

		IScope result = null;
		EditPart contextEObject = ((EditPart)PopupXtextEditorHelper.getHostEditPart());
		if(contextEObject instanceof IAdaptable) {
			AppliedStereotypeProperty appliedStereotypeProperty = (AppliedStereotypeProperty)contextEObject.getAdapter(AppliedStereotypeProperty.class);

			ArrayList<org.eclipse.uml2.uml.Property> properties = new ArrayList<org.eclipse.uml2.uml.Property>();
			properties.add(appliedStereotypeProperty.getStereotypeProperty());
			Iterable<IEObjectDescription> visiblePropertiesIterable = Scopes.scopedElementsFor(properties);
			result = new SimpleScope(visiblePropertiesIterable);
		}
		return result;
	}

	public IScope scope_PrimaryExpression_prefix(PrimaryExpression ctx, EReference ref) {
		IScope result = null;
		return null;
	}
}
