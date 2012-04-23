/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.edit.policy;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.util.PortViewDispatcher;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ArrangeAffixedNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.requests.ArrangeAffixedNodeRequest;
import org.eclipse.papyrus.uml.diagram.common.util.AffixedNodeDispatcher;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Port;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * Implementation of {@link ArrangeAffixedNodeEditPolicy} in order to arrange contained {@link Port} and {@link FlowPort}
 */
public class ArrangePortEditPolicy extends ArrangeAffixedNodeEditPolicy {

	/**
	 * {@inheritDoc ArrangeAffixedNodeEditPolicy}
	 * 
	 * @return
	 */
	@Override
	protected AffixedNodeDispatcher getDispatcher() {
		return PortViewDispatcher.getDispatcher();
	}

	/**
	 * Predicate to filter view of the port
	 */
	private static Predicate<View> portFilterPredicate = new Predicate<View>() {

		public boolean apply(View input) {
			if(input != null) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID.equals(input.getType()) || UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID.equals(input.getType());
			}
			return false;
		}
	};

	@Override
	protected List<View> getViewToArrange(ArrangeAffixedNodeRequest request) {
		View hostView = ((IGraphicalEditPart)getHost()).getNotationView();
		if(hostView != null) {
			TreeIterator<EObject> eAllContents = hostView.eAllContents();
			Iterator<View> viewIterator = Iterators.transform(eAllContents, new Function<EObject, View>() {

				public View apply(EObject from) {
					if(from instanceof View) {
						return (View)from;
					}
					return null;
				}
			});
			return Lists.newArrayList(Iterables.filter(Lists.newArrayList(viewIterator), portFilterPredicate));
		}
		return Collections.emptyList();
	}
}
