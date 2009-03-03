package org.eclipse.papyrus.diagram.clazz.custom;

import org.eclipse.gmf.runtime.diagram.ui.internal.tools.RubberbandDragTracker;

public class PapyrusRubberbandDragTracker extends RubberbandDragTracker {

	protected boolean handleButtonDown(int button) {
		System.err.println("PapyrusRubberbandDragTracker click detected " + button);
		return super.handleButtonDown(button);
	}
}
