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
package org.eclipse.papyrus.uml.diagram.component.custom.edit.part;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.component.custom.figure.nodes.EllipseFigure;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfacePortLinkEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;


/**
 * This class is used to add behavior to reorient the lollipop or the required interface representation
 *
 */
public class CustomInterfaceEditPart extends InterfaceEditPart {
	/**
	 * 
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomInterfaceEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodePlate() {
		String prefElementId = "NamedElement";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new EllipseFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}
	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		
		//the interface is connected to an usage Link
		if((getTargetConnections().size()==1) && (getTargetConnections().get(0)  instanceof UsageEditPart)){
			UsageEditPart usageEditPart=((UsageEditPart)getTargetConnections().get(0));
			Point anchor=usageEditPart.getPrimaryShape().getEnd();

			Rectangle bounds = this.getFigure().getBounds();

			Rectangle insideRect = bounds.getCopy().shrink(new Insets(2));
			int position = insideRect.getPosition(anchor);
			this.getPrimaryShape().setRequired(true);
			this.getPrimaryShape().setProvided(false);
			this.getPrimaryShape().setOrientation(position);
		}
		
		//the interface is connected to a link for a port
		if((getTargetConnections().size()==1) && (getTargetConnections().get(0)  instanceof InterfacePortLinkEditPart)){
			InterfacePortLinkEditPart interfaceLinkPort=((InterfacePortLinkEditPart)getTargetConnections().get(0));
			Point anchor=interfaceLinkPort.getPrimaryShape().getEnd();

			Rectangle bounds = this.getFigure().getBounds();

			Rectangle insideRect = bounds.getCopy().shrink(new Insets(2));
			int position = insideRect.getPosition(anchor);
			EObjectValueStyle valueStyle=(EObjectValueStyle)((View)interfaceLinkPort.getModel()).getStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
			if(valueStyle.getName().equals("REQUIRED")){
				this.getPrimaryShape().setRequired(true);
				this.getPrimaryShape().setProvided(false);
			}
			else{
				this.getPrimaryShape().setRequired(false);
				this.getPrimaryShape().setProvided(true);
			}
			
			this.getPrimaryShape().setOrientation(position);



		}
		
		
		else if((getTargetConnections().size()==1) && (getTargetConnections().get(0)  instanceof InterfaceRealizationEditPart)){
			this.getPrimaryShape().setRequired(false);
			this.getPrimaryShape().setProvided(true);
		}
		else if((getTargetConnections().size()>1)){
			UsageEditPart usageEditPart=null;
			InterfaceRealizationEditPart interfaceRealizationEditPart=null;
			for(Iterator<?> iterator = getTargetConnections().iterator(); iterator.hasNext();) {

				EditPart editPart = (EditPart)iterator.next();
				if( editPart instanceof UsageEditPart){
					usageEditPart= (UsageEditPart)editPart;
				}
				if( editPart instanceof InterfaceRealizationEditPart){
					interfaceRealizationEditPart= (InterfaceRealizationEditPart)editPart;
				}

			}
			if(usageEditPart==null && interfaceRealizationEditPart==null){
				this.getPrimaryShape().setRequired(false);
				this.getPrimaryShape().setProvided(false);
			}
			if(usageEditPart==null && interfaceRealizationEditPart!=null){
				this.getPrimaryShape().setRequired(false);
				this.getPrimaryShape().setProvided(true);
			}
			if(usageEditPart!=null && interfaceRealizationEditPart==null){
				this.getPrimaryShape().setRequired(true);
				this.getPrimaryShape().setProvided(false);

				Point anchor=usageEditPart.getPrimaryShape().getEnd();

				Rectangle bounds = this.getFigure().getBounds();

				Rectangle insideRect = bounds.getCopy().shrink(new Insets(2));
				int position = insideRect.getPosition(anchor);
				this.getPrimaryShape().setOrientation(position);
			}
			if(usageEditPart!=null && interfaceRealizationEditPart!=null){
				//this.getPrimaryShape().setRequired(true);
				//this.getPrimaryShape().setProvided(true);
				Point anchor=usageEditPart.getPrimaryShape().getEnd();

				Rectangle bounds = this.getFigure().getBounds();

				Rectangle insideRect = bounds.getCopy().shrink(new Insets(2));
				int position = insideRect.getPosition(anchor);
				this.getPrimaryShape().setOrientation(position);
			}

		}
	}
}
