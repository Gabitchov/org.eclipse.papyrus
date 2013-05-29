/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.edit.policy;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Realization;

public class CustomDragDropEditPolicy extends RequirementDiagramDragDropEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualID = new HashSet<Integer>();
		return droppableElementsVisualID;
	}
	
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		String semanticHint = "-1";

		// Fill the semantic hint during the drop when the top level is the Requirement Diagram
		if(containerView instanceof Diagram) {
			if(domainElement instanceof org.eclipse.uml2.uml.Package) {
				semanticHint = ElementTypes.PACKAGE.getSemanticHint();
			}
			if((domainElement instanceof org.eclipse.uml2.uml.Class)) {
				org.eclipse.uml2.uml.Class domainElementClass = (org.eclipse.uml2.uml.Class)domainElement;
				if(domainElementClass.getAppliedStereotype(SysmlResource.REQUIREMENT_ID) != null) {
					semanticHint = ElementTypes.CLASS.getSemanticHint();
				}
			}
			
			if(domainElement instanceof Comment) {
				semanticHint = ElementTypes.COMMENT.getSemanticHint();
			}
			
			if(domainElement instanceof Constraint) {
				semanticHint = ElementTypes.CONSTRAINT.getSemanticHint();
			}
						
		}

		// Fill the semantic hint during the drop when the top level is the an element in the Requirement Diagram  (a Package for instance)
		else {
			if(domainElement instanceof org.eclipse.uml2.uml.Package) {
				semanticHint = ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if((domainElement instanceof org.eclipse.uml2.uml.Class)) {
				org.eclipse.uml2.uml.Class domainElementClass = (org.eclipse.uml2.uml.Class)domainElement;
				if(domainElementClass.getAppliedStereotype(SysmlResource.REQUIREMENT_ID) != null) {
					semanticHint = ElementTypes.CLASS_CN.getSemanticHint();
				}
			}
			
			if(domainElement instanceof Comment) {
				semanticHint = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			
			if(domainElement instanceof Constraint) {
				semanticHint = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			
		}

		// In the case of we want to Drag and drop something else than a package or a Requirement, if this is a NamedElement, 
		// we can fill the semanticHint with the NamedElement dedicated Value
		if(semanticHint == "-1") {
			if((domainElement instanceof org.eclipse.uml2.uml.NamedElement)) {
				semanticHint = ElementTypes.DEFAULT_NAMED_ELEMENT.getSemanticHint();
			}
		}

		return new Integer(semanticHint);
	}
	
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		String semanticHint = "-1";

		if(domainElement instanceof Abstraction) {
			semanticHint = ElementTypes.ABSTRACTION.getSemanticHint();
		}

		if(domainElement instanceof Dependency) {
			semanticHint = ElementTypes.DEPENDENCY.getSemanticHint();
		}
		
		if(domainElement instanceof PackageImport) {
			semanticHint = ElementTypes.PACKAGE_IMPORT.getSemanticHint();
		}
		if(domainElement instanceof Realization) {
			semanticHint = ElementTypes.REALIZATION.getSemanticHint();
		}
		
		return new Integer(semanticHint);

	}
	
}
