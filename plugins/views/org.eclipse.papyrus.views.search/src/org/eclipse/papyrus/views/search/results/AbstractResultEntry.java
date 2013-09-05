/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *  Christian W. Damus (CEA LIST) - Fix equals() to avoid resolving source objects and add missing hashCode() 
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.results;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.ui.PartInitException;

/**
 * 
 * Abstract implementation of Result entry. A ResultEntry is an entry that will appear in the result of a search. It provides a tree structure.
 * It is abstract because entries can be real matches i.e. {@see ModelMatch} or entries shown for hierarchical reasons i.e. {@see ResultEntry}.
 * 
 */
public abstract class AbstractResultEntry extends Match {

	/**
	 * The source element that raised a match
	 */
	protected Object source;

	/**
	 * The parent of this result entry in the hierarchy
	 */
	protected Object parent;

	protected URI uriSource;

	protected java.net.URI uriResource;
	
	protected URI uriEResource;

	/**
	 * Used to specify offset and length of {@link Match} when these attributes are not meaningful
	 */
	final protected static int UNSPECIFIED = -1;

	/**
	 * Every implementation of {@link AbstractResultEntry} must implement this to define what should be displayed in labelproviders
	 * 
	 * @return
	 *         the element to display in labelproviders
	 */
	public abstract Object elementToDisplay();

	/**
	 * Every implementation of {@link AbstractResultEntry} must implement this to define what element is to give to the {@link OpenElementService}
	 * 
	 * @return
	 *         the element to open with {@link OpenElementService}
	 */
	public abstract Object openElement(OpenElementService service) throws ServiceException, PartInitException;

	/**
	 * Every implementation of {@link AbstractResultEntry} must implement this to define what element is to be analyzed by {@link MatchFilter}(s)
	 * 
	 * @return
	 *         the element to analyze to filter matches
	 */
	public abstract Object elementToCheckFilterFor();

	/**
	 * Compute the parent hierarchy of parents of a element in a model
	 * 
	 * @param child
	 *        the element to search parents for
	 * @param scopeEntry
	 *        the {@link ScopeEntry} corresponding to the resource that contains the element that matches
	 */
	public void recursiveHierarchy(AbstractResultEntry child) {
		if(child.getSource() instanceof EObject) {
			EObject potentialParent = ((EObject)child.getSource()).eContainer();

			if(potentialParent != null) {
				ResultEntry theParent = new ResultEntry(potentialParent, (ScopeEntry)this.getElement());
				child.setParent(theParent);
				recursiveHierarchy(theParent);
			} else {
				ResultEntry theParent = new ResultEntry(((ScopeEntry)this.getElement()).getResourceURI(), (ScopeEntry)this.getElement());
				child.setParent(theParent);
			}
		}
	}

	protected AbstractResultEntry getLastParent(AbstractResultEntry child, ScopeEntry scopeEntry) {
		if(child.getSource() instanceof EObject) {


			EObject potentialParent = ((EObject)child.getSource()).eContainer();
			ResultEntry theParent = null;

			while(potentialParent != null) {
				theParent = new ResultEntry(potentialParent, scopeEntry);
				theParent.setParent(new ResultEntry(scopeEntry.getResourceURI(), scopeEntry));

				potentialParent = potentialParent.eContainer();
			}

			if(theParent == null) {

				theParent = new ResultEntry(scopeEntry.getResourceURI(), scopeEntry);

			}
			return theParent;

		}

		return null;

	}

	/**
	 * It is a really important override that used to not duplicate elements in the result hierarchy. Extensions of {@link AbstractResultEntry} may
	 * specialize this method
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof AbstractResultEntry)) {
			// support comparison against EObjects
			// FIXME: This violates the symmetry contract of Object::equals!
			if(obj instanceof EObject && this.getSource() instanceof EObject) {
				if(EcoreUtil.equals((EObject)this.getSource(), (EObject)obj)) {
					if(((AbstractResultEntry)obj).getOffset() == this.getOffset()) {
						if(((AbstractResultEntry)obj).getLength() == this.getLength()) {
							return true;
						}
					}
				}
			}
			return false;
		}

		AbstractResultEntry other = (AbstractResultEntry)obj;

		// don't attempt to resolve the source object by URI in case it is no longer available.
		// Note that, in the degenerate (and invalid) case in which all of the uri variants of
		// both result entries are null, they are not considered equal
		boolean sameSource = ((uriSource != null) && uriSource.equals(other.uriSource)) //
			|| ((uriResource != null) && uriResource.equals(other.uriResource)) //
			|| ((uriEResource != null) && uriEResource.equals(other.uriEResource));

		return sameSource && (getOffset() == other.getOffset()) && (getLength() == other.getLength());
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		
		if (uriSource != null) {
			result = result ^ uriSource.hashCode();
		}
		if (uriResource != null) {
			result = result ^ uriResource.hashCode();
		}
		if (uriEResource != null) {
			result = result ^ uriEResource.hashCode();
		}
		
		result = result ^ (getOffset() * 17);
		result = result ^ (getLength() * 37);
		
		return super.hashCode();
	}

	/**
	 * @see Match#Match(Object, int, int)
	 * 
	 * @param offset
	 * 
	 * @param lenght
	 * 
	 * @param source
	 *        the element that raised the match
	 * @param scopeEntry
	 *        the {@link ScopeEntry} that correspond to the resource that contains the element that raised the match
	 */
	public AbstractResultEntry(int offset, int lenght, Object source, ScopeEntry scopeEntry) {
		super(scopeEntry, offset, lenght);
		//		this.source = source;
		if(source instanceof EObject) {

			this.uriSource = EcoreUtil.getURI((EObject)source);
		} else if(source instanceof IResource) {
			this.uriResource = ((IResource)source).getLocationURI();
		} else if (source instanceof URI) {
			URI uri = (URI) source;
			
			if (uri.isPlatformResource()) {
				// we use this as a proxy for IResources
				this.uriResource = java.net.URI.create(((URI) source).toString());
			} else {
				this.uriEResource = uri;
			}
		}
	}

	public Object getSource() {
		if(this.uriSource != null) {
			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
			return resSet.getEObject(this.uriSource, true);
		} else if(this.uriResource != null) {

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();


			IPath path = new Path(this.uriResource.getPath());
			return root.getFile(path);
		} else if (this.uriEResource != null) {
			ResourceSet rset = ((ScopeEntry)this.getElement()).getModelSet();
			return rset.getResource(this.uriEResource, true);
		}

		return null;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + super.hashCode() + ") : source -> " + source; //$NON-NLS-1$ //$NON-NLS-2$
	}


}
