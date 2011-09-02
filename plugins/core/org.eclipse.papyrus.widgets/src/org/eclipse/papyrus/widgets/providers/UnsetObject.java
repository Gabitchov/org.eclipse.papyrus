package org.eclipse.papyrus.widgets.providers;

import org.eclipse.papyrus.widgets.messages.Messages;


public class UnsetObject {

	@Override
	public String toString() {
		return Messages.ReferenceDialog_Unset;
	}

	private UnsetObject() {

	}

	public static UnsetObject instance = new UnsetObject();
}
