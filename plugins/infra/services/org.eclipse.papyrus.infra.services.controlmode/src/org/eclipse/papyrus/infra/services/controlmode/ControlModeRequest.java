/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * Request used to control or uncontrol an element.
 * 
 * @author adaussy
 * 
 */
public class ControlModeRequest extends AbstractEditCommandRequest implements ControlModeRequestParameters {

	/**
	 * Object to control or uncontrol
	 */
	private EObject targetObject;

	/**
	 * New target {@link URI}.
	 * In the case of control command. This point to the new created resource.
	 * In the case of uncontrol command. This point to the container resource
	 */
	private URI newURI;

	/**
	 * Old source {@link URI}.
	 * In the case of control command. This point to the new created resource.
	 * In the case of uncontrol command. This point to the container resource
	 */
	private URI sourceURI;

	/**
	 * @return {@link ControlModeRequest#sourceURI}
	 */
	public URI getSourceURI() {
		return sourceURI;
	}

	/**
	 * True if the request aim to control an element
	 * False otherwise
	 */
	private boolean isControlRequest;


	/**
	 * Constructor used to create an Uncontrol request (No new {@link URI} specified)
	 * 
	 * @param editingDomain
	 *        Current {@link TransactionalEditingDomain}
	 * @param targetObject
	 *        {@link EObject} to control
	 */
	public ControlModeRequest(TransactionalEditingDomain editingDomain, EObject targetObject) {
		this(editingDomain, targetObject, getTargetURI(targetObject));
		this.isControlRequest = false;
	}

	private static URI getTargetURI(EObject targetObject) {
		EObject eContainer = targetObject.eContainer();
		if(eContainer != null) {
			return eContainer.eResource().getURI();
		}
		return null;
	}

	/**
	 * @return {@link ControlModeRequest#isControlRequest}
	 */
	public boolean isControlRequest() {
		return isControlRequest;
	}

	/**
	 * Set the {@link ControlModeRequest#isControlRequest}
	 * 
	 * @param isControlRequest
	 */
	public void setControlRequest(boolean isControlRequest) {
		this.isControlRequest = isControlRequest;
	}

	/**
	 * Constructor used to create an control request to the new URI
	 * 
	 * @param editingDomain
	 *        Current {@link TransactionalEditingDomain}
	 * @param targetObject
	 *        {@link EObject} to control
	 * @param newURI
	 *        {@link URI} targeting the new resource about to be created
	 */
	public ControlModeRequest(TransactionalEditingDomain editingDomain, EObject objectToControl, URI newURI) {
		super(editingDomain);
		Assert.isNotNull(objectToControl);
		this.targetObject = objectToControl;
		this.newURI = newURI;
		if(newURI != null) {
			setTargetResource(editingDomain.getResourceSet().getResource(newURI, false), newURI.fileExtension());
		}
		Resource r = objectToControl.eResource();
		Assert.isNotNull(r);
		this.sourceURI = r.getURI();
		this.isControlRequest = true;
	}

	public Object getEditHelperContext() {
		return targetObject;
	}

	/**
	 * @return {@link ControlModeRequest#targetObject}
	 */
	public EObject getTargetObject() {
		return targetObject;
	}

	/**
	 * @return {@link ControlModeRequest#newURI}
	 */
	public URI getNewURI() {
		return newURI;
	}


	/**
	 * See {@link ControlModeRequest#isUIAction()}
	 * 
	 * @param value
	 */
	public void setIsUIAction(boolean value) {
		setParameter(IS_UI_ACTION, value);
	}

	/**
	 * Indicate that this request as been launch by user.
	 * That's means that the manager can use User Interface (such as dialog) do display information to user
	 * 
	 * @param value
	 */
	public boolean isUIAction() {
		Object result = getParameter(IS_UI_ACTION);
		return (Boolean)(result == null ? false : result);
	}

	/**
	 * Register the target resource for a specific type (define by file extension)
	 * 
	 * @param resource
	 *        Target resource
	 * @param extension
	 *        Resource File Extension
	 */
	public void setTargetResource(Resource resource, String extension) {
		setParameter(getTargetResourceKey(extension), resource);
	}

	/**
	 * Get the target resource for this kind of file extension
	 * 
	 * @param extension
	 * @return
	 */
	public Resource getTargetResource(String extension) {
		Object result = getParameter(getTargetResourceKey(extension));
		return (Resource)(result == null ? null : result);
	}

	/**
	 * Get the source resource for this kind of file extension
	 * 
	 * @param extension
	 * @return
	 */
	public Resource getSourceResource(String extension) {
		Object result = getParameter(getSourceResourceKey(extension));
		return (Resource)(result == null ? null : result);
	}

	/**
	 * Register the source resource for a specific type (define by file extension)
	 * 
	 * @param resource
	 *        Target resource
	 * @param extension
	 *        Resource File Extension
	 */
	public void setSourceResource(Resource resource, String extension) {
		setParameter(getSourceResourceKey(extension), resource);
	}

	/**
	 * Get the key used to register this file extension into the parameters for target
	 * 
	 * @param extension
	 *        File extension
	 * @return
	 */
	protected String getTargetResourceKey(String extension) {
		return getResourceKey(TARGET_RESOURCE, extension);
	}

	/**
	 * Get the key used to register this file extension into the parameters for source
	 * 
	 * @param extension
	 *        File Extenion
	 * @return
	 */
	protected String getSourceResourceKey(String extension) {
		return getResourceKey(SOURCE_RESOURCE, extension);
	}

	protected String getResourceKey(String key, String extension) {
		return TARGET_RESOURCE + extension;
	}

	/**
	 * @return the current {@link ModelSet} in use
	 */
	public ModelSet getModelSet() {
		return (ModelSet)getEditingDomain().getResourceSet();
	}
	
	/**
	 * Create a request for creating a request for controlling a EObject. This request is aware that the action is User Interface action
	 * 
	 * @param editingDomain
	 * @param objectToControl
	 * @param newURI
	 * @return
	 */
	public static ControlModeRequest createUIControlModelRequest(TransactionalEditingDomain editingDomain, EObject objectToControl, URI newURI) {
		ControlModeRequest request = new ControlModeRequest(editingDomain, objectToControl, newURI);
		request.setIsUIAction(true);
		return request;
	}

	/**
	 * Create a request for creating a request for controling a EObject. This request is aware that the action is User Interface action
	 * 
	 * @param editingDomain
	 * @param objectToControl
	 * @return
	 */
	public static ControlModeRequest createUIUncontrolModelRequest(TransactionalEditingDomain editingDomain, EObject objectToControl) {
		ControlModeRequest request = new ControlModeRequest(editingDomain, objectToControl);
		request.setIsUIAction(true);
		return request;
	}
}
