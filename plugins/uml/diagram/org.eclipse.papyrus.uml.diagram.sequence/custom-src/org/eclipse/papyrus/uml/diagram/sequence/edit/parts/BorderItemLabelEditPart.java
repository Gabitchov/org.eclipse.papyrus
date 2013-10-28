/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
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
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
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
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.sequence.Activator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Feature;


/**
 * Abstract LabelEditPart which should be located around of BorderedNodeFigure.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class BorderItemLabelEditPart extends LabelEditPart implements ITextAwareEditPart, IBorderItemEditPart {

	private DirectEditManager manager;

	private IParser parser;

	private List<?> parserElements;

	private String defaultText;

	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	protected IDirectEditorConfiguration configuration;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public BorderItemLabelEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new UMLTextSelectionEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new BorderItemSelectionEditPolicy() {

			protected List createSelectionHandles() {
				MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
				mh.setBorder(null);
				return Collections.singletonList(mh);
			}
		});
	}

	public IBorderItemLocator getBorderItemLocator() {
		IFigure parentFigure = getFigure().getParent();
		if(parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
			return (IBorderItemLocator)constraint;
		}
		return null;
	}

	public void refreshBounds() {
		Point location = getLocation();
		if(location == null) {
			location = new Point();
		}
		Dimension size = getSize();
		if(size == null) {
			size = new Dimension();
		}
		IBorderItemLocator borderItemLocator = getBorderItemLocator();
		if(borderItemLocator != null) {
			borderItemLocator.setConstraint(new Rectangle(location, size));
		}
	}

	protected Point getLocation() {
		Point point = new Point();
		point.x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		point.y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		return point;
	}

	protected Dimension getSize() {
		Dimension size = new Dimension();
		size.width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		size.height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
		return size;
	}

	public int getKeyPoint() {
		return ConnectionLocator.MIDDLE;
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

	public void setLabel(WrappingLabel figure) {
		unregisterVisuals();
		setFigure(figure);
		defaultText = getLabelTextHelper(figure);
		registerVisuals();
		refreshVisuals();
	}

	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return null;
	}

	protected EObject getParserElement() {
		return resolveSemanticElement();
	}

	protected Image getLabelIcon() {
		return null;
	}

	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if(parserElement != null && getParser() != null) {
			text = getParser().getPrintString(new EObjectAdapter(parserElement), getParserOptions().intValue());
		}
		if(text == null || text.length() == 0) {
			text = defaultText;
		}
		return text;
	}

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
		return ParserOptions.NONE;
	}

	public final IParser getParser() {
		if(parser == null) {
			parser = createParser();
		}
		return parser;
	}

	protected abstract IParser createParser();

	protected DirectEditManager getManager() {
		if(manager == null) {
			setManager(new MultilineLabelDirectEditManager(this, MultilineLabelDirectEditManager.getTextCellEditorClass(this), UMLEditPartFactory.getTextCellEditorLocator(this)));
		}
		return manager;
	}

	protected void setManager(DirectEditManager manager) {
		this.manager = manager;
	}

	protected void performDirectEdit() {
		getManager().show();
	}

	protected void performDirectEdit(Point eventLocation) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(eventLocation.getSWTPoint());
		}
	}

	private void performDirectEdit(char initialCharacter) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}

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
					dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), ((IDirectEditorConfiguration)configuration).getTextToEdit(resolveSemanticElement()), (IDirectEditorConfiguration)configuration);
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

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshUnderline();
		refreshStrikeThrough();
	}

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
		refreshBounds();
	}

	protected void refreshUnderline() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel)getFigure()).setTextUnderline(style.isUnderline());
		}
		if(resolveSemanticElement() instanceof Feature) {
			if(((Feature)resolveSemanticElement()).isStatic()) {
				((WrappingLabel)getFigure()).setTextUnderline(true);
			} else {
				((WrappingLabel)getFigure()).setTextUnderline(false);
			}
		}
	}

	protected void refreshStrikeThrough() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel)getFigure()).setTextStrikeThrough(style.isStrikeThrough());
		}
	}

	protected void refreshFont() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

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

	protected void removeSemanticListeners() {
		if(parserElements != null) {
			for(int i = 0; i < parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}

	protected AccessibleEditPart getAccessibleEditPart() {
		if(accessibleEP == null) {
			accessibleEP = new AccessibleGraphicalEditPart() {

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
			final String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
			if(languagePreferred != null && !languagePreferred.equals("")) {
				configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
			} else {
				configuration = DirectEditorsUtil.findEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, resolveSemanticElement().eClass().getInstanceClassName());
			}
		}
	}

	protected void updateExtendedEditorConfiguration() {
		String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
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

	protected IFigure createFigure() {
		final IFigure label = createFigurePrim();
		defaultText = getLabelTextHelper(label);
		return label;
	}

	protected IFigure createFigurePrim() {
		return new WrappingLabel();
	}
}
