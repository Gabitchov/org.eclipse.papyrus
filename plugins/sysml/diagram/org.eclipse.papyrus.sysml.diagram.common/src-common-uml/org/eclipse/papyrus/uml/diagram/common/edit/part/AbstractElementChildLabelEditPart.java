/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.edit.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.gmf.diagram.common.edit.part.ITextAwareEditPart;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultGraphicalNodeEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.LabelDirectEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.TextNonResizableEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.TextSelectionEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.locator.CellEditorLocatorUtil;
import org.eclipse.papyrus.infra.emf.appearance.helper.NameLabelIconHelper;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusAnchorableWrappingLabel;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.sysml.diagram.common.preferences.LabelPreferenceHelper;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager;
import org.eclipse.papyrus.uml.diagram.common.edit.policy.MaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.parser.DefaultParserHintAdapter;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract non-diagram specific edit part for child label node.
 * This class is adapted from edit parts generated by GMF Tooling.
 */
public class AbstractElementChildLabelEditPart extends GraphicalEditPart implements ITextAwareEditPart, IPrimaryEditPart, INodeEditPart {

	private DirectEditManager manager;

	protected IParser parser;

	private List<?> parserElements;

	private String defaultText;

	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	protected IDirectEditorConfiguration configuration;

	/** Constructor */
	public AbstractElementChildLabelEditPart(View view) {
		super(view);
	}

