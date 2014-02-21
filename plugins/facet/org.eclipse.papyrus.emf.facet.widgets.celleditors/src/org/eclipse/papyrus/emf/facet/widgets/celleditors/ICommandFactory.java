/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Creates {@link Command}s for a specific {@link EditingDomain}.
 * <p>
 * See also {@link ICommandFactoriesRegistry}
 */
public interface ICommandFactory extends
		org.eclipse.emf.facet.util.emf.core.internal.exported.ICommandFactory {

	// The content of this interface ha been moved to
	// org.eclipse.emf.facet.util.emf.core.internal.exported.ICommandFactory to
	// solve a cyclic
	// dependency issue (with the plug-in org.eclipse.emf.facet.custom.ui)
}
