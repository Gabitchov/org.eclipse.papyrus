/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration;

import java.util.Collection;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * Represents a surrogate property descriptor delegating to an encapsulated descriptor
 * @author Laurent Wouters
 */
public abstract class SurrogateItemPropertyDescriptor implements IItemPropertyDescriptor {
	private IItemPropertyDescriptor inner;
	
	public SurrogateItemPropertyDescriptor(IItemPropertyDescriptor inner) {
		this.inner = inner;
	}
	
	public Object getPropertyValue(Object object) { return inner.getPropertyValue(object); }

	public boolean isPropertySet(Object object) { return inner.isPropertySet(object); }

	public boolean canSetProperty(Object object) { return inner.canSetProperty(object); }

	public void resetPropertyValue(Object object) { inner.resetPropertyValue(object); }

	public void setPropertyValue(Object object, Object value) { inner.setPropertyValue(object, value); }

	public String getCategory(Object object) { return inner.getCategory(object); }

	public String getDescription(Object object) { return inner.getDescription(object); }

	public String getDisplayName(Object object) { return inner.getDisplayName(object); }

	public String[] getFilterFlags(Object object) { return inner.getFilterFlags(object); }

	public Object getHelpContextIds(Object object) { return inner.getHelpContextIds(object); }

	public String getId(Object object) { return inner.getId(object); }

	public IItemLabelProvider getLabelProvider(Object object) { return inner.getLabelProvider(object); }

	public boolean isCompatibleWith(Object object, Object anotherObject, IItemPropertyDescriptor anotherPropertyDescriptor) {
		return inner.isCompatibleWith(object, anotherObject, anotherPropertyDescriptor);
	}

	public Object getFeature(Object object) { return inner.getFeature(object); }

	public boolean isMany(Object object) { return inner.isMany(object); }

	public abstract Collection<?> getChoiceOfValues(Object object);

	public boolean isMultiLine(Object object) { return inner.isMultiLine(object); }

	public boolean isSortChoices(Object object) { return inner.isSortChoices(object); }
}
