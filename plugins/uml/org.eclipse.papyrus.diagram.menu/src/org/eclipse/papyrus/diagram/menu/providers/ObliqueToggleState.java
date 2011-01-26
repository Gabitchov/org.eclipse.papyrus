package org.eclipse.papyrus.diagram.menu.providers;

import org.eclipse.papyrus.diagram.menu.actions.LineStyleAction;
import org.eclipse.ui.ISelectionListener;


public class ObliqueToggleState extends AbstractLineStyleToggleState implements ISelectionListener {

	public ObliqueToggleState() {
		super(LineStyleAction.OBLIQUE);
	}
}
