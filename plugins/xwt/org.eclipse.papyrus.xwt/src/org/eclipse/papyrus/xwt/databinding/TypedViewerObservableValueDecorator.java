/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.databinding;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.internal.databinding.viewers.ViewerObservableValueDecorator;
import org.eclipse.jface.viewers.Viewer;

public class TypedViewerObservableValueDecorator extends ViewerObservableValueDecorator {

	protected Object elementType;

	public TypedViewerObservableValueDecorator(IObservableValue decorated, Viewer viewer) {
		super(decorated, viewer);
	}

	public Object getElementType() {
		return elementType;
	}

	public void setElementType(Object elementType) {
		this.elementType = elementType;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof TypedViewerObservableValueDecorator)) {
			return false;
		}
		TypedViewerObservableValueDecorator decorator = (TypedViewerObservableValueDecorator)obj;
		if(elementType != null) {
			if(!elementType.equals(decorator.elementType)) {
				return false;
			}
		} else if(decorator.elementType != null) {
			return false;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		if(elementType == null) {
			return super.hashCode();
		}
		return elementType.hashCode() * super.hashCode();
	}

	@Override
	public Object getValueType() {
		Object elementType = getElementType();
		if(elementType != null) {
			return elementType;
		}
		return super.getValueType();
	}
}
