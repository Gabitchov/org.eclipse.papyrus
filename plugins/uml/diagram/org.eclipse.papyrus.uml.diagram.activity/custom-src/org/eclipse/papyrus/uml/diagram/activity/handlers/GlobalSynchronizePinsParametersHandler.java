/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : [Activitydiagram] Papyrus should provide a way to manually resynchronize pins and parameters on Call Actions
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.modelsetquery.ModelSetQuery;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.IContext;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Handler to synchronize all call Action of the model
 * 
 * @author adaussy
 * 
 */
public class GlobalSynchronizePinsParametersHandler extends AbstractSynchronizePinsAndParameters {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if(selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			Object obj = structuredSelection.getFirstElement();
			EObject element = null;
			if(obj instanceof IAdaptable) {
				element = (EObject)((IAdaptable)obj).getAdapter(EObject.class);
				if(element instanceof View) {
					element = ((View)element).getElement();
				}
				if(element instanceof Package) {
					Package pack = (Package)element;
					final Collection<EObject> objectsOfType = ModelSetQuery.getObjectsOfType(pack, UMLPackage.Literals.INVOCATION_ACTION);
					new NotificationBuilder().setAsynchronous(false).setType(Type.WARNING).setHTML(true).setMessage(getCallActionToSync(objectsOfType)).addAction(new NotificationRunnable() {

						public void run(IContext context) {
							for(EObject ca : objectsOfType) {
								if(ca instanceof InvocationAction) {
									EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(ca);
									if(!editingDomain.isReadOnly(ca.eResource())) {
										SynchronizePinsParametersHandler.syncInvocationAction((InvocationAction)ca);
									}
								}
							}
						}

						public String getLabel() {
							return "Synchronize";
						}
					}).addAction(new NotificationRunnable() {

						public void run(IContext context) {
							// Do Nothing
						}

						public String getLabel() {
							return "Cancel";
						}
					}).run();
				}
			}
		}
		return null;
	}

	protected String getCallActionToSync(Collection<EObject> objectsOfType) {
		StringBuilder builder = new StringBuilder("<form><p>The following Call Actions will be synchronized : </p>");////$NON-NLS-1$
		List<EObject> readOnlyresource = new ArrayList<EObject>();
		for(EObject e : objectsOfType) {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(e);
			boolean isReadOnly = editingDomain.isReadOnly(e.eResource());
			if(!isReadOnly) {
				if(e instanceof NamedElement) {
					builder.append("<li>");
					builder.append(((NamedElement)e).getQualifiedName());
					builder.append("</li>");
				}
			} else {
				readOnlyresource.add(e);
			}
		}
		if(!readOnlyresource.isEmpty()) {
			builder.append("<p> </p><p>The following Call Actions will not be synchronized because the are is read only mode :</p>");
			for(EObject e : readOnlyresource) {
				if(e instanceof NamedElement) {
					builder.append("<li>").append(((NamedElement)e).getQualifiedName()).append("</li>");
				}
			}
		}
		builder.append("</form>");
		return builder.toString();
	}
}
