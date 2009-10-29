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
package org.eclipse.papyrus.diagram.common.parser.assist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class FixedSetCompletionProcessor extends EObjectCompletionProcessor {

	private final List<String> myProposals;

	public FixedSetCompletionProcessor(List<String> proposals) {
		myProposals = Collections.unmodifiableList(new ArrayList<String>(proposals));
	}

	// @unused
	public FixedSetCompletionProcessor(String... proposals) {
		this(Arrays.asList(proposals));
	}

	@Override
	protected Iterable<String> computeContextProposals(EObject context) {
		return myProposals;
	}

}
