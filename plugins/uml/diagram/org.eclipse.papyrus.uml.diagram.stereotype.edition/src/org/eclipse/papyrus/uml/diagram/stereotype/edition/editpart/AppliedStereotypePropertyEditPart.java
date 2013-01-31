/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.UMLTextNonResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.parser.StereotypePropertyParser;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * the goal of this editpart is to display property of stereotype in on line
 * 
 */
public class AppliedStereotypePropertyEditPart extends UMLCompartmentEditPart implements ITextAwareEditPart, IPrimaryEditPart {


	public static final String ID = "AppliedStereotypeProperty";

	private DirectEditManager manager;

	private IParser parser;

	private List<?> parserElements;

	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	protected IDirectEditorConfiguration configuration;

	public AppliedStereotypePropertyEditPart(View view) {
		super(view);
	}


	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#activate()
	 * 
	 */
	@Override
	public void activate() {
		super.activate();
		// add listeners of listen modification on application of stereotypes
		EObject stereotypeApplication = ((View)getNotationView().eContainer()).getElement();
		final Element umlElement = UMLUtil.getBaseElement(stereotypeApplication);
		getDiagramEventBroker().addNotificationListener(stereotypeApplication, this);
		getDiagramEventBroker().addNotificationListener(umlElement, this);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#deactivate()
	 * 
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		//remove Listeners
		EObject stereotypeApplication = ((View)getNotationView().eContainer()).getElement();
		final Element umlElement = UMLUtil.getBaseElement(stereotypeApplication);
		getDiagramEventBroker().removeNotificationListener(stereotypeApplication, this);
		getDiagramEventBroker().removeNotificationListener(umlElement, this);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart#getDragTracker(org.eclipse.gef.Request)
	 * 
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		if(request instanceof SelectionRequest && ((SelectionRequest)request).getLastButtonPressed() == 3) {
			return null;
		}
		return new DragEditPartsTrackerEx(this);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.UMLCompartmentEditPart#createDefaultEditPolicies()
	 * 
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		//installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PropertyForClassItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new UMLTextNonResizableEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
	}


