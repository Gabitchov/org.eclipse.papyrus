package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ExecutionSpecification;

public abstract class AbstractExecutionSpecificationEditPart extends
		ShapeNodeEditPart {
	private List executionSpecificationEndParts;

	public AbstractExecutionSpecificationEditPart(View view) {
		super(view);
	}

	@Override
	public List getChildren() {
		if (executionSpecificationEndParts == null) {
			initExecutionSpecificationEndEditPart();
		}
		return executionSpecificationEndParts;
	}

	/**
	 * Adds the child's Figure to the {@link #getContentPane() contentPane}.
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#addChildVisual(EditPart,
	 *      int)
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		final IFigure f = this.getFigure();
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		if (childEditPart instanceof ExecutionSpecificationEndEditPart) {
			getContentPane().add(
					child,
					((ExecutionSpecificationEndEditPart) childEditPart)
							.getLocator(), index);
		} else
			getContentPane().add(child, index);
		// getContentPane().add(child, new FillParentLocator(), index);
	}

	@Override
	protected void reorderChild(EditPart child, int index) {
		if (!(child instanceof ExecutionSpecificationEndEditPart))
			super.reorderChild(child, index);
	}

	protected void initExecutionSpecificationEndEditPart() {
		executionSpecificationEndParts = new ArrayList();

		EObject element = this.resolveSemanticElement();
		if (!(element instanceof ExecutionSpecification))
			return;
		ExecutionSpecification execution = (ExecutionSpecification) element;
		final ExecutionSpecificationEndEditPart startPart = new ExecutionSpecificationEndEditPart(
				execution.getStart(), this, new RelativeLocator(getFigure(),
						PositionConstants.NORTH));
		executionSpecificationEndParts.add(startPart);

		final ExecutionSpecificationEndEditPart finishPart = new ExecutionSpecificationEndEditPart(
				execution.getFinish(), this, new RelativeLocator(getFigure(),
						PositionConstants.SOUTH));
		executionSpecificationEndParts.add(finishPart);

		Diagram diagram = ((View) this.getModel()).getDiagram();
		startPart.rebuildLinks(diagram);
		finishPart.rebuildLinks(diagram);
	}

	static class FillParentLocator implements Locator {
		public void relocate(IFigure target) {
			target.setBounds(target.getParent().getBounds());
		}
	}
}
