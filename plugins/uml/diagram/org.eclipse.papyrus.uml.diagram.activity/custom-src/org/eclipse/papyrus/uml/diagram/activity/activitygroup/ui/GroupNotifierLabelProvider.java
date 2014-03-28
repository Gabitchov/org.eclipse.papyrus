/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *   Christian W. Damus (CEA) - bug 410346
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.ui;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;
import org.eclipse.swt.graphics.Image;

/**
 * {@link LabelProvider} for {@link IGroupNotifier}
 */
public class GroupNotifierLabelProvider extends LabelProvider {

	private ComposedAdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	private AdapterFactoryLabelProvider delegate = new AdapterFactoryLabelProvider(factory);

	@Override
	public String getText(Object element) {
		if(element instanceof IGroupNotifier) {
			IGroupNotifier notifier = (IGroupNotifier)element;
			return delegate.getText(notifier.getEObject());
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof IGroupNotifier) {
			IGroupNotifier notifier = (IGroupNotifier)element;
			return delegate.getImage(notifier.getEObject());
		}
		return super.getImage(element);
	}
	
	@Override
	public void dispose() {
		delegate.dispose();
		factory.dispose();
		
		super.dispose();
	}
}
