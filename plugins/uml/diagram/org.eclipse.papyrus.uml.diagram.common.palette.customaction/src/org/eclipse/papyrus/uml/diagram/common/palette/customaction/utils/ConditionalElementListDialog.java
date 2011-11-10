/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.utils;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.papyrus.infra.core.modelsetquery.ModelSetQuery;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * ConditionalElementListDialog is widget displaying elements to choose
 * @author tfaure
 *
 * @param <T>
 */
public class ConditionalElementListDialog<T extends EObject> extends ElementListSelectionDialog {

	@SuppressWarnings("unchecked")
	public ConditionalElementListDialog(Shell parent, Predicate<T> condition,EObject anEobject, EClass eclassAccepted) {
		this (parent,condition,(Collection<T>) ModelSetQuery.getObjectsOfType(anEobject, eclassAccepted));
	}
	
	public ConditionalElementListDialog(Shell parent, Predicate<T> condition, Collection<T> elements) {
		super(parent, new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		setMultipleSelection(false);
		List<T> result = Lists.newArrayList(Iterables.filter(elements, condition));
		setTitle("Choose Elements");
		setElements(result.toArray());
	}
	
	public static interface ICondition<T>
	{
		boolean isValid (T eobject) ;
	}
	
	@SuppressWarnings("unchecked")
	public T getFirstResult ()
	{
		if (getResult().length > 0)
		{
			return (T) getResult()[0];
		}
		return null ;
	}
	

}
