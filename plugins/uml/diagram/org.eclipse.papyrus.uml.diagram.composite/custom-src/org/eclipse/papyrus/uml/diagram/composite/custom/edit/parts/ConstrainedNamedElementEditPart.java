package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.dragtracker.NoScrollDragEditPartsTrackerEx;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;


public abstract class ConstrainedNamedElementEditPart extends NamedElementEditPart {

	public ConstrainedNamedElementEditPart(View view) {
		super(view);
	}
	/**
	 * the drag tracker has been specialized in order to constraint mvt inside its container without 
	 * scroll bar
	 * {@inheritDoc}
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		return new NoScrollDragEditPartsTrackerEx(this);
	}
}
