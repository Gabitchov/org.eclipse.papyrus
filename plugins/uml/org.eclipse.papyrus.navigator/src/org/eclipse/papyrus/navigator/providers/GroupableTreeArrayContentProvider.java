/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EObjectItemProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;

/**
 * A provider that takes envelopes children in groups by type. EObjecs are grouped by their
 * {@link EClass}. {@link Object}s are grouped by their first Interface.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=290422>Bug #290422</a>
 * 
 */
public class GroupableTreeArrayContentProvider extends EObjectItemProvider {

	/**
	 * A <Map> from <Object> to containing <PackagingNode>.
	 */
	private static Map<Object, PackagingNode> parentNodes = null;

	/**
	 * A <Map> from <Object> to contained <PackagingNodes>.
	 */
	private static Map<Object, Collection<?>> virtualSuperNodes = null;

	synchronized protected static Map<Object, PackagingNode> getParentNodes() {
		if (parentNodes == null) {
			parentNodes = new HashMap<Object, PackagingNode>();
		}
		return parentNodes;
	}

	synchronized protected static Map<Object, Collection<?>> getVirtualSuperNodes() {
		if (virtualSuperNodes == null) {
			virtualSuperNodes = new HashMap<Object, Collection<?>>();
		}
		return virtualSuperNodes;
	}

	AdapterFactory helperAdapterFactory;

	public GroupableTreeArrayContentProvider(AdapterFactory adapterFactory, AdapterFactory helper) {
		super(adapterFactory);
		helperAdapterFactory = helper;
	}

	@Override
	public Collection<?> getChildren(Object parentElement) {
		if (parentElement instanceof PackagingNode) {
			return ((PackagingNode) parentElement).getContainedNodes();
		} else if (getVirtualSuperNodes().containsKey(parentElement)) {
			updateElementChildren(parentElement);
			return getVirtualSuperNodes().get(parentElement);
		} else {
			Collection<?> children = getVirtualSupernodes(parentElement);
			getVirtualSuperNodes().put(parentElement, children);
			return children;
		}
	}

