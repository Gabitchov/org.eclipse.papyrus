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
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ContextLinkCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContextLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * use to construct the instance specification link between two instance
 * 
 */
public class CustomContextLinkCreateCommand extends ContextLinkCreateCommand {

	public CustomContextLinkCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	private View findView(EObject element) {
		if(element == null) {
			return null;
		}
		Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(element);
		for(Setting ref : settings) {
			if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
				View view = (View)ref.getEObject();
				if(view != null) {
					return view;
				}
			}
		}
		return null;
	}

	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Constraint) {
			return false;
		}
		if(target != null && false == target instanceof Namespace) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		if(getSource() != null) {
			if(getSource().getContext() != null && target != null) {
				if(getSource() instanceof Constraint) {
					View viewConstraint = findView((Constraint)getSource());
					List sourceConnections = ViewUtil.getSourceConnections(viewConstraint); //get all outgoing connections from constraint view
					for(Object connector : sourceConnections) {
						if(!(connector instanceof Edge)) {
							continue;
						}
						Edge edge = (Edge)connector;
						EObject targetElem = edge.getTarget().getElement();
						if(targetElem instanceof Namespace) {
							if(("" + ContextLinkEditPart.VISUAL_ID).equals(edge.getType()))
								return false; //case of the connector representing a context link
						}
					}
				}
			}
		}
		if(getTarget() != null && (getTarget().getOwnedRules().contains(getTarget()))) {
			return false;
		}
		return true;
	}
}
