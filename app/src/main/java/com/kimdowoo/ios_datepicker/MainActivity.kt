package com.kimdowoo.ios_datepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kimdowoo.datepicker.componenet.SpinnerDatePicker
import com.kimdowoo.ios_datepicker.ui.theme.IOS_DatePickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {


                Text(text = "DarkMode")
                SpinnerDatePicker(darkModeEnabled = true)
                SpinnerDatePicker(darkModeEnabled = false)
//                Text(text = "isTransformationEnabled")
//                SpinnerDatePicker(isTransformationEnabled = true)
//                SpinnerDatePicker(isTransformationEnabled = false)
//
//                Text(text = "selectViewEnable")
//                SpinnerDatePicker(selectViewEnable = true)
//                SpinnerDatePicker(selectViewEnable = false)
            }
        }
    }
}