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

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;

public class SemanticLabelDirectEditPolicy extends LabelDirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest edit) {
		Command applyChanges = super.getDirectEditCommand(edit);
		Command postRefresh = null;
		if (applyChanges != null && applyChanges.canExecute()) {
			postRefresh = new PostRefreshCommand();
		}
		return applyChanges.chain(postRefresh);
	}

	private class PostRefreshCommand extends Command {

		@Override
		public void execute() {
			getHost().refresh();
		}
	}
}
