/**
 * Copyright 2017 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package moaible.sample.presentation.screen.main

import android.os.Bundle
import android.util.Log
import moaible.sample.R
import moaible.sample.presentation.base.BaseActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sample", "MainActivity.onCreate")
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // NOTE:
            // onCreateでsavedInstanceStateを見ずにfragmentをaddすると
            //
            // https://qiita.com/kirimin/items/59fcb626ee5a315a3684
            supportFragmentManager.beginTransaction()
                    .add(R.id.content, MainFragment.newInstance("initial"))
                    .addToBackStack("test")
                    .commit()
        }
    }
}
