/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.papyrus.diagram.activity.figures.WrappedLabel;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.diagram.common.figure.node.CornerBentFigure;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class DataStoreInIARSelectionEditPart


extends DataStoreSelectionEditPart

implements ITextAwareEditPart, IBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5128;

	/**
	 * @generated
	 */
	private DirectEditManager manager;

	/**
	 * @generated
	 */
	private IParser parser;

	/**
	 * @generated
	 */
	private List<?> parserElements;

	/**
	 * @generated
	 */
	private String defaultText;



	/**
	 * direct edition mode (default, undefined, registered editor, etc.)
	 * 
	 * @generated
	 */
	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	/**
	 * configuration from a registered edit dialog
	 * 
	 * @generated
	 */
	protected IDirectEditorConfiguration configuration;



	/**
	 * @generated
	 */
	static {
		registerSnapBackPosition(UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreInIARSelectionEditPart.VISUAL_ID), new Point(0, 0));
	}

	/**
	 * @generated
	 */
	public DataStoreInIARSelectionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public IBorderItemLocator getBorderItemLocator() {
		return super.getBorderItemLocator();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public void refreshBounds() {
		super.refreshBounds();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected String getLabelTextHelper(IFigure figure) {
		return super.getLabelTextHelper(figure);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void setLabelTextHelper(IFigure figure, String text) {
		super.setLabelTextHelper(figure, text);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected Image getLabelIconHelper(IFigure figure) {
		return super.getLabelIconHelper(figure);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void setLabelIconHelper(IFigure figure, Image icon) {
		super.setLabelIconHelper(figure, icon);
	}

	/**
	 * @generated NOT use inherited method
	 */
	public void setLabel(IFigure figure) {
		super.setLabel(figure);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected List getModelChildren() {
		return super.getModelChildren();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return super.getChildBySemanticHint(semanticHint);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected EObject getParserElement() {
		return super.getParserElement();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected Image getLabelIcon() {
		return super.getLabelIcon();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected String getLabelText() {
		return super.getLabelText();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public void setLabelText(String text) {
		super.setLabelText(text);
	}

	/**
	 * @generated NOT use inherited method
	 */
	public String getEditText() {
		return super.getEditText();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected boolean isEditable() {
		return super.isEditable();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public ICellEditorValidator getEditTextValidator() {
		return super.getEditTextValidator();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public IContentAssistProcessor getCompletionProcessor() {
		return super.getCompletionProcessor();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public ParserOptions getParserOptions() {
		return super.getParserOptions();
	}

	/**
	 * @generated NOT use inherited method
	 */
	public IParser getParser() {
		return super.getParser();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected DirectEditManager getManager() {
		return super.getManager();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void setManager(DirectEditManager manager) {
		super.setManager(manager);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void performDirectEdit() {
		super.performDirectEdit();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void performDirectEdit(Point eventLocation) {
		super.performDirectEdit(eventLocation);
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
	 * @generated NOT use inherited method
	 */
	protected void performDirectEditRequest(Request request) {
		super.performDirectEditRequest(request);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void refreshLabel() {
		super.refreshLabel();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void refreshUnderline() {
		super.refreshUnderline();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void refreshStrikeThrough() {
		super.refreshStrikeThrough();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void refreshFont() {
		super.refreshFont();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void setFontColor(Color color) {
		super.setFontColor(color);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected AccessibleEditPart getAccessibleEditPart() {
		return super.getAccessibleEditPart();
	}

	/**
	 * @generated
	 */
	private View getFontStyleOwnerView() {
		return getPrimaryView();
	}



	/**
	 * Returns the kind of associated editor for direct edition.
	 * 
	 * @return an <code>int</code> corresponding to the kind of direct editor, @see org.eclipse.papyrus.diagram.common.editpolicies.IDirectEdition
	 * @generated NOT use inherited method
	 */
	public int getDirectEditionType() {
		return super.getDirectEditionType();
	}

	/**
	 * Checks if an extended editor is present.
	 * 
	 * @return <code>true</code> if an extended editor is present.
	 * @generated NOT use inherited method
	 */
	protected boolean checkExtendedEditor() {
		return super.checkExtendedEditor();
	}

	/**
	 * Checks if a default direct edition is available
	 * 
	 * @return <code>true</code> if a default direct edition is available
	 * @generated NOT use inherited method
	 */
	protected boolean checkDefaultEdition() {
		return super.checkDefaultEdition();
	}

	/**
	 * Initializes the extended editor configuration
	 * 
	 * @generated NOT use inherited method
	 */
	protected void initExtendedEditorConfiguration() {
		super.initExtendedEditorConfiguration();
	}

	/**
	 * Updates the preference configuration
	 * 
	 * @generated NOT use inherited method
	 */
	protected void updateExtendedEditorConfiguration() {
		super.updateExtendedEditorConfiguration();
	}

	/**
	 * Performs the direct edit usually used by GMF editors.
	 * 
	 * @param theRequest
	 *        the direct edit request that starts the direct edit system
	 * @generated NOT use inherited method
	 */
	protected void performDefaultDirectEditorEdit(final Request theRequest) {
		super.performDefaultDirectEditorEdit(theRequest);
	}



	/**
	 * @generated NOT use inherited method
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected IFigure createFigure() {
		return super.createFigure();
	}

	/**
	 * @generated NOT use inherited method
	 */
	protected IFigure createFigurePrim() {
		return super.createFigurePrim();
	}


	/**
	 * @generated
	 */
	public class LinkAndCornerBentWithTextFigure extends CornerBentFigure {


		/**
		 * @generated
		 */
		private WrappedLabel fCornerBentContent;

		/**
		 * @generated
		 */
		private PolylineShape fLinkToBehaviorProperty;


		/**
		 * @generated
		 */
		public LinkAndCornerBentWithTextFigure() {


			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fCornerBentContent = new WrappedLabel();



			this.add(fCornerBentContent);



			fLinkToBehaviorProperty = new PolylineShape();
			fLinkToBehaviorProperty.setLineStyle(Graphics.LINE_DASH);

			this.add(fLinkToBehaviorProperty);


		}





		/**
		 * @generated
		 */
		public WrappedLabel getCornerBentContent() {
			return fCornerBentContent;
		}

		/**
		 * @generated
		 */
		public PolylineShape getLinkToBehaviorProperty() {
			return fLinkToBehaviorProperty;
		}


	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 248, 249, 214);



}
