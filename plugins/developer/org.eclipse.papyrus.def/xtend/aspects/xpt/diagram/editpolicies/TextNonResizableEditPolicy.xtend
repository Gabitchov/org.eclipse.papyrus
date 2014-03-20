package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

/** 
 * FIXME: [MG] - reverse the calls? call common code from here and TextelectionEP and not vice versa 
*/
@Singleton class TextNonResizableEditPolicy extends xpt.diagram.editpolicies.TextNonResizableEditPolicy {
	
	@Inject extension Common;



	override def TextNonResizableEditPolicy_createSelectionHandles(GenDiagram it) '''
		«generatedMemberComment»
		protected java.util.List<?> createSelectionHandles() {
			org.eclipse.gef.handles.MoveHandle moveHandle =
				new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());
			moveHandle.setBorder(null);
			moveHandle.setDragTracker(new org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx(getHost()));
			return java.util.Collections.singletonList(moveHandle);
		}
	'''

}