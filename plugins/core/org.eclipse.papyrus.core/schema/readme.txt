nestedEditor.exsd is an example of schema that should be provided by plugin using 
the multidiagrams extension mechanism.
Each multi-editor wanting to have auto plugable diagram should declare in its own plugin.xml the 
extension point referencing a copy of nestedEditor.exsd. This copy should be in the same plugin 
has the new multi-editor. 