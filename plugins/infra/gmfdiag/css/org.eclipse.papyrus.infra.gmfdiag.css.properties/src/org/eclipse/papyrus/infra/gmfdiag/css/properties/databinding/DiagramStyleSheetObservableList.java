/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomEObjectStyleObservableList;

/**
 * An ObservableList for manipulating CSS StyleSheets in a Diagram. The styleSheets
 * are stored in the view's Resource, and added as a CustomStyle (GMF NamedStyle)
 * in the view. When the last reference to a CSS Stylesheet is removed, it is
 * removed from the view's resource.
 * 
 * A Stylesheet will only be deleted if it is contained in the same resource as
 * the argument View (A Model B referencing a StyleSheet from a Model A cannot
 * delete it).
 * 
 * 
 * @author Camille Letavernier
 */
public class DiagramStyleSheetObservableList extends CustomEObjectStyleObservableList {

	public DiagramStyleSheetObservableList(View view, EditingDomain domain, String styleName) {
		super(view, domain, styleName);
	}

	@Override
	public Command getAddCommand(int index, Object value) {
		return new AddCSSStyleSheetCommand(domain, view, styleName, eClass, feature, value, index);
	}

	@Override
	public Command getAddCommand(Object value) {
		return new AddCSSStyleSheetCommand(domain, view, styleName, eClass, feature, value);
	}

	@Override
	public Command getAddAllCommand(Collection<?> values) {
		return new AddAllCSSStyleSheetCommand(domain, view, styleName, eClass, feature, values);
	}

	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		return new AddAllCSSStyleSheetCommand(domain, view, styleName, eClass, feature, values, index);
	}

	@Override
	public Command getRemoveCommand(Object value) {
		return new RemoveCSSStyleSheetCommand(domain, view, styleName, eClass, feature, value);
	}

	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		return new RemoveAllCSSStyleSheetValueCommand(domain, view, styleName, eClass, feature, values);
	}

	@Override
	public Command getSetCommand(int index, Object value) {
		return new SetCSSStyleSheetCommand(domain, view, styleName, eClass, feature, index, value);
	}

}
