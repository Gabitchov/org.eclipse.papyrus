package org.eclipse.papyrus.exteditor.cdt.listener;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.papyrus.exteditor.cdt.sync.SyncModelToCDT;
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
		if(eventType == OperationHistoryEvent.OPERATION_ADDED || eventType == OperationHistoryEvent.REDONE) {

			// regen ...
			for(Classifier cl : ModelListener.regenList) {
				System.err.println("regenerate: " + cl.getQualifiedName());
				SyncModelToCDT.syncModelToCDT(cl);
			}
			ModelListener.regenList.clear();

		} else if(eventType == OperationHistoryEvent.UNDONE) {
			// regen ...
			for(Classifier cl : ModelListener.regenList) {
				System.err.println("regenerate (undone?): " + cl.getQualifiedName());
				SyncModelToCDT.syncModelToCDT(cl);
			}
			ModelListener.regenList.clear();
		}
	}
}
