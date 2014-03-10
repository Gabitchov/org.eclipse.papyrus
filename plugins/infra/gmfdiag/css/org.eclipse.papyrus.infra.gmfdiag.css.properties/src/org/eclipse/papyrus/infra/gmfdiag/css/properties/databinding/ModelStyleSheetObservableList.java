/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël Adam (ALL4TEC) mia@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomEObjectStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StyleSheetReferenceImpl;

public class ModelStyleSheetObservableList extends CustomEObjectStyleObservableList {

	public ModelStyleSheetObservableList(View view, EditingDomain domain,String styleName) {
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
		return new AddAllModelStyleSheetCommand(domain, view, styleName, eClass, feature, values);
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
