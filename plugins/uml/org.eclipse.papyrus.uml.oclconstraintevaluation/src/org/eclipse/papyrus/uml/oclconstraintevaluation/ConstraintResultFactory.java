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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.oclconstraintevaluation;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;

/**
 * the factory in charge to create the console to compute OCL constraint.
 * This class is mandatory to use the extension point org.eclipse.ui.console.consoleFactories 
 * 
 *
 */
public class ConstraintResultFactory implements IConsoleFactory {

	public void openConsole() {
		org.eclipse.ui.console.IConsole  console=ConstraintConsoleResult.getInstance();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
			new IConsole[] {console});

		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
	}
}