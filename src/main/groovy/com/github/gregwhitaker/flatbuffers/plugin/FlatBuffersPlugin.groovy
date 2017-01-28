/*
 * Copyright 2017 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gregwhitaker.flatbuffers.plugin

import com.github.gregwhitaker.flatbuffers.plugin.tasks.BuildFlatBuffers
import com.github.gregwhitaker.flatbuffers.plugin.tasks.CleanFlatBuffers
import org.gradle.api.Plugin
import org.gradle.api.Project

class FlatBuffersPlugin implements Plugin<Project> {

    private static final String GROUP = 'flatbuffers'

    @Override
    void apply(Project project) {
        project.extensions.create('flatbuffers', FlatBuffersPluginExtension.class)
        applyTasks(project)
    }

    void applyTasks(final Project project) {
        project.task('buildFlatBuffers', type: BuildFlatBuffers) {
            group = GROUP
            description = 'Generates flatbuffers files from schemas.'
        }

        project.task('cleanFlatBuffers', type: CleanFlatBuffers) {
            group = GROUP
            description = 'Cleans the output directory of generated flatbuffers files.'
        }
    }

}
