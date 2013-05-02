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

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;


public abstract class AbstractCustomStyleListValueCommand extends AbstractCommand {

	protected View view;

	protected EClass styleClass;

	protected String styleName;

	protected boolean needsCreate;

	protected EStructuralFeature styleFeature;

	protected EditingDomain domain;

	protected Command command;

	protected NamedStyle style;

	public AbstractCustomStyleListValueCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature styleFeature) {
		this.view = view;
		this.styleName = styleName;
		this.styleClass = styleClass;
		this.styleFeature = styleFeature;
		this.domain = domain;
	}

	public void execute() {
		//FIXME: Related to CompoundCommand vs StrictCompoundCommand.
		//Sometimes, canExecute() is not called, and the command is not prepared
		if(!isPrepared) {
			prepare();
			isPrepared = true;
		}

		if(needsCreate) {
			view.getStyles().add(style);
		}
		command.execute();
	}

	public void redo() {
		execute();
	}

	@Override
	public boolean prepare() {
		style = view.getNamedStyle(styleClass, styleName);

		if(needsCreate = (style == null)) {
			style = (NamedStyle)NotationFactory.eINSTANCE.create(styleClass);
			style.setName(styleName);
		}

		command = createCommand();

		//		return true;
		return command.canExecute();
	}

	protected abstract Command createCommand();

	@Override
	public void undo() {
		EList currentList = (EList)(style.eGet(styleFeature));
		command.undo();
		if(needsCreate) {
			view.getStyles().remove(style);
		}
	}

}
