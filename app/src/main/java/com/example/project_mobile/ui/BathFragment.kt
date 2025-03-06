package com.example.yourapp.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.project_mobile.R
import java.util.*

class FragmentBath : Fragment() {

    private lateinit var spinnerLocation: Spinner
    private lateinit var spinnerBathroomSize: Spinner
    private lateinit var radioBookingNow: RadioButton
    private lateinit var radioBookingLater: RadioButton
    private lateinit var btnSelectDate: Button
    private lateinit var btnSelectTime: Button
    private lateinit var btnNext: Button
    private lateinit var tvCost: TextView

    private var selectedDate: String = ""
    private var selectedTime: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_bath, container, false)

        // เชื่อมโยง View
        spinnerLocation = view.findViewById(R.id.spinner_location)
        spinnerBathroomSize = view.findViewById(R.id.spinner_bathroom_size)
        radioBookingNow = view.findViewById(R.id.radio_booking_now)
        radioBookingLater = view.findViewById(R.id.radio_booking_later)
        btnSelectDate = view.findViewById(R.id.btn_select_date)
        btnSelectTime = view.findViewById(R.id.btn_select_time)
        btnNext = view.findViewById(R.id.btn_next)
        tvCost = view.findViewById(R.id.tv_cost)

        // ตั้งค่าปฏิทินเลือกวัน
        btnSelectDate.setOnClickListener { showDatePicker() }
        btnSelectTime.setOnClickListener { showTimePicker() }

        // ปุ่มกด Next
        btnNext.setOnClickListener {
            Toast.makeText(requireContext(), "Booking confirmed!", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    // ฟังก์ชันเลือกวันที่
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(requireContext(), { _, y, m, d ->
            selectedDate = "$d/${m + 1}/$y"
            btnSelectDate.text = selectedDate
        }, year, month, day)

        datePicker.show()
    }

    // ฟังก์ชันเลือกเวลา
    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePicker = TimePickerDialog(requireContext(), { _, h, m ->
            selectedTime = String.format("%02d:%02d", h, m)
            btnSelectTime.text = selectedTime
        }, hour, minute, true)

        timePicker.show()
    }
}
