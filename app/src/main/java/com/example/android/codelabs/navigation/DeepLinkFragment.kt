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

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Fragment used to show how to deep link to a destination
 */
class DeepLinkFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.deeplink_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.text)
        textView.text = requireArguments().getString("myarg")

        val notificationButton = view.findViewById<Button>(R.id.send_notification_button)
        notificationButton.setOnClickListener {
            val editArgs = view.findViewById<EditText>(R.id.args_edit_text)
            val args = Bundle()
            args.putString("myarg", editArgs.text.toString())

            val deeplink = findNavController().createDeepLink()
                    .setDestination(R.id.deeplink_dest)
                    .setArguments(args)
                    .createPendingIntent()

            val notificationManager =
                    requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(NotificationChannel(
                        "deeplink", "Deep Links", NotificationManager.IMPORTANCE_HIGH))
            }

            val builder = NotificationCompat.Builder(
                    requireContext(), "deeplink")
                    .setContentTitle("Navigation")
                    .setContentText("Deep link to Android")
                    .setSmallIcon(R.drawable.ic_android)
                    .setContentIntent(deeplink)
                    .setAutoCancel(true)
            notificationManager.notify(0, builder.build())
        }
    }
}
