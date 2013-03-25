/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.manager.cell;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.papyrus.infra.nattable.manager.ICellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

//FIXME : move this class to remove UML dependency
public class StereotypePropertyCellManager implements ICellManager {

	//FIXME : remove me!
	public static final String STEREOTYPE_PREFIX = "property_of_stereotype:/";

	public boolean handles(final Object obj1, final Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	public Object getValue(final Object obj1, final Object obj2) {
		final List<Object> elements = organizeObject(obj1, obj2);
		final Object el = elements.get(0);
		if(el instanceof Element) {
			String propertyQualifiedName = (String)elements.get(1);
			propertyQualifiedName = propertyQualifiedName.substring(Constants.PROPERTY_OF_STEREOTYPE_PREFIX.length(), propertyQualifiedName.length());
			final String stereotypeQN = NamedElementUtil.getParentQualifiedName(propertyQualifiedName);
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQualifiedName);
			final Stereotype ste = ((Element)el).getAppliedStereotype(stereotypeQN);

			//FIXME : case where the property comes from a super class not managed
			//FIXME : case a stereotype and a super stereotype with the same property is applied not managed
			if(ste != null) {
				return ((Element)el).getValue(ste, propertyName);
			}

		}
		return NOT_AVALAIBLE;
	}

	/**
	 *
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	protected List<Object> organizeObject(final Object obj1, final Object obj2) {
		final List<Object> objects = new ArrayList<Object>();
		if(obj1 instanceof String && ((String)obj1).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX)) {
			objects.add(obj2);
			objects.add(obj1);
		} else if(obj2 instanceof String && ((String)obj2).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX)) {
			objects.add(obj1);
			objects.add(obj2);
		}
		return objects;
	}

	public void setValue(EditingDomain domain, Object rowElement, Object lineElement, Object newValue) {
		// TODO Auto-generated method stub

	}

	public boolean isCellEditable(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		return true;
	}

	public Command getSetValueCommand(EditingDomain domain, Object rowElement, Object lineElement, Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICellEditor getCellEditor(Table table, Object obj1) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean handlersAxisElement(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
