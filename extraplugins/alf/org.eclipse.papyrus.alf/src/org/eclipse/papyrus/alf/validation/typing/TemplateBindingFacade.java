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
package org.eclipse.papyrus.alf.validation.typing;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.alf.alf.SequenceExpansionExpression;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;

public class TemplateBindingFacade {
	
	public class ParameterSubstitutionFacade {
		private ClassifierTemplateParameter formal ;
		private TypeFacade actual ;
		
		public ParameterSubstitutionFacade(TemplateParameterSubstitution t) {
			this.formal = (ClassifierTemplateParameter)t.getFormal() ;
			this.actual = TypeFacadeFactory.eInstance.createTypeFacade((Classifier)t.getActual()) ;
		}
		
		public ParameterSubstitutionFacade(ClassifierTemplateParameter formal, TypeFacade actual) {
			this.formal = formal ;
			this.actual = actual ;
		}

		public ClassifierTemplateParameter getFormal() {
			return formal;
		}

		public void setFormal(ClassifierTemplateParameter formal) {
			this.formal = formal;
		}

		public TypeFacade getActual() {
			return actual;
		}

		public void setActual(TypeFacade actual) {
			this.actual = actual;
		}
		
		public String getLabel(boolean withExplicitFormalParameter) {
			String label = actual.getLabelWithoutBinding() ;
			if (withExplicitFormalParameter) {
				label = ((Classifier)formal.getParameteredElement()).getName() + " => " + label ;
			}
			return label ;
		}
		
		public String getLabel() {
			return getLabel(false) ;
		}
	}
	
	private List<ParameterSubstitutionFacade>  substitutions ;
	
	public TemplateBindingFacade() {
		this.substitutions = new ArrayList<TemplateBindingFacade.ParameterSubstitutionFacade>() ;
	}
	
	public String getLabel(boolean withExplicitFormalParameters) {
		if (substitutions.isEmpty())
			return "" ;
		String label = "<" ;
		boolean first = true ;
		for (ParameterSubstitutionFacade s : substitutions) {
			if (!first) label += ", " ; else first = false ;
			label += withExplicitFormalParameters ? s.getLabel(true) : s.getLabel(false) ; 
		}
		label += ">" ;
		return label ;
	}
	
	public String getLabel() {
		return this.getLabel(false) ;
	}
}
