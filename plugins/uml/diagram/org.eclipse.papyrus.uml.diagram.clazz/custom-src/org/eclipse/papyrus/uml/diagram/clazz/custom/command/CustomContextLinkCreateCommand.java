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
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ContextLinkCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContextLinkEditPart;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;

/**
 * use to construct the instance specification link between two instance
 * 
 */
public class CustomContextLinkCreateCommand extends ContextLinkCreateCommand {


	public CustomContextLinkCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
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
			// the context is already set
			if(getSource().getContext() != null && target != null && getSource().getContext() != target) {
				return false;
			}
		}
		View viewSource = findView(source);
		
		if(viewSource != null && source instanceof Constraint) {
			View viewTarget = findView(target);
			List sourceConnections = ViewUtil.getSourceConnections(viewSource);
			
			for(Object connector : sourceConnections) {
				if(!(connector instanceof Connector)) {
					continue;
				}
				Edge edge = (Edge)connector;

				if(("" + ContextLinkEditPart.VISUAL_ID).equals(edge.getType())) {
					if(viewTarget == edge.getTarget()) {
						// the context link is already
						//  drawn between the Constraint and the NamedElement
						return false;
					}
				}
			}
		}
				
		if(resolveTargetNamespace() != null && (resolveTargetNamespace().getOwnedRules().contains(resolveTargetNamespace()))) {
			return false;
		}
		return true;
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
}
