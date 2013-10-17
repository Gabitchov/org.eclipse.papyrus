/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.texteditor.cdt.listener;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.texteditor.cdt.sync.SyncModelToCDT;
import org.eclipse.uml2.uml.Classifier;


public class OperationHistoryListener implements IOperationHistoryListener {

	public static void init() {
		if(ohl == null) {
			ohl = new OperationHistoryListener();
			OperationHistoryFactory.getOperationHistory().addOperationHistoryListener(ohl);
		}
	}

	private static OperationHistoryListener ohl = null;

	public void historyNotification(OperationHistoryEvent event) {
		int eventType = event.getEventType();
		if(eventType == OperationHistoryEvent.OPERATION_ADDED ||
			eventType == OperationHistoryEvent.REDONE ||
			eventType == OperationHistoryEvent.UNDONE) {

			EList<Classifier> regenListCopy = new BasicEList<Classifier>(ModelListener.regenList);
			ModelListener.regenList.clear();
			// regen ...
			for(Classifier cl : regenListCopy) {
				// System.err.println("regenerate: " + cl.getQualifiedName());
				SyncModelToCDT.syncModelToCDT(cl);
			}
		}
	}
}