	/**
	 * get the text from the figure
	 * 
	 * @param figure
	 * @return
	 */
	protected String getLabelTextHelper(IFigure figure) {
		if(figure instanceof WrappingLabel) {
			return ((WrappingLabel)figure).getText();
		} else if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getText();
		} else {
			return ((Label)figure).getText();
		}
	}

	/**
	 * set the text into the figure
	 * 
	 * @param figure
	 * @param text
	 */
	protected void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof WrappingLabel) {
			((WrappingLabel)figure).setText(text);
		} else if(figure instanceof ILabelFigure) {
			((ILabelFigure)figure).setText(text);
		} else {
			((Label)figure).setText(text);
		}
	}

	/**
	 * get the icon from the figure
	 * 
	 * @param figure
	 *        the figure
	 * @return the icon
	 */
	protected Image getLabelIconHelper(IFigure figure) {
		if(figure instanceof WrappingLabel) {
			return ((WrappingLabel)figure).getIcon();
		} else if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getIcon();
		} else {
			return ((Label)figure).getIcon();
		}
	}

	/**
	 * set the icon into the figure
	 * 
	 * @param figure
	 *        get the figure
	 * @param icon
	 */
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
		registerVisuals();
		refreshVisuals();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getModelChildren()
	 * 
	 */
	@Override
	@SuppressWarnings("rawtypes")
	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getChildBySemanticHint(java.lang.String)
	 * 
	 */
	@Override
	public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return null;
	}

	/**
	 * 
	 * @return the element that will be edited
	 */
	protected EObject getParserElement() {
		return resolveSemanticElement();
	}

	/**
	 * 
	 * @return null for the icon of the label
	 */
	protected Image getLabelIcon() {
		return null;
	}

	/**
	 * 
	 * @return a string that is the presentation of the element into the label
	 */
	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if(parserElement != null && getParser() != null) {
			text = getParser().getPrintString(new SemanticAdapter(this.resolveSemanticElement(), getNotationView()), getParserOptions().intValue());
		}
		if(text == null || text.length() == 0) {
			text = "SterotypeProperty";
		}
		return text;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#setLabelText(java.lang.String)
	 * 
	 */
	public void setLabelText(String text) {
		setLabelTextHelper(getFigure(), text);
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditText()
	 * 
	 */
	public String getEditText() {
		if(getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}
		return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
	}

	/**
	 * 
	 * @return the label is editable
	 */
	protected boolean isEditable() {
		if(!(((Property)resolveSemanticElement()).isDerived())) {
			return getParser() != null;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditTextValidator()
	 * 
	 */
	public ICellEditorValidator getEditTextValidator() {
		return new ICellEditorValidator() {

			public String isValid(final Object value) {
				if(value instanceof String) {
					final EObject element = getParserElement();
					final IParser parser = getParser();
					try {
						@SuppressWarnings("rawtypes")
						IParserEditStatus valid = (IParserEditStatus)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

							@SuppressWarnings("unchecked")
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

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getCompletionProcessor()
	 * 
	 */
	public IContentAssistProcessor getCompletionProcessor() {
		if(getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getParserOptions()
	 * 
	 */
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getParser()
	 * 
	 */
	public IParser getParser() {
		if(parser == null) {
			parser = new StereotypePropertyParser();
		}
		return parser;
	}

	/**
	 * get the manager in charge of the edition
	 * 
	 * @return the directEditManager
	 */
	protected DirectEditManager getManager() {
		if(manager == null) {
			setManager(new MultilineLabelDirectEditManager(this, MultilineLabelDirectEditManager.getTextCellEditorClass(this), getTextCellEditorLocator(this)));
		}
		return manager;
	}


	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if(source.getFigure() instanceof WrappingLabel) {
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		}
		return null;

	}

	/**
	 * set the manager in charge of the edition
	 * 
	 * @param manager
	 */
	protected void setManager(DirectEditManager manager) {
		this.manager = manager;
	}

	/**
	 * perform the edtion of the label
	 */
	protected void performDirectEdit() {
		getManager().show();
	}

	/**
	 * perform the edtion of the label
	 * 
	 * @param eventLocation
	 */
	protected void performDirectEdit(Point eventLocation) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(eventLocation.getSWTPoint());
		}
	}

	/**
	 * perform the edition
	 */
	private void performDirectEdit(char initialCharacter) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performDirectEditRequest(org.eclipse.gef.Request)
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

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#refreshVisuals()
	 * 
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshUnderline();
		refreshStrikeThrough();
	}

	/**
	 * refresh the associated label by taking in account the semantic
	 */
	protected void refreshLabel() {
		EditPolicy maskLabelPolicy = getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(maskLabelPolicy == null) {
			setLabelTextHelper(getFigure(), getLabelText());
			setLabelIconHelper(getFigure(), getLabelIcon());
		}
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}


	/**
	 * specific refresh for the underline
	 */
	protected void refreshUnderline() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel)getFigure()).setTextUnderline(style.isUnderline());
		}
	}

	/**
	 * specific refresh strick for the label
	 */
	protected void refreshStrikeThrough() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel)getFigure()).setTextStrikeThrough(style.isStrikeThrough());
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#refreshFont()
	 * 
	 */
	@Override
	protected void refreshFont() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#setFontColor(org.eclipse.swt.graphics.Color)
	 * 
	 */
	@Override
	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 * 
	 */
	@Override
	protected void addSemanticListeners() {
		if(getParser() instanceof ISemanticParser) {
			//listen stereotype application
			EObject StereotypeApplication = ((View)getNotationView().eContainer()).getElement();
			addListenerFilter("SemanticModelForStereotypeApplication", this, StereotypeApplication); //$NON-NLS-1$
			EObject element = resolveSemanticElement();
			parserElements = ((ISemanticParser)getParser()).getSemanticElementsBeingParsed(element);
			for(int i = 0; i < parserElements.size(); i++) {
				addListenerFilter("SemanticModel" + i, this, (EObject)parserElements.get(i)); //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 * 
	 */
	@Override
	protected void removeSemanticListeners() {
		//remove listener on the stereotype application
		removeListenerFilter("SemanticModelForStereotypeApplication"); //$NON-NLS-1$
		if(parserElements != null) {
			for(int i = 0; i < parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAccessibleEditPart()
	 * 
	 */
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

	private View getFontStyleOwnerView() {
		return (View)getModel();
	}

	/**
	 * Returns the kind of associated editor for direct edition.
	 * 
	 * @return an <code>int</code> corresponding to the kind of direct editor, @see org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition
	 */
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

	/**
	 * Checks if an extended editor is present.
	 * 
	 * @return <code>true</code> if an extended editor is present.
	 */
	protected boolean checkExtendedEditor() {
		if(resolveSemanticElement() != null) {
			return DirectEditorsUtil.hasSpecificEditorConfiguration(resolveSemanticElement().eClass().getInstanceClassName());
		}
		return false;
	}

	/**
	 * Checks if a default direct edition is available
	 * 
	 * @return <code>true</code> if a default direct edition is available
	 */
	protected boolean checkDefaultEdition() {
		return (getParser() != null);
	}

	/**
	 * Initializes the extended editor configuration
	 * 
	 */
	protected void initExtendedEditorConfiguration() {
		if(configuration == null) {
			final String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
			if(languagePreferred != null && !languagePreferred.equals("")) {
				configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
			} else {
				configuration = DirectEditorsUtil.findEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, resolveSemanticElement().eClass().getInstanceClassName());
			}
		}
	}

	/**
	 * Updates the preference configuration
	 * 
	 */
	protected void updateExtendedEditorConfiguration() {
		String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
		if(languagePreferred != null && !languagePreferred.equals("") && languagePreferred != configuration.getLanguage()) {
			configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
		} else if(IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(languagePreferred)) {
			configuration = null;
		}
	}

	/**
	 * Performs the direct edit usually used by GMF editors.
	 * 
	 * @param theRequest
	 *        the direct edit request that starts the direct edit system
	 */
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

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addNotationalListeners()
	 * 
	 */
	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("PrimaryView", this, getPrimaryView()); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeNotationalListeners()
	 * 
	 */
	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("PrimaryView"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 * 
	 */
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

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#createFigure()
	 * 
	 */
	@Override
	protected IFigure createFigure() {
		return new PropertyFigureDescriptor();
	}

	/**
	 * this method has been overloaded in order to be able to display it into the proeprtyView
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAdapter(java.lang.Class)
	 * 
	 */
	@Override
	public Object getAdapter(Class key) {
		if(key == AppliedStereotypeProperty.class) {
			return new AppliedStereotypeProperty(((View)getNotationView().eContainer()).getElement(), (Property)resolveSemanticElement());
		}
		return null;
		//return super.getAdapter(key);
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if(!text.getFont().isDisposed()) {
				if(getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
					rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
				} else {
					int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}


	/**
	 * the figure associated to this editpart
	 * 
	 */
	public class PropertyFigureDescriptor extends WrappingLabel {

		/**
		 * @generated
		 */
		public PropertyFigureDescriptor() {
			this.setText("");

			this.setFont(THIS_FONT);

		}

	}

	static final Font THIS_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.NORMAL);

}
