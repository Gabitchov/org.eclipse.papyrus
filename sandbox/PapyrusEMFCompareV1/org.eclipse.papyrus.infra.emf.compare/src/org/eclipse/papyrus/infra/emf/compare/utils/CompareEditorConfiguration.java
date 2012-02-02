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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This class contains all the information and the methods to do UML file comparison with the Eclipse Viewer
 * 
 */
public class CompareEditorConfiguration {

	/**
	 * the left diResource
	 */
	private Resource leftDiResource;

	/**
	 * the right diResource
	 */
	private Resource rightDiResource;

	/**
	 * the editing domain for the merge
	 */
	private TransactionalEditingDomain domain;

	/**
	 * the right uml resource
	 */
	private Resource rightUMLResource;

	/**
	 * the left uml resource
	 */
	private Resource leftUMLResource;

	/**
	 * a boolean to know if we should use the edit service
	 */
	private boolean isEditServiceUsing = false;

	/** this boolean is used to know if the editing domain is provided by the editor or has been created by this class */
	private boolean provideTransactionalEditingDomain = false;//TODO pourrait être supprimer en regardant lors du dispose si l'éditeur est un domain provider!

	/**
	 * the list of the metamodels for the customization manager
	 */
	private Set<EPackage> metamodels;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editor
	 *        the compare editor
	 * @param leftUMLResource
	 *        the left UML Resource
	 * @param rightUMLResource
	 *        the right UMLResource
	 */
	public CompareEditorConfiguration(final IEditorPart editor, final Resource leftUMLResource, final Resource rightUMLResource) {
		this.leftUMLResource = leftUMLResource;
		this.rightUMLResource = rightUMLResource;
		if(editor instanceof IEditingDomainProvider) {
			//we assume it will be always the case...
			this.domain = (TransactionalEditingDomain)((IEditingDomainProvider)editor).getEditingDomain();
		}
		if(this.leftUMLResource == null) {
			return;
		}
		Assert.isNotNull(rightUMLResource);
		Assert.isNotNull(rightUMLResource);
		initialize();
	}

	/**
	 * initialize the field
	 */
	private void initialize() {
		initializeEditingDomain();
		initializeDiResource();
	}

	/**
	 * Returns <code>true</code> if we should use the edit service
	 * 
	 * @return
	 *         Getter for {@link #isEditServiceUsing}
	 */
	public boolean isEditServiceUsing() {
		return this.isEditServiceUsing;
	}

	/**
	 * Setter for {@link #isEditServiceUsing()}
	 * 
	 * @param use
	 *        <code>true</code> if we should use the edit service
	 */
	public void setUseEditService(final boolean use) {
		this.isEditServiceUsing = use;
	}

	/**
	 * Initialize the editing domain used for the action
	 */
	private void initializeEditingDomain() {
		if(this.domain == null) {
			this.domain = TransactionUtil.getEditingDomain(this.leftUMLResource);
			if(this.domain == null) {
				this.domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(this.leftUMLResource.getResourceSet());
				this.provideTransactionalEditingDomain = true;
			}
		}

	}

	/**
	 * initialize the di resource
	 */
	private void initializeDiResource() {
		URI uri;
		URI diURI;
		ResourceSet set;
		//the left : 
		uri = this.leftUMLResource.getURI();
		diURI = URI.createPlatformResourceURI(uri.toPlatformString(false).replace("uml", "di"), false);//TODO FIXME avoid to duplicate these string?
		set = this.leftUMLResource.getResourceSet();
		if(set.getURIConverter().exists(diURI, null)) {
			this.leftDiResource = set.getResource(diURI, true);
			try {
				this.leftDiResource.load(null);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//the right
		uri = this.rightUMLResource.getURI();
		diURI = URI.createPlatformResourceURI(uri.toPlatformString(false).replace("uml", "di"), false);//TODO FIXME avoid to duplicate these string?
		set = this.rightUMLResource.getResourceSet();
		if(set.getURIConverter().exists(diURI, null)) {
			this.rightDiResource = set.getResource(diURI, true);
			try {
				this.rightDiResource.load(null);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * save the di resource
	 */
	public void save() {
		final Map<?, ?> options = null;
		if(this.leftDiResource != null) {
			try {
				this.leftDiResource.save(options);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(this.rightDiResource != null) {
			try {
				this.rightDiResource.save(options);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Getter for {@link #domain}
	 * 
	 * @return
	 *         {@link #domain}
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return this.domain;
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if there is diResource associated to the UML Resource
	 */
	public boolean manageDiResource() {
		return this.leftDiResource != null || this.rightDiResource != null;
	}

	/**
	 * 
	 * @return
	 *         the list of the metamodel managed for the CustomizationManager
	 */
	public Set<EPackage> getMetamodels() {
		if(this.metamodels == null) {
			this.metamodels = new HashSet<EPackage>();
			if(this.leftUMLResource != null && this.rightUMLResource != null) {
				final List<EObject> contents = new ArrayList<EObject>(this.leftUMLResource.getContents());
				contents.addAll(this.rightUMLResource.getContents());
				for(final EObject current : contents) {
					this.metamodels.add(current.eClass().getEPackage());
				}
			}
		}
		return this.metamodels;
	}

	public void dispose() {
		//we detach the editingdomain of the resourceset
		if(this.provideTransactionalEditingDomain) {
			this.domain.dispose();
			//if not the editing domain comes from the editor, we doesn't manage it!
		}
		final Map<?, ?> options = null;
		if(this.leftDiResource != null) {
			this.leftDiResource.unload();
		}
		if(this.rightDiResource != null) {
			this.rightDiResource.unload();
		}
		this.metamodels.clear();
	}

}
