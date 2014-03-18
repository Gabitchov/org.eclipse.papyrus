/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

//DOCUMENTATION: PapyrusGencode
//change to manage the figure of the comment
@Singleton class EditPartFactory extends xpt.diagram.editparts.EditPartFactory {

	@Inject extension xpt.Common;


	override getTextCellEditorLocator(GenDiagram it) '''
		«generatedMemberComment»
		public static org.eclipse.gef.tools.CellEditorLocator getTextCellEditorLocator(
				org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart source) {
				      if (source.getFigure() instanceof org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure){
				return new MultilineCellEditorLocator(
						(org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure) source.getFigure());
						}
						   else {
						      return org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
		
		       }
		   }
		   
		   
		   «generatedClassComment»
		   static private class MultilineCellEditorLocator implements org.eclipse.gef.tools.CellEditorLocator {
		
			«generatedClassComment»
			private org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure multilineEditableFigure;
		
			«generatedClassComment»
			public MultilineCellEditorLocator(org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure figure) {
			this.multilineEditableFigure = figure;
			}
		
			«generatedClassComment»
			public org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure getMultilineEditableFigure() {
			return multilineEditableFigure;
			}
		
			«generatedClassComment»
			public void relocate(org.eclipse.jface.viewers.CellEditor celleditor) {
			org.eclipse.swt.widgets.Text text = (org.eclipse.swt.widgets.Text) celleditor.getControl();
			org.eclipse.draw2d.geometry.Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
			rect.x=getMultilineEditableFigure().getEditionLocation().x;
			rect.y=getMultilineEditableFigure().getEditionLocation().y;
			getMultilineEditableFigure().translateToAbsolute(rect);
			if (getMultilineEditableFigure().getText().length() > 0) {
				rect.setSize(new org.eclipse.draw2d.geometry.Dimension(text.computeSize(rect.width,
						org.eclipse.swt.SWT.DEFAULT)));
			}
			if (!rect.equals(new org.eclipse.draw2d.geometry.Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
			}
		}
	'''

}
