package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableOvalAnchor;
import org.eclipse.gmf.runtime.gef.ui.internal.figures.CircleFigure;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.uml.diagram.sequence.command.ExecutionOccurrenceSpecificationMessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.ExecutionOccurrenceSpecificationMessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ExecutionSpecificationEndGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.HighlightEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class ExecutionSpecificationEndEditPart extends GraphicalEditPart implements INodeEditPart {

	public static final int VISUAL_ID = 999998;

	private static final int DEFAULT_SIZE = 16;

	private Locator locator;

	private OccurrenceSpecification executionSpecificationEnd;

	public ExecutionSpecificationEndEditPart(OccurrenceSpecification occurrenceSpecification, ShapeNodeEditPart parent, RelativeLocator locator) {
		super(createDummyView(parent, occurrenceSpecification));
		this.executionSpecificationEnd = occurrenceSpecification;
		this.locator = locator;
		this.setParent(parent);
		addToResource(parent.getNotationView(), this.getNotationView());
	}

	public ExecutionSpecificationEndEditPart(View view) {
		super(view);
		if(view.getElement() instanceof OccurrenceSpecification)
			this.executionSpecificationEnd = (OccurrenceSpecification)view.getElement();
	}

	public void setParent(EditPart parent) {
		super.setParent(parent);
		initLocator();
	}

	private static EObject createDummyView(ShapeNodeEditPart parent, EObject model) {
		final Shape node = new ShapeImpl() {

			@Override
			public boolean eNotificationRequired() {
				return true;
			}
		};
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(String.valueOf(VISUAL_ID));
		node.setElement(model);
		return node;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if(NotationPackage.eINSTANCE.getView_SourceEdges().equals(feature)) {
			refreshSourceConnections();
		} else if(NotationPackage.eINSTANCE.getView_TargetEdges().equals(feature)) {
			refreshTargetConnections();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	@Override
	protected void addNotationalListeners() {
		if(hasNotationView()) {
			addListenerFilter("View", this, (View)getModel());
		}
	}

	static class DummyCommand extends org.eclipse.emf.common.command.AbstractCommand {

		public void execute() {
		}

		public void redo() {
		}

		@Override
		public void undo() {
		}

		@Override
		protected boolean prepare() {
			return true;
		}
	}

	private void addToResource(final View container, final View view) {
		CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				ViewUtil.insertChildView(container, view, -1, false);
			}
		}, true);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ExecutionSpecificationEndSemanticEditPolicy());
		//The custom Graphical node edit policy for showing feedback has been removed, and this will be finished in HighlightEditPolicy.
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ExecutionSpecificationEndGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicy() {

			@Override
			protected void addSelectionHandles() { // remove handles
			}
		});
		installEditPolicy(HighlightEditPolicy.HIGHLIGHT_ROLE, new HighlightEditPolicy() {

			@Override
			protected void highlight(EditPart object) {
				super.highlight(getParent());
				IFigure feedback = getTargetIndicator();
				Rectangle rect = getFigure().getBounds().getCopy();
				getFigure().translateToAbsolute(rect);
				setFeedbackLocation(feedback, rect.getCenter());
			}
		});
	}

	public void rebuildLinks(Diagram diagram) {
		helper.collectViews(diagram);
		if(executionSpecificationEnd == null)
			return;
		EAnnotation annotation = executionSpecificationEnd.getEAnnotation("Connections");
		if(annotation != null) {
			for(EObject eo : annotation.getReferences()) {
				View view = helper.findView(eo);
				if(view == null) {
					continue; // should not happen
				}
				EList edges = view.getSourceEdges();
				for(Object o : edges) {
					if(o instanceof Edge) {
						if(needRestoreLink((Edge)o)) {
							restoreEdgeTarget((Edge)o);
							break;
						}
					}
				}
			}
		}
	}

	public void removeFromResource() {
		CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				View view = getNotationView();
				ViewUtil.destroy(view);;
			}
		}, true);
	}

	private boolean needRestoreLink(Edge e) {
		if(e.getTarget() == null) {
			return true;
		}
		EObject model = e.getTarget().getElement();
		if(!(model instanceof OccurrenceSpecification)) {
			return false;
		}
		if(model == this.resolveSemanticElement()) {
			if(!this.getNotationView().equals(e.getTarget())) {
				return true;
			}
		}
		return false;
	}

	private void restoreEdgeTarget(final Edge edge) {
		CommandHelper.executeCommandWithoutHistory(this.getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				edge.setTarget((View)ExecutionSpecificationEndEditPart.this.getModel());
			}
		}, true);
	}

	static ViewHelper helper = new ViewHelper();

	static class ViewHelper {

		Diagram diagram = null;

		Set<View> allViews = new HashSet<View>();

		Map<EObject, View> viewMaps = new HashMap<EObject, View>();

		View findView(EObject key) {
			return viewMaps.get(key);
		}

		void collectViews(Diagram d) {
			if(diagram != d) { // compare pointer ref
				diagram = d;
				allViews.clear();
				viewMaps.clear();
				getAllNestedViews(diagram, allViews);
				for(View v : allViews) {
					if(v instanceof DecorationNode) {
						continue;
					}
					viewMaps.put(v.getElement(), v);
				}
			}
		}

		static private void getAllNestedViews(View view, Set<View> allViews) {
			for(View childView : (List<View>)view.getChildren()) {
				getAllNestedViews(childView, allViews);
				allViews.add(childView);
			}
		}
	}

	static class ReorientExecutionSpecificationEndCommand extends EditElementCommand {

		private ReorientReferenceRelationshipRequest request;

		public ReorientExecutionSpecificationEndCommand(ReorientReferenceRelationshipRequest request) {
			super(request.getLabel(), request.getNewRelationshipEnd(), request);
			this.request = request;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// adding new end
			if(request.getNewRelationshipEnd() instanceof OccurrenceSpecification) {
				ExecutionSpecificationEndHelper.addConnectionSourceToExecutionSpecificationEnd((OccurrenceSpecification)request.getNewRelationshipEnd(), request.getReferenceOwner());
				// update uml model reference
				if(request.getReferenceOwner() instanceof Constraint) {
					((Constraint)request.getReferenceOwner()).getConstrainedElements().add((OccurrenceSpecification)request.getNewRelationshipEnd());
				} else if(request.getReferenceOwner() instanceof Comment) {
					((Comment)request.getReferenceOwner()).getAnnotatedElements().add((OccurrenceSpecification)request.getNewRelationshipEnd());
				}
			}
			// removing old end
			if(request.getOldRelationshipEnd() instanceof OccurrenceSpecification) {
				ExecutionSpecificationEndHelper.removeConnectionSourceFromExecutionSpecificationEnd((OccurrenceSpecification)request.getOldRelationshipEnd(), request.getReferenceOwner());
				// update uml model reference
				if(request.getReferenceOwner() instanceof Constraint) {
					((Constraint)request.getReferenceOwner()).getConstrainedElements().remove(request.getOldRelationshipEnd());
				} else if(request.getReferenceOwner() instanceof Comment) {
					((Comment)request.getReferenceOwner()).getAnnotatedElements().remove(request.getOldRelationshipEnd());
				}
			}
			return CommandResult.newOKCommandResult();
		}
	}

	static class ExecutionSpecificationEndSemanticEditPolicy extends SemanticEditPolicy {

		@Override
		protected Command getSemanticCommand(final IEditCommandRequest request) {
			if(request instanceof CreateRelationshipRequest) {
				return getCreateRelationshipCommand((CreateRelationshipRequest)request);
			} else if(request instanceof ReorientReferenceRelationshipRequest) {
				return getGEFWrapper(new ReorientExecutionSpecificationEndCommand((ReorientReferenceRelationshipRequest)request));
			} else if(request instanceof ReorientRelationshipRequest) {
				return getGEFWrapper(new ExecutionOccurrenceSpecificationMessageReorientCommand((ReorientRelationshipRequest)request));
			}
			Command cmd = super.getSemanticCommand(request);
			return cmd;
		}

		protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
			if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
				return getGEFWrapper(new ConstraintConstrainedElementCreateCommandEx(req, req.getSource(), req.getTarget()));
			} else if(UMLElementTypes.Message_4003 == req.getElementType() || UMLElementTypes.Message_4004 == req.getElementType() || UMLElementTypes.Message_4005 == req.getElementType()) {
				return getGEFWrapper(new ExecutionOccurrenceSpecificationMessageCreateCommand(req));
			}
			return null;
		}

		protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
			if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
				return getGEFWrapper(new ConstraintConstrainedElementCreateCommandEx(req, req.getSource(), req.getTarget()));
			} else if(UMLElementTypes.CommentAnnotatedElement_4010 == req.getElementType()) {
				return getGEFWrapper(new CommentAnnotatedElementCreateCommandEx(req, req.getSource(), req.getTarget()));
			} else if(UMLElementTypes.Message_4003 == req.getElementType() || UMLElementTypes.Message_4004 == req.getElementType() || UMLElementTypes.Message_4005 == req.getElementType()) {
				return getGEFWrapper(new ExecutionOccurrenceSpecificationMessageCreateCommand(req));
			}
			return null;
		}

		protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
			Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
			return command;
		}

		protected final Command getGEFWrapper(ICommand cmd) {
			return new ICommandProxy(cmd);
		}
	}

	public static class ExecutionSpecificationEndHelper {

		public static void removeConnectionSourceFromExecutionSpecificationEnd(OccurrenceSpecification executionOccurrence, EObject connectionSource) {
			EAnnotation annotation = executionOccurrence.getEAnnotation("Connections");
			if(annotation != null) {
				annotation.getReferences().remove(connectionSource);
			}
		}

		public static void addConnectionSourceToExecutionSpecificationEnd(OccurrenceSpecification executionOccurrence, EObject connectionSource) {
			EAnnotation annotation = executionOccurrence.getEAnnotation("Connections");
			if(annotation == null) {
				annotation = EcoreFactory.eINSTANCE.createEAnnotation();
				annotation.setSource("Connections"); //$NON-NLS-1$
				executionOccurrence.getEAnnotations().add(annotation);
			}
			if(!annotation.getReferences().contains(connectionSource)) {
				annotation.getReferences().add(connectionSource);
			}
		}
	}

	static class CommentAnnotatedElementCreateCommandEx extends CommentAnnotatedElementCreateCommand {

		public CommentAnnotatedElementCreateCommandEx(CreateRelationshipRequest request, EObject source, EObject target) {
			super(request, source, target);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CommandResult res = super.doExecuteWithResult(monitor, info);
			if(getTarget() instanceof OccurrenceSpecification) {
				ExecutionSpecificationEndHelper.addConnectionSourceToExecutionSpecificationEnd((OccurrenceSpecification)getTarget(), getSource());
			}
			return res;
		}
	}

	static class ConstraintConstrainedElementCreateCommandEx extends ConstraintConstrainedElementCreateCommand {

		public ConstraintConstrainedElementCreateCommandEx(CreateRelationshipRequest request, EObject source, EObject target) {
			super(request, source, target);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CommandResult res = super.doExecuteWithResult(monitor, info);
			if(getTarget() instanceof OccurrenceSpecification) {
				ExecutionSpecificationEndHelper.addConnectionSourceToExecutionSpecificationEnd((OccurrenceSpecification)getTarget(), getSource());
			}
			return res;
		}
	}

	public Locator getLocator() {
		return locator;
	}

	@Override
	protected IFigure createFigure() {
		IFigure fig = new ExecutionSpecificationEndFigure();
		fig.setForegroundColor(ColorConstants.black);
		//		Rectangle b = fig.getBounds();
		//		final ExecutionOccurrenceSpecification model = (ExecutionOccurrenceSpecification) this.resolveSemanticElement();
		//		Label tooltip = new Label();
		//		tooltip.setText(model.getName());
		//		fig.setToolTip(tooltip);
		fig.setOpaque(false);
		return fig;
	}

	@Override
	public boolean hasNotationView() {
		return true;
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		final ConnectionNodeEditPart connection = (ConnectionNodeEditPart)connEditPart;
		String t = ""; //$NON-NLS-1$
		try {
			t = (String)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				public void run() {
					Anchor a = ((Edge)connection.getModel()).getTargetAnchor();
					if(a instanceof IdentityAnchor) {
						setResult(((IdentityAnchor)a).getId());
					} else {
						setResult(""); //$NON-NLS-1$
					}
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getTargetConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getTargetConnectionAnchor", e); //$NON-NLS-1$
		}
		IAnchorableFigure fig = ((IAnchorableFigure)getFigure());
		ConnectionAnchor a = fig.getConnectionAnchor(t);
		return a;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		Point center = getFigure().getBounds().getCenter();
		getFigure().translateToAbsolute(center);
		Point pt = ((DropRequest)request).getLocation() == null ? center : new Point(((DropRequest)request).getLocation());
		if(request instanceof CreateRequest) {
			getFigure().translateToRelative(pt);
		}
		ConnectionAnchor a = ((IAnchorableFigure)getFigure()).getTargetConnectionAnchorAt(pt);
		return a;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		Point location = getFigure().getBounds().getCenter();
		getFigure().translateToAbsolute(location);
		if(!(request instanceof CreateRequest)) {
			getFigure().translateToRelative(location);
		}
		return ((IAnchorableFigure)getFigure()).getSourceConnectionAnchorAt(location);
	}

	public boolean canAttachNote() {
		return true;
	}

	public String mapConnectionAnchorToTerminal(ConnectionAnchor c) {
		return ((IAnchorableFigure)getFigure()).getConnectionAnchorTerminal(c);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart#mapTerminalToConnectionAnchor(String)
	 */
	public ConnectionAnchor mapTerminalToConnectionAnchor(String terminal) {
		return ((IAnchorableFigure)getFigure()).getConnectionAnchor(terminal);
	}

	@Override
	protected List getModelSourceConnections() {
		return ViewUtil.getSourceConnectionsConnectingVisibleViews((View)getModel());
	}

	@Override
	protected List getModelTargetConnections() {
		List list = ViewUtil.getTargetConnectionsConnectingVisibleViews((View)getModel());
		return list;
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		EditPart targetEditPart = super.getTargetEditPart(request);
		if(REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType()) || REQ_RECONNECT_SOURCE.equals(request.getType()) || REQ_RECONNECT_TARGET.equals(request.getType())) {
			return targetEditPart;
		}
		if(AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END.equals(request.getType()) || AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_REORIENT_END.equals(request.getType())) {
			return targetEditPart;
		}
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			List types = ((CreateUnspecifiedTypeConnectionRequest)request).getElementTypes();
			if(types.contains(UMLElementTypes.CommentAnnotatedElement_4010) || types.contains(UMLElementTypes.ConstraintConstrainedElement_4011)) {
				return targetEditPart;
			}
		} else if(request instanceof ReconnectRequest) {
			ConnectionEditPart con = ((ReconnectRequest)request).getConnectionEditPart();
			if(con instanceof CommentAnnotatedElementEditPart || con instanceof ConstraintConstrainedElementEditPart) {
				return targetEditPart;
			}
		}
		if(RequestConstants.REQ_SELECTION == request.getType() && isSelectable()) {
			return this;
		}
		return getParent().getTargetEditPart(request);
	}

	static class ExecutionSpecificationEndAnchor extends SlidableOvalAnchor {

		public ExecutionSpecificationEndAnchor(CircleFigure circleFigure, PrecisionPoint p) {
			super(circleFigure, p);
		}

		public ExecutionSpecificationEndAnchor(CircleFigure circleFigure) {
			super(circleFigure);
		}

		@Override
		public Point getLocation(Point reference) {
			return getBox().getCenter();
		}
	}

	class ExecutionSpecificationEndFigure extends CircleFigure {

		ExecutionSpecificationEndFigure() {
			super(DEFAULT_SIZE, DEFAULT_SIZE);
		}

		@Override
		protected void paintFigure(Graphics g) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBounds());
			r.width--;
			r.height--;
			// Hide 
			//g.drawOval(r);
		}

		@Override
		protected ConnectionAnchor createAnchor(PrecisionPoint p) {
			if(p == null) {
				return createDefaultAnchor();
			}
			return new ExecutionSpecificationEndAnchor(this, p);
		}

		@Override
		protected ConnectionAnchor createDefaultAnchor() {
			return new ExecutionSpecificationEndAnchor(this);
		}

		@Override
		public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
			try {
				return super.getTargetConnectionAnchorAt(p);
			} catch (Exception e) {
				return null;
			}
		};

		@Override
		public void validate() {
			relocateFigure(this);
			super.validate();
		}
	}

	private void initLocator() {
		if(locator == null && executionSpecificationEnd instanceof ExecutionOccurrenceSpecification) {
			ExecutionSpecification es = ((ExecutionOccurrenceSpecification)executionSpecificationEnd).getExecution();
			if(es.getStart() == executionSpecificationEnd)
				locator = new RelativeLocator(((org.eclipse.gef.GraphicalEditPart)getParent()).getFigure(), PositionConstants.NORTH);
			else
				locator = new RelativeLocator(((org.eclipse.gef.GraphicalEditPart)getParent()).getFigure(), PositionConstants.SOUTH);
		}
	}

	public void relocateFigure(ExecutionSpecificationEndFigure fig) {
		if(locator == null)
			initLocator();
		if(locator != null)
			locator.relocate(fig); //place figure at north or south, ignore layout manager
	}
}
