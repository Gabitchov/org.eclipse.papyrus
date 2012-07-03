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
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
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

	static AdapterFactoryLabelProvider factory = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	@Override
	public String getText(Object element) {
		if(element instanceof IGroupNotifier) {
			IGroupNotifier notifier = (IGroupNotifier)element;
			return factory.getText(notifier.getEObject());
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof IGroupNotifier) {
			IGroupNotifier notifier = (IGroupNotifier)element;
			return factory.getImage(notifier.getEObject());
		}
		return super.getImage(element);
	}
}
