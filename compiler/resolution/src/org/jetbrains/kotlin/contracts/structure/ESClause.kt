/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package org.jetbrains.kotlin.contracts.structure

/**
 * Effect with possibly condition attached to it.
 *
 * If [condition] is null, then the semantic of clause is: "[effect] was fired"
 *
 * Otherwise, [condition] is some expression, which result-type is Boolean, and
 * clause should be interpreted as: "if [effect] took place then [condition]-expression
 * is guaranteed to be true"
 *
 * NB. [effect] and [condition] connected with implication in math logic sense:
 * [effect] => [condition]. In particular this means that:
 *  - there can be multiple ways how [effect] can be produced, but for any of them
 *    [condition] holds.
 *  - if [effect] wasn't observed, we *can't* reason that [condition] is false
 *  - if [condition] is true, we *can't* reason that [effect] will be observed.
 */
class ESClause(val condition: ESBooleanExpression, val effect: ESEffect) {
    fun replaceEffect(newEffect: ESEffect) = ESClause(condition, newEffect)
}
