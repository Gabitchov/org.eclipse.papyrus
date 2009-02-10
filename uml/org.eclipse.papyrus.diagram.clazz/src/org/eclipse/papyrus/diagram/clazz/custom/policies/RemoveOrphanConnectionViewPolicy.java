/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ModelCanonicalEditPolicy;

/**
 * this policy is used to supress orphan connection in GMF diagram
 * 
 * @author Patrick Tessier
 */
public abstract class RemoveOrphanConnectionViewPolicy extends ModelCanonicalEditPolicy {

	protected HashMap<String, String> edgeWithoutElement;

	/**
	 * the constructor
	 */
	public RemoveOrphanConnectionViewPolicy() {
		super();
		edgeWithoutElement = new HashMap<String, String>();
		initMapEdgewithoutElement();

	}

	/**
	 * It exist two manner to find orphan edge: the edge is no associated to an element of the model exception contained into "edgeWithoutElement"- the edge is associated to bad element (not defined
	 * in the mapping)
	 * 
	 * @param viewChildren
	 *            the view
	 * @return the list of edge to supress
	 */
	protected List findOrphanEdge(Collection<Edge> viewChildren) {
		ArrayList<Edge> orphanEdge = new ArrayList<Edge>();
		Iterator<Edge> it = viewChildren.iterator();
		while (it.hasNext()) {
			Edge currentEdge = it.next();
			// find if it extist a bad mapping

			if (currentEdge.getElement() != null) {
				// try to find a Ielement type

				String prefix = getPrefixofElementTypes();
				String umlElementClassName = currentEdge.getElement().getClass().getInterfaces()[0].getSimpleName();

				String result2 = prefix + "." + umlElementClassName + "_" + currentEdge.getType();
				IElementType theElementType = ElementTypeRegistry.getInstance().getType(result2);
				if (theElementType == null) {
					orphanEdge.add(currentEdge);
				}
			}
			if (currentEdge.getElement() == null && !edgeWithoutElement.containsKey(currentEdge.getType())) {
				orphanEdge.add(currentEdge);
			}
		}

		return orphanEdge;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Collection getConnectionViews() {
		ArrayList edgelist = new ArrayList();
		Iterator<EObject> it = ((View) getHost().getModel()).eContents().iterator();
		while (it.hasNext()) {
			EObject currentObject = it.next();
			if (currentObject instanceof Edge) {
				edgelist.add((Edge) currentObject);
			}
		}
		return edgelist;
	}

	/**
	 * get the string that is the prefix of ElementTypes for example. In class diagram this is: "org.eclipse.papyrus.diagram.clazz";
	 * 
	 * @return the prefix
	 */
	protected abstract String getPrefixofElementTypes();

	/**
	 * add element ID that are not linked to the model example for the class diagram <BR>
	 * </BR><quote> edgeWithoutElement.put(((IHintedType) UMLElementTypes.Link_4016).getSemanticHint(), ((IHintedType) UMLElementTypes.Link_4016).getSemanticHint()); </quote>
	 */
	protected abstract void initMapEdgewithoutElement();

	/**
	 * this code comes from generated classes of canonical policies
	 * 
	 * @return
	 */
	private Collection refreshConnections() {

		return new ArrayList();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void refreshSemantic() {
		List createdConnectionViews = refreshSemanticConnections();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected List refreshSemanticConnections() {
		Edge viewChild;
		EObject semanticChild;
		//
		// current connection views
		Collection<Edge> viewChildren = getConnectionViews();

		List orphaned = findOrphanEdge(viewChildren);
		//
		// delete all the remaining views
		deleteViews(orphaned.iterator());

		//
		// create a view for each remaining semantic element.
		List viewDescriptors = new ArrayList();

		return viewDescriptors;
	}
}
