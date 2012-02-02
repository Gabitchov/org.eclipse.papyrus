package org.eclipse.papyrus.uml.compare.ui.merge.viewer;

import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
//TODO set the correct super class
//duplicate code from tatiana
public class UMLModelContentMergeViewer extends ModelContentMergeViewer {

	//duplicate code from tatiana
	public UMLModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
	}

	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		// TODO Auto-generated method stub
//		return super.createModelContentMergeTabFolder(composite, side);
		return new UMLModelContentMergeTabFolder(this, composite, side);
	}
	
	@Override
	protected void copy(List<DiffElement> diffs, boolean leftToRight) {
		DiffElement diff = diffs.get(0);
		if(diff instanceof ModelElementChangeLeftTarget){
			EObject element = ((ModelElementChangeLeftTarget)diff).getLeftElement();
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
			int d=0;
			d++;
			
		}else if(diff instanceof UpdateReference){
			EObject element  = ((UpdateReference)diff).getLeftElement();
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
			int d=0;
			d++;
		}
		super.copy(diffs, leftToRight);
	}

}
