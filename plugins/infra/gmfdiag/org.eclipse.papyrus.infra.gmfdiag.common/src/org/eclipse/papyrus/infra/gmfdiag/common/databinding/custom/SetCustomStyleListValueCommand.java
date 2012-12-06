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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;


public class SetCustomStyleListValueCommand extends AbstractCustomStyleListValueCommand {

	private int index;

	private Object value;

	public SetCustomStyleListValueCommand(EditingDomain domain, View view, String styleName, EClass eClass, EStructuralFeature feature, int index, Object value) {
		super(domain, view, styleName, eClass, feature);
		this.index = index;
		this.value = value;
	}

	@Override
	protected Command createCommand() {
		return SetCommand.create(domain, style, styleFeature, value, index);
	}

}
