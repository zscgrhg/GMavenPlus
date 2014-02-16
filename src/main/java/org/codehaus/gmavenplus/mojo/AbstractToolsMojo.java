/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.gmavenplus.mojo;

import org.codehaus.gmavenplus.model.Version;

import java.util.Properties;


/**
 * The base tools mojo, which all tool mojos extend.
 *
 * @author Keegan Witt
 */
public abstract class AbstractToolsMojo extends AbstractGroovyMojo {

    /**
     * The minimum version of Groovy that this mojo supports.
     */
    protected static final Version MIN_GROOVY_VERSION = new Version(1, 5, 0);

    /**
     * Properties to make available in scripts.  By default it will include
     * <dl>
     *   <dt>settings</dt>
     *     <dd>a org.apache.maven.settings.Settings object of the current Maven settings</dd>
     *   <dt>project</dt>
     *     <dd>a org.apache.maven.project.Project object of the current Maven project</dd>
     *   <dt>session</dt>
     *     <dd>a org.apache.maven.execution.MavenSession object of the current Maven session</dd>
     *   <dt>pluginArtifacts</dt>
     *     <dd>a list of org.apache.maven.artifact.Artifact objects of this plugin's artifacts</dd>
     *   <dt>localRepository</dt>
     *     <dd>a org.apache.maven.artifact.repository.ArtifactRepository object of Maven's local repository</dd>
     *   <dt>reactorProjects</dt>
     *     <dd>a list of org.apache.maven.project.MavenProject objects currently loaded by the reactor</dd>
     * </dl>
     * These can be overridden.
     *
     * @parameter
     */
    protected Properties properties = new Properties();

    /**
     * Determines whether this mojo can be run with the version of Groovy supplied.
     * Must be >= 1.5.0 because not all the classes needed were available and
     * functioning correctly in previous versions.
     *
     * @return <code>true</code> only if the version of Groovy supports this mojo.
     */
    protected boolean groovyVersionSupportsAction() {
        return getGroovyVersion() != null && getGroovyVersion().compareTo(MIN_GROOVY_VERSION) >= 0;
    }

}
