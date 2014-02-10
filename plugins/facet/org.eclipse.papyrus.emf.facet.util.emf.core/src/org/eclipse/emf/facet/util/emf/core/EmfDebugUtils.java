/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *    Grégoire Dupé (Mia-Software) - Bug 365843 - [Unit Test Failure][0.2/3.8][0.2/4.2] org.eclipse.emf.facet.widgets.nattable.tests.swtbot.Bug344925Test.testBug344925
 *    Grégoire Dupé (Mia-Software) - Bug 367700 - [Unit Test Failure][0.2/3.8] org.eclipse.emf.facet.widgets.table.tests.internal.v0_2.swtbot.NatTableUITests.testOpenLoadCustomizationDialog
 *    Grégoire Dupé (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.core;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.util.core.DebugUtils;
import org.eclipse.emf.facet.util.emf.core.exception.DebugRuntimeException;

/**
 * @since 0.2
 */
public final class EmfDebugUtils {

	private EmfDebugUtils() {
		// Must not be used
	}
	
	public static String debugCommand(final Command command) {
		return debugCommand(command, 1);
	}
	
	private static String debugCommand(final Command command, final int indent) {
		StringBuffer result = new StringBuffer();
		result.append('\n');
		for (int i = 0; i < indent; i++) {
			result.append("--"); //$NON-NLS-1$
		}
		result.append(command.getClass().getSimpleName());
		result.append(" \""); //$NON-NLS-1$
		result.append(command.getLabel());
		result.append("\" "); //$NON-NLS-1$
		result.append(" canExecute="); //$NON-NLS-1$
		result.append(command.canExecute());
		result.append(" ("); //$NON-NLS-1$
		result.append(command.getClass().getName());
		result.append(')');
		if (command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) command;
			for (Command subCommand : compoundCommand.getCommandList()) {
				result.append(debugCommand(subCommand, indent + 1));
			}
		}
		return result.toString();
	}
	
	/**
	 * This method can be used to easily dump a model into a file. This method has been written to be
	 * used by unit tests.
	 * 
	 * @param eObject
	 * @param fileExtension
	 * @return a string explaining where the file has been saved.
	 */
	public static String getStateDumpMessage(final EObject eObject, final String fileExtension) {
		final File file = new File(DebugUtils.getCallerLocation(1) + '.' + fileExtension);
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(EcoreUtil.copy(eObject));
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			throw new DebugRuntimeException(e);
		}
		return "A model containing the dumped EObject has been saved in " + file.getAbsolutePath(); //$NON-NLS-1$
	}

}
