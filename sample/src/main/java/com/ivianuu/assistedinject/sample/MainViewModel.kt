/*
 * Copyright 2018 Manuel Wrage
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

package com.ivianuu.assistedinject.sample

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.ivianuu.assistedinject.Assisted
import com.ivianuu.assistedinject.AssistedInject

/**
 * @author Manuel Wrage (IVIanuu)
 */
class MainViewModel @AssistedInject constructor(
    @AppContext private val context: Context,
    @Assisted private val id: String,
    private val myDep1: MyDep1,
    private val myDep2: MyDep2,
    @Assisted private val useSomething: Boolean
) : ViewModel() {

    init {
        Log.d("MainViewModel", "id = $id, use something $useSomething")
    }

}