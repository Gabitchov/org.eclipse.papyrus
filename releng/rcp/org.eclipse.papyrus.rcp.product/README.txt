One of the things you need to check are the icon paths in your .product file. 
There are unfortunately three possible ways of interpreting this path:

  1) Eclipse's product editor interprets these as project-relative paths (e.g., 
     treating them as if they were prefixed with "platform:/plugin").  

  2) PDE/Build interprets the paths relative to the workspace root (e.g., 
     treating them as if they were prefixed with "platform:/base").

  3) Tycho interprets them as paths in the local workspace, relative to its
     current build location set by the active mojo.  The tycho-p2-publisher-plugin, 
     which is responsible for publishing the product definition to a p2 repository, 
     uses "${project.build.directory}/products/${product-id}" as its current build location.

So you need to ensure your path names are relative to #3.  Note that the paths specified using the Eclipse
product editor have a leading "/", which causes tycho-p2-publisher-plugin to attempt resolve
the icons relative to the root directory. 

Check https://bugs.eclipse.org/bugs/show_bug.cgi?id=349421 for more details. 