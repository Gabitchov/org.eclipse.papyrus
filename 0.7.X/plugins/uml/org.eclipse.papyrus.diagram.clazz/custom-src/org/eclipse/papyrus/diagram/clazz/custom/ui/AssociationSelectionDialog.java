package org.eclipse.papyrus.diagram.clazz.custom.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.ui.dialogs.ElementChooseDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ParameterableElement;


public class AssociationSelectionDialog extends AbstractAssociationSelectionDialog {

	protected Classifier source, target;
	public AssociationSelectionDialog(Shell parent, int style, Classifier source, Classifier target) {
		super(parent, style);
		this.source=source;
		this.target=target;
		// TODO Auto-generated constructor stub
	}
	protected void createContents() {
		// TODO Auto-generated method stub
		super.createContents();
		final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		final IStructuredContentProvider  associationContentProvider=new IStructuredContentProvider() {
			
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub
				
			}
			
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			public Object[] getElements(Object inputElement) {
				HashSet<Association> assos= new HashSet<Association>();
				assos.addAll(source.getAssociations());
				assos.retainAll(target.getAssociations());
				return assos.toArray();
			}
		};
		TableViewer tableViewer= new TableViewer(table);
		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setContentProvider(associationContentProvider);
		tableViewer.setInput(null);
		btnOk.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {

			}

			public void mouseDown(MouseEvent e) {}
			public void mouseDoubleClick(MouseEvent e) {}
		});
		btnCancel.addMouseListener(new MouseListener() {


			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {}
			public void mouseDoubleClick(MouseEvent e) {}
		});
		
	}

}
