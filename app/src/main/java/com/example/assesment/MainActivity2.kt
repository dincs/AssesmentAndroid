package com.example.assesment

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment.FlightScheduleAdapter.FlightClickInterface
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL


class MainActivity2 : AppCompatActivity(), FlightClickInterface{

    private var flightScheduleAdapter: FlightScheduleAdapter? = null
    private var arrayList = ArrayList<Flight>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val flightrecycler = findViewById<RecyclerView>(R.id.flightschedule)
        flightrecycler.layoutManager = LinearLayoutManager(this)
        flightrecycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        flightScheduleAdapter = FlightScheduleAdapter(Flight.itemCallback, this)
        flightrecycler.adapter = flightScheduleAdapter
        loadData()

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        callRequest()
    }
    override fun onClick(position: Int) {

    }

    private fun callRequest(){
        val apiUrl = "http://192.168.100.33:8000/api/search"
//        val apiUrl = "https://api.waktusolat.app/v2/solat/JHR01"

        try {
            val url : URL = URI.create(apiUrl).toURL()
            val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET"

            // Add Bearer token to the request header
            val bearerToken = "2|craN1mK91b4QVeYVBgrWljVh2BgzNESBrTXJM1qq13b36db1"
            connection.setRequestProperty("Authorization", "Bearer $bearerToken")

            val responseCode: Int = connection.responseCode
            println("Response Code: $responseCode")

            if(responseCode == HttpURLConnection.HTTP_OK){
                val reader : BufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                var line: String?
                val response = StringBuilder()
                while(reader.readLine().also { line = it } != null){
                    response.append(line)
                }

                reader.close()
                println("Response Data: $response")
            }else{
                println("Error: Unable to fetch data from API" + HttpURLConnection.HTTP_FORBIDDEN)
            }

            connection.disconnect()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun loadData(){
        for (i in 0..9) {
            val flight = Flight()
            flight.locationd = "K.Lumpur"
            flight.tripd = "KLIA"
            flight.dated = "10:00 am"
            flight.locationa = "China"
            flight.tripa = "CH"
            flight.datea = "14:00pm"
            arrayList.add(flight)
        }

        flightScheduleAdapter?.submitList(arrayList)
    }
}