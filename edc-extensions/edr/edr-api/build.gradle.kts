/********************************************************************************
 * Copyright (c) 2023 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

plugins {
    `java-library`
    `maven-publish`
    id("io.swagger.core.v3.swagger-gradle-plugin")
}

dependencies {
    implementation(project(":spi:callback-spi"))
    implementation(project(":spi:edr-spi"))
    implementation(project(":spi:core-spi"))

    implementation(libs.edc.api.management)
    implementation(libs.edc.core.validator)
    implementation(libs.jakarta.rsApi)

    testImplementation(testFixtures(libs.edc.core.jersey))
    testImplementation(libs.restAssured)
    testImplementation(libs.edc.junit)
    testImplementation(libs.edc.ext.jersey.providers)
    testImplementation(libs.edc.core.transform)
}
