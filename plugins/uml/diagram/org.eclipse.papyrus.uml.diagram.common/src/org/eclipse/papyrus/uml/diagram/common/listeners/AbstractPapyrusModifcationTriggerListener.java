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
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366026 - [ActivityDiagram] Refactoring in order to try respect Generation Gap Pattern 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.listeners;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
/**
 * Abstract method used to trigger model modification by listenning the ressource set
 * @author adaussy
 *
 */
public abstract class AbstractPapyrusModifcationTriggerListener extends TriggerListener {
	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		if(notification != null) {
			ICommand cc = getModificationCommand(notification);
			if(cc != null) {
				return new GMFtoEMFCommandWrapper(cc);
			}
		}
		return null;
	}

	@Override
	public abstract NotificationFilter getFilter();

	/**
	 * Command which will react to the trigger
	 * @param notif
	 * @return
	 */
	protected abstract ICommand getModificationCommand(Notification notif);

	/**
	 * Return the main edipart which correspond to the {@link EObject} passed in argument
	 * 
	 * @param eObject
	 * @param rootEditPart
	 *        {@link IGraphicalEditPart} root from which the search will start
	 * @return
	 */
	protected IGraphicalEditPart getChildByEObject(final EObject eObject, IGraphicalEditPart rootEditPart, boolean isEdge) {
		return DiagramEditPartsUtil.getChildByEObject(eObject, rootEditPart, isEdge);
	}


	/**
	 * Get the referencing views
	 * @param oldEObject
	 * @param predicates Additionnal predecate use to speciy search
	 * @return
	 */
	protected Iterable<View> getReferencingView(EObject oldEObject, Predicate<? super View>... predicates) {
		ECrossReferenceAdapter eCrossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(oldEObject);
		Collection<Setting> settings = eCrossReferencer.getInverseReferences(oldEObject,false);
		Predicate<Setting> predicate = new Predicate<Setting>() {
	
			public boolean apply(Setting input) {
				EObject from = input.getEObject();
				/*
				 * Is a view
				 */
				if (from instanceof View &&NotationPackage.Literals.VIEW__ELEMENT.equals(input.getEStructuralFeature())){
					return true;
				}
				return false;
			}
		};

		Iterable<Setting> referencingView = Iterables.filter(settings, predicate);
		Iterable<View> views = Iterables.transform(referencingView, new Function<Setting, View>() {
	
			public View apply(Setting from) {
				return (View)from.getEObject();
			}
		});
		
		return Iterables.filter(views, Predicates.and(predicates));
	}
	
	/**
	 * Get the transactionnal editing domain from EObject
	 * @param o
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain(Object o){
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(o);
		if (editingDomain instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain transEditingDomain = (TransactionalEditingDomain) editingDomain;
			return transEditingDomain;
		}
		throw new RuntimeException("Enable to retreive editing domin from object");
	}
}
