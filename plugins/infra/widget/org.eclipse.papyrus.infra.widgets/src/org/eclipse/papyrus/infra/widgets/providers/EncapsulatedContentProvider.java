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
package org.eclipse.papyrus.infra.widgets.providers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.strategy.IStrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.swt.widgets.Composite;

/**
 * A ContentProvider encapsulate another ContentProvider.
 * This class implements all Papyrus interfaces extending IContentProvider,
 * and is thus compatible with all papyrus tools, even if the encapsulated
 * provider is not.
 * 
 * Moreover, the Encapsulated provider can handle temporary elements.
 * 
 * @author Camille Letavernier
 * 
 */
//TODO : Move the temporary elements feature to another class. 
//This feature is only used by multi-reference dialogs
public class EncapsulatedContentProvider implements IHierarchicContentProvider, IGraphicalContentProvider, ICommitListener, IAdaptableContentProvider, IRevealSemanticElement, IStrategyBasedContentProvider, IStaticContentProvider {

	/**
	 * The encapsulated static content provider
	 */
	protected IStructuredContentProvider encapsulated;

	/**
	 * The set of temporaryElements, which are added from outside this ContentProvider
	 */
	private Set<Object> temporaryElements = new LinkedHashSet<Object>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param encapsulated
	 *        The encapsulated content provider, to which all calls will be forwarded
	 */
	public EncapsulatedContentProvider(IStructuredContentProvider encapsulated) {
		this.encapsulated = encapsulated;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	protected EncapsulatedContentProvider() {
	}

	/**
	 * Returns all elements known by this ContentProvider. This is the union of
	 * the objects returned by the wrapped StaticContentProvider and the temporary
	 * elements, which are not known by the wrapped provider.
	 * 
	 * @param elements
	 *        The Object[] returned by the encapsulated provider
	 * @return
	 *         All elements known by this ContentProvider
	 */
	private Object[] getAllElements(Object[] elements) {
		if(temporaryElements.isEmpty()) {
			return elements;
		}

		List<Object> result = ListHelper.asList(elements);
		result.addAll(temporaryElements);
		return result.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		//encapsulated.dispose();
		//encapsulated = null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(encapsulated != null) {
			encapsulated.inputChanged(viewer, oldInput, newInput);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if(encapsulated == null) {
			return new Object[0];
		}
		return getAllElements(encapsulated.getElements(inputElement));
	}

	/**
	 * Gets the elements for this content provider
	 * 
	 * @return
	 *         all elements from the wrapped ContentProvider
	 */
	public Object[] getElements() {
		if(encapsulated instanceof IStaticContentProvider) {
			return getAllElements(((IStaticContentProvider)encapsulated).getElements());
		}
		return getElements(null);
	}

	/**
	 * Adds a Temporary element to this ContentProvider
	 * 
	 * @param newObject
	 *        The temporary element to be added
	 */
	public void addTemporaryElement(Object newObject) {
		temporaryElements.add(newObject);
	}

	/**
	 * Removes a Temporary element from this ContentProvider
	 * 
	 * @param removeObject
	 *        The temporary element to remove
	 */
	public void removeTemporaryElement(Object removeObject) {
		temporaryElements.remove(removeObject);
	}

	/**
	 * Clears all temporary elements from this content provider
	 */
	public void clearTemporaryElements() {
		temporaryElements.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if(encapsulated instanceof ITreeContentProvider) {
			return ((ITreeContentProvider)encapsulated).getChildren(parentElement);
		} else {
			return new Object[0];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		if(encapsulated instanceof ITreeContentProvider) {
			return ((ITreeContentProvider)encapsulated).getParent(element);
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		if(encapsulated instanceof ITreeContentProvider) {
			return ((ITreeContentProvider)encapsulated).hasChildren(element);
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isValidValue(Object element) {
		if(encapsulated instanceof IHierarchicContentProvider) {
			return ((IHierarchicContentProvider)encapsulated).isValidValue(element);
		} else {
			return true;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createBefore(Composite parent) {
		if(encapsulated instanceof IGraphicalContentProvider) {
			((IGraphicalContentProvider)encapsulated).createBefore(parent);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createAfter(Composite parent) {
		if(encapsulated instanceof IGraphicalContentProvider) {
			((IGraphicalContentProvider)encapsulated).createAfter(parent);
		}
	}

	public void commit(AbstractEditor editor) {
		if(encapsulated instanceof ICommitListener) {
			((ICommitListener)encapsulated).commit(editor);
		}
	}

	public Object getAdaptedValue(Object selection) {
		if(encapsulated instanceof IAdaptableContentProvider) {
			return ((IAdaptableContentProvider)encapsulated).getAdaptedValue(selection);
		}
		return selection;
	}

	public void revealSemanticElement(List<?> elementList) {
		if(encapsulated instanceof IRevealSemanticElement) {
			((IRevealSemanticElement)encapsulated).revealSemanticElement(elementList);
		}
	}

	public TreeBrowseStrategy getBrowseStrategy() {
		if(encapsulated instanceof IStrategyBasedContentProvider) {
			return ((IStrategyBasedContentProvider)encapsulated).getBrowseStrategy();
		}
		return null;
	}

	public TreeBrowseStrategy getRevealStrategy() {
		if(encapsulated instanceof IStrategyBasedContentProvider) {
			return ((IStrategyBasedContentProvider)encapsulated).getRevealStrategy();
		}
		return null;
	}
}