	@Override
	public DragTracker getDragTracker(Request request) {
		if(request instanceof SelectionRequest && ((SelectionRequest)request).getLastButtonPressed() == 3) {
			return null;
		}
		//return new DragEditPartsTrackerEx(this);
		// Disable current child label DnD as this is not correctly handled by Papyrus.
		return new SelectEditPartTracker(this);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY, new MaskManagedLabelEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new TextNonResizableEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new ConnectionHandleEditPolicy());
	}

	protected String getLabelTextHelper(IFigure figure) {
		if(figure instanceof WrappingLabel) {
			return ((WrappingLabel)figure).getText();
		} else if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getText();
		} else {
			return ((Label)figure).getText();
		}
	}

	protected void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof WrappingLabel) {
			((WrappingLabel)figure).setText(text);
		} else if(figure instanceof ILabelFigure) {
			((ILabelFigure)figure).setText(text);
		} else {
			((Label)figure).setText(text);
		}
	}

	protected Image getLabelIconHelper(IFigure figure) {
		if(figure instanceof WrappingLabel) {
			return ((WrappingLabel)figure).getIcon();
		} else if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getIcon();
		} else {
			return ((Label)figure).getIcon();
		}
	}

	protected void setLabelIconHelper(IFigure figure, Image icon) {
		if(figure instanceof WrappingLabel) {
			((WrappingLabel)figure).setIcon(icon);
		} else if(figure instanceof ILabelFigure) {
			((ILabelFigure)figure).setIcon(icon);
		} else {
			((Label)figure).setIcon(icon);
		}
	}

	public void setLabel(IFigure figure) {
		unregisterVisuals();
		setFigure(figure);
		defaultText = getLabelTextHelper(figure);
		registerVisuals();
		refreshVisuals();
	}

	@Override
	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return null;
	}

	public EObject getParserElement() {
		return resolveSemanticElement();
	}

	protected Image getLabelIcon() {
		EObject parserElement = getParserElement();
		if(parserElement == null) {
			return null;
		}

		List<View> views = DiagramEditPartsUtil.findViews(parserElement, getViewer());
		for(View view : views) {
			if(NameLabelIconHelper.showLabelIcon(view)) {
				return Activator.getInstance().getLabelProvider().getImage(parserElement);
			}
		}
		return null;

	}

	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if(parserElement != null && getParser() != null) {
			text = getParser().getPrintString(new SemanticAdapter(parserElement, getNotationView()), getParserOptions().intValue());
		}
		if(text == null || text.length() == 0) {
			text = defaultText;
		}
		return text;
	}

	public void setLabelText(String text) {
		setLabelTextHelper(getFigure(), text);
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof TextSelectionEditPolicy) {
			((TextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof TextSelectionEditPolicy) {
			((TextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	public String getEditText() {
		if(getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}
		return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
	}

	protected boolean isEditable() {
		return getParser() != null;
	}

	public ICellEditorValidator getEditTextValidator() {
		return new ICellEditorValidator() {

			public String isValid(final Object value) {
				if(value instanceof String) {
					final EObject element = getParserElement();
					final IParser parser = getParser();
					try {
						IParserEditStatus valid = (IParserEditStatus)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

							public void run() {
								setResult(parser.isValidEditString(new EObjectAdapter(element), (String)value));
							}
						});
						return valid.getCode() == ParserEditStatus.EDITABLE ? null : valid.getMessage();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}

				// shouldn't get here
				return null;
			}
		};
	}

	public IContentAssistProcessor getCompletionProcessor() {
		if(getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
	}

	public ParserOptions getParserOptions() {
		if(getNotationView() == null || getNotationView().getDiagram() == null) {
			return ParserOptions.NONE;
		}

		//		int displayOptions = AppearanceHelper.getLabelDisplay(getNotationView());

		EAnnotation display = getNotationView().getEAnnotation(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION);
		if(display == null) {
			return getDefaultParserOptions();
		}

		// display != null
		int displayOptions = Integer.parseInt(display.getDetails().get(VisualInformationPapyrusConstants.CUSTOM_APPEARANCE_MASK_VALUE));
		return new ParserOptions(displayOptions);
	}

	public ParserOptions getDefaultParserOptions() {

		if(getNotationView() == null || getNotationView().getDiagram() == null) {
			return ParserOptions.NONE;
		}

		IPreferenceStore store = org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();
		int displayOptions = store.getInt(LabelPreferenceHelper.getPreferenceConstant(getLabelPreferenceKey(), ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE));
		if(displayOptions == 0) {
			return ParserOptions.NONE;
		}

		return new ParserOptions(displayOptions);
	}

	public IParser getParser() {
		if(parser == null) {
			parser = ParserService.getInstance().getParser(new DefaultParserHintAdapter(getNotationView().getDiagram(), resolveSemanticElement(), getNotationView().getType()));
		}
		return parser;
	}

	protected DirectEditManager getManager() {
		if(manager == null) {
			setManager(new MultilineLabelDirectEditManager(this, MultilineLabelDirectEditManager.getTextCellEditorClass(this), CellEditorLocatorUtil.getTextCellEditorLocator(this)));
		}
		return manager;
	}

	/**
	 * @generated
	 */
	protected void setManager(DirectEditManager manager) {
		this.manager = manager;
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		getManager().show();
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit(Point eventLocation) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(eventLocation.getSWTPoint());
		}
	}

	/**
	 * @generated
	 */
	private void performDirectEdit(char initialCharacter) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void performDirectEditRequest(Request request) {

		final Request theRequest = request;

		if(IDirectEdition.UNDEFINED_DIRECT_EDITOR == directEditionMode) {
			directEditionMode = getDirectEditionType();
		}
		switch(directEditionMode) {
		case IDirectEdition.NO_DIRECT_EDITION:
			// no direct edition mode => does nothing
			return;
		case IDirectEdition.EXTENDED_DIRECT_EDITOR:
			updateExtendedEditorConfiguration();
			if(configuration == null || configuration.getLanguage() == null) {
				performDefaultDirectEditorEdit(theRequest);
			} else {
				configuration.preEditAction(resolveSemanticElement());
				Dialog dialog = null;
				if(configuration instanceof IPopupEditorConfiguration) {
					IPopupEditorHelper helper = ((IPopupEditorConfiguration)configuration).createPopupEditorHelper(this);
					helper.showEditor();
					return;
				} else if(configuration instanceof IAdvancedEditorConfiguration) {
					dialog = ((IAdvancedEditorConfiguration)configuration).createDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()));
				} else if(configuration instanceof IDirectEditorConfiguration) {
					dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()), configuration);
				} else {
					return;
				}
				final Dialog finalDialog = dialog;

				if(Window.OK == dialog.open()) {
					TransactionalEditingDomain domain = getEditingDomain();
					RecordingCommand command = new RecordingCommand(domain, "Edit Label") {

						@Override
						protected void doExecute() {
							configuration.postEditAction(resolveSemanticElement(), ((ILabelEditorDialog)finalDialog).getValue());

						}
					};
					domain.getCommandStack().execute(command);
				}
			}
			break;
		case IDirectEdition.DEFAULT_DIRECT_EDITOR:

			// initialize the direct edit manager
			try {
				getEditingDomain().runExclusive(new Runnable() {

					public void run() {
						if(isActive() && isEditable()) {
							if(theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
								Character initialChar = (Character)theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
								performDirectEdit(initialChar.charValue());
							} else if((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
								DirectEditRequest editRequest = (DirectEditRequest)theRequest;
								performDirectEdit(editRequest.getLocation());
							} else {
								performDirectEdit();
							}
						}
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshUnderline();
		refreshStrikeThrough();
	}

	protected void refreshLabel() {

		setLabelTextHelper(getFigure(), getLabelText());
		setLabelIconHelper(getFigure(), getLabelIcon());

		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof TextSelectionEditPolicy) {
			((TextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof TextSelectionEditPolicy) {
			((TextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	protected void refreshUnderline() {
		FontStyle style = (FontStyle)getView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel)getFigure()).setTextUnderline(style.isUnderline());
		}
	}

	protected void refreshStrikeThrough() {
		FontStyle style = (FontStyle)getView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel)getFigure()).setTextStrikeThrough(style.isStrikeThrough());
		}
	}

	@Override
	protected void refreshFont() {
		FontStyle style = (FontStyle)getView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	@Override
	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

	@Override
	protected void addSemanticListeners() {
		if(getParser() instanceof ISemanticParser) {
			EObject element = resolveSemanticElement();
			parserElements = ((ISemanticParser)getParser()).getSemanticElementsBeingParsed(element);
			for(int i = 0; i < parserElements.size(); i++) {
				addListenerFilter("SemanticModel" + i, this, (EObject)parserElements.get(i)); //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}

	@Override
	protected void removeSemanticListeners() {
		if(parserElements != null) {
			for(int i = 0; i < parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}

	@Override
	protected AccessibleEditPart getAccessibleEditPart() {
		if(accessibleEP == null) {
			accessibleEP = new AccessibleGraphicalEditPart() {

				@Override
				public void getName(AccessibleEvent e) {
					e.result = getLabelTextHelper(getFigure());
				}
			};
		}
		return accessibleEP;
	}

	private View getView() {
		return (View)getModel();
	}

	public int getDirectEditionType() {
		if(checkExtendedEditor()) {
			initExtendedEditorConfiguration();
			return IDirectEdition.EXTENDED_DIRECT_EDITOR;
		}
		if(checkDefaultEdition()) {
			return IDirectEdition.DEFAULT_DIRECT_EDITOR;
		}

		// not a named element. no specific editor => do nothing
		return IDirectEdition.NO_DIRECT_EDITION;
	}

	protected boolean checkExtendedEditor() {
		if(resolveSemanticElement() != null) {
			return DirectEditorsUtil.hasSpecificEditorConfiguration(resolveSemanticElement().eClass().getInstanceClassName());
		}
		return false;
	}

	protected boolean checkDefaultEdition() {
		return (getParser() != null);
	}

	protected void initExtendedEditorConfiguration() {
		if(configuration == null) {
			final String languagePreferred = Activator.getInstance().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
			if(languagePreferred != null && !languagePreferred.equals("")) {
				configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
			} else {
				configuration = DirectEditorsUtil.findEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, resolveSemanticElement().eClass().getInstanceClassName());
			}
		}
	}

	protected void updateExtendedEditorConfiguration() {
		String languagePreferred = Activator.getInstance().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
		if(languagePreferred != null && !languagePreferred.equals("") && languagePreferred != configuration.getLanguage()) {
			configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
		} else if(IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(languagePreferred)) {
			configuration = null;
		}
	}

	protected void performDefaultDirectEditorEdit(final Request theRequest) {
		// initialize the direct edit manager
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if(isActive() && isEditable()) {
						if(theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character)theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest)theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("PrimaryView", this, getPrimaryView()); //$NON-NLS-1$
	}

	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("PrimaryView"); //$NON-NLS-1$
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if(NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			Integer c = (Integer)event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if(NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
			refreshUnderline();
		} else if(NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
			refreshStrikeThrough();
		} else if(NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
			refreshFont();
		} else if(NotationPackage.eINSTANCE.getView_SourceEdges().equals(feature)) {
			refreshSourceConnections();
		} else if(NotationPackage.eINSTANCE.getView_TargetEdges().equals(feature)) {
			refreshTargetConnections();
		} else {
			if(getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {
				refreshLabel();
			}
			if(getParser() instanceof ISemanticParser) {
				ISemanticParser modelParser = (ISemanticParser)getParser();
				if(modelParser.areSemanticElementsAffected(null, event)) {
					removeSemanticListeners();
					if(resolveSemanticElement() != null) {
						addSemanticListeners();
					}
					refreshLabel();
				}
			}
		}
		super.handleNotificationEvent(event);
	}

	@Override
	protected IFigure createFigure() {
		IFigure label = createFigurePrim();
		defaultText = getLabelTextHelper(label);
		return label;
	}

	protected IFigure createFigurePrim() {
		return new FigureDescriptor();
	}

	static final Font THIS_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.NORMAL);

	public class FigureDescriptor extends PapyrusAnchorableWrappingLabel {

		public FigureDescriptor() {
			this.setText("");
			this.setFont(THIS_FONT);
		}
	}

	private String getLabelPreferenceKey() {
		String diagramType = getNotationView().getDiagram().getType();
		String labelType = getNotationView().getType();
		return diagramType + "_" + labelType;
	}

	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getModelSourceConnections()
	 *
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
	@Override
	protected List getModelSourceConnections() {
		return ViewUtil.getSourceConnectionsConnectingVisibleViews((View)getModel());
	}

	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getModelTargetConnections()
	 *
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
	@Override
	protected List getModelTargetConnections() {
		return ViewUtil.getTargetConnectionsConnectingVisibleViews((View)getModel());
	}


	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor()
	 *
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart connEditPart) {
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart)connEditPart;
		String t = ""; //$NON-NLS-1$
		try {
			t = (String)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				public void run() {
					Anchor a = ((Edge)connection.getModel()).getSourceAnchor();
					if(a instanceof IdentityAnchor) {
						setResult(((IdentityAnchor)a).getId());
					} else {
						setResult(""); //$NON-NLS-1$
					}
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getSourceConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getSourceConnectionAnchor", e); //$NON-NLS-1$
		}
		return getAnchorableFigure().getConnectionAnchor(t);
	}

	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getAnchorableFigure()
	 *
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	protected IAnchorableFigure getAnchorableFigure() {
		IFigure myFigure = getFigure();
		if(myFigure instanceof IAnchorableFigure) {
			return (IAnchorableFigure)myFigure;
		}
		throw new RuntimeException("The figure of this element should be an IAnchorable Figure");//
	}


	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor()
	 *
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		if(request instanceof ReconnectRequest) {
			if(((DropRequest)request).getLocation() == null) {
				return getAnchorableFigure().getSourceConnectionAnchorAt(null);
			}
			Point pt = ((DropRequest)request).getLocation().getCopy();
			return getAnchorableFigure().getSourceConnectionAnchorAt(pt);
		} else if(request instanceof DropRequest) {
			return getAnchorableFigure().getSourceConnectionAnchorAt(((DropRequest)request).getLocation());
		}
		return getAnchorableFigure().getSourceConnectionAnchorAt(null);
	}


	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getTargetConnectionAnchor()
	 *
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart connEditPart) {
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart)connEditPart;

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

		return getAnchorableFigure().getConnectionAnchor(t);
	}




	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getTargetConnectionAnchor()
	 *
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(request instanceof ReconnectRequest) {
			if(((DropRequest)request).getLocation() == null) {
				return getAnchorableFigure().getTargetConnectionAnchorAt(null);
			}
			Point pt = ((DropRequest)request).getLocation().getCopy();
			return getAnchorableFigure().getTargetConnectionAnchorAt(pt);
		} else if(request instanceof DropRequest) {
			return getAnchorableFigure().getTargetConnectionAnchorAt(((DropRequest)request).getLocation());
		}
		return getAnchorableFigure().getTargetConnectionAnchorAt(null);
	}


	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#mapConnectionAnchorToTerminal()
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart#mapConnectionAnchorToTerminal(org.eclipse.draw2d.ConnectionAnchor)
	 */
	final public String mapConnectionAnchorToTerminal(ConnectionAnchor c) {
		return getAnchorableFigure().getConnectionAnchorTerminal(c);
	}

	/*
	 * (non-Javadoc)
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#mapTerminalToConnectionAnchor()
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart#mapTerminalToConnectionAnchor(java.lang.String)
	 */
	final public ConnectionAnchor mapTerminalToConnectionAnchor(String terminal) {
		return getAnchorableFigure().getConnectionAnchor(terminal);
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.INotableEditPart#canAttachNote()
	 * Copied from @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#canAttachNote()
	 */
	public boolean canAttachNote() {
		return true;
	}



}
