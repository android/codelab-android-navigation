/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup

/**
 * Fragment used to show how to navigate to another destination
 */
class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO STEP 5 - Set an OnClickListener, using Navigation.createNavigateOnClickListener()
//        view.findViewById<Button>(R.id.navigate_dest_bt)?.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.flow_step_one, null)
//        )
        //TODO ENDSTEP 5

        //TODO STEP 6 - Set NavOptions

//        val options = NavOptions.Builder()
//            .setEnterAnim(R.anim.slide_in_right)
//            .setExitAnim(R.anim.slide_out_left)
//            .setPopEnterAnim(R.anim.slide_in_left)
//            .setPopExitAnim(R.anim.slide_out_right)
//            .build()
//
//        view.findViewById<Button>(R.id.navigate_dest_bt)?.setOnClickListener {
//            findNavController(it).navigate(R.id.flow_step_one, null, options)
//        }
        //TODO ENDSTEP 6

        //TODO STEP 7 - Update the OnClickListener to navigate using an action
//        view.findViewById<Button>(R.id.navigate_action_bt)?.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.next_action, null)
//        )

        //TODO ENDSTEP 7
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main_menu, menu)
    }
}
