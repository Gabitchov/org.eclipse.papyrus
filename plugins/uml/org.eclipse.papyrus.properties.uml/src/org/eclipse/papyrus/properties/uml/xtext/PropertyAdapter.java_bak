/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.property.editor.xtext.ui.contributions.PropertyPopupEditorConfigurationContribution;
import org.eclipse.papyrus.property.editor.xtext.ui.internal.UmlPropertyActivator;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.widgets.xtext.adapter.IXtextAdapter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;

import com.google.inject.Injector;


public class PropertyAdapter implements IXtextAdapter {

	public EObject reconcile(EObject sourceModelObject, EObject xtextObject) {
		Property target;
		if(sourceModelObject != null) {
			target = (Property)sourceModelObject;
		} else {
			target = UMLFactory.eINSTANCE.createProperty();
		}
		PropertyRule source = (PropertyRule)xtextObject;

		target.setName(source.getName());
		target.setVisibility(getVisibility(source));
		return target;
	}

	private VisibilityKind getVisibility(PropertyRule source) {
		switch(source.getVisibility()) {
		case PACKAGE:
			return VisibilityKind.PACKAGE_LITERAL;
		case PRIVATE:
			return VisibilityKind.PRIVATE_LITERAL;
		case PROTECTED:
			return VisibilityKind.PROTECTED_LITERAL;
		case PUBLIC:
			return VisibilityKind.PUBLIC_LITERAL;
		default:
			return null;
		}
	}

	public String getText(EObject modelObject) {
		PropertyPopupEditorConfigurationContribution config = new PropertyPopupEditorConfigurationContribution();
		return config.getTextToEdit(modelObject); //Cannot retrieve the property type's label
	}

	public Injector getInjector() {
		//return (new UmlPropertyStandaloneSetup()).createInjectorAndDoEMFRegistration();
		//return Guice.createInjector(new UmlPropertyRuntimeModule());
		return UmlPropertyActivator.getInstance().getInjector("org.eclipse.papyrus.property.editor.xtext.UmlProperty"); //$NON-NLS-1$
	}

}
