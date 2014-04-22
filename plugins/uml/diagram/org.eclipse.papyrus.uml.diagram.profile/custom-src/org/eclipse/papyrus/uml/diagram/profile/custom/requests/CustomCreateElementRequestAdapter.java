/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.requests;

import java.util.ArrayList;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public class CustomCreateElementRequestAdapter extends org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter {
	/**
	 * The request to create a new element.
	 */
	private final CreateElementRequest createElementRequest;
	private ArrayList<CreateElementRequestAdapter> listRequestAdapter;

	/**
	 * Constructs a new adapter.
	 * 
	 * @param createElementRequest
	 *            the request to create a new element.
	 */
	public CustomCreateElementRequestAdapter(CreateElementRequest createElementRequest) {
		super(createElementRequest);
		this.createElementRequest = createElementRequest;
		listRequestAdapter = new ArrayList<CreateElementRequestAdapter>();
		listRequestAdapter.add(new CreateElementRequestAdapter(createElementRequest));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(java.lang.Class<?> adapter, int i) {
		if (adapter.isInstance(listRequestAdapter.get(i).getAdapter(CreateElementRequest.class))) {
			return listRequestAdapter.get(i).getAdapter(CreateElementRequest.class);
		}
		if (adapter.isInstance(getNewElement(i))) {
			return getNewElement(i);
		}
		if (adapter.isInstance(getElementType(i))) {
			return getElementType(i);
		}
		// Is this correct?
		if (adapter.isInstance(this)) {
			return this;
		}
		return Platform.getAdapterManager().getAdapter(listRequestAdapter.get(i).getAdapter(CreateElementRequest.class), adapter);
	}

	/**
	 * Gets the new element that has been created in response to this request.
	 * 
	 * @return the new element
	 */
	private EObject getNewElement(int i) {
		return ((CreateElementRequest) listRequestAdapter.get(i).getAdapter(CreateElementRequest.class)).getNewElement();
	}

	public CreateElementRequest getRequest(int i) {
		return ((CreateElementRequest) listRequestAdapter.get(i).getAdapter(CreateElementRequest.class));
	}

	/**
	 * Gets the element type for the new element.
	 * 
	 * @return the element type
	 */
	private IElementType getElementType(int i) {
		return ((CreateElementRequest) listRequestAdapter.get(i).getAdapter(CreateElementRequest.class)).getElementType();
	}

	/**
	 * Sets the new element that has been created in response to this request.
	 * 
	 * @param newElement
	 *            the new element
	 */
	@Override
	public void setNewElement(EObject newElement) {
		if (listRequestAdapter.size() == 1 && ((CreateElementRequest) listRequestAdapter.get(0).getAdapter(CreateElementRequest.class)).getNewElement() == null) {
			// the request exists yet!!!
			listRequestAdapter.get(0).setNewElement(newElement);
		} else {
			CreateElementRequest req = new CreateElementRequest(createElementRequest.getEditingDomain(), createElementRequest.getContainer(), createElementRequest.getElementType(), createElementRequest.getContainmentFeature());
			req.setNewElement(newElement);
			listRequestAdapter.add(new CreateElementRequestAdapter(req));
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.core.internal.util.IProxyEObject#getProxyClassID()
	 */
	public Object getProxyClassID(int i) {
		return getNewElement(i) == null ? null : PackageUtil.getID(EMFCoreUtil.getProxyClass(getNewElement(i)));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.core.internal.util.IProxyEObject#resolve()
	 */
	public EObject resolve(int i) {
		return getNewElement(i) == null ? null : EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(((CreateElementRequest) listRequestAdapter.get(i).getAdapter(CreateElementRequest.class)).getContainer()), getNewElement(i));
	}

	/**
	 * 
	 * @param i
	 * @return the request adapter or null
	 */
	public CreateElementRequestAdapter getRequestAdapterDUMMY(int index) {
		CreateElementRequestAdapter reqAdapter = null;
		try {
			reqAdapter = listRequestAdapter.get(index);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw (e);
		}
		return reqAdapter;
	}

	/**
	 * 
	 * @return the list of the requestAdapter
	 */
	public ArrayList<CreateElementRequestAdapter> getRequestAdapters() {
		return listRequestAdapter;
	}
}
