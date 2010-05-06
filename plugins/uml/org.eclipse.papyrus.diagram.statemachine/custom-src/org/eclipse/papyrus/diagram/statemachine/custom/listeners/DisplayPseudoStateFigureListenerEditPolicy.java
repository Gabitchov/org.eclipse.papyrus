package org.eclipse.papyrus.diagram.statemachine.custom.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;

public class DisplayPseudoStateFigureListenerEditPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener{

	@Override
	public void notifyChanged(Notification notification) {
		int i = 0;
	}

}
