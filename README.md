# spring-boot-plugins-example
An example of building a spring-boot application extendable with plugins.
## Plugins? Why not osgi?
This approach has some weak points:
  * There is not separation between the plugins, its just all on one classpath at runtime. So be careful if you import dependencies in a plugin - they my conflict with the ones from another plugin
  * You can only install plugins before you start the application, not at runtime
  * You can not remove or update plugins at runtime

But if you can live with this, it has some advantages too:
  * No osgi runtime needed  
  * One plugin can totally use the other. An extension of the database like the team plugin is not possible with osgi bundles AFAIK
  * Simply use spring in all parts of your application
  
## Description
This demo uses vaadin for the UI and spring-data-jpa with geodb and hibernate for persistence.
  
## Usage

1. Clone the reopsitory
2. Build the stuff ``mvn install``
3. Start the application: ``cd application/target`` and then: ``java -jar application-0.0.1-SNAPSHOT.jar``

Now the application starts just with the people plugin. To add the team plugin:

1. Stop the application
2. Create a folder called ``lib`` next to ``application-0.0.1-SNAPSHOT.jar`` and place ``plugin-team-0.0.1-SNAPSHOT.jar`` in it.
3. Start the application again

Now the application starts with both plugins.

## Layout
<dl>
<dt>plugin</dt>
  <dd>A pom with the dependencies need and common classes for all plugins. In this case just the MenuEntry stuff</dd>
  <dt>application</dt>
  <dd>This contains the spring-boot application</dd>
  <dt>plugin-*</dt>
  <dd>This modules contain the implementation of the modules.
</dl>