	public Object getParent(Object element) {
		if (element instanceof PackagingNode) {
			return ((PackagingNode) element).getParent();
		} else if (getParentNodes().containsKey(element)) {
			return getParentNodes().get(element);
		} else if (element instanceof EObject && element instanceof View == false) {
			createVirtualSuperNodesTilParent((EObject) element);
			if (getParentNodes().containsKey(element)) {
				return getParentNodes().get(element);
			}
		}
		Object adapter = helperAdapterFactory.adapt(element, ITreeItemContentProvider.class);
		if (adapter instanceof ITreeItemContentProvider) {
			return ((ITreeItemContentProvider) adapter).getParent(element);
		} else
			return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof PackagingNode) {
			return true;
		} else {

			Object adapter = helperAdapterFactory.adapt(element, ITreeItemContentProvider.class);
			if (adapter instanceof ITreeItemContentProvider) {
				return ((ITreeItemContentProvider) adapter).hasChildren(element);
			} else
				return false;
		}
	}

	@Override
	public Collection<?> getElements(Object inputElement) {

		return getVirtualSupernodes(inputElement);
	}

	private String getKey(Object o) {
		if (o instanceof EObject) {
			return ((EObject) o).eClass().getName();
		} else {
			return o.getClass().getInterfaces()[0].getSimpleName();
		}
	}

	private Collection<?> getVirtualSupernodes(Collection<?> node) {
		Object[] nodes = node != null ? node.toArray(new Object[node.size()]) : new Object[0];
		return getVirtualSupernodes(nodes);
	}

	private Collection<?> getVirtualSupernodes(Object[] node) {
		Map<String, Object> superNodes = new HashMap<String, Object>();
		Object[] nodeList = node != null ? node : new Object[0];

		for (int i = 0; i < nodeList.length; i++) {
			if (nodeList[i] instanceof View) {
				superNodes.put(nodeList[i].toString(), nodeList[i]);
			} else {
				String key = getKey(nodeList[i]);
				PackagingNode ghostNode = null;
				if (!superNodes.containsKey(key)) {
					ghostNode = new PackagingNode(key, super.getParent(nodeList[i]));
					superNodes.put(key, ghostNode);
				} else {
					ghostNode = superNodes.get(key) instanceof PackagingNode ? (PackagingNode) superNodes.get(key)
							: null;
				}
				if (ghostNode != null) {
					ghostNode.getContainedNodes().add(nodeList[i]);
					getParentNodes().put(nodeList[i], ghostNode);
				}
			}
		}
		return superNodes.values();
	}

	private Collection<?> getVirtualSupernodes(Object parent) {
		Collection<?> children = null;
		Object adapter = helperAdapterFactory.adapt(parent, ITreeItemContentProvider.class);
		if (adapter instanceof ITreeItemContentProvider) {
			children = ((ITreeItemContentProvider) adapter).getChildren(parent);
		}
		if (parent instanceof EObject && children != null) {
			// Map<Object, Collection<?>> superNodes = getVirtualSuperNodes();
			// collection of EClass nodes to create
			Collection<EClass> eClasses = new ArrayList<EClass>();
			// collection of other elements to add as children
			Collection<Object> othersToAdd = new ArrayList<Object>();
			for (Object child : children) {
				if (child instanceof EObject && !(child instanceof Diagram || child instanceof EAnnotation)) {
					// for each child EObject we'll find its EClass and add it
					// as a node to create
					EClass eClass = ((EObject) child).eClass();
					if (!eClasses.contains(eClass)) {
						eClasses.add(eClass);
					}
				} else {
					// if not an EObject it will be added as a child as is
					othersToAdd.add(child);
				}
			}
			// final collection of actual children to show in the tree for this
			// parent element
			Collection<Object> superNodes = new ArrayList<Object>();
			// EObjectPackagingNodes for EObjects
			for (EClass eClass : eClasses) {
				EObjectPackagingNode node = new EObjectPackagingNode(eClass, (EObject) parent);
				superNodes.add(node);
				// add to the parentNodes collection these newly created
				// elements
				for (Object o : node.getContainedNodes()) {
					getParentNodes().put(o, node);
				}
			}
			// other Objects that are children
			for (Object object : othersToAdd) {
				superNodes.add(object);
			}
			return superNodes;
		} else {
			return getVirtualSupernodes(children);
		}
	}

	protected void updateElementChildren(Object parent) {
		if (getVirtualSuperNodes().containsKey(parent)) {
			Collection<Object> oldCollection = (Collection<Object>) getVirtualSuperNodes().get(parent);
			Collection<Object> newCollection = (Collection<Object>) getVirtualSupernodes(parent);
			mergeCollections(oldCollection, newCollection);
		} else {
			return;
		}
	}

	/**
	 * Adds to oldC the new elements in newC. Removes from oldC the elements that don't appear in
	 * newC.
	 * 
	 * @param oldC
	 * @param newC
	 */
	protected void mergeCollections(Collection<Object> oldC, Collection<Object> newC) {
		if (oldC == null || newC == null || (oldC.size() == 0 && newC.size() == 0)) {
			return;
		}
		// elements to remove from oldC
		Collection<Object> toRemove = new ArrayList<Object>();
		for (Object o : oldC) {
			if (!newC.contains(o)) {
				toRemove.add(o);
			}
		}
		// elements to add to oldC
		Collection<Object> toAdd = new ArrayList<Object>();
		for (Object o : newC) {
			if (!oldC.contains(o)) {
				toAdd.add(o);
			}
		}
		// remove elements
		for (Object o : toRemove) {
			oldC.remove(o);
		}
		// add elements
		for (Object o : toAdd) {
			oldC.add(o);
		}
	}

	protected void createVirtualSuperNodesTilParent(EObject element) {
		if (getVirtualSuperNodes().containsKey(element)) {
			return;
		}
		if (element.eContainer() != null) {
			createVirtualSuperNodesTilParent(element.eContainer());
		}
		getChildren(element);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}

}
