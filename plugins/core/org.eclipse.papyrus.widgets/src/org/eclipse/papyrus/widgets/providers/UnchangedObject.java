package org.eclipse.papyrus.widgets.providers;

import org.eclipse.papyrus.widgets.messages.Messages;


public class UnchangedObject {

	private UnchangedObject() {

	}

	@Override
	public String toString() {
		return Messages.ReferenceDialogObservable_Unchanged;
	}

	public static UnchangedObject instance = new UnchangedObject();
}
