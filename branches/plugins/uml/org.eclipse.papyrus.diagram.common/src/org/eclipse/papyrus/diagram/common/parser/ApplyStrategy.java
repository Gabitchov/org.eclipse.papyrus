/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;

public interface ApplyStrategy {

	public List/* 1.5 <ICommand> */apply(EObject modelObject, EObject parsedObject);

	public static final List/* 1.5 <ICommand> */NOT_EXECUTABLE = Collections.singletonList(UnexecutableCommand.INSTANCE);
}
