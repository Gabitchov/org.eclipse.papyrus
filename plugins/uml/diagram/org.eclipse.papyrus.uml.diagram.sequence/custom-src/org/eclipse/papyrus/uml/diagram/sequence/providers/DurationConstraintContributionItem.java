package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomCommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDurationConstraintEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.uml2.uml.DurationConstraint;

//org.eclipse.papyrus.extensionpoints.editors.ui.DirectEditorsContributionItem
public class DurationConstraintContributionItem extends ContributionItem implements IWorkbenchContribution {

	/**
	 * Service locator given to this contribution item using the {@link IWorkbenchContribution} interface.
	 */
	private IServiceLocator serviceLocator;

	private MenuItem subMenuItem;

	/**
	 * 
	 */
	public DurationConstraintContributionItem() {
		setId("org.eclipse.papyrus.sequence.duraitonconstraint.menuitem");
	}

	/**
	 * @param id
	 */
	public DurationConstraintContributionItem(String id) {
		super(id);
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void dispose() {
		if(subMenuItem != null && !subMenuItem.isDisposed()) {
			subMenuItem.dispose();
		}
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void fill(Composite parent) {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void fill(Menu menu, int index) {
		// retrieves current selection
		final Object selectedElement = getSelectedElement();

		// first case: this class was not able to retrieve the selection service
		// or does not understand the current selection.
		// does not build any sub-menu and returns.
		if(selectedElement == null) {
			return;
		}

		// get the uml object type of this element, using the business resolver
		final Object businessObject = EMFHelper.getEObject(selectedElement);
		// no object found: exit
		if(businessObject == null || !(businessObject instanceof DurationConstraint)) {
			return;
		}

		createSubMenu(menu, index, (DurationConstraint)businessObject);
	}

	protected void createSubMenu(Menu menu, int index, DurationConstraint businessObject) {
		subMenuItem = new MenuItem(menu, SWT.PUSH);// SWT.CASCADE);
		subMenuItem.setText("Rotate Duration Constraint");

		subMenuItem.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {

			}

			public void widgetSelected(SelectionEvent e) {
				doRotate();
			}
		});
	}

	/**
	 * Retrieves and return the current selected element
	 * 
	 * @return the current selected element
	 */
	protected Object getSelectedElement() {
		ISelection selection = getSelection();
		// this checks if it is the good instance AND if it is not null
		if(selection instanceof IStructuredSelection) {
			return ((IStructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	/**
	 * Retrieves and return the current selection
	 * 
	 * @return the current selection
	 */
	protected ISelection getSelection() {
		ISelectionService selectionService = getSelectionService();
		if(selectionService != null) {
			return selectionService.getSelection();
		}
		return null;
	}

	/**
	 * Returns the selection service for the current workbench
	 * 
	 * @return the selection service for the current workbench or <code>null</code> if no selection
	 *         service was found.
	 */
	protected ISelectionService getSelectionService() {
		ISelectionService selectionService = (ISelectionService)serviceLocator.getService(ISelectionService.class);
		return selectionService;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void fill(ToolBar parent, int index) {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 * 
	 * @since 3.0
	 */
	@Override
	public void fill(CoolBar parent, int index) {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 * 
	 * @since 3.0
	 */
	@Override
	public void saveWidgetState() {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isDirty() {
		// @issue should this be false instead of calling isDynamic()?
		return true;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>true</code>. Subclasses may override.
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isDynamic() {
		return true;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isGroupMarker() {
		return false;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isSeparator() {
		return false;
	}

	/**
	 * Returns a string representation of this contribution item suitable only for debugging.
	 */
	@Override
	public String toString() {
		return getClass().getName() + "(id=" + getId() + ")";//$NON-NLS-2$//$NON-NLS-1$
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void update() {
	}

	/**
	 * The <code>ContributionItem</code> implementation of this method declared on <code>IContributionItem</code> does nothing. Subclasses should
	 * override to update their
	 * state.
	 */
	@Override
	public void update(String id) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(IServiceLocator serviceLocator) {
		assert (serviceLocator != null);
		this.serviceLocator = serviceLocator;
	}

	private void doRotate() {
		Object element = getSelectedElement();
		if(!(element instanceof CustomDurationConstraintEditPart))
			return;

		CustomDurationConstraintEditPart durationPart = (CustomDurationConstraintEditPart)element;
		boolean isVertical = durationPart.isArrowVertical();

		CompositeCommand compositeCmd = new CompositeCommand("rotate");
		Command rotateCmd = new CustomDurationConstraintEditPart.RotateArrowCommand(durationPart.getEditingDomain(), durationPart);
		compositeCmd.add(new EMFtoGMFCommandWrapper(rotateCmd));

		// set bounds command
		ICommand boundsCommand = new SetBoundsCommand(durationPart.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(durationPart.getNotationView()), getNewBounds(durationPart.getBounds()));
		compositeCmd.add(boundsCommand);

		// update anchor
		List list = durationPart.getSourceConnections();
		for(Object o : list)
			if(o instanceof CustomCommentAnnotatedElementEditPart) {
				CustomCommentAnnotatedElementEditPart connectionPart = (CustomCommentAnnotatedElementEditPart)o;
				String terminal = AnchorHelper.getAnchorId(connectionPart.getEditingDomain(), connectionPart, true);
				if(terminal.length() > 0) {
					PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
					SetConnectionAnchorsCommand rotateAnchorsCommand = new SetConnectionAnchorsCommand(connectionPart.getEditingDomain(), "Rotate Duration Anchors");
					rotateAnchorsCommand.setEdgeAdaptor(new EObjectAdapter(connectionPart.getNotationView()));
					if(isVertical) {
						if(pt.y < 0.3)
							rotateAnchorsCommand.setNewSourceTerminal("(0,0.5){L}");
						else if(pt.y > 0.7)
							rotateAnchorsCommand.setNewSourceTerminal("(1,0.5){R}");
					} else {
						if(pt.x < 0.3)
							rotateAnchorsCommand.setNewSourceTerminal("(0.5,0){T}");
						else if(pt.x > 0.7)
							rotateAnchorsCommand.setNewSourceTerminal("(0.5,1){D}");
					}
					compositeCmd.add(rotateAnchorsCommand);
				}
			}
		// execute command
		durationPart.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(compositeCmd));
	}

	private Rectangle getNewBounds(Rectangle bounds) {
		Point p = bounds.getCenter();
		return new Rectangle(p.x - bounds.height / 2, p.y - bounds.width / 2, bounds.height, bounds.width);
	}

}
