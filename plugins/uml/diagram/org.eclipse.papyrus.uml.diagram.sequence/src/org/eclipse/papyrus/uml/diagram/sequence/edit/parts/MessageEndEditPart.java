package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
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
import org.eclipse.gef.commands.Command;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.GeneralOrderingCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Edit part for message end to make it possible for selecting a messageEnd. 
 * 
 */
public class MessageEndEditPart extends GraphicalEditPart implements
		INodeEditPart {

	private static final String DUMMY_TYPE = "999999";
	private static final int DEFAULT_SIZE = 16;
	private ConnectionLocator locator;
	private MessageEnd messageEnd;

	public MessageEndEditPart(MessageEnd end, AbstractMessageEditPart parent,
			ConnectionLocator locator) {
		super(createDummyView(parent, end));
		this.locator = locator;
		this.setParent(parent);
		this.messageEnd = end;	
		addToResource(parent.getNotationView(), this.getNotationView());
	}

	@Override
	protected void addNotationalListeners() {
		if (hasNotationView()) {
			addListenerFilter("View", this,(View)getModel()); //$NON-NLS-1$
		}
	}

	protected List getModelSourceConnections() {
		return ViewUtil
				.getSourceConnectionsConnectingVisibleViews((View) getModel());
	}

	protected List getModelTargetConnections() {
		List list = ViewUtil
				.getTargetConnectionsConnectingVisibleViews((View) getModel());
		return list;
	}

	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getView_SourceEdges().equals(feature))
			refreshSourceConnections();
		else if (NotationPackage.eINSTANCE.getView_TargetEdges()
				.equals(feature))
			refreshTargetConnections();
		else
			super.handleNotificationEvent(notification);
	}

	private static View createDummyView(AbstractMessageEditPart parent,
			EObject model) {
		View view = parent.findChildByModel(model);
		if(view != null)
			return view;
		
		final Shape node = new ShapeImpl() {
			public boolean eNotificationRequired() {
				return true;
			}
		};

		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(DUMMY_TYPE);
		node.setElement(model);
//		final View container = (View) parent.getModel();
//		ViewUtil.insertChildView(container.getDiagram(), node,-1, true);
		return node;
	}

	static class DummyCommand extends org.eclipse.emf.common.command.AbstractCommand  {
		public void execute() {
		}

		public void redo() {
		}

		public void undo() {
		}

		protected boolean prepare() {
			return true;
		}
	}

	private void addToResource(final View container, final View view) {
		CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new DummyCommand() {
			public void execute() {
				ViewUtil.insertChildView(container, view,-1, false);
			}
		}, true);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MessageEndSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new MessageEndGraphicalNodeEditPolicy());
	}
	
	protected IFigure createFigure() {
		final MessageEnd messageEnd = (MessageEnd) this
				.resolveSemanticElement();
		IFigure fig = new MessageEndFigure();
		fig.setForegroundColor(ColorConstants.white);

		Label tooltip = new Label();
		if(messageEnd != null)
			tooltip.setText(messageEnd.getName());
		fig.setToolTip(tooltip);

		fig.setOpaque(false);
		// f.setFill(true);
		//((org.eclipse.gef.GraphicalEditPart) getParent()).getFigure().add(fig);
		return fig;
	}

	public boolean hasNotationView() {
		return true;
	}

	public ConnectionAnchor getSourceConnectionAnchor(
			final ConnectionEditPart connEditPart) {
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = 
            (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart)connEditPart;
		String t = ""; //$NON-NLS-1$
		try {
			t = (String) getEditingDomain().runExclusive(
				new RunnableWithResult.Impl() {

				public void run() {
					Anchor a = ((Edge) connection.getModel()).getSourceAnchor();
					if (a instanceof IdentityAnchor)
						setResult(((IdentityAnchor) a).getId());
                    else
                        setResult(""); //$NON-NLS-1$
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(),
				DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(),
				"getSourceConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(),
				DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING,
				"getSourceConnectionAnchor", e); //$NON-NLS-1$
		}
		IAnchorableFigure fig = ((IAnchorableFigure) getFigure());
		return fig.getConnectionAnchor(t);
	}

	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connEditPart) {
		final ConnectionNodeEditPart connection = (ConnectionNodeEditPart) connEditPart;
		String t = ""; //$NON-NLS-1$
		try {
			t = (String) getEditingDomain().runExclusive(
					new RunnableWithResult.Impl() {

						public void run() {
							Anchor a = ((Edge) connection.getModel())
									.getTargetAnchor();
							if (a instanceof IdentityAnchor)
								setResult(((IdentityAnchor) a).getId());
							else
								setResult(""); //$NON-NLS-1$
						}
					});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(),
					DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(),
					"getTargetConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(),
					DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING,
					"getTargetConnectionAnchor", e); //$NON-NLS-1$
		}
		IAnchorableFigure fig = ((IAnchorableFigure) getFigure());
		ConnectionAnchor a = fig.getConnectionAnchor(t);
		return a;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		Point center = getFigure().getBounds().getCenter();
		getFigure().translateToAbsolute(center);
		Point pt = ((DropRequest) request).getLocation() == null ? center
				: new Point(((DropRequest) request).getLocation());
		if (request instanceof CreateRequest) {
			getFigure().translateToRelative(pt);
		}
		ConnectionAnchor a = ((IAnchorableFigure) getFigure())
				.getTargetConnectionAnchorAt(pt);
		return a;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		IAnchorableFigure fig = ((IAnchorableFigure) getFigure());
		if (request instanceof ReconnectRequest) {
			if (((DropRequest) request).getLocation() == null) {
				return fig.getSourceConnectionAnchorAt(null);
			}
			Point pt = ((DropRequest) request).getLocation().getCopy();
			return fig.getSourceConnectionAnchorAt(pt);
		}
		else if (request instanceof DropRequest){
			return fig.getSourceConnectionAnchorAt(
				((DropRequest) request).getLocation());
		}
		return fig.getSourceConnectionAnchorAt(null);
	}

	public boolean canAttachNote() {
		return true;
	}

	public String mapConnectionAnchorToTerminal(ConnectionAnchor c) {
		return ((IAnchorableFigure) getFigure()).getConnectionAnchorTerminal(c);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart#mapTerminalToConnectionAnchor(String)
	 */
	public ConnectionAnchor mapTerminalToConnectionAnchor(String terminal) {
		return ((IAnchorableFigure) getFigure()).getConnectionAnchor(terminal);
	}

	public void rebuildLinks(Diagram diagram) {
		helper.collectViews(diagram);
		if(messageEnd == null)
			return;
		EAnnotation annotation = messageEnd.getEAnnotation("Connections");
		if (annotation != null) {
			for (EObject eo : annotation.getReferences()) {
				View view = helper.findView(eo);
				if (view == null)
					continue; // should not happen

				EList edges = view.getSourceEdges();
				for (Object o : edges) {
					if (o instanceof Edge && ((Edge) o).getTarget() == null) {
						restoreEdgeTarget((Edge) o);
						break;
					}
				}
			}
		}
	}

	private void restoreEdgeTarget(final Edge edge) {
		org.eclipse.emf.common.command.Command c = new org.eclipse.emf.common.command.AbstractCommand() {
			public void execute() {
				edge.setTarget((View) MessageEndEditPart.this
						.getModel());
			}

			public void redo() {
			}

			public void undo() {
			}

			protected boolean prepare() {
				return true;
			}
		};

		CommandHelper.executeCommandWithoutHistory(this.getEditingDomain(), c, true);
	}
	
	/**
	 * The circle feedback has been moved to HighlightEditPolicy.
	 */
	static class MessageEndGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
		
		protected Connection createDummyConnection(Request req) {
			Connection conn = super.createDummyConnection(req);
			conn.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			return conn;
		}
		
		protected Command getConnectionAndRelationshipCreateCommand(CreateConnectionViewAndElementRequest request) {
			Map<String, Object> extendedData = request.getExtendedData();
			String requestHint = request.getConnectionViewAndElementDescriptor().getSemanticHint();
			if(((IHintedType)UMLElementTypes.GeneralOrdering_4012).getSemanticHint().equals(requestHint)) {
				if(getHost() instanceof MessageEndEditPart){
					List<OccurrenceSpecification> events = new ArrayList<OccurrenceSpecification>(2);
					final MessageOccurrenceSpecification messageEnd = (MessageOccurrenceSpecification) ((MessageEndEditPart)getHost()).resolveSemanticElement();
					events.add(messageEnd);
					extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION, events);
					extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION, request.getLocation());
				}
			}
			return super.getConnectionAndRelationshipCreateCommand(request);
		}
		
		protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
			Map<String, Object> extendedData = request.getExtendedData();
			String requestHint = request.getConnectionViewAndElementDescriptor().getSemanticHint();
			if(((IHintedType)UMLElementTypes.GeneralOrdering_4012).getSemanticHint().equals(requestHint)) {
				if(getHost() instanceof MessageEndEditPart){
					List<OccurrenceSpecification> events = new ArrayList<OccurrenceSpecification>(2);
					final MessageOccurrenceSpecification messageEnd = (MessageOccurrenceSpecification) ((MessageEndEditPart)getHost()).resolveSemanticElement();
					events.add(messageEnd);
					extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2, events);
					extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2, request.getLocation());
				}
			}
			return super.getConnectionAndRelationshipCompleteCommand(request);
		}
	}
	
	static class ReorientMessageEndCommand extends EditElementCommand{
		private ReorientReferenceRelationshipRequest request;

		public ReorientMessageEndCommand(ReorientReferenceRelationshipRequest request) {
			super(request.getLabel(), request.getNewRelationshipEnd(), request);
			this.request = request;
		}

		public boolean canExecute() {		 
			return true;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			// adding new end
			if(request.getNewRelationshipEnd() instanceof MessageEnd) {
				MessageEndHelper.addConnectionSourceToMessageEnd((MessageEnd) request.getNewRelationshipEnd(), request.getReferenceOwner());
				if(request.getReferenceOwner() instanceof Constraint) {
					((Constraint)request.getReferenceOwner()).getConstrainedElements().add((MessageEnd) request.getNewRelationshipEnd());
				}else if(request.getReferenceOwner() instanceof Comment) {
					((Comment) request.getReferenceOwner()).getAnnotatedElements().add( (MessageEnd)  request.getNewRelationshipEnd());
				}
			}
			// removing old end
			if(request.getOldRelationshipEnd() instanceof MessageEnd) {
				MessageEndHelper.removeConnectionSourceFromMessageEnd((MessageEnd) request.getOldRelationshipEnd(), request.getReferenceOwner());
				if(request.getReferenceOwner() instanceof Constraint) {
					((Constraint)request.getReferenceOwner()).getConstrainedElements().remove((MessageEnd) request.getOldRelationshipEnd());
				}else if(request.getReferenceOwner() instanceof Comment) {
					((Comment) request.getReferenceOwner()).getAnnotatedElements().remove( (MessageEnd)  request.getOldRelationshipEnd());
				}
			}
			return CommandResult.newOKCommandResult();
		}
	}
	
	static class MessageEndSemanticEditPolicy extends SemanticEditPolicy{
			
		protected Command getSemanticCommand(
				final IEditCommandRequest request) {
			if (request instanceof CreateRelationshipRequest) {
				return getCreateRelationshipCommand((CreateRelationshipRequest) request);
			}else if( request instanceof ReorientReferenceRelationshipRequest) {
				return  getGEFWrapper(new ReorientMessageEndCommand((ReorientReferenceRelationshipRequest) request ) ) ;
			}
			Command cmd = super.getSemanticCommand(request);
			return cmd;
		}

		protected Command getStartCreateRelationshipCommand(
				CreateRelationshipRequest req) {
			if (UMLElementTypes.ConstraintConstrainedElement_4011 == req
					.getElementType()) {
				return getGEFWrapper(new ConstraintConstrainedElementCreateCommandEx(
						req, req.getSource(), req.getTarget()));
			}else if(UMLElementTypes.GeneralOrdering_4012 == req.getElementType()) {
				return getGEFWrapper(new GeneralOrderingCreateCommand(req, req.getSource(), req.getTarget()));
			}
			return null;
		}

		protected Command getCompleteCreateRelationshipCommand(
				CreateRelationshipRequest req) {
			if (UMLElementTypes.ConstraintConstrainedElement_4011 == req
					.getElementType()) {
				return getGEFWrapper(new ConstraintConstrainedElementCreateCommandEx(
						req, req.getSource(), req.getTarget()));
			}else if(UMLElementTypes.CommentAnnotatedElement_4010 == req
					.getElementType()) {
				return getGEFWrapper(new CommentAnnotatedElementCreateCommandEx(req, req.getSource(), req.getTarget()));
			}else if(UMLElementTypes.GeneralOrdering_4012 == req.getElementType()) {
				return getGEFWrapper(new GeneralOrderingCreateCommand(req, req.getSource(), req.getTarget()));
			}
			return null;
		}

		protected Command getCreateRelationshipCommand(
				CreateRelationshipRequest req) {
			Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
					: getCompleteCreateRelationshipCommand(req);
			return command;
		}

		protected final Command getGEFWrapper(ICommand cmd) {
			return new ICommandProxy(cmd);
		}

	}

	static class CommentAnnotatedElementCreateCommandEx extends CommentAnnotatedElementCreateCommand{

		public CommentAnnotatedElementCreateCommandEx(
				CreateRelationshipRequest request, EObject source,
				EObject target) {
			super(request, source, target);
		}
		
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CommandResult res = super.doExecuteWithResult(monitor, info);
			if (getTarget() instanceof MessageEnd) {
				MessageEndHelper.addConnectionSourceToMessageEnd((MessageEnd) getTarget(), getSource());
			}
			return res;	 
		}	
	}
	
	static class ConstraintConstrainedElementCreateCommandEx extends
			ConstraintConstrainedElementCreateCommand {

		public ConstraintConstrainedElementCreateCommandEx(
				CreateRelationshipRequest request, EObject source,
				EObject target) {
			super(request, source, target);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {

			CommandResult res = super.doExecuteWithResult(monitor, info);
			if (getTarget() instanceof MessageEnd) {
				MessageEndHelper.addConnectionSourceToMessageEnd((MessageEnd) getTarget(), getSource());
			}
			return res;
		}
	}

	static class MessageEndAnchor extends SlidableOvalAnchor {

		public MessageEndAnchor(CircleFigure circleFigure, PrecisionPoint p) {
			super(circleFigure, p);
		}

		public MessageEndAnchor(CircleFigure circleFigure) {
			super(circleFigure);
		}

		public Point getLocation(Point reference) {
			return getBox().getCenter(); 
		}
	}

	class MessageEndFigure extends CircleFigure {
		MessageEndFigure() {
			super(DEFAULT_SIZE, DEFAULT_SIZE);
		}

		@Override
		protected void paintFigure(Graphics g) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBounds());
			r.width--;
			r.height--;
			// g.drawOval(r);
		}

		protected ConnectionAnchor createAnchor(PrecisionPoint p) {
			if (p == null)
				return createDefaultAnchor();
			return new MessageEndAnchor(this, p);
		}

		protected ConnectionAnchor createDefaultAnchor() {
			return new MessageEndAnchor(this);
		}

		public void validate() {
			locator.relocate(this);
			super.validate();
		}

		public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
			try {
				return super.getTargetConnectionAnchorAt(p);
			} catch (Exception e) {
				return null;
			}
		};
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
			if (diagram != d) { // compare pointer ref
				diagram = d;
				allViews.clear();
				viewMaps.clear();

				getAllNestedViews(diagram, allViews);
				for (View v : allViews) {
					if (v instanceof DecorationNode)
						continue;

					viewMaps.put(v.getElement(), v);
				}
			}
		}

		static private void getAllNestedViews(View view, Set<View> allViews) {
			for (View childView : (List<View>) view.getChildren()) {
				getAllNestedViews(childView, allViews);
				allViews.add(childView);
			}
		}
	}
	
	public static class MessageEndHelper{
		public static void removeConnectionSourceFromMessageEnd(MessageEnd messageEnd , EObject connectionSource) {
			EAnnotation annotation = messageEnd
					.getEAnnotation("Connections");
			if (annotation != null) {
				 annotation.getReferences().remove( connectionSource);
			}
		}
		
		public static void addConnectionSourceToMessageEnd(MessageEnd messageEnd,EObject connectionSource)  {
			EAnnotation annotation = messageEnd
					.getEAnnotation("Connections");
			if (annotation == null) {
				annotation = EcoreFactory.eINSTANCE.createEAnnotation();
				annotation.setSource("Connections"); //$NON-NLS-1$
				messageEnd.getEAnnotations().add(annotation);
			}
			if( !annotation.getReferences().contains( connectionSource) )
				annotation.getReferences().add(connectionSource);
		}
	}
	
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest){
			List types = ((CreateUnspecifiedTypeConnectionRequest) request).getElementTypes();
			if(types.contains(UMLElementTypes.CommentAnnotatedElement_4010) || types.contains(UMLElementTypes.ConstraintConstrainedElement_4011) || types.contains(UMLElementTypes.GeneralOrdering_4012)){
				return super.getTargetEditPart(request);
			}
		}else if(request instanceof ReconnectRequest){
			ConnectionEditPart con = ((ReconnectRequest)request).getConnectionEditPart();
			if(con instanceof CommentAnnotatedElementEditPart || con instanceof ConstraintConstrainedElementEditPart || con instanceof GeneralOrderingEditPart){
				return super.getTargetEditPart(request);
			}
		} else if(AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END.equals(request.getType()) || AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_REORIENT_END.equals(request.getType())) {
			return super.getTargetEditPart(request);
		} else if(request instanceof CreateUnspecifiedTypeRequest && ((CreateUnspecifiedTypeRequest)request).getElementTypes().contains(UMLElementTypes.TimeConstraint_3019)) {
			return super.getTargetEditPart(request);
		}
		return null;
	}
}