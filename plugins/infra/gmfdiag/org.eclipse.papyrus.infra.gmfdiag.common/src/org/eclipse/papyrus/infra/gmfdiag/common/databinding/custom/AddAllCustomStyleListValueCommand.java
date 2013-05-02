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
package org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;


public class AddAllCustomStyleListValueCommand extends AbstractCustomStyleListValueCommand {

	protected int index = CommandParameter.NO_INDEX;

	protected Collection<?> values;

	protected Command command;

	public AddAllCustomStyleListValueCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature styleFeature, Collection<?> values, int index) {
		super(domain, view, styleName, styleClass, styleFeature);
		this.index = index;
		this.values = values;
	}

	public AddAllCustomStyleListValueCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature feature, Collection<?> values) {
		this(domain, view, styleName, styleClass, feature, values, CommandParameter.NO_INDEX);
	}

	@Override
	protected Command createCommand() {
		return AddCommand.create(domain, style, styleFeature, values, index);
	}
}
